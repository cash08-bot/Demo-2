package com.myorg;

import io.github.cdklabs.cdknag.NIST80053R4Checks;
import software.amazon.awscdk.App;
import software.amazon.awscdk.Aspects;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;
import java.util.Arrays;

public class CdktestApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdktestStack(app, "CdktestStack", StackProps.builder()
                // If you don't specify 'env', this stack will be environment-agnostic.
                // Account/Region-dependent features and context lookups will not work,
                // but a single synthesized template can be deployed anywhere.

                // Uncomment the next block to specialize this stack for the AWS Account
                // and Region that are implied by the current CLI configuration.
                /*
                .env(Environment.builder()
                        .account(System.getenv("CDK_DEFAULT_ACCOUNT"))
                        .region(System.getenv("CDK_DEFAULT_REGION"))
                        .build())
                */

                // Uncomment the next block if you know exactly what Account and Region you
                // want to deploy the stack to.
                
 .env(Environment.builder()
                        .account("123456789012")
                        .region("us-east-1")
                        .build())


                .build());
        Aspects.of(app)
                .add(
                       NIST80053R4Checks.Builder
                                .create()
                                .verbose(true)
                                .build()
                );
        app.synth();
    }
}

