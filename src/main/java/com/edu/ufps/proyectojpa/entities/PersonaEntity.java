package com.edu.ufps.proyectojpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity (name = "persona")
@Data
public class PersonaEntity {

	@Id
	@Column (name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	  
	@Column(name="email")
	private String email;
	
	@Column(name="pais")
	private String pais;
	
	}
