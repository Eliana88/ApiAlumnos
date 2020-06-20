package com.irso.apialumnos.services;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.irso.apialumnos.models.entity.Alumno;
import com.irso.apialumnos.models.entity.AlumnoSoloAfiliado;

public interface IAlumnoService {

	public List<Alumno> findAll();
	
	public List<Alumno> findAllByOrderByIdAsc();

	public Alumno findById(Long id);

	public Alumno findByEmail(String email);

	public Alumno save(Alumno alumno, BindingResult result);

	public Alumno update(Alumno alumno, BindingResult result, Alumno alumnoActual);

	public void delete(Long id);
	
	public Alumno replace(AlumnoSoloAfiliado alumnoAfiliado, Alumno alumno);
	

}
