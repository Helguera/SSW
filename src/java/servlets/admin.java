/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Producto> productos = ProductoBD.getProductos();
        ArrayList<Curso> cursos = CursoBD.getCursos();
        ArrayList<Usuario> usuarios = UserBD.getUsuarios();
        ArrayList<Archivo> archivos = ArchivosBD.getArchivos();
        request.setAttribute("productos", productos);
        request.setAttribute("cursos", cursos);
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("archivos", archivos);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("zona");
        ArrayList<Producto> productos = ProductoBD.getProductos();
        ArrayList<Curso> cursos = CursoBD.getCursos();
        ArrayList<Usuario> usuarios = UserBD.getUsuarios();
        ArrayList<Archivo> archivos = ArchivosBD.getArchivos();
        request.setAttribute("productos", productos);
        request.setAttribute("cursos", cursos);
        request.setAttribute("usuarios", usuarios);
        request.setAttribute("archivos", archivos);
        if (tipo == null) {
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            request.setAttribute("tipo", tipo);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        }
    }
    
    

}
