package com.irso.apialumnos.services;

import java.util.List;

import org.springframework.validation.BindingResult;

import com.irso.apialumnos.models.entity.Alumno;

public interface IAlumnoService {

	public List<Alumno> findAll();

	public Alumno findById(Long id);

	public Alumno findByEmail(String email);

	public Alumno save(Alumno alumno, BindingResult result);

	public Alumno update(Alumno alumno, BindingResult result);

	public void delete(Long id);

}
