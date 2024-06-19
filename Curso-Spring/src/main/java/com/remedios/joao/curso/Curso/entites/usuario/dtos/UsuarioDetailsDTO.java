package com.remedios.joao.curso.Curso.entites.usuario.dtos;

import com.remedios.joao.curso.Curso.entites.usuario.Usuario;

public record UsuarioDetailsDTO(long id, String name, String passoword) {
    public UsuarioDetailsDTO(Usuario user) {
        this(user.getId(), user.getUsername(), user.getPassword());
    }
}
