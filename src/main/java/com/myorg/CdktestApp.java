package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;
import software.constructs.Construct;
import software.amazon.awscdk.Aspects;

// 🔒 Import CDK Nag
import io.cdk.nag.packs.NIST80053R5Checks;

public class CdktestApp {
    public static void main(final String[] args) {
        App app = new App();

        // Create the stack
        new CdktestStack(app, "CdktestStack", StackProps.builder()
            .env(Environment.builder()
                .account("123456789012")
                .region("us-east-1")
                .build())
            .build());

        // ✅ Apply NIST 800-53 Rev 5 compliance checks
        Aspects.of(app).add(new NIST80053R5Checks());

        app.synth();
    }
}
