package com.umg.gestionacademica.repository;

import com.umg.gestionacademica.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}

