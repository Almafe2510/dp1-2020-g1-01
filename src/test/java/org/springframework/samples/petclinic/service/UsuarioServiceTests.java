package org.springframework.samples.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.Alumno;
import org.springframework.samples.petclinic.model.Tutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioServiceTests {
	private static final Logger log = LoggerFactory.logger(UsuarioServiceTests.class);
	
	@Autowired
	protected UsuarioService usuarioService;
	
	@Autowired
	protected SolicitudService solicitudService;
	
	@BeforeAll
	@Transactional
	void insertAlumnoTutor() {
		Alumno alumno = new Alumno();
		alumno.setContraseya("HolaBuenas777");
		alumno.setCorreoElectronicoUsuario("javikuka7@gmail.com");
		alumno.setDireccionUsuario("Calle error");
		alumno.setDniUsuario("76766776Y");
		alumno.setFechaMatriculacion(null);
		alumno.setFechaNacimiento(null);
		alumno.setNickUsuario("JaviMartinez");
		alumno.setNombreCompletoUsuario("Javi Martínez");
		alumno.setNumTelefonoUsuario("635096767");
		alumno.setNumTareasEntregadas(4);
		solicitudService.saveAlumno(alumno);
		Tutor tutor = new Tutor();
		tutor.setContraseya("EyEyHola6");
		tutor.setCorreoElectronicoUsuario("pedro@gmail.com");
		tutor.setDireccionUsuario("Calle Lora");
		tutor.setDniUsuario("23232323H");
		tutor.setFechaNacimiento(null);
		tutor.setNickUsuario("PedroGar");
		tutor.setNombreCompletoUsuario("Pedro García");
		tutor.setNumTelefonoUsuario("676767453");
		solicitudService.saveTutor(tutor);
	}
	
	@Test
	@Transactional
	void testTypeShouldBeIntegrante() {
		String nickUsuario = "JaviMartinez";
		String contraseya = "HolaBuenas777";
		String type = usuarioService.typeOfUser(nickUsuario, contraseya);
		
		assertThat(type).isEqualTo("integrante");
	}
	
	@Test
	void testTypeShouldBeUsernameNotExist() {
		String nickUsuario = "--------ImposibleQueExistaError---------";
		String contraseya = "prueba";
		String type = usuarioService.typeOfUser(nickUsuario, contraseya);
		
		assertThat(type).isEqualTo("Username not exist");
	}
	
	@Test
	@Transactional
	void testTypeShouldBeTutor() {
		String nickUsuario = "PedroGar";
		String contraseya = "EyEyHola6";
		String type = usuarioService.typeOfUser(nickUsuario, contraseya);
		
		assertThat(type).isEqualTo("tutor");
	}
	
	@Test
	@Transactional
	void testTypeShouldBeIncorrectPassword() {
		String nickUsuario = "JaviMartinez";
		String contraseya = "noExiste";
		String contraseyaNoExistente = contraseya.concat("noExiste");
		String type = usuarioService.typeOfUser(nickUsuario, contraseyaNoExistente);
		
		assertThat(contraseya).isNotEqualTo(contraseyaNoExistente);
		assertThat(type).isEqualTo("Incorrect password");
	}

}
