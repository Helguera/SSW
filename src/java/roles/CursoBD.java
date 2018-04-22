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
public class CursoBD {
    
    public static Curso selectCurso(String nombre) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Curso WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            Curso cur = null;
            if (rs.next()) {
                cur = new Curso();
                cur.setCode(rs.getInt("Codigo"));
                cur.setPrecio(rs.getDouble("Precio"));
                cur.setNombre(rs.getString("Nombre"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return cur;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
