package com.remedios.joao.curso.Curso.entites.usuario.dtos;

import jakarta.validation.constraints.NotBlank;

public record UsuarioCreateDTO(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}
