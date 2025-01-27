package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.*;
import negocio.*;
import negocioImpl.*;

@WebServlet("/ServletCuenta")
public class ServletCuenta extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CuentaNeg CueNeg = new CuentaNegImpl();
	MovimientoNeg MovNeg = new MovimientoNegImpl();

	public ServletCuenta() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Param") != null) {
			String opcion = request.getParameter("Param");
			String id = null;
			String idParam = null;
			String role = null;
			Cookie[] cookies = request.getCookies();
			HttpSession session = request.getSession();
			RequestDispatcher dispatcher = null;
			List<Cuenta> cuentas = null;
			List<Movimiento> movs = null;

			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("userID".equals(cookie.getName())) {
						id = cookie.getValue();
					}
					if ("role".equals(cookie.getName())) {
						role = cookie.getValue();
					}
				}
			}

			switch (opcion) {
			// Get Cuentas
			case "listarCuentas":
				int cuentasPorPagina = 5;
				int paginaActual = 1;

				// Si el parametro "pagina" esta presente, intentamos parsearlo
				if (request.getParameter("pagina") != null) {
					try {
						paginaActual = Integer.parseInt(request.getParameter("pagina"));
					} catch (NumberFormatException e) {
						paginaActual = 1;
					}
				}

				// User no pueda listar otras cuentas
				if (request.getParameter("id") != null && !"Usuario".equals(role)) {
					idParam = request.getParameter("id");
				}

				// Si es User, listar cuentas usuario
				if ("Usuario".equals(role) && id != null) {
					try {
						cuentas = CueNeg.readIdCliente(Integer.parseInt(id));
						request.setAttribute("listaCu", cuentas);
						request.setAttribute("paginaActual", 0); // Sin paginacion
						request.setAttribute("totalPaginas", 0);
					} catch (NumberFormatException e) {
						request.setAttribute("error", "ID de cliente no valido.");
					}
				}

				// Para el administrador
				if ("Admin".equals(role) && idParam == null) {
					cuentas = CueNeg.readAll(); // Listar todas las cuentas
				} else if ("Admin".equals(role) && idParam != null) {
					try {
						cuentas = CueNeg.readIdCliente(Integer.parseInt(idParam)); // Cuentas de un cliente especifico
					} catch (NumberFormatException e) {
						request.setAttribute("error", "ID de cliente no valido.");
					}
				}

				// Config paginacion
				if (cuentas == null || cuentas.isEmpty()) {
					request.setAttribute("listaCu", null);
					request.setAttribute("paginaActual", 0);
					request.setAttribute("totalPaginas", 0);
				} else {
					int totalCuentas = cuentas.size();
					int totalPaginas = (int) Math.ceil((double) totalCuentas / cuentasPorPagina);

					int inicio = (paginaActual - 1) * cuentasPorPagina;
					int fin = Math.min(inicio + cuentasPorPagina, totalCuentas);

					List<Cuenta> cuentasPagina = cuentas.subList(inicio, fin);

					request.setAttribute("listaCu", cuentasPagina);
					request.setAttribute("paginaActual", paginaActual);
					request.setAttribute("totalPaginas", totalPaginas);
				}

				dispatcher = request
						.getRequestDispatcher(!"Usuario".equals(role) ? "ListarCuentasAdmin.jsp" : "InicioUsuario.jsp");
				dispatcher.forward(request, response);
				break;

			// Get Movimientos
			case "Movimientos":

			    int movimientosPorPagina = 5;
			    int paginaActualMovimientos = 1;

			    // Validar el numero de pagina
			    if (request.getParameter("pagina") != null) {
			        try {
			            paginaActualMovimientos = Integer.parseInt(request.getParameter("pagina"));
			        } catch (NumberFormatException e) {
			            paginaActualMovimientos = 1;
			        }
			    }

			    String nroCuenta = request.getParameter("Nro");
			    double minimo = Double.NEGATIVE_INFINITY; // Rango minimo infinito por defecto
			    double maximo = Double.POSITIVE_INFINITY; // Rango maximo infinito por defecto

			    // Leer los parametros del filtro
			    if (request.getParameter("minimo") != null && !request.getParameter("minimo").isEmpty()) {
			        try {
			            minimo = Double.parseDouble(request.getParameter("minimo"));
			        } catch (NumberFormatException e) {
			            request.setAttribute("error", "El valor minimo no es valido.");
			        }
			    }

			    if (request.getParameter("maximo") != null && !request.getParameter("maximo").isEmpty()) {
			        try {
			            maximo = Double.parseDouble(request.getParameter("maximo"));
			        } catch (NumberFormatException e) {
			            request.setAttribute("error", "El valor maximo no es valido.");
			        }
			    }

			    // Obtener todos los movimientos de la cuenta
			    movs = MovNeg.readIdCuenta(Integer.parseInt(nroCuenta));

			    final double minImporte = minimo; 
			    final double maxImporte = maximo;
			    
			    // Filtrar los movimientos por rango
			    List<Movimiento> movsFiltrados = movs.stream()
			        .filter(m -> m.getImporte() >= minImporte && m.getImporte() <= maxImporte)
			        .collect(Collectors.toList());

			    // Movs vacio
			    if (movsFiltrados.isEmpty()) {
			        request.setAttribute("listaMov", movsFiltrados);
			        request.setAttribute("paginaActualMovimientos", 0);
			        request.setAttribute("totalPaginasMovimientos", 0);
			        request.setAttribute("mensajeError", "No se encontraron movimientos en el rango especificado.");

			        dispatcher = request.getRequestDispatcher("/MovimientosUsuario.jsp");
			        dispatcher.forward(request, response);
			        return; 
			    }
			    
			    
			    // Paginacion
			    int totalMovimientos = movsFiltrados.size();
			    int totalPaginasMovimientos = (int) Math.ceil((double) totalMovimientos / movimientosPorPagina);

			    if (paginaActualMovimientos < 1) {
			        paginaActualMovimientos = 1;
			    } else if (paginaActualMovimientos > totalPaginasMovimientos) {
			        paginaActualMovimientos = totalPaginasMovimientos;
			    }

			    int inicio = (paginaActualMovimientos - 1) * movimientosPorPagina;
			    int fin = Math.min(inicio + movimientosPorPagina, totalMovimientos);

			    List<Movimiento> movimientosPagina = movsFiltrados.subList(inicio, fin);

			    // Establecer los atributos para el JSP
			    request.setAttribute("listaMov", movimientosPagina);
			    request.setAttribute("paginaActualMovimientos", paginaActualMovimientos);
			    request.setAttribute("totalPaginasMovimientos", totalPaginasMovimientos);

			    dispatcher = request.getRequestDispatcher("/MovimientosUsuario.jsp");
			    dispatcher.forward(request, response);
			    break;
			case "Transferencia":
				cuentas = CueNeg.readIdCliente(Integer.parseInt(id));
				request.setAttribute("listaCu", cuentas);
				request.setAttribute("id", id);
				dispatcher = request.getRequestDispatcher("NuevaTransferenciaUsuario.jsp");
				dispatcher.forward(request, response);
				break;
			case "Prestamo":
				id = null;

				cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if ("userID".equals(cookie.getName())) {
							id = cookie.getValue();
							break;
						}
					}
				}
				cuentas = CueNeg.readIdCliente(Integer.parseInt(id));
				session.setAttribute("listaCu", cuentas);
				response.sendRedirect("AltaPrestamoUsuario.jsp");
				break;

			case "filtrarCuentas":
				String filtro = request.getParameter("filtro");
				String txtFiltro = request.getParameter("txtFiltro");
				List<Cuenta> cuentasFiltradas = null;

				if (filtro != null && txtFiltro != null && !txtFiltro.isEmpty()) {
					switch (filtro) {
					case "Nro_cuenta":
						cuentasFiltradas = CueNeg.readNro(Integer.parseInt(txtFiltro));
						break;

					case "Id_cliente":
						cuentasFiltradas = CueNeg.readIdCliente(Integer.parseInt(txtFiltro));
						break;

					case "Tipo_cuenta":
						cuentasFiltradas = CueNeg.readTipoCuenta(Integer.parseInt(txtFiltro));
						System.out.println("Tipo Cuenta: " + txtFiltro);
						break;

					case "Cbu":
						cuentasFiltradas = CueNeg.readCBU(txtFiltro);
						break;
					}
				}
				if (cuentasFiltradas != null) {
					request.setAttribute("listaCu", cuentasFiltradas);
				} else {
					request.setAttribute("listaCu", Collections.emptyList());
				}
				dispatcher = request.getRequestDispatcher("/ListarCuentasAdmin.jsp");
				dispatcher.forward(request, response);
				break;
			default:
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create Cuenta
		if (request.getParameter("btnAceptar") != null) {
			Cuenta x = new Cuenta();
			x.setIdCliente(Integer.parseInt(request.getParameter("txtId")));
			Date fechaCreacion = new Date();
			x.setFechaCreacion(fechaCreacion);
			String tipoCuenta[] = request.getParameter("tipoCuenta").split("-");
			int idTipo = Integer.parseInt(tipoCuenta[0]);
			String descTipo = tipoCuenta[1];
			x.setTipoCuenta(new TipoCuenta(idTipo, descTipo));
			x.setCbu(request.getParameter("txtCbu"));

			Respuesta res = CueNeg.insert(x);
			request.setAttribute("EstadoCuenta", res);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaCuentaAdmin.jsp");
			rd.forward(request, response);
		}

		// Delete Cuenta
		if (request.getParameter("btnEliminar") != null) {
			String nro = request.getParameter("nroCuenta");
			Cuenta x = new Cuenta();
			x.setNroCuenta(Integer.parseInt(nro));
			if (nro != null && !nro.isEmpty()) {
				boolean estado = CueNeg.delete(x);
				request.setAttribute("Estado", estado);
			} else {
				request.setAttribute("Estado", false);
			}
			response.sendRedirect("ServletCuenta?Param=listarCuentas");
		}

		// Update Cuenta
		if (request.getParameter("btnEditar") != null) {
			String nro = request.getParameter("nroCuenta");
			List<Cuenta> lista = CueNeg.readNro(Integer.parseInt(nro));
			Cuenta x = lista.get(0);
			request.setAttribute("cuenta", x);
			RequestDispatcher rd = request.getRequestDispatcher("/EditarCuentaAdmin.jsp");
			rd.forward(request, response);
		}
		
		if (request.getParameter("btnConfirmarEdicion") != null) {
			Cuenta x = new Cuenta();
			x.setNroCuenta(Integer.parseInt(request.getParameter("nroCuenta")));
			x.setIdCliente(Integer.parseInt(request.getParameter("txtId")));
			String tipoCuenta[] = request.getParameter("ddlTipoCuenta").split("-");
			int idTipo = Integer.parseInt(tipoCuenta[0]);
			String descTipo = tipoCuenta[1];
			x.setTipoCuenta(new TipoCuenta(idTipo, descTipo));
			x.setCbu(request.getParameter("txtCbu"));
			x.setSaldo(Double.parseDouble(request.getParameter("txtSaldo")));
			boolean estado = false;
			estado = CueNeg.update(x);
			request.setAttribute("EstadoCuenta", estado);
			response.sendRedirect("ServletCuenta?Param=listarCuentas");
		}
		if (request.getParameter("btnCancelarEdicion") != null) {
			response.sendRedirect("ServletCuenta?Param=listarCuentas");
		}

		// Hacer Transferencia
		if (request.getParameter("btnNuevaTransferencia") != null) {
			String nroCuenta = request.getParameter("cuenta");
			String cbu = request.getParameter("cbu");
			String monto = request.getParameter("monto");
			String detalle = request.getParameter("detalle");

			Respuesta res = MovNeg.transferencia(Integer.parseInt(nroCuenta), Double.parseDouble(monto),
					detalle + " - CBU: " + cbu, cbu);
			request.getSession().setAttribute("estado", res);
			RequestDispatcher rd = request.getRequestDispatcher("/NuevaTransferenciaUsuario.jsp");
			rd.forward(request, response);
		}

	}
}
