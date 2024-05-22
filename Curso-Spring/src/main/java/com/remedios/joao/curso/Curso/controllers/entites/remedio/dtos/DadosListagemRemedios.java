package com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.Laboratorio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Remedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Via;

import java.time.LocalDate;

public record DadosListagemRemedios(String nome , Via via, String lote, Laboratorio laboratorio, LocalDate validade) {
    public DadosListagemRemedios(Remedio remedio){
        this(remedio.getNome(),remedio.getVia(),remedio.getLote(),remedio.getLaboratorio(),remedio.getValidade());
    }
}
