package com.remedios.joao.curso.Curso.security.services;


import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import com.remedios.joao.curso.Curso.entites.usuario.dtos.InUsuarioDTO;
import com.remedios.joao.curso.Curso.entites.usuario.dtos.OutUsuarioDTO;
import com.remedios.joao.curso.Curso.entites.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public OutUsuarioDTO register(InUsuarioDTO dados){

        Usuario usuario = new Usuario(dados, passwordEncoder.encode(dados.password()));

        System.out.println("ROLES - " + usuario.getAuthorities());

        usuarioService.save(usuario);

        return new OutUsuarioDTO(usuario);
    }
}