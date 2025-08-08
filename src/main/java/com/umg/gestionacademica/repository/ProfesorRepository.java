package com.umg.gestionacademica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umg.gestionacademica.entity.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}

