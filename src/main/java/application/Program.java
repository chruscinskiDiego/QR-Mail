package application;

import exception.InvalidMailException;
import mail.Data;
import mail.Shipping;
import qrcode.QRGenerator;

import javax.imageio.IIOException;
import javax.swing.*;
import java.io.FileNotFoundException;

public class Program {


    public static void main(String[] args) throws InvalidMailException {

        QRGenerator qrGenerator = new QRGenerator();
        Data dataMail = new Data();
        Shipping shipping = new Shipping();

        int choice = 0;

        String[] options ={"Enviar QRCode", "Sair"};

        while (choice!= 1)
        {
            choice = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma ação:",
                    "QRCode Generator by Diego Chruscinski",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if(choice == 0){

                try{
                    String recipient = JOptionPane.showInputDialog(null,
                            "Informe o e-mail para recebimento do QRCode:",
                            "QRCode Generator by Diego Chruscinski",
                            JOptionPane.QUESTION_MESSAGE);

                    String link =JOptionPane.showInputDialog(null,
                            "Informe o link: ",
                            "QRCode Generator by Diego Chruscinski",
                            JOptionPane.QUESTION_MESSAGE);


                    String subject = "Seu QRCode para o link "+link+" chegou!";

                    qrGenerator.generateQRCode(link ,dataMail.qrFile);

                    if(shipping.sendMail(dataMail.host,dataMail.door, dataMail.user, dataMail.password, recipient, subject,
                            dataMail.body, dataMail.qrPath, dataMail.auth)==true){
                        JOptionPane.showMessageDialog(null, "QRCode enviado no e-mail com sucesso!");
                    }
                }
                catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "ERRO "+e.getMessage());
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Até breve! :)");
            }
        }

    }
}
