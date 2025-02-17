package com.eval.jvs.controller;

import java.util.List;
import java.util.Map;

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

import com.eval.jvs.dto.CursoDTO;
import com.eval.jvs.model.Curso;
import com.eval.jvs.model.Estudiante;
import com.eval.jvs.record.GenericResponse;
import com.eval.jvs.service.ICursoService;
import com.eval.jvs.util.MapperUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<GenericResponse<CursoDTO>> findAll() throws Exception {

        List<CursoDTO> list = mapperUtil.mapList(service.findAll(), CursoDTO.class);

        return new ResponseEntity<>(new GenericResponse<>(200,"success", list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> findById (@PathVariable("id") int id) throws Exception{
        Curso curso = service.findById(id);

        return new ResponseEntity<>(new GenericResponse<>(200, "success", List.of(mapperUtil.map(curso, CursoDTO.class))),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse<CursoDTO>> save (@RequestBody CursoDTO cursoDto) throws Exception {
        Curso curso = service.save(mapperUtil.map(cursoDto, Curso.class));

        return new ResponseEntity<>(new GenericResponse<>(201, "created", List.of(mapperUtil.map(curso, CursoDTO.class))),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> update (@RequestBody CursoDTO cursoDto, @PathVariable("id") int id) throws Exception {
        Curso curso = service.update(mapperUtil.map(cursoDto, Curso.class), id);

        return new ResponseEntity<>(new GenericResponse<>(200, "success", List.of(mapperUtil.map(curso, CursoDTO.class))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) throws Exception{
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Mostrar la relación de cursos matriculados y sus estudiantes correspondientes usando programación funcional 
     * (sugerencia, usar un Map<K,V>)
     */
    @GetMapping("/relacion-estudiantes")
    public ResponseEntity<GenericResponse<Map<String, List<Estudiante>>>> getRelacionCursoEstudiantes() throws Exception{
        Map<String, List<Estudiante>> map = service.obtenerCursosConEstudiantes();
        return new ResponseEntity<>(new GenericResponse<>(200, "success", List.of(map)),HttpStatus.OK);
    }

}
