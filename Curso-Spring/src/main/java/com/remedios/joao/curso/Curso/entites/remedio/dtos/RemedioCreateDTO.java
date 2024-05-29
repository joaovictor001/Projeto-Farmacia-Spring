package com.remedios.joao.curso.Curso.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.entites.remedio.Enum.Laboratorio;
import com.remedios.joao.curso.Curso.entites.remedio.Enum.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;


import java.time.LocalDate;

public record RemedioCreateDTO(

        @NotBlank
        String nome ,
        @Enumerated
        Via via,
        @NotBlank
        String  lote,
        int quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio) {

}
