package com.remedios.joao.curso.Curso.entites.medico.dto;

import com.remedios.joao.curso.Curso.entites.medico.Enums.Especialidade;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
        @NotNull
        Long id,
        Especialidade especialidade,
        String telefone,
        String email) {
}
