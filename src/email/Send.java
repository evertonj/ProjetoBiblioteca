/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author EvetonSpindola
 */
public class Send {

    /**
     *
     * @param para
     * @param titulo
     * @param usuario
     * @return
     * @throws javax.mail.MessagingException
     */
    public static boolean email(String para, String titulo, String usuario) throws MessagingException{
        final String username = "bibliotecaslages@gmail.com";
        final String password = "projetodeextensao";
        
        String assunto = "Obra reservada";
        String mensagem = usuario + " sua obra de título: " + titulo + " já está disponível na biblioteca\n"
                + "Favor retirar em 48h, obrigado.";
        
        Properties pros = new Properties();
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.enable", "true");
        pros.put("mail.smtp.host", "smtp.gmail.com");
        pros.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(pros,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(para));
            message.setSubject(assunto);
            message.setText(mensagem);
            
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
