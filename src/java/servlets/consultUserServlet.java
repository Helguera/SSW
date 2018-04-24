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
import javax.servlet.http.*;
import roles.UserBD;
import roles.Usuario;
import java.io.*;

/**
 *
 * @author josealbertodelval
 */

@WebServlet(urlPatterns = {"/consultUserServlet"})
public class consultUserServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = new Usuario();
        String email= request.getParameter("correo");
        usuario.setEmail(email);
        String pass=request.getParameter("pass");
        usuario.setPassword(pass);
        
        PrintWriter pw = response.getWriter();
        pw.println(UserBD.selectPass(email)+" de la base");


        
        if (UserBD.userExists(usuario) == false) {
            pw.println("El usuario NO está en la base de datos->Error en loggin");
            
        } else {
            pw.println("El usuario SI está en la base de datos->Comprobamos contraseña");
            //Usuario user=UserBD.selectUsuario(usuario.getEmail());
            if(UserBD.selectPass(email).equals(usuario.getPassword())){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", usuario);
                pw.println("Login correcto");
            }
            else pw.println("Login incorrecto");
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


