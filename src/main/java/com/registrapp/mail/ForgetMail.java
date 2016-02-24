package com.registrapp.mail;

import com.registrapp.configuration.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class ForgetMail {

    @Autowired
    JavaMailSender mailSender;

    public void sendForgetEmail(String to, Integer userId)
            throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(Constants.MAIL_SERVER);
        helper.setTo(to);
        helper.setSubject("Forgot your password?");
        helper.setText("<html><head><meta charset='utf-8'></head><body>" +
                    "<center><img src='cid:logo' width='400px'><br>" +
                    "<a href='"+Constants.SERVER+Constants.FORGET+userId+"'>" +
                    "<button>Change password</button></center></a>"+
                    "</body></html>", true);
        ClassPathResource image = new ClassPathResource("img/logo3.png");
        helper.addInline("logo", image);
        mailSender.send(message);
        }
    }
