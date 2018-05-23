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
import javax.servlet.http.HttpSession;
import roles.*;

/**
 *
 * @author javier
 */
@WebServlet(urlPatterns = {"/addUserServlet"})
public class addUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();
        String nombre = request.getParameter("nombre");
        usuario.setNombre(nombre);
        String apellidos=request.getParameter("apellidos");
        usuario.setApellidos(apellidos);
        String email= request.getParameter("email");
        usuario.setEmail(email);
        String pass=request.getParameter("password");
        usuario.setPassword(pass);
        String calle=request.getParameter("calle");
        usuario.setCalle(calle);
        String resto=request.getParameter("resto");
        usuario.setResto(resto);
        String poblacion =request.getParameter("poblacion");
        usuario.setPoblacion(poblacion);
        String provincia = request.getParameter("provincia");
        usuario.setProvicia(provincia);
        String cp = request.getParameter("cp");
        usuario.setCp(cp);
        
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        
        
        if (usuario.compruebaPass(request.getParameter("password2"))==false) {
            //pw.println("Las contraseñas no coinciden");
            //pw.println("<h3><a href="registro.html">Iniciar sesión</a></h3>");
            response.sendRedirect("registro");
            /*pw.println("<html><head><title>Las contraseñas no coinciden.</title></head><body>");  
            pw.println("<h1><title>Las contraseñas no coinciden.</h1>");            
            pw.println("<h3><a href=\"registro.html\">Volver al formulario de registro.</a></h3>");
            pw.println("</body></html>");*/

            
        }
            
        else if (usuario.compruebaCampos()==false) {
            /*pw.println("<html><head><title>Todos los campos son requeridos</title></head><body>"); 
            pw.println("<h1>Todos los campos son requeridos</h1>"); 
            pw.println("<h3><a href=\"registro.html\">Volver al formulario de registro.</a></h3>");
            pw.println("</body></html>");*/	
            response.sendRedirect("registro");

        }
            
        else if(UserBD.userExists(usuario) == true) {
            //pw.println("El usuario ya existía en la base de datos");
            
            pw.println("<html><head><title>El usuario ya existía en la base de datos.</title></head><body>");   
            pw.println("<h1>El usuario ya existía en la base de datos.</h1>");            

            pw.println("<h3><a href=\"registro\">Volver al formulario de registro.</a></h3>");
            pw.println("</body></html>");

        } else {        
            UserBD.insert(usuario);
            /*pw.println("Ha sido registrado correctamente");*/
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuario", usuario);
            response.sendRedirect("index");
        }
        
        
        
        
        

        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}