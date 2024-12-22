<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar Cuenta</title>
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
    <h1>Agregar Cuenta</h1>
    <form method="" action="">
        <table>
            <tr>
                <td><label>Id del cliente:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Fecha de nreacion:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td><label>Tipo de Cuenta:</label></td>
                <td>
                    <select>
                        <option value="0" selected disabled>Seleccione un tipo de cuenta</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>CBU:</label></td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Aceptar">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>