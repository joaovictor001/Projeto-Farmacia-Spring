package com.remedios.joao.curso.Curso.security.services;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;

import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Service
public class TokenService {

    // Indica que estamos utilizando o valor definido em 'properties'

    @Value("${api.security.token.secret}")
    private String secret;

    private static final Logger logger = LoggerFactory.getLogger(TokenService.class);

    public String gerarToken(Usuario usuario) throws JWTCreationException{

        try {
            return JWT
                    .create()
                    .withIssuer("remedios_api")
                    .withSubject(usuario.getEmail())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(Expirar())
                    .sign(Algorithm.HMAC256(secret));
        }
        catch (JWTCreationException e){
            logger.error("Erro ao gerar o token!", e);
            throw new RuntimeException("Erro ao gerar o token", e);
        }
    }

    public String getSubject(String tokenJWT) throws JWTCreationException, JWTDecodeException{

        try {
            return JWT
                    .require(Algorithm.HMAC256(secret))
                    .withIssuer("remedios_api")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }

        catch (TokenExpiredException e ){
            throw new TokenExpiredException("Token Expirado!", e.getExpiredOn());
        }
    }


    private Instant Expirar() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}
