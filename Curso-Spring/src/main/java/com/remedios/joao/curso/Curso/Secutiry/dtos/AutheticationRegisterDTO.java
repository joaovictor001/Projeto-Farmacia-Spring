package com.remedios.joao.curso.Curso.Secutiry.dtos;

import jakarta.validation.constraints.NotBlank;

public record AutheticationRegisterDTO(
        @NotBlank
        String name,
        String email,
        @NotBlank
        String password
) {



}
