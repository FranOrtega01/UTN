<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="java.util.List"%>
    <%@page import="entidad.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Informe Estadístico</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body class="grid-body">
    <%@include file="./MenuAdmin.jsp" %>
    
    <%
    
   	int usuariosRegistrados = 0;
    int cuentasCreadas = 0;
    double dineroDepositado = 0;
    String mesMayorMovimientos = "";
    
    if(session.getAttribute("usuariosRegistrados") != null )  {
    	usuariosRegistrados = (int)session.getAttribute("usuariosRegistrados");
		session.removeAttribute("usuariosRegistrados");
	}
    
    if(session.getAttribute("cuentasCreadas") != null )  {
    	cuentasCreadas = (int)session.getAttribute("cuentasCreadas");
		session.removeAttribute("cuentasCreadas");
	}
    
    if(session.getAttribute("dineroDepositado") != null )  {
    	dineroDepositado = (Double)session.getAttribute("dineroDepositado");
		session.removeAttribute("dineroDepositado");
	}
    
    if(session.getAttribute("mesMayorMovimientos") != null )  {
    	mesMayorMovimientos = (String)session.getAttribute("mesMayorMovimientos");
		session.removeAttribute("mesMayorMovimientos");
	}
    
    %>
    
    <main style="padding: 20px">
        <h2>Informe Estadístico</h2>
        <p style="margin: 15px 0"><b>Usuarios Registrados:</b> <%= usuariosRegistrados %></p>
        <p style="margin: 15px 0"><b>Cuentas Creadas:</b>  <%= cuentasCreadas %></p>
        <p style="margin: 15px 0"><b>Dinero Total En Cuentas:</b>  $<%= dineroDepositado %></p>
        <p style="margin: 15px 0"><b>Mes con Mayor Cantidad de Movimientos:</b>  <%= mesMayorMovimientos %></p>
        
       	<b style="margin: 15px 0">Informe por rango de fechas</b>
       <form action="ServletEstadistico" method="get" onsubmit="return validarFechas()">
    <label for="fechaInicio">Fecha Inicio:</label>
    <input type="date" name="fechaInicio" id="fechaInicio">
    <span id="errorFechaInicio" style="color: red;"></span>
    <br><br>

    <label for="fechaFin">Fecha Fin:</label>
    <input type="date" name="fechaFin" id="fechaFin">
    <span id="errorFechaFin" style="color: red;"></span>
    <br><br>

    <button name="generarInforme" value="">Generar Informe</button>
</form>

<script>
function validarFechas() {
    const fechaInicio = document.getElementById("fechaInicio");
    const fechaFin = document.getElementById("fechaFin");
    const errorFechaInicio = document.getElementById("errorFechaInicio");
    const errorFechaFin = document.getElementById("errorFechaFin");
    let valido = true;

    errorFechaInicio.textContent = "";
    errorFechaFin.textContent = "";

    // fechaInicio
    if (!fechaInicio.value.trim()) {
        errorFechaInicio.textContent = "La fecha de inicio es obligatoria.";
        valido = false;
    }

    // fechaFin
    if (!fechaFin.value.trim()) {
        errorFechaFin.textContent = "La fecha de fin es obligatoria.";
        valido = false;
    }

    if (fechaInicio.value > fechaFin.value) {
        errorFechaInicio.textContent = "La fecha de inicio no puede ser mayor que la fecha de fin.";
        valido = false;
    }

    return valido;
}
</script>
        
        <%
        int cantCuentas = -1;
    	if(session.getAttribute("totalCuentas") != null )  {
    		cantCuentas = (int) session.getAttribute("totalCuentas");
    		session.removeAttribute("totalCuentas");
    	}
        
        if(cantCuentas != -1 ){
        	%>
        		<p> Cuentas creadas: <%= cantCuentas  %> </p>
        	<%
        }
        
    %>
    
     <%
        double promedioCuotas = -1;
     	int totalCuotas = -1;
     	int totalPrestamos = -1;
     	
    	if(session.getAttribute("totalPrestamos") != null )  {
    		totalPrestamos = (int)session.getAttribute("totalPrestamos");
    		session.removeAttribute("totalPrestamos");
    	}
    	
    	if(session.getAttribute("totalCuotas") != null )  {
    		totalCuotas = (int)session.getAttribute("totalCuotas");
    		session.removeAttribute("totalCuotas");
    	}
    	
    	if(session.getAttribute("promedioCuotasPagas") != null )  {
    		promedioCuotas = (double) session.getAttribute("promedioCuotasPagas");
    		session.removeAttribute("promedioCuotasPagas");
    	}
        
        if(promedioCuotas != -1 && totalCuotas != -1 && totalPrestamos != -1 ){
        	%>
        		<p> Prestamos totales: <%= totalPrestamos  %> </p>
        		<p> Cuotas totales: <%= totalCuotas  %> </p>
        		<p> Promedio de cuotas pagadas: <%= promedioCuotas  %>% </p>
        		
        	<%
        }
        
    %>
    </main>
</body>
</html>