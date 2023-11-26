package mail;

import com.sun.mail.smtp.SMTPAddressFailedException;
import exception.InvalidMailException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.*;
import java.util.Properties;

public class Shipping {

    public boolean sendMail(String host, String door, String user, String password, String recipient,
                            String subject, String body, String attachment, boolean useAuthentication) throws InvalidMailException {
        // Configurações

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", door);
        props.put("mail.smtp.auth", useAuthentication);

        // Criação de uma sessão com autenticação
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Criação de uma mensagem de e-mail
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);

            // Criação do corpo da mensagem
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(body);

            // Criação da parte do anexo
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Anexo
            MimeBodyPart attachment1 = new MimeBodyPart();
            attachment1.attachFile(attachment);
            multipart.addBodyPart(attachment1);


            // Corpo
            message.setContent(multipart);

            // Envio da mensagem
            Transport.send(message);



            return true;

        } catch (SMTPAddressFailedException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "ERRO: "+ e.getMessage());
            //throw new InvalidMailException("ERRO: " + e.getMessage());
            return false;
        } catch (MessagingException e) {
            if (e instanceof SMTPAddressFailedException) {
                SMTPAddressFailedException smtpException = (SMTPAddressFailedException) e;
                JOptionPane.showMessageDialog(null,
                        "ERRO: "+ smtpException.getMessage());
                return false;
                //throw new InvalidMailException("ERRO: " + smtpException.getMessage());
            } else if ((e instanceof SendFailedException)) {

                SendFailedException sendFailedException = (SendFailedException) e;
                JOptionPane.showMessageDialog(null,
                        "ERRO: "+ sendFailedException.getMessage());
                return false;
                //throw new InvalidMailException("Endereço de e-mail inválido: " + sendFailedException.getMessage());
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,
                        "ERRO: "+ e.getMessage());
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "ERRO: "+e.getMessage());
            return false;
        }

    }
}