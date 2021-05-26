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

/**
 * Servlet specific implementation of {@link HaloHttpRequest}.
 */
public class ServletRequest implements HaloHttpRequest {

    /**
     * Serialized request envelope.
     */
    private final byte[] serializedRequestEnvelope;

    /**
     * De-serialized request envelope.
     */
    private final RequestEnvelope deserializedRequestEnvelope;

    /**
     * Base64 encoded signature.
     */
    private final String baseEncoded64Signature;

    /**
     * Certificate chain URL.
     */
    private final String signingCertificateChainUrl;

    /**
     * Constructor to build an instance of ServletRequest.
     * @param signature signature for the request.
     * @param certChainUrl certificate chain url.
     * @param serializedRequestEnvelope serialized request envelope.
     * @param deserializedRequestEnvelope de-serialized request envelope.
     */
    public ServletRequest(
        final String signature,
        final String certChainUrl,
        final byte[] serializedRequestEnvelope,
        final RequestEnvelope deserializedRequestEnvelope
    ) {
        this.serializedRequestEnvelope = serializedRequestEnvelope;
        this.deserializedRequestEnvelope = deserializedRequestEnvelope;
        this.baseEncoded64Signature = signature;
        this.signingCertificateChainUrl = certChainUrl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public String getBaseEncoded64Signature() {
        return baseEncoded64Signature;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public String getSigningCertificateChainUrl() {
        return signingCertificateChainUrl;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public byte[] getSerializedRequestEnvelope() {
        return serializedRequestEnvelope;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    final public RequestEnvelope getDeserializedRequestEnvelope() {
        return deserializedRequestEnvelope;
    }
}
