package com.remedios.joao.curso.Curso.controllers.entites.medico.Repository;

import com.remedios.joao.curso.Curso.controllers.entites.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface MedicoRepository extends JpaRepository<Medico,Long> {
    List<Medico>findAllByAtivoTrue();
}
