<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import='java.util.List'%>
<%@ page import='com.unu.poo2.beans.Autor'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<table id="tabla">
	<thead>
		<tr>
			<th>Codigo del autor</th>
			<th>Nombre del autor</th>
			<th>Nacionalidad</th>
			<th>Operaciones</th>
		</tr>
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
</head>
<body>
</body>
</html>