package com.daniel.notify.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JmsEmailDetailsDto {

    private String recipient;
    private String msgBody;
    private String subject;
}
