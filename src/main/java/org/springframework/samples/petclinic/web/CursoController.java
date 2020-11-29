package org.springframework.samples.petclinic.web;

import java.util.List;
import java.util.logging.Logger;

import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Curso;
import org.springframework.samples.petclinic.service.CursoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonCreator;


@RestController
@CrossOrigin("*")
@RequestMapping("/course")
public class CursoController {
	
	private final static Logger LOGGER = Logger.getLogger("");

    @Autowired
    CursoService cursoService;


    @GetMapping("/all")
    public List<Curso> getAllCourses(){
    	JSONObject res = new JSONObject();
    	
        return cursoService.allCourses();
    }
 
}