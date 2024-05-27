package com.remedios.joao.curso.Curso.controllers.entites.medico;

import com.remedios.joao.curso.Curso.controllers.entites.medico.Enums.Especialidade;
import com.remedios.joao.curso.Curso.controllers.entites.medico.dto.MedicoCreateDTO;
import com.remedios.joao.curso.Curso.controllers.entites.medico.dto.MedicoUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


//@Table que vai indicar qual a tabela corespondente no banco de dado
@Table(name = "medico")
@Entity(name = "medicos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank
    private String nome;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @NotBlank
    @Column(unique = true)
    private String crm;

    private String telefone;

    private String email;

    private boolean ativo;


    public Medico(MedicoCreateDTO dados){
        this.nome = dados.nome();
        this.especialidade = dados.especialidade();
        this.crm = dados.crm();;
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.ativo = true;

    }

    public void atualizar(MedicoUpdateDTO dados){
        if(dados.especialidade() != null){
            this.especialidade = dados.especialidade();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
    }

    public void ativar(){
        this.ativo = true;
    }
    public  void desativar(){
        this.ativo = false;
    }

}
