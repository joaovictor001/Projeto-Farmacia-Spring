package com.remedios.joao.curso.Curso.controllers;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.InDadosCadastroRemedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Remedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Repository.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController indica para o spring que essa é um aclase sping e precisa ser inicializada.
//@RequestMapping setar o meu endpoint da Api.
@RestController
@RequestMapping("/remedios")
public class RemedioControler {
    @Autowired
    private RemedioRepository repository;


    //@PostMapping é o verbo que minha funcao vai usar
    //@RequestBody indica que eu vou passar um atributo durante minha requisição
    @PostMapping

    //Para passar informçoes como o remedeio por meio de requisição é preciso cria um DTO(Model de dados)
    //Onde vou informar os atributos que eu vou pedir.


    public void cadastrar(@RequestBody InDadosCadastroRemedio dados){
        repository.save(new Remedio(dados));
    }


}
