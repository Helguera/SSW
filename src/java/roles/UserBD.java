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
        String query = "insert into usuario values (nombre, apellido,email,calle,numero,ciudad,cp,password) VALUES (?,?,?,?,?,?,?,?)";
        //String query = "insert into usuario values ('"+user.getNombre()+"','"+user.getApellidos()+"','"+user.getEmail()+"','"+user.getCalle()+"',"+user.getResto()+",'"+user.getPoblacion()+"',"+ user.getCp()+",'"+user.getPassword()+"')";
        /*try {
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
        } catch (Exception w) {

        }*/
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
        //PreparedStatement ps = null;
        //ResultSet rs = null;
        //String query = "SELECT email FROM USUARIO WHERE email = ?";
        /*try {
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
        }*/
        boolean res=false;
        String email="inic";
        try {
            Statement statement = connection.createStatement();
            ResultSet usuarios = statement.executeQuery("SELECT email FROM usuario");       
            while (usuarios.next()) {
         
                email = usuarios.getString(4);
                
                if(email==usuario.getEmail()) res=true;
    // procesar cada elemento del resultado de la consulta
            }
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return res;
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
