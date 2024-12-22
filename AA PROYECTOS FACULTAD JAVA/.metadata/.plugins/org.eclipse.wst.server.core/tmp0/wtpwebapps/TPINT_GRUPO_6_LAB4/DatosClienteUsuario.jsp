<%@page import="entidad.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos Cliente</title>
</head>
    <link rel="stylesheet" href="styles.css">
<body class="grid-body">
<%@include file="./MenuUsuario.jsp" %>
<main> 
<h1>Informacion Personal</h1>
<table border="1">
    <tr>
        <th>Id Cliente</th>
        <th>DNI</th>
        <th>CUIL</th>
        <th>Nombre</th>
        <th>Apellido</th>
        <th>Sexo</th>
        <th>Nacionalidad</th>
        <th>Fecha de Nacimiento</th>
        <th>Dirección</th>
        <th>Localidad</th>
        <th>Provincia</th>
        <th>Email</th>
        <th>Teléfono</th>
        <th>Usuario</th>
        <th>Clave</th>
    </tr>
    <%
    List<Cliente> datos = (List<Cliente>) request.getAttribute("datosPersonales");
    if (datos == null || datos.isEmpty()) {
    %>
        <tr>
            <td colspan="15" style="text-align: center;">Error al cargar los datos</td>
        </tr>
    <%
    } else {
        for (Cliente c : datos) {
    %>
    <tr>
        <td><%= c.getIdCliente() %></td>
        <td><%= c.getDni() %></td>
        <td><%= c.getCuil() %></td>
        <td><%= c.getNombre() %></td>
        <td><%= c.getApellido() %></td>
        <td><%= c.getSexo() %></td>
        <td><%= c.getNacionalidad() %></td>
        <td><%= c.getFechaNacimiento() %></td>
        <td><%= c.getDireccion() %></td>
        <td><%= c.getLocalidad() %></td>
        <td><%= c.getProvincia() %></td>
        <td><%= c.getEmail() %></td>
        <td><%= c.getTelefono() %></td>
        <td><%= c.getUsuario() %></td>
        <td><%= c.getClave() %></td>
    </tr>
    <%
        }
    }
    %>
</table>