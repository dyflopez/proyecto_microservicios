package com.daniel.notify.controller.v1.doc;

import com.daniel.notify.dto.NotifyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Notify", description = "Notify API")
@RequestMapping("/api/v1/notify")
public interface INotifyDoc {

    @Operation(summary = "Send notification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Notification sent"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
    })

    @PostMapping
    ResponseEntity<?> sendNotification(@Valid @RequestBody NotifyDto notifyDto);
}
