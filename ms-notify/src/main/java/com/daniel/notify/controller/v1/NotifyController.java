package com.daniel.notify.controller.v1;

import com.daniel.notify.controller.v1.doc.INotifyControllerDoc;
import com.daniel.notify.dto.NotifyDto;
import com.daniel.notify.service.INotifyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class NotifyController implements INotifyControllerDoc {

    private final INotifyService notifyService;

    @Override
    public ResponseEntity<?> sendNotification(NotifyDto notifyDto) {
        return this.notifyService.sendNotification(notifyDto);
    }
}
