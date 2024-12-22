<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="entidad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar Prestamo</title>
<link rel="stylesheet" href="styles.css">
</head>
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

		if (session.getAttribute("listaCu") == null) {
			response.sendRedirect("ServletCuenta?Param=Prestamo");
		}

		List<Cuenta> lista = (List<Cuenta>) session.getAttribute("listaCu");
	%>
	<main>
	<h1>Solicitar Prestamo</h1>
	<%
		if (lista == null || lista.isEmpty()) {
	%>
	<p>No tienes cuentas para solicitar un prestamo.</p>
	<%
		} else {
        if (request.getAttribute("mensajeError") != null) {
    %>
        <p style="color: red; text-align: center;"><%= request.getAttribute("mensajeError") %></p>
    <%
        }
    %>

	<form method="POST" action="ServletPrestamo"
		onsubmit="return handleForm()">
		<label>Monto</label> <input name="monto" id="monto" type="text" /> <span
			id="error-monto" style="color: red;"></span> <br> <br> <label>Cuotas</label>
		<select name="cuotas" id="cuotas">
			<option value="" selected disabled>Seleccionar Cuotas</option>
			<option value="3">3 Cuotas (10% interés)</option>
			<option value="6">6 Cuotas (20% interés)</option>
			<option value="12">12 Cuotas (40% interés)</option>
		</select> <span id="error-cuotas" style="color: red;"></span> <br> <br>
		<label> Seleccione cuenta <select name="cuenta" id="cuenta">
				<option value="" selected disabled>Seleccione una cuenta</option>
				<%
					for (Cuenta c : lista) {
				%>
				<option value=<%=c.getNroCuenta()%>><%=c.getNroCuenta() + " - " + c.getTipoCuenta().getDescripcion() + " ($" + c.getSaldo() + ")"%></option>
				<%
					}
				%>
		</select>
		</label> <span id="error-cuenta" style="color: red;"></span> <br> <br>
		<br> <input type="submit" name="SolicitarPrestamo"
			value="Solicitar Prestamo">
	</form>

	<script>
		function handleForm(){
			
			let valido = true;
			
			// Validación del monto
			const monto = document.getElementById("monto");
			const errorMonto = document.getElementById("error-monto");

			if (!monto.value.trim()) {
			    errorMonto.textContent = "Este campo es obligatorio.";
			    valido = false;
			} else if (!/^\d+(\.\d{1,2})?$/.test(monto.value.trim())) {
			    errorMonto.textContent = "El monto debe ser un número positivo con hasta 2 decimales.";
			    valido = false;
			} else if (parseFloat(monto.value.trim()) > 50000) {
			    errorMonto.textContent = "El monto no puede ser mayor a $50,000.";
			    valido = false;
			} else {
			    errorMonto.textContent = "";
			}
			
			// Validación de las cuotas
			const cuotasSelect = document.getElementById("cuotas");
			const errorCuotas = document.getElementById("error-cuotas");
			if (!cuotasSelect.value) {
			    errorCuotas.textContent = "Debe seleccionar una opción.";
			    valido = false;
			} else {
			    errorCuotas.textContent = "";
			}
			
			// Validación de la cuenta
			const cuentaSelect = document.getElementById("cuenta");
			const errorCuenta = document.getElementById("error-cuenta");
			if (!cuentaSelect.value) {
			    errorCuenta.textContent = "Debe seleccionar una cuenta.";
			    valido = false;
			} else {
			    errorCuenta.textContent = "";
			}
			
			// Evitar el envío si hay errores
			if (!valido) {
			    event.preventDefault();
			}
		}
</script> <%
 	}
 %> <%
 	if (request.getAttribute("estado") != null) {
 %>
	<p>
		Estado:
		<%=((Boolean) request.getAttribute("estado")) ? "Prestamo solicitado con exito" : "Ocurrio un error."%>
	</p>
	<%
		}
	%> </main>
</body>
</html>