package com.eval.jvs.service;

import java.util.List;

import com.eval.jvs.model.Estudiante;

public interface IEstudianteService extends ICRUD<Estudiante,Integer>{
    List<Estudiante> getEstudiantesPorEdadDesc();
}
