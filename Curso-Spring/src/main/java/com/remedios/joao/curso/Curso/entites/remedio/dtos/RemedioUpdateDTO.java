package com.remedios.joao.curso.Curso.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.entites.remedio.Enum.Laboratorio;
import com.remedios.joao.curso.Curso.entites.remedio.Enum.Via;
import jakarta.validation.constraints.NotNull;

public record RemedioUpdateDTO(
        @NotNull
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio,
        boolean ativo) {
}
