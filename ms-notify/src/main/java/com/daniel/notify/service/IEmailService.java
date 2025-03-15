package com.daniel.notify.service;

import com.daniel.notify.dto.JmsEmailDetailsDto;

public interface IEmailService {

    void sendEmail(JmsEmailDetailsDto jmsEmailDetailsDto);
}
