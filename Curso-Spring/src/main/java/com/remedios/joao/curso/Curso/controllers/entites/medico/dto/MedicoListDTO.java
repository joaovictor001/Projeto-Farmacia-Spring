package com.remedios.joao.curso.Curso.controllers.entites.medico.dto;

import com.remedios.joao.curso.Curso.controllers.entites.medico.Enums.Especialidade;
import com.remedios.joao.curso.Curso.controllers.entites.medico.Medico;

public record MedicoListDTO(Long id, String nome, Especialidade especialidade, String crm, String telefone, String email,boolean ativo) {
    public MedicoListDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEspecialidade(),medico.getCrm(), medico.getTelefone(), medico.getEmail(),medico.isAtivo());

    }
}
