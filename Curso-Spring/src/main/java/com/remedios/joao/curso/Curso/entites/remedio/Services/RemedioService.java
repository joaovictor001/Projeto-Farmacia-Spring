package com.remedios.joao.curso.Curso.entites.remedio.Services;

import com.remedios.joao.curso.Curso.entites.remedio.Remedio;
import com.remedios.joao.curso.Curso.entites.remedio.Repository.RemedioRepository;
import com.remedios.joao.curso.Curso.entites.remedio.dtos.RemedioCreateDTO;
import com.remedios.joao.curso.Curso.entites.remedio.dtos.RemedioDetailDTO;
import com.remedios.joao.curso.Curso.entites.remedio.dtos.RemedioListDTO;
import com.remedios.joao.curso.Curso.entites.remedio.dtos.RemedioUpdateDTO;
import com.remedios.joao.curso.Curso.infra.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository repository;

    public RemedioDetailDTO create (RemedioCreateDTO dados){
        var remedio = new Remedio(dados);
        this.repository.save(remedio);
        return new RemedioDetailDTO(remedio);
    };
    public List<RemedioListDTO> getAll(){
        return this.repository.findAllByAtivoTrue().stream().map(RemedioListDTO::new).toList();

    }

    public RemedioDetailDTO getPorId(Long id){

        Remedio remedio  = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Remedio não encontrado.!"));
        if(!remedio.vereicar_status()){
            return null;
        }
        return new RemedioDetailDTO(remedio);
    }

    public RemedioDetailDTO update(long id, RemedioUpdateDTO dados){
        Remedio remedio = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Id Not Fund"));
        remedio.atualizarInformacoes(dados);

        return new RemedioDetailDTO(remedio);



    }

    public RemedioDetailDTO Inativar(Long id){
        Remedio remedio = this.repository.findById(id).orElseThrow(()-> new NotFoundException("id not found!"));
        remedio.inativar();
        return new RemedioDetailDTO(remedio);

    }

    public  RemedioDetailDTO Ativar(Long id ){
        Remedio remedio = this.repository.findById(id).orElseThrow(() -> new NotFoundException("Id not found!!!!"));
        remedio.ativar();
        return  new RemedioDetailDTO(remedio);
    }

}
