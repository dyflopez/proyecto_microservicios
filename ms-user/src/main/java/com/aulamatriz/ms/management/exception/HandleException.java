package com.aulamatriz.ms.management.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
@NoArgsConstructor
public class HandleException {

    @Value("${control.my-exception}")
    private String errorNegocio ;

    //metodo para el manejo de errores no controlados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleExceptionMethod(Exception e){
        var error = "Error del sistema :" + e.getMessage();
        log.error(error);
        return ResponseEntity
                .badRequest()
                .body(error);
    }

    //metodo para el manejo de errores controlados
    @ExceptionHandler(MyHandleException.class)
    public ResponseEntity<String> myHandleExceptionMethod(Exception e){
        var error =  errorNegocio + " : " + e.getMessage();
        log.error(error);
        return ResponseEntity
                .badRequest()
                .body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleExceptionArgument(MethodArgumentNotValidException ex){
        List<String> errorList = new ArrayList<>();
        //Java  > 8
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errorList.add(
                    """
                       Error del sistema %s: %s: %s
                        """.formatted(error.getObjectName(), error.getField(), error.getDefaultMessage())
            );
        }
        //java <11+ Streams
        errorList = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> """
                       Error del sistema %s: %s: %s
                        """.formatted(error.getObjectName(), error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity
                .badRequest()
                .body(errorList);
    }
}
