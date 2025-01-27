package negocio;

import java.util.List;

import entidad.*;

public interface CuentaNeg {
    public Respuesta insert(Cuenta cuenta);
    public boolean update(Cuenta cuenta);
    public boolean delete(Cuenta cuenta);
    public List<Cuenta> readAll();
    public List<Cuenta> readNro(int nro);
    public List<Cuenta> readIdCliente(int nro);
    List<Cuenta> readCBU(String cbu);
    List<Cuenta> readTipoCuenta(int tipoCuenta);
}