package daoImpl;

import dao.UsuarioDao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class UsuarioDaoImpl implements UsuarioDao {
    public UsuarioDaoImpl() {
    }

    @Override
    public boolean validarUsuario(String username, String password) {
        boolean esValido = false;
        try {
        	Connection cn = Conexion.getConexion().getSQLConexion();
            String sql = "{CALL ValidarUsuario(?, ?, ?)}"; 
            CallableStatement stmt = cn.prepareCall(sql);
            stmt.setString(1, username); 
            stmt.setString(2, password); 
            stmt.registerOutParameter(3, java.sql.Types.BOOLEAN); 
            stmt.execute();

            esValido = stmt.getBoolean(3);

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return esValido;
    }
    
    @Override
    public int loginUsuario(String username, String password) {
        int userId = -1; 
        try {
        	Connection cn = Conexion.getConexion().getSQLConexion();
            String sql = "SELECT idCliente as ID FROM clientes WHERE Usuario = ? AND Clave = ?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {
                userId = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId; 
    }
    
    @Override
    public int loginAdmin(String username, String password) {
        int userId = -1; 
        try {
        	Connection cn = Conexion.getConexion().getSQLConexion();
            String sql = "SELECT idAdmin as ID FROM administradores WHERE Usuario = ? AND Clave = ?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {
                userId = rs.getInt("id");
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId; 
    }
}

