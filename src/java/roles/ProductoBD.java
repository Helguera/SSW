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
                pr.setId_producto(rs.getInt("Id_producto"));
                pr.setPrecio(rs.getDouble("Precio"));
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
    public static ArrayList<Producto> getProductos() {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Producto> productos=new ArrayList<Producto>();
        String query = "SELECT * FROM PRODUCTOS P JOIN IMPRESORAS3D I ON P.ID_PRODUCTO=I.ID_PRODUCTO";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Impresora3d imp = new Impresora3d();
                imp.setId_producto(rs.getInt("id_producto"));
                imp.setPrecio(rs.getDouble("precio"));
                imp.setMarca(rs.getString("marca"));
                imp.setModelo(rs.getString("modelo"));
                imp.setTamaño(rs.getString("tamaño"));
                productos.add(imp);
            }
            rs.close();
            ps.close();
            //pool.freeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        query = "SELECT * FROM PRODUCTOS P JOIN CONSUMIBLES C ON P.ID_PRODUCTO=C.ID_PRODUCTO";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Consumible cons = new Consumible();
                cons.setId_producto(rs.getInt("id_producto"));
                cons.setPrecio(rs.getDouble("precio"));
                cons.setMarca(rs.getString("marca"));
                cons.setNombre(rs.getString("nombre"));
                productos.add(cons);
            }
            rs.close();
            ps.close();
            //pool.freeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        pool.freeConnection(connection);
        return productos;
        
    }
    
}
