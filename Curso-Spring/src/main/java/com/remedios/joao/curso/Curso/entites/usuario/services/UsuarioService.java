package com.remedios.joao.curso.Curso.entites.usuario.services;

import com.remedios.joao.curso.Curso.Secutiry.dtos.AutheticationRegisterDTO;
import com.remedios.joao.curso.Curso.entites.usuario.Repository.UsuarioRepository;
import com.remedios.joao.curso.Curso.entites.usuario.Usuario;
import com.remedios.joao.curso.Curso.entites.usuario.dtos.UsuarioDetailsDTO;
import com.remedios.joao.curso.Curso.infra.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.List;

public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public UserDetails getByEmail(String email){
        UserDetails user = repository.findByEmail(email);

        if(user == null){
            throw new BadCredentialsException("Usuario na existe");
        }

        System.out.println("Usuario Service" + user.getUsername());
        return user;
    }


    public List<UsuarioDetailsDTO> getAll() {
        return this.repository.findAllByAtivoTrue().stream().map(UsuarioDetailsDTO::new).toList();
    }

    // SALVAR NO BANCO

    public void save(Usuario usuario) {

        if (repository.findByEmail(usuario.getEmail()) != null) {
            throw new IllegalArgumentException("This email is already being used!");
        }
        if(repository.findByName(usuario.getName()) != null){
            throw new IllegalArgumentException("This name is already begin used!");
        }
        this.repository.save(usuario);
    }

    // DESATIVAR USUÁRIO

    public UsuarioDetailsDTO inativar(Long id) {
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));

        usuario.setAtivo(false);

        return new UsuarioDetailsDTO(usuario);
    }

    // ATIVAR USUÁRIO

    public UsuarioDetailsDTO ativar(Long id) {
        Usuario usuario = this.repository.findById(id).orElseThrow(() -> new NotFoundException("User not found!"));

        usuario.setAtivo(true);

        return new UsuarioDetailsDTO(usuario);
    }


}
