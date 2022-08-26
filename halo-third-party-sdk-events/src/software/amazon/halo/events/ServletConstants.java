/*
    Copyright 2021 Amazon.com, Inc. or its affiliates. All Rights Reserved.

    Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
    except in compliance with the License. A copy of the License is located at

        http://aws.amazon.com/apache2.0/

    or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
    the specific language governing permissions and limitations under the License.
 */

package software.amazon.halo.events;

/**
 * Helper class to hold package's constant values.
 */
public final class ServletConstants {

    /**
     * Prevent instantiation.
     */
    private ServletConstants() { }

    /**
     * The algorithm used to generate the signature.
     */
    public static final String SIGNATURE_ALGORITHM = "RSASSA-PSS";

    /**
     * Certificate algorithm used to generate the signature.
     */
    public static final String CERT_SIGNATURE_ALGORITHM = "SHA256withRSA";

    /**
     * signature salt size
     */
    public static final int SALT_SIZE = 32;

    /**
     * signature trailer field
     */
    public static final int TRAILER_FIELD = 1;

    /**
     * signature hash algorithm
     */
    public static final String HASH_ALGORITHM = "SHA-256";

    /**
     * signature mask gen algorithm
     */
    public static final String MASK_GEN_ALGORITHM = "MGF1";

    /**
     * The character encoding used.
     */
    public static final String CHARACTER_ENCODING = "UTF-8";

    /**
     * The format of the certificate needed to verify the request signature.
     */
    public static final String SIGNATURE_CERTIFICATE_TYPE = "X.509";

    /**
     * The type of encryption key used to generate the signature.
     */
    public static final String SIGNATURE_TYPE = "RSA";

    /**
     * The domain name used by the Halo Third Party API.
     */
    public static final String[] HALO_API_DOMAIN_NAMES = {
            "na-alpha.events.partners.healthtech.a2z.com",
            "na-beta.events.partners.healthtech.a2z.com",
            "na.events.partners.healthtech.a2z.com",
            "na.events.partners.amazonhealthtech.com"
    };
    /**
     * The name of the request header that contains the signature.
     */
    public static final String SIGNATURE_REQUEST_HEADER = "Signature";

    /**
     * The name of the request header that contains the URL for the certificate chain needed to
     * verify the request signature.
     */
    public static final String SIGNATURE_CERTIFICATE_CHAIN_URL_REQUEST_HEADER =
            "SignatureCertChainUrl";

    /**
     * Maximum allowed timestamp offset tolerance value in millis.
     */
    public static final long MAXIMUM_TOLERANCE_MILLIS = 150000;

}
