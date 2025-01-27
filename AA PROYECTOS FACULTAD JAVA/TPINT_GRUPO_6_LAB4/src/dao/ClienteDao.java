package dao;
import java.util.List;
import entidad.Cliente;
import entidad.Respuesta;

public interface ClienteDao {
    public Respuesta insert(Cliente cliente);
    public Respuesta update(Cliente cliente);
    public Respuesta delete(Cliente cliente);
    List<Cliente> readAll();
    List<Cliente> readById(int id);
    List<Cliente> readByApellido(String apellido);
	List<Cliente> readByNombre(String nombre);
	List<Cliente> readByDNI(String dni);
	List<Cliente> readByCUIL(String cuil);
	public int obtenerTotalUsuarios();
	public int obtenerTotalCuentas();
	public double obtenerTotalDineroDepositado();
	public String obtenerMesConMayorMovimientos();
}
