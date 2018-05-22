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

    <br>

    <div class="container">
        
        <form action="consultUserServlet" method="post">
        <p>Correo electrónico: <input name="correo" type="text" placeholder="Tu correo electrónico..."></p>
        <p>Contraseña: <input name="pass" type="password" placeholder="Contraseña..."></p>
        <center>
            <input type="submit" value="Acceder">
        </center>
        </form>
            <br>
            <br>
            <center>
                <h5><a href="recuperaContrasena">¿Has olvidado la contraseña?</a></h5>
            </center>
            <center>
                <h5><a href="registro">¿Necesitas una cuenta?</a></h5>
            </center>
    </div>

    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <footer class="footer">
        <br>
        <h2>© 3DImpresion 2018</h2>
    </footer>

</body>

</html>