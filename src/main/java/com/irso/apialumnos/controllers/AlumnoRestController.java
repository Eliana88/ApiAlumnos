package com.irso.apialumnos.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.irso.apialumnos.models.entity.Alumno;
import com.irso.apialumnos.services.IAlumnoService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/presencial")
public class AlumnoRestController {

	@Autowired
	private IAlumnoService alumnoService;

	@GetMapping("/alumnos")
	public List<Alumno> index() {
		return alumnoService.findAllByOrderByIdAsc();
	}

	
	
	@GetMapping("/alumnos/{id}") //presencial/alumnos/id
	public ResponseEntity<Alumno> getAlumnoById(@PathVariable(value = "id") Long alumnoId) {

		Alumno alumno = alumnoService.findById(alumnoId);

		return ResponseEntity.ok().body(alumno);
	}
	
	
	@GetMapping("/alumnos/emails/{email}") //presencial/alumnos/emails/email
	public ResponseEntity<Alumno> getAlumnoByEmail(@PathVariable(value = "email") String alumnoEmail) {

		Alumno alumno = alumnoService.findByEmail(alumnoEmail);

		// int forzar500= 1/0;

		return ResponseEntity.ok().body(alumno);
	}
	
	
	
	@PostMapping("/alumnos")
	@ResponseStatus(HttpStatus.CREATED) // guarda los datos enviados
	private Alumno create(@Valid @RequestBody Alumno alumno, BindingResult result) {
		
		Alumno alumnoCreated = alumnoService.save(alumno, result);
		
		return alumnoCreated;
	}
	
	
	@PutMapping("/alumnos/{id}")
	@ResponseStatus(HttpStatus.OK)
	private Alumno update(@Valid @RequestBody Alumno alumnoDetails, BindingResult result, @PathVariable Long id) {
		
		Alumno alumnoActual = alumnoService.findById(id); 
		
		Alumno alumnoUpdated = alumnoService.update(alumnoDetails, result, alumnoActual);
		
		return alumnoUpdated;

	}
	

	@DeleteMapping("/alumnos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	private void delete(@PathVariable Long id) {

		alumnoService.findById(id);

		alumnoService.delete(id);
	}

}
