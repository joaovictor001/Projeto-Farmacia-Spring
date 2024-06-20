package com.remedios.joao.curso.Curso.entites.usuario.dtos;

import com.remedios.joao.curso.Curso.entites.usuario.Usuario;

public record UsuarioListDTO (Long id, String name, String email) {

    public UsuarioListDTO (Usuario usuario){
        this(usuario.getId(), usuario.getName(), usuario.getEmail());
    }
}
