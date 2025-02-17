package com.eval.jvs.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Matricula implements Identifiable<Integer>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name="id_estudiante", nullable = false)
    private Estudiante estudiante;


    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<DetalleMatricula> detalles;

    private boolean estado;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

}
