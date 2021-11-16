package guiCountries;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class EnvioCorreo {
    
    static final String FROM = "jamcrests@gmail.com";
    static final String FROMNAME = "Cartera Virtual";
    static final String TO = "jamcrests@gmail.com";
    
    
    static final String SMTP_USERNAME = "jamcrests@gmail.com";
    static final String SMTP_PASSWORD = "*Welcome01";
    
    static final String CONFIGSET = "ConfigSet";
    
    static final String HOST = "smtp.gmail.com";
    
    static final int PORT = 587;
    
    static final String SUBJECT = "MENSAJE IMPORTANTE";
    
    static final String BODY = "Mensaje de prueba para ver si funciona";
    
    
 
    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {
     
        Properties props = System.getProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        
        MimeMessage mg = new MimeMessage(session);
        mg.setFrom(new InternetAddress(FROM, FROMNAME));
        mg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        mg.setSubject(SUBJECT);
        mg.setContent(BODY,"text/html");
        
        mg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);
        
        Transport transport = session.getTransport();
        
        try {
            transport.connect(HOST,SMTP_USERNAME,SMTP_PASSWORD);
            transport.sendMessage(mg, mg.getAllRecipients());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            System.out.println(e.getMessage());
        }finally{
            transport.close();
        }
        
    }
    
}
