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
String url ="http://localhost:8087/ejercicioWeb/";
%>

	<h3>Nuevo Editorial</h3>
	
<form role="form" action="<%=url%>EditorialControllers" method="POST">
<input type="hidden" name="op" value="insertar" />

<label for="nombre">Nombre del Editorial</label><br>
<input type="text" name="nombre" id="nombre" /> <br>

<label for="nombre">Contacto</label><br>
<input type="text" name="contacto" id="contacto" /> <br>

<label for="nombre">Telefono</label><br>
<input type="text" name="telefono" id="telefono" /> <br>

<input type="submit" value="Guardar"name="Guardar">

<a href="<%=url %>EditorialControllers?op=listar">Retorno</a>
</form>
</body>

</html>