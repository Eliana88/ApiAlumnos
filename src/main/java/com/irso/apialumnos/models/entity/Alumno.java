package com.irso.apialumnos.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "Nombre no puede ser nulo")
	@Size(min=3, max=50)
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@NotEmpty(message = "Apellido no puede ser nulo")
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	
    @NotNull
    @Email(regexp="[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+", message = "Email debe ser válido")
    @Size(min=10, max=50, message = "Email debe contener entre 10 y 50 caracteres")
	@Column(name = "email", nullable = false , unique=true)
	private String email;
   
    @Column(name = "afiliado", nullable = true)
    @Size(min=1, max=1, message = "Afiliado debe ser 'S' o 'N'")
	private String afiliado;
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAfiliado() {
		return afiliado;
	}

	public void setAfiliado(String afiliado) {
		this.afiliado = afiliado;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


}
