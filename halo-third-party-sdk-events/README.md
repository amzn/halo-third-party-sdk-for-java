Halo Third Party SDK Events package is an extension package that will let developers verify the authenticity of events.

## What is Halo Third Party SDK for Java

The Halo Third Party SDK for Java makes it easier for you to verify events and allows you to spend more time on implementing features and less on writing boiler-plate code.

Quick Start
-----------

### Installation

The Halo Third Party SDK for Java has been uploaded to Maven central, and you can add the SDK to your project dependencies.

For example, if you are using Maven as your build system:
 
    <dependency>
      <groupId>software.amazon.halo</groupId>
      <artifactId>halo-third-party-events-sdk</artifactId>
      <version>1.0.0</version>
    </dependency>

    <dependency>
      <groupId>software.amazon.halo</groupId>
      <artifactId>halo-third-party-sdk-model</artifactId>
      <version>1.0.0</version>
    </dependency>

Usage and Getting Started
-------------------------

1. Import the necessary classes.
   ```
    import software.amazon.halo.events.verifiers.HaloEventVerificationHandler;
    import software.amazon.halo.events.verifiers.HaloEventSignatureVerifier;
    import software.amazon.halo.events.verifiers.HaloEventTimestampVerifier;
    import software.amazon.halo.events.verifiers.ServletRequest;
   ```

2. Create a servlet request object.
    
   ```
    ServletRequest request = new ServletRequest(
      input.getSignatureSha256(),
      input.getSignatureCertChainUrl(),
      input.getMessage().array(),
      requestEnvelope
    );
   ```

3. Create handler object with required verifiers, here we used time and signature verifier.
    
   ```
    HaloEventVerificationHandler verificationHandler = new HaloEventVerificationHandler(signatureVerifier, timestampVerifier);
   ```

4. Call verify request method with request object. 
    
   ```
    verificationHandler.verifyRequest(request);
   ```

## Opening Issues
For bug reports, feature requests and questions, we would like to hear about it. Search the [existing issues](https://github.com/amzn/halo-third-party-sdk-for-java/issues) and try to make sure your problem doesn’t already exist before opening a new issue. It’s helpful if you include the version of the SDK, Java and OS you’re using. Please include a stack trace and reduced repro case when appropriate, too.

## License
This SDK is distributed under the Apache License, Version 2.0, see LICENSE for more information.
