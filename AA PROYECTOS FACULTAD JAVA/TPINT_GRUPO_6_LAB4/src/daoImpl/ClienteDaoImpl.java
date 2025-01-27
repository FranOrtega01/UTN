package daoImpl;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import entidad.Cliente;
import entidad.Respuesta;

public class ClienteDaoImpl implements ClienteDao {
	private static final String insert = "INSERT INTO Clientes (Dni, Cuil, Nombre, Apellido, Sexo, Nacionalidad, "
			+ "FechaNacimiento, Direccion, Localidad, Provincia, Email, Telefono, Usuario, Clave) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String update = "UPDATE Clientes SET Dni = ?, Cuil = ?, Nombre = ?, Apellido = ?, Sexo = ?, "
			+ "Nacionalidad = ?, FechaNacimiento = ?, Direccion = ?, Localidad = ?, Provincia = ?, Email = ?, "
			+ "Telefono = ?, Clave = ? WHERE IdCliente = ?";
    private static final String delete = "UPDATE Clientes set Activo = 0 WHERE IdCliente = ?";
    private static final String readAll = "SELECT IdCliente, Dni, Cuil, Nombre, Apellido,Sexo, Nacionalidad,FechaNacimiento, "
    		+ "Direccion, Localidad, Provincia, Email, Telefono, Usuario, Clave FROM Clientes WHERE Activo = TRUE";
    private static final String readById = "SELECT IdCliente, Dni, Cuil, Nombre, Apellido,Sexo, Nacionalidad,FechaNacimiento, "
    		+ "Direccion, Localidad, Provincia, Email, Telefono, Usuario, Clave FROM Clientes WHERE Activo = TRUE and IdCliente = ?";
    private static final String readByApellido = "SELECT IdCliente, Dni, Cuil, Nombre, Apellido,Sexo, Nacionalidad,FechaNacimiento, "
    		+ "Direccion, Localidad, Provincia, Email, Telefono, Usuario, Clave FROM Clientes WHERE Activo = TRUE and Apellido LIKE ?";
    private static final String readByNombre = "SELECT IdCliente, Dni, Cuil, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, "
            + "Direccion, Localidad, Provincia, Email, Telefono, Usuario, Clave FROM Clientes WHERE Activo = TRUE and Nombre LIKE ?";
    
    private static final String readByDNI = "SELECT IdCliente, Dni, Cuil, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, "
            + "Direccion, Localidad, Provincia, Email, Telefono, Usuario, Clave FROM Clientes WHERE Activo = TRUE and dni = ?";
    
    private static final String readByCUIL = "SELECT IdCliente, Dni, Cuil, Nombre, Apellido, Sexo, Nacionalidad, FechaNacimiento, "
            + "Direccion, Localidad, Provincia, Email, Telefono, Usuario, Clave FROM Clientes WHERE Activo = TRUE and cuil = ?";
    
	private static final String readAllClientes = "SELECT COUNT(*) FROM Clientes";
	private static final String readAllCuentas = "SELECT COUNT(*) FROM Cuentas";
	private static final String readSumDinero = "SELECT SUM(saldo) FROM Cuentas";
	private static final String readMesMayorMov = "SELECT DATE_FORMAT(fecha, '%M') AS mes, COUNT(*) AS totalMovimientos " 
			+ "FROM movimientos WHERE YEAR(fecha) = YEAR(CURRENT_DATE())GROUP BY mes ORDER BY totalMovimientos DESC LIMIT 1";
    
