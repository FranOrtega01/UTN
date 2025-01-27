//package daoImpl;
//
//import java.sql.Date;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import dao.CuentaDao;
//import entidad.Cuenta;
//import entidad.Respuesta;
//import entidad.TipoCuenta;
//
//public class CuentaDaoImpl implements CuentaDao {
//	private static final String insert = "INSERT INTO Cuentas (NroCuenta, IdCliente, FechaCreacion, TipoCuenta, Cbu) "
//			+ "VALUES (?, ?, ?, ?, ?)";
//	private static final String update = "UPDATE Cuentas SET IdCliente = ?, TipoCuenta = ?, Cbu = ?, "
//			+ "Saldo = ? WHERE NroCuenta = ?";
//    private static final String delete = "UPDATE Cuentas set Activo = 0 WHERE NroCuenta = ?";
//	private static final String readAll = "SELECT " + 
//		    "    NroCuenta, " + 
//		    "    IdCliente, " + 
//		    "    FechaCreacion, " + 
//		    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
//		    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
//		    "    Cbu, " + 
//		    "    Saldo, " + 
//		    "    Activo " + 
//		    "FROM " + 
//		    "    Cuentas " + 
//		    "INNER JOIN " + 
//		    "    TiposCuenta " + 
//		    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta WHERE Activo = 1";
//	private static final String readNro = "SELECT " + 
//		    "    NroCuenta, " + 
//		    "    IdCliente, " + 
//		    "    FechaCreacion, " + 
//		    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
//		    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
//		    "    Cbu, " + 
//		    "    Saldo, " + 
//		    "    Activo " + 
//		    "FROM " + 
//		    "    Cuentas " + 
//		    "INNER JOIN " + 
//		    "    TiposCuenta " + 
//		    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta WHERE Activo = 1 and NroCuenta = ?";
//	
//	private static final String readIdCliente = "SELECT " + 
//		    "    NroCuenta, " + 
//		    "    IdCliente, " + 
//		    "    FechaCreacion, " + 
//		    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
//		    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
//		    "    Cbu, " + 
//		    "    Saldo, " + 
//		    "    Activo " + 
//		    "FROM " + 
//		    "    Cuentas " + 
//		    "INNER JOIN " + 
//		    "    TiposCuenta " + 
//		    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta "
//		    + "WHERE Activo = 1 and IdCliente = ?"; 
//	
//	 private static final String GetNroCuentaByCBU = "SELECT nroCuenta FROM Cuentas WHERE cbu = ?";
//	 
//	 private static final String GetCuentaByID = "SELECT " +
//			"    NroCuenta, " + 
//		    "    IdCliente, " + 
//		    "    FechaCreacion, " + 
//		    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
//		    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
//		    "    Cbu, " + 
//		    "    Saldo, " + 
//		    "    Activo " + 
//		    "FROM " + 
//		    "    Cuentas " + 
//		    "INNER JOIN " + 
//		    "    TiposCuenta " + 
//		    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta " +
//		    "WHERE Activo = 1 and NroCuenta = ?"; 
//			 
//	 
//	public Respuesta insert(Cuenta cuenta) {
//	    CallableStatement callableStatement = null;
//	    Connection cn = Conexion.getConexion().getSQLConexion();
//	    Respuesta res = new Respuesta();
//
//	    try {
//	        callableStatement = cn.prepareCall("{call SpAgregarCuenta(?, ?, ?)}");
//	        callableStatement.setInt(1, cuenta.getIdCliente());
//	        callableStatement.setInt(2, cuenta.getTipoCuenta().getIdTipo());
//	        callableStatement.setString(3, cuenta.getCbu());
//
//	        if (callableStatement.executeUpdate() > 0) {
//	            cn.commit();
//	            res.setEstado(true);
//	            res.setMensaje("Cuenta creada con exito");
//	        }
//	    } catch (SQLException e) {
//	        System.out.println("Error al insertar cuenta: " + e.getMessage());
//	        try {
//	            if (cn != null) {
//	                cn.rollback();
//	                res.setEstado(false);
//		            res.setMensaje(e.getMessage());
//	            }
//	        } catch (SQLException rollbackEx) {
//	            System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
//	            res.setEstado(false);
//	            res.setMensaje(e.getMessage());
//	        }
//	    }
//
//	    return res;
//	}
//    
//	public boolean update(Cuenta cuenta)
//	{
//		PreparedStatement statement;
//		Connection cn = Conexion.getConexion().getSQLConexion();
//		boolean hasUpdated = false;
//		try
//		{
//			statement = cn.prepareStatement(update);
//            statement.setInt(1, cuenta.getIdCliente());
//            statement.setInt(2, cuenta.getTipoCuenta().getIdTipo());
//            statement.setString(3, cuenta.getCbu());
//            statement.setDouble(4, cuenta.getSaldo());
//            statement.setInt(5, cuenta.getNroCuenta());
//			if(statement.executeUpdate() > 0)
//			{
//				cn.commit();
//				hasUpdated = true;
//			}
//		} 
//		catch (SQLException e) 
//		{
//			System.out.println(e.getMessage());
//			try {
//				cn.rollback();
//			} catch (SQLException e1) {
//				System.out.println(e1.getMessage());
//			}
//		}
//		return hasUpdated;
//	}
//    
//	public boolean delete(Cuenta cuenta)
//	{
//		PreparedStatement statement;
//		Connection cn = Conexion.getConexion().getSQLConexion();
//		boolean hasDeleted = false;
//		try 
//		{
//			statement = cn.prepareStatement(delete);
//			statement.setInt(1, cuenta.getNroCuenta());
//			if(statement.executeUpdate() > 0)
//			{
//				cn.commit();
//				hasDeleted = true;
//			}
//		} 
//		catch (SQLException e) 
//		{
//			System.out.println(e.getMessage());
//		}
//		return hasDeleted;
//	}
//
//	public List<Cuenta> readAll() {
//		PreparedStatement statement;
//		ResultSet resultSet; 
//		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
//		Conexion conexion = Conexion.getConexion();
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(readAll);
//			resultSet = statement.executeQuery();
//			while(resultSet.next()){
//				cuentas.add(getCuenta(resultSet));
//			}
//		} 
//		catch (SQLException e){
//			System.out.println(e.getMessage());
//		}
//		return cuentas;
//	}
//
//	private Cuenta getCuenta(ResultSet resultSet) throws SQLException{
//        int nroCuenta = resultSet.getInt("NroCuenta");
//        int idCliente = resultSet.getInt("IdCliente");
//        Date fechaCreacion = resultSet.getDate("FechaCreacion");
//        int idTipoCuenta = resultSet.getInt("IdTipoCuenta");
//        String descTipo = resultSet.getString("TipoCuentaDescripcion");
//        String cbu = resultSet.getString("Cbu");
//        double saldo = resultSet.getDouble("Saldo");
//		
//        return new Cuenta(nroCuenta, idCliente, new java.util.Date(fechaCreacion.getTime()), 
//        		new TipoCuenta(idTipoCuenta,descTipo), cbu, saldo);
//	}
//
//	@Override
//	public List<Cuenta> readNro(int nro) {
//		PreparedStatement statement;
//		ResultSet resultSet; 
//		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
//		Conexion conexion = Conexion.getConexion();
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(readNro);
//			statement.setInt(1, nro);
//			resultSet = statement.executeQuery();
//			while(resultSet.next()){
//				cuentas.add(getCuenta(resultSet));
//			}
//		} 
//		catch (SQLException e){
//			System.out.println(e.getMessage());
//		}
//		return cuentas;
//	}
//	
//	@Override
//	public List<Cuenta> readIdCliente(int nro) {
//		PreparedStatement statement;
//		ResultSet resultSet; 
//		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
//		Conexion conexion = Conexion.getConexion();
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(readIdCliente);
//			statement.setInt(1, nro);
//			resultSet = statement.executeQuery();
//			while(resultSet.next()){
//				cuentas.add(getCuenta(resultSet));
//			}
//		} 
//		catch (SQLException e){
//			System.out.println(e.getMessage());
//		}
//		return cuentas;
//	}
//
//	@Override
//	public int getCuentaByCBU(String cbu) {
//		PreparedStatement statement;
//		ResultSet resultSet; 
//		int nroCuenta = -1;
//		Conexion cn = Conexion.getConexion();
//		 try {
//	            statement = cn.getSQLConexion().prepareStatement(GetNroCuentaByCBU);
//	            statement.setString(1, cbu);
//	            resultSet = statement.executeQuery();
//	            if (resultSet.next()) {
//	                nroCuenta = resultSet.getInt("nroCuenta");
//	            }
//	        } catch (SQLException e) {
//	            System.out.println("Error al obtener el n�mero de cuenta: " + e.getMessage());
//	        }
//		 return nroCuenta;
//	}
//	
//	public Cuenta getCuentaByID(int id) {
//		PreparedStatement statement;
//		ResultSet resultSet; 
//		Cuenta cuenta = new Cuenta();
//		Conexion conexion = Conexion.getConexion();
//		try {
//			statement = conexion.getSQLConexion().prepareStatement(GetCuentaByID);
//			statement.setInt(1, id);
//			resultSet = statement.executeQuery();
//			while(resultSet.next()){
//				cuenta = getCuenta(resultSet);
//			}
//		} 
//		catch (SQLException e){
//			System.out.println(e.getMessage());
//		}
//		return cuenta;
//	}
//
//}

package daoImpl;

import java.sql.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CuentaDao;
import entidad.Cuenta;
import entidad.Respuesta;
import entidad.TipoCuenta;

public class CuentaDaoImpl implements CuentaDao {
	private static final String insert = "INSERT INTO Cuentas (NroCuenta, IdCliente, FechaCreacion, TipoCuenta, Cbu) "
			+ "VALUES (?, ?, ?, ?, ?)";
	private static final String update = "UPDATE Cuentas SET IdCliente = ?, TipoCuenta = ?, Cbu = ?, "
			+ "Saldo = ? WHERE NroCuenta = ?";
    private static final String delete = "UPDATE Cuentas set Activo = 0 WHERE NroCuenta = ?";
	private static final String readAll = "SELECT " + 
		    "    NroCuenta, " + 
		    "    IdCliente, " + 
		    "    FechaCreacion, " + 
		    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
		    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
		    "    Cbu, " + 
		    "    Saldo, " + 
		    "    Activo " + 
		    "FROM " + 
		    "    Cuentas " + 
		    "INNER JOIN " + 
		    "    TiposCuenta " + 
		    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta WHERE Activo = 1";
	private static final String readNro = "SELECT " + 
		    "    NroCuenta, " + 
		    "    IdCliente, " + 
		    "    FechaCreacion, " + 
		    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
		    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
		    "    Cbu, " + 
		    "    Saldo, " + 
		    "    Activo " + 
		    "FROM " + 
		    "    Cuentas " + 
		    "INNER JOIN " + 
		    "    TiposCuenta " + 
		    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta WHERE Activo = 1 and NroCuenta = ?";
	private static final String readTipoCuenta = "SELECT " + 
 		    "    NroCuenta, " + 
		    "    IdCliente, " + 
		    "    FechaCreacion, " + 
		    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
		    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
		    "    Cbu, " + 
		    "    Saldo, " + 
		    "    Activo " + 
		    "FROM " + 
		    "    Cuentas " + 
		    "INNER JOIN " + 
		    "    TiposCuenta " + 
		    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta WHERE Activo = 1 and IdTipoCuenta = ?";
	private static final String readCBU = "SELECT " + 
		        "    NroCuenta, " + 
		        "    IdCliente, " + 
		        "    FechaCreacion, " + 
		        "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
		        "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
		        "    Cbu, " + 
		        "    Saldo, " + 
		        "    Activo " + 
		        "FROM " + 
		        "    Cuentas " + 
		        "INNER JOIN " + 
		        "    TiposCuenta " + 
		        "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta " + 
		        "WHERE Activo = 1 AND Cbu LIKE ?";
    private static final String readIdCliente = "SELECT " + 
		    "    NroCuenta, " + 
		    "    IdCliente, " + 
		    "    FechaCreacion, " + 
		    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
		    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
		    "    Cbu, " + 
		    "    Saldo, " + 
		    "    Activo " + 
		    "FROM " + 
		    "    Cuentas " + 
		    "INNER JOIN " + 
		    "    TiposCuenta " + 
		    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta "
		    + "WHERE Activo = 1 and IdCliente = ?"; 
    private static final String GetNroCuentaByCBU = "SELECT nroCuenta FROM Cuentas WHERE cbu = ?";
	private static final String GetCuentaByID = "SELECT " +
	"    NroCuenta, " + 
    "    IdCliente, " + 
    "    FechaCreacion, " + 
    "    TiposCuenta.IdTipoCuenta as IdTipoCuenta, " + 
    "    TiposCuenta.Descripcion AS TipoCuentaDescripcion, " + 
    "    Cbu, " + 
    "    Saldo, " + 
    "    Activo " + 
    "FROM " + 
    "    Cuentas " + 
    "INNER JOIN " + 
    "    TiposCuenta " + 
    "    ON Cuentas.TipoCuenta = TiposCuenta.IdTipoCuenta " +
    "WHERE Activo = 1 and NroCuenta = ?"; 
	 
