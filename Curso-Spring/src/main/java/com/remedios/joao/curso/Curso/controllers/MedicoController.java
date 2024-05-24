package com.remedios.joao.curso.Curso.controllers;

import com.remedios.joao.curso.Curso.controllers.entites.medico.Medico;
import com.remedios.joao.curso.Curso.controllers.entites.medico.Repository.MedicoRepository;
import com.remedios.joao.curso.Curso.controllers.entites.medico.dto.MedicoCreateDTO;
import com.remedios.joao.curso.Curso.controllers.entites.medico.dto.MedicoListDTO;
import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/medico")

public class MedicoController {
    @Autowired
    private MedicoRepository repository ;




    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid  MedicoCreateDTO dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public List<MedicoListDTO> Get_medicos(){
        return repository.findAll().stream().map(MedicoListDTO::new).toList();
    }


}
