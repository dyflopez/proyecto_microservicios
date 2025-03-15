package com.daniel.notify.service.impl;

import com.daniel.notify.dto.JmsEmailDetailsDto;
import com.daniel.notify.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(JmsEmailDetailsDto jmsEmailDetailsDto) {
        try {
            //Crear emaila enviar
            SimpleMailMessage msg = new SimpleMailMessage();

            // Set the email address of the sender
            msg.setFrom("daniel.florez2315@gmail.com");
            msg.setTo(jmsEmailDetailsDto.getRecipient());
            msg.setText(jmsEmailDetailsDto.getMsgBody());
            msg.setSubject(jmsEmailDetailsDto.getSubject());

            javaMailSender.send(msg);

        } catch (Exception e) {
            System.out.println("Error sending email: " + e.getMessage());
        }
    }
}
