 package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import roles.*;
 
 import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


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
            String pass = UserBD.selectPass(email);
            String asunto = "Recuperación contraseña";
            String mensaje = "Su contraseña es : " + pass;
            //Mail.sendEmail(asunto,mensaje);

            Properties properties = new Properties();
            String username = "tucorreo@gmail.com";
            String password = "contraseña";
            Session session;
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.port", 25);
            properties.put("mail.smtp.mail.sender", "emisor@gmail.com");
            properties.put("mail.smtp.user", "usuario");
            properties.put("mail.smtp.auth", "true");

            session = Session.getDefaultInstance(properties);

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress((String) properties.get("mail.smtp.mail.sender")));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress("pepeino2@hotmail.com"));
                message.setSubject(asunto);
                message.setText(mensaje);
                Transport t = session.getTransport("smtp");
                t.connect((String) properties.get("mail.smtp.user"), "password");
                t.sendMessage(message, message.getAllRecipients());
                t.close();
            } catch (MessagingException me) {
                pw.println(me);
            }

            //Clase de correos, metodo que genere el mensaje, pasandole la contraseña
        }
        
        
        
        

        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
