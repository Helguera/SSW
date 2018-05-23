<html>
<meta charset="utf-8">
<head>
    
    <title>Impresion 3D</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script language="javascript">
function comprobar()
{
   
   if(document.getElementById('apellidos').value.length <1||document.getElementById('email').value.length<1||
           document.getElementById('password').value.length<1||document.getElementById('password2').value.length<1||
           document.getElementById('calle').value.length<1||document.getElementById('resto').value.length<1||
           document.getElementById('poblacion').value.length<1||document.getElementById('provincia').value.length<1||
           document.getElementById('cp').value.length<1){
       alert("Por favor, rellena todos los campos");
   }
   

  
   else{
       alert("Registro Correcto");
       //return true;
   }
   return true;
   
   
   
}
</script>
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
     
         <center><h1>¿Quieres registrarte en nuestro sitio?</h1></center>
         
         <center><h3>Rellene la siguiente información :</h3></center>
        
         <form action="addUserServlet" method="post" id="formu" name = "formu" >   
         
            <p>Nombre: <input name="nombre" type="text" placeholder="Tu nombre..."></p>
            <p>Apellidos: <input name="apellidos" id ="apellidos" type="text" placeholder="Tus apellidos..."></p>
            <p>E-mail: <input name="email" id="email" type="text" placeholder="Tu email..."></p>
            <p>Contraseña: <input name="password" id="password" type="password" placeholder="Tu contraseña..."></p>
            <p>Confirma tu contraseña: <input name="password2" id="password2" type="password" placeholder="Tu contraseña..."></p>
            <p>Dirección:</p>
            <input name="calle" id="calle" type="text" placeholder="Tu calle...">
            <input name="resto" id="resto" type="text" placeholder="Numero, resto...">
            <input name="poblacion" id="poblacion" type="text" placeholder="Tu población...">
            <input name="provincia" id="provincia" type="text" placeholder="Tu provincia...">
            <input name="cp" id="cp" type="text" placeholder="Tu código postal...">
            <h5>*Al hacer clic en Registrarme aceptas nuestra política de protección de datos.</h5>
            <p><center><input type = "submit" value = "Registrarme" onclick="comprobar()"></center></p>
         
         </form>
        
     </div>
     
     <footer class="footer">
        <br>
        <h2>© 3DImpresion 2018</h2>
    </footer>

</body>

</html>