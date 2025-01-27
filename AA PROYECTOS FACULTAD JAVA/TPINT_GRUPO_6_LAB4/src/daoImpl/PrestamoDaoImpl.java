package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import dao.PrestamoDao;
import entidad.Cuota;
import entidad.Prestamo;
import entidad.Respuesta;

public class PrestamoDaoImpl implements PrestamoDao{
	private static final String insert = "INSERT INTO Prestamos "
			+ "(IdCuenta, Fecha, ImportePedido, ImporteAPagar, PlazoPago, MontoXMes, Cuotas) VALUES "
		    + "(?, ?, ?, ?, ?, ?, ?)";
	private static final String update = "UPDATE Prestamos SET "
		    + "IdCuenta = ?, Fecha = ?, ImportePedido = ?, ImporteAPagar = ?, PlazoPago = ?, "
		    + "MontoXMes = ?, Cuotas = ? "
		    + "WHERE IdPrestamo = ?";
    private static final String delete = "UPDATE Prestamos set Activo = 0 WHERE IdPrestamo = ?";
	private static final String readAll =  "SELECT " +
			"p.IdPrestamo, " +
			"p.Fecha, " +
		    "p.IdCuenta, " +
		    "p.ImportePedido, " +
		    "p.ImporteAPagar, " +
		    "p.Cuotas, " +
		    "p.MontoXMes, " +
		    "p.Estado, " +
		    "COALESCE(SUM(CASE WHEN c.Pagado = 1 THEN 1 ELSE 0 END), 0) AS CuotasPagadas, " +
		    "COALESCE(MIN(CASE WHEN c.Pagado = 0 THEN c.NroCuota END), 0) AS ProximaCuota " +
		    "FROM Prestamos p " +
		    "LEFT JOIN Cuotas c ON p.IdPrestamo = c.IdPrestamo " +
		    "GROUP BY p.IdPrestamo, p.Fecha, p.IdCuenta, p.ImportePedido, p.ImporteAPagar, p.Estado " +
		    "ORDER BY p.Fecha DESC";
	
	private static final String readByID =  "SELECT " +
			"p.IdPrestamo, " +
			"p.Fecha, " +
		    "p.IdCuenta, " +
		    "p.ImportePedido, " +
		    "p.ImporteAPagar, " +
		    "p.Cuotas, " +
		    "p.MontoXMes, " +
		    "p.Estado, " +
		    "COALESCE(SUM(CASE WHEN c.Pagado = 1 THEN 1 ELSE 0 END), 0) AS CuotasPagadas, " +
		    "COALESCE(MIN(CASE WHEN c.Pagado = 0 THEN c.NroCuota END), 0) AS ProximaCuota " +
		    "FROM Prestamos p " +
		    "LEFT JOIN Cuotas c ON p.IdPrestamo = c.IdPrestamo  " +
		    "WHERE p.IdCuenta = ? " +
		    "GROUP BY p.IdPrestamo, p.Fecha, p.IdCuenta, p.ImportePedido, p.ImporteAPagar, p.Estado " +
		    "ORDER BY p.Fecha DESC";

