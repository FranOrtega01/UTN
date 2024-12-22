/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2024-12-12 05:16:34 UTC
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

public final class NuevaTransferenciaUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Nueva Transferencia</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
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
      out.write("\t\t<a href=\"ServletCliente?Param=MostrarDatosPersonales\">Mi Perfil</a>\r\n");
      out.write("    </navbar>\r\n");
      out.write("    <div>\r\n");
      out.write("    \t<p> ");
      out.print( MenuUsername );
      out.write(" </p>\r\n");
      out.write("    \t<a href=\"ServletSesion\">Cerrar Sesion</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>");
      out.write('\r');
      out.write('\n');

	if(request.getAttribute("listaCu") == null){
		response.sendRedirect("ServletCuenta?Param=Transferencia");
		return;
	}
	List<Cuenta> lista = (List<Cuenta>)request.getAttribute("listaCu");
	String id = (String)request.getAttribute("id");

      out.write("\r\n");
      out.write("<main> \r\n");
      out.write("<h1>Nueva Transferencia</h1>\r\n");
      out.write("\r\n");
 
if (lista == null || lista.isEmpty()) {
    
      out.write("\r\n");
      out.write("        <p>No tienes cuentas para realizar una transferencia.</p>\r\n");
      out.write("    ");

        } else {
    
      out.write("\r\n");
      out.write("<form method=\"POST\" action=\"ServletCuenta\" onsubmit=\"return handleForm()\">\r\n");
      out.write("\r\n");
      out.write("    <label>\r\n");
      out.write("        Seleccione cuenta\r\n");
      out.write("        <select name=\"cuenta\" id=\"cuenta\">\r\n");
      out.write("            <option value=\"0\" selected disabled>Seleccione una cuenta</option>\r\n");
      out.write("            ");
 for (Cuenta c : lista) { 
      out.write("\r\n");
      out.write("                <option value=");
      out.print( c.getNroCuenta() );
      out.write('>');
      out.print( c.getNroCuenta() + " - " + c.getTipoCuenta().getDescripcion() + " ($" + c.getSaldo() +")" );
      out.write("</option>\r\n");
      out.write("            ");
 } 
      out.write("\r\n");
      out.write("        </select>\r\n");
      out.write("    </label>\r\n");
      out.write("    <span id=\"error-cuenta\" style=\"color: red;\"></span>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    \r\n");
      out.write("    <label>\r\n");
      out.write("        Ingrese el monto a transferir:\r\n");
      out.write("        <input type=\"text\" name=\"monto\" id=\"monto\" />\r\n");
      out.write("    </label>\r\n");
      out.write("    <span id=\"error-monto\" style=\"color: red;\"></span>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    \r\n");
      out.write("    <label>\r\n");
      out.write("        Ingrese CBU de la cuenta a transferir:\r\n");
      out.write("        <input type=\"text\" name=\"cbu\" id=\"cbu\" />\r\n");
      out.write("    </label>\r\n");
      out.write("    <span id=\"error-cbu\" style=\"color: red;\"></span>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    \r\n");
      out.write("    <label>\r\n");
      out.write("        Detalle:\r\n");
      out.write("        <input type=\"text\" name=\"detalle\" id=\"detalle\">\r\n");
      out.write("    </label>\r\n");
      out.write("    <span id=\"error-detalle\" style=\"color: red;\"></span>\r\n");
      out.write("    <br><br>\r\n");
      out.write("    \r\n");
      out.write("    <input type=\"submit\" name=\"btnNuevaTransferencia\" value=\"Enviar Transferencia\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function handleForm() {\r\n");
      out.write("        let valido = true;\r\n");
      out.write("\r\n");
      out.write("        // cuenta \r\n");
      out.write("        const cuenta = document.getElementById(\"cuenta\");\r\n");
      out.write("        const errorCuenta = document.getElementById(\"error-cuenta\");\r\n");
      out.write("        if (cuenta.value === \"0\") {\r\n");
      out.write("            errorCuenta.textContent = \"Debe seleccionar una cuenta.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        } else {\r\n");
      out.write("            errorCuenta.textContent = \"\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("     \t// monto\r\n");
      out.write("        const monto = document.getElementById(\"monto\");\r\n");
      out.write("        const errorMonto = document.getElementById(\"error-monto\");\r\n");
      out.write("        if (!monto.value.trim()) {\r\n");
      out.write("            errorMonto.textContent = \"El monto es obligatorio.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        } else if (!/^\\d+(\\.\\d{1,2})?$/.test(monto.value.trim())) {\r\n");
      out.write("            errorMonto.textContent = \"El monto debe ser un número positivo de hasta 2 decimales.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        } else if (parseFloat(monto.value.trim()) <= 0) {\r\n");
      out.write("            errorMonto.textContent = \"El monto debe ser mayor que 0.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        } else {\r\n");
      out.write("            errorMonto.textContent = \"\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        //  CBU\r\n");
      out.write("        const cbu = document.getElementById(\"cbu\");\r\n");
      out.write("        const errorCbu = document.getElementById(\"error-cbu\");\r\n");
      out.write("        if (!cbu.value.trim()) {\r\n");
      out.write("            errorCbu.textContent = \"El CBU es obligatorio.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        } else if (!/^\\d{22}$/.test(cbu.value.trim())) {\r\n");
      out.write("            errorCbu.textContent = \"El CBU debe tener 22 dígitos.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        } else {\r\n");
      out.write("            errorCbu.textContent = \"\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // detalle\r\n");
      out.write("        const detalle = document.getElementById(\"detalle\");\r\n");
      out.write("        const errorDetalle = document.getElementById(\"error-detalle\");\r\n");
      out.write("        if (!detalle.value.trim()) {\r\n");
      out.write("            errorDetalle.textContent = \"El detalle es obligatorio.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        } else if (detalle.value.trim().length > 20) {\r\n");
      out.write("            errorDetalle.textContent = \"El detalle no puede tener más de 20 caracteres.\";\r\n");
      out.write("            valido = false;\r\n");
      out.write("        } else {\r\n");
      out.write("        \t\r\n");
      out.write("        \t\r\n");
      out.write("            errorDetalle.textContent = \"\";\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        return valido;\r\n");
      out.write("    }\r\n");
      out.write("    </script>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t");

		Respuesta res = (Respuesta) session.getAttribute("estado");
		if (res != null) {
			
	
      out.write(" <br>\r\n");
      out.write("\t<p style=\"color: ");
      out.print(res.isEstado() ? "green" : "red");
      out.write("\">\r\n");
      out.write("\t\t");
      out.print(res.getMensaje());
      out.write("</p>\r\n");
      out.write("\t");

		session.removeAttribute("estado");
		}
	
      out.write("\r\n");
      out.write("</main>\r\n");
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
