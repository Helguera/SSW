package roles;

import java.io.Serializable;
import java.util.Date;

public class Curso implements Serializable{
    
    private int code;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private float precio;
        
    
    //Constructor
    public Curso(){};
    
    
    //Setters
    public void setCode(int code){
        this.code=code;
    }
   
    public void setNombre(String n){
        this.nombre=n;
    }
    
    public void setDescripcion(String d){
        this.descripcion = d;
    }
    
    public void setFecha(Date f){
        this.fecha = f;
    }
    
    public void setPrecio(float p){
        this.precio = p;
    }
    
    
    //Getters
    public int getCode( ){
        return this.code;
    }
    
    public String getNombre( ){
        return this.nombre;
    }
    
    public String getDescripcion( ){
        return this.descripcion;
    }
    
    public Date getFecha(){
        return this.fecha;
    }
    
    public float getPrecio(){
        return this.precio;
    }
}
