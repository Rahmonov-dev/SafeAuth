package org.register.Services;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class NotificationService {
    private static final String username = "baxtiyorr545@gmail.com";
    private static final String password = "nfxf dbqf xqzc hhvs";

    public static void sendEmail(String toEmail) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Ro'yxatdan o'tish");
            message.setContent("""
                <h2>Hurmatli foydalanuvchi!</h2>
                <p>Siz tizimimizda muvaffaqiyatli ro'yxatdan o'tdingiz.</p>
                <p>Biz bilan birga bo'lganingizdan mamnunmiz!</p>
                <p>Hurmat bilan, jamoamiz!</p>
                """, "text/html; charset=utf-8");

            Transport.send(message);
            System.out.println("Email successfully sent to " + toEmail);
        } catch (MessagingException e) {
            System.out.println("Failed to send email to " + toEmail);
        }
    }
}
