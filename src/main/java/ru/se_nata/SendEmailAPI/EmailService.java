package ru.se_nata.SendEmailAPI;




import java.util.Properties;
import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	public boolean sendmail(String to, String subject,String message) {
		String senderEmail="serviceexample@gmail.com";
		String senderPassword="test";
		boolean foo=false;
		
		Properties properties=new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		
           Session session=Session.getDefaultInstance(properties, 
        		   new Authenticator(){
               			protected PasswordAuthentication getPasswordAuthentication(){

                   return new PasswordAuthentication(senderEmail, senderPassword);
               }
           });
		
		try {
			MimeMessage msg=new MimeMessage(session);
			msg.setFrom();
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(subject);
			msg.setText(message);
			jakarta.mail.Transport.send(msg);
			foo=true;
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return foo;
	}

}
