package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entidad.Cliente;
import negocio.ClienteNeg;
import negocioImpl.ClienteNegImpl;

@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	ClienteNeg CliNeg = new ClienteNegImpl();
       
    public ServletClientes() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("Param")!=null)
		{
	        String opcion = request.getParameter("Param");
	        
	        switch (opcion) {
	            case "listarClientes":
	                System.out.println("Listando clientes");
	                List<Cliente> clientes = CliNeg.readAll();
	                if (clientes == null || clientes.isEmpty()) {
	                    System.out.println("No hay clientes disponibles.");
	                } else {
	                    System.out.println("Clientes encontrados: " + clientes.size());
	                }
	                request.setAttribute("listaCl", clientes);
	                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListarClientesAdmin.jsp");
	                dispatcher.forward(request, response);
	                break;
	            default:
	                break;
	        }
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar") != null) {
			Cliente x = new Cliente();
			x.setDni(request.getParameter("txtDni"));
			x.setCuil(request.getParameter("txtCuil"));
			x.setNombre(request.getParameter("txtNombre"));
			x.setApellido(request.getParameter("txtApellido"));
			// Convertir el valor de sexo a char
	        String sexoString = request.getParameter("txtSexo");
	        char sexo = (sexoString != null && !sexoString.isEmpty()) ? sexoString.charAt(0) : '\0'; // Usar '\0' si está vacío o null
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
				} // Convierte el String en Date
	            x.setFechaNacimiento(fecha);
	        }
	        x.setDireccion(request.getParameter("txtDireccion"));
	        x.setLocalidad(request.getParameter("txtLocalidad"));
	        x.setProvincia(request.getParameter("ddlProvincia"));
	        x.setEmail(request.getParameter("txtEmail"));
	        x.setTelefono(request.getParameter("txtTelefono"));
	        x.setUsuario(request.getParameter("txtUsuario"));
	        x.setClave(request.getParameter("txtClave"));
	        boolean estado = false;
	        estado = CliNeg.insert(x);
	        request.setAttribute("EstadoCliente", estado);
	        RequestDispatcher rd = request.getRequestDispatcher("/AltaClienteAdmin.jsp");
	        rd.forward(request, response);
		}
	}
}
