<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="entidad.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes</title>

<link rel="stylesheet" href="styles.css">

</head>
<body class="grid-body">
	<%@include file="./MenuAdmin.jsp"%>
	<main>
	<h1>Lista de Clientes</h1>

	<form action="ServletCliente" method="get"
		onsubmit="return validarFiltro(event);">
		<div>
			<label for="filtro">Seleccionar Filtro:</label> <select name="filtro"
				id="filtro" onchange="mostrarCampoFiltro(this.value)">
				<option value="0">Seleccione</option>
				<option value="id">ID de Cliente</option>
				<option value="nombre">Nombre</option>
				<option value="apellido">Apellido</option>
			</select> <span class="error" id="error-filtro" style="color: red;"></span>
		</div>
		<div id="campoFiltro" style="margin-top: 10px;">
			<input type="text" name="txtFiltro" id="txtFiltro"
				placeholder="Seleccione filtro" style="width: 247px;"> <span
				class="error" id="error-txtFiltro" style="color: red;"></span>
		</div>
		<div style="margin-top: 10px;">
			<button type="submit" name="Param" value="filtrarClientes">Filtrar</button>
			<button type="submit" name="Param" value="listarClientes">Eliminar
				Filtros</button>
		</div>
	</form>
	<script>
    function mostrarCampoFiltro(filtro) {
        const campoFiltro = document.getElementById('campoFiltro');
        const txtFiltro = document.getElementById('txtFiltro');

        switch (filtro) {
            case 'id':
                txtFiltro.placeholder = "Ingrese el ID del cliente";
                break;
            case 'nombre':
                txtFiltro.placeholder = "Ingrese el Nombre del cliente";
                break;
            case 'apellido':
                txtFiltro.placeholder = "Ingrese el Apellido del cliente";
                break;
            default:
                txtFiltro.placeholder = "Seleccione filtro";
        }
    }
    
    function validarFiltro(event) {
 
          if (event.submitter.value === "listarClientes") {
			return true;
          }
        let valido = true;

        document.getElementById("error-filtro").textContent = "";
        document.getElementById("error-txtFiltro").textContent = "";

        const filtro = document.getElementById("filtro").value;
        const txtFiltro = document.getElementById("txtFiltro").value;


        if (filtro === "0") {
            document.getElementById("error-filtro").textContent = "Debe seleccionar un filtro.";
            valido = false;
        }

        if (txtFiltro.trim() === "") {
            document.getElementById("error-txtFiltro").textContent = "Debe ingresar un valor para el filtro.";
            valido = false;
        }else if (filtro === 'id' && isNaN(Number(txtFiltro.trim()))) {
            document.getElementById("error-txtFiltro").textContent = "El ID debe ser un n�mero.";
            valido = false;
        }

        return valido; 
    }
    
    function confirmar(event){
    	
    	if (event.submitter.value === "Eliminar") {
    		if(confirm("�Quieres eliminar este usuario?")) return true;
    		else{
    			return false;
    		}
          }
    	
    	return true;
    }
</script> <%
    	List<Cliente> lista = (List<Cliente>) request.getAttribute("listaCl");
		if(lista == null){
			response.sendRedirect("ServletCliente?Param=listarClientes");
			return;
		}
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
			<th>Direccion</th>
			<th>Localidad</th>
			<th>Provincia</th>
			<th>Email</th>
			<th>Telefono</th>
			<th>Usuario</th>
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
			<td><%= c.getUsuario() %></td>
			<td>
				<form action="ServletCliente" method="post" onsubmit="return confirmar(event)">
					<input type="hidden" name="idCliente"
						value="<%= c.getIdCliente() %>" />
					<button type="submit" name="btnEditar" value="Editar">Editar</button>
					<button type="submit" name="btnEliminar" value="Eliminar">Eliminar</button>
				</form>
			</td>
		</tr>
		<%
            }
        %>
	</table>
 	<%
    Respuesta res = (Respuesta) session.getAttribute("EstadoCliente");
	   if (res != null) {
	%>
	   <p style="color: <%= res.isEstado() ? "green" : "red" %>">
	       <%= res.getMensaje() %>
	   </p>
	<%
    session.removeAttribute("EstadoCliente");
}
%>
	<%
        }
    %> <% 
    int paginaActual = (int) request.getAttribute("paginaActual");
    int totalPaginas = (int) request.getAttribute("totalPaginas");
%>

	<div>
		<% if (paginaActual > 1) { %>
		<a
			href="ServletCliente?Param=listarClientes&pagina=<%= paginaActual - 1 %>">Anterior</a>
		<% } %>

		<% for (int i = 1; i <= totalPaginas; i++) { %>
		<% if (i == paginaActual) { %>
		<strong><%= i %></strong>
		<% } else { %>
		<a href="ServletCliente?Param=listarClientes&pagina=<%= i %>"><%= i %></a>
		<% } %>
		<% } %>

		<% if (paginaActual < totalPaginas) { %>
		<a
			href="ServletCliente?Param=listarClientes&pagina=<%= paginaActual + 1 %>">Siguiente</a>
		<% } %>
	</div>
	</main>
</body>
</html>