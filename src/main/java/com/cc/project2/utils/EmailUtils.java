package com.cc.project2.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Value("${FromEmail}")
	private String toFromEmail;
	
	public boolean sendEmail(String emailID, String Subject, String text) {
		  Properties props = new Properties();
		  Session session = Session.getDefaultInstance(props, null);

		  try {
		    Message msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress(toFromEmail, "ASU Short term Accomodator"));
		    msg.addRecipient(Message.RecipientType.TO,
		                     new InternetAddress(emailID, "Dear User"));
		    msg.setSubject(Subject);
		    msg.setText(text);
		    Transport.send(msg);
		    return true;
		  } catch (AddressException e) {
			  return false;
		    // ...
		  } catch (MessagingException e1) {
		    // ...
			  return false;
		  } catch (UnsupportedEncodingException e2) {
			  return false;
		    // ...
		  }catch(Exception e3) {
			  return false;
		  }
	}
}
