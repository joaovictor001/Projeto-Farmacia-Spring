package com.remedios.joao.curso.Curso.entites.usuario.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Role {

    ROLE_ADMIN("admin"),
    ROLE_MANAGER("manager"),
    ROLE_USER("user");

    private String role_name;

    Role(String role_name){
        this.role_name = role_name;
    }

    @JsonCreator
    public static Role fromString(String value){
        for(Role role : Role.values()){
            if(role.name().equalsIgnoreCase(value)){
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role: " + value);
    }
}
