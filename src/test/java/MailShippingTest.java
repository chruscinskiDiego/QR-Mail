import exception.InvalidMailException;
import mail.Shipping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MailShippingTest {

    private Shipping shipping;

    @BeforeEach
    public void setUp() {
        shipping = new Shipping();
    }


    @Test
    public void testSendMail_Successful() throws InvalidMailException {

        String host = "smtp.gmail.com";
        String door = "587";
        String user = "contatodiegochruscinski@gmail.com";
        String password = "yxyukdopapmuqilv";
        Boolean auth = true;
        String body = "Obrigado por fazer parte do teste deste software! :')";
        String qrFile = "qrcode.png";
        String recipient = "contato@diegochruscinski.com.br";
        String subject = "Test";

        assertTrue(shipping.sendMail(host,door, user, password,
                recipient, subject, body, qrFile, auth));
    }

    @Test
    public void testSendMail_NoAuthentication() throws InvalidMailException {

        String host = "smtp.gmail.com";
        String door = "587";
        String user = "contatodiegochruscinski@gmail.com";
        String password = "yxyukdopapmuqilv";
        Boolean auth = false;
        String body = "Obrigado por fazer parte do teste deste software! :')";
        String qrFile = "qrcode.png";
        String recipient = "contato@diegochruscinski.com.br";
        String subject = "Test";

        assertFalse(shipping.sendMail(host,door, user, password,
                recipient, subject, body, qrFile, auth));
    }

    @Test
    public void testSendMail_NoAttachment() throws InvalidMailException {

        String host = "smtp.gmail.com";
        String door = "587";
        String user = "contatodiegochruscinski@gmail.com";
        String password = "yxyukdopapmuqilv";
        Boolean auth = false;
        String body = "Obrigado por fazer parte do teste deste software! :')";
        String qrFile = "qrcode.png";
        String recipient = "contato@diegochruscinski.com.br";
        String subject = "Test";

        assertFalse(shipping.sendMail(host,door, user, password,
                recipient, subject, body, null, auth));
    }

    @Test
    public void testSendMail_EmptyRecipient() throws InvalidMailException {

        String host = "smtp.gmail.com";
        String door = "587";
        String user = "contatodiegochruscinski@gmail.com";
        String password = "yxyukdopapmuqilv";
        Boolean auth = false;
        String body = "Obrigado por fazer parte do teste deste software! :')";
        String qrFile = "qrcode.png";
        String recipient = "";
        String subject = "Test";

        assertFalse(shipping.sendMail(host,door, user, password,
                recipient, subject, body, qrFile, auth));
    }

    @Test
    public void testSendMail_InvalidRecipient() throws InvalidMailException {

        String host = "smtp.gmail.com";
        String door = "587";
        String user = "contatodiegochruscinski@gmail.com";
        String password = "yxyukdopapmuqilv";
        Boolean auth = true;
        String body = "Obrigado por fazer parte do teste deste software! :')";
        String qrFile = "qrcode.png";
        String recipient = "naoexiste@diegochruscinski.com.br";
        String subject = "Test";

        assertFalse(shipping.sendMail(host,door, user, password,
                recipient, subject, body, qrFile, auth));

    }


    @Test
    public void testSendMail_SMTPAddressFailedException() {
        assertThrows(InvalidMailException.class, () -> {
           shipping.sendMail("invalidhost", "port", "user", "password",
                    "recipient@example.com", "Subject", "Body", "attachment.txt", true);
        });
    }



}
