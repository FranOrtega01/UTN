package dao;
import entidad.Movimiento;
import entidad.Respuesta;

import java.util.List;

public interface MovimientoDao {
	List<Movimiento> readIdCuenta(int id);
	boolean movimiento(Movimiento mov);
	Respuesta transferencia(Movimiento mov, int cuentaReceptor);
}
