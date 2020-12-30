package org.springframework.samples.petclinic.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Alumno;
import org.springframework.samples.petclinic.service.AlumnoService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/alumnos")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@Slf4j
public class AlumnoController {
	private static final Logger LOGGER = LoggerFactory.logger(SolicitudController.class);

	@Autowired
	AlumnoService alumnoServ;

	@PutMapping("/editStudent")
	public ResponseEntity<?> processUpdateAlumnoForm(@Valid @RequestBody Alumno alumno, BindingResult result, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		
    		LOGGER.info("El alumno es : " + alumno.getNickUsuario());
    		if (result.hasErrors()) {
    			LOGGER.info("Esto no funciona");
    			return new ResponseEntity<>(result.getFieldErrors(), HttpStatus.NON_AUTHORITATIVE_INFORMATION);
    		}
    		else {
    			LOGGER.info("Ha funcionado");
    			this.alumnoServ.saveAlumno(alumno);
    			return new ResponseEntity<>("Successful shipment", HttpStatus.CREATED);
    			
    		}
    	
    	
		
    }
    @GetMapping("/editStudentInfo")
    public ResponseEntity<?> getStudentInfo(@PathVariable("nickUsuario") String nickUsuario, 
    		HttpServletRequest request){
    	HttpSession session = request.getSession(false);
    	if(session != null && session.getAttribute("type") == "alumno") {
    		LOGGER.info("ESTO ESTA FUNCIONANDO");
    		Alumno alumno = alumnoServ.getAlumno(nickUsuario);
            return ResponseEntity.ok(alumno);
    	}else {
    		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    	}
    }

	@GetMapping("/all")
	public ResponseEntity<?> listAlumnos(HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		log.info("Has iniciado sesion como: "+ session.getAttribute("type"));
		if(session != null && session.getAttribute("type") == "profesor") {
			List<Alumno> allStudents = alumnoServ.getAllAlumnos();
			return ResponseEntity.ok(allStudents);
		}else {
			 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); 
		}
	}

	@GetMapping("/getByCourse/{course}")
	public ResponseEntity<?> listStudentsByCourse(@PathVariable("course") String cursoDeIngles, HttpServletRequest request) {
		HttpSession session = request.getSession(false);

		log.info("Has iniciado sesion como: "+ session.getAttribute("type"));
		if(session != null && session.getAttribute("type") == "profesor") {
			List<String> cursos = new ArrayList<String>();
			cursos.add("A1");
			cursos.add("A2");
			cursos.add("B1");
			cursos.add("B2");
			cursos.add("C1");
			cursos.add("C2");
			cursos.add("APRENDIZAJELIBRE");
			if (cursos.contains(cursoDeIngles)) {
				List<Alumno> allStudentsByCourse = alumnoServ.getStudentsByCourse(cursoDeIngles);
				return ResponseEntity.ok(allStudentsByCourse);
			} else {
				return ResponseEntity.notFound().build();
			}
		}else {
			 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); 

		}
	}

	@GetMapping("/{nombreGrupo}")
	public ResponseEntity<List<Alumno>> getPersonasByNameOfGroup(@PathVariable("nombreGrupo") String nombreGrupo) {
		List<Alumno> studentsByGroup = alumnoServ.getStudentsPerGroup(nombreGrupo);
		return ResponseEntity.ok(studentsByGroup);
	}

	// @GetMapping("/{nick_usuario}/edit/{nombreGrupo}")/*Aquí podemos usar el
	// servicio de grupo*/
	@PutMapping("/assignStudent")
	public ResponseEntity<?> assignStudent(@Valid Alumno alumno, BindingResult result, HttpServletResponse response) throws IOException
			 {
		if (result.hasErrors()) {
			LOGGER.info("Esto no funciona");
		}
		else {
			LOGGER.info("Ha funcionado");
			this.alumnoServ.saveAlumno(alumno);
			response.sendRedirect("http://localhost:3000");
		}
	    return ResponseEntity.ok().build();
    }
}
