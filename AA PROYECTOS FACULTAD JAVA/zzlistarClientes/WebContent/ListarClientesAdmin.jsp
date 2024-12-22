<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="entidad.Cliente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Lista de Clientes</title>
</head>
<body>
    <h1>Lista de Clientes</h1>
    
    <%
    	
        List<Cliente> lista = (List<Cliente>) request.getAttribute("listaCl");
        if (lista == null || lista.isEmpty()) {
    %>
        <p>No hay clientes disponibles.</p>
    <%
        } else {
    %>

    <table border="1">
        <tr>
            <th>ID Cliente</th>
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
        </tr>

        <%
            for (Cliente c : lista) {
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
        </tr>
        <%
            }
        %>
    </table>

    <%
        }
    %>
</body>
</html>