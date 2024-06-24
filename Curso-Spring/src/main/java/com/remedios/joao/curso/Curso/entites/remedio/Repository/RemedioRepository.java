package com.remedios.joao.curso.Curso.entites.remedio.Repository;

import com.remedios.joao.curso.Curso.entites.remedio.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RemedioRepository extends JpaRepository<Remedio,Long> {
    List<Remedio>findAllByAtivoTrue();

    List<Remedio> findAllByAtivoFalse();
}
