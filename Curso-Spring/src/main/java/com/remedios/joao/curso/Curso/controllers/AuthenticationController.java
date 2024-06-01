package com.remedios.joao.curso.Curso.controllers;

import com.remedios.joao.curso.Curso.Secutiry.TokenService;
import com.remedios.joao.curso.Curso.Secutiry.dtos.AuthenticationCreateDTO;
import com.remedios.joao.curso.Curso.Secutiry.dtos.AuthenticationDetailsDTO;
import com.remedios.joao.curso.Curso.Secutiry.dtos.AutheticationRegisterDTO;
import com.remedios.joao.curso.Curso.entites.usuario.Repository.UsuarioRepository;
import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import lombok.RequiredArgsConstructor;
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

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;


    @PostMapping("/login")
    @Transactional
    public ResponseEntity <AuthenticationDetailsDTO> login(@RequestBody AuthenticationCreateDTO dados){
        Usuario user = this.repository.findByEmail(dados.email());
        if(passwordEncoder.matches(dados.password(), user.getPassword())){
            String token  = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new AuthenticationDetailsDTO(user.getName(), token));

        }
        return  ResponseEntity.badRequest().build();



    }

    @PostMapping("/register")
    @Transactional
    public ResponseEntity <?> register(@RequestBody AutheticationRegisterDTO dados){
        Optional<Usuario> user = Optional.ofNullable(this.repository.findByEmail(dados.email()));
        if(user.isEmpty()){
            Usuario newUser = new Usuario();
            newUser.setPassword(passwordEncoder.encode(dados.password()));
            newUser.setEmail(dados.email());
            newUser.setName(dados.nome());
            this.repository.save(newUser);
            System.out.println("Cheguei aqui ante do token");

            String token = this.tokenService.generateToken(newUser);

            System.out.println("Cheguei aqui depois do token");
            return  ResponseEntity.ok(new AuthenticationDetailsDTO((newUser.getName()),token));
        }

        return  ResponseEntity.badRequest().build();
    }



}
