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
	public Alumno findById(Long id) {
		// TODO Auto-generated method stub
		return alumnoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Alumno no encontrado con ID: " + id));

	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findByEmail(String email) {
		// TODO Auto-generated method stub
		return alumnoDao.findByEmail(email);
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno, BindingResult result) {
		// TODO Auto-generated method stub
		if (result.hasErrors())
			throw new ValidationException("Request Body error: " + result);

		String email = alumno.getEmail();

		Alumno alumnoEmail = alumnoDao.findByEmail(email);

		if (alumnoEmail != null) {
			throw new ConflictException("El email: " + email + " se encuentra asociado a otro alumno.");
		} else
			return alumnoDao.save(alumno);

	}

	@Override
	public Alumno update(Alumno alumnoNuevo, BindingResult result) {
		// TODO Auto-generated method stub
		/*
		 * La logica de la actualización es: tomo el email del body y lo busco en la
		 * base, obtengo el objeto alumno, si el id del alumno obtenido es igual al que
		 * quiero actualizar, actualizo. Sino quiere decir que el email esta asociado a
		 * otro alumno.
		 */
		if (result.hasErrors())
			throw new ValidationException("Request Body error: " + result);

		String emailNuevo = alumnoNuevo.getEmail();

		Alumno alumnoExistente = alumnoDao.findByEmail(emailNuevo);

		if (alumnoNuevo.getId() == alumnoExistente.getId()) {
			alumnoExistente.setApellido(alumnoNuevo.getApellido());
			alumnoExistente.setNombre(alumnoNuevo.getNombre());

			return alumnoDao.save(alumnoExistente);
		} else
			throw new ConflictException("El email: " + emailNuevo + " se encuentra asociado a otro alumno.");

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoDao.deleteById(id);
	}

}
