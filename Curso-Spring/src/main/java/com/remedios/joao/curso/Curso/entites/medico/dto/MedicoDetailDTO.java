package com.remedios.joao.curso.Curso.entites.medico.dto;

import com.remedios.joao.curso.Curso.entites.medico.Enums.Especialidade;
import com.remedios.joao.curso.Curso.entites.medico.Medico;

public record MedicoDetailDTO(Long ID , String nome, Especialidade especialidade, String crm, String telefone, String email, boolean ativo) {

    public MedicoDetailDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEspecialidade(), medico.getCrm(), medico.getTelefone(), medico.getEmail(), medico.isAtivo());
    }
}
