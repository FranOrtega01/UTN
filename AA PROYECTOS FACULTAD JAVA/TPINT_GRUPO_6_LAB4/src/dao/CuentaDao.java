package dao;
import java.util.List;
import entidad.Cuenta;
import entidad.Respuesta;

public interface CuentaDao {
    public Respuesta insert(Cuenta cuenta);
    public boolean update(Cuenta cuenta);
    public boolean delete(Cuenta cuenta);
    List<Cuenta> readAll();
    List<Cuenta> readNro(int nro);
    List<Cuenta> readIdCliente(int nro);
    List<Cuenta> readCBU(String cbu);
    List<Cuenta> readTipoCuenta(int tipoCuenta);
    int getCuentaByCBU(String cbu);
    Cuenta getCuentaByID(int id);
}