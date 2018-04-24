<%-- 
    Document   : tienda
    Created on : Apr 22, 2018, 6:54:56 PM
    Author     : javier
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.*"%>
<%@page import="servlets.ConnectionPool"%>
<%@page import="roles.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <head>
        <title>Impresion 3D</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>

    <body>

        <header id="header">
            <a href="index.html">
                <img src="images/logo.png" width="25%" />
            </a>
            <nav>
                <ul>
                    <li>
                        <h1>
                            <a href="index.html">Inicio</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="impresion.html">Impresión</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="tienda.jsp">Tienda</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="cursos.html">Cursos</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="registro.html">Registro</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="info_empresa.html">La empresa</a>
                        </h1>
                    </li>
                </ul>
            </nav>

        </header>
        <br><br><br>
    <center>
        <div class="container">
            <h1>¡Haz login , y elige cualquiera de nuestros productos!</h1>
        </div>
        <h3><a href="login.html">Login aquí</a></h3>
    </center>
    <br><br><br>
    
    <%
        HttpSession sesion = request.getSession();
        Producto[] carrito = (Producto[]) sesion.getAttribute("carrito");
    %>

    <div class="container">
        <ul class="image-grid">
            <%
                ConnectionPool pool = ConnectionPool.getInstance();
                Connection connection = pool.getConnection();

                PrintWriter pw = response.getWriter();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet products = statement.executeQuery("SELECT * FROM PRODUCTOS P JOIN IMPRESORAS3D I ON P.ID_PRODUCTO=I.ID_PRODUCTO");
                    while (products.next()) {
            %>
            <li>
                <img src='images/tienda1.jpg'/>
                <h3><%=products.getString("modelo")%></h3>
                <h2><%=products.getString("precio")%> €</h2>
            </li>

            <%}
                } catch (Exception e) {
                }

                try {
                    Statement statement = connection.createStatement();
                    ResultSet products = statement.executeQuery("SELECT * FROM PRODUCTOS P JOIN CONSUMIBLES C ON P.ID_PRODUCTO=C.ID_PRODUCTO");
                    while (products.next()) {
            %>
            <li>
                <img src='images/tienda2.jpg'/>
                <h3><%=products.getString("nombre")%></h3>
                <h2><%=products.getString("precio")%> €</h2>
            </li>

            <%}
                } catch (Exception e) {
                }%>

        </ul>

    </div>

    <br><br><br><br><br><br><br><br><br><br><br><br>
    <footer class="footer">
        <br>
        <h2>© 3DImpresion 2018</h2>
    </footer>

</body>

</html>
