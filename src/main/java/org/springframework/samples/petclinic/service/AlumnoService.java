package org.springframework.samples.petclinic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Alumno;
import org.springframework.samples.petclinic.model.TipoCurso;
import org.springframework.samples.petclinic.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {
	
	AlumnoRepository alumnoRepository;
	
	@Autowired
	public AlumnoService(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}
	
	public List<Alumno> getStudentsPerGroup(String nombreGrupo) {
        return alumnoRepository.findByGroup(nombreGrupo);
    }

	public List<Alumno> getAllAlumnos() {
		return alumnoRepository.findStudents();
	}
	//esta es la otra mia 
	public Alumno getAlumno(String nickUsuario) {
		return alumnoRepository.findByNick(nickUsuario);
	}
	
	@Transactional	
	public void deleteStudents(Alumno alumno) {
		alumnoRepository.delete(alumno);
	}
	//esta es una mia 
	@Transactional
	public Alumno saveAlumno(Alumno alumno) throws DataAccessException {
		return alumnoRepository.save(alumno);		
	}		

    public List<Alumno> getStudentsByCourse(TipoCurso cursoDeIngles){
        return alumnoRepository.findStudentsByCourse(cursoDeIngles);
    }
   
    public List<Alumno>getAllMyStudents(String nickTutor){
    	return alumnoRepository.findStudentsByTutor(nickTutor);
    }
     
    
    
}

