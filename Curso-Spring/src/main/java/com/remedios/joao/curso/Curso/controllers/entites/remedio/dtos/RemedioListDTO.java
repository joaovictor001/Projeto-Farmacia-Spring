package com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.Enum.Laboratorio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Remedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Enum.Via;

import java.time.LocalDate;

public record RemedioListDTO(long id, String nome , Via via, String lote, Laboratorio laboratorio, LocalDate validade) {
    public RemedioListDTO(Remedio remedio){
        this(remedio.getId(),remedio.getNome(),remedio.getVia(),remedio.getLote(),remedio.getLaboratorio(),remedio.getValidade());
    }
}
