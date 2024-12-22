<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="entidad.Cuenta"%>
<%@page import="negocioImpl.CuentaNegImpl"%>
<%@page import="negocio.CuentaNeg"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Cuenta</title>
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
<body>
    <h1>Editar Cuenta</h1>
    <%
        Cuenta cuenta = (Cuenta) request.getAttribute("cuenta");
    %>
    <form action="ServletCuenta" method = "post">
        <input type="hidden" name="nroCuenta" value="<%= cuenta.getNroCuenta() %>">
        <table>
            <tr>
                <td><label>Id del cliente:</label></td>
                <td><input readonly type="text" name = "txtId" value="<%= cuenta.getIdCliente() %>"></td>
            </tr>
            <tr>
                <td><label>Tipo de Cuenta:</label></td>
                <td>
                    <select name = "ddlTipoCuenta">
                        <option value="0" selected disabled>Seleccione un tipo de cuenta</option>
                        <option value="1-Cuenta de Ahorro" <% if(cuenta.getTipoCuenta().getIdTipo()==1) { %> selected <% } %>>Cuenta de Ahorro</option>
                        <option value="2-Cuenta Corriente" <% if(cuenta.getTipoCuenta().getIdTipo()==2) { %> selected <% } %>>Cuenta Corriente</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>CBU:</label></td>
                <td><input readonly type="text" name = "txtCbu" value="<%= cuenta.getCbu() %>"></td>
            </tr>
            <tr>
                <td><label>Saldo:</label></td>
                <td><input readonly type="text" name = "txtSaldo" value="<%= cuenta.getSaldo() %>"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Aceptar" name = "btnConfirmarEdicion">
                </td>
                <td>
                	<input type="submit" value="Cancelar" name = "btnCancelarEdicion">
                </td>
                
            </tr>
        </table>
    </form>
</body>
</html>