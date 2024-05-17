package com.remedios.joao.curso.Curso.controllers;

import com.remedios.joao.curso.Curso.remedio.DadosCadastroRemedio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController indica para o spring que essa é um aclase sping e precisa ser inicializada.0
//@RequestMapping setar o meu endpoint da Api.
@RestController
@RequestMapping("/remedios")
public class RemedioControler {


    //@PostMapping é o verbo que minha funcao vai usar
    //@RequestBody indica que eu vou passar um atributo durante minha requisição
    @PostMapping


    //Para passar informçoes como o remedeio por meio de requisição é preciso cria um DTO
    //Onde vou informar os atributos que eu vou pedir.


    public void cadastrar(@RequestBody DadosCadastroRemedio dados){
        System.out.println(dados);
    }
}
