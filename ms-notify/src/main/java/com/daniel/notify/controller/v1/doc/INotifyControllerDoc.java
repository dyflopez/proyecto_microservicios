package com.daniel.notify.controller.v1.doc;


import com.daniel.notify.dto.NotifyDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Notify", description = "Notify Controller")
@RequestMapping("/notify")
public interface INotifyControllerDoc {


    @Operation(summary = "Send notification")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email was send successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping
    ResponseEntity<?> sendNotification(@RequestBody NotifyDto notifyDto);
}
