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
 * @author enriq_000
 */
public class addCursoBD {
    public static boolean userExists(Usuario usuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT email FROM userCursos WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, usuario.getEmail());
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
    
    public static int insert(Usuario user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into userCursos (email,password) "
                + "VALUES('" + user.getEmail() + "','" + user.getPassword() + "')";
        //String query = "insert into usuario values ('"+user.getNombre()+"','"+user.getApellidos()+"','"+user.getEmail()+"','"+user.getCalle()+"',"+user.getResto()+",'"+user.getPoblacion()+"',"+ user.getCp()+",'"+user.getPassword()+"')";
        try {
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
        } catch (Exception w) {

        }

        try {

            //Preparamos el query
            ps = connection.prepareStatement(query);
            ps.setString(3, user.getEmail());
            ps.setString(8, user.getPassword());

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
}
