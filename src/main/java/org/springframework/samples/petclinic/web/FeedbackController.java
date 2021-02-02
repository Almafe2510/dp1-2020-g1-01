package org.springframework.samples.petclinic.web;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Alumno;
import org.springframework.samples.petclinic.service.FeedbackService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	private FeedbackService feedbackService;

	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		super();
		this.feedbackService = feedbackService;
	};
	
	@PutMapping("{idMaterial}/añadirAlumno")
	public ResponseEntity<?> añadirAlumnoAMaterial(@PathVariable("idMaterial") Integer idMaterial, @Valid @RequestBody Alumno alumno){
		log.info("he entrado en añadirAlumno");

		feedbackService.añadirAlumnoAMaterial(idMaterial,alumno);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/deleteMaterial/{idMaterial}")
	public ResponseEntity<?> deleteMaterial(@PathVariable("idMaterial") Integer idMaterial) throws IOException{
		log.info("Material con id:" + idMaterial);
		feedbackService.deleteMaterial(idMaterial);
		return ResponseEntity.ok().build();
	}
}