		public Respuesta insert(Cuenta cuenta) {
	    CallableStatement callableStatement = null;
	    Connection cn = Conexion.getConexion().getSQLConexion();
	    Respuesta res = new Respuesta();

	    try {
	        callableStatement = cn.prepareCall("{call SpAgregarCuenta(?, ?, ?)}");
	        callableStatement.setInt(1, cuenta.getIdCliente());
	        callableStatement.setInt(2, cuenta.getTipoCuenta().getIdTipo());
	        callableStatement.setString(3, cuenta.getCbu());

	        if (callableStatement.executeUpdate() > 0) {
	            cn.commit();
	            res.setEstado(true);
	            res.setMensaje("Cuenta creada con exito");
	        }
	    } catch (SQLException e) {
	        System.out.println("Error al insertar cuenta: " + e.getMessage());
	        try {
	            if (cn != null) {
	                cn.rollback();
	                res.setEstado(false);
		            res.setMensaje(e.getMessage());
	            }
	        } catch (SQLException rollbackEx) {
	            System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
	            res.setEstado(false);
	            res.setMensaje(e.getMessage());
	        }
	    }

	    return res;
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
            statement.setInt(2, cuenta.getTipoCuenta().getIdTipo());
            statement.setString(3, cuenta.getCbu());
            statement.setDouble(4, cuenta.getSaldo());
            statement.setInt(5, cuenta.getNroCuenta());
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
        int idTipoCuenta = resultSet.getInt("IdTipoCuenta");
        String descTipo = resultSet.getString("TipoCuentaDescripcion");
        String cbu = resultSet.getString("Cbu");
        double saldo = resultSet.getDouble("Saldo");
		
        return new Cuenta(nroCuenta, idCliente, new java.util.Date(fechaCreacion.getTime()), 
        		new TipoCuenta(idTipoCuenta,descTipo), cbu, saldo);
	}

