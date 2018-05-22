<%-- 
    Document   : tienda
    Created on : Apr 22, 2018, 6:54:56 PM
    Author     : javier
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.*"%>
<%@page import="servlets.ConnectionPool"%>
<%@page import="roles.*"%>
<%@page import="servlets.*"%>
<%@page import="java.util.*"%>
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
            <a href="index">
                <img src="images/logo.png" width="25%" />
            </a>
            <nav>
                <ul>
                    <li>
                        <h1>
                            <a href="index">Inicio</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="impresion">Impresión</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="tienda">Tienda</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="cursos">Cursos</a>
                        </h1>
                    </li>
                    <li>
                        <h1>
                            <a href="info_empresa">La empresa</a>
                        </h1>
                    </li>
                    <%
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("urlAnterior", "tienda");
                    if(sesion.getAttribute("usuario")==null){
                    %>
                        <li>
                            <h1>
                                <a href="registro">Registro</a>
                            </h1>
                        </li>
                    <%
                    }else{
                    %>
                        <li>
                            <h1>
                                <a href="logout">Logout</a>
                            </h1>
                        </li>
                    <%
                    }
                    %>
                </ul>
            </nav>

        </header>
        <br><br><br>
    <%
    if(sesion.getAttribute("usuario")==null){
        sesion.setAttribute("urlAnterior", "tienda");
    %>
    <center>
        <div class="container">
            <h1>Para realizar compras es necesario haber iniciado sesión.</h1>
        </div>
        <h3><a href="login">Iniciar sesión</a></h3>
        <h3><a href="registro">Registrarme</a></h3>
    </center>
    <br><br><br>
    <%
    }
    %>

    <div class="container">
        <ul class="image-grid">
            <%
                Producto[] carrito = (Producto[])sesion.getAttribute("carrito");
                ArrayList<Producto> productos = (ArrayList<Producto>)request.getAttribute("productos");
        
                for(int i=0; i<productos.size(); i++){
                    Producto producto=productos.get(i);
                    if(producto.getClass().getSimpleName().equals("Consumible")){
            %>
            <li>
                <img src='images/tienda2.jpg'/>
                <h3><%=((Consumible)producto).getNombre()%></h3>
                <h2><%=producto.getPrecio()%> €</h2>
            </li>

            <%      }else{
            %>
            <li>
                <img src='images/tienda1.jpg'/>
                <h3><%=((Impresora3d)producto).getModelo()%></h3>
                <h2><%=producto.getPrecio()%> €</h2>
            </li>

            <%}
                    }
                %>

        </ul>
                
    </div>

    <br><br><br><br><br><br><br><br><br><br><br><br>
    <footer class="footer">
        <br>
        <h2>© 3DImpresion 2018</h2>
    </footer>Consumible

</body>

</html>
