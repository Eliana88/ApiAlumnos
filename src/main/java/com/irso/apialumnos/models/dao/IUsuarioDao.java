package com.irso.apialumnos.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.irso.apialumnos.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository <Usuario, Long> {
	
	public Usuario findByUsername(@Param("username") String username);



}
