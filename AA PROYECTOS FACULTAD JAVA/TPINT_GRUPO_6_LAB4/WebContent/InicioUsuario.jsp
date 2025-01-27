<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="entidad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<title>Incio</title>
</head>
<style>
h2 {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

.cuentaContainer {
	display: flex;
	gap: 10px;
	flex-wrap: wrap;
}

.cuenta {
	border: 1px solid black;
	padding: 2px 5px
}
</style>
<body class="grid-body">
	<%@include file="./MenuUsuario.jsp"%>
	<%
		Cookie[] cookies = request.getCookies();

		String userID = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("userID".equals(cookie.getName())) {
					userID = cookie.getValue();
				}
			}
		}

		if (request.getAttribute("listaCu") == null) {
			response.sendRedirect("ServletCuenta?Param=listarCuentas");
			return;
		}

		List<Cuenta> lista = (List<Cuenta>) request.getAttribute("listaCu");
	%>
	<main>
	<h1>Inicio Usuario</h1>

	<div class="cuentaContainer">
		<%
			if (lista == null || lista.isEmpty()) {
		%>
		<p>
			No hay cuentas disponibles. <a
				href="CrearSolicitudAltaCuentaUsuario.jsp">Solicitar nueva
				cuenta</a>
		</p>
		<%
			} else {
				for (Cuenta c : lista) {
		%>
		<div class="cuenta">
			<h2>
				<%=c.getTipoCuenta().getDescripcion() + " - " + c.getNroCuenta() %></h2>
			<p><%=c.getCbu()%></p>
			<p>
				$
				<%=c.getSaldo()%>
			<p />
			<a
				href=<%="ServletCuenta?Param=Movimientos&Nro=" + c.getNroCuenta()%>>Ir
				a movimientos</a>
		</div>
		<%
			}
		%>
	</div>
	<%
		}
	%> </main>
</body>
</html>