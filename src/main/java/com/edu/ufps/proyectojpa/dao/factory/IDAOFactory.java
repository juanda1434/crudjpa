package com.edu.ufps.proyectojpa.dao.factory;

import com.edu.ufps.proyectojpa.idao.IPersonaDAO;

public interface IDAOFactory {

	
	public IPersonaDAO getPersonaDAO();
	
	
	public static IDAOFactory getFactory(String tipoSGBD) {
		IDAOFactory factory= null;
		
		switch(tipoSGBD) {
		case "JPA":
			factory = new DAOFactoryJPA();
			break;
		}
		
		return factory;
	}
}
