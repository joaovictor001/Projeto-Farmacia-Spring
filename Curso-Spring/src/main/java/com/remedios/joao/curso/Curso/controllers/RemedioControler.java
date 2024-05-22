package com.remedios.joao.curso.Curso.controllers;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.DadosAtualizarRemedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.OutDadosCadastroRemedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.InDadosCadastroRemedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Remedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Repository.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Para passar informçoes como o remedeio por meio de requisição é preciso cria um DTO(Model de dados).
    //Onde vou informar os atributos que eu vou pedir.
    //casso haja algo erro no post o Trasactional da um rollback nao enviando imformaçoes quebradas.
    @Transactional
    public void cadastrar(@RequestBody @Valid InDadosCadastroRemedio dados){
        repository.save(new Remedio(dados));
    }

    @GetMapping
    public List<OutDadosCadastroRemedio> listar(){
        return repository.findAll().stream().map(OutDadosCadastroRemedio::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarRemedio dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }



}
