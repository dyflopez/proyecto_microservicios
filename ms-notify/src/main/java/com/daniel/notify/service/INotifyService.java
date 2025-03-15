package com.daniel.notify.service;

import com.daniel.notify.dto.NotifyDto;
import org.springframework.http.ResponseEntity;

public interface INotifyService {

    ResponseEntity<?> sendNotification(NotifyDto notifyDto);
}
