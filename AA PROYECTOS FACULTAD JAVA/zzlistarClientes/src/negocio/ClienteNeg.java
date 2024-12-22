package negocio;

import java.util.List;
import entidad.*;

public interface ClienteNeg {
	public List<Cliente> readAll();
	public boolean insert(Cliente cliente);
    public boolean update(Cliente cliente);
    public boolean delete(Cliente cliente);
}
