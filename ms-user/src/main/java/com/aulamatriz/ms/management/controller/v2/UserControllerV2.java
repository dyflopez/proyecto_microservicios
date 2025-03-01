package com.aulamatriz.ms.management.controller.v2;

import com.aulamatriz.ms.management.controller.v2.docs.IUserDoc;
import com.aulamatriz.ms.management.dto.UserDto;
import com.aulamatriz.ms.management.exception.MyHandleException;
import com.aulamatriz.ms.management.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserControllerV2 implements IUserDoc {

    private final IUserService userService;

    @Override
    public ResponseEntity<?> create(UserDto userDTO) {
        return this.userService.create(userDTO);
    }

    @Override
    public ResponseEntity<?> division(int valor1, int valor2) throws Exception {
        if(valor2==0){
            throw new MyHandleException("No se puede dividir por cero");
        } else if (valor2==1) {
            throw new Exception( "No se puede dividir por cero");
        }
        var result = valor1 / valor2;
        return ResponseEntity.ok(result);
    }
}
