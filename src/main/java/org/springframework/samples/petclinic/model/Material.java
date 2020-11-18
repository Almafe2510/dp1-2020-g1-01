package org.springframework.samples.petclinic.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data 
@Table(name="materiales")
public class Material extends BaseEntity{
	
	@Enumerated(EnumType.STRING)
    @Column(name="tipo_material")
    private TipoMaterial tipoMaterial;

    @Column(name="nombre_material")
    private String nombreMaterial;

    @ManyToOne
    @JoinColumn(name="nick_usuario")
    private Profesor profesor;
    
    @OneToMany(mappedBy = "materiales")
    private List<Feedback> feedbacks;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "material_alumno", joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "nick_usuario"))
	private Set<Alumno> alumnos;
    
    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "curso_material", joinColumns = @JoinColumn(name = "id"),
			inverseJoinColumns = @JoinColumn(name = "curso_de_ingles"))
	private Set<Curso> cursos;
}