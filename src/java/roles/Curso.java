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
public class Curso implements Serializable{
    
    
    private int code;
    private String nombre;
    private double precio;
        
    //Constructor
    public Curso(){};
    
    //Setters
    
    public void setCode(int code){
        this.code=code;
    }
   
    
    public void setNombre(String n){
        this.nombre=n;
    }
    
    public void setPrecio(double precio){
        this.precio = precio;
    }
    
    
    
    //Getters
    public int getCode( ){
        return this.code;
    }
    
    public String getNombre( ){
        return this.nombre;
    }
    
    public double getPrecio( ){
        return this.precio;
    }
    
}
