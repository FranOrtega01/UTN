package daoImpl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;

import dao.MovimientoDao;
import entidad.Cliente;
import entidad.Movimiento;
import entidad.Respuesta;
import entidad.TipoMovimiento;

public class MovimientoDaoImpl implements MovimientoDao {
	
	private static final String readIdCuenta = "SELECT " + 
		    "    idMovimiento, " + 
		    "    nroCuenta, " + 
		    "    fecha, " + 
		    "    TiposMovimiento.IdTipoMovimiento as IdTipoMovimiento, " + 
		    "    TiposMovimiento.Descripcion AS TipoMovimientoDescripcion, " + 
		    "    importe,   " +
		    " detalle "+
		    " FROM " + 
		    "    Movimientos " + 
		    " INNER JOIN " + 
		    "    TiposMovimiento " + 
		    "    ON Movimientos.IdTipoMovimiento = TiposMovimiento.IdTipoMovimiento "
		    + " WHERE nroCuenta = ? and Activo = 1 "
		    + " ORDER BY fecha DESC";

	@Override
	public List<Movimiento> readIdCuenta(int id) {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readIdCuenta);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				movimientos.add(getMovimiento(resultSet));
			}
		} 
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
		return movimientos;
	}
	
	private Movimiento getMovimiento(ResultSet rs) throws SQLException{
		
		return new Movimiento(
				rs.getInt("idMovimiento"), 
				rs.getInt("nroCuenta"), 
				new java.util.Date(rs.getDate("fecha").getTime()),
				rs.getString("Detalle"),
				rs.getDouble("importe"),
				new TipoMovimiento(
					rs.getInt("IdTipoMovimiento"),
					rs.getString("TipoMovimientoDescripcion")
				)
			);
	}

	@Override
	public boolean movimiento(Movimiento mov) {
		CallableStatement callableStatement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		boolean hasInserted = false;

	    try {
	        callableStatement = cn.prepareCall("{CALL SpHacerMovimiento(?, ?, ?, ?)}");
	        callableStatement.setInt(1, mov.getNroCuenta());
	        callableStatement.setDouble(2, mov.getImporte());
	        callableStatement.setString(3, mov.getDetalle());
	        callableStatement.setInt(4, mov.getTipoMovimiento().getIdTipo());

	        hasInserted = callableStatement.executeUpdate() > 0;
	        if(hasInserted) {
	        	cn.commit();
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Error al insertar cuenta: " + e.getMessage());
	        try {
	            if (cn != null) {
	                cn.rollback();
	            }
	        } catch (SQLException rollbackEx) {
	            System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
	        }
	    }
		return hasInserted;
	}

	@Override
	public Respuesta transferencia(Movimiento mov, int cuentaReceptor) {
		CallableStatement callableStatement;
		Connection cn = Conexion.getConexion().getSQLConexion();
		int hasInserted = 0;
		
		try {
	        callableStatement = cn.prepareCall("{CALL SpHacerMovimiento(?, ?, ?, ?)}");
	        callableStatement.setInt(1, mov.getNroCuenta());
	        callableStatement.setDouble(2, mov.getImporte() * -1);
	        callableStatement.setString(3, mov.getDetalle());
	        callableStatement.setInt(4, mov.getTipoMovimiento().getIdTipo());

	        hasInserted += callableStatement.executeUpdate() ;
	        
	        callableStatement.setInt(1, cuentaReceptor);
	        callableStatement.setDouble(2, mov.getImporte());
	        callableStatement.setString(3, mov.getDetalle());
	        callableStatement.setInt(4, mov.getTipoMovimiento().getIdTipo());
	        hasInserted += callableStatement.executeUpdate() ;
	        
	        if(hasInserted == 2) {
	        	cn.commit();
	        }
	        
	    } catch (SQLException e) {
	        System.out.println("Error al insertar cuenta: " + e.getMessage());
	        try {
	            if (cn != null) {
	                cn.rollback();
	            }
	        } catch (SQLException rollbackEx) {
	            System.out.println("Error al hacer rollback: " + rollbackEx.getMessage());
	        }
	    }
		
		if(hasInserted == 2) {			
			return new Respuesta(true, "Transferencia realizada con exito.");
		}else {
			return new Respuesta(false, "Ocurrio un error.");
		}
	}	
}
