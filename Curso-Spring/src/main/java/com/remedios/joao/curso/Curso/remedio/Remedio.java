package com.remedios.joao.curso.Curso.remedio;

import jakarta.persistence.*;

import java.security.PrivateKey;

@Table(name = "Remedio")
@Entity(name = "remedios")

public class Remedio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private String quantidade;
    private String validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
}
