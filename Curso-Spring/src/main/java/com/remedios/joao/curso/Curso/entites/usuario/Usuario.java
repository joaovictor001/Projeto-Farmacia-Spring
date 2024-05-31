package com.remedios.joao.curso.Curso.entites.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Usuario")
@Entity(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of  = "id")


public class Usuario {
    // A anotação id so indica para o banco quem é a chave primaria
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String email;
    private  String pssword;

}
