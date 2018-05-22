<%-- 
    Document   : cursos
    Created on : Apr 23, 2018, 7:58:12 PM
    Author     : javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="roles.*"%>
<%@page import="servlets.*"%>
<%@page import="java.util.*"%>
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
        
    <%
    HttpSession sesion = request.getSession();
    if(sesion.getAttribute("usuario")==null){
        sesion.setAttribute("urlAnterior", "cursos");
    %>
    <center>
        <div class="container">
            <h1>Para apuntarse a un curso es necesario haber iniciado sesión.</h1>
        </div>
        <h3><a href="login.html">Iniciar sesión</a></h3>
        <h3><a href="registro.html">Registrarme</a></h3>
    </center>
    <br><br><br>
    <%
    }
    %>


        <div class="container">
            <%
                ArrayList<Curso> cursos = (ArrayList<Curso>)request.getAttribute("cursos");
        
                for(int i=0; i<cursos.size(); i++){
                    Curso curso=cursos.get(i);
                        
            %>
                    <img src="images/cursoIniciacion.jpg" align="left" width="60%" alt="Impresion 3D" title="Curso iniciacion" class="image"/>
                    <br>
                    <br>
                    <br>
                    <center><h1><%=curso.getNombre()%></h1>
                    <br>
                    <p><%=curso.getDescripcion()%></p>
                    <br>
                    <input type="submit" value="Apuntarse al curso" onclick = "location.href='login.html'"/>
                    </center>
            <%}
                
            %>

                
    </div>





            

        <br><br><br><br><br><br><br><br><br>

        <footer class="footer">
            <br>
            <h2>© 3DImpresion 2018</h2>
        </footer>

    </body>

</html>

