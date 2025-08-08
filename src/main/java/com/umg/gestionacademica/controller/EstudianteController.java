package com.umg.gestionacademica.controller;

import com.umg.gestionacademica.entity.Estudiante;
import com.umg.gestionacademica.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping
    public ResponseEntity<Estudiante> crear(@RequestBody Estudiante estudiante) {
        return ResponseEntity.ok(estudianteService.crear(estudiante));
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodos() {
        return ResponseEntity.ok(estudianteService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerPorId(@PathVariable Integer id) {
        return estudianteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizar(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
        if (!estudianteService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estudianteService.actualizar(id, estudiante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        if (!estudianteService.obtenerPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        estudianteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
