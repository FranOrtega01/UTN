package negocioImpl;

import java.util.List;

import javax.servlet.RequestDispatcher;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidad.Cliente;
import entidad.Respuesta;
import negocio.ClienteNeg;

public class ClienteNegImpl implements ClienteNeg{
	
	private ClienteDao CliDao = new ClienteDaoImpl();
	
	public ClienteNegImpl() {
	}
	
	public ClienteNegImpl(ClienteDao CliDao) {
		this.CliDao = CliDao;
	}

	@Override
	public List<Cliente> readAll() {
		return (List<Cliente>)CliDao.readAll();
	}

	@Override
	public Respuesta insert(Cliente cliente) {
		
		if(!CliDao.readByDNI(cliente.getDni()).isEmpty()) {
			return new Respuesta(false, "Ya hay un usuario con este DNI");
		}
		
		if(!CliDao.readByCUIL(cliente.getCuil()).isEmpty()) {
			return new Respuesta(false, "Ya hay un usuario con este CUIL");
		}
		
		
		return CliDao.insert(cliente);
	}

	@Override
	public Respuesta update(Cliente cliente, String id) {
		Cliente aux = CliDao.readById(Integer.parseInt(id)).get(0);
		
		if(!aux.getDni().equals(cliente.getDni()) && !CliDao.readByDNI(cliente.getDni()).isEmpty()) {
			return new Respuesta(false, "Ya hay un usuario con este DNI");
		}
//		
		if(!aux.getCuil().equals(cliente.getCuil()) && !CliDao.readByCUIL(cliente.getCuil()).isEmpty()) {
			return new Respuesta(false, "Ya hay un usuario con este CUIL");
		}
		
		return CliDao.update(cliente);
	}

	@Override
	public Respuesta delete(Cliente cliente) {
		return CliDao.delete(cliente);
	}
	
	@Override
	public List<Cliente> readById(int id) {
		return (List<Cliente>)CliDao.readById(id);
	}
	
	public List<Cliente> readByApellido(String apellido) {
		return (List<Cliente>)CliDao.readByApellido(apellido);
	}

	@Override
	public List<Cliente> readByNombre(String nombre) {
		return (List<Cliente>)CliDao.readByNombre(nombre);
	}
	
	@Override
	public List<Cliente> readByDNI(String dni) {
		return (List<Cliente>)CliDao.readByDNI(dni);
	}

	@Override
	public List<Cliente> readByCUIL(String cuil) {
		return (List<Cliente>)CliDao.readByDNI(cuil);
	}
	
	@Override
	public int obtenerTotalUsuarios() {
	    return CliDao.obtenerTotalUsuarios();
	}

	@Override
	public int obtenerTotalCuentas() {
	    return CliDao.obtenerTotalCuentas();
	}

	@Override
	public double obtenerTotalDineroDepositado() {
	    return CliDao.obtenerTotalDineroDepositado();
	}

	@Override
	public String obtenerMesConMayorMovimientos() {
	    return CliDao.obtenerMesConMayorMovimientos();
	}



}
