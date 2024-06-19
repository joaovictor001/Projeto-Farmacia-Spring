package com.remedios.joao.curso.Curso.Secutiry;

import com.remedios.joao.curso.Curso.Secutiry.dtos.AuthenticationDTO;
import com.remedios.joao.curso.Curso.Secutiry.dtos.TokenJwtDTO;
import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import com.remedios.joao.curso.Curso.entites.usuario.services.UsusarioServiseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthenticationService {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UsusarioServiseImpl userDetailService;

    public TokenJwtDTO loginAndCreateToken (AuthenticationDTO dados){
        String tokenJWT = tokenService.generateToken((Usuario) manager.authenticate(new UsernamePasswordAuthenticationToken(dados.email(), dados.senha())).getPrincipal());

        return  new TokenJwtDTO(tokenJWT);
    }
}
