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
import roles.Curso;
import roles.CursoBD;

/**
 *
 * @author enriq_000
 */
@WebServlet(name = "consultCursoServlet", urlPatterns = {"/consultCursoServlet"})
public class consultCursoServlet extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Curso curso = new Curso();
        int codigo = request.getIntHeader("code");
        curso.setCode(codigo);
        String nombre = request.getParameter("nombre");
        curso.setNombre(nombre);
        
        PrintWriter pw = response.getWriter();
        pw.println(curso.getNombre());
        
        if (CursoBD.cursoExists(curso) == false) {
            pw.println("EL curso no existe.");
            
        } else {
            pw.println("El curso si esta disponible.");
            System.out.println("El curso si esta.");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
