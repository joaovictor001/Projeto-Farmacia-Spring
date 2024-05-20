package com.remedios.joao.curso.Curso.controllers.entites.remedio.Repository;

import com.remedios.joao.curso.Curso.controllers.entites.remedio.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio,Long> {
}
