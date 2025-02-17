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

import com.eval.jvs.dto.MatriculaDTO;
import com.eval.jvs.model.Matricula;
import com.eval.jvs.record.GenericResponse;
import com.eval.jvs.service.IMatriculaService;
import com.eval.jvs.util.MapperUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final IMatriculaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<MatriculaDTO>> findAll() throws Exception {
        List<MatriculaDTO> list = mapperUtil.mapList(service.findAll(), MatriculaDTO.class);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<MatriculaDTO>> findById (@PathVariable("id") int id) throws Exception{
        Matricula matricula = service.findById(id);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", List.of(mapperUtil.map(matricula, MatriculaDTO.class))), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<MatriculaDTO>> save (@RequestBody MatriculaDTO matricula) throws Exception {
        Matricula mat = service.save(mapperUtil.map(matricula, Matricula.class));
        return new ResponseEntity<>(new GenericResponse<>(201, "success", List.of(mapperUtil.map(mat, MatriculaDTO.class))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<MatriculaDTO>> update (@RequestBody MatriculaDTO matricula, @PathVariable("id") int id) throws Exception {
        Matricula mat = service.update(mapperUtil.map(matricula, Matricula.class), id);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", List.of(mapperUtil.map(mat, MatriculaDTO.class))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) throws Exception{
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
