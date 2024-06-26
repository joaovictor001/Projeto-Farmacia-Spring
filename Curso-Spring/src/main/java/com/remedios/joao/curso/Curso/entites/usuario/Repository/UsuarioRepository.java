package com.remedios.joao.curso.Curso.entites.usuario.Repository;

import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario , Long> {

    Usuario findByEmail(String email);
    Usuario findByName(String name);
    List<Usuario> findAllByAtivoTrue();
}
