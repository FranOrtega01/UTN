package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.*;
import negocio.*;
import negocioImpl.*;



/**
 * Servlet implementation class ServletEstadistico
 */
@WebServlet("/ServletEstadistico")
public class ServletEstadistico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEstadistico() {
        super();
        
        
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuentaNeg CueNeg = new CuentaNegImpl();
        List<Cuenta> cuentas = CueNeg.readAll();
        List<Cuenta> filtroCuentas = null;
        
        PrestamoNeg PreNeg = new PrestamoNegImpl();
        List<Prestamo> prestamos = PreNeg.readAll();
        List<Prestamo> filtroPrestamos = null;

        ClienteNeg CliNeg = new ClienteNegImpl();
        HttpSession session =  request.getSession();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaInicioStr = request.getParameter("fechaInicio");
            String fechaFinStr = request.getParameter("fechaFin");

            if (fechaInicioStr != null && fechaFinStr != null) {
                Date fechaInicio = sdf.parse(fechaInicioStr);
                Date fechaFin = sdf.parse(fechaFinStr);

                // Filtro Cuentas
                filtroCuentas = cuentas.stream()
                    .filter(cuenta -> {
                        Date fechaCreacion = cuenta.getFechaCreacion();
                        return fechaCreacion != null &&
                               !fechaCreacion.before(fechaInicio) &&
                               !fechaCreacion.after(fechaFin);
                    })
                    .collect(Collectors.toList());

                // Filtro Prestamos
                filtroPrestamos = prestamos.stream()
                    .filter(prestamo -> {
                        Date fechaPrestamo = prestamo.getFecha();
                        return fechaPrestamo != null &&
                               !fechaPrestamo.before(fechaInicio) &&
                               !fechaPrestamo.after(fechaFin);
                    })
                    .collect(Collectors.toList());

                int totalCuotasPagas = 0;
                int totalCuotas = 0;
                int prestamosFiltrados = filtroPrestamos.size();

                for (Prestamo prestamo : filtroPrestamos) {
                    totalCuotasPagas += prestamo.getCuotasPagas();
                    if(!"Rechazado".equals(prestamo.getEstado())) totalCuotas += prestamo.getCuotas();
                }

                double promedioCuotasPagas = prestamosFiltrados > 0 ? ((double)totalCuotasPagas / (double)totalCuotas) * 100 : 0.0;
               
                session.setAttribute("totalCuentas", filtroCuentas.size());
                session.setAttribute("totalPrestamos", filtroPrestamos.size());
                session.setAttribute("totalCuotas", totalCuotas);
                session.setAttribute("promedioCuotasPagas", promedioCuotasPagas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        int usuariosRegistrados = CliNeg.obtenerTotalUsuarios();
	    int cuentasCreadas = CliNeg.obtenerTotalCuentas();
	    double dineroDepositado = CliNeg.obtenerTotalDineroDepositado();
	    String mesMayorMovimientos = CliNeg.obtenerMesConMayorMovimientos();

	    session.setAttribute("usuariosRegistrados", usuariosRegistrados);
	    session.setAttribute("cuentasCreadas", cuentasCreadas);
	    session.setAttribute("dineroDepositado", dineroDepositado);
	    session.setAttribute("mesMayorMovimientos", mesMayorMovimientos);
      
        RequestDispatcher rd = request.getRequestDispatcher("/InformeEstadisticoAdmin.jsp");
        rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
