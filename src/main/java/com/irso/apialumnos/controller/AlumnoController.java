package com.irso.apialumnos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irso.apialumnos.exception.ResourceNotFoundException;
import com.irso.apialumnos.model.Alumno;
import com.irso.apialumnos.repository.AlumnoRepository;

@RestController
@RequestMapping("/presencial/") //direccion principal
public class AlumnoController {
	
    @Autowired
    private AlumnoRepository alumnoRepository;

    @GetMapping("/alumnos") ///api/v1/alumnos --> este metodo busca todos los alumnos
    public List<Alumno> getAll() {
        return alumnoRepository.findAll();
    }

    @GetMapping("/alumnos/{id}") ///api/v1/alumnos/id --> este metodo busca todos los alumnos
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable(value = "id") Long alumnoId)
        throws ResourceNotFoundException {
        Alumno alumno = alumnoRepository.findById(alumnoId)
          .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ese ID: " + alumnoId));
        return ResponseEntity.ok().body(alumno);
    }
    
    @GetMapping("/email/{email}") ///api/v1/email/email --> este metodo busca todos los alumnos
    public ResponseEntity<Alumno> findByEmail(@PathVariable(value = "email") String alumnoEmail)
        throws ResourceNotFoundException {
        Alumno alumno =  alumnoRepository.findByEmail(alumnoEmail);
        return ResponseEntity.ok().body(alumno);
    }
       
    
    @PostMapping("/alumnos") //guarda los datos enviados
    public Alumno createAlumno(@Valid @RequestBody Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @PutMapping("/alumnos/{id}") //actualiza
    public ResponseEntity<Alumno> updateAlumno(@PathVariable(value = "id") Long alumnoId,
         @Valid @RequestBody Alumno alumnoDetails) throws ResourceNotFoundException {
        Alumno alumno = alumnoRepository.findById(alumnoId)
        .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ese ID: " + alumnoId));

        alumno.setEmail(alumnoDetails.getEmail());
        alumno.setApellido(alumnoDetails.getApellido());
        alumno.setNombre(alumnoDetails.getNombre());
        final Alumno updatedAlumno = alumnoRepository.save(alumno);
        return ResponseEntity.ok(updatedAlumno);
    }

    @DeleteMapping("/alumnos/{id}")
    public Map<String, Boolean> deleteAlumno(@PathVariable(value = "id") Long alumnoId)
         throws ResourceNotFoundException {
        Alumno alumno = alumnoRepository.findById(alumnoId)
       .orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ese ID: " + alumnoId));

        alumnoRepository.delete(alumno);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}