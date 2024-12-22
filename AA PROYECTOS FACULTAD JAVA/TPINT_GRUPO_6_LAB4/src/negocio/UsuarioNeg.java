package negocio;

public interface UsuarioNeg {
    boolean validarUsuario(String username, String password);
    int loginUsuario(String user, String pass);
    int loginAdmin(String user, String pass);
}