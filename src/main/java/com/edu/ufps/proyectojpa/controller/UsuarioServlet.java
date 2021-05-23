package com.edu.ufps.proyectojpa.controller;

import java.io.IOException;
import java.util.List;

import com.edu.ufps.proyectojpa.dao.factory.IDAOFactory;
import com.edu.ufps.proyectojpa.idao.IPersonaDAO;
import com.edu.ufps.proyectojpa.model.Persona;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {

    	private static final long serialVersionUID = 1L;

    	private IPersonaDAO personaDAO;
    	//private ICorreo mail;
        /**
         * Default constructor. 
         */
        public UsuarioServlet() {
            // TODO Auto-generated constructor stub
        }

    	/**
    	 * @see Servlet#init(ServletConfig)
    	 */
    	public void init(ServletConfig config) throws ServletException {
    		super.init(config);
    		String tipoSGBD= getServletContext().getInitParameter("type");
    		this.personaDAO= IDAOFactory.getFactory(tipoSGBD).getPersonaDAO();
    		//mail = new Mail();
    	}

    	/**
    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String path = request.getServletPath();
    		
    		switch (path) {
    		case "/nuevo":
    			mostrarFormulario(request, response);
    			break;
    		case "/insertar":
    			insertar(request, response);
    			break;
    		case "/borrar":
    			eliminar(request,response);
    			break;
    		case "/edicion":
    			mostrarFormularioEdicion(request, response);
    			break;
    		case "/editar":
    			editar(request,response);
    			break;
    		case "/lista":
    			listar(request, response);
    			break;

    		default:
    			listar(request, response);
    			break;
    		}
    	}

    	protected void mostrarFormulario(HttpServletRequest request,HttpServletResponse response)
    			throws ServletException, IOException {
    		request.getRequestDispatcher("usuario.jsp").forward(request, response);
    		}
    	
    	protected void mostrarFormularioEdicion(HttpServletRequest request,HttpServletResponse response)
    			throws ServletException, IOException {
    		Persona usuarioDTO = new Persona(Integer.parseInt(request.getParameter("id")));
    		Persona usuarioActual = personaDAO.listarPersona(usuarioDTO);
    		
    		request.setAttribute("user", usuarioActual);
    		request.getRequestDispatcher("usuario.jsp").forward(request, response);
    		}
    	
    	protected void insertar(HttpServletRequest request,HttpServletResponse response)
    			throws ServletException, IOException {
    		String nombre = request.getParameter("nombre");
    		String email = request.getParameter("email");
    		String pais = request.getParameter("pais");
    		Persona usuarioDTO = new Persona(nombre, email, pais);
    		personaDAO.insertar(usuarioDTO);
    		String mensaje = "Hola "+nombre+" eres de "+pais+" bienvenido";
    		//mail.enviarEmail(email, "Bienvenida", mensaje);
    		response.sendRedirect("listar");
    		}
    	
    	protected void editar(HttpServletRequest request,HttpServletResponse response)
    			throws ServletException, IOException {
    		String nombre = request.getParameter("nombre");
    		String email = request.getParameter("email");
    		String pais = request.getParameter("pais");
    		Integer id = Integer.parseInt(request.getParameter("id"));
    		Persona usuarioDTO = new Persona(id,nombre, email, pais);
    		personaDAO.editar(usuarioDTO);
    		response.sendRedirect("listar");
    		}
    	protected void eliminar(HttpServletRequest request,HttpServletResponse response)
    			throws ServletException, IOException {
    		int id = Integer.parseInt(request.getParameter("id"));
    		Persona usuarioDTO = new Persona(id);
    		personaDAO.eliminar(usuarioDTO);
    		response.sendRedirect("listar");
    		}
    	
    	protected void listar(HttpServletRequest request,HttpServletResponse response)
    			throws ServletException, IOException {
    				List<Persona>users= personaDAO.listarAll();
    				request.setAttribute("listaUsuarios", users);
    		request.getRequestDispatcher("listarUsuario.jsp").forward(request, response);
    	}
    	/**
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		doGet(request, response);
    	}

}
