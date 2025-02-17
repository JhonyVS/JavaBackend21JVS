package com.eval.jvs.service;

import java.util.List;
import java.util.Map;

import com.eval.jvs.model.Curso;
import com.eval.jvs.model.Estudiante;

public interface ICursoService extends ICRUD<Curso,Integer>{
    Map<String, List<Estudiante>> obtenerCursosConEstudiantes();
}
