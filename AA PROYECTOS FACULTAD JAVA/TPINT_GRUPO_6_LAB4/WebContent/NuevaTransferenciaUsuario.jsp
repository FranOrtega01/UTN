<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="entidad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nueva Transferencia</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body class="grid-body">
<%@include file="./MenuUsuario.jsp" %>
<%
	if(request.getAttribute("listaCu") == null){
		response.sendRedirect("ServletCuenta?Param=Transferencia");
		return;
	}
	List<Cuenta> lista = (List<Cuenta>)request.getAttribute("listaCu");
	String id = (String)request.getAttribute("id");
%>
<main> 
<h1>Nueva Transferencia</h1>

<% 
if (lista == null || lista.isEmpty()) {
    %>
        <p>No tienes cuentas para realizar una transferencia.</p>
    <%
        } else {
    %>
<form method="POST" action="ServletCuenta" onsubmit="return handleForm()">

    <label>
        Seleccione cuenta
        <select name="cuenta" id="cuenta">
            <option value="0" selected disabled>Seleccione una cuenta</option>
            <% for (Cuenta c : lista) { %>
                <option value=<%= c.getNroCuenta() %>><%= c.getNroCuenta() + " - " + c.getTipoCuenta().getDescripcion() + " ($" + c.getSaldo() +")" %></option>
            <% } %>
        </select>
    </label>
    <span id="error-cuenta" style="color: red;"></span>
    <br><br>
    
    <label>
        Ingrese el monto a transferir:
        <input type="text" name="monto" id="monto" />
    </label>
    <span id="error-monto" style="color: red;"></span>
    <br><br>
    
    <label>
        Ingrese CBU de la cuenta a transferir:
        <input type="text" name="cbu" id="cbu" />
    </label>
    <span id="error-cbu" style="color: red;"></span>
    <br><br>
    
    <label>
        Detalle:
        <input type="text" name="detalle" id="detalle">
    </label>
    <span id="error-detalle" style="color: red;"></span>
    <br><br>
    
    <input type="submit" name="btnNuevaTransferencia" value="Enviar Transferencia">
</form>

<script>
    function handleForm() {
        let valido = true;

        // cuenta 
        const cuenta = document.getElementById("cuenta");
        const errorCuenta = document.getElementById("error-cuenta");
        if (cuenta.value === "0") {
            errorCuenta.textContent = "Debe seleccionar una cuenta.";
            valido = false;
        } else {
            errorCuenta.textContent = "";
        }

     	// monto
        const monto = document.getElementById("monto");
        const errorMonto = document.getElementById("error-monto");
        if (!monto.value.trim()) {
            errorMonto.textContent = "El monto es obligatorio.";
            valido = false;
        } else if (!/^\d+(\.\d{1,2})?$/.test(monto.value.trim())) {
            errorMonto.textContent = "El monto debe ser un n�mero positivo de hasta 2 decimales.";
            valido = false;
        } else if (parseFloat(monto.value.trim()) <= 0) {
            errorMonto.textContent = "El monto debe ser mayor que 0.";
            valido = false;
        } else {
            errorMonto.textContent = "";
        }

        //  CBU
        const cbu = document.getElementById("cbu");
        const errorCbu = document.getElementById("error-cbu");
        if (!cbu.value.trim()) {
            errorCbu.textContent = "El CBU es obligatorio.";
            valido = false;
        } else if (!/^\d{22}$/.test(cbu.value.trim())) {
            errorCbu.textContent = "El CBU debe tener 22 d�gitos.";
            valido = false;
        } else {
            errorCbu.textContent = "";
        }

        // detalle
        const detalle = document.getElementById("detalle");
        const errorDetalle = document.getElementById("error-detalle");
        if (!detalle.value.trim()) {
            errorDetalle.textContent = "El detalle es obligatorio.";
            valido = false;
        } else if (detalle.value.trim().length > 20) {
            errorDetalle.textContent = "El detalle no puede tener m�s de 20 caracteres.";
            valido = false;
        } else {
        	
        	
            errorDetalle.textContent = "";
        }

        return valido;
    }
    </script>
<% } %>

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
</main>

</body>
</html>