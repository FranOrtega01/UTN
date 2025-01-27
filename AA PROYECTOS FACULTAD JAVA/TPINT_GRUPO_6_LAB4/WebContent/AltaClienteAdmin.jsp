<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar usuario</title>
<link rel="stylesheet" href="styles.css">
</head>
<body class="grid-body">
	<script type="text/javascript">
		function handleForm(event) {
			let valido = true;

			let errores = document.querySelectorAll(".error");
			for (let i = 0; i < errores.length; i++) {
				errores[i].textContent = "";
			}

			// Validar campos obligatorios

			let textInputs = document.querySelectorAll(".input");
			for (let i = 0; i < textInputs.length; i++) {
				const id = textInputs[i].id;
				const campo = document.getElementById(id);
				if (!campo.value.trim()) {
					document.getElementById("error-" + id).textContent = "Este campo es obligatorio.";
					valido = false;
				}
			}

			const ID = document.getElementById("dni").value.trim();
			if(ID.length != 8){
				document.getElementById("error-dni").textContent = "el DNI debe tener 8 digitos.";
				valido = false;
			}
			
			const cuil = document.getElementById("cuil").value.trim();
			const cuilRegex = /^\d{2}-\d{8}-\d{1}$/ ;
			if (!cuilRegex.test(cuil)) {
				document.getElementById("error-cuil").textContent = "El cuil debe estar en formato xx-xxxxxxxx-x";
				valido = false;
			}
			// Validar Fecha de Nacimiento (mayor a 18 a�os)
			const fechaNacimiento = document.getElementById("fecha_nacimiento").value;
			const hoy = new Date();
			const fechaMinima = new Date(hoy.getFullYear() - 18,
					hoy.getMonth(), hoy.getDate());
			if (new Date(fechaNacimiento) > fechaMinima) {
				document.getElementById("error-fecha-nacimiento").textContent = "Debe ser mayor de 18 a�os.";
				valido = false;
			}

			// Validar Email (formato correcto)
			const email = document.getElementById("email").value.trim();
			const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
			if (!emailRegex.test(email)) {
				document.getElementById("error-email").textContent = "Debe ingresar un email v�lido.";
				valido = false;
			}

			// Validar Claves (que coincidan)
			const clave = document.getElementById("clave").value;
			const claveConf = document.getElementById("claveConf").value;
			if (clave !== claveConf) {
				document.getElementById("error-claveConf").textContent = "Las claves no coinciden.";
				valido = false;
			}

			return valido;
		}
	</script>
	<%@include file="./MenuAdmin.jsp"%>
	<main>
	<h1>Agregar usuario</h1>
	<form action="ServletCliente" method="post"
		onsubmit="return handleForm(event)">
		<table>
			<tr>
				<td><label for="dni">DNI:</label></td>
				<td><input class="input" type="number" id="dni" name="txtDni">
					<span class="error" id="error-dni" style="color: red;"></span></td>
			</tr>
			<tr>
				<td><label for="cuil">CUIL:</label></td>
				<td><input class="input" type="text" id="cuil" name="txtCuil">
					<span class="error" id="error-cuil" style="color: red;"></span></td>
			</tr>
			<tr>
				<td><label for="nombre">Nombre:</label></td>
				<td><input class="input" type="text" id="nombre"
					name="txtNombre"> <span class="error" id="error-nombre"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td><label for="apellido">Apellido:</label></td>
				<td><input class="input" type="text" id="apellido"
					name="txtApellido"> <span class="error" id="error-apellido"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td><label for="sexo">Sexo:</label></td>
				<td><label for="M"> <input type="radio" checked id="M"
						name="txtSexo" value="M"> Hombre
				</label> <label for="F"> <input type="radio" id="F" name="txtSexo"
						value="F"> Mujer
				</label></td>
			</tr>
			<tr>
				<td><label for="fecha_nacimiento">Fecha de Nacimiento:</label></td>
				<td><input type="date" id="fecha_nacimiento"
					name="txtFecha_Nacimiento"> <span class="error"
					id="error-fecha-nacimiento" style="color: red;"></span></td>
			</tr>

			<tr>
				<td><label for="nacionalidad">Nacionalidad:</label></td>
				<td><input class="input" type="text" id="nacionalidad"
					name="txtNacionalidad"> <span class="error"
					id="error-nacionalidad" style="color: red;"></span></td>
			</tr>

			<tr>
				<td><label for="provincia">Provincia:</label></td>
				<td><select class="input" id="provincia" name="ddlProvincia">
						<option value="" selected disabled>Seleccione una
							provincia</option>
						<option value="Buenos Aires">Buenos Aires</option>
						<option value="Catamarca">Catamarca</option>
						<option value="Chaco">Chaco</option>
						<option value="Chubut">Chubut</option>
						<option value="C�rdoba">C�rdoba</option>
						<option value="Corrientes">Corrientes</option>
						<option value="Entre R�os">Entre R�os</option>
						<option value="Formosa">Formosa</option>
						<option value="Jujuy">Jujuy</option>
						<option value="La Pampa">La Pampa</option>
						<option value="La Rioja">La Rioja</option>
						<option value="Mendoza">Mendoza</option>
						<option value="Misiones">Misiones</option>
						<option value="Neuqu�n">Neuqu�n</option>
						<option value="R�o Negro">R�o Negro</option>
						<option value="Salta">Salta</option>
						<option value="San Juan">San Juan</option>
						<option value="San Luis">San Luis</option>
						<option value="Santa Cruz">Santa Cruz</option>
						<option value="Santa Fe">Santa Fe</option>
						<option value="Santiago del Estero">Santiago del Estero</option>
						<option value="Tierra del Fuego">Tierra del Fuego</option>
						<option value="Tucum�n">Tucum�n</option>
				</select> <span class="error" id="error-provincia" style="color: red;"></span>
				</td>
			</tr>

			<tr>
				<td><label for="localidad">Localidad:</label></td>
				<td><input class="input" type="text" id="localidad"
					name="txtLocalidad"> <span class="error"
					id="error-localidad" style="color: red;"></span></td>
			</tr>
			<tr>
				<td><label for="direccion">Direcci�n:</label></td>
				<td><input class="input" type="text" id="direccion"
					name="txtDireccion"> <span class="error"
					id="error-direccion" style="color: red;"></span></td>
			</tr>

			<tr>
				<td><label for="email">Email:</label></td>
				<td><input class="input" type="email" id="email"
					name="txtEmail"> <span class="error" id="error-email"
					style="color: red;"></span></td>
			</tr>

			<tr>
				<td><label for="telefono">Tel�fono:</label></td>
				<td><input class="input" type="text" id="telefono"
					name="txtTelefono"> <span class="error" id="error-telefono"
					style="color: red;"></span></td>
			</tr>

			<tr>
				<td><label for="usuario">Usuario:</label></td>
				<td><input class="input" type="text" id="usuario"
					name="txtUsuario"> <span class="error" id="error-usuario"
					style="color: red;"></span></td>
			</tr>

			<tr>
				<td><label for="clave">Clave:</label></td>
				<td><input class="input" type="password" id="clave"
					name="txtClave"> <span class="error" id="error-clave"
					style="color: red;"></span></td>
			</tr>
			<tr>
				<td><label for="claveConf">Confirmar Clave:</label></td>
				<td><input class="input" type="password" id="claveConf"
					name="txtClaveConf"> <span class="error"
					id="error-claveConf" style="color: red;"></span></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<button type="submit" name="btnAceptar">Agregar Usuario</button>
				</td>
			</tr>
		</table>

	</form>

	<%
		Respuesta res = (Respuesta) request.getAttribute("EstadoCliente");
		if (res != null) {
	%> <br>
	<p style="color: <%=res.isEstado() ? "green" : "red"%>">
		<%=res.getMensaje()%></p>
	<%
		}
	%> </main>

</body>
</html>
