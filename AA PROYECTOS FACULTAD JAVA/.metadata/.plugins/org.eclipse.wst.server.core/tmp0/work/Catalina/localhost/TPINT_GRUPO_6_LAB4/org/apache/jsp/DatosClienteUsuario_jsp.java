/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2024-12-12 13:23:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entidad.*;
import java.util.List;

public final class DatosClienteUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>Datos Cliente</title>\r\n");
      out.write("</head>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles.css\">\r\n");
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
      out.write("\r\n");
      out.write("<main> \r\n");
      out.write("<h1>Informacion Personal</h1>\r\n");
      out.write("<table border=\"1\">\r\n");
      out.write("    <tr>\r\n");
      out.write("        <th>Id Cliente</th>\r\n");
      out.write("        <th>DNI</th>\r\n");
      out.write("        <th>CUIL</th>\r\n");
      out.write("        <th>Nombre</th>\r\n");
      out.write("        <th>Apellido</th>\r\n");
      out.write("        <th>Sexo</th>\r\n");
      out.write("        <th>Nacionalidad</th>\r\n");
      out.write("        <th>Fecha de Nacimiento</th>\r\n");
      out.write("        <th>Dirección</th>\r\n");
      out.write("        <th>Localidad</th>\r\n");
      out.write("        <th>Provincia</th>\r\n");
      out.write("        <th>Email</th>\r\n");
      out.write("        <th>Teléfono</th>\r\n");
      out.write("        <th>Usuario</th>\r\n");
      out.write("        <th>Clave</th>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

    List<Cliente> datos = (List<Cliente>) request.getAttribute("datosPersonales");
    if (datos == null || datos.isEmpty()) {
    
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td colspan=\"15\" style=\"text-align: center;\">Error al cargar los datos</td>\r\n");
      out.write("        </tr>\r\n");
      out.write("    ");

    } else {
        for (Cliente c : datos) {
    
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("        <td>");
      out.print( c.getIdCliente() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getDni() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getCuil() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getNombre() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getApellido() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getSexo() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getNacionalidad() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getFechaNacimiento() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getDireccion() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getLocalidad() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getProvincia() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getEmail() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getTelefono() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getUsuario() );
      out.write("</td>\r\n");
      out.write("        <td>");
      out.print( c.getClave() );
      out.write("</td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    ");

        }
    }
    
      out.write("\r\n");
      out.write("</table>");
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
