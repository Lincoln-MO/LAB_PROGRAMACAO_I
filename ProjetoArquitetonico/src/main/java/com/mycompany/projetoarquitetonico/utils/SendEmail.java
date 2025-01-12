package com.mycompany.projetoarquitetonico.utils;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


/**
 *
 * @author yurit
 */
public class SendEmail {
    public static boolean SendMessage(String subject, String message, String target){        
        String EmailRemetente = "@gmail.com";
        String senhaEmailRemetente = "";
        
        SimpleEmail email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthentication(EmailRemetente, senhaEmailRemetente);
        email.setSSLOnConnect(true);
        
        try{
            email.setFrom(EmailRemetente);
            email.setSubject(subject);
            email.setMsg(message);
            email.addTo(target);
            email.send();
            return true;
        }catch(EmailException e){
            return false;
        }
    }
}
