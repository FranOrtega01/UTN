package daoImpl;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CuentaDao;
import entidad.Cuenta;

public class CuentaDaoImpl implements CuentaDao {
	private static final String insert = "INSERT INTO Cuentas (NroCuenta, IdCliente, FechaCreacion, TipoCuenta, Cbu, Saldo) "
			+ "VALUES (?, ?, ?, ?, ?, ?)";
	private static final String update = "UPDATE Cuentas SET IdCliente = ?, FechaCreacion = ?, TipoCuenta = ?, Cbu = ?, "
			+ "Saldo = ?, Activo = ? WHERE NroCuenta = ?";
    private static final String delete = "DELETE FROM Cuentas WHERE NroCuenta = ?";
	private static final String readAll = "SELECT * FROM Cuentas";

	public boolean insert(Cuenta cuenta)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasInserted = false;
		try
		{
			statement = cn.prepareStatement(insert);
            statement.setInt(1, cuenta.getNroCuenta());
            statement.setInt(2, cuenta.getIdCliente());
            statement.setDate(3, new Date(cuenta.getFechaCreacion().getTime()));
            statement.setInt(4, cuenta.getTipoCuenta());
            statement.setString(5, cuenta.getCbu());
            statement.setDouble(6, cuenta.getSaldo());
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
    
	public boolean update(Cuenta cuenta)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasUpdated = false;
		try
		{
			statement = cn.prepareStatement(update);
            statement.setInt(1, cuenta.getIdCliente());
            statement.setDate(2, new Date(cuenta.getFechaCreacion().getTime()));
            statement.setInt(3, cuenta.getTipoCuenta());
            statement.setString(4, cuenta.getCbu());
            statement.setDouble(5, cuenta.getSaldo());
            statement.setInt(7, cuenta.getNroCuenta());
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
    
	public boolean delete(Cuenta cuenta)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasDeleted = false;
		try 
		{
			statement = cn.prepareStatement(delete);
			statement.setInt(1, cuenta.getNroCuenta());
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

	public List<Cuenta> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				cuentas.add(getCuenta(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return cuentas;
	}

	private Cuenta getCuenta(ResultSet resultSet) throws SQLException{
        int nroCuenta = resultSet.getInt("NroCuenta");
        int idCliente = resultSet.getInt("IdCliente");
        Date fechaCreacion = resultSet.getDate("FechaCreacion");
        int tipoCuenta = resultSet.getInt("TipoCuenta");
        String cbu = resultSet.getString("Cbu");
        double saldo = resultSet.getDouble("Saldo");
		
        return new Cuenta(nroCuenta, idCliente, new java.util.Date(fechaCreacion.getTime()), 
        		tipoCuenta, cbu, saldo);
	}
}
