/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2024-12-12 12:57:03 UTC
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

public final class InformeEstadisticoAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/./MenuAdmin.jsp", Long.valueOf(1733984782229L));
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
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("    <title>Informe Estadístico</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"grid-body\">\r\n");
      out.write("    ");

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


      out.write("\r\n");
      out.write("<section class=\"menu\">\r\n");
      out.write("    <navbar>\r\n");
      out.write("        <a href=\"AltaClienteAdmin.jsp\">Agregar Cliente</a>\r\n");
      out.write("        <a href=\"AltaCuentaAdmin.jsp\">Agregar Cuenta</a>\r\n");
      out.write("        <a href=\"ServletCliente?Param=listarClientes\">ABML Clientes</a>\r\n");
      out.write("        <a href=\"ServletCuenta?Param=listarCuentas\">ABML Cuentas</a>\r\n");
      out.write("        <a href=\"ServletPrestamo?Param=listarPrestamos\">Listado Prestamos</a>\r\n");
      out.write("        <a href=\"ServletEstadistico\">Informes estadísticos</a>\r\n");
      out.write("    </navbar>\r\n");
      out.write("    <div>\r\n");
      out.write("    \t<p> ");
      out.print( role + "  -  " + username );
      out.write(" </p>\r\n");
      out.write("    \t<a href=\"ServletSesion\">Cerrar Sesion</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

    
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
    
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <main style=\"padding: 20px\">\r\n");
      out.write("        <h2>Informe Estadístico</h2>\r\n");
      out.write("        <p style=\"margin: 15px 0\"><b>Usuarios Registrados:</b> ");
      out.print( usuariosRegistrados );
      out.write("</p>\r\n");
      out.write("        <p style=\"margin: 15px 0\"><b>Cuentas Creadas:</b>  ");
      out.print( cuentasCreadas );
      out.write("</p>\r\n");
      out.write("        <p style=\"margin: 15px 0\"><b>Dinero Total En Cuentas:</b>  $");
      out.print( dineroDepositado );
      out.write("</p>\r\n");
      out.write("        <p style=\"margin: 15px 0\"><b>Mes con Mayor Cantidad de Movimientos:</b>  ");
      out.print( mesMayorMovimientos );
      out.write("</p>\r\n");
      out.write("        \r\n");
      out.write("       \t<b style=\"margin: 15px 0\">Informe por rango de fechas</b>\r\n");
      out.write("       <form action=\"ServletEstadistico\" method=\"get\" onsubmit=\"return validarFechas()\">\r\n");
      out.write("    <label for=\"fechaInicio\">Fecha Inicio:</label>\r\n");
      out.write("    <input type=\"date\" name=\"fechaInicio\" id=\"fechaInicio\">\r\n");
      out.write("    <span id=\"errorFechaInicio\" style=\"color: red;\"></span>\r\n");
      out.write("    <br><br>\r\n");
      out.write("\r\n");
      out.write("    <label for=\"fechaFin\">Fecha Fin:</label>\r\n");
      out.write("    <input type=\"date\" name=\"fechaFin\" id=\"fechaFin\">\r\n");
      out.write("    <span id=\"errorFechaFin\" style=\"color: red;\"></span>\r\n");
      out.write("    <br><br>\r\n");
      out.write("\r\n");
      out.write("    <button name=\"generarInforme\" value=\"\">Generar Informe</button>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("function validarFechas() {\r\n");
      out.write("    const fechaInicio = document.getElementById(\"fechaInicio\");\r\n");
      out.write("    const fechaFin = document.getElementById(\"fechaFin\");\r\n");
      out.write("    const errorFechaInicio = document.getElementById(\"errorFechaInicio\");\r\n");
      out.write("    const errorFechaFin = document.getElementById(\"errorFechaFin\");\r\n");
      out.write("    let valido = true;\r\n");
      out.write("\r\n");
      out.write("    errorFechaInicio.textContent = \"\";\r\n");
      out.write("    errorFechaFin.textContent = \"\";\r\n");
      out.write("\r\n");
      out.write("    // fechaInicio\r\n");
      out.write("    if (!fechaInicio.value.trim()) {\r\n");
      out.write("        errorFechaInicio.textContent = \"La fecha de inicio es obligatoria.\";\r\n");
      out.write("        valido = false;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    // fechaFin\r\n");
      out.write("    if (!fechaFin.value.trim()) {\r\n");
      out.write("        errorFechaFin.textContent = \"La fecha de fin es obligatoria.\";\r\n");
      out.write("        valido = false;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    if (fechaInicio.value > fechaFin.value) {\r\n");
      out.write("        errorFechaInicio.textContent = \"La fecha de inicio no puede ser mayor que la fecha de fin.\";\r\n");
      out.write("        valido = false;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    return valido;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("        \r\n");
      out.write("        ");

        int cantCuentas = -1;
    	if(session.getAttribute("totalCuentas") != null )  {
    		cantCuentas = (int) session.getAttribute("totalCuentas");
    		session.removeAttribute("totalCuentas");
    	}
        
        if(cantCuentas != -1 ){
        	
      out.write("\r\n");
      out.write("        \t\t<p> Cuentas creadas: ");
      out.print( cantCuentas  );
      out.write(" </p>\r\n");
      out.write("        \t");

        }
        
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("     ");

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
        	
      out.write("\r\n");
      out.write("        \t\t<p> Prestamos totales: ");
      out.print( totalPrestamos  );
      out.write(" </p>\r\n");
      out.write("        \t\t<p> Cuotas totales: ");
      out.print( totalCuotas  );
      out.write(" </p>\r\n");
      out.write("        \t\t<p> Promedio de cuotas pagadas: ");
      out.print( promedioCuotas  );
      out.write("% </p>\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t");

        }
        
    
      out.write("\r\n");
      out.write("    </main>\r\n");
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