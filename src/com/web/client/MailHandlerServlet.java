package com.web.client;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException; 
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Properties; 

import javax.servlet.http.*; 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;





 
public class MailHandlerServlet extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException { 
		Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
		final String username = "chienfuweb@gmail.com";
	    final String password = "1qaz2wsx#";
	    final String adminname = "chienfu76@hotmail.com";
        Session session = Session.getInstance(props,
        	      new javax.mail.Authenticator() {
        	        protected PasswordAuthentication getPasswordAuthentication() {
        	            return new PasswordAuthentication(username, password);
        	        }
        	      });
        String msgBody = "千釜網站留言資訊\n\n\n"+
        				"姓名："+req.getParameter("name")+"\n\n"+
    					"電話 ："+req.getParameter("tel")+"\n\n"+
					"EMail："+req.getParameter("mail")+"\n\n"+
					"留言："+req.getParameter("message");

        try {
        		PrintWriter out = new PrintWriter(new OutputStreamWriter(resp.getOutputStream(), "UTF8"), true);

        		if (!req.getParameter("name").equals("")){
	            Message msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress(username, MimeUtility.encodeText("千釜網站 系統自動寄發","UTF-8",null)));
	            msg.addRecipient(Message.RecipientType.TO,
	                             new InternetAddress(adminname));
	            
	            msg.setSubject(MimeUtility.encodeText("千釜網站 意見回饋","UTF-8",null));
	
	            msg.setText(msgBody);
	            Transport.send(msg);
	            out.print("感謝您的留言"); 
        		}else {
        		    out.print("留言發生錯誤,請撥打電話聯絡!'}");  
        		}
        		out.flush();
        } catch (AddressException e) {
        		e.printStackTrace();
        } catch (MessagingException e) {
			e.printStackTrace();
		}
                
			
                
	}
}
