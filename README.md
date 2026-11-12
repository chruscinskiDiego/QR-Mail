# QR Mail

Java project for generating QR codes from links and sending them by email.

## Features

- Accepts a link and recipient details.
- Generates an image with ZXing.
- Sends email through SMTP with JavaMail.
- Includes tests related to QR generation and email delivery.

## Technologies

Java 18, ZXing, JavaMail, Java Activation and JUnit.

## Prepare the environment

pom.xml does not declare all runtime dependencies. The repository includes JavaMail, Activation and ZXing JARs; add these libraries to the IDE classpath before running application.Program.

Review src/main/java/mail/Data.java and src/main/java/mail/Shipping.java. Use a dedicated development account and the SMTP settings required by your provider. Keep real passwords out of commits.

## Structure

- `qrcode/`: image generation.
- `mail/`: configuration and delivery.
- `exception/`: email validation.
- `src/test/java/`: test scenarios.

## Scope

A learning project. Delivery depends on provider configuration and policies. A delivery test alone does not guarantee successful email delivery or establish an isolated integration test suite.
