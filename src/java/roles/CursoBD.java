/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import java.sql.*;
import java.util.ArrayList;
import servlets.*;
/**
 *
 * @author enriq_000
 */
public class CursoBD {
    
    /*public static int insert(Curso curso){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        String query = "insert into curso (code, nombre, precio) "
                + "VALUES('"+curso.getCode()+"','"+curso.getNombre()+"','"+curso.getPrecio()+"')";
        //String query = "insert into usuario values ('"+user.getNombre()+"','"+user.getApellidos()+"','"+user.getEmail()+"','"+user.getCalle()+"',"+user.getResto()+",'"+user.getPoblacion()+"',"+ user.getCp()+",'"+user.getPassword()+"')";
        try {
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate(query);
        } catch (Exception w) {

        }
        
    
        try {
            
            //Preparamos el query
            
            ps = connection.prepareStatement(query);
            ps.setInt(1, curso.getCode());
            ps.setString(2, curso.getNombre());
            //Ejecutamos el query
            
            int res = ps.executeUpdate();
            ps.close();
            pool.freeConnection(connection);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
         
    }*/
    
    public static boolean cursoExists(Curso curso) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT nombre FROM Curso WHERE nombre = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, curso.getNombre());
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
    
    /*public static Curso selectCurso(String nombre) {
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
    }*/

    public static ArrayList<Curso> getCursos() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Curso> cursos=new ArrayList<Curso>();
        String query = "SELECT * FROM CURSOS";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Curso c = new Curso();
                c.setCode(rs.getInt("id_curso"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setNombre(rs.getString("nombre"));
                
                cursos.add(c);
            }
            rs.close();
            ps.close();
            pool.freeConnection(connection);
            return cursos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
