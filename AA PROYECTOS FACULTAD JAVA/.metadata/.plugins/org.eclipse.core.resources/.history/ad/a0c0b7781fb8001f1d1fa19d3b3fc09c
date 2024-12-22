package negocioImpl;

import java.util.List;

import dao.*;
import daoImpl.CuentaDaoImpl;
import entidad.*;
import negocio.*;

public class CuentaNegImpl implements CuentaNeg{
	
	private CuentaDao CueDao = new CuentaDaoImpl();
	
	public CuentaNegImpl() {
		
	}

	public CuentaNegImpl(CuentaDao CueDao) {
		this.CueDao = CueDao;
	}
	
	@Override
	public Respuesta insert(Cuenta cuenta) {
		return CueDao.insert(cuenta);
	}

	@Override
	public boolean update(Cuenta cuenta) {
		return CueDao.update(cuenta);
	}

	@Override
	public boolean delete(Cuenta cuenta) {
		return CueDao.delete(cuenta);
	}

	@Override
	public List<Cuenta> readAll() {
		return (List<Cuenta>)CueDao.readAll();
	}

	@Override
	public List<Cuenta> readNro(int nro) {
		return (List<Cuenta>)CueDao.readNro(nro);

	}
	
	@Override
	public List<Cuenta> readIdCliente(int nro) {
		return (List<Cuenta>)CueDao.readIdCliente(nro);
	}

	@Override
	public List<Cuenta> readCBU(String cbu) {
		return (List<Cuenta>)CueDao.readCBU(cbu);
	}

	@Override
	public List<Cuenta> readTipoCuenta(int tipoCuenta) {
		return (List<Cuenta>)CueDao.readTipoCuenta(tipoCuenta);
	}

}
