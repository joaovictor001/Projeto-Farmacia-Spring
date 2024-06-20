package com.remedios.joao.curso.Curso.Secutiry;

import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import com.remedios.joao.curso.Curso.entites.usuario.dtos.UsuarioCreateDTO;
import com.remedios.joao.curso.Curso.entites.usuario.dtos.UsuarioDetailsDTO;
import com.remedios.joao.curso.Curso.entites.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizaionService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthorizaionService authorizaionService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioDetailsDTO register(UsuarioCreateDTO dados){
        Usuario usuario  = new Usuario(dados,passwordEncoder.encode(dados.password()));

        usuarioService.save(usuario);

        return new UsuarioDetailsDTO(usuario);
    }
}
