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
public class Impresora3d extends Producto{
    private String marca;
    private String modelo;
    private String tamaño;
    
    public Impresora3d(){
        super();
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setModelo(String modelo){
        this.modelo=modelo;
    }
    
    public void setTamaño(String tamaño){
        this.tamaño = tamaño;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getModelo(){
        return modelo;
    }
    
    public String getTamaño(){
        return tamaño;
    }
   
    
    
    
    
}
