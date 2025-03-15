package com.daniel.notify.service.impl;

import com.daniel.notify.dto.JmsEmailDetailsDto;
import com.daniel.notify.dto.NotifyDto;
import com.daniel.notify.model.NotifyEntity;
import com.daniel.notify.repository.INotifyRepository;
import com.daniel.notify.service.IEmailService;
import com.daniel.notify.service.INotifyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class NotifyServiceImpl implements INotifyService {

    private final INotifyRepository notifyRepository;

    private final IEmailService emailService;

    @Override
    public ResponseEntity<?> sendNotification(NotifyDto notifyDto) {

        NotifyEntity notify = NotifyEntity
                .builder()
                .id(UUID.randomUUID().toString())
                .message(notifyDto.getMessage())
                .recipient(notifyDto.getRecipient())
                .build();

        var  newNotify=  notifyRepository.save(notify);

        JmsEmailDetailsDto jmsEmailDetailsDto = JmsEmailDetailsDto
                .builder()
                .recipient(notifyDto.getRecipient())
                .msgBody(notifyDto.getMessage())
                .subject("New Notification")
                .build();

        this.emailService.sendEmail(jmsEmailDetailsDto);


        return ResponseEntity.ok(newNotify);
    }
}
