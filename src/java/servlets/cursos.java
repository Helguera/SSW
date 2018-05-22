/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import roles.*;
import roles.ProductoBD;
/**
 *
 * @author josealbertodelval
 */
@WebServlet(urlPatterns = {"/cursos"})

public class cursos extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Curso> cursos = CursoBD.getCursos();
        request.setAttribute("cursos", cursos);       
        request.getRequestDispatcher("cursos.jsp").forward(request, response);
       
       

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        if(sesion.getAttribute("usuario")!=null){
            if(addCursoBD.userExists((Usuario) sesion.getAttribute("usuario")) == true) {
            //pw.println("El usuario ya existía en la base de datos");
            pw.println("<html><head><title>El usuario ya estaba apuntado.</title></head><body>");   
            pw.println("<h1>El usuario ya estaba apuntado.</h1>");            

            pw.println("<h3><a href=\"index.html\">Volver a la página principal.</a></h3>");
            pw.println("</body></html>");

            } else {        
            addCursoBD.insert((Usuario) sesion.getAttribute("usuario"));
            pw.println("<html><head><title>Cursos</title></head><body>"); 
            pw.println("<h1>Se ha apuntado correctamente al curso</h1>"); 
            pw.println("<h3><a href=\"index.html\">Volver a la página principal.</a></h3>");
            pw.println("</body></html>");	
            //response.sendRedirect("registro.html");
        }

    }
    }
    
}
