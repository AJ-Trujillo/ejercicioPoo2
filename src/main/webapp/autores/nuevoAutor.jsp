<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file='/cabecera.jsp'%>
	<br>


	<h3>Nuevo Autor</h3>
	<form role="form" action="<%=url%>AutoresController" method="POST">
		<input type="hidden" name="op" value="insertar" />
		<div class="form-group">
			<label for="nombre">Nombre del autor</label><br> <input
				type="text" name="nombre" id="nombre" /> <br>
		</div>

		<div class="form-group">
			<label for="nombre">Nacionalidad</label><br> <input type="text"
				name="nacionalidad" id="nacionalidad" />
		</div>

		<input type="submit" value="Guardar" name="Guardar" class="btn btn-danger"> <a
			href="<%=url%>AutoresController?op=listar">Retorno</a>
	</form>
</body>
</html>