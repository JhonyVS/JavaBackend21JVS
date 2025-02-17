package com.eval.jvs.service.impl;

import org.springframework.stereotype.Service;

import com.eval.jvs.model.Matricula;
import com.eval.jvs.repository.IGenericRepostory;
import com.eval.jvs.repository.IMatriculaRepository;
import com.eval.jvs.service.IMatriculaService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MatriculaServiceImpl extends CRUDImpl<Matricula,Integer> implements IMatriculaService{
    private final IMatriculaRepository repository;

    @Override
    protected IGenericRepostory<Matricula, Integer> getRepository() {
        return repository;
    }
}
