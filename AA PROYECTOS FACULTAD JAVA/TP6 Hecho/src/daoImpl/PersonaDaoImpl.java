package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, apellido) VALUES(?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String update = "UPDATE personas set nombre = ?, apellido = ? WHERE idPersona = ?";
	private static final String readAll = "SELECT * FROM personas";
	
	public boolean insert(Persona persona)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasInserted = false;
		try
		{
			statement = cn.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getApellido());
			if(statement.executeUpdate() > 0)
			{
				cn.commit();
				hasInserted = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return hasInserted;
	}
	
	public boolean update(Persona persona)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasUpdated = false;
		try
		{
			statement = cn.prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setInt(3, persona.getIdPersona());
			if(statement.executeUpdate() > 0)
			{
				cn.commit();
				hasUpdated = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				cn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return hasUpdated;
	}
	
	public boolean delete(Persona persona)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasDeleted = false;
		try 
		{
			statement = cn.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona.getIdPersona()));
			if(statement.executeUpdate() > 0)
			{
				cn.commit();
				hasDeleted = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return hasDeleted;
	}
	
	public List<Persona> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersona(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private Persona getPersona(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String apellido = resultSet.getString("Apellido");
		return new Persona(id, nombre, apellido);
	}
}
