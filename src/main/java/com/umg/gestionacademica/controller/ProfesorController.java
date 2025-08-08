package com.umg.gestionacademica.controller;

import com.umg.gestionacademica.entity.Profesor;
import com.umg.gestionacademica.service.ProfesorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping
    public Profesor crear(@RequestBody Profesor profesor) {
        return profesorService.crear(profesor);
    }

    @GetMapping
    public List<Profesor> obtenerTodos() {
        return profesorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Profesor obtenerPorId(@PathVariable Long id) {
        return profesorService.obtenerPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Profesor actualizar(@PathVariable Integer id, @RequestBody Profesor profesor) {
        return profesorService.actualizar(id, profesor);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
    }
}