    public Respuesta insert(Cliente cliente)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		Respuesta hasInserted = new Respuesta();
		try
		{
			statement = cn.prepareStatement(insert);
            statement.setString(1, cliente.getDni());
            statement.setString(2, cliente.getCuil());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getApellido());
            statement.setString(5, String.valueOf(cliente.getSexo()));
            statement.setString(6, cliente.getNacionalidad());
            java.util.Date utilDate = cliente.getFechaNacimiento();
            if (utilDate != null) {
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                statement.setDate(7, sqlDate);
            } 
            else {
                statement.setNull(7, java.sql.Types.DATE);  
                }
            statement.setString(8, cliente.getDireccion());
            statement.setString(9, cliente.getLocalidad());
            statement.setString(10, cliente.getProvincia());
            statement.setString(11, cliente.getEmail());
            statement.setString(12, cliente.getTelefono());
            statement.setString(13, cliente.getUsuario());
            statement.setString(14, cliente.getClave());
			if(statement.executeUpdate() > 0)
			{
				cn.commit();
				hasInserted.setEstado(true);
				hasInserted.setMensaje("Se agrego correctamente.");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			try {
				cn.rollback();
				hasInserted.setEstado(false);
				hasInserted.setMensaje(e.getMessage());
			} catch (SQLException e1) {
				hasInserted.setEstado(false);
				hasInserted.setMensaje(e.getMessage());
			}
		}
		return hasInserted;
	}
    
	public Respuesta update(Cliente cliente)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		Respuesta hasUpdated = new Respuesta();
		try
		{
			statement = cn.prepareStatement(update);
            statement.setString(1, cliente.getDni());
            statement.setString(2, cliente.getCuil());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getApellido());
            statement.setString(5, String.valueOf(cliente.getSexo()));
            statement.setString(6, cliente.getNacionalidad());
            java.util.Date utilDate = cliente.getFechaNacimiento();
            if (utilDate != null) {
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                statement.setDate(7, sqlDate);
            } 
            else {
                statement.setNull(7, java.sql.Types.DATE);  
                }
            statement.setString(8, cliente.getDireccion());
            statement.setString(9, cliente.getLocalidad());
            statement.setString(10, cliente.getProvincia());
            statement.setString(11, cliente.getEmail());
            statement.setString(12, cliente.getTelefono());
            statement.setString(13, cliente.getClave());
            statement.setInt(14, cliente.getIdCliente());
            int filas = statement.executeUpdate();
            System.out.println(filas);
			if(filas > 0)
			{
				cn.commit();
				hasUpdated.setEstado(true);
				hasUpdated.setMensaje("Se agrego correctamente.");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			try {
				cn.rollback();
				hasUpdated.setEstado(false);
				hasUpdated.setMensaje(e.getMessage());
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
				hasUpdated.setEstado(false);
				hasUpdated.setMensaje(e.getMessage());
			}
		}
		return hasUpdated;
	}
    
	public Respuesta delete(Cliente cliente)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		Respuesta hasDeleted = new Respuesta();
		try 
		{
			statement = cn.prepareStatement(delete);
			statement.setInt(1, cliente.getIdCliente());
			if(statement.executeUpdate() > 0)
			{
				cn.commit();
				hasDeleted.setEstado(true);
				hasDeleted.setMensaje("Usuario eliminado correctamente");
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			hasDeleted.setEstado(false);
			hasDeleted.setMensaje(e.getMessage());
		}
		return hasDeleted;
	}

	public List<Cliente> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				clientes.add(getCliente(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return clientes;
	}
	
	public List<Cliente> readById(int id) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readById);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				clientes.add(getCliente(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return clientes;
	}
	
	@Override
	public List<Cliente> readByNombre(String nombre) {
		PreparedStatement statement;
        ResultSet resultSet;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Conexion conexion = Conexion.getConexion();
        try {
            statement = conexion.getSQLConexion().prepareStatement(readByNombre);
            statement.setString(1, "%" + nombre + "%");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                clientes.add(getCliente(resultSet));
            }
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
	}
	
	public List<Cliente> readByApellido(String apellido) {
		System.out.println(apellido);
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readByApellido);
			statement.setString(1, apellido);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				clientes.add(getCliente(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return clientes;
	}
	
	public List<Cliente> readByDNI(String dni) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readByDNI);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				clientes.add(getCliente(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return clientes;
	}
	
	public List<Cliente> readByCUIL(String dni) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readByCUIL);
			statement.setString(1, dni);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				clientes.add(getCliente(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return clientes;
	}
	
	@Override
	public int obtenerTotalUsuarios() {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion cn = Conexion.getConexion();
	    try {
	    	statement = cn.getSQLConexion().prepareStatement(readAllClientes);
	    	resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getInt(1);
	        }
	    } catch (SQLException e) {
			System.out.println(e.getMessage());
	    }
	    return 0;
	}

	@Override
	public int obtenerTotalCuentas() {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion cn = Conexion.getConexion();
	    try {
	    	statement = cn.getSQLConexion().prepareStatement(readAllCuentas);
	    	resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getInt(1);
	        }
	    } catch (SQLException e) {
			System.out.println(e.getMessage());
	    }
	    return 0;
	}

	@Override
	public double obtenerTotalDineroDepositado() {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion cn = Conexion.getConexion();
	    try {
	    	statement = cn.getSQLConexion().prepareStatement(readSumDinero);
	    	resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getDouble(1);
	        }
	    } catch (SQLException e) {
			System.out.println(e.getMessage());
	    }
	    return 0.0;
	}

	@Override
	public String obtenerMesConMayorMovimientos() {
		PreparedStatement statement;
		ResultSet resultSet; 
		Conexion cn = Conexion.getConexion();
	    try {
	    	statement = cn.getSQLConexion().prepareStatement(readMesMayorMov);
	    	resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getString("mes");
	        }
	    } catch (SQLException e) {
			System.out.println(e.getMessage());
	    }
	    return "No disponible";
	}

	private Cliente getCliente(ResultSet resultSet) throws SQLException{
	    int idCliente = resultSet.getInt("IdCliente");
	    String dni = resultSet.getString("Dni");
	    String cuil = resultSet.getString("Cuil");
	    String nombre = resultSet.getString("Nombre");
	    String apellido = resultSet.getString("Apellido");
	    char sexo = resultSet.getString("Sexo").charAt(0);
	    String nacionalidad = resultSet.getString("Nacionalidad");
	    Date fechaNacimiento = resultSet.getDate("FechaNacimiento");
	    String direccion = resultSet.getString("Direccion");
	    String localidad = resultSet.getString("Localidad");
	    String provincia = resultSet.getString("Provincia");
	    String email = resultSet.getString("Email");
	    String telefono = resultSet.getString("Telefono");
	    String usuario = resultSet.getString("Usuario");
	    String clave = resultSet.getString("Clave");
		
	    return new Cliente(idCliente, dni, cuil, nombre, apellido, sexo, nacionalidad, fechaNacimiento, direccion, 
	    		localidad, provincia, email, telefono, usuario, clave);
	}


}
