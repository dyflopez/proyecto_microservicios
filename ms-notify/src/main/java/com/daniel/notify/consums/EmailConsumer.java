package com.daniel.notify.consums;

import com.daniel.notify.dto.JmsEmailDetailsDto;
import com.daniel.notify.service.IEmailService;
import com.daniel.notify.utlis.JsonUtils;
import jakarta.jms.JMSException;
import jakarta.jms.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(value = "activemq.jms-listener.enabled", matchIfMissing = true)
public class EmailConsumer {

    private final IEmailService emailService;

    public EmailConsumer(IEmailService emailService) {
        this.emailService = emailService;
    }

    @JmsListener(destination = "email-queue",containerFactory = "jmsListenerContainerFactoryLoyalty")
    public void  listenerTransaction(Message<String> message, Session session) throws JMSException {
        JmsEmailDetailsDto emailDetails = new JmsEmailDetailsDto();
        log.info("EmailConsumer: " + message);
        try {
            String json = message.getPayload();
            log.info("EmailConsumer: " + json);
            emailDetails = JsonUtils.jsonToObject(json, JmsEmailDetailsDto.class);
            log.info("EmailConsumer: " + emailDetails);
            emailService.sendEmail(emailDetails);
        }catch (Exception e){
            log.error("Error: ", e);
        }
    }
}
