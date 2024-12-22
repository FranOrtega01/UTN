package negocioImpl;

import java.util.List;

import dao.ClienteDao;
import daoImpl.ClienteDaoImpl;
import entidad.Cliente;
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
		return CliDao.readAll();
	}

	@Override
	public boolean insert(Cliente cliente) {
		return CliDao.insert(cliente);
	}

	@Override
	public boolean update(Cliente cliente) {
		return CliDao.update(cliente);
	}

	@Override
	public boolean delete(Cliente cliente) {
		return CliDao.delete(cliente);
	}

}
