package com.edu.ufps.proyectojpa.dao.factory;

import com.edu.ufps.proyectojpa.dao.PersonaDAOJPA;
import com.edu.ufps.proyectojpa.idao.IPersonaDAO;

public class DAOFactoryJPA implements IDAOFactory {

	
	
	@Override
	public IPersonaDAO getPersonaDAO() {
		return new PersonaDAOJPA();
	}

	
	
	
}
