package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="alumnos")

public class Alumno extends Usuario{
	
	@Column(name="num_tareas_entregadas")
	private Integer numTareasEntregadas;
	
	@Column(name="fecha_matriculacion")
	private String fechaMatriculacion;
	
    @ManyToOne(optional=true)
    private Tutor tutores;
    
    @ManyToOne(optional=false)
    private Grupo grupos;
}