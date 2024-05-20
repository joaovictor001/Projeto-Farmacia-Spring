package com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.Laboratorio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Via;

public record InDadosCadastroRemedio(String nome , Via via, String  lote, int quantidade, String validade, Laboratorio laboratorio) {

}
