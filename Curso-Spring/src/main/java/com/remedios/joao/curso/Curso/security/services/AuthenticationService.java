package com.remedios.joao.curso.Curso.security.services;

import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import com.remedios.joao.curso.Curso.security.dtos.AuthenticationDTO;
import com.remedios.joao.curso.Curso.security.dtos.TokenJwtDTO;
import com.remedios.joao.curso.Curso.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public TokenJwtDTO loginAndCreateToken(AuthenticationDTO dados){

        String tokenJWT = tokenService.gerarToken((Usuario) manager.authenticate(new UsernamePasswordAuthenticationToken(dados.email(), dados.senha())).getPrincipal());

        return new TokenJwtDTO(tokenJWT);
    }
}
