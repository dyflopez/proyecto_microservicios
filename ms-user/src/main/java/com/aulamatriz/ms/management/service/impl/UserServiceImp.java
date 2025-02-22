package com.aulamatriz.ms.management.service.impl;

import com.aulamatriz.ms.management.dto.UserDto;
import com.aulamatriz.ms.management.model.UserEntity;
import com.aulamatriz.ms.management.repository.IUserRepository;
import com.aulamatriz.ms.management.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImp implements IUserService {

    private final IUserRepository IUserRepository;

    @Override
    public ResponseEntity<?> create(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setDocument(userDto.getDocument());
        userEntity.setTypeDocument(userDto.getTypeDocument());

        UserEntity newUser = this.IUserRepository.save(userEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }

    @Override
    public ResponseEntity<?> getAll() {
        var users = this.IUserRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
