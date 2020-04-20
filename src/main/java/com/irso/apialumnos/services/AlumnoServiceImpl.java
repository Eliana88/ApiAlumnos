package com.irso.apialumnos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.irso.apialumnos.exceptions.ConflictException;
import com.irso.apialumnos.exceptions.ResourceNotFoundException;
import com.irso.apialumnos.exceptions.ValidationException;
import com.irso.apialumnos.models.dao.IAlumnoDao;
import com.irso.apialumnos.models.entity.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService {

	@Autowired
	private IAlumnoDao alumnoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		// TODO Auto-generated method stub
		return (List<Alumno>) alumnoDao.findAll();

	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAllByOrderByIdAsc() {
		// TODO Auto-generated method stub
		return (List<Alumno>) alumnoDao.findAllByOrderByIdAsc();

	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findById(Long id) {
		// TODO Auto-generated method stub
		return alumnoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID: " + id));

	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findByEmail(String email) {
		// TODO Auto-generated method stub
		Alumno alumno = alumnoDao.findByEmail(email);
		
		return alumno;

	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno, BindingResult result) {
		if (result.hasErrors())
			throw new ValidationException("Request Body Error en: " + result);

		String email = alumno.getEmail();

		Alumno alumnoEmail = alumnoDao.findByEmail(email);

		if (alumnoEmail != null) {
			throw new ConflictException("El email: " + email + " se encuentra asociado a otro alumno.");
		} else
			return alumnoDao.save(alumno);

	}

	@Override
	@Transactional
	public Alumno update(Alumno alumnoNuevo, BindingResult result, Alumno alumnoActual) {
	
		if (result.hasErrors())
			throw new ValidationException("Request Body error: " + result);
		
		
		String emailNuevo = alumnoNuevo.getEmail();
		String emailActual = alumnoActual.getEmail();
		
		if (emailNuevo != emailActual) {
			
			Alumno alumnoEmail = findByEmail(emailNuevo);
			
			if (alumnoEmail == null) {
				alumnoActual.setApellido(alumnoNuevo.getApellido());
				alumnoActual.setNombre(alumnoNuevo.getNombre());
				alumnoActual.setEmail(alumnoNuevo.getEmail());
				
				} else
					if(alumnoEmail.getId() == alumnoNuevo.getId()) {
				
					alumnoActual.setApellido(alumnoNuevo.getApellido());
					alumnoActual.setNombre(alumnoNuevo.getNombre());
		
			}else
				throw new ConflictException("El email: " + alumnoNuevo.getEmail() + " se encuentra asociado a otro alumno.");
				
		}	
		return alumnoDao.save(alumnoActual);
		
	}



	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoDao.deleteById(id);
	}

}
