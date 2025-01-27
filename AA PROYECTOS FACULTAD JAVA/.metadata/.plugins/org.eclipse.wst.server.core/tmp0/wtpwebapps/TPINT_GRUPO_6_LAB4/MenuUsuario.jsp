<%
   // Validar sesion
    Cookie[] MenuCookies = request.getCookies();
    
    String MenuUsername = null;
    String MenuUserID = null;
    String MenuRole = null;
    
    if (MenuCookies != null) {
        for (Cookie cookie : MenuCookies) {
            if ("username".equals(cookie.getName())) {
            	MenuUsername = cookie.getValue();
            } else if ("userID".equals(cookie.getName())) {
            	MenuUserID = cookie.getValue();
            } else if ("role".equals(cookie.getName())) {
            	MenuRole = cookie.getValue();
            }
        }
    }
    if (MenuUsername == null || MenuUserID == null || MenuRole == null || !"Usuario".equals(MenuRole)) {
        response.sendRedirect("Login.jsp"); 
        return;
    }

%>
<section class="menu">
    <navbar>
        <a href="InicioUsuario.jsp">Incio</a>
		<a href= "ServletCuenta?Param=Transferencia" >Nueva Transferencia</a>
		<a href= "ServletCuenta?Param=Prestamo">Nuevo Prestamo</a>
		<a href="ServletPrestamo?Param=listarPrestamos">Mis Prestamos</a>
		<a href="ServletCliente?Param=MostrarDatosPersonales">Mi Perfil</a>
    </navbar>
    <div>
    	<p> <%= MenuUsername %> </p>
    	<a href="ServletSesion">Cerrar Sesion</a>
    </div>
</section>