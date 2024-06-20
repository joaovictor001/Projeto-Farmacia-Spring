package com.remedios.joao.curso.Curso.entites.usuario;

import com.remedios.joao.curso.Curso.entites.usuario.dtos.UsuarioCreateDTO;
import com.remedios.joao.curso.Curso.entites.usuario.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "Usuario")
@Entity(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of  = "id")


public class Usuario implements UserDetails {
    // A anotação id so indica para o banco quem é a chave primaria

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private  String email;
    private  String password;
    private boolean ativo;

    @Enumerated(EnumType.STRING)
    private Role role;


    public Usuario(UsuarioCreateDTO dados, String encrypPassword){
        this.name = dados.name();
        this.email = dados.email();
        this.password = encrypPassword;
        this.ativo = true;
        this.role= Role.ROLE_USER;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == Role.ROLE_ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_MANAGER"), new SimpleGrantedAuthority("ROLE_USER"));

        else if (this.role == Role.ROLE_MANAGER) return List.of(new SimpleGrantedAuthority("ROLE_MANAGER"), new SimpleGrantedAuthority("ROLE_USER"));

        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
