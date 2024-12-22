<%@page import="entidad.Cliente"%>
<%@page import="negocioImpl.ClienteNegImpl"%>
<%@page import="negocio.ClienteNeg"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Agregar usuario</title>
    <link rel="stylesheet" href="styles.css"> <!-- Vincula tu CSS personalizado aquí -->
    <style>
        /* Estilos básicos para mejorar la apariencia */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        html, body {
    		height: auto; /* Permitir que el contenido expanda la altura */
		}
        
        .container {
            width: 60%;
            max-width: 800px;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            overflow hidden;
        }
        h1 {
            text-align: center;
            color: #4CAF50;
            font-size: 2.5em;
        }
        form table {
            width: 100%;
            border-collapse: collapse;
        }
        form table td {
            padding: 10px;
        }
        form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }
        form input[type="text"],
        form select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
            color: #333;
        }
        form input[type="radio"] {
            margin-right: 5px;
        }
        form input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 100%;
        }
        form input[type="submit"]:hover {
            background-color: #45a049;
        }
        .account-type {
            text-align: center;
            margin-top: 10px;
            color: #333;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Agregar usuario</h1>
    <form action="ServletClientes" method="post">
        <table>
            <tr>
                <td><label for="dni">DNI:</label></td>
                <td><input type="text" id="dni" name="txtDni"></td>
            </tr>
            <tr>
                <td><label for="cuil">CUIL:</label></td>
                <td><input type="text" id="cuil" name="txtCuil"></td>
            </tr>
            <tr>
                <td><label for="nombre">Nombre:</label></td>
                <td><input type="text" id="nombre" name="txtNombre"></td>
            </tr>
            <tr>
                <td><label for="apellido">Apellido:</label></td>
                <td><input type="text" id="apellido" name="txtApellido"></td>
            </tr>
            <tr>
                <td><label for="sexo">Sexo:</label></td>
                <td><input type="text" id="sexo" name="txtSexo"></td>
            </tr>
            <tr>
                <td><label for="nacionalidad">Nacionalidad:</label></td>
                <td><input type="text" id="nacionalidad" name="txtNacionalidad"></td>
            </tr>
            <tr>
                <td><label for="fecha_nacimiento">Fecha de Nacimiento:</label></td>
                <td><input type="text" id="fecha_nacimiento" name="txtFecha_Nacimiento"></td>
            </tr>
            <tr>
                <td><label for="direccion">Dirección:</label></td>
                <td><input type="text" id="direccion" name="txtDireccion"></td>
            </tr>
            <tr>
                <td><label for="localidad">Localidad:</label></td>
                <td><input type="text" id="localidad" name="txtLocalidad"></td>
            </tr>
            <tr>
                <td><label for="provincia">Provincia:</label></td>
                <td>
                    <select id="provincia" name="ddlProvincia">
    					<option value="" selected disabled>Seleccione una provincia</option>
    					<option value="Buenos Aires">Buenos Aires</option>
						<option value="Catamarca">Catamarca</option>
						<option value="Chaco">Chaco</option>
						<option value="Chubut">Chubut</option>
						<option value="Córdoba">Córdoba</option>
						<option value="Corrientes">Corrientes</option>
						<option value="Entre Ríos">Entre Ríos</option>
						<option value="Formosa">Formosa</option>
						<option value="Jujuy">Jujuy</option>
    					<option value="La Pampa">La Pampa</option>
					    <option value="La Rioja">La Rioja</option>
						<option value="Mendoza">Mendoza</option>
						<option value="Misiones">Misiones</option>
						<option value="Neuquén">Neuquén</option>
						<option value="Río Negro">Río Negro</option>
						<option value="Salta">Salta</option>
						<option value="San Juan">San Juan</option>
						<option value="San Luis">San Luis</option>
						<option value="Santa Cruz">Santa Cruz</option>
						<option value="Santa Fe">Santa Fe</option>
						<option value="Santiago del Estero">Santiago del Estero</option>
						<option value="Tierra del Fuego">Tierra del Fuego</option>
						<option value="Tucumán">Tucumán</option>
					</select>
                </td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td><input type="text" id="email" name="txtEmail"></td>
            </tr>
            <tr>
                <td><label for="telefono">Teléfono:</label></td>
                <td><input type="text" id="telefono" name="txtTelefono"></td>
            </tr>
            <tr>
                <td><label for="usuario">Usuario:</label></td>
                <td><input type="text" id="usuario" name="txtUsuario"></td>
            </tr>
            <tr>
                <td><label for="clave">Clave:</label></td>
                <td><input type="text" id="clave" name="txtClave"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" name = "btnAceptar" value="Aceptar">
    <%
		if (request.getAttribute("EstadoCliente") != null) {
	%>
	Cliente agregado con exito
	<%
		}
	%>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
