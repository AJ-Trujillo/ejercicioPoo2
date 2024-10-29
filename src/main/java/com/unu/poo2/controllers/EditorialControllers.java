package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.unu.poo2.beans.Autor;
import com.unu.poo2.beans.Editorial;
import com.unu.poo2.model.EditorialModeler;

/**
 * Servlet implementation class EditorialControllers
 */
public class EditorialControllers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EditorialModeler modelo = new EditorialModeler();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialControllers() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") == null) {
			listar(request, response);
			return;
		}
		String operacion = request.getParameter("op");

		switch (operacion) {
		case "listar":
			listar(request, response);
			break;
		case "nuevo":
			request.getRequestDispatcher("/editorial/nuevoEditorial.jsp").forward(request, response);
			break;
		case "insertar":
			insertar(request, response);
			break;
		case "obtener":
			obtener(request, response);
			break;
		case "modificar":
			modificar(request, response);
			break;
		case "eliminar":
			eliminar(request, response);
			break;

		}
	}
    
    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaEditorial", modelo.listarEditorial());
			request.getRequestDispatcher("/editorial/listarEditorial.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			// TODO: handle exception
			Logger.getLogger(EditorialControllers.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Editorial miEditorial = new Editorial();
			miEditorial.setNombre(request.getParameter("nombre"));
			miEditorial.setContacto(request.getParameter("contacto"));
			miEditorial.setTelefono (request.getParameter("telefono"));

			if (modelo.insertarEditorial(miEditorial) > 0) {
				request.getSession().setAttribute("exito", "Editorial registrado exitosamente");
				response.sendRedirect(request.getContextPath() + "/EditorialControllers?op=listar");
			} else {
				request.getSession().setAttribute("fracaso", "Editorial no registrado");
			}
			response.sendRedirect(request.getContextPath() + "/EditorialControllers?op=listar");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private void obtener(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Editorial miEditorial = modelo.obtenerEditorial(Integer.parseInt(id));
			if(miEditorial != null) {
				request.setAttribute("editorial", miEditorial);
				request.getRequestDispatcher("/editorial/editarEditorial.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath()+"/error404.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private void modificar (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			Editorial miEditorial = new Editorial();
			miEditorial.setIdeditorial(Integer.parseInt(request.getParameter("id")));
			miEditorial.setNombre(request.getParameter("nombre"));
			miEditorial.setContacto(request.getParameter("contacto"));
			miEditorial.setTelefono (request.getParameter("telefono"));
			if (modelo.modificarEditorial(miEditorial) > 0) {
				request.getSession().setAttribute("exito", "Editorial modificado exitosamente");
			} else {
				request.getSession().setAttribute("fracaso", "Editorial no modificado");
			}
			response.sendRedirect(request.getContextPath() + "/EditorialControllers?op=listar");
			
		} catch (Exception ex) {
			
			ex.getStackTrace();
		}
	}
	private void eliminar (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			if (modelo.eliminarEditorial(id) > 0) {
				request.getSession().setAttribute("exito", "Editorial eliminado exitosamente");
			} else {
				request.getSession().setAttribute("fracaso", "Editorial no eliminado");
			}
			response.sendRedirect(request.getContextPath() + "/EditorialControllers?op=listar");
			
		} catch (Exception ex) {
			
			ex.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
