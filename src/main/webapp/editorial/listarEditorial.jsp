<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import='java.util.List'%>
<%@ page import='com.unu.poo2.beans.Editorial'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String url = "http://localhost:8080/ejercicioWeb/";
	%>

	<a type="button" href="<%=url%>EditorialControllers?op=nuevo">Nuevo Editorial</a>;
	<table id="tabla" border="1">
		<thead>
			<tr>
				<th>Codigo del Editorial</th>
				<th>Nombre del Editorial</th>
				<th>Contacto</th>
				<th>Telefono</th>
				<th>Operaciones</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Editorial> listarEditorial = (List<Editorial>) request.getAttribute("listaEditorial");
			if (listarEditorial != null) {
				for (Editorial editorial : listarEditorial) {
			%>
			<tr>
				<td><%= editorial.getIdeditorial()%></td>
				<td><%=editorial.getNombre()%></td>
				<td><%=editorial.getContacto()%></td>
				<td><%=editorial.getTelefono()%></td>
				<td><a
					href="<%=url%>EditorialControllers?op=obtener&id=<%=editorial.getIdeditorial()%>">Modificar</a>
					<a
					href="<%=url%>EditorialControllers?op=eliminar&id=<%=editorial.getIdeditorial()%>">Eliminar</a>
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
				<td>No hay datos</td>
				<td></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>
</head>
</body>

</html>