package com.eval.jvs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

import com.eval.jvs.dto.EstudianteDTO;
import com.eval.jvs.model.Estudiante;
import com.eval.jvs.record.GenericResponse;
import com.eval.jvs.service.IEstudianteService;
import com.eval.jvs.util.MapperUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {
    private final IEstudianteService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<EstudianteDTO>> findAll() throws Exception {
        List<EstudianteDTO> list = mapperUtil.mapList(service.findAll(),EstudianteDTO.class);
        return new ResponseEntity<>( new GenericResponse<>(200, "success", list),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EstudianteDTO>> findById (@PathVariable("id") int id) throws Exception{
        EstudianteDTO estudianteDTO = mapperUtil.map(service.findById(id),EstudianteDTO.class);

        return new ResponseEntity<>(new GenericResponse<>(200, "success", List.of(estudianteDTO)),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<EstudianteDTO>> save (@Valid @RequestBody EstudianteDTO estudiante) throws Exception {
        Estudiante est = service.save(mapperUtil.map(estudiante,Estudiante.class));
        return new ResponseEntity<>(new GenericResponse<>(201, "success", List.of(mapperUtil.map(est, EstudianteDTO.class))),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<EstudianteDTO>> update (@Valid @RequestBody EstudianteDTO estudiante, @PathVariable("id") int id) throws Exception {
        Estudiante est = service.update(mapperUtil.map(estudiante,Estudiante.class),id);

        return new ResponseEntity<>(new GenericResponse<>(200, "success", List.of(mapperUtil.map(est, EstudianteDTO.class))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<Void>> deleteById(@PathVariable("id") int id) throws Exception{
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Listar estudiantes ordenados de forma descendente por edad usando programación funcional
     */
    @GetMapping("/por-edad-desc")
    public ResponseEntity<GenericResponse<EstudianteDTO>> getEstudiantesPorEdadDesc() throws Exception{
        List<Estudiante> estudiantes = mapperUtil.mapList(service.getEstudiantesPorEdadDesc(), Estudiante.class);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", mapperUtil.mapList(estudiantes, EstudianteDTO.class)), HttpStatus.OK);
    }

}
