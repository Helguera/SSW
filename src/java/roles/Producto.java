package roles;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josealbertodelval
 */
public class Producto implements Serializable{
    private int id_producto;
    private double precio;
    
        
    //Constructor
    public Producto(){};
    
    //Setters
    
    public void setId_producto(int id_producto){
        this.id_producto=id_producto;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
   

    //Getters
    public int getId_producto(){
        return this.id_producto;
    }
    public double getPrecio(){
        return this.precio;
    }
   
}
