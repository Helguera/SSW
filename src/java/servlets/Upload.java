package servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import roles.*;

@WebServlet(name = "Upload", urlPatterns = {"/upload"})
@MultipartConfig
public class Upload extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//String path = "C:\\Users\\Pepe\\Documents\\sswRepository";
        String path = getServletContext().getRealPath("/archivos");

            //Recogemos parametros del formulario 
            
            Part filePart = request.getPart("adjunto");
            String fileName = request.getParameter("nameArch");
            String description = request.getParameter("description");
            
            final PrintWriter pw = response.getWriter();
            response.setContentType("text/html");

            Archivo ar = new Archivo();
            ar.setRuta("/archivos/"+fileName);
            ar.setDescription(description);
            HttpSession sesion = request.getSession();
            Usuario u =(Usuario) sesion.getAttribute("usuario");
            ar.setUsuario(u.getEmail());
            if(!ArchivosBD.archExists(ar))   {
               
                ArchivosBD.insert(ar);

            pw.println("<html><head><title>correcto.</title></head><body>");  
            pw.println("<h1>Archivo subido correctamente.</h1>");            
            pw.println("<h3><a href=\"index.html\">Volver al inicio.</a></h3>");
            pw.println("</body></html>");
            }
            else{

            pw.println("<html><head><title>Usuario tiene mas de un archivo en server.</title></head><body>");  
            pw.println("<h1>El usuario no puede subir mas archivos.</h1>");            
            pw.println("<h3><a href=\"index.html\">Volver al inicio.</a></h3>");
            pw.println("</body></html>");
            }
            
            OutputStream out = null;
            InputStream fileContent = null;
            
            try {
                out = new FileOutputStream(new File(path + File.separator + fileName));
                fileContent = filePart.getInputStream();

                int read = 0;
                byte[] bytes = new byte[1024];
                
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                //writer.println("New file " + fileName + " created at " + path);
                //response.sendRedirect("index.html");

                
            } catch (FileNotFoundException fne) {
                
            } finally {
                if (out != null) {
                    out.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
                
            }
        
    }
    /*protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = "C:\\Users\\Pepe\\Documents\\sswRepository";
        //String path = getServletContext().getRealPath("archivos");
        try (PrintWriter out = response.getWriter()) {
            Part filePart = request.getPart("file");
            //String fileName = getFileName(filePart);
            String fileName = request.getParameter("nameArch");

            InputStream fileContent = filePart.getInputStream();
            OutputStream outFile = null;
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Servlet Upload</title></head>");
            out.println("<body>");
            Archivo ar = new Archivo();
            ar.setRuta("/archivos/" + fileName);
            ar.setNombre(fileName);
            HttpSession sesion = request.getSession();
            Usuario u = (Usuario) sesion.getAttribute("usuario");
            ar.setUsuario(u.getEmail());

            if (ArchivosBD.archExists(ar) == false) {
                ArchivosBD.insert(ar);
            }

            try {
                outFile = new FileOutputStream(new File(path + File.separator
                        + fileName));
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    outFile.write(bytes, 0, read);
                }
                out.println("Fichero " + fileName + " creado");
                response.sendRedirect("index.html");

            } catch (FileNotFoundException fne) {
                out.println("Error al subir el fichero:");
                out.println("<br/>" + fne.getMessage());
            } finally {
                if (outFile != null) {
                    outFile.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
                if (out != null) {
                    out.println("</body></html>");
                    out.close();
                }
            }
        }
    }*/

}
