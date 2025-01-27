<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@page import="entidad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Cuenta</title>
<link rel="stylesheet" href="styles.css">
</head>
<style>
table {
	border-collapse: collapse;
	width: 30%;
}

td {
	padding: 2px;
}

td label {
	font-weight: bold;
	margin-right: 2px;
}

input[type="text"], select {
	width: 95%;
	box-sizing: border-box;
}
</style>
</head>
<body class="grid-body">
<%@include file="./MenuAdmin.jsp"%>
<main>
    <h1>Agregar Cuenta</h1>
    <form action="ServletCuenta" method="post" onsubmit="return handleForm();">
        <table>
            <tr>
                <td><label for="txtId">Id del cliente:</label></td>
                <td>
                    <input type="number" name="txtId" id="txtId" class="input">
                    <span id="error-txtId" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label>Tipo de Cuenta:</label></td>
                <td>
                    <label for="tipoCuentaCA">Caja de Ahorro
                        <input type="radio" checked name="tipoCuenta" id="tipoCuentaCA" value="1-Caja de Ahorro">
                    </label>
                    <label for="tipoCuentaCC">Cuenta Corriente
                        <input type="radio" name="tipoCuenta" id="tipoCuentaCC" value="2-Cuenta Corriente">
                    </label>
                </td>
            </tr>
            <tr>
                <td><label for="txtCbu">CBU:</label></td>
                <td>
                    <input type="text" name="txtCbu" id="txtCbu" class="input">
                    <span id="error-txtCbu" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Aceptar" name="btnAceptar">
                </td>
            </tr>
        </table>
    </form>
    <%
    	Respuesta res = (Respuesta)request.getAttribute("EstadoCuenta");
        if (res != null) {
    %> 
        <br>
        <p style="color: <%= res.isEstado() ? "green" : "red"%>"> <%= res.getMensaje() %></p>
    <%
        }
    %>
</main>

<script>
    function handleForm() {
        let valido = true;

        document.getElementById("error-txtId").textContent = "";
        document.getElementById("error-txtCbu").textContent = "";

        const txtId = document.getElementById("txtId").value.trim();
        if (txtId === "") {
            document.getElementById("error-txtId").textContent = "El ID del cliente debe ser un n�mero y no puede estar vac�o.";
            valido = false;
        }

        const cbu = document.getElementById("txtCbu");
        if (txtCbu.value.trim() === "") {
            document.getElementById("error-txtCbu").textContent = "El CBU es obligatorio.";
            valido = false;
        }else if(!/^\d{22}$/.test(cbu.value.trim())){
        	document.getElementById("error-txtCbu").textContent = "El CBU debe tener 22 n�meros.";
            valido = false;
        }

        // Previene el env�o si alguna validaci�n falla
        return valido;
    }
</script>

</body>
</html>