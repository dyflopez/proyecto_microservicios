package com.aulamatriz.ms.management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotBlank
    @Size(min = 0, max = 20,message = "el nombre no debe tener mas de 20 caracteres")
    //TODO EL nombre no debe tener numeros
    private String name;
    @NotBlank
    @Email(message = "el email debe ser valido , @")
    @Size(min = 0, max = 30 ,message = "el email no debe tener mas de 30 caracteres")
    private String email;

    @NotBlank
    @Size(min = 0, max = 12)
    //TODO solo debe temeros numeros ayuda, expreciones regulares
    private String document;
    @NotBlank
    // TODO SOLO DEBE PERMITIR CC , CE
    private String typeDocument;
}
