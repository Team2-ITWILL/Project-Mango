package mango.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator{
	
	PasswordAuthentication pa;
	
	public MailAuth()
	{
		pa = new PasswordAuthentication("rhksflwkflwk11", "rhksflwk1");
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication()
	{
		return pa;
	}
}


