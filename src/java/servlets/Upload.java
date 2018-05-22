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
            
            Part filePart = request.getPart("file");
            String fileName = request.getParameter("nameArch");
            String description = request.getParameter("description");
            
            //No entiendo el porque de este error.
            
            Archivo ar = new Archivo();
            ar.setRuta("/archivos/"+fileName);
            ar.setNombre(fileName);
            HttpSession sesion = request.getSession();
            Usuario u =(Usuario) sesion.getAttribute("usuario");
            ar.setUsuario(u.getEmail());
            
            if(ArchivosBD.archExists(ar)==false)   ArchivosBD.insert(ar);
            
            OutputStream out = null;
            InputStream fileContent = null;
            final PrintWriter writer = response.getWriter();
            
            try {
                out = new FileOutputStream(new File(path + File.separator + fileName));
                fileContent = filePart.getInputStream();

                int read = 0;
                byte[] bytes = new byte[1024];
                
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                //writer.println("New file " + fileName + " created at " + path);
                response.sendRedirect("index.html");

                
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

}
