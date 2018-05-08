/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import roles.Admin;
import roles.AdminBD;

/**
 *
 * @author enriq_000
 */
@WebServlet(name = "consultAdminServlet", urlPatterns = {"/consultAdminServlet"})
public class consultAdminServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Admin admin = new Admin();
        String email= request.getParameter("correo");
        admin.setEmail(email);
        String pass=request.getParameter("pass");
        admin.setPassword(pass);
        
        PrintWriter pw = response.getWriter();
        pw.println(AdminBD.selectPass(email)+" de la base");


        
        if (AdminBD.adminExists(admin) == false) {
            pw.println("No se ha encontrado el administrador en la BD->Error en loggin");
            
        } else {
             pw.println("El administrador SI está en la base de datos->Comprobamos contraseña");
            //Usuario user=UserBD.selectUsuario(usuario.getEmail());
            if(AdminBD.selectPass(email).equals(admin.getPassword())){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("administrador", admin);
                pw.println("Login correcto");
            }
            else pw.println("Login incorrecto");
        }
    }
}