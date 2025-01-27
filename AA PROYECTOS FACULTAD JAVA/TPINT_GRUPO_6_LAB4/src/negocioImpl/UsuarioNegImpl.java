package negocioImpl;

import daoImpl.UsuarioDaoImpl;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg {
    private UsuarioDaoImpl usuarioDao = new UsuarioDaoImpl();

    public UsuarioNegImpl() {

    }

    @Override
    public boolean validarUsuario(String username, String password) {
        return usuarioDao.validarUsuario(username, password);
    }
    
    @Override
    public int loginUsuario(String user, String pass) {
        return usuarioDao.loginUsuario(user, pass);
    }
    public int loginAdmin(String user, String pass) {
        return usuarioDao.loginAdmin(user, pass);
    }
}