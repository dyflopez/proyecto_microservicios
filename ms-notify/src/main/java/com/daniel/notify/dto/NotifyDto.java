package com.daniel.notify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotifyDto {

    private String message;
    private  String recipient;

}
