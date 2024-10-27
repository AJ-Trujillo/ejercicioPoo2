<%@page import="com.unu.poo2.beans.Autor"%>
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
	String url = "http://localhost:8080/ejercicioWeb/";

	Autor autor;

	if (request.getAttribute("autor") == null)
		autor = new Autor();
	else
		autor = (Autor)request.getAttribute("autor");
	%>

	<h3>Nuevo Autor</h3>
	<form role="form" action="<%=url%>AutoresController" method="POST">
		<input type="hidden" name="op" value="modificar" /> <label
			for="nombre">Nombre del autor</label><br> 
			<input type="text"name="nombre" id="nombre" value="<%=autor.getNombreAutor() %>"/> <br> 
			<label for="nombre">Nacionalidad</label><br>
		<input type="text" name="nacionalidad" id="nacionalidad" value="<%=autor.getNacionalidad()%>"/> <br>

		<input type="submit" value="Guardar" name="Guardar"> <a
			href="<%=url%>AutoresController?op=listar">Retorno</a>
	</form>
</body>
</html>