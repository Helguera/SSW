<%-- 
    Document   : Registro2
    Created on : Apr 18, 2018, 12:29:28 PM
    Author     : javier
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios Registrados</title>
    </head>
    <body>
        <%
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String dni = request.getParameter("dni");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            
            String calle = request.getParameter("calle");
            String resto = request.getParameter("resto");
            String poblacion = request.getParameter("poblacion");
            String provincia = request.getParameter("provincia");
            String cp = request.getParameter("cp");

            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            
            String query = "insert into usuario values ('Fernando','Zamora','12345678A','hola@hola.com','calle',5,'Valladolid', 47001,'1234')";
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
        %>


    </body>
</html>
