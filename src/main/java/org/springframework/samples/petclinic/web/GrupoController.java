package org.springframework.samples.petclinic.web;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Alumno;
import org.springframework.samples.petclinic.model.Curso;
import org.springframework.samples.petclinic.model.Grupo;
import org.springframework.samples.petclinic.service.AlumnoService;
import org.springframework.samples.petclinic.service.GrupoService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
@RequestMapping("/grupos")
public class GrupoController {
	

	//private static final String vista = "grupos/list";
	//private static final String VIEWS_GROUPS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
	private final GrupoService grupoService;
	private final AlumnoService alumnoService;
	private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.control");
	
	@Autowired
	public GrupoController(GrupoService grupoService, AlumnoService alumnoService) {
		this.grupoService = grupoService;
		this.alumnoService = alumnoService;
	}
	
	@GetMapping("/all")
	public List<Grupo> listaGrupos() {
		return grupoService.findAll().stream().collect(Collectors.toList());
		
	}
	
	@GetMapping("/{curso}")
	public List<Grupo> listaGruposPorCurso(@PathVariable("curso") String curso) {
		return grupoService.findAll().stream().filter(x->x.getCursos().getCursoDeIngles()
				.toString().equals(curso)).collect(Collectors.toList());
	}
	
	@GetMapping(value="/getByNameOfGroup/{nombreGrupo}")	
	public List<Alumno> getPersonasByNameOfGroup(@PathVariable("nombreGrupo") String nombreGrupo){
        return alumnoService.getStudentsPerGroup(nombreGrupo);
    }
	
	@GetMapping(value = "/{nick_usuario}/edit/{nombreGrupo}")
    public void processUpdateStudentGroup(@PathVariable("nick_usuario") String nick_usuario, @PathVariable("nombreGrupo") String nombreGrupo) {
        	Alumno alumno1= alumnoService.findById(nick_usuario);
        	Grupo grupo= grupoService.getCourseById(nombreGrupo);       
            alumno1.setGrupos(grupo);
            this.alumnoService.saveAlumno(alumno1);
    }
	
	
	
	

}
