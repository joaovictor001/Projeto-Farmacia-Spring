package com.remedios.joao.curso.Curso.security.services;


import com.remedios.joao.curso.Curso.entites.usuario.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService service;

    /*

     Este método é utilizado para carregar os detalhes do usuário a partir de um nome de usuário fornecido.

     Quando um usuário envia suas credenciais (como nome de usuário e senha) para o sistema,
     o Spring Security precisa verificar se essas credenciais estão corretas e,
     em seguida, autenticar o usuário. Para fazer isso,
     ele chama o método loadUserByUsername para carregar os detalhes do usuário com base no nome de usuário fornecido.

    */

    /*

    O método loadUserByUsername então utiliza o UsuarioService para buscar os detalhes
    do usuário com o nome de usuário "joao" no banco de dados e retorna esses detalhes encapsulados
    em um objeto que implementa a interface UserDetails.
    O Spring Security então usa esses detalhes para verificar as credenciais fornecidas pelo usuário
    e determinar se o login é bem-sucedido.

     */

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return service.getByEmail(email);
    }
}