	private static final String readByPrestamoID =  "SELECT " +
			"p.IdPrestamo, " +
			"p.Fecha, " +
		    "p.IdCuenta, " +
		    "p.ImportePedido, " +
		    "p.ImporteAPagar, " +
		    "p.Cuotas, " +
		    "p.MontoXMes, " +
		    "p.Estado, " +
		    "COALESCE(SUM(CASE WHEN c.Pagado = 1 THEN 1 ELSE 0 END), 0) AS CuotasPagadas, " +
		    "COALESCE(MIN(CASE WHEN c.Pagado = 0 THEN c.NroCuota END), 0) AS ProximaCuota " +
		    "FROM Prestamos p " +
		    "LEFT JOIN Cuotas c ON p.IdPrestamo = c.IdPrestamo  " +
		    "WHERE p.IdPrestamo = ? " +
		    "GROUP BY p.IdPrestamo, p.Fecha, p.IdCuenta, p.ImportePedido, p.ImporteAPagar, p.Estado " +
		    "ORDER BY p.Fecha DESC";

	
	private static final String readByUser =  "SELECT " +
			"p.IdPrestamo, " +
		    "p.Fecha, " +
		    "p.IdCuenta, " +
		    "p.ImportePedido, " +
		    "p.ImporteAPagar, " +
		    "p.Estado, " +
		    "p.MontoXMes, " +
		    "p.Cuotas, " +
		    "COALESCE(SUM(CASE WHEN c.Pagado = 1 THEN 1 ELSE 0 END), 0) AS CuotasPagadas, " +
		    "COALESCE(MIN(CASE WHEN c.Pagado = 0 THEN c.NroCuota END), 0) AS ProximaCuota " +
		    "FROM Prestamos p " +
		    "LEFT JOIN Cuotas c " +
		    "ON p.IdPrestamo = c.IdPrestamo " +
		    "INNER JOIN Cuentas cu " +
		    "ON p.IdCuenta = cu.NroCuenta " +
		    "INNER JOIN Clientes cl " +
		    "ON cu.IdCliente = cl.IdCliente " +
		    "WHERE cl.IdCliente = ? " +
		    "GROUP BY p.IdPrestamo, p.Fecha, cu.NroCuenta, p.ImportePedido, p.ImporteAPagar, p.Estado " +
		    "ORDER BY p.Fecha DESC";
	private static final String readCuentaPorEstado = "SELECT COUNT(*) FROM prestamos WHERE IdCuenta = ? AND "
			+ "(estado = 'pendiente' OR estado = 'aprobado')";
	
	
	public boolean insert(Prestamo prestamo)
	{
		CallableStatement cs = null;
	    Connection cn = Conexion.getConexion().getSQLConexion();
	    boolean hasInserted = false;

		try
		{
			cs = cn.prepareCall("{call SpAgregarPrestamo(?, ?, ?, ?, ?)}");
			cs.setInt(1, prestamo.getIdCuenta());
			cs.setDouble(2, prestamo.getImportePedido());
			cs.setDouble(3, prestamo.getImporteAPagar());
			cs.setDouble(4, prestamo.getPlazoPago());
			cs.setDouble(5, prestamo.getCuotas());
			if(cs.executeUpdate() > 0)
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
    
	public boolean update(Prestamo prestamo)
	{
		CallableStatement cs = null;
	    Connection cn = Conexion.getConexion().getSQLConexion();
	    boolean hasUpdated = false;
		try
		{
			cs = cn.prepareCall("{call SpActualizarPrestamo(?, ?)}");
			cs.setInt(1, prestamo.getIdPrestamo());
			cs.setString(2, prestamo.getEstado());
            
			if(cs.executeUpdate() > 0)
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
    
	public boolean delete(Prestamo prestamo)
	{
		PreparedStatement statement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasDeleted = false;
		try 
		{
			statement = cn.prepareStatement(delete);
			statement.setInt(1, prestamo.getIdCuenta());
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

	public List<Prestamo> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readAll);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				prestamos.add(getPrestamo(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return prestamos;
	}
	
	public List<Prestamo> readByIDCuenta(int id) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readByID);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				prestamos.add(getPrestamo(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return prestamos;
	}
	
	public Prestamo readByPrestamoID(int id) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readByPrestamoID);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				prestamos.add(getPrestamo(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return prestamos.get(0);
	}
	
	public List<Prestamo> readByIDUser(int id) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readByUser);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				prestamos.add(getPrestamo(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return prestamos;
	}


	private Prestamo getPrestamo(ResultSet resultSet) throws SQLException{
		int idPrestamo = resultSet.getInt("IdPrestamo");
	    int idCuenta = resultSet.getInt("IdCuenta");
        Date fecha = resultSet.getDate("Fecha");
	    double importePedido = resultSet.getDouble("ImportePedido");
	    double importeAPagar = resultSet.getDouble("ImporteAPagar");
	    //int plazoPago = resultSet.getInt("PlazoPago");
	    double montoMensual = resultSet.getDouble("MontoXMes");
	    int cuotas = resultSet.getInt("Cuotas");
	    int cuotasPagas = resultSet.getInt("CuotasPagadas");
	    String estado = resultSet.getString("Estado");
		
	    return new Prestamo(idPrestamo, idCuenta, fecha, importePedido, importeAPagar, cuotas, montoMensual, cuotas, cuotasPagas, estado);
	}

	@Override
	public Respuesta pagarCuota(Cuota c) {
		CallableStatement cs = null;
	    Connection cn = Conexion.getConexion().getSQLConexion();
	    Respuesta hasUpdated = new Respuesta();
		try
		{
			cs = cn.prepareCall("{call SpPagarCuota(?, ?)}");
			cs.setInt(1, c.getIdPrestamo());
			cs.setInt(2, c.getNroCuota());
            
			if(cs.executeUpdate() > 0)
			{
				cn.commit();
				hasUpdated.setEstado(true);
				hasUpdated.setMensaje("Cuota Pagada con exito");
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
				hasUpdated.setEstado(false);
				hasUpdated.setMensaje(e.getMessage());
				System.out.println(e1.getMessage());
			}
		}
		return hasUpdated;
	}
	
	@Override
	public boolean existePrestamoActivo(int cuentaId) {
		PreparedStatement statement;
		ResultSet resultSet; 
	    try 
	    {
	    	Connection cn = Conexion.getConexion().getSQLConexion();
	        statement = cn.prepareStatement(readCuentaPorEstado);
	        statement.setInt(1, cuentaId);
	        resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            return resultSet.getInt(1) > 0;
	        }
	    }
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	    return false;
	}
}

