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
            <a href="index.html">
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
            if (sesion.getAttribute("tipo") == null) {
                //pw.print(sesion.getAttribute("tipo"));
                
        %>
        <div class="container">

            <h1><center>¡Bienvenido al panel de administración!</center></h1>
            <br><br><br><br>
            <center><h3>¿Que quieres modificar?</h3></center>
            <br><br>
            <form action="admin" method="post">
                <div class="container">
                    <input type="radio" name="zona" value="clientes"><font size="3"> Modificar datos clientes.</font><br><br>
                    <input type="radio" name="zona" value="productos"><font size="3"> Modificar productos.</font><br><br>
                    <input type="radio" name="zona" value="cursos"><font size="3"> Modificar cursos.</font><br>
                </div>
                <br><br><br>
                <center><input type="submit" value="Seleccionar"></center>
            </form>

            <form action="logout" method="post">
                <br><br><br>
                <center><input type="submit" value="Cerrar Sesión"></center>
            </form>

        </div>
        <%
        } else {
            if (sesion.getAttribute("tipo").equals("productos")) {
            pw.print(sesion.getAttribute("tipo"));
                ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("productos");

        %>
        <table style="width:100%">
            <tr>
                <th>Nombre</th>
                <th>Precio</th>
            </tr>
            <tr>
                <%                    for (int i = 0; i < productos.size(); i++) {
                        Producto producto = productos.get(i);
                        if (producto.getClass().getSimpleName().equals("Consumible")) {
                %>
                <th><%=((Consumible) producto).getNombre()%></th>
                <th><%=((Consumible) producto).getPrecio()%></th>
                    <%}%>
            </tr>
        </table>



        <%
                    }
                }

            }
        %>
 
        <%
            

            
            
        }else {
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
