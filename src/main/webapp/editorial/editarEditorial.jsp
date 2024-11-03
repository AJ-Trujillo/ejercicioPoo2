<%@page import="com.unu.poo2.beans.Editorial"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String url = "http://localhost:8089/ejercicioWeb/";

	Editorial editorial;

	if (request.getAttribute("editorial") == null)
		editorial = new Editorial();
	else
		editorial = (Editorial) request.getAttribute("editorial");
	%>

	<h3>Editar Editorial</h3>
	<form role="form" action="<%=url%>EditorialControllers" method="POST">
		<input type="hidden" name="op" value="modificar" /> <input
			type="hidden" name="id" value="<%=editorial.getIdeditorial()%>" /> <label
			
			for="nombre">Nombre del Editorial</label><br> <input type="text"
			name="nombre" id="nombre" value="<%=editorial.getNombre()%>" /> <br>
			
		<label for="nombre">Contacto</label><br> 
		<input type="text" name="contacto" id="contacto" value="<%=editorial.getContacto()%>" /> <br>
		
		<label for="nombre">Telefono</label><br> 
		<input type="text" name="telefono" id="telefono" value="<%=editorial.getTelefono()%>" /> <br>
			
		<input type="submit" value="Guardar" name="Guardar"> 
		<a href="<%=url%>EditorialControllers?op=listar">Retorno</a>
	</form>
</body>
</html>