package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cliente;
import entidad.Respuesta;
import negocio.ClienteNeg;
import negocioImpl.ClienteNegImpl;

@WebServlet("/ServletCliente")
public class ServletCliente extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ClienteNeg CliNeg = new ClienteNegImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (request.getParameter("Param") != null) {
			String opcion = request.getParameter("Param");

			switch (opcion) {
			case "listarClientes":
				// Configuración de paginación
				int clientesPorPagina = 5;
				int paginaActual = 1;

				if (request.getParameter("pagina") != null) {
					try {
						paginaActual = Integer.parseInt(request.getParameter("pagina"));
					} catch (NumberFormatException e) {
						paginaActual = 1;
					}
				}

				List<Cliente> clientes = CliNeg.readAll();
				if (clientes == null || clientes.isEmpty()) {
					System.out.println("No hay clientes disponibles.");
				} else {
					System.out.println("Clientes encontrados: " + clientes.size());
				}
				int totalClientes = clientes.size();
				int totalPaginas = (int) Math.ceil((double) totalClientes / clientesPorPagina);

				int inicio = (paginaActual - 1) * clientesPorPagina;
				int fin = Math.min(inicio + clientesPorPagina, totalClientes);

				List<Cliente> clientesPagina = clientes.subList(inicio, fin);

				request.setAttribute("listaCl", clientesPagina);
				request.setAttribute("paginaActual", paginaActual);
				request.setAttribute("totalPaginas", totalPaginas);

				RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarClientesAdmin.jsp");
				dispatcher.forward(request, response);
				break;

			case "MostrarDatosPersonales":

				int id = -1;
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if ("userID".equals(cookie.getName())) {
							id = Integer.parseInt(cookie.getValue());
						}
					}
				}
				List<Cliente> datosPersonales = CliNeg.readById(id);
				if (datosPersonales == null || datosPersonales.isEmpty()) {
					System.out.println("Error al cargar los datos");
				}
				request.setAttribute("datosPersonales", datosPersonales);
				RequestDispatcher rd = request.getRequestDispatcher("/DatosClienteUsuario.jsp");
				rd.forward(request, response);
				break;
			case "filtrarClientes":
				String filtro = request.getParameter("filtro");
				String txtFiltro = request.getParameter("txtFiltro");
				List<Cliente> clientesFiltrados = null;

				if (filtro != null && txtFiltro != null && !txtFiltro.isEmpty()) {
					switch (filtro) {
					case "id":
						clientesFiltrados = CliNeg.readById(Integer.parseInt(txtFiltro));
						break;

					case "nombre":
						clientesFiltrados = CliNeg.readByNombre(txtFiltro);
						break;

					case "apellido":
						clientesFiltrados = CliNeg.readByApellido(txtFiltro);
						break;

					default:
						break;
					}
				}

				if (clientesFiltrados != null) {
					request.setAttribute("listaCl", clientesFiltrados);
				} else {
					request.setAttribute("listaCl", Collections.emptyList());
				}
				request.setAttribute("paginaActual", 1);
				request.setAttribute("totalPaginas", 1);

				dispatcher = request.getRequestDispatcher("/ListarClientesAdmin.jsp");
				dispatcher.forward(request, response);
				break;

			case "informeEstadistico":
				
				HttpSession session = request.getSession();

			    int usuariosRegistrados = CliNeg.obtenerTotalUsuarios();
			    int cuentasCreadas = CliNeg.obtenerTotalCuentas();
			    double dineroDepositado = CliNeg.obtenerTotalDineroDepositado();
			    String mesMayorMovimientos = CliNeg.obtenerMesConMayorMovimientos();

			    session.setAttribute("usuariosRegistrados", usuariosRegistrados);
			    session.setAttribute("cuentasCreadas", cuentasCreadas);
			    session.setAttribute("dineroDepositado", dineroDepositado);
			    session.setAttribute("mesMayorMovimientos", mesMayorMovimientos);

			    dispatcher = request.getRequestDispatcher("/InformeEstadisticoAdmin.jsp");
			    dispatcher.forward(request, response);
			    break;


			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Respuesta res = null;
		if (request.getParameter("btnAceptar") != null) {
			Cliente x = new Cliente();
			x.setDni(request.getParameter("txtDni"));
			x.setCuil(request.getParameter("txtCuil"));
			x.setNombre(request.getParameter("txtNombre"));
			x.setApellido(request.getParameter("txtApellido"));
			// Convertir el valor de sexo a char
			String sexoString = request.getParameter("txtSexo");
			char sexo = (sexoString != null && !sexoString.isEmpty()) ? sexoString.charAt(0) : '\0'; 

			x.setSexo(sexo);
			x.setNacionalidad(request.getParameter("txtNacionalidad"));
			// Fecha (Date)
			String fechaString = request.getParameter("txtFecha_Nacimiento");
			if (fechaString != null && !fechaString.isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date fecha = null;
				try {
					fecha = sdf.parse(fechaString);
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				} 
				x.setFechaNacimiento(fecha);
			}
			x.setDireccion(request.getParameter("txtDireccion"));
			x.setLocalidad(request.getParameter("txtLocalidad"));
			x.setProvincia(request.getParameter("ddlProvincia"));
			x.setEmail(request.getParameter("txtEmail"));
			x.setTelefono(request.getParameter("txtTelefono"));
			x.setUsuario(request.getParameter("txtUsuario"));
			x.setClave(request.getParameter("txtClave"));
			
			res = CliNeg.insert(x);
			request.setAttribute("EstadoCliente", res);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaClienteAdmin.jsp");
			rd.forward(request, response);
		}
		
		// Delete
		if (request.getParameter("btnEliminar") != null) {
			String id = request.getParameter("idCliente");
			Cliente x = new Cliente();
			x.setIdCliente(Integer.parseInt(id));
			if (id != null && !id.isEmpty()) {
				res = CliNeg.delete(x);
			}else {
				res = new Respuesta(true, "Ocurrio un error");
			}
			
			request.getSession().setAttribute("EstadoCliente", res);
			response.sendRedirect("ServletCliente?Param=listarClientes");
		}
		
		// Update
		if (request.getParameter("btnEditar") != null) {
			String id = request.getParameter("idCliente");
			List<Cliente> lista = CliNeg.readById(Integer.parseInt(id));
			Cliente x = lista.get(0);
			request.setAttribute("cliente", x);

			
			RequestDispatcher rd = request.getRequestDispatcher("/EditarClienteAdmin.jsp");
			rd.forward(request, response);
		}
		
		// Confirmar Update
		if (request.getParameter("btnConfirmarEdicion") != null) {
			String idCliente = request.getParameter("id");
			
			Cliente x = new Cliente();
			x.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
			x.setDni(request.getParameter("txtDni"));
			x.setCuil(request.getParameter("txtCuil"));
			x.setNombre(request.getParameter("txtNombre"));
			x.setApellido(request.getParameter("txtApellido"));
			// Convertir el valor de sexo a char
			String sexoString = request.getParameter("txtSexo");
			char sexo = (sexoString != null && !sexoString.isEmpty()) ? sexoString.charAt(0) : '\0'; 

			x.setSexo(sexo);
			x.setNacionalidad(request.getParameter("txtNacionalidad"));
			// Fecha (Date)
			String fechaString = request.getParameter("txtFecha_Nacimiento");
			if (fechaString != null && !fechaString.isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Date fecha = null;
				try {
					fecha = sdf.parse(fechaString);
				} catch (java.text.ParseException e) {
					e.printStackTrace();
				}
				x.setFechaNacimiento(fecha);
			}
			
			x.setDireccion(request.getParameter("txtDireccion"));
			x.setLocalidad(request.getParameter("txtLocalidad"));
			x.setProvincia(request.getParameter("ddlProvincia"));
			x.setEmail(request.getParameter("txtEmail"));
			x.setTelefono(request.getParameter("txtTelefono"));
			x.setUsuario(request.getParameter("txtUsuario"));
			x.setClave(request.getParameter("txtClave"));			
			x.setFechaNacimientoString(request.getParameter("txtFecha_Nacimiento"));
			
			
			res = CliNeg.update(x, idCliente);
			request.getSession().setAttribute("EstadoCliente", res);
			
			if(!res.isEstado()) {
				x.setFechaNacimientoString(request.getParameter("txtFecha_Nacimiento"));
				request.getSession().setAttribute("cliente", x);
				RequestDispatcher rd = request.getRequestDispatcher("/EditarClienteAdmin.jsp");
				rd.forward(request, response);
				return;
			}
		
			
		    request.getSession().removeAttribute("EstadoCliente");
			request.getSession().removeAttribute("cliente");
			response.sendRedirect("ServletCliente?Param=listarClientes");
		} 
		
		// Cancelar Update
		if (request.getParameter("btnCancelarEdicion") != null) {
			response.sendRedirect("ServletCliente?Param=listarClientes");
		}
	}
}
