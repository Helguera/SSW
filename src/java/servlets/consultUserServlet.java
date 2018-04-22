/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import roles.UserBD;
import roles.Usuario;

/**
 *
 * @author josealbertodelval
 */

@WebServlet(urlPatterns = {"/consultUserServlet"})
public class consultUserServlet extends HttpServlet{
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = new Usuario();
        String email= request.getParameter("email");
        usuario.setEmail(email);
        String pass=request.getParameter("password");
        usuario.setPassword(pass);
        
        PrintWriter pw = response.getWriter();
        pw.println(usuario.getEmail());
        
        if (UserBD.userExists(usuario) == false) {
            pw.println("El usuario NO está en la base de datos->Error en loggin");
            
        } else {
            pw.println("El usuario SI está en la base de datos->Comprobamos contraseña");
            Usuario user=UserBD.selectUsuario(usuario.getEmail());
            if(user.getPassword()==usuario.getPassword()) pw.println("Login correcto");
            else pw.println("Login incorrecto");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


