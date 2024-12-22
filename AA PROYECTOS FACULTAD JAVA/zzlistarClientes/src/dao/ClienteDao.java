package dao;
import java.util.List;
import entidad.Cliente;

public interface ClienteDao {
    public boolean insert(Cliente cliente);
    public boolean update(Cliente cliente);
    public boolean delete(Cliente cliente);
    public List<Cliente> readAll();
}
