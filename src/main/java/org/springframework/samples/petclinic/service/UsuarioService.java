package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Alumno;
import org.springframework.samples.petclinic.model.Profesor;
import org.springframework.samples.petclinic.model.Tutor;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UsuarioService {
	
	private AlumnoService alumnoService;
	private ProfesorService profesorService;
	private TutorService tutorService;
	
	@Autowired
	public UsuarioService(AlumnoService alumnoService, ProfesorService profesorService, TutorService tutorService) {
		this.alumnoService = alumnoService;
		this.profesorService = profesorService;
		this.tutorService = tutorService;
	}
	
	public String typeOfUser(String nickUsuario, String contraseya) {
		String type = "Username not exist";
		Alumno a = alumnoService.getAlumno(nickUsuario);
		if(a!=null && a.getFechaMatriculacion()!=null) { // Si se cumple esta condición, quiere decir que el username existe entre los alumnos registrados
			type = a.getContraseya().equals(contraseya) ? "alumno":"Incorrect password";
		}
		Profesor p = profesorService.getProfesor(nickUsuario);
		if(p!=null) { // Si se cumple esta condición, quiere decir que el username existe entre los profesores registrados
			type = p.getContraseya().equals(contraseya) ? "profesor":"Incorrect password";
		}
		Tutor t = tutorService.getTutor(nickUsuario);
		if(t!=null && t.getFechaMatriculacion()!=null) { // Si se cumple esta condición, quiere decir que el username existe entre los tutores registrados
			type = t.getContraseya().equals(contraseya) ? "tutor":"Incorrect password";
		}
		log.info("Type of user: "+type);
		return type;
	}
	
}
