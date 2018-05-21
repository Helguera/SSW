package roles;

import java.io.Serializable;

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
