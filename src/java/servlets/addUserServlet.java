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

/**
 *
 * @author javier
 */
@WebServlet(urlPatterns = {"/addUserServlet"})
public class addUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print("<html>");
            pw.print("<body>");
                pw.print("Prueba de servlet");
                pw.print(request.getParameter("nombre"));
            pw.print("</body>");
        pw.print("</html>");*/
    
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        
        String query = "insert into usuario values ('Fernando','Zamora','12345678A','hola@hola.com','calle',5,'Valladolid', 47001,'1234')";
        try{
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
        }catch (Exception e){
            
        }
        
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.print("<html>");
            pw.print("<body>");
                pw.print("Prueba de servlet");
                pw.print(request.getParameter("nombre"));
            pw.print("</body>");
        pw.print("</html>");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
