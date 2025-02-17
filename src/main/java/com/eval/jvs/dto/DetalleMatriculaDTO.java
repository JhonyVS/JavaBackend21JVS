package com.eval.jvs.dto;

import com.eval.jvs.model.Curso;
import com.eval.jvs.model.Matricula;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DetalleMatriculaDTO {


    private int id;

    @NotNull
    private Matricula matricula;

    @NotNull
    private Curso curso;

    @NotNull
    @Size(min = 3 ,max = 20)
    private String aula;
}
