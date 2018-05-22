/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import java.io.Serializable;

/**
 *
 * @author josealbertodelval
 */
public class Archivo implements Serializable{
    private String ruta;
    private String description;
    private String usuario;
    
    //Constructor
    public Archivo(){};
    
    
    //Setters
    public void setRuta(String ruta){
        this.ruta=ruta;
    }
    
    public void setDescription(String n){
        this.description=n;
    }
    public void setUsuario(String u){
        this.usuario=u;
    }
    
    
    
    String getDescription() {
        return this.description;
    }

    

    String getRuta() {
        return this.ruta;
    }

    String getUsuario() {
        return this.usuario;
    }

    
    
}
