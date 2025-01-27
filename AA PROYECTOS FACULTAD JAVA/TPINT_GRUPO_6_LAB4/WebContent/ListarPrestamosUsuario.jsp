<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
<%@page import="entidad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mis Prestamos</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body class="grid-body">
<%
	if(request.getAttribute("listaPr") == null){
		response.sendRedirect("ServletPrestamo?Param=listarPrestamos");
		return;
	}
%>
<%@include file="./MenuUsuario.jsp" %>
<main> 
	<h1>Mis Prestamos</h1>
	
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

<script>
    function handleFormCuenta() {
        const idCuenta = document.getElementById("idCuenta").value.trim();
        const errorIdCuenta = document.getElementById("errorIdCuenta");
        let valido = true;

        errorIdCuenta.textContent = "";

        if (!idCuenta) {
            errorIdCuenta.textContent = "El campo ID Cuenta es obligatorio.";
            valido = false;
        }

        return valido;
    }

    function handleFormEstado() {
        const selectEstado = document.getElementById("selectEstado").value;
        const errorEstado = document.getElementById("errorEstado");
        let valido = true;

        errorEstado.textContent = "";

        if (!selectEstado) {
            errorEstado.textContent = "Seleccione un estado.";
            valido = false;
        }

        return valido;
    }
</script>
	
	<%
    	List<Prestamo> lista = (List<Prestamo>) request.getAttribute("listaPr");
        if (lista == null || lista.isEmpty()) {
    %>
        <p>No tienes prestamos... <a href="ServletCuenta?Param=Prestamo">Soliticar uno.</a> </p>
    <%
        } else {
    %>
	<table border="1">
		<tr>
			<th>Fecha</th>
			<th>Cuenta</th>
			<th>Importe</th>
			<th>Importe a Pagar</th>
			<th>Cuotas</th>
			<th>Monto Cuota </th>
			<th>Estado</th>
			<th>Pagar Cuotas </th>
		</tr>
		<%
            for (Prestamo p : lista) {
        %>
        <tr>
            <td><%= p.getFecha() %></td>
            <td><%= p.getIdCuenta() %></td>
            <td><%= p.getImportePedido() %></td>
            <td><%= p.getImporteAPagar() %></td>
            <td><%= p.getCuotas() %></td>
            <td><%= p.getMontoMensual() %></td>
            <td><%= p.getEstado() %></td>
            
            <td> 
            <% if ("Aprobado".equals(p.getEstado())) { %>
            <form action="ServletPrestamo" method="post">
       			<input type="hidden" name="idPrestamo" value="<%= p.getIdPrestamo() %>" />
      		 	<button type="submit" name = "btnPagarCuota" value=<%= p.getCuotasPagas() + 1 %>> <%= "Pagar cuota " + (p.getCuotasPagas() + 1) + "/" + p.getCuotas() %> </button>
   			</form>
	        <%
	            }else{
	        %>
	        	<p> <%= "Prestamo " + p.getEstado() %> </p>
	        <%} %>
            </td>   			
        </tr>
        <% } %>
	</table>
	<% } %>
	
	<% 
    int paginaActual = (int) request.getAttribute("paginaActual");
    int totalPaginas = (int) request.getAttribute("totalPaginas");
%>

<%
		Respuesta res = (Respuesta) session.getAttribute("estado");
		if (res != null) {
				
		%> <br>
		<p style="color: <%=res.isEstado() ? "green" : "red"%>">
			<%=res.getMensaje()%></p>
		<%
			session.removeAttribute("estado");
			}
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