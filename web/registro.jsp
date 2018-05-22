<html>
<meta charset="utf-8">
<head>
    
    <title>Impresion 3D</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script language="javascript">
function comprobar()
{
   var nombre = document.formu.nombre.value;
   //var apellidos = document.formu.apellidos.value;
   if (nombre.length <1)
   {
      alert("No has introducido un nombre.");
      return false;
   }
   if(document.getElementById('apellidos').value.length <1 ){
       alert("No has introducido apellidos");
       return false;
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
            <p>E-mail: <input name="email" type="text" placeholder="Tu email..."></p>
            <p>Contraseña: <input name="password" type="text" placeholder="Tu contraseña..."></p>
            <p>Confirma tu contraseña: <input name="password2" type="text" placeholder="Tu contraseña..."></p>
            <p>Dirección:</p>
            <input name="calle" type="text" placeholder="Tu calle...">
            <input name="resto" type="text" placeholder="Numero, resto...">
            <input name="poblacion" type="text" placeholder="Tu población...">
            <input name="provincia" type="text" placeholder="Tu provincia...">
            <input name="cp" type="text" placeholder="Tu código postal...">
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