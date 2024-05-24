package com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.Laboratorio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Remedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Via;

import java.time.LocalDate;

public record DadosDetalhamentoRemedios(
        Long id ,
        String nome,
        Via via,
        String lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio,

        Boolean ativo) {
    public DadosDetalhamentoRemedios(Remedio remedio){
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
