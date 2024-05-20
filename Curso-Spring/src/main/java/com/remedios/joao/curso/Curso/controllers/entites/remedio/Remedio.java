package com.remedios.joao.curso.Curso.controllers.entites.remedio;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.InDadosCadastroRemedio;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "Remedio")
@Entity(name = "remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode


public class Remedio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private int quantidade;
    private String validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;


    public Remedio(InDadosCadastroRemedio dados) {
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();

    }


}
