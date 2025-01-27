<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="entidad.*"%>
<%@page import="negocioImpl.ClienteNegImpl"%>
<%@page import="negocio.ClienteNeg"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar usuario</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body class=grid-body>
    <%
    	if(request.getAttribute("cliente") == null && session.getAttribute("cliente") == null){
    		response.sendRedirect("ServletCliente?Param=listarClientes");
    		return;
    	}
    	
        Cliente cliente = (Cliente)request.getAttribute("cliente");
        
        String fecha = null;
        
        if(session.getAttribute("cliente") != null){
        	cliente = (Cliente)session.getAttribute("cliente");
        	fecha = cliente.getFechaNacimientoString();
        }
    
   		String [] provs = {	"Buenos Aires","Catamarca","Chaco","Chubut","C�rdoba","Corrientes","Entre R�os","Formosa","Jujuy","La Pampa","La Rioja","Mendoza","Misiones",
		"Neuqu�n","R�o Negro","Salta","San Juan","San Luis","Santa Cruz","Santa Fe","Santiago del Estero","Tierra del Fuego","Tucum�n"};
   
   		String provCliente = cliente.getProvincia();
    %>
<%@include file="./MenuAdmin.jsp"%>
<main>
    <h1>Editar Cliente</h1>
    <form action="ServletCliente" method="post" onsubmit="return handleForm(event)">
        <input type="hidden" name="idCliente" value="<%= cliente.getIdCliente() %>" />
        <table>
            <tr>
                <td><label for="dni">DNI:</label></td>
                <td>
                    <input class="input"  type="number" id="dni" name="txtDni" value="<%= cliente.getDni() %>">
                    <span class="error" id="error-dni" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="cuil">CUIL:</label></td>
                <td>
                    <input class="input"  type="text" id="cuil" name="txtCuil" value="<%= cliente.getCuil() %>">
                    <span class="error" id="error-cuil" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="nombre">Nombre:</label></td>
                <td>
                    <input class="input"  type="text" id="nombre" name="txtNombre" value="<%= cliente.getNombre() %>">
                    <span class="error" id="error-nombre" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="apellido">Apellido:</label></td>
                <td>
                    <input class="input"  type="text" id="apellido" name="txtApellido" value="<%= cliente.getApellido() %>">
                    <span class="error" id="error-apellido" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="sexo">Sexo:</label></td>
                <td>
                    <% char sexo = cliente.getSexo(); %>
                    <label for="H">
                        <input type="radio" id="M" <%= sexo == 'M' ? "checked" : "" %> name="txtSexo" value="M">
                        Hombre
                    </label>
                    <label for="M">
                        <input type="radio" id="F" <%= sexo == 'F' ? "checked" : "" %> name="txtSexo" value="F">
                        Mujer
                    </label>
                </td>
            </tr>
            <tr>
                <td><label for="nacionalidad">Nacionalidad:</label></td>
                <td>
                    <input class="input"  type="text" id="nacionalidad" name="txtNacionalidad" value="<%= cliente.getNacionalidad() %>">
                    <span class="error" id="error-nacionalidad" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="fecha_nacimiento">Fecha de Nacimiento:</label></td>
                <td>
                    <input  type="date" id="fecha_nacimiento" name="txtFecha_Nacimiento" value="<%= fecha == null ? cliente.getFechaNacimiento() : fecha%>">
                    <span class="error" id="error-fecha_nacimiento" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="direccion">Direcci�n:</label></td>
                <td>
                    <input class="input"  type="text" id="direccion" name="txtDireccion" value="<%= cliente.getDireccion() %>">
                    <span class="error" id="error-direccion" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="localidad">Localidad:</label></td>
                <td>
                    <input class="input"  type="text" id="localidad" name="txtLocalidad" value="<%= cliente.getLocalidad() %>">
                    <span class="error" id="error-localidad" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="provincia">Provincia:</label></td>
                <td>
                    <select id="provincia" name="ddlProvincia">
                        <option value="" <%= provCliente == "" ? "selected" : "" %> disabled>Seleccione una provincia</option>
                        <% for(String p : provs) { %>
                        <option <%= provCliente == p ? "selected" : "" %> value=<%= p %> ><%= p %></option>
                        <% } %>
                    </select>
                    <span id="error-provincia" class="error" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="email">Email:</label></td>
                <td>
                    <input class="input"  type="text" id="email" name="txtEmail" value="<%= cliente.getEmail() %>">
                    <span id="error-email" class="error" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="telefono">Tel�fono:</label></td>
                <td>
                    <input class="input"  type="text" id="telefono" name="txtTelefono" value="<%= cliente.getTelefono() %>">
                    <span id="error-telefono" class="error" style="color: red;"></span>
                </td>
            </tr>
            <tr>
                <td><label for="usuario">Usuario:</label></td>
                <td>
                    <input readonly disabled class="input" type="text" id="usuario-readonly" name="usuario-readonly" value="<%= cliente.getUsuario() %>">
                    <span id="error-usuario" class="error" style="color: red;"></span>
                </td>
            </tr>
            
            <tr>
                <td><label for="clave">Clave:</label></td>
                <td>
                    <input class="input" type="text" id="clave" name="txtClave" value="<%= cliente.getClave() %>">
                    <span id="error-clave" class="error" style="color: red;"></span>
                </td>
            </tr>
            
            <tr>
                <td colspan="2" style="text-align: center;">
                	<input type="hidden" name="dni-anterior" value="<%= cliente.getDni() %>">
                	<input type="hidden" name="cuil-anterior" value="<%= cliente.getCuil() %>">
                	<input type="hidden" name="id" value="<%= cliente.getIdCliente() %>">
					<input type="hidden" name="txtUsuario" id="usuario" name="usuario" value="<%= cliente.getUsuario() %>">	
                    <input type="submit" name="btnConfirmarEdicion" value="Aceptar">
                </td>
                <td>
                	<input type="submit" name="btnCancelarEdicion" value="Cancelar">
                </td>
            </tr>
        </table>
    </form>
   	<%
    Respuesta res = (Respuesta) session.getAttribute("EstadoCliente");
	   if (res != null) {
	%>
	   <p style="color: <%= res.isEstado() ? "green" : "red" %>">
	       <%= res.getMensaje() %>
	   </p>
	<%
    session.removeAttribute("EstadoCliente");
	session.removeAttribute("cliente");
}
%>
</main>
<script type="text/javascript">

		function handleForm(event) {
	          if (event.submitter.value === "Cancelar") {
	              return true;
	          }
			
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
			
			const clave = document.getElementById("clave").value.trim();
			if(clave.length < 3){
				document.getElementById("error-clave").textContent = "La clave debe tener al menos 4 caracteres.";
				valido = false;
			}	
			
			return valido;
		}
	</script>
	
	

</body>
</html>