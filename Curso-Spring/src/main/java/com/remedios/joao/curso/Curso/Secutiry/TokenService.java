package com.remedios.joao.curso.Curso.Secutiry;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
@Service

public class TokenService {

    //Essa é a chave que informa que o token esta sendo sgerado por essa aplicação.
    @Value("${api.security.token.secret}")
    private String secret;

    public  String generateToken(Usuario user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    //Vai indicar quem que ra emitindo esse token
                    .withIssuer("login-auth-api")
                    //Para quem vai o token
                    .withSubject(user.getEmail())
                    //Tempo para expirar o token
                    .withExpiresAt(this.generatedExpiratioDate())
                    .sign(algorithm);
            return  token;


        }catch (JWTCreationException exception){
            throw new RuntimeException("erro while authentication");
        }
    }
    public String validateToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secret);
            //criar o corpo de resposta da vilidação
            return JWT.require(algorithm)
                    .withIssuer("login-ath-api")
                    .build()
                    .verify(token)
                    //Vai pegar  o Subject que passamos la em cima
                    .getSignature();


        }catch (JWTVerificationException exception){
            return  null;
        }

    }
    private Instant generatedExpiratioDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}