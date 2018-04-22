 package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import roles.*;


/**
 *
 * @author javier
 */
@WebServlet(urlPatterns = {"/recuperaPassServlet"})
public class recuperaPassServlet extends HttpServlet {

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
        
        
        PrintWriter pw = response.getWriter();
        pw.println(usuario.getEmail());
        
        if (UserBD.userExists(usuario) == false) {
            pw.println("El usuario NO está en la base de datos");

            
        } else {
            pw.println("El usuario SI está en la base de datos->Te hemos enviado un correo con tu contraseña");
            String pass=UserBD.selectPass(email);
            //Clase de correos, metodo que genere el mensaje, pasandole la contraseña
        }
        
        
        
        

        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
