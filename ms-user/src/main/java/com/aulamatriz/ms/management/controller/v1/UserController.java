package com.aulamatriz.ms.management.controller.v1;

import com.aulamatriz.ms.management.dto.UserDto;
import com.aulamatriz.ms.management.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.create(userDTO));
    }

    @PostMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
}
