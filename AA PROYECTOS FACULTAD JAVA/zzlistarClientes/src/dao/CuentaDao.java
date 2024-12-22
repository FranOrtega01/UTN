package dao;
import java.util.List;
import entidad.Cuenta;

public interface CuentaDao {
    public boolean insert(Cuenta cuenta);
    public boolean update(Cuenta cuenta);
    public boolean delete(Cuenta cuenta);
    public List<Cuenta> readAll();
}
