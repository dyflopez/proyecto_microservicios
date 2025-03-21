package com.aulamatriz.ms.management.service.impl;

import com.aulamatriz.ms.management.dto.NotifyDto;
import com.aulamatriz.ms.management.dto.UserDto;
import com.aulamatriz.ms.management.external.service.IFeignNotifyServiceEmail;
import com.aulamatriz.ms.management.model.UserEntity;
import com.aulamatriz.ms.management.repository.IUserRepository;
import com.aulamatriz.ms.management.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImp implements IUserService {

    private final IUserRepository IUserRepository;

    private final IFeignNotifyServiceEmail iNotifyServiceEmail;

    @Override
    public ResponseEntity<?> create(UserDto userDto) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDto.getName());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setDocument(userDto.getDocument());
        userEntity.setTypeDocument(userDto.getTypeDocument());

        UserEntity newUser = this.IUserRepository.save(userEntity);

        NotifyDto notifyDto = NotifyDto
                .builder()
                .message("New user created")
                .recipient(userDto.getEmail())
                .build();


        this.iNotifyServiceEmail.sendNotification(notifyDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }

    @Override
    public ResponseEntity<?> getAll() {
        var users = this.IUserRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<?> getByName(String name) {
        Optional<UserEntity> user = this.IUserRepository.findByName(name);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok(new UserEntity());
    }
}
