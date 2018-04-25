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
                            <a href="cursos.jsp">Cursos</a>
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


        <div class="container">
            <ul class="image-grid">
                <%
                    HttpSession sesion = request.getSession();
                    ArrayList<Curso> cursos = (ArrayList<Curso>)request.getAttribute("cursos");
        
                    for(int i=0; i<cursos.size(); i++){
                        Curso curso=cursos.get(i);
                        
                %>
                <li>
                    <img src='images/tienda2.jpg'/>
                    <h3><%=curso.getNombre()%></h3>
                    <h3><%=curso.getFecha()%></h3>
                    <h2><%=curso.getDireccion()%> €</h2>
                    <h2><%=curso.getDescripcion()%> €</h2>
                </li>

                <%}
                        }
                %>

        </ul>
                
    </div>





            <img src="images/cursoIniciacion.jpg" align="left" width="60%" alt="Impresion 3D" title="Curso iniciacion" class="image"/>
            <br>
            <center><h1>Curso de iniciación a la impresión 3D</h1>
                <br>
                <p>Con este curso te iniciarás en el mundo de la impresión 3D y aprenderás todo lo necesario
                    para realizar tus primeras piezas y conocer los aspectos tecnicos básicos para manejar una
                    impresora 3D.</p>
                <br>
                <input type="submit" value="Apuntarse al curso" onclick = "location.href = 'login.html'"/>
            </center>

            <br><br><br><br><br><br><br><br><br><br>

            <img src="images/cursoAvanzado.jpg" align="right" width="60%" alt="Impresion 3D" title="Curso avanzado" class="image"/>
            <center><h1>Curso avanzado de impresión 3D</h1>
                <br>
                <p>Con este curso obtendrás los conocimientos necesarios para desenvolverte con soltura en el ámbito de la
                    impresión 3D, conocer los softwares de manejo de impresoras y detectar, analizar y solucionar problemas típicos
                    en la impresión 3D.</p>
                </br>
                <input type="submit" value="Apuntarse al curso" onclick = "location.href = 'login.html'"/>
            </center>
        </div>

        <br><br><br><br><br><br><br><br><br>

        <footer class="footer">
            <br>
            <h2>© 3DImpresion 2018</h2>
        </footer>

    </body>

</html>

