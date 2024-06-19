package com.remedios.joao.curso.Curso.infra;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}