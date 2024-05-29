package com.remedios.joao.curso.Curso.entites.usuario.Repository;

import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario , Long> {
    UserDetails findByLogin(String login);
}
