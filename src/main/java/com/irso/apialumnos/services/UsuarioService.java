package com.irso.apialumnos.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.irso.apialumnos.models.dao.IUsuarioDao;
import com.irso.apialumnos.models.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {
	
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			throw new  UsernameNotFoundException("Usuario no registrado en la base de datos."); 
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnable(), true,
				true, true, authorities);
	}
	



	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsername(String username) {
		
		return usuarioDao.findByUsername(username);
	}
}