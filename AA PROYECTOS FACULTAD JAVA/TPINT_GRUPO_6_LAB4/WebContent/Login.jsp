<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles.css">
<title>Iniciar Sesi�n</title>
</head>
<body>

<%
    // Validar sesion
    Cookie[] cookies = request.getCookies();	
    String role = null;
    
    if (cookies != null) {
        for (Cookie cookie : cookies) {
        	if ("role".equals(cookie.getName())) {
                role = cookie.getValue();
            }
        }
    }
    if (role != null) {
        response.sendRedirect("Inicio" + role + ".jsp"); 
        return;
    }  
%>
<section class="login-container"> 
	<div class="left-side shadow-right"></div>
	<div class=login-form>
		<form class="shadow" action="ServletSesion" method="POST" >
			<h1>Iniciar Sesi�n</h1>
			<div class="form-input">
				<label >Usuario</label>
				<input name="username" type="text" />
			</div>
			<div  class="form-input">
				<label>Contrase�a</label>
				<input name="password" type="password" />
			</div>
			<%
			if(request.getAttribute("error") != null){
				%>
				<p style="color: red"> <%= request.getAttribute("error") %> </p>
				<%}
			%>
			<input class="btn btn-primary" type="submit" value="Ingresar" />
		</form>
	</div>
</section>
</body>
</html>