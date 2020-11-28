package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Alumno;
import org.springframework.samples.petclinic.service.AlumnoService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/tutor/{nickTutor}")
public class TutorController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/allMyStudents")
    public List<Alumno>getStudentsByTutor(@PathVariable("nickTutor") String nickTutor){
        return alumnoService.getAllMyStudents(nickTutor);
    }
}