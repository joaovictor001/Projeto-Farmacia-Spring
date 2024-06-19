package com.remedios.joao.curso.Curso.Secutiry.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank
        String email,

        @NotBlank
        String senha) {
}
