package com.remedios.joao.curso.Curso.controllers.entites.medico.dto;

import com.remedios.joao.curso.Curso.controllers.entites.medico.Enums.Especialidade;

public record MedicoCreateDTO(String nome, Especialidade especialidade,String crm, String telefone, String email) {
}
