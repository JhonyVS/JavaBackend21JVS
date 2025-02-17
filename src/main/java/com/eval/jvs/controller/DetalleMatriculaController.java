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

import com.eval.jvs.dto.DetalleMatriculaDTO;
import com.eval.jvs.model.DetalleMatricula;
import com.eval.jvs.record.GenericResponse;
import com.eval.jvs.service.IDetalleMatriculaService;
import com.eval.jvs.util.MapperUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/detalles")
@RequiredArgsConstructor
public class DetalleMatriculaController {

    private final IDetalleMatriculaService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<DetalleMatriculaDTO>> findAll() throws Exception {
        List<DetalleMatriculaDTO> list = mapperUtil.mapList(service.findAll(),DetalleMatriculaDTO.class);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", list),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<DetalleMatriculaDTO>> findById (@PathVariable("id") int id) throws Exception{
        DetalleMatriculaDTO detalleMatricula = mapperUtil.map(service.findById(id), DetalleMatriculaDTO.class);
        return new ResponseEntity<>( new GenericResponse<>(200, "success", List.of(detalleMatricula)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<DetalleMatriculaDTO>> save (@Valid @RequestBody DetalleMatriculaDTO detalleMatriculaDTO) throws Exception {
        DetalleMatricula detalleMatricula = service.save(mapperUtil.map(detalleMatriculaDTO, DetalleMatricula.class));
        return new ResponseEntity<>(new GenericResponse<>(201, "success", List.of(mapperUtil.map(detalleMatricula,DetalleMatriculaDTO.class))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<DetalleMatriculaDTO>> update (@Valid @RequestBody DetalleMatriculaDTO detalleMatriculaDTO, @PathVariable("id") int id) throws Exception {
        DetalleMatricula detalleMatricula = service.update(mapperUtil.map(detalleMatriculaDTO,DetalleMatricula.class), id);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", List.of(mapperUtil.map(detalleMatricula,DetalleMatriculaDTO.class))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) throws Exception{
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
