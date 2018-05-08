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
public class Usuario implements Serializable{
    
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    //direccion
    private String calle;
    private String resto;
    private String poblacion;
    private String provincia;
    private String cp;
    
    
    //Constructor vacío
    public Usuario(){
        /*nombre="";
        apellidos="";
        email="";
        password="";
        calle="";
        resto="";
        poblacion="";
        provincia="";
        cp="";*/
    }
        
    
    //Setters
    public void setNombre(String n){
        this.nombre=n;
    }
    public void setApellidos(String a){
        this.apellidos=a;
    }
    
    public void setEmail(String e){
        this.email=e;
    }
    public void setPassword(String p){
        this.password=p;
    }
    public void setCalle(String c){
        this.calle=c;
    }
    public void setResto(String r){
        this.resto=r;
    }
    public void setPoblacion(String p){
        this.poblacion=p;
    }
    public void setProvicia(String prov){
        this.provincia=prov;
    }
    public void setCp(String cp){
        this.cp=cp;
    }
    
    
    //Getters
    public String getNombre(){
        return this.nombre;
    }
    public String getApellidos(){
        return this.apellidos;
    }
    
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getCalle(){
        return this.calle;
    }
    public String getResto(){
        return this.resto;
    }
    public String getPoblacion(){
        return this.poblacion;
    }
    public String getProvicia(){
        return this.provincia;
    }
    public String getCp(){
        return this.cp;
    }
    
    public boolean compruebaPass(String pass2){
        if (this.password.equals(pass2)){
           return true;
        }
        return false;
    }
    
    public boolean compruebaCampos(){
        if (this.nombre.equals("") || this.apellidos.equals("") || this.email.equals("") || this.password.equals("") || this.calle.equals("") || this.resto.equals("") || this.poblacion.equals("") || this.provincia.equals("") || this.cp.equals("")){
           return false;
        }
        return true;
    }
   
    
   

}
