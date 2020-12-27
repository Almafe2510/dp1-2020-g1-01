package org.springframework.samples.petclinic.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.model.Premiado;
import org.springframework.samples.petclinic.service.PremiadoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/premiados")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class PremiadoController {
	
	@Autowired
	PremiadoService premiadoService;
	
	@GetMapping("/{fechaWall}")
	public List<Premiado> premiadosPorFecha(@PathVariable("fechaWall") String fechaWall){
		return premiadoService.premiadosPorFecha(fechaWall);
	}
	
	@GetMapping("/ultimaSemana")
	public String obtenerUltimaSemana() {
		return premiadoService.obtenerUltimaSemana();
	}
	
	@PostMapping(value="/añadirPremiado/{fechaWall}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void añadirPremiado(@PathVariable("fechaWall") String fechaWall,
            @RequestParam("photo") MultipartFile file, @RequestParam("nickUsuario") String nickUsuario, @RequestParam("description") String description){
        
		if(!file.isEmpty()) {
			Path directorioImagenes = Paths.get("src//main//resources//static//frontend//public/photosWall");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytes = file.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nickUsuario + ".jpg");

				premiadoService.insertarPremiado(nickUsuario, fechaWall, description);
				Files.write(rutaCompleta, bytes);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    }
	
	@PutMapping(value="/editarPremiado", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public void editarPremiado(@RequestParam(value = "photo", required = false) MultipartFile file, @RequestParam("id") Integer id, @RequestParam("description") String descripcion,
			 @RequestParam("nickUsuario") String nickUsuario) {
		
		System.out.println("SOY LA ID: "+id);
		if(file !=null) {
			Path directorioImagenes = Paths.get("src//main//resources//static//frontend//public/photosWall");
			String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			
			try {
				byte[] bytes = file.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nickUsuario + ".jpg");
				Files.write(rutaCompleta, bytes);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if(!descripcion.isEmpty()) {
			System.out.println("CAMBIANDO DESCRIPCION: "+descripcion);
			premiadoService.editarPremiado(id, descripcion);}
		
	}
	
	@DeleteMapping(value="/borrarPremiado/{id}")
	public void deletePremiado(@PathVariable("id") Integer id) {
		premiadoService.deletePremiadoById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
