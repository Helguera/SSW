/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

/**
 *
 * @author josealbertodelval
 */
import java.sql.*;
import servlets.*;

public class UserBD {

    /*public static int insert(Usuario user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "INSERT INTO User (FirstName, LastName,EmailAddress) VALUES (?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidoName());
            ps.setString(3, user.getEmail());
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }*/
    public static boolean userExists(Usuario usuario) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT email FROM USUARIO WHERE email = ?";
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

    /*public static Usuario selectUsuario(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM User WHERE EmailAddress = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            Usuario user = null;
            if (rs.next()) {
                user = new Usuario();
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmailAddress(rs.getString("EmailAddress"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}
