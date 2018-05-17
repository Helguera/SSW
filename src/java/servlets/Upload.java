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
import javax.servlet.http.Part;

@WebServlet(name = "Upload", urlPatterns = {"/upload"})
@MultipartConfig
public class Upload extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//String path = "C:\\Users\\Pepe\\Documents\\sswRepository";
        String path = getServletContext().getRealPath("/images");
        try (PrintWriter out = response.getWriter()) {
            Part filePart = request.getPart("file");
            String fileName = getFileName(filePart);
            InputStream fileContent = filePart.getInputStream();
            OutputStream outFile = null;
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<title>Servlet Upload</title></head>");
            out.println("<body>");
            try {
                outFile = new FileOutputStream(new File(path + File.separator
                        + fileName));
                int read = 0;
                byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    outFile.write(bytes, 0, read);
                }
                out.println("Fichero " + fileName + " creado");
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
    }

    private static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"",
                        "");
                return fileName.substring(fileName.lastIndexOf('/')
                        + 1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }
}
