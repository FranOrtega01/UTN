/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2024-12-11 20:02:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CrearSolicitudAltaCuentaUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/./MenuUsuario.jsp", Long.valueOf(1733946961000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Solicitar Creación de Usuario</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\"> \r\n");
      out.write("    <style>\r\n");
      out.write("        /* Estilos básicos para mejorar la apariencia */\r\n");
      out.write("        .container {\r\n");
      out.write("            width: 60%;\r\n");
      out.write("            max-width: 800px;\r\n");
      out.write("            background: #fff;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);\r\n");
      out.write("        }\r\n");
      out.write("        h1 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: #4CAF50;\r\n");
      out.write("            font-size: 2.5em;\r\n");
      out.write("        }\r\n");
      out.write("        form table {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            border-collapse: collapse;\r\n");
      out.write("        }\r\n");
      out.write("        form table td {\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        form label {\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin-bottom: 5px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        form input[type=\"text\"],\r\n");
      out.write("        form select {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            margin-top: 5px;\r\n");
      out.write("            border: 1px solid #ddd;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            background-color: #f9f9f9;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        form input[type=\"radio\"] {\r\n");
      out.write("            margin-right: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        form input[type=\"submit\"] {\r\n");
      out.write("            background-color: #4CAF50;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            transition: background-color 0.3s;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("        }\r\n");
      out.write("        form input[type=\"submit\"]:hover {\r\n");
      out.write("            background-color: #45a049;\r\n");
      out.write("        }\r\n");
      out.write("        .account-type {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"grid-body\">\r\n");

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
      out.write("\t\t<a href=\"CrearSolicitudAltaCuentaUsuario.jsp\">Solicitar nueva cuenta</a>\r\n");
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
      out.write("<div class=\"container\">\r\n");
      out.write("    <h1>Solicitar Creación de Cuenta</h1>\r\n");
      out.write("    <form action=\"\" method=\"\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"2\" class=\"account-type\">\r\n");
      out.write("                    <label>Cuenta Corriente</label>\r\n");
      out.write("                    <input type=\"radio\" name=\"tipo_cuenta\" value=\"corriente\">\r\n");
      out.write("                    <label>Caja de Ahorro</label>\r\n");
      out.write("                    <input type=\"radio\" name=\"tipo_cuenta\" value=\"ahorro\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"2\" style=\"text-align: center;\">\r\n");
      out.write("                    <input type=\"submit\" value=\"Aceptar\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</main>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
