<%
   // Validar sesion
    Cookie[] cookies = request.getCookies();
    
    String username = null;
    String userID = null;
    String role = null;
    
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            } else if ("userID".equals(cookie.getName())) {
                userID = cookie.getValue();
            } else if ("role".equals(cookie.getName())) {
                role = cookie.getValue();
            }
        }
    }
    if (username == null || userID == null || role == null || !"Admin".equals(role)) {
        response.sendRedirect("Login.jsp"); 
        return;
    }

%>
<section class="menu">
    <navbar>
        <a href="AltaClienteAdmin.jsp">Agregar Cliente</a>
        <a href="AltaCuentaAdmin.jsp">Agregar Cuenta</a>
        <a href="ServletCliente?Param=listarClientes">ABML Clientes</a>
        <a href="ServletCuenta?Param=listarCuentas">ABML Cuentas</a>
        <a href="ServletPrestamo?Param=listarPrestamos">Listado Prestamos</a>
        <a href="ServletEstadistico">Informes estadísticos</a>
    </navbar>
    <div>
    	<p> <%= role + "  -  " + username %> </p>
    	<a href="ServletSesion">Cerrar Sesion</a>
    </div>
</section>