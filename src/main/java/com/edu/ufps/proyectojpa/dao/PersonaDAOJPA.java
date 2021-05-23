package com.edu.ufps.proyectojpa.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.edu.ufps.proyectojpa.entities.PersonaEntity;
import com.edu.ufps.proyectojpa.idao.IPersonaDAO;
import com.edu.ufps.proyectojpa.model.Persona;
import com.edu.ufps.proyectojpa.util.ConexionJPA;

public class PersonaDAOJPA implements IPersonaDAO {

    public ConexionJPA conexion;
	
	public PersonaDAOJPA() {
		conexion = ConexionJPA.getConexion();
	}

	@Override
	public void insertar(Persona persona) {
		EntityManager manager = conexion.getManager();
		EntityTransaction transaccion = manager.getTransaction();
		try {
			transaccion.begin();
			PersonaEntity entidad = new PersonaEntity();
			entidad.setNombre(persona.getNombre());
		    entidad.setPais(persona.getPais());
		    entidad.setEmail(persona.getEmail());
			manager.persist(entidad);
			transaccion.commit();
			
		} catch (Exception e) {
			transaccion.rollback();
		}
		manager.close();
	}

	@Override
	public void eliminar(Persona persona) {

EntityManager manager = conexion.getManager();
EntityTransaction transaccion = manager.getTransaction();

try {
	transaccion.begin();
	PersonaEntity personaEliminar= manager.find(PersonaEntity.class,persona.getId());
	manager.remove(personaEliminar);
	transaccion.commit();
} catch (Exception e) {
	transaccion.rollback();
}
		
manager.close();
		
	}

	@Override
	public List<Persona> listarAll() {
		List<Persona> personas= new ArrayList<Persona>();
		EntityManager manager = conexion.getManager();
		EntityTransaction transaccion = manager.getTransaction();
		try {
			transaccion.begin();
			List<PersonaEntity>personasQuery = manager.createNativeQuery("Select * from persona", PersonaEntity.class).getResultList();			
			for (PersonaEntity persona : personasQuery) {
				personas.add(new Persona(persona.getId(),persona.getNombre(),persona.getEmail(),persona.getPais()));
			}
			transaccion.commit();
		} catch (Exception e) {
transaccion.rollback();
		}
		
		manager.close();
		return personas;
		
	}

	@Override
	public Persona listarPersona(Persona persona) {
		Persona personaEncontrada=null;
		EntityManager manager =conexion.getManager();
		EntityTransaction transaccion = manager.getTransaction();
		try {
			transaccion.begin();
			//Object obj= manager.createNativeQuery("Select * from persona where id=:id", PersonaEntity.class).setParameter("id",persona.getId()).getSingleResult();			
			//PersonaEntity personaQuery=obj!=null ?(PersonaEntity)obj:null;
			//personaEncontrada= personaQuery!=null ? new Persona(personaQuery.getId(),personaQuery.getNombre(),personaQuery.getEmail(),personaQuery.getPais()):null;
			
			PersonaEntity personaQuery=manager.find(PersonaEntity.class, persona.getId());
			personaEncontrada= personaQuery!=null ? new Persona(personaQuery.getId(),personaQuery.getNombre(),personaQuery.getEmail(),personaQuery.getPais()):null;
			
			transaccion.commit();
		} catch (Exception e) {
			transaccion.rollback();
		}
manager.close();
		
		return personaEncontrada;
		
	}

	@Override
	public void editar(Persona persona) {
EntityManager manager = conexion.getManager();
EntityTransaction transaccion = manager.getTransaction();

try {
	transaccion.begin();
	PersonaEntity personaEditar= new PersonaEntity();
	personaEditar.setId(persona.getId());
	personaEditar.setNombre(persona.getNombre());
	personaEditar.setPais(persona.getPais());
	personaEditar.setEmail(persona.getEmail());
	manager.merge(personaEditar);
	transaccion.commit();
} catch (Exception e) {
	transaccion.rollback();
}
		
manager.close();
	}
	
	
	
	
}
