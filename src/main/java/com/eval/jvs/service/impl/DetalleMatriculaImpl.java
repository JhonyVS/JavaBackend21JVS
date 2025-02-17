package com.eval.jvs.service.impl;

import org.springframework.stereotype.Service;

import com.eval.jvs.model.DetalleMatricula;
import com.eval.jvs.repository.IDetalleMatriculaRepository;
import com.eval.jvs.repository.IGenericRepostory;
import com.eval.jvs.service.IDetalleMatriculaService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class DetalleMatriculaImpl extends CRUDImpl <DetalleMatricula,Integer> implements IDetalleMatriculaService{

    private final IDetalleMatriculaRepository repository;

    @Override
    protected IGenericRepostory<DetalleMatricula, Integer> getRepository() {
        return repository;
    }
    
}
