<%-- 
    Document   : prueba
    Created on : Apr 18, 2018, 11:15:39 AM
    Author     : javier
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! <%= new Date()%></h1>
        
        Peticion datos al navegador: <%= request.getHeader("User-Agent") %>
                
        
        
        
    </body>
</html>
