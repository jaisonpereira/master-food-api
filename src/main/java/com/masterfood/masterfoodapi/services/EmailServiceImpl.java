package com.masterfood.masterfoodapi.services;

import com.wirelabs.service.SmtpEmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

import javax.mail.internet.MimeMessage;

public class EmailServiceImpl extends SmtpEmailService {

    @Value("${default.sender}")
    private String sender;

    public void sendNewPasswordEmail(String email, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(email, newPass);
        sendEmail(sm);
    }

    private SimpleMailMessage prepareNewPasswordEmail(String email, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(email);
        sm.setFrom(sender);
        sm.setSubject("Master Food - Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        // TODO Auto-generated method stub
    }

}
