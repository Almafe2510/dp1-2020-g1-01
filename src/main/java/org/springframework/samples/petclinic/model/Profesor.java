package org.springframework.samples.petclinic.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="profesores")
public class Profesor extends Usuario{
	@OneToMany(mappedBy = "profesor")
    private List<Material> materiales;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profesor_grupo", joinColumns = @JoinColumn(name = "nick_usuario"),
			inverseJoinColumns = @JoinColumn(name = "nombre_grupo"))
	private Set<Grupo> grupos;
}
