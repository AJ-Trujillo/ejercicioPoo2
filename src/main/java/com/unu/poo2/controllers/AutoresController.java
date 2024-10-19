package com.unu.poo2.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
    	if(request.getParameter("op")==null) {
    		//listar(request,respone);
    		return;
    	}
    	String operacion = request.getParameter("op");
    	switch (operacion) {
		case "listar":
				//listar(request, response);
			break;

		default:
			break;
		}
    }
    private void listar(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	request.setAttribute("listarAutores", modelo.listarAutores());
    	request.getRequestDispatcher("/autores/listaAutores.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
