package com.remedios.joao.curso.Curso.controllers;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.RemedioUpdateDTO;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.RemedioDetailDTO;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.RemedioListDTO;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.dtos.RemedioCreateDTO;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Remedio;
import com.remedios.joao.curso.Curso.controllers.entites.remedio.Repository.RemedioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController indica para o spring que essa é um aclase sping e precisa ser inicializada.
//@RequestMapping setar o meu endpoint da Api.

//Link Swagger => http://localhost:8081/swagger-ui/index.html#/
@RestController
@RequestMapping("/remedios")
@Tag(name = "remedios_api")
public class RemedioControler {
    @Autowired
    private RemedioRepository repository;


    //@PostMapping é o verbo que minha funcao vai usar
    //@RequestBody indica que eu vou passar um atributo durante minha requisição
    @PostMapping

    //Para passar informaçoes como o remedeio por meio de requisição é preciso cria um DTO(Model de dados).
    //Onde vou informar os atributos que eu vou pedir.
    // @Transactional: caso haja algo erro no post o Trasactional da um rollback nao enviando imformaçoes quebradas.
    @Transactional
    @Operation(summary = "Realiza o cadastro de remedios ", method = "POST")
    public void cadastrar(@RequestBody @Valid RemedioCreateDTO dados){
        repository.save(new Remedio(dados));
    }

    @GetMapping
    public  ResponseEntity<List<RemedioListDTO>> listar(){
        // A função findAll(boolean)(true or false) cria automatico para campos boolean so precisamos
        var lista =  repository.findAllByAtivoTrue().stream().map(RemedioListDTO::new).toList();
        return ResponseEntity.ok(lista);
    }


    @PutMapping
    @Transactional
    public ResponseEntity<RemedioDetailDTO> atualizar(@RequestBody @Valid RemedioUpdateDTO dados){
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);

        return  ResponseEntity.ok(new RemedioDetailDTO(remedio));
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable long id ){
        repository.deleteById(id);

        return  ResponseEntity.noContent().build();

    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }


    @PutMapping("ativar/{id}")
    @Transactional
    public ResponseEntity<Void> Reativar(@PathVariable long id){
        var ativacao = repository.getReferenceById(id);
        ativacao.ativar();

        return ResponseEntity.noContent().build();
    }






}
