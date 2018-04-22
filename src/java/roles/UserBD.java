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

    public static int insert(Usuario user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into usuario (nombre, apellido,email,calle,numero,ciudad,provincia,cp,password) "
                + "VALUES('"+user.getNombre()+"','"+user.getApellidos()+"','"+user.getEmail()+"','"+user.getCalle()+"','"+user.getResto()+"','"+user.getPoblacion()+"','"+user.getProvicia()+"','"+user.getCp()+"','"+user.getPassword()+"')";
        //String query = "insert into usuario values ('"+user.getNombre()+"','"+user.getApellidos()+"','"+user.getEmail()+"','"+user.getCalle()+"',"+user.getResto()+",'"+user.getPoblacion()+"',"+ user.getCp()+",'"+user.getPassword()+"')";
        try {
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
        } catch (Exception w) {

        }
        
    
        try {
            
            //Preparamos el query
            
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getNombre());
            ps.setString(2, user.getApellidos());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getCalle());
            ps.setString(5, user.getResto());
            ps.setString(6, user.getPoblacion());
            ps.setString(7, user.getCp());
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

    public static Usuario selectUsuario(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM usuario WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            Usuario usuario = null;
            if (rs.next()) {
                usuario = new Usuario();               
                
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidos(rs.getString("apellido"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPassword(rs.getString("password"));

                usuario.setCalle(rs.getString("calle"));
                usuario.setResto(rs.getString("numero"));
                usuario.setPoblacion(rs.getString("ciudad"));
                usuario.setProvicia(rs.getString("provincia"));
                usuario.setCp(rs.getString("cp"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return usuario;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String selectPass(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String password="";

        String query = "SELECT password FROM usuario WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                password=rs.getString("password");               
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return password;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
