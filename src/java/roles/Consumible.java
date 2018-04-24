/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

/**
 *
 * @author javier
 */
public class Consumible extends Producto {
    private String nombre;
    private String marca;
    
    public Consumible(){
        super();
    }
    
    
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setMarca(String m){
        this.marca=m;
    }
   

    //Getters
    
    public String getNombre(){
        return this.nombre;
    }
    public String getMarca(){
        return this.marca;
    }
}
