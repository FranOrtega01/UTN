package servlets;

import java.io.IOException;
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

import entidad.Cliente;
import entidad.Cuota;
import entidad.Prestamo;
import entidad.Respuesta;
import negocioImpl.*;

@WebServlet("/ServletPrestamo")
public class ServletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrestamoNegImpl preNeg = new PrestamoNegImpl();

	public ServletPrestamo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("Param") != null) {
			String opcion = request.getParameter("Param");
			String userId = null;
			String role = null;
			Cookie[] cookies = request.getCookies();
			;
			String idCuentaParam = request.getParameter("idCuenta");
			String estadoParam = request.getParameter("estado");

			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("userID".equals(cookie.getName())) {
						userId = cookie.getValue();
					}
					if ("role".equals(cookie.getName())) {
						role = cookie.getValue();
					}
				}
			}

			switch (opcion) {
			case "listarPrestamos":
				List<Prestamo> prestamosPagina = null;
				int prestamosPorPagina = 5;
				int paginaActual = 1;

				if (request.getParameter("pagina") != null) {
					try {
						paginaActual = Integer.parseInt(request.getParameter("pagina"));
					} catch (NumberFormatException e) {
						paginaActual = 1;
					}
				}

				// Obtener los pr�stamos seg�n el rol
				if ("Usuario".equals(role) && userId != null) {
					List<Prestamo> prestamos = preNeg.readByIDUser(Integer.parseInt(userId));
					// Filtrar si ID Cuenta est� presente
					if (idCuentaParam != null && !idCuentaParam.trim().isEmpty()) {
						try {
							int idCuenta = Integer.parseInt(idCuentaParam.trim());
							prestamos = prestamos.stream().filter(p -> p.getIdCuenta() == idCuenta)
									.collect(Collectors.toList());
						} catch (NumberFormatException e) {
							request.setAttribute("error", "El ID de Cuenta no es v�lido.");
						}
					}

					if (estadoParam != null && !estadoParam.trim().isEmpty()) {
						prestamos = prestamos.stream().filter(p -> estadoParam.equalsIgnoreCase(p.getEstado()))
								.collect(Collectors.toList());
					}

					int totalPrestamos = prestamos.size();
					int totalPaginas = (int) Math.ceil((double) totalPrestamos / prestamosPorPagina);

					int inicio = (paginaActual - 1) * prestamosPorPagina;
					int fin = Math.min(inicio + prestamosPorPagina, totalPrestamos);

					prestamosPagina = prestamos.subList(inicio, fin);
					request.setAttribute("listaPr", prestamosPagina);
					request.setAttribute("paginaActual", paginaActual);
					request.setAttribute("totalPaginas", totalPaginas);

				} else if ("Admin".equals(role)) {
					List<Prestamo> prestamos = preNeg.readAll();

					// Filtrar si ID Cuenta est� presente
					if (idCuentaParam != null && !idCuentaParam.trim().isEmpty()) {
						try {
							int idCuenta = Integer.parseInt(idCuentaParam.trim());
							prestamos = prestamos.stream().filter(p -> p.getIdCuenta() == idCuenta)
									.collect(Collectors.toList());
						} catch (NumberFormatException e) {
							request.setAttribute("error", "El ID de Cuenta no es v�lido.");
						}
					}

					if (estadoParam != null && !estadoParam.trim().isEmpty()) {
						prestamos = prestamos.stream().filter(p -> estadoParam.equalsIgnoreCase(p.getEstado()))
								.collect(Collectors.toList());
					}

					int totalPrestamos = prestamos.size();
					int totalPaginas = (int) Math.ceil((double) totalPrestamos / prestamosPorPagina);

					int inicio = (paginaActual - 1) * prestamosPorPagina;
					int fin = Math.min(inicio + prestamosPorPagina, totalPrestamos);

					prestamosPagina = prestamos.subList(inicio, fin);

					request.setAttribute("listaPr", prestamosPagina);
					request.setAttribute("paginaActual", paginaActual);
					request.setAttribute("totalPaginas", totalPaginas);
				}

				// Redirigir a la JSP correspondiente
				RequestDispatcher dispatcher = request.getRequestDispatcher(
						"Usuario".equals(role) ? "/ListarPrestamosUsuario.jsp" : "/ListarPrestamosAdmin.jsp");
				dispatcher.forward(request, response);
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Solicitud Prestamo
		HttpSession session = request.getSession();
		if (request.getParameter("SolicitarPrestamo") != null) {
			double monto = Double.parseDouble((String) request.getParameter("monto"));
			int cuotas = Integer.parseInt((String) request.getParameter("cuotas"));
			int cuentaId = Integer.parseInt(request.getParameter("cuenta"));

			boolean existePrestamoActivo = preNeg.existePrestamoActivo(cuentaId);

			if (existePrestamoActivo) {
				request.setAttribute("estado", false);
				request.setAttribute("mensajeError", "Ya existe un pr�stamo pendiente o activo para esta cuenta.");
				RequestDispatcher rd = request.getRequestDispatcher("/AltaPrestamoUsuario.jsp");
				rd.forward(request, response);
				return;
			}

			Prestamo aux = new Prestamo(Integer.parseInt((String) request.getParameter("cuenta")), monto, cuotas,
					cuotas);
			boolean estado = preNeg.insert(aux);
			request.setAttribute("estado", estado);
			RequestDispatcher rd = request.getRequestDispatcher("/AltaPrestamoUsuario.jsp");
			rd.forward(request, response);
		}
		// Aprobar / Rechazar
		if (request.getParameter("btnAprobar") != null || request.getParameter("btnRechazar") != null) {
			Prestamo aux = new Prestamo();
			String estadoPr = "Pendiente";
			if (request.getParameter("btnAprobar") != null) {
				estadoPr = request.getParameter("btnAprobar");
			} else if (request.getParameter("btnRechazar") != null) {
				estadoPr = request.getParameter("btnRechazar");
			}
			aux.setEstado(estadoPr);
			aux.setIdPrestamo(Integer.parseInt(request.getParameter("idPrestamo")));

			boolean estado = preNeg.update(aux);
			request.setAttribute("estado", estado ? estadoPr : "Hubo un error");
			RequestDispatcher rd = request.getRequestDispatcher("/ListarPrestamosAdmin.jsp");
			rd.forward(request, response);
		}

		// Pagar Cuota
		if (request.getParameter("btnPagarCuota") != null) {
			Cuota aux = new Cuota();
			aux.setIdPrestamo(Integer.parseInt(request.getParameter("idPrestamo")));
			aux.setNroCuota(Integer.parseInt(request.getParameter("btnPagarCuota")));

			Respuesta estado = preNeg.pagarCuota(aux);
			session.setAttribute("estado", estado);
			RequestDispatcher rd = request.getRequestDispatcher("/ListarPrestamosUsuario.jsp");
			rd.forward(request, response);

		}
	}
}
