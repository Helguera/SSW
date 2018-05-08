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
import servlets.ConnectionPool;

/**
 *
 * @author enriq_000
 */
public class AdminBD {
    
    public static boolean adminExists(Admin admin) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT email FROM ADMIN WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, admin.getEmail());
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

    public static Admin selectAdmin(String email) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM ADMIN WHERE email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            Admin admin = null;
            if (rs.next()) {
                admin = new Admin(); 
                
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return admin;
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

        String query = "SELECT password FROM ADMIN WHERE email = ?";
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
