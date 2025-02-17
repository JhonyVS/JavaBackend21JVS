package com.eval.jvs.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eval.jvs.model.Curso;
import com.eval.jvs.model.Estudiante;
import com.eval.jvs.repository.ICursoRepository;
import com.eval.jvs.repository.IDetalleMatriculaRepository;
import com.eval.jvs.repository.IGenericRepostory;
import com.eval.jvs.service.ICursoService;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso,Integer> implements ICursoService{

    private final ICursoRepository repository;
    private final IDetalleMatriculaRepository detalleMatriculaRepository;

    @Override
    protected IGenericRepostory<Curso, Integer> getRepository() {
        return repository;
    }

    @Override
    public Map<String, List<Estudiante>> obtenerCursosConEstudiantes() {
        return detalleMatriculaRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(
                    detalle -> detalle.getCurso().getNombre(), 
                    Collectors.mapping(detalle -> detalle.getMatricula().getEstudiante(), Collectors.toList())
            ));
    }
    
    
}
