<%@page import="roles.Archivo"%>
<%@page import="roles.Impresora3d"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="roles.Consumible"%>
<%@page import="roles.Producto"%>
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


        </header>

        <br><br><br>

        <%
            HttpSession sesion = request.getSession();
            PrintWriter pw = response.getWriter();
            if (sesion.getAttribute("administrador") != null) {
        %>
        <%
            if (request.getAttribute("tipo") == null) {
                //pw.print(sesion.getAttribute("tipo"));

        %>
        <div class="container">

            <h1><center>¡Bienvenido al panel de administración!</center></h1>
            <br><br><br><br>
            <center><h3>¿Que quieres modificar?</h3></center>
            <br><br>

            <form action="admin" method="post"> 
                <br>
                <center> <input type = "submit" name="zona" value = "Clientes"> </center> 
            </form>
            <form action="admin" method="post"> 
                <br>
                <center> <input type = "submit" name="zona" value = "Productos"> </center> 
            </form>
            <form action="admin" method="post"> 
                <br>
                <center> <input type = "submit" name="zona" value = "Cursos"> </center> 
            </form>
            <form action="admin" method="post"> 
                <br>
                <center> <input type = "submit" name="zona" value = "Consulta archivos recibidos"> </center> 
            </form>



            <form action="logout" method="post">
                <br><br><br><br>
                <center><input type="submit" value="Cerrar Sesión"></center>
            </form>

        </div>
        <%        } else {
            if (request.getAttribute("tipo").toString().equals("Productos")) {
                ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");

        %>
        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
            <%                    for (int i = 0; i < productos.size(); i++) {
                    Producto producto = productos.get(i);
                    if (producto.getClass().getSimpleName().equals("Consumible")) {
            %>
            <tr><form action="eliminar" method="get">
                <td width="5%"><input name="id" type="text" value="<%=((Consumible) producto).getId_producto()%>" readonly></td>
                <td><input name="nombre" type="text" value="<%=((Consumible) producto).getNombre()%>"></td>
                <td><input name="precio" type="text" value="<%=((Consumible) producto).getPrecio()%>"></td>
                <td> 
                <center> <input type = "submit" value = "Eliminar"> </center> 
            </form></td>
    </tr>
    <%}
        }%>
</table>

<br><br><br>

<table style="width:100%">
    <tr>
        <th>ID</th>
        <th>Nombre</th>
        <th>Precio</th>
    </tr>
    <%                    for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.get(i);
            if (producto.getClass().getSimpleName().equals("Impresora3d")) {
    %>
    <tr><form action="eliminar" method="get">
        <td width="5%"><input name="id" type="text" value="<%=((Impresora3d) producto).getId_producto()%>" readonly></td>
        <td><input name="nombre" type="text" value="<%=((Impresora3d) producto).getModelo()%>"></td>
        <td><input name="precio" type="text" value="<%=((Impresora3d) producto).getPrecio()%>"></td>
        <td> 
        <center> <input type = "submit" value = "Eliminar"> </center> 
    </form></td>
</tr>
<%}
    }%>
</table>



<form action="admin" method="get"> 
    <br>
    <center> <input type = "submit" value = "Volver"> </center> 
</form>

<form action="logout" method="post"> 
    <br>
    <center> <input type = "submit" value = "Cerrar Sesión"> </center> 
</form>





<%
    }

    if (request.getAttribute("tipo").toString().equals("Consulta archivos recibidos")) {
        ArrayList<Archivo> archivos = (ArrayList<Archivo>) request.getAttribute("archivos");

%>
<table style="width:100%">
    <tr>
        <th>Ruta</th>
        <th>Descripcion</th>
        <th>Usuario</th>
    </tr>
    <%                    for (int i = 0; i < archivos.size(); i++) {
            Archivo archivo = archivos.get(i);
    %>
    <tr>

        <td><input name="ruta" type="text" value="<%=archivo.getRuta()%>"readonly></td>
        <td><input name="desc" type="text" value="<%=archivo.getDescription()%>"readonly></td>
        <td><input name="user" type="text" value="<%=archivo.getUsuario()%>"readonly></td>
        </tr>
        <%
        }%>
</table>

<br><br><br>



<form action="admin" method="get"> 
    <br>
    <center> <input type = "submit" value = "Volver"> </center> 
</form>

<form action="logout" method="post"> 
    <br>
    <center> <input type = "submit" value = "Cerrar Sesión"> </center> 
</form>





<%
        }

if (request.getAttribute("tipo").toString().equals("Cursos")) {
%>
<h1><center>No se ha implementado por tiempo, es igual que el admin de productos</center></h1>
<form action="admin" method="get"> 
    <br><br><br><br>
    <center> <input type = "submit" value = "Volver"> </center> 
</form>
<%

}

if (request.getAttribute("tipo").toString().equals("Clientes")) {
%>
<h1><center>No se ha implementado por tiempo, es igual que el admin de productos</center></h1>
<form action="admin" method="get"> 
    <br><br><br><br>
    <center> <input type = "submit" value = "Volver"> </center> 
</form>
<%
}

    }
} else {
%>
<h1><center>No tiene permisos de administrador</center></h1>



<%}%>




<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<footer class="footer">
    <br>
    <h2>© 3DImpresion 2018</h2>
</footer>

</body>

</html>
