package com.irso.apialumnos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import com.irso.apialumnos.exceptions.BadRequestException;
import com.irso.apialumnos.exceptions.ConflictException;
import com.irso.apialumnos.exceptions.ResourceNotFoundException;
import com.irso.apialumnos.exceptions.ValidationException;
import com.irso.apialumnos.models.dao.IAlumnoDao;
import com.irso.apialumnos.models.entity.Alumno;

@Service
public class AlumnoServiceImpl implements IAlumnoService {
	
	private final String SI = "S";
	private final String NO = "N";

	@Autowired
	private IAlumnoDao alumnoDao;

	
	@Override
	@Transactional(readOnly = true)
	public Page<Alumno> findAllByOrderByIdAsc(Pageable pageable) {
		return alumnoDao.findAll(pageable);
	}


	@Override
	@Transactional(readOnly = true)
	public Alumno findById(Long id) {
		return alumnoDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Codigo Error: 1. Alumno no encontrado con ID: " + id + "."));

	}

	@Override
	@Transactional(readOnly = true)
	public Alumno findByEmail(String email) {

		Alumno alumno = alumnoDao.findByEmail(email);
		
		if (alumno == null) {
			throw new ResourceNotFoundException("Alumno no encontrado con email: " + email);

		} else {
			return alumno;
		}
		
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno, BindingResult result) {	
		
		if (result.hasErrors()) {

			final Optional<ObjectError> firstError = result.getAllErrors().stream().findFirst();
			final String firstErrorMessage = firstError.get().getDefaultMessage();

			throw new ValidationException("Codigo Error: 2. " +  firstErrorMessage + "." );
		}
		
		if (alumno.getAfiliado() != null) {
			
			if(!(alumno.getAfiliado().equals(NO)) && !(alumno.getAfiliado().equals(SI))) {
				
				throw new BadRequestException("Codigo Error: 3. Afiliado debe ser 'S' o 'N'." );							
			}			
		}
		
		String email = alumno.getEmail();

		Alumno alumnoEmail = alumnoDao.findByEmail(email);

		if (alumnoEmail != null) {

			throw new ConflictException("Codigo Error: 4. El email: " + email + " se encuentra asociado a otro alumno.");
		}
		
		
		return alumnoDao.save(alumno);


	}

	@Override
	@Transactional
	public Alumno update(Alumno alumnoNuevo, BindingResult result, Alumno alumnoActual) {
		

		if (result.hasErrors()) {

			final Optional<ObjectError> firstError = result.getAllErrors().stream().findFirst();
			final String firstErrorMessage = firstError.get().getDefaultMessage();

			throw new ValidationException("Codigo Error: 5. " + firstErrorMessage + ".");

		}


		String emailNuevo = alumnoNuevo.getEmail();
		String emailActual = alumnoActual.getEmail();

		if (emailNuevo != emailActual) {

			Alumno alumnoEmail = findByEmail(emailNuevo);

			if (alumnoEmail == null) {
				alumnoActual.setApellido(alumnoNuevo.getApellido());
				alumnoActual.setNombre(alumnoNuevo.getNombre());
				alumnoActual.setEmail(alumnoNuevo.getEmail());

			} else if (alumnoEmail.getId() != alumnoNuevo.getId()) {

				throw new ConflictException(
						"Codigo Error: 6. El email: " + alumnoNuevo.getEmail() + " se encuentra asociado a otro alumno.");
			}
		}
		
		if (alumnoNuevo.getAfiliado() != null) {
			
			
			if(alumnoNuevo.getAfiliado().equals(NO) || alumnoNuevo.getAfiliado().equals(SI)) {
				alumnoActual.setAfiliado(alumnoNuevo.getAfiliado());
										
			} else {	
				throw new BadRequestException("Codigo Error: 7. Afiliado debe ser 'S' o 'N'." );	
				
				
			}
		}

		alumnoActual.setApellido(alumnoNuevo.getApellido());
		alumnoActual.setNombre(alumnoNuevo.getNombre());
		

		return alumnoDao.save(alumnoActual);

	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		alumnoDao.deleteById(id);
	}

}
