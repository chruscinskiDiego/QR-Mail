# QR Mail

Projeto em Java para gerar QR Codes a partir de links e enviá-los por e-mail.

## Funcionalidades

- Entrada de link e dados do destinatário.
- Geração de imagem com ZXing.
- Envio por SMTP com JavaMail.
- Testes relacionados à geração e ao envio.

## Tecnologias

Java 18, ZXing, JavaMail, Java Activation e JUnit.

## Preparar o ambiente

O pom.xml não declara todas as dependências de execução. O repositório inclui JARs de JavaMail, Activation e ZXing; adicione essas bibliotecas ao classpath pela IDE antes de executar application.Program.

Revise os parâmetros em src/main/java/mail/Data.java e src/main/java/mail/Shipping.java. Use uma conta própria de desenvolvimento e os parâmetros exigidos pelo seu provedor SMTP. Não inclua senhas reais em commits.

## Organização

- `qrcode/`: geração da imagem.
- `mail/`: configuração e envio.
- `exception/`: validação de e-mail.
- `src/test/java/`: cenários de teste.

## Escopo

Projeto de estudo. O envio depende da configuração e das políticas do provedor de e-mail; não há garantia de entrega ou suíte de integração isolada apenas por existir um teste de envio.
