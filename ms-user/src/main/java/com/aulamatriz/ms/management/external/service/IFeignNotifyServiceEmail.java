package com.aulamatriz.ms.management.external.service;

import com.aulamatriz.ms.management.dto.NotifyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:9090")
public interface IFeignNotifyServiceEmail {

    @PostMapping("/api/v1/notify")
    ResponseEntity<?> sendNotification(@RequestBody NotifyDto notifyDto);
}
