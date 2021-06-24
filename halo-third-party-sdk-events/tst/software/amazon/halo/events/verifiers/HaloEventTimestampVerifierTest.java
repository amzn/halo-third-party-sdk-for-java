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

import software.amazon.halo.model.RequestEnvelope;
import software.amazon.halo.model.Data;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import software.amazon.halo.events.ServletConstants;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class HaloEventTimestampVerifierTest {

    private HaloEventTimestampVerifier verifier;

    private static final long TOLERANCE_IN_MILLIS = 2000;

    private static byte[] serializedRequestEnvelope;

    public HaloEventTimestampVerifierTest(HaloEventTimestampVerifier verifier) {
        this.verifier = verifier;
    }

    @Parameterized.Parameters
    public static Collection verifiers() {
        return Arrays.asList(new HaloEventTimestampVerifier(TOLERANCE_IN_MILLIS), new HaloEventTimestampVerifier(TOLERANCE_IN_MILLIS / 1000, TimeUnit.SECONDS));
    }

    @BeforeClass
    public static void setUp() {
        serializedRequestEnvelope = "".getBytes();
    }

    @Test (expected = IllegalArgumentException.class)
    public void construct_withNegativeTolerance_throwsIllegalArgumentException() {
        new HaloEventTimestampVerifier(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void construct_withToleranceBeyondMaximum_throwsIllegalArgumentException() {
        new HaloEventTimestampVerifier(ServletConstants.MAXIMUM_TOLERANCE_MILLIS + 1);
    }

    @Test
    public void verify_currentDate_no_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, getRequestEnvelope(Instant.now())));
    }

    @Test
    public void verify_recentOldDate_no_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, getRequestEnvelope(Instant.now().minusMillis(TOLERANCE_IN_MILLIS / 2))));
    }

    @Test
    public void verify_upcomingNewDate_no_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, getRequestEnvelope(Instant.now().plusMillis(TOLERANCE_IN_MILLIS / 2))));
    }

    @Test(expected = SecurityException.class)
    public void verify_tooOldDate_throws_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, getRequestEnvelope(Instant.now().minusMillis(TOLERANCE_IN_MILLIS * 2))));
    }

    @Test(expected = SecurityException.class)
    public void verify_tooNewDate_throws_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, getRequestEnvelope(Instant.now().plusMillis(TOLERANCE_IN_MILLIS * 2))));
    }

    @Test(expected = SecurityException.class)
    public void verify_nullDate_throws_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, getRequestEnvelope(null)));
    }

    @Test(expected = SecurityException.class)
    public void verify_nullRequestEnvelope_throws_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, null));
    }

    @Test(expected = SecurityException.class)
    public void verify_nullRequest_throws_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, RequestEnvelope.builder().build()));
    }

    @Test(expected = SecurityException.class)
    public void verify_nullTimestamp_throws_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, RequestEnvelope.builder().withData(Data.builder().build()).build()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void construct_withNullTimeUnit_throwsIllegalArgumentException() {
        new HaloEventTimestampVerifier(TOLERANCE_IN_MILLIS / 1000, null);
    }

    @Test(expected = SecurityException.class)
    public void verify_withGreaterRequestTimeDelta_throws_exception() {
        verifier.verify(new ServletRequest("mockSignature", "mockCertChainUrl", serializedRequestEnvelope, getRequestEnvelope(Instant.now().plusMillis(TOLERANCE_IN_MILLIS).plusMillis(200))));
    }

    private RequestEnvelope getRequestEnvelope(Instant timestamp) {
        return RequestEnvelope.builder().withTimestamp(timestamp != null ? timestamp.toString() : null).build();
    }

}
