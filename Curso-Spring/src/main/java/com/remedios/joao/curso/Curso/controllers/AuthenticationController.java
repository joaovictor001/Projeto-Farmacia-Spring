package com.remedios.joao.curso.Curso.controllers;

import com.remedios.joao.curso.Curso.Secutiry.AuthenticationService;
import com.remedios.joao.curso.Curso.Secutiry.AuthorizaionService;
import com.remedios.joao.curso.Curso.Secutiry.TokenService;
import com.remedios.joao.curso.Curso.Secutiry.dtos.*;
import com.remedios.joao.curso.Curso.entites.usuario.Repository.UsuarioRepository;
import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import com.remedios.joao.curso.Curso.entites.usuario.dtos.UsuarioCreateDTO;
import com.remedios.joao.curso.Curso.entites.usuario.dtos.UsuarioDetailsDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor

public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AuthorizaionService authorizaionService;





    @PostMapping("/login")
    @Transactional
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AuthenticationDTO dados){
        System.out.println("Print controller " + authenticationService.loginAndCreateToken(dados));

        return new ResponseEntity<>(authenticationService.loginAndCreateToken(dados), HttpStatus.OK);
    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity<UsuarioDetailsDTO> register(@RequestBody @Valid UsuarioCreateDTO dados){
        return new ResponseEntity<>(authorizaionService.register(dados), HttpStatus.OK);
    }
}
