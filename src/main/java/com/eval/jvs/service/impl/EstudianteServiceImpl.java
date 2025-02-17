package com.eval.jvs.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eval.jvs.model.Estudiante;
import com.eval.jvs.repository.IEstudianteRepository;
import com.eval.jvs.repository.IGenericRepostory;
import com.eval.jvs.service.IEstudianteService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante,Integer> implements IEstudianteService{

    private final IEstudianteRepository repository;

    @Override
    protected IGenericRepostory<Estudiante, Integer> getRepository() {
        return repository;
    }

    @Override
    public List<Estudiante> getEstudiantesPorEdadDesc() {
        return repository.findAll()
                        .stream()
                        .sorted(Comparator.comparingInt(Estudiante::getEdad).reversed())
                        .collect(Collectors.toList());
    }
    
}
