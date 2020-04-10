package com.irso.apialumnos.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.irso.apialumnos.models.entity.Alumno;

public interface IAlumnoDao extends CrudRepository<Alumno, Long> {
	
	Alumno findByEmail(String email);
	
	
}
