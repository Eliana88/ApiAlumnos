package com.irso.apialumnos.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.irso.apialumnos.model.Alumno;

public interface AlumnoRepository extends JpaRepository <Alumno, Long>{
	
	Alumno findByEmail(String email);

	Alumno findById(long id);

	

}
