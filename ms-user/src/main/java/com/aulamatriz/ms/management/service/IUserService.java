package com.aulamatriz.ms.management.service;

import com.aulamatriz.ms.management.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponseEntity<?> create(UserDto userDto);

    ResponseEntity<?> getAll();
}