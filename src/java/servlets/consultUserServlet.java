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
        response.setContentType("text/html");


        
        if (UserBD.userExists(usuario) == false) {
            pw.println("<html><head><title>incorrecto.</title></head><body>");  
            pw.println("<h1>El usuario NO existe en la base de datos.</h1>");            
            pw.println("<h3><a href=\"login.html\">Volver al loggin.</a></h3>");
            pw.println("</body></html>");
            
        } else {
            if(UserBD.selectPass(email).equals(usuario.getPassword())){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("usuario", usuario);
                response.sendRedirect(sesion.getAttribute("urlAnterior").toString());
            }
            else {
            pw.println("<html><head><title>incorrecto2.</title></head><body>");  
            pw.println("<h1>Contraseña incorrecta.</h1>");            
            pw.println("<h3><a href=\"login.html\">Volver al loggin.</a></h3>");
            pw.println("</body></html>");
            }
        }
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


