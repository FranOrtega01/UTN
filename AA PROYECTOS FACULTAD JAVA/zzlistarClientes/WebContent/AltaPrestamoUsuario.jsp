<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitar Prestamo</title>
</head>
<body>
	<h1>Solicitar Prestamo</h1>
	<form method="" action="">
		<label>Monto</label>
		<input type="text" />
		<br><br>
		<label>Cuotas</label>
		<select> 
			<option value="0" selected disabled>Seleccionar Cuotas</option>
			<option value="3">3 Cuotas</option>
			<option value="6">6 Cuotas</option>
			<option value="12">12 Cuotas</option>
		</select>
		<br><br>
		<label>Cuenta</label>
		<select> 
			<option value="0" selected disabled>Seleccionar Cuenta</option>
		</select>
		<br><br><br>
		<input type="submit" value="Solicitar">

	</form>
</body>
</html>