package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.unu.poo2.beans.Autor;
import com.unu.poo2.model.AutoresModel;

/**
 * Servlet implementation class AutoresController
 */
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AutoresModel modelo = new AutoresModel();

	/**
	 * Default constructor.
	 */
	public AutoresController() {
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
			request.getRequestDispatcher("/autores/nuevoAutor.jsp").forward(request, response);
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

	/*
	 * private void lista(HttpServletRequest request, HttpServletResponse response)
	 * throws ServletException, IOException{ `request.setAttribute("listarAutores",
	 * modelo.listarAutores());
	 * 
	 * Iterator<Autor> it = modelo.listarAutores().iterator(); while(it.hasNext()) {
	 * Autor a = it.next();
	 * System.out.println(a.getIdAutor()+" - "+a.getNombreAutor()+" - "+a.
	 * getNacionalidad()); }
	 * request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request,
	 * response);
	 * 
	 * }
	 */

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("listaAutores", modelo.listarAutores());
			request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			// TODO: handle exception
			Logger.getLogger(AutoresController.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	private void insertar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Autor miAutor = new Autor();
			miAutor.setNombreAutor(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));

			if (modelo.insertarAutor(miAutor) > 0) {
				request.getSession().setAttribute("exito", "autor registrado exitosamente");
				response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			} else {
				request.getSession().setAttribute("fracaso", "autor no registrado");
			}
			response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	private void obtener(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			Autor miAutor = modelo.obtenerAutor(Integer.parseInt(id));
			if(miAutor != null) {
				request.setAttribute("autor", miAutor);
				request.getRequestDispatcher("/autores/editarAutores.jsp").forward(request, response);
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
			Autor miAutor = new Autor();
			miAutor.setIdAutor(Integer.parseInt(request.getParameter("id")));
			miAutor.setNombreAutor(request.getParameter("nombre"));
			miAutor.setNacionalidad(request.getParameter("nacionalidad"));

			if (modelo.modificarAutor(miAutor) > 0) {
				request.getSession().setAttribute("exito", "autor modificado exitosamente");
			} else {
				request.getSession().setAttribute("fracaso", "autor no modificado");
			}
			response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			
		} catch (Exception ex) {
			
			ex.getStackTrace();
		}
	}
	private void eliminar (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));

			if (modelo.eliminarAutor(id) > 0) {
				request.getSession().setAttribute("exito", "autor eliminado exitosamente");
			} else {
				request.getSession().setAttribute("fracaso", "autor no eliminado");
			}
			response.sendRedirect(request.getContextPath() + "/AutoresController?op=listar");
			
		} catch (Exception ex) {
			
			ex.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
