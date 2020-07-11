package com.irso.apialumnos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.irso.apialumnos.models.entity.Alumno;
import com.irso.apialumnos.services.IAlumnoService;

@CrossOrigin(origins = {"https://alumnosirso.web.app", "http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AlumnoRestController {

	@Autowired
	private IAlumnoService alumnoService;

	
	@GetMapping("/usuarios")
	private long findAlumnoByEmail(@RequestParam(required = true) String email) {

		Alumno alumno = alumnoService.findByEmail(email);
		
		long alumnoId = alumno.getId();

		return alumnoId;

	}

	@GetMapping("/alumnos") // api/alumnos ---> enviar parametro page y size
	private Page<Alumno> listar(Pageable pageable){
		
		return alumnoService.findAllByOrderByIdAsc(pageable);

	}


	
	  @GetMapping("/alumnos/{id}") //api/alumnos/id public
	  ResponseEntity<Alumno> getAlumnoById(@PathVariable(value = "id") Long
	  alumnoId) {
	  
	  Alumno alumno = alumnoService.findById(alumnoId);
	  
	  return ResponseEntity.ok().body(alumno); }
	 


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
