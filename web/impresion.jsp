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
    <script language="javascript">
function comprobar()
{
   
   if(document.getElementById('name').value.length <1||document.getElementById('des').value.length <1||
           document.getElementById('file').value.length<1){
       alert("No se han rellenado todos los campos.");
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
                    sesion.setAttribute("urlAnterior", "impresion");
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
        <%
            if(sesion.getAttribute("usuario")==null){
                sesion.setAttribute("urlAnterior", "impresion");
        %>
                <center>
                <div class="container">
                    <h1>Para encargar una impresión o diseño es necesario haber iniciado sesión.</h1>
                </div>
                <h3><a href="login">Iniciar sesión</a></h3>
                <h3><a href="registro">Registrarme</a></h3>
                </center>
                <br><br><br>
        <%
            }
        %>
        <%
            if(sesion.getAttribute("usuario")!=null){
                
        %>
            
            
            <form method="post" action="upload" enctype="multipart/form-data"> 
            
            <div>
                    <h3>Rellena los siguientes campos y selecciona un archivo..</h3>
                    <input type="text" id="name" name="nameArch" placeholder="Nombre del archivo tal cual esta en tu directorio..."/>
                    
                    <input type="text" id="des " name="description" placeholder="Comentarios acerca del archivo..."/>


            </div>
           
            
            
            <input type="file" id="file"  name="adjunto" accept=".pdf,.jpg,.png,.stl" multiple>
         
             <FONT SIZE=1>&#160 &#160 &#160 &#160 &#160 &#160 &#160 &#160* Formatos permitidos: .pdf , .jpg, .png , .stl.</font>
            
            <br>
            <br>

            <p>
                <input type = "submit" value = "Enviar" onclick="comprobar()"/>
                </form>
            </p>
                     <%
            }
        %>
            

     </div>
   
     <br>

    <footer class="footer">
        <br>
        <h2>© 3DImpresion 2018</h2>
    </footer>

</body>

</html>