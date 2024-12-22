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

public class ClienteDaoImpl implements ClienteDao {
	private static final String insert = "INSERT INTO Cliente (Dni, Cuil, Nombre, Apellido, Sexo, Nacionalidad, "
			+ "FechaNacimiento, Direccion, Localidad, Provincia, Email, Telefono, Usuario, Clave) VALUES "
			+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String update = "UPDATE Cliente SET Dni = ?, Cuil = ?, Nombre = ?, Apellido = ?, Sexo = ?, "
			+ "Nacionalidad = ?, FechaNacimiento = ?, Direccion = ?, Localidad = ?, Provincia = ?, Email = ?, "
			+ "Telefono = ?, Usuario = ?, Clave = ? WHERE IdCliente = ?";
    private static final String delete = "DELETE FROM Cliente WHERE IdCliente = ?";
	private static final String readAll = "SELECT * FROM Cliente";

	public boolean insert(Cliente cliente)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasInserted = false;
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
				hasInserted = true;
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return hasInserted;
	}
    
	public boolean update(Cliente cliente)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasUpdated = false;
		try
		{
			statement = cn.prepareStatement(update);
            statement.setString(1, cliente.getDni());
            statement.setString(2, cliente.getCuil());
            statement.setString(3, cliente.getNombre());
            statement.setString(4, cliente.getApellido());
            statement.setString(5, String.valueOf(cliente.getSexo()));
            statement.setString(6, cliente.getNacionalidad());
            statement.setDate(7, (Date) cliente.getFechaNacimiento());
            statement.setString(8, cliente.getDireccion());
            statement.setString(9, cliente.getLocalidad());
            statement.setString(10, cliente.getProvincia());
            statement.setString(11, cliente.getEmail());
            statement.setString(12, cliente.getTelefono());
            statement.setString(13, cliente.getUsuario());
            statement.setString(14, cliente.getClave());
            statement.setInt(15, cliente.getIdCliente());
			if(statement.executeUpdate() > 0)
			{
				cn.commit();
				hasUpdated = true;
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
			try {
				cn.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
			}
		}
		return hasUpdated;
	}
    
	public boolean delete(Cliente cliente)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasDeleted = false;
		try 
		{
			statement = cn.prepareStatement(delete);
			statement.setInt(1, cliente.getIdCliente());
			if(statement.executeUpdate() > 0)
			{
				cn.commit();
				hasDeleted = true;
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e.getMessage());
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
