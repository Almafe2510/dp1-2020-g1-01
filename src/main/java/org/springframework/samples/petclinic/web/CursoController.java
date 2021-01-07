package org.springframework.samples.petclinic.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Curso;
import org.springframework.samples.petclinic.service.CursoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RequestMapping("/course")
public class CursoController {
	
    @Autowired
    CursoService cursoService;
    
//    @GetMapping("/all")
//    public List<Curso> getAllCourses(){
//    	return cursoService.allCourses();
//    }
//    
 
}