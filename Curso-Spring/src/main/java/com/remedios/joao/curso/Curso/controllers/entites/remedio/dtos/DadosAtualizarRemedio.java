package com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.Laboratorio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Via;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public record DadosAtualizarRemedio(
        @NotNull
        Long id,
        String nome,
        Via via,
        Laboratorio laboratorio,
        boolean ativo) {
}
