/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import java.sql.*;
import servlets.*;

/**
 *
 * @author enriq_000
 */
public class ProductoBD {

    public static Producto selectProducto(String nombre) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Producto WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            Producto pr = null;
            if (rs.next()) {
                pr = new Producto();
                pr.setCode(rs.getInt("Codigo"));
                pr.setPrecio(rs.getDouble("Precio"));
                pr.setNombre(rs.getString("Nombre"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return pr;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