	@Override
	public List<Cuenta> readNro(int nro) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readNro);
			statement.setInt(1, nro);
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
	
	@Override
	public List<Cuenta> readIdCliente(int nro) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readIdCliente);
			statement.setInt(1, nro);
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

	@Override
	public int getCuentaByCBU(String cbu) {
		PreparedStatement statement;
		ResultSet resultSet; 
		int nroCuenta = -1;
		Conexion cn = Conexion.getConexion();
		 try {
	            statement = cn.getSQLConexion().prepareStatement(GetNroCuentaByCBU);
	            statement.setString(1, cbu);
	            resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                nroCuenta = resultSet.getInt("nroCuenta");
	            }
	        } catch (SQLException e) {
	            System.out.println("Error al obtener el n�mero de cuenta: " + e.getMessage());
	        }
		 return nroCuenta;
	}

	@Override
	public List<Cuenta> readCBU(String cbu) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readCBU);
			statement.setString(1, "%" + cbu + "%");
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

	@Override
	public List<Cuenta> readTipoCuenta(int tipoCuenta) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readTipoCuenta);
			statement.setInt(1, tipoCuenta);
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


	@Override
	public Cuenta getCuentaByID(int id) {
		PreparedStatement statement;
		ResultSet resultSet; 
		Cuenta cuenta = new Cuenta();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(GetCuentaByID);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				cuenta = getCuenta(resultSet);
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return cuenta;
	}
}
