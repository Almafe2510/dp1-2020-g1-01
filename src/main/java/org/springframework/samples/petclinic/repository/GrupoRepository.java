package org.springframework.samples.petclinic.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Grupo;

public interface GrupoRepository extends CrudRepository<Grupo, String>{		
	public Set<Grupo> findAll();
		
	@Query("SELECT g FROM Grupo g JOIN g.cursos c WHERE c.cursoDeIngles = :curso")
	public List<Grupo> findByCurso(@Param("curso")String curso);
	
	@Query("SELECT g.nombreGrupo FROM Grupo g")
	public List<String> findAllGroupNames();
	
//	@Query(value="SELECT g.nombreGrupo FROM Grupo g JOIN Alumno a WHERE a.grupos.nombreGrupo = g.nombreGrupo")
	@Query(value="select distinct g.nombre_grupo from grupos g join alumnos a where a.grupos_nombre_grupo != g.nombre_grupo", nativeQuery=true)
	public List<String> findAllEmptyGroups();
}