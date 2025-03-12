package com.daniel.notify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JmsEmailDetails {

    private String recipient;

    private String msgBody;

    private String subject;

    private String attachment;
}
