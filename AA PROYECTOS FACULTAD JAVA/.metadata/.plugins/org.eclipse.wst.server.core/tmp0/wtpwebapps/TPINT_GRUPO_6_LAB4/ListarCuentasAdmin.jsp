<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="entidad.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Cuentas</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body class="grid-body">
<%@include file="./MenuAdmin.jsp" %>
<script>
function toggleInput() {
    const select = document.getElementById('filtro');
    const input = document.getElementById('txtFiltro');
    const btnFiltrar = document.getElementById('btnFiltrar');
    
    if (select.value === "0") {
        input.value = "";          // Borrar el contenido del campo de texto
        input.disabled = true;     // Deshabilitar la edici�n del campo de texto
        btnFiltrar.disabled = true; // Deshabilitar el bot�n Filtrar
    } else {
        input.disabled = false;    // Habilitar la edici�n del campo de texto
        btnFiltrar.disabled = false; // Habilitar el bot�n Filtrar
    }
}


function handleForm(event){
	if (event.submitter.value === "listarCuentas") {
        return true;
    }
	let valido = true;
	
    const filtro = document.getElementById('filtro').value.trim();
    const txtFiltro = document.getElementById('txtFiltro');
    const valorFiltro = txtFiltro.value.trim();

    const errorElement = document.getElementById('error-txtFiltro');
    if (errorElement) {
        errorElement.remove();
    }
	
    // Validar seg�n el filtro seleccionado
    switch (filtro) {
        case "Nro_cuenta":
        case "Id_cliente":
            if (!/^\d+$/.test(valorFiltro)) {
                crearError("Debe ser un n�mero entero.");
                valido = false;
            }
            break;
        case "Tipo_cuenta":
            if (!/^[12]$/.test(valorFiltro)) {
                crearError("Debe ser 1 (Caja de Ahorro) o 2 (Cuenta Corriente).");
                valido = false;
            }
            break;
        case "Cbu":
            if (!/^\d{22}$/.test(valorFiltro)) {
                crearError("El CBU debe tener exactamente 22 d�gitos.");
                valido = false;
            }
            break;
        default:
            crearError("Seleccione un filtro v�lido.");
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
</script>
<main> 
<h1>ABML Cuentas</h1>
<form action="ServletCuenta" method="get" onsubmit="return handleForm(event)">
    <label for="filtro">Seleccionar Filtro:</label> 
    <select name="filtro" id="filtro" onchange="toggleInput()">
        <option value="0">Seleccione</option>
        <option value="Nro_cuenta">Nro de cuenta</option>
        <option value="Id_cliente">Id de cliente</option>
        <option value="Tipo_cuenta">Tipo de cuenta</option>
        <option value="Cbu">CBU</option>
    </select>
    <input type="text" name="txtFiltro" id="txtFiltro" disabled> 
    <br/>
    <button type="submit" name="Param" id="btnFiltrar" value="filtrarCuentas" disabled>Filtrar</button>
    <button type="submit" name="Param" value="listarCuentas">Eliminar Filtros</button>
</form>
 	<%
 		List<Cuenta> lista = (List<Cuenta>) request.getAttribute("listaCu");
 		
 	
        if (lista == null || lista.isEmpty()) {
    %>
        <p>No hay cuentas disponibles.</p>
    <%
        } else {
    %>
	

	
	<table border="1">
		<tr>
			<th>Nro Cuenta</th>
			<th>ID Cliente</th>
			<th>Fecha de Creacion</th>
			<th>Tipo de Cuenta</th>
			<th>CBU</th>
			<th>Saldo</th>
		</tr>
		<%
            for (Cuenta c : lista) {
        %>
        <tr>
            <td><%= c.getNroCuenta() %></td>
            <td><%= c.getIdCliente() %></td>
            <td><%= c.getFechaCreacion() %></td>
            <td><%= c.getTipoCuenta().getDescripcion() %></td>
            <td><%= c.getCbu() %></td>
            <td><%= c.getSaldo() %></td>
            <td>
    			<form action="ServletCuenta" method="post" onsubmit="return confirmar(event);">
        			<input type="hidden" name="nroCuenta" value="<%= c.getNroCuenta() %>" />
       		 		<button type="submit" name = "btnEditar" value="Editar">Editar</button>
       		 		<button type="submit" name = "btnEliminar" value="Eliminar">Eliminar</button>
    			</form>
    		</td>
        </tr>
        <%
            }
        %>
    </table>

    <%
        }
    %>
    
        <% 
    Integer paginaActual = (Integer) request.getAttribute("paginaActual");
    Integer totalPaginas = (Integer) request.getAttribute("totalPaginas");
%>

<%
    if (paginaActual != null && totalPaginas != null && totalPaginas > 1) {
%>
<div>
    <% if (paginaActual > 1) { %>
        <a href="ServletCuenta?Param=listarCuentas&pagina=<%= paginaActual - 1 %>">Anterior</a>
    <% } %>

    <% for (int i = 1; i <= totalPaginas; i++) { %>
        <% if (i == paginaActual) { %>
            <strong><%= i %></strong>
        <% } else { %>
            <a href="ServletCuenta?Param=listarCuentas&pagina=<%= i %>"><%= i %></a>
        <% } %>
    <% } %>

    <% if (paginaActual < totalPaginas) { %>
        <a href="ServletCuenta?Param=listarCuentas&pagina=<%= paginaActual + 1 %>">Siguiente</a>
    <% } %>
</div>
<%
    }
%>
</main>
</body>
</html>