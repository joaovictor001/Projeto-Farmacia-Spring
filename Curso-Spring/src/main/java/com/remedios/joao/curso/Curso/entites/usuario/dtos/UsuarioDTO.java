package com.remedios.joao.curso.Curso.entites.usuario.dtos;


import com.remedios.joao.curso.Curso.entites.usuario.Usuario;

public record UsuarioDTO(

        Long id,
        String Name,
        String Email

) {

    public UsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getEmail(), usuario.getName());
    }
}
