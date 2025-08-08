package com.umg.gestionacademica.service;

import com.umg.gestionacademica.entity.Profesor;
import com.umg.gestionacademica.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public Profesor crear(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> obtenerPorId(Long id) {
        return profesorRepository.findById(id);
    }

    public Profesor actualizar(Integer id, Profesor profesor) {
        profesor.setId(id);
        return profesorRepository.save(profesor);
    }

    public void eliminar(Long id) {
        profesorRepository.deleteById(id);
    }
}
