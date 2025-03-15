package com.daniel.notify.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotifyDto {


    @NotBlank
    @NotEmpty
    @Size(min = 5, max = 100)
    private String message;

    @NotBlank
    @NotEmpty
    @Email
    @Size(min = 5, max = 100)
    private String recipient;
}
