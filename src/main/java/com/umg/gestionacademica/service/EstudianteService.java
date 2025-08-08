package com.umg.gestionacademica.service;

import com.umg.gestionacademica.entity.Estudiante;
import com.umg.gestionacademica.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public Estudiante crear(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> obtenerPorId(Integer id) {
        return estudianteRepository.findById(id);
    }

    public Estudiante actualizar(Integer id, Estudiante estudiante) {
        estudiante.setId(id);
        return estudianteRepository.save(estudiante);
    }

    public void eliminar(Integer id) {
        estudianteRepository.deleteById(id);
    }
}
