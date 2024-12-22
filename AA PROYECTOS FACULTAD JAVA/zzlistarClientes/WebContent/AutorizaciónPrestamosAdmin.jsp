<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Autorización de Préstamos</title>
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
        h2 {
            text-align: center;
            color: #4CAF50;
        }
        .loan-info, .authorization-form {
            margin: 20px 0;
        }
        .loan-info p {
            font-size: 16px;
            margin: 8px 0;
        }
        .authorization-form label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        .authorization-form select, .authorization-form textarea, .authorization-form button {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        .authorization-form button {
            background-color: #4CAF50;
            color: #fff;
            cursor: pointer;
            font-size: 16px;
            border: none;
            transition: background-color 0.3s;
        }
        .authorization-form button:hover {
            background-color: #45a049;
        }
        .message {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
            color: #4CAF50;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Autorización de Préstamos</h2>

    <!-- Información del Préstamo -->
    <div class="loan-info">
        <p><strong>ID del Préstamo:</strong></p>
        <p><strong>Solicitante:</strong></p>
        <p><strong>Monto Solicitado:</strong></p>
        <p><strong>Fecha de Solicitud:</strong></p>
        <p><strong>Estado Actual:</strong></p>
    </div>

    <!-- Formulario de Autorización -->
    <form class="authorization-form" action="authorizeLoan" method="post">
        <input type="hidden" name="loanId" value="${loan.id}" />

        <label for="decision">Decisión</label>
        <select name="decision" id="decision" required>
            <option value="">Seleccionar una opción</option>
            <option value="approved">Aprobar</option>
            <option value="rejected">Rechazar</option>
        </select>

        <label for="comments">Comentarios</label>
        <textarea name="comments" id="comments" rows="4" placeholder="Escribe tus comentarios (opcional)"></textarea>

        <button type="submit">Enviar Decisión</button>
    </form>
    </div>

</body>
</html>
