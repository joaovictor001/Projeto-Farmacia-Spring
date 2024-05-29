package com.remedios.joao.curso.Curso.entites.medico.dto;

import com.remedios.joao.curso.Curso.entites.medico.Enums.Especialidade;

public record MedicoCreateDTO(String nome, Especialidade especialidade,String crm, String telefone, String email) {
}
