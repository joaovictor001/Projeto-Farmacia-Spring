package com.remedios.joao.curso.Curso.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.entites.remedio.Enum.Laboratorio;
import com.remedios.joao.curso.Curso.entites.remedio.Remedio;
import com.remedios.joao.curso.Curso.entites.remedio.Enum.Via;

import java.time.LocalDate;

public record RemedioDetailDTO(
        Long id ,
        String nome,
        Via via,
        String lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio,

        Boolean ativo) {
    public RemedioDetailDTO(Remedio remedio){
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio(),
                remedio.isAtivo());
    }
}
