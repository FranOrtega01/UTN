<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Solicitar Creación de Usuario</title>
    <link rel="stylesheet" href="styles.css"> <!-- Vincula tu CSS personalizado aquí -->
    <style>
        /* Estilos básicos para mejorar la apariencia */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            color: #333;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            width: 60%;
            max-width: 800px;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        h1 {
            text-align: center;
            color: #4CAF50;
            font-size: 2.5em;
        }
        form table {
            width: 100%;
            border-collapse: collapse;
        }
        form table td {
            padding: 10px;
        }
        form label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #333;
        }
        form input[type="text"],
        form select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
            color: #333;
        }
        form input[type="radio"] {
            margin-right: 5px;
        }
        form input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            padding: 10px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            width: 100%;
        }
        form input[type="submit"]:hover {
            background-color: #45a049;
        }
        .account-type {
            text-align: center;
            margin-top: 10px;
            color: #333;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Solicitar Creación de Cuenta</h1>
    <form action="" method="">
        <table>
            <tr>
                <td colspan="2" class="account-type">
                    <label>Cuenta Corriente</label>
                    <input type="radio" name="tipo_cuenta" value="corriente">
                    <label>Caja de Ahorro</label>
                    <input type="radio" name="tipo_cuenta" value="ahorro">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="submit" value="Aceptar">
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
