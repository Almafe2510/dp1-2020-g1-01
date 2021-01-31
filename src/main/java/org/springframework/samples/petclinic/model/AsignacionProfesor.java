package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="asignaciones_profesor")
public class AsignacionProfesor {
	
	@EmbeddedId
	private AsignacionProfesorKey id;
	
	@ManyToOne(optional=false)
    @MapsId("nickProfesor")
	private Profesor profesor;
	
	@ManyToOne(optional=true)
    @MapsId("nombreGrupo")
	private Grupo grupo;
	
	@Column(name="fecha_asignacion")
	private LocalDate fecha;
}
