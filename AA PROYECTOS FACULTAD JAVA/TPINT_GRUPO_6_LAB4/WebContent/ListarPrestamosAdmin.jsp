<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
    <%@page import="entidad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos Solicitados</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body class="grid-body">
<%@include file="./MenuAdmin.jsp" %>

<%
	if(request.getAttribute("listaPr") == null){
		response.sendRedirect("ServletPrestamo?Param=listarPrestamos");
		return;
	}
%>
<main> 
	<h1>Prestamos Solicitados</h1>
	
	<form method="GET" action="ServletPrestamo">
        <input type="hidden" name="Param" value="listarPrestamos" />
        <label for="idCuenta">Filtrar por ID Cuenta:</label>
        <input type="text" id="idCuenta" name="idCuenta" value="<%= request.getParameter("idCuenta") != null ? request.getParameter("idCuenta") : "" %>" />
    <label for="estado">Filtrar por Estado:</label>
    <select id="estado" name="estado">
        <option value="">--Todos--</option>
        <option value="Pendiente" <%= "Pendiente".equals(request.getParameter("estado")) ? "selected" : "" %>>Pendiente</option>
        <option value="Aprobado" <%= "Aprobado".equals(request.getParameter("estado")) ? "selected" : "" %>>Aprobado</option>
        <option value="Rechazado" <%= "Rechazado".equals(request.getParameter("estado")) ? "selected" : "" %>>Rechazado</option>
        <option value="Pagado" <%= "Pagado".equals(request.getParameter("estado")) ? "selected" : "" %>>Pagado</option>
    </select>
        <button type="submit">Filtrar</button>
        <a href="ServletPrestamo?Param=listarPrestamos">Quitar Filtro</a>
    </form>
	<%
    	List<Prestamo> lista = (List<Prestamo>) request.getAttribute("listaPr");
        if (lista == null || lista.isEmpty()) {
    %>
        <p>No hay prestamos disponibles.</p>
    <%
        } else {
    %>
	<table border="1">
		<tr>
			<th>ID Prestamo</th>
			<th>ID Cuenta</th>
			<th>Fecha</th>
			<th>Importe Pedido</th>
			<th>Importe a Pagar</th>
			<th>Plazo de Pago</th>
			<th>Monto por Mes</th>
			<th>Cuotas</th>
			<th>Cuotas Pagas</th>
			<th>Estado</th>
		</tr>
   		<%
            for (Prestamo p : lista) {
        %>
        <tr>
            <td><%= p.getIdPrestamo() %></td>
            <td><%= p.getIdCuenta() %></td>
            <td><%= p.getFecha() %></td>
            <td><%= p.getImportePedido() %></td>
            <td><%= p.getImporteAPagar() %></td>
            <td><%= p.getPlazoPago() %></td>
            <td><%= p.getMontoMensual() %></td>
            <td><%= p.getCuotas() %></td>
            <td><%= "Aprobado".equals(p.getEstado()) ? p.getCuotasPagas() : "-"%></td>
            <td><%= p.getEstado() %></td>
            <% if ("Pendiente".equals(p.getEstado())) { %>
            <td> 
            <form action="ServletPrestamo" method="post">
       			<input type="hidden" name="idPrestamo" value="<%= p.getIdPrestamo() %>" />
      		 		<button type="submit" name = "btnAprobar" value="Aprobado">Aprobar</button>
      		 		<button type="submit" name = "btnRechazar" value="Rechazado">Rechazar</button>
   			</form>
            </td>   			
	        <%
	            }
	        %>
        </tr>
        <% } %>
    </table>
    <%
        }
    %>
    
    <% if(request.getAttribute("estado") != null) { %>
    <p> Estado del Prestamo: <%= request.getAttribute("estado") %> </p>
	<% } %>
	
		<% 
    int paginaActual = (int) request.getAttribute("paginaActual");
    int totalPaginas = (int) request.getAttribute("totalPaginas");
%>

<div>
    <% if (paginaActual > 1) { %>
        <a href="ServletPrestamo?Param=listarPrestamos&pagina=<%= paginaActual - 1 %>">Anterior</a>
    <% } %>

    <% for (int i = 1; i <= totalPaginas; i++) { %>
        <% if (i == paginaActual) { %>
            <strong><%= i %></strong>
        <% } else { %>
            <a href="ServletPrestamo?Param=listarPrestamos&pagina=<%= i %>"><%= i %></a>
        <% } %>
    <% } %>

    <% if (paginaActual < totalPaginas) { %>
        <a href="ServletPrestamo?Param=listarPrestamos&pagina=<%= paginaActual + 1 %>">Siguiente</a>
    <% } %>
</div>

</main>
</body>
</html>