package com.edu.ufps.proyectojpa.test;

import com.edu.ufps.proyectojpa.idao.IPersonaDAO;
import com.edu.ufps.proyectojpa.model.Persona;
import com.edu.ufps.proyectojpa.dao.factory.IDAOFactory;
public class JPATest {

	
	
	public static void main(String[] args) {
		Persona persona =new Persona("Juan Sanchez","correo@correo.com","Bolivia");
		Persona persona2 = new Persona(7,"Eduar Mancilla","correo2@correo.com","Costa Rica");
		IDAOFactory factory= IDAOFactory.getFactory("JPA");
		IPersonaDAO personaDAO = factory.getPersonaDAO();		
		//personaDAO.insertar(persona);
		//personaDAO.insertar(persona2);
	   // System.out.println(personaDAO.listarAll().toString());
		//personaDAO.editar(persona2);
		//System.out.println(personaDAO.listarPersona(persona2).toString());
		personaDAO.eliminar(persona2);
	}
}
