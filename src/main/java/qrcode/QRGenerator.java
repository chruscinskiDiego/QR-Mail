package qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

public class QRGenerator {

    public static void generateQRCode(String text, String filePath) {
        int width = 300;
        int height = 300;

        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

            BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
                }
            }

            File qrCodeFile = new File(filePath);
            ImageIO.write(bufferedImage, "png", qrCodeFile);


        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERRO "+e.getMessage());
        } catch (IIOException e) {
            JOptionPane.showMessageDialog(null, "ERRO "+e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ERRO "+e.getMessage());
        } catch (WriterException e) {
            JOptionPane.showMessageDialog(null, "ERRO "+e.getMessage());
        }


    }
}
