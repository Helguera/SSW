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
import javax.servlet.http.HttpSession;
import roles.*;
import roles.ProductoBD;

/**
 *
 * @author josealbertodelval
 */
@WebServlet(urlPatterns = {"/addUserServlet"})
public class tiendaDinamicaServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    protected void setProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto[] productos = ProductoDB.getProductos();
        request.setAttribute("productos", productos);
    }
    
    
    
    
}
