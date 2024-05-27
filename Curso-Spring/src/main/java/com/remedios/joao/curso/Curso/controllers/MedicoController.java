package com.remedios.joao.curso.Curso.controllers;

import com.remedios.joao.curso.Curso.controllers.entites.medico.Medico;
import com.remedios.joao.curso.Curso.controllers.entites.medico.Repository.MedicoRepository;
import com.remedios.joao.curso.Curso.controllers.entites.medico.dto.MedicoCreateDTO;
import com.remedios.joao.curso.Curso.controllers.entites.medico.dto.MedicoDetailDTO;
import com.remedios.joao.curso.Curso.controllers.entites.medico.dto.MedicoListDTO;
import com.remedios.joao.curso.Curso.controllers.entites.medico.dto.MedicoUpdateDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/medico")

public class MedicoController {
    @Autowired
    private MedicoRepository repository ;


    @PostMapping
    @Transactional
    public ResponseEntity<MedicoDetailDTO> cadastra(@RequestBody @Valid  MedicoCreateDTO dados, UriComponentsBuilder UriBilder){
        var medico  = new Medico(dados);
        repository.save(medico);
        var uri  = UriBilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoDetailDTO(medico));
    }

    @GetMapping
    public List<MedicoListDTO> Get_medicos(){
        return repository.findAllByAtivoTrue().stream().map(MedicoListDTO::new).toList();
    }

    @PutMapping("{id}")
    public ResponseEntity<MedicoDetailDTO> atualizando(@PathVariable Long id, MedicoUpdateDTO dados){
        var medico  = repository.getReferenceById(id);
        medico.atualizar(dados);
        return ResponseEntity.ok(new MedicoDetailDTO(medico));


    }

    @PutMapping("ativar/{id}")
    @Transactional
    public void ativar(@PathVariable Long id ){
        var medico = repository.getReferenceById(id);
        medico.ativar();
    }
    @PutMapping("desativar/{id}")
    @Transactional
    public String desativar(@PathVariable Long id ){
        var medico = repository.getReferenceById(id);
        medico.desativar();
        return "perfil desativado";

    }


}
