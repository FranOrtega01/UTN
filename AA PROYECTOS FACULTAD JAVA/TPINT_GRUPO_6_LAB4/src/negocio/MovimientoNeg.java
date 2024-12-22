package negocio;

import java.util.List;

import entidad.*;

public interface MovimientoNeg {
	public List<Movimiento> readIdCuenta(int nro);
	public boolean movimiento(Movimiento mov);
	public Respuesta transferencia(int nroCuentaEmisor, double monto, String detalle, String cbu);
}
