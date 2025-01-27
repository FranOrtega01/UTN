/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2024-12-12 12:55:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidad.*;

public final class AltaCuentaAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t    \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Agregar Cuenta</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<style>\r\n");
      out.write("table {\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\twidth: 30%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td {\r\n");
      out.write("\tpadding: 2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td label {\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tmargin-right: 2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"text\"], select {\r\n");
      out.write("\twidth: 95%;\r\n");
      out.write("\tbox-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"grid-body\">\r\n");

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
      out.write("<main>\r\n");
      out.write("    <h1>Agregar Cuenta</h1>\r\n");
      out.write("    <form action=\"ServletCuenta\" method=\"post\" onsubmit=\"return handleForm();\">\r\n");
      out.write("        <table>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><label for=\"txtId\">Id del cliente:</label></td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"number\" name=\"txtId\" id=\"txtId\" class=\"input\">\r\n");
      out.write("                    <span id=\"error-txtId\" style=\"color: red;\"></span>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><label>Tipo de Cuenta:</label></td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <label for=\"tipoCuentaCA\">Caja de Ahorro\r\n");
      out.write("                        <input type=\"radio\" checked name=\"tipoCuenta\" id=\"tipoCuentaCA\" value=\"1-Caja de Ahorro\">\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <label for=\"tipoCuentaCC\">Cuenta Corriente\r\n");
      out.write("                        <input type=\"radio\" name=\"tipoCuenta\" id=\"tipoCuentaCC\" value=\"2-Cuenta Corriente\">\r\n");
      out.write("                    </label>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><label for=\"txtCbu\">CBU:</label></td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input type=\"text\" name=\"txtCbu\" id=\"txtCbu\" class=\"input\">\r\n");
      out.write("                    <span id=\"error-txtCbu\" style=\"color: red;\"></span>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"2\" style=\"text-align: center;\">\r\n");
      out.write("                    <input type=\"submit\" value=\"Aceptar\" name=\"btnAceptar\">\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("    </form>\r\n");
      out.write("    ");

    	Respuesta res = (Respuesta)request.getAttribute("EstadoCuenta");
        if (res != null) {
    
      out.write(" \r\n");
      out.write("        <br>\r\n");
      out.write("        <p style=\"color: ");
      out.print( res.isEstado() ? "green" : "red");
      out.write('"');
      out.write('>');
      out.write(' ');
      out.print( res.getMensaje() );
      out.write("</p>\r\n");
      out.write("    ");

        }
    
      out.write("\r\n");
      out.write("</main>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function handleForm() {\r\n");
      out.write("        let valido = true;\r\n");
      out.write("\r\n");
      out.write("        document.getElementById(\"error-txtId\").textContent = \"\";\r\n");
      out.write("        document.getElementById(\"error-txtCbu\").textContent = \"\";\r\n");
      out.write("\r\n");
      out.write("        const txtId = document.getElementById(\"txtId\").value.trim();\r\n");
      out.write("        if (txtId === \"\") {\r\n");
      out.write("            document.getElementById(\"error-txtId\").textContent = \"El ID del cliente debe ser un número y no puede estar vacío.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        const cbu = document.getElementById(\"txtCbu\");\r\n");
      out.write("        if (txtCbu.value.trim() === \"\") {\r\n");
      out.write("            document.getElementById(\"error-txtCbu\").textContent = \"El CBU es obligatorio.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        }else if(!/^\\d{22}$/.test(cbu.value.trim())){\r\n");
      out.write("        \tdocument.getElementById(\"error-txtCbu\").textContent = \"El CBU debe tener 22 números.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // Previene el envío si alguna validación falla\r\n");
      out.write("        return valido;\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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
