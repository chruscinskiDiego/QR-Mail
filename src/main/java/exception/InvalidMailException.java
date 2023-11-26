package exception;

import javax.mail.SendFailedException;

public class InvalidMailException extends SendFailedException {

    public InvalidMailException(String msg){
        super(msg);
    }

}
