package com.remedios.joao.curso.Curso.entites.remedio;

import com.remedios.joao.curso.Curso.entites.remedio.Enum.Laboratorio;
import com.remedios.joao.curso.Curso.entites.remedio.Enum.Via;
import com.remedios.joao.curso.Curso.entites.remedio.dtos.RemedioUpdateDTO;
import com.remedios.joao.curso.Curso.entites.remedio.dtos.RemedioCreateDTO;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Table(name = "Remedio")
@Entity(name = "remedios")
@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


public class Remedio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private int quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
    private boolean ativo;


    public Remedio(RemedioCreateDTO dados) {

        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
        this.ativo = true;
    }


    public void atualizarInformacoes(RemedioUpdateDTO dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.via() != null){
            this.via = dados.via();
        }
        if (dados.laboratorio() != null){
            this.laboratorio = dados.laboratorio();
        }
    }

    public void inativar(){
        this.ativo = false;
    }
    public void ativar(){
        this.ativo = true;
    }

    public boolean vereicar_status(){
        return this.ativo;
    }


}
