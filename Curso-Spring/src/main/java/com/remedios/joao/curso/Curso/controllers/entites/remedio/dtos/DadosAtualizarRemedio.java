package com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.Laboratorio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Via;
import lombok.NoArgsConstructor;
import lombok.NonNull;

public record DadosAtualizarRemedio(
        @NonNull
        Long id,
        String nome,
        @NonNull
        Via via,
        Laboratorio laboratorio) {
}
