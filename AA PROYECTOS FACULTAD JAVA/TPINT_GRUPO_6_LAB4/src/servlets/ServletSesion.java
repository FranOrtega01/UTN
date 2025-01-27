package servlets;

import daoImpl.UsuarioDaoImpl;
import negocio.UsuarioNeg;
import negocioImpl.UsuarioNegImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletSesion") 
public class ServletSesion extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // ServletLogout
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName()) || "userID".equals(cookie.getName()) || "role".equals(cookie.getName())) {
                    cookie.setMaxAge(0); 
                    cookie.setPath("/TPINT_GRUPO_6_LAB4");
                    response.addCookie(cookie); 
                }
            }
        }
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("Login.jsp"); 
    }
    //LogIn
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = "Usuario";
        try {
            UsuarioNeg userNeg = new UsuarioNegImpl();
           
            int id = userNeg.loginUsuario(username, password);
            
            if(id == -1) {
            	id = userNeg.loginAdmin(username, password);
            	role = "Admin";
            }
            

            if (id != -1) {
            	Cookie userCookie = new Cookie("username", username);
            	userCookie.setMaxAge(60 * 60 * 24);
            	response.addCookie(userCookie);
            	
            	Cookie userIDCookie = new Cookie("userID", String.valueOf(id));
            	userIDCookie.setMaxAge(60 * 60 * 24);
            	response.addCookie(userIDCookie);
            	
            	Cookie roleCookie = new Cookie("role", role);
            	roleCookie.setMaxAge(60 * 60 * 24);
            	response.addCookie(roleCookie);
            	
            	if(role == "Usuario") {
            		response.sendRedirect("InicioUsuario.jsp"); 
            	}else {            		
            		response.sendRedirect("InicioAdmin.jsp"); 
            	}
            } else {
                request.setAttribute("error", "Usuario o contraseņa incorrectos");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
