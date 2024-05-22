package com.remedios.joao.curso.Curso.controllers.entites.remedio.Repository;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface RemedioRepository extends JpaRepository<Remedio,Long> {
    List<Remedio>findAllByAtivoTrue();

    List<Remedio> findAllByAtivoFalse();
}
