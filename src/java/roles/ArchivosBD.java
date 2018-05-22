/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import servlets.ConnectionPool;

/**
 *
 * @author josealbertodelval
 */
public class ArchivosBD {
    public static int insert(Archivo a) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into archivos (nombre, apellido,email,calle,numero,ciudad,provincia,cp,password) "
                + "VALUES('" + a.getNombre() + "','" + a.getRuta() + "','" + a.getUsuario() + "')";
        //String query = "insert into usuario values ('"+user.getNombre()+"','"+user.getApellidos()+"','"+user.getEmail()+"','"+user.getCalle()+"',"+user.getResto()+",'"+user.getPoblacion()+"',"+ user.getCp()+",'"+user.getPassword()+"')";
        try {
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
        } catch (Exception w) {

        }

        try {

            //Preparamos el query
            ps = connection.prepareStatement(query);
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getRuta());
            ps.setString(3, a.getUsuario());
           

            //Ejecutamos el query
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static boolean archExists(Archivo a) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT nombre FROM ARCHIVOS WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, a.getUsuario());
            rs = ps.executeQuery();
            boolean res = rs.next();
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
