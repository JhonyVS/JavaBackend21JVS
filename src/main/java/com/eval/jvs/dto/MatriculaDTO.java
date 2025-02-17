package com.eval.jvs.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.eval.jvs.model.DetalleMatricula;
import com.eval.jvs.model.Estudiante;
import com.fasterxml.jackson.annotation.JsonInclude;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {


    private int id;

    @NotNull
    private LocalDateTime fecha;

    @NotNull
    private Estudiante estudiante;

    @NotNull
    private List<DetalleMatricula> detalles;

    @NotNull
    private boolean estado;

}
