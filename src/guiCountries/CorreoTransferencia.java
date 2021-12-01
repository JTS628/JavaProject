/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


public class CorreoTransferencia {
    static final String FROM = "jamcrests@gmail.com";
    static final String FROMNAME = "CARTERA VIRTUAL";
    private String TO; // = "jamcrests@gmail.com";
    
    public CorreoTransferencia (String TO){
        this.TO = TO;}
    
    
    static final String SMTP_USERNAME = "jamcrests@gmail.com";
    static final String SMTP_PASSWORD = "*Welcome01*";
    
    static final String CONFIGSET = "ConfigSet";
    
    static final String HOST = "smtp.gmail.com";
    
    static final int PORT = 587;
    
    static final String SUBJECT = "NOTIFICACION DE TRANSFERENCIA";
    
    static final String BODY = "El presente documento es para informarle sobre sobre su reciente transferencia realizada en nuestra plataforma virtal";
    
    
 
    public void enviarcorreotransf() throws UnsupportedEncodingException, MessagingException {
     
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
            JOptionPane.showMessageDialog(null, "Verifique los datos de correo ingresados");
            System.out.println(e.getMessage());
        }finally{
            transport.close();
        }
        
    }

     
    public static String getFROM() {
        return FROM;
    }

    public static String getFROMNAME() {
        return FROMNAME;
    }

    /*public static String getTO() {
        return TO;
    }*/

    public static String getSMTP_USERNAME() {
        return SMTP_USERNAME;
    }

    public static String getSMTP_PASSWORD() {
        return SMTP_PASSWORD;
    }

    public static String getCONFIGSET() {
        return CONFIGSET;
    }

    public static String getHOST() {
        return HOST;
    }

    public static int getPORT() {
        return PORT;
    }

    public static String getSUBJECT() {
        return SUBJECT;
    }

    public static String getBODY() {
        return BODY;
    }
    
    
    }

