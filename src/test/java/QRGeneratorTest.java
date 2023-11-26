import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import qrcode.QRGenerator;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QRGeneratorTest {

    private QRGenerator qrGenerator;

    @BeforeEach
    public void setUp() {
        qrGenerator = new QRGenerator();
    }

    @Test
    public void testGenerateQRCode_OneWord() {
        String text = "testID1";
        String filePath = "testID1";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_SpaceBetweenWords() {
        String text = "test ID 2";
        String filePath = "test ID 2";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_EmptyInput() {
        String text = "";
        String filePath = "";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_SpecialCharacter() {
        String text = "@#%_";
        String filePath = "@#%_";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_Link() {
        String text = "www.instagram.com";
        String filePath = "www.instagram.com";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_LongText() {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Praesent egestas augue in ultricies rhoncus. Sed dignissim convallis" +
                " massa, ac mattis enim. Aenean vestibulum commodo quam quis condimentum." +
                "Mauris posuere dui nibh, sit amet tincidunt ligula lobortis at. Quisque eget" +
                " neque rutrum, consectetur nisl non, tempus dolor. Proin id condimentum justo. " +
                "Phasellus nec felis sagittis, congue tellus sit amet, semper mauris. Vivamus est leo," +
                " laoreet quis dui eget, egestas mollis massa. Ut non odio elementum, hendrerit nibh sit " +
                "amet, luctus diam. Quisque rhoncus dictum facilisis.";

        String filePath = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Praesent egestas augue in ultricies rhoncus. Sed dignissim convallis" +
                " massa, ac mattis enim. Aenean vestibulum commodo quam quis condimentum." +
                "Mauris posuere dui nibh, sit amet tincidunt ligula lobortis at. Quisque eget" +
                " neque rutrum, consectetur nisl non, tempus dolor. Proin id condimentum justo. " +
                "Phasellus nec felis sagittis, congue tellus sit amet, semper mauris. Vivamus est leo," +
                " laoreet quis dui eget, egestas mollis massa. Ut non odio elementum, hendrerit nibh sit " +
                "amet, luctus diam. Quisque rhoncus dictum facilisis.";;

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_NotUFT8() {
        String text = "中文测试";
        String filePath = "中文测试";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_BinaryData() {
        String text = "\\u0000\\u0001\\u0002\\u0003";
        String filePath = "\\u0000\\u0001\\u0002\\u0003";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_NullInput() {
        String text = null;
        String filePath = null;

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_FormatedText() {
        String text = "Bold: **Hello**";
        String filePath = "Bold: **Hello**";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_ControlText() {
        String text = "\n\n\n";
        String filePath = "\n\n\n";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_HTML() {
        String text = "<html><body>Hello</body></html>";
        String filePath = "<html><body>Hello</body></html>";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_JSON() {
        String text = "{\"key\": \"value\"}";
        String filePath = "{\"key\": \"value\"}";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_Accentuation() {
        String text = "ããããããã";
        String filePath ="ããããããã";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_NumbersLetters() {
        String text = "A2c3r4232B2dsda";
        String filePath = "A2c3r4232B2dsda";

        qrGenerator.generateQRCode(text, filePath);

        File qrCodeFile = new File(filePath);
        assertTrue(qrCodeFile.exists());
    }

    @Test
    public void testGenerateQRCode_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> qrGenerator.generateQRCode("",""));
    }

    @Test
    public void testGenerateQRCode_NullPointerException(){
        assertThrows(IllegalArgumentException.class, () -> qrGenerator.generateQRCode(null, null));
    }










}
