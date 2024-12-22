package negocio;

import java.util.List;

import entidad.Cuota;
import entidad.Prestamo;
import entidad.Respuesta;

public interface PrestamoNeg {
	public boolean insert(Prestamo prestamo);
    public boolean update(Prestamo prestamo);
    public boolean delete(Prestamo prestamo);
    public List<Prestamo> readAll();
    public List<Prestamo> readByIDCuenta(int id);
    public List<Prestamo> readByIDUser(int id);
    public Respuesta pagarCuota(Cuota c);
    public boolean existePrestamoActivo(int cuentaId);
}
