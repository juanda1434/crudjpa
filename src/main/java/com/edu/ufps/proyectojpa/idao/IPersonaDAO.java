package com.edu.ufps.proyectojpa.idao;

import java.util.List;

import com.edu.ufps.proyectojpa.model.Persona;

public interface IPersonaDAO {

	public void insertar(Persona persona);
	public void eliminar(Persona persona);
	public List<Persona> listarAll();
	public Persona listarPersona(Persona persona);
	public void editar(Persona persona);
	
	
}
