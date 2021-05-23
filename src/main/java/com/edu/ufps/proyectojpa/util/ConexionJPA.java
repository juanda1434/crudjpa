package com.edu.ufps.proyectojpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {

	
	private EntityManagerFactory factory;
	private static ConexionJPA conexion; 
	
	private ConexionJPA() {
	
		 factory = Persistence.createEntityManagerFactory("proyectojpa");
	}
	
	public static ConexionJPA getConexion() {
		return conexion==null ? conexion=new ConexionJPA(): conexion;
	}
	
	
	public EntityManager getManager() {
		return factory.createEntityManager();
	}
	
	
	
}
