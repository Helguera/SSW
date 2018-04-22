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
    private int code;
    private double precio;
    private String nombre;
    private String descripcion;
        
    //Constructor
    public Producto(){};
    
    //Setters
    
    public void setCode(int code){
        this.code=code;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
   
    
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setDescripcion(String des){
        this.descripcion=des;
    }
    
    
    
    //Getters
    public int getCode( ){
        return this.code;
    }
    public double getPrecio(){
        return this.precio;
    }
    
    public String getNombre( ){
        return this.nombre;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
}
