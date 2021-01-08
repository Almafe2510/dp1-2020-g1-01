package org.springframework.samples.petclinic.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Alumno;
import org.springframework.samples.petclinic.model.Curso;
import org.springframework.samples.petclinic.model.Evento;
import org.springframework.samples.petclinic.model.TipoCurso;
import org.springframework.samples.petclinic.service.AlumnoService;
import org.springframework.samples.petclinic.service.EventoService;
import org.springframework.samples.petclinic.util.DateEventValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/events")
public class EventoController {
	
	private final EventoService eventoService;
	private final AlumnoService alumService;
	
	@Autowired
	public EventoController(EventoService eventoService, AlumnoService alumService) {
		this.eventoService = eventoService;
		this.alumService = alumService;	
		}
	
	@InitBinder("evento")
	public void initEventoBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new DateEventValidator());
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllEvents(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("type") == "profesor") {
			return ResponseEntity.ok(eventoService.getAll());
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/getByCourse/{nick}")
	public ResponseEntity<?> getUserEvents(HttpServletRequest request, @PathVariable("nick") String nick) {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("type") == "alumno") {
			Alumno a = alumService.getAlumno(nick);
			Curso b = a.getGrupos().getCursos();
			return ResponseEntity.ok(eventoService.getByCourse(b));
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PutMapping("/update/{id}/{start}/{end}")
	public ResponseEntity<?> updateEvent(@PathVariable("id") Integer id, @PathVariable("start") String start,
			@PathVariable("end") String end, HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("type") == "profesor") {
			Evento evento = eventoService.updateDateEvent(id, start, end);
			if(evento == null) {
				return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
			}else {
				log.info("Event update: "+evento);
				return ResponseEntity.ok(evento);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@GetMapping("/description/{id}")
	public ResponseEntity<?> getDescription(@PathVariable("id") Integer id, HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("type") == "profesor" || session.getAttribute("type") == "alumno") {
			String description = eventoService.getDescription(id);
			if(description == null) {
				return new ResponseEntity<>("Event not found", HttpStatus.NOT_FOUND);
			}else {
				log.info("Event's description with id "+id+": "+description);
				return ResponseEntity.ok(description);
			}
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteDescription(@PathVariable("id") Integer id, HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("type") == "profesor") {
			eventoService.deleteDescription(id);
			log.info("Delete event");
			return ResponseEntity.ok(eventoService.getAll());
		}else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	@PostMapping("/create/{curso}")
	public ResponseEntity<?> create(@Valid @RequestBody Evento evento, BindingResult result, @PathVariable("curso") String curso, 
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("type") == "profesor") {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Evento>> violations = validator.validate(evento);
			if (!(curso.equals("null") || curso == "")) {
				Curso course = new Curso(); // poner en servicio
				course.setCursoDeIngles(TipoCurso.valueOf(curso));
				evento.setCurso(course);
			}
			if (result.hasErrors() || violations.size() > 0 || curso.equals("null") || curso == "") {
				List<FieldError> errors = new ArrayList<>();
				if (violations.size() > 0) {
					for (ConstraintViolation<Evento> v : violations) {
						FieldError e = new FieldError("evento", v.getPropertyPath().toString(), v.getMessageTemplate());
						errors.add(e);
					}
				}
				if (result.hasErrors()) {
					errors.addAll(result.getFieldErrors());
				}
				if (curso.equals("null") || curso == "") {
					FieldError e = new FieldError("evento", "curso", "You have to select a course");
					errors.add(e);
				}
				return new ResponseEntity<>(errors, HttpStatus.NON_AUTHORITATIVE_INFORMATION);
			} else {
				Boolean existEvent = eventoService.existEvent(evento);
				if (!existEvent) {
					Boolean existType = eventoService.assignTypeAndSave(evento, evento.getTipo().getTipo());
					if (existType) {
						log.info("New event with title: " + evento.getTitle());
						return new ResponseEntity<>("Successful creation", HttpStatus.CREATED);
					} else {
						log.info("Type not exist");
						return new ResponseEntity<>("Type not exist", HttpStatus.OK);
					}
				} else {
					log.info("Event Exist");
					return new ResponseEntity<>("The event already exists", HttpStatus.OK);
				}
			}
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

}
