package mango.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator{
	

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("mango.project0324@gmail.com","akdrh123");
    }
}


