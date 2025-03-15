package com.daniel.notify.service.impl;

import com.daniel.notify.dto.NotifyDto;
import com.daniel.notify.model.NotifyEntity;
import com.daniel.notify.repositoy.INotifyRepository;
import com.daniel.notify.service.INotifyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotifyServiceImpl implements INotifyService {

    private final INotifyRepository notifyRepository;

    @Override
    public ResponseEntity<?> sendNotification(NotifyDto notifyDto) {
        var notifyEntity = NotifyEntity.builder()
                .message(notifyDto.getMessage())
                .recipient(notifyDto.getRecipient())
                .id(java.util.UUID.randomUUID().toString())
                .build();

        this.notifyRepository.save(notifyEntity);

        return ResponseEntity.ok("email was send successfully");
    }
}
