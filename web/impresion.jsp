<%-- 
    Document   : impresion
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

    <br>
   
     <div class="container">
        <%
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("usuario")==null){
                sesion.setAttribute("urlAnterior", "impresion");
        %>
                <center>
                <div class="container">
                    <h1>Para encargar una impresión o diseño es necesario haber iniciado sesión.</h1>
                </div>
                <h3><a href="login.html">Iniciar sesión</a></h3>
                <h3><a href="registro.html">Registrarme</a></h3>
                </center>
                <br><br><br>
        <%
            }
        %>
            
            <form method="POST" action="upload" enctype="multipart/form-data"> 
            
            <div>
            <textarea name="comentarios" rows="10" cols="40">Descripción de su solicitud.</textarea>
            </div>
            
           
            <input type="file" name="adjunto" accept=".pdf,.jpg,.png,.stl" multiple>
             <FONT SIZE=1>&#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160* Formatos permitidos: .pdf , .jpg, .png , .stl.</font>
            <br>
            <br>

            <p>
                <input type = "submit" value = "Enviar" onclick = "location.href='index.html'"/>
            </p>
            </form>

     </div>
   
     <br>

    <footer class="footer">
        <br>
        <h2>© 3DImpresion 2018</h2>
    </footer>

</body>

</html>