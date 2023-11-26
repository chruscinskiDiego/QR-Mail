package mail;

import application.Program;

public class Data {

    // Configurações do servidor de e-mail
    public String host = "smtp.gmail.com";
    public String door = "587";
    public String user = "contatodiegochruscinski@gmail.com";

    public String password = "yxyukdopapmuqilv";
    public Boolean auth = true;

    // Estrutura do e-mail

    public String body = "Obrigado por fazer parte do teste deste software! :')";
    public String qrFile = "qrcode.png";
    public String qrPath = "C:\\UTFPR_2023_2\\TESTES\\QR-Mail\\QR-MAIL\\"+qrFile;

}
