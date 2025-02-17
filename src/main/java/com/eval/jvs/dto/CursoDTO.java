package com.eval.jvs.dto;

import java.util.List;

import com.eval.jvs.model.Estudiante;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {
    private int id;
    
    @NotNull
    private String nombre;

    @NotNull
    private String siglas;

    @NotNull
    private boolean estado;
    
    @NotNull
    private List<Estudiante> estudiantes;

}
