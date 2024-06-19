package com.remedios.joao.curso.Curso.entites.usuario.services;

import com.remedios.joao.curso.Curso.Secutiry.dtos.AutheticationRegisterDTO;
import com.remedios.joao.curso.Curso.entites.usuario.Repository.UsuarioRepository;
import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsusarioServiseImpl implements UserDetailsService {
    @Autowired
    private UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return service.getByEmail(email);
    }
}
