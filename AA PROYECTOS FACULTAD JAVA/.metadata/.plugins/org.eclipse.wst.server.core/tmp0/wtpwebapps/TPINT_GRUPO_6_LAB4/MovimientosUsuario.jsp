<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
    <%@page import="entidad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mis Movimientos</title>
<link rel="stylesheet" href="styles.css">
</head>
<body class="grid-body">
<%@include file="./MenuUsuario.jsp" %>
<main> 
<h1>Mis Movimientos</h1>

<form method="GET" action="ServletCuenta" onsubmit="return validateForm()">
    <input type="hidden" name="Param" value="Movimientos">
    <input type="hidden" name="Nro" value="${param.Nro}">

    <label for="minimo">Mínimo:</label>
    <input type="number" id="minimo" name="minimo" step="0.01" value="${param.minimo != null ? param.minimo : ''}">
    <span id="error-minimo" style="color: red;"></span>
    
    <br>

    <label for="maximo">Máximo:</label>
    <input type="number" id="maximo" name="maximo" step="0.01" value="${param.maximo != null ? param.maximo : ''}">
    <span id="error-maximo" style="color: red;"></span>
    
    <br>

    <button type="submit">Filtrar</button>
    <a href="ServletCuenta?Param=Movimientos&Nro=${param.Nro}">Quitar Filtro</a>
</form>

<script>
function validateForm() {
    const minimo = document.getElementById("minimo").value.trim();
    const maximo = document.getElementById("maximo").value.trim();
    const errorMinimo = document.getElementById("error-minimo");
    const errorMaximo = document.getElementById("error-maximo");

    let isValid = true;

    errorMinimo.textContent = "";
    errorMaximo.textContent = "";

    if (minimo === "") {
        errorMinimo.textContent = "El valor mínimo es obligatorio.";
        isValid = false;
    }
    if (maximo === "") {
        errorMaximo.textContent = "El valor máximo es obligatorio.";
        isValid = false;
    }

    // Validar que mínimo no sea mayor que máximo
    if (minimo !== "" && maximo !== "" && parseFloat(minimo) > parseFloat(maximo)) {
        errorMaximo.textContent = "El valor máximo debe ser mayor o igual al mínimo.";
        isValid = false;
    }

    return isValid;
}
</script>

 <%
    	String nro = (String)request.getParameter("Nro");
 		List<Movimiento> lista = (List<Movimiento>)request.getAttribute("listaMov");
        if (lista == null || lista.isEmpty()) {
    %>
        <p>No hay ningun movmiento.</p>
    <%
        } else {
    %>

   <table border="1">
<tr>
<th>Fecha</th>
<th>Importe</th>
<th>Detalle</th>
<th>Tipo de Movimiento</th>
</tr>

        <%
            for (Movimiento m : lista) {
           
        %>
        <tr>
			<td><%= m.getFechaString() %></td>
			<td><%= ( m.getImporte() > 0 ? "+" : "" ) + m.getImporte() %></td>
			<td><%= m.getDetalle() %></td>
			<td><%= m.getTipoMovimiento().getDescripcion() %></td>
			</tr>
        <%
            }
        %>
    </table>

<%
        }
    %> 
    
<% 
    int paginaActual = (int) request.getAttribute("paginaActualMovimientos");
    int totalPaginas = (int) request.getAttribute("totalPaginasMovimientos");
%>

	<div>
		<% if (paginaActual > 1) { %>
	    <a
	        href="ServletCuenta?Param=Movimientos&Nro=<%= nro %>&pagina=<%= (paginaActual - 1) %>">  
		Anterior
	    </a>
		<% } %>

		<% for (int i = 1; i <= totalPaginas; i++) { %>
			<% if (i == paginaActual) { %>
			<b><%= i %></b>
			<% } else { %>
			<a href="ServletCuenta?Param=Movimientos&Nro=<%= nro %>&pagina=<%= i %>"><%= i %></a>
			<% } %>
		<% } %>
	
		<% if (paginaActual < totalPaginas) { %>
		<a
			href="ServletCuenta?Param=Movimientos&Nro=<%= nro %>&&pagina=<%= paginaActual + 1 %>">Siguiente</a>
		<% } %>
		
	</div>

</main>
</body>
</html>