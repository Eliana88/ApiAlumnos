package com.irso.apialumnos.services;

import com.irso.apialumnos.models.entity.Usuario;

public interface IUsuarioService {

	Usuario findByUsername(String username);
	
	

}
