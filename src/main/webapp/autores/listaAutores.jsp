<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import='java.util.List'%>
<%@ page import='com.unu.poo2.beans.Autor'%>
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
<body>

	<%@ include file='/cabecera.jsp'%>
	<br>


	<div class="container">

		<a type="button" href="<%=url%>AutoresController?op=nuevo" >Nuevo
			Autor</a>;

		<table class="table">
			<thead>

				<th>Codigo del autor</th>
				<th>Nombre del autor</th>
				<th>Nacionalidad</th>
				<th>Operaciones</th>

			</thead>
			<tbody>
				<%
				List<Autor> listarAutores = (List<Autor>) request.getAttribute("listaAutores");
						if (listarAutores != null) {
							for (Autor autor : listarAutores) {
				%>
				<tr>
					<td><%=autor.getIdAutor()%></td>
					<td><%=autor.getNombreAutor()%></td>
					<td><%=autor.getNacionalidad()%></td>
					<td><a
						href="<%=url%>AutoresController?op=obtener&id=<%=autor.getIdAutor()%>">Modificar</a>
						<a
						href="<%=url%>AutoresController?op=eliminar&id=<%=autor.getIdAutor()%>">Eliminar</a>
					</td>
				</tr>

				<%
				}
				} else {
				%>
				<tr>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td>No hay datos</td>
					<td></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

	</div>
</head>

</body>
</html>