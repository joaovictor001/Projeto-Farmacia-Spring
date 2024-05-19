package com.remedios.joao.curso.Curso.remedio.DTO;

import com.remedios.joao.curso.Curso.remedio.Laboratorio;
import com.remedios.joao.curso.Curso.remedio.Via;

public record DadosCadastroRemedio(String nome , Via via, String  lote, String quantidade, String validade, Laboratorio laboratorio) {

}
