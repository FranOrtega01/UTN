package dao;

import java.util.List;

import entidad.Cuota;
import entidad.Prestamo;
import entidad.Respuesta;

public interface PrestamoDao {
	public boolean insert(Prestamo prestamo);
    public boolean update(Prestamo prestamo);
    public boolean delete(Prestamo prestamo);
    List<Prestamo> readAll();
    public Prestamo readByPrestamoID(int id);
    List<Prestamo> readByIDCuenta(int id);
    List<Prestamo> readByIDUser(int id);
    public Respuesta pagarCuota(Cuota c);
    public boolean existePrestamoActivo(int cuentaId);
}