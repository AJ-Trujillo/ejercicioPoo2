<%@page import="com.unu.poo2.beans.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Autor</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

</head>
<body>
	<%@ include file='/cabecera.jsp'%>
	<%
	Autor autor;

		if (request.getAttribute("autor") == null)
			autor = new Autor();
		else
			autor = (Autor) request.getAttribute("autor");
	%>

	<h3>Nuevo Autor</h3>
	<form role="form" action="<%=url%>AutoresController" method="POST">

		<input type="hidden" name="op" value="modificar" /> <input
			type="hidden" name="id" value="<%=autor.getIdAutor()%>" />

		<div class="form-group">
			<label for="nombre">Nombre del autor</label><br> <input
				type="text" name="nombre" id="nombre"
				value="<%=autor.getNombreAutor()%>" />
		</div>
		<div class="form-group">
			<label for="nombre">Nacionalidad</label><br> <input type="text"
				name="nacionalidad" id="nacionalidad"
				value="<%=autor.getNacionalidad()%>" />
		</div>
		<input type="submit" value="Guardar" name="Guardar" class="btn btn-success"> <a
			href="<%=url%>AutoresController?op=listar">Retorno</a>
	</form>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>