/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2024-12-12 06:00:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import entidad.*;

public final class ListarPrestamosUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/./MenuUsuario.jsp", Long.valueOf(1733963303679L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("entidad");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Mis Prestamos</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"grid-body\">\r\n");

	if(request.getAttribute("listaPr") == null){
		response.sendRedirect("ServletPrestamo?Param=listarPrestamos");
		return;
	}

      out.write('\r');
      out.write('\n');

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


      out.write("\r\n");
      out.write("<section class=\"menu\">\r\n");
      out.write("    <navbar>\r\n");
      out.write("        <a href=\"InicioUsuario.jsp\">Incio</a>\r\n");
      out.write("\t\t<a href= \"ServletCuenta?Param=Transferencia\" >Nueva Transferencia</a>\r\n");
      out.write("\t\t<a href= \"ServletCuenta?Param=Prestamo\">Nuevo Prestamo</a>\r\n");
      out.write("\t\t<a href=\"ServletPrestamo?Param=listarPrestamos\">Mis Prestamos</a>\r\n");
      out.write("\t\t<a href=\"ServletCliente?Param=MostrarDatosPersonales\">Mi Perfil</a>\r\n");
      out.write("    </navbar>\r\n");
      out.write("    <div>\r\n");
      out.write("    \t<p> ");
      out.print( MenuUsername );
      out.write(" </p>\r\n");
      out.write("    \t<a href=\"ServletSesion\">Cerrar Sesion</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>");
      out.write("\r\n");
      out.write("<main> \r\n");
      out.write("\t<h1>Mis Prestamos</h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<form method=\"GET\" action=\"ServletPrestamo\">\r\n");
      out.write("        <input type=\"hidden\" name=\"Param\" value=\"listarPrestamos\" />\r\n");
      out.write("        <label for=\"idCuenta\">Filtrar por ID Cuenta:</label>\r\n");
      out.write("        <input type=\"text\" id=\"idCuenta\" name=\"idCuenta\" value=\"");
      out.print( request.getParameter("idCuenta") != null ? request.getParameter("idCuenta") : "" );
      out.write("\" />\r\n");
      out.write("    <label for=\"estado\">Filtrar por Estado:</label>\r\n");
      out.write("    <select id=\"estado\" name=\"estado\">\r\n");
      out.write("        <option value=\"\">--Todos--</option>\r\n");
      out.write("        <option value=\"Pendiente\" ");
      out.print( "Pendiente".equals(request.getParameter("estado")) ? "selected" : "" );
      out.write(">Pendiente</option>\r\n");
      out.write("        <option value=\"Aprobado\" ");
      out.print( "Aprobado".equals(request.getParameter("estado")) ? "selected" : "" );
      out.write(">Aprobado</option>\r\n");
      out.write("        <option value=\"Rechazado\" ");
      out.print( "Rechazado".equals(request.getParameter("estado")) ? "selected" : "" );
      out.write(">Rechazado</option>\r\n");
      out.write("        <option value=\"Pagado\" ");
      out.print( "Pagado".equals(request.getParameter("estado")) ? "selected" : "" );
      out.write(">Pagado</option>\r\n");
      out.write("    </select>\r\n");
      out.write("        <button type=\"submit\">Filtrar</button>\r\n");
      out.write("        <a href=\"ServletPrestamo?Param=listarPrestamos\">Quitar Filtro</a>\r\n");
      out.write("    </form>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function handleFormCuenta() {\r\n");
      out.write("        const idCuenta = document.getElementById(\"idCuenta\").value.trim();\r\n");
      out.write("        const errorIdCuenta = document.getElementById(\"errorIdCuenta\");\r\n");
      out.write("        let valido = true;\r\n");
      out.write("\r\n");
      out.write("        errorIdCuenta.textContent = \"\";\r\n");
      out.write("\r\n");
      out.write("        if (!idCuenta) {\r\n");
      out.write("            errorIdCuenta.textContent = \"El campo ID Cuenta es obligatorio.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        return valido;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function handleFormEstado() {\r\n");
      out.write("        const selectEstado = document.getElementById(\"selectEstado\").value;\r\n");
      out.write("        const errorEstado = document.getElementById(\"errorEstado\");\r\n");
      out.write("        let valido = true;\r\n");
      out.write("\r\n");
      out.write("        errorEstado.textContent = \"\";\r\n");
      out.write("\r\n");
      out.write("        if (!selectEstado) {\r\n");
      out.write("            errorEstado.textContent = \"Seleccione un estado.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        return valido;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("\t");

    	List<Prestamo> lista = (List<Prestamo>) request.getAttribute("listaPr");
        if (lista == null || lista.isEmpty()) {
    
      out.write("\r\n");
      out.write("        <p>No tienes prestamos... <a href=\"ServletCuenta?Param=Prestamo\">Soliticar uno.</a> </p>\r\n");
      out.write("    ");

        } else {
    
      out.write("\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Fecha</th>\r\n");
      out.write("\t\t\t<th>Cuenta</th>\r\n");
      out.write("\t\t\t<th>Importe</th>\r\n");
      out.write("\t\t\t<th>Importe a Pagar</th>\r\n");
      out.write("\t\t\t<th>Cuotas</th>\r\n");
      out.write("\t\t\t<th>Monto Cuota </th>\r\n");
      out.write("\t\t\t<th>Estado</th>\r\n");
      out.write("\t\t\t<th>Pagar Cuotas </th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

            for (Prestamo p : lista) {
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.print( p.getFecha() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( p.getIdCuenta() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( p.getImportePedido() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( p.getImporteAPagar() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( p.getCuotas() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( p.getMontoMensual() );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( p.getEstado() );
      out.write("</td>\r\n");
      out.write("            \r\n");
      out.write("            <td> \r\n");
      out.write("            ");
 if ("Aprobado".equals(p.getEstado())) { 
      out.write("\r\n");
      out.write("            <form action=\"ServletPrestamo\" method=\"post\">\r\n");
      out.write("       \t\t\t<input type=\"hidden\" name=\"idPrestamo\" value=\"");
      out.print( p.getIdPrestamo() );
      out.write("\" />\r\n");
      out.write("      \t\t \t<button type=\"submit\" name = \"btnPagarCuota\" value=");
      out.print( p.getCuotasPagas() + 1 );
      out.write('>');
      out.write(' ');
      out.print( "Pagar cuota " + (p.getCuotasPagas() + 1) + "/" + p.getCuotas() );
      out.write(" </button>\r\n");
      out.write("   \t\t\t</form>\r\n");
      out.write("\t        ");

	            }else{
	        
      out.write("\r\n");
      out.write("\t        \t<p> ");
      out.print( "Prestamo " + p.getEstado() );
      out.write(" </p>\r\n");
      out.write("\t        ");
} 
      out.write("\r\n");
      out.write("            </td>   \t\t\t\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");
 
    int paginaActual = (int) request.getAttribute("paginaActual");
    int totalPaginas = (int) request.getAttribute("totalPaginas");

      out.write("\r\n");
      out.write("\r\n");

		Respuesta res = (Respuesta) session.getAttribute("estado");
		if (res != null) {
				
		
      out.write(" <br>\r\n");
      out.write("\t\t<p style=\"color: ");
      out.print(res.isEstado() ? "green" : "red");
      out.write("\">\r\n");
      out.write("\t\t\t");
      out.print(res.getMensaje());
      out.write("</p>\r\n");
      out.write("\t\t");

			session.removeAttribute("estado");
			}
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("    ");
 if (paginaActual > 1) { 
      out.write("\r\n");
      out.write("        <a href=\"ServletPrestamo?Param=listarPrestamos&pagina=");
      out.print( paginaActual - 1 );
      out.write("\">Anterior</a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
 for (int i = 1; i <= totalPaginas; i++) { 
      out.write("\r\n");
      out.write("        ");
 if (i == paginaActual) { 
      out.write("\r\n");
      out.write("            <strong>");
      out.print( i );
      out.write("</strong>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("            <a href=\"ServletPrestamo?Param=listarPrestamos&pagina=");
      out.print( i );
      out.write('"');
      out.write('>');
      out.print( i );
      out.write("</a>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
 if (paginaActual < totalPaginas) { 
      out.write("\r\n");
      out.write("        <a href=\"ServletPrestamo?Param=listarPrestamos&pagina=");
      out.print( paginaActual + 1 );
      out.write("\">Siguiente</a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</main>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
