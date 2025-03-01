package com.aulamatriz.ms.management.controller.v2.docs;

import com.aulamatriz.ms.management.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User-api", description = "crud basico para usuarios")
@RequestMapping("/v2/user")
public interface IUserDoc {

    @Operation(summary = "Crear un nuevo usuario")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Usuario creado"),
                    @ApiResponse(responseCode = "500", description = "el desarrollador la cago"),
                    @ApiResponse(responseCode = "404", description = "endpoint no encontrado"),
            }
    )
    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid UserDto userDTO);


    @Operation(summary = "division")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "dividido"),
                    @ApiResponse(responseCode = "500", description = "el desarrollador la cago"),
                    @ApiResponse(responseCode = "404", description = "endpoint no encontrado"),
            }
    )
    @GetMapping("/division")
    ResponseEntity<?> division(@RequestParam("valor1") int valor1,
                               @RequestParam("valor2") int valor2) throws Exception;
}
