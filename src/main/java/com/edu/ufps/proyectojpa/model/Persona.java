package com.edu.ufps.proyectojpa.model;

import lombok.Data;

@Data
public class Persona {

	
	private int id;
	private String nombre;
	private String email;
	private String pais;
	
	public Persona(String nombre, String email, String pais) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
	}

	public Persona(int id, String nombre, String email, String pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pais = pais;
	}

	public Persona(int id) {
		super();
		this.id = id;
	}
	
	
	
	
}
