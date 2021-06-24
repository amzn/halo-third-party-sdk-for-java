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

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doThrow;
import static org.powermock.api.mockito.PowerMockito.mock;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.junit.Test;
import java.time.Instant;

@RunWith(PowerMockRunner.class)
@PrepareForTest({HaloEventSignatureVerifier.class,HaloEventTimestampVerifier.class})
public class HaloEventVerificationHandlerTest {

    @Test
    public void verifyRequest_no_exception() {
        HaloEventSignatureVerifier mockSignatureVerifier = mock(HaloEventSignatureVerifier.class);
        doNothing().when(mockSignatureVerifier).verify(any(HaloHttpRequest.class));
        HaloEventTimestampVerifier mockTimestampVerifier = mock(HaloEventTimestampVerifier.class);
        doNothing().when(mockTimestampVerifier).verify(any(HaloHttpRequest.class));

        HaloHttpRequest request = new ServletRequest(
                "mockSignature", "mockCertChainUrl",
                "".getBytes(),
                RequestEnvelope.builder().withTimestamp(Instant.now().toString()).build()
        );
        HaloEventVerificationHandler verificationHandler = new HaloEventVerificationHandler(
                mockSignatureVerifier, mockTimestampVerifier);
        verificationHandler.verifyRequest(request);
    }

    @Test(expected = SecurityException.class)
    public void verifyRequest_raise_exception() {
        HaloEventSignatureVerifier mockSignatureVerifier = mock(HaloEventSignatureVerifier.class);
        doThrow(new SecurityException()).when(mockSignatureVerifier).verify(any(HaloHttpRequest.class));
        HaloEventTimestampVerifier mockTimestampVerifier = mock(HaloEventTimestampVerifier.class);
        doNothing().when(mockTimestampVerifier).verify(any(HaloHttpRequest.class));

        HaloHttpRequest request = new ServletRequest(
                "mockSignature", "mockCertChainUrl",
                "".getBytes(),
                RequestEnvelope.builder().withTimestamp(Instant.now().toString()).build()
        );
        HaloEventVerificationHandler verificationHandler = new HaloEventVerificationHandler(
                mockSignatureVerifier, mockTimestampVerifier);
        verificationHandler.verifyRequest(request);
    }
}
