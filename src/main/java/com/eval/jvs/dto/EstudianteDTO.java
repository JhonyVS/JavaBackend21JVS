package com.eval.jvs.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {
    

    private int id;

    @NotNull
    @Size(min = 3 ,max = 20)
    private String nombres;

    @NotNull
    @Size(min = 3 ,max = 20)
    private String apellidos;

    @NotNull
    @Size(min = 7 ,max = 16)
    private String dni;

    @NotNull
    @Min(value = 0)
    @Max(value = 150)
    private int edad;
}
