package negocioImpl;

import java.util.List;

import dao.MovimientoDao;
import dao.CuentaDao;
import daoImpl.CuentaDaoImpl;
import daoImpl.MovimientoDaoImpl;
import entidad.Movimiento;
import entidad.Respuesta;
import entidad.TipoMovimiento;
import negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg{
	private MovimientoDao MovDao = new MovimientoDaoImpl();
	private CuentaDao CueDao = new CuentaDaoImpl();
	
	@Override
	public List<Movimiento> readIdCuenta(int id) {
		return (List<Movimiento>)MovDao.readIdCuenta(id);
	}
	
	@Override
	public boolean movimiento(Movimiento mov) {
		return MovDao.movimiento(mov);
	}

	public Respuesta transferencia(int nroCuentaEmisor, double monto, String detalle, String cbu) {
		int nroCuentaReceptor = CueDao.getCuentaByCBU(cbu);
		
		if(nroCuentaReceptor == -1) {
			return new Respuesta(false, "El CBU no corresponde a una cuenta.");
		}
		
		if(nroCuentaEmisor == nroCuentaReceptor) {
			return new Respuesta(false, "No puedes transferir a la misma cuenta.");
		}
		
		if(CueDao.getCuentaByID(nroCuentaReceptor).getSaldo() < monto) {
			return new Respuesta(false, "Saldo insuficiente.");
		}
		
		Movimiento aux = new Movimiento();
		// Emisor
		aux.setNroCuenta(nroCuentaEmisor);
		aux.setImporte(monto);
		aux.setDetalle(detalle);
		aux.setTipoMovimiento(new TipoMovimiento(4));
		
		return MovDao.transferencia(aux, nroCuentaReceptor);
	}

}
