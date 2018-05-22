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
                        <a href="impresion">Impresi�n</a>
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
  
    <div class="container justificado">
        <h1>�Por qu� elegir 3D Impresi�n?</h1>
        <br>
        <p>Con nuestra tecnolog�a y conocimientos ofrecemos un servicio de impresi�n 3d online de una excelente calidad y con
            el menor coste del mercado garantizado 100%. Hemos optimizado el desarrollo de la fabricaci�n de los modelos
            y contamos con las impresoras 3d mas actuales del mercado y siempre en continua evoluci�n, as� hemos conseguido
            reducir los costes para ofrecer el mejor servicio al menor precio. Tenemos los precios m�s bajos de Espa�a 100%
            garantizado. Tener un precio bajo no significa una p�rdida de calidad, nuestro equipo ante todo nos comprometemos
            en ofrecer un nivel alto de acabado, ya que contamos con materiales de una excelente calidad. Rellene el formulario
            y pasados unos instantes le contestamos sin compromiso para una impresi�n 3d totalmente personalizada.
        </p>
        <br>
        <p>
            Realizamos la impresi�n 3d de cualquier objeto y geometr�a, contamos con la �ltima tecnolog�a del mercado y los �ltimos materiales.
            Y siempre en constante innovaci�n.
        </p>
        <br>
        <p>
            Contamos con las impresoras 3d m�s actuales y grandes profesionales en el dise�o capaces de hacer r�plicas de dise�os 3d
            con un perfecto acabado para un buen ensamblaje.
        </p>
        <br>
        <p>
            Disponemos de un grupo de dise�adores y modeladores expertos para elaborar cualquier dise�o 3d, necesidad y funcionalidad
            en cualquier �mbito.
        </p>
        <p>
            En el suguiente formulario puede comentarnos cualquier duda que le surja, estaremos encantados de ayudarle.
        </p>
    </div>

    <div class="container">
        <div style="text-align:center">
            <h2>Cont�ctanos</h2>
        </div>
        <div class="row">
        </div>
        <div>
            <form>
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" placeholder="Tu nombre...">
                <label for="apellido">Apellidos</label>
                <input type="text" id="apellidos" name="apellidos" placeholder="Tus apellidos...">
                <label for="apellido">Correo Electr�nico</label>
                <input type="text" id="email" name="email" placeholder="Tu correo...">
                <label for="asunto">Asunto</label>
                <input type="text" id="asunto" name="asunto" placeholder="Asunto...">
                <label for="tipo">Tipo de consulta</label>
                <select id="tipo" name="tipo">
                    <option value="impresion3d">Impresi�n 3D</option>
                    <option value="modelado">Modelado</option>
                    <option value="tienda">Tienda</option>
                    <option value="Cursos">Cursos</option>
                    <option value="otro">Otro</option>
                </select>
                <label for="mensaje">Mensaje</label>
                <textarea id="subject" name="subject" placeholder="Com�ntanos tu duda..." style="height:170px"></textarea>
                <center>
                    <input type="submit" value="Enviar"  onclick = "location.href='index'">
                </center>
            </form>
        </div>
    </div>

    <footer class="footer">
        <br>
        <h2>� 3DImpresion 2018</h2>
    </footer>

</body>

</html>