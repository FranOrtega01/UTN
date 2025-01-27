package negocio;

import java.util.List;
import entidad.*;

public interface ClienteNeg {
	public Respuesta insert(Cliente cliente);
    public Respuesta update(Cliente cliente, String id);
    public Respuesta delete(Cliente cliente);
    public List<Cliente> readAll();
	public List<Cliente> readById(int id);
	public List<Cliente> readByApellido(String apellido);
	public List<Cliente> readByNombre(String nombre);
	public List<Cliente> readByDNI(String dni);
	public List<Cliente> readByCUIL(String cuil);
	public int obtenerTotalUsuarios();
	public int obtenerTotalCuentas();
	public double obtenerTotalDineroDepositado();
	public String obtenerMesConMayorMovimientos();
}
