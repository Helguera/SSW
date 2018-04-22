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
public class Admin implements Serializable{
     private String email;
     private String password;
        
    //Constructor
    public Admin(){};
    
    //Setters
    
    public void setEmail(String email){
        this.email=email;
    }
   
    
    public void setPassword(String pass){
        this.password=pass;
    }
    
    
    
    //Getters
    public String getEmail( ){
        return this.email;
    }
    
    public String getPassword( ){
        return this.password;
    }
    
}
