<html>
    
    <meta charset="utf-8">

<head>
    <title>Impresion 3D</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>

    <header class="header">
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

    <div class="zoom">
        <center>
            <a href="impresion">
                <img src="images/portada1.jpg" width="75%">
            </a>
        </center>
    </div>
    <br>
    <div class="zoom">
        <center>
            <a href="impresion">
                <img src="images/portada2.jpg" width="75%">
            </a>
        </center>
    </div>
    <br>
    <div class="zoom">
        <center>
            <a href="tienda">
                <img src="images/portada3.jpg" width="75%">
            </a>
        </center>
    </div>
    <br>
    <div class="zoom">
        <center>
            <a href="cursos">
                <img src="images/portada4.jpg" width="75%">
            </a>
            <br>
        </center>
    </div>


    <footer class="footer">
        <br>
        <h2>© 3DImpresion 2018</h2>
    </footer>

</body>

</html>