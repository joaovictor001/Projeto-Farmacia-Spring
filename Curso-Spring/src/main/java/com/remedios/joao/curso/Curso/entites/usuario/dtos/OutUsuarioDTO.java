package com.remedios.joao.curso.Curso.entites.usuario.dtos;


import com.remedios.joao.curso.Curso.entites.usuario.Usuario;

public record OutUsuarioDTO(

        long id, String email

) {

    public OutUsuarioDTO(Usuario usuario) {

        this(usuario.getId(), usuario.getUsername());

    }
}
