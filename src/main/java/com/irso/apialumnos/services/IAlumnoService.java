package com.irso.apialumnos.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import com.irso.apialumnos.models.entity.Alumno;

public interface IAlumnoService {

	
	public Page<Alumno> findAllByOrderByIdAsc(Pageable pageable);

	public Alumno findById(Long id);

	public Alumno findByEmail(String email);

	public Alumno save(Alumno alumno, BindingResult result);

	public Alumno update(Alumno alumno, BindingResult result, Alumno alumnoActual);

	public void delete(Long id);
	
	

}
