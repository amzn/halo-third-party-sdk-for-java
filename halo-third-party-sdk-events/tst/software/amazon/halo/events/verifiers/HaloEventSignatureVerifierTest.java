/*
    Copyright 2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
    except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
    the specific language governing permissions and limitations under the License.
 */

package software.amazon.halo.events.verifiers;

import static software.amazon.halo.events.verifiers.HaloEventSignatureVerifier.getAndVerifySigningCertificateChainUrl;
import static software.amazon.halo.events.verifiers.HaloEventSignatureVerifier.subjectAlernativeNameListContainsHaloSdkDomainName;
import static java.security.Security.addProvider;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

import javax.security.auth.x500.X500Principal;
import javax.servlet.http.HttpServletRequest;

import software.amazon.halo.model.RequestEnvelope;
import software.amazon.halo.events.ServletConstants;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore("javax.security.auth.x500.X500Principal")
@PrepareForTest(HaloEventSignatureVerifier.class)
public class HaloEventSignatureVerifierTest {

    private static final String PREPOPULATED_CERT_URL =
            "https://s3.amazonaws.com/healthtech.api/doesnotexist";
    private static final String VALID_URL = "https://s3.amazonaws.com/healthtech.api/cert";
    private static final String VALID_URLS[] = {
            VALID_URL,
            "https://s3.amazonaws.com/healthtech.api-alpha/cert",
            "https://s3.amazonaws.com/healthtech.api-beta/cert"
    };
    private static final String VALID_URL_WITH_PORT = "https://s3.amazonaws.com:443/healthtech.api/cert";
    private static final String VALID_URL_WITH_PATH_TRAVERSAL =
            "https://s3.amazonaws.com/healthtech.api/../healthtech.api/cert";
    private static final String INVALID_URL_WITH_INVALID_HOST_NAME =
            "https://very.bad/healthtech.api/cert";
    private static final String INVALID_URL_WITH_UNSUPPORTED_PROTOCOL =
            "http://s3.amazonaws.com/healthtech.api/cert";
    private static final String INVALID_URL_WITH_INVALID_PORT =
            "https://s3.amazonaws.com:563/healthtech.api/cert";
    private static final String INVALID_URL_WITH_INVALID_PATH = "https://s3.amazonaws.com/cert";
    private static final String INVALID_URL_WITH_INVALID_PATH_TRAVERSAL =
            "https://s3.amazonaws.com/healthtech.api/../cert";
    private static final String INVALID_URL_WITH_INVALID_UPPER_CASE_PATH =
            "https://s3.amazonaws.com/HEALTHTECH.API/cert";
    private static final String MALFORMED_URL = "badUrl";

    private static PrivateKey validPrivateKey = null;
    private static RequestEnvelope deserializedRequestEnvelope;
    private static HaloEventSignatureVerifier verifier;
    private HttpServletRequest mockServletRequest;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    @SuppressWarnings("deprecation")
    public static void initializeCertMap() throws Exception {
        X509Certificate cert = generateCert(ServletConstants.HALO_API_DOMAIN_NAMES[0]);

        ConcurrentHashMap<String, X509Certificate> certCache = new ConcurrentHashMap<>();
        certCache.put(PREPOPULATED_CERT_URL, cert);
        whenNew(ConcurrentHashMap.class).withAnyArguments().thenReturn(certCache);
        verifier = new HaloEventSignatureVerifier();
        deserializedRequestEnvelope = RequestEnvelope.builder().build();
    }

    @SuppressWarnings("deprecation")
    public static X509Certificate generateCert(String domain) throws Exception {
        addProvider(new BouncyCastleProvider());
        KeyPair keyPair = generateKeyPair();
        validPrivateKey = keyPair.getPrivate();

        GeneralName altName = new GeneralName(GeneralName.dNSName, domain);
        GeneralNames subjectAltName = new GeneralNames(altName);

        X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
        certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
        X500Principal self = new X500Principal("CN=Test Certificate");
        certGen.setIssuerDN(self);
        certGen.setSubjectDN(self);
        certGen.setNotBefore(new Date(System.currentTimeMillis() - 60000));
        certGen.setNotAfter(new Date(System.currentTimeMillis() + 60000));
        certGen.setPublicKey(keyPair.getPublic());
        certGen.setSignatureAlgorithm(ServletConstants.CERT_SIGNATURE_ALGORITHM);
        certGen.addExtension(X509Extensions.SubjectAlternativeName, false, subjectAltName);
        // BC means the Bouncy Castle security provider.
        return certGen.generate(validPrivateKey, "BC");
    }

    @Before
    public void setUp() {
        mockServletRequest = mock(HttpServletRequest.class);
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_validUrlValue_urlReturned() throws Exception {
        for (String url : VALID_URLS) {
            assertEquals(url, getAndVerifySigningCertificateChainUrl(url).toExternalForm());
        }
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_validUrlWithPort_noExceptionThrown()
            throws Exception {
        assertEquals(VALID_URL_WITH_PORT,
                getAndVerifySigningCertificateChainUrl(VALID_URL_WITH_PORT).toExternalForm());
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_validUrlWithPathTraversal_noExceptionThrown()
            throws Exception {
        assertEquals(VALID_URL,
                getAndVerifySigningCertificateChainUrl(VALID_URL_WITH_PATH_TRAVERSAL)
                        .toExternalForm());
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_invalidHostnameInUrl_certificateExceptionThrown()
            throws Exception {
        thrown.expect(CertificateException.class);
        thrown.expectMessage("does not contain the required hostname");

        getAndVerifySigningCertificateChainUrl(INVALID_URL_WITH_INVALID_HOST_NAME);
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_unsupportedProtocolInUrl_certificateExceptionThrown()
            throws Exception {
        thrown.expect(CertificateException.class);
        thrown.expectMessage("contains an unsupported protocol");

        getAndVerifySigningCertificateChainUrl(INVALID_URL_WITH_UNSUPPORTED_PROTOCOL);
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_invalidPortInUrl_certificateExceptionThrown()
            throws Exception {
        thrown.expect(CertificateException.class);
        thrown.expectMessage("contains an invalid port");

        getAndVerifySigningCertificateChainUrl(INVALID_URL_WITH_INVALID_PORT);
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_malformedUrl_certificateExceptionThrown()
            throws Exception {
        thrown.expect(CertificateException.class);
        thrown.expectCause(isA(IllegalArgumentException.class));
        thrown.expectMessage("is malformed");

        getAndVerifySigningCertificateChainUrl(MALFORMED_URL);
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_invalidPath_certificateExceptionThrown()
            throws Exception {
        thrown.expect(CertificateException.class);
        thrown.expectMessage("Expecting path to start with");

        getAndVerifySigningCertificateChainUrl(INVALID_URL_WITH_INVALID_PATH);
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_invalidPathTraversal_certificateExceptionThrown()
            throws Exception {
        thrown.expect(CertificateException.class);
        thrown.expectMessage("Expecting path to start with");

        getAndVerifySigningCertificateChainUrl(INVALID_URL_WITH_INVALID_PATH_TRAVERSAL);
    }

    @Test
    public void getAndVerifySigningCertificateChainUrl_invalidUpperCasePath_certificateExceptionThrown()
            throws Exception {
        thrown.expect(CertificateException.class);
        thrown.expectMessage("Expecting path to start with");

        getAndVerifySigningCertificateChainUrl(INVALID_URL_WITH_INVALID_UPPER_CASE_PATH);
    }

    @Test
    public void checkRequestSignature_validSignatureValidPrivateKey_noSecurityExceptionThrown()
            throws Exception {
        String testContent = "This is some test content.";
        byte[] signature = signContent(testContent, validPrivateKey);
        verifier.verify(new ServletRequest(new Base64().encodeAsString(signature), PREPOPULATED_CERT_URL, testContent.getBytes(), deserializedRequestEnvelope));
    }

    @Test
    public void checkRequestSignature_validSignatureInvalidPrivateKey_securityExceptionThrown()
            throws Exception {
        thrown.expect(SecurityException.class);
        thrown
                .expectMessage("Failed to verify the signature/certificate for the provided event");

        String testContent = "This is some test content.";
        byte[] signature = signContent(testContent, generateKeyPair().getPrivate());
        verifier.verify(new ServletRequest(new Base64().encodeAsString(signature), PREPOPULATED_CERT_URL, testContent.getBytes(), deserializedRequestEnvelope));
    }

    @Test
    public void subjectAlernativeNameListContainsHaloSdkDomainName_validDomain() throws Exception {
        for (String domain : ServletConstants.HALO_API_DOMAIN_NAMES) {
            X509Certificate cert = generateCert(domain);
            assertEquals(true, subjectAlernativeNameListContainsHaloSdkDomainName(cert.getSubjectAlternativeNames()));
        }
    }

    @Test
    public void subjectAlernativeNameListContainsHaloSdkDomainName_invalidDomain() throws Exception {
        X509Certificate cert = generateCert("asdf");
        assertEquals(false, subjectAlernativeNameListContainsHaloSdkDomainName(cert.getSubjectAlternativeNames()));
    }

    private static KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ServletConstants.SIGNATURE_TYPE);
        keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }

    private static byte[] signContent(String content, PrivateKey key) throws Exception {
        Signature signature = Signature.getInstance(ServletConstants.SIGNATURE_ALGORITHM);
        PSSParameterSpec pssSpec = new PSSParameterSpec(
            ServletConstants.HASH_ALGORITHM,
            ServletConstants.MASK_GEN_ALGORITHM,
            MGF1ParameterSpec.SHA256,
            ServletConstants.SALT_SIZE,
            ServletConstants.TRAILER_FIELD);
        signature.setParameter(pssSpec);
        signature.initSign(key);
        signature.update(content.getBytes());
        return signature.sign();
    }
}