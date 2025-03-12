package com.daniel.notify.consumers;


import com.daniel.notify.dto.JmsEmailDetails;
import com.daniel.notify.utils.JsonUtils;
import jakarta.jms.JMSException;
import jakarta.jms.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.messaging.Message;

@Slf4j
@Component
@ConditionalOnProperty(value = "activemq.jms-listener.enabled", matchIfMissing = true)
public class EmailConsumer {

    @JmsListener(destination = "${activemq.msemail.transaction-status-changes.queue}",
            containerFactory = "jmsListenerContainerFactoryLoyalty")
    public void transactionStatusChange(Message<String> message, Session session) throws JMSException {

        JmsEmailDetails details = new JmsEmailDetails();


        try {

            String jsonMessage = message.getPayload();
            log.info("ActiveMQ incomming message from {}: \n{}", jsonMessage);
            details = JsonUtils.jsonToObject(jsonMessage, JmsEmailDetails.class);

            log.info("ActiveMQ incomming message from {}: \n{}", details);

        } catch (Exception e) {
            log.error("Error proccessing JSON message\n{}", e.getLocalizedMessage());
        }
    }
}
