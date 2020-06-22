package com.irso.apialumnos.models.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irso.apialumnos.models.entity.Alumno;

public interface IAlumnoDao extends JpaRepository<Alumno, Long> {
	
	Alumno findByEmail(String email);

	List<Alumno> findAllByOrderByIdAsc();

	
	
	
}
