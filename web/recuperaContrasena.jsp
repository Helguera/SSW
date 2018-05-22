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

    <div class="container">
        <form action="recuperaPassServlet" method="post">
            <center><h1>¿Has olvidado tu contraseña?</h1></center>
            <br>
            </br>
            
         
            <h5>Si has olvidado tu contraseña, no te preocupes, introduce tu correo electrónico y te la recordaremos.</h5>
            <br>
            <label for="correo">Correo electrónico</label>
            <input type="text" id="correo" name="correo" placeholder="Correo...">
            <br>
            <center>
                <input type="submit" value="Recuperar Contraseña">
            </center>
            <br><br>
 
        </form>
    </div>

    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <footer class="footer">
        <br>
        <h2>© 3DImpresion 2018</h2>
    </footer>

</body>

</html>