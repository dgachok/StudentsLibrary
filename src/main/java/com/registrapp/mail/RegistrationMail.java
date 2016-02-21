package com.registrapp.mail;

import com.registrapp.configuration.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class RegistrationMail {

    @Autowired
    JavaMailSender mailSender;

    public void sendRegistrationEmail(String to, Integer userId)
            throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(Constants.MAIL_SERVER);
        helper.setTo(to);
        helper.setSubject("Реєстрація аккаунта");
        helper.setText("<html><head><meta charset='utf-8'></head><body>" +
                "<center><img src='cid:logo' width='400px'><br>" +
                "<a href='"+Constants.SERVER+Constants.VERIFICATION+userId+"'>" +
                "<button>Активувати аккаунт</button></center></a>"+
                "</body></html>", true);
        ClassPathResource image = new ClassPathResource("img/logo3.png");
        helper.addInline("logo", image);
        mailSender.send(message);
    }
}
