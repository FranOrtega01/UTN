package dao;

public interface UsuarioDao {
    boolean validarUsuario(String user, String pass);
    int loginUsuario(String user, String pass);
    int loginAdmin(String user, String pass);
}