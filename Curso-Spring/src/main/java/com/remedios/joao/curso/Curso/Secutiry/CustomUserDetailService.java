package com.remedios.joao.curso.Curso.Secutiry;

import com.remedios.joao.curso.Curso.entites.usuario.Repository.UsuarioRepository;
import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import com.remedios.joao.curso.Curso.entites.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import java.util.Optional;

import java.util.ArrayList;

@Component

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return  service.getByEmail(email);
    }
}
