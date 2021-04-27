/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.Entities;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Dhia
 */
public abstract class User {
    private SimpleIntegerProperty id ;
    private SimpleStringProperty email ; 
    private SimpleStringProperty password ;
    private SimpleIntegerProperty type ;
    private SimpleStringProperty roles ;
    private SimpleStringProperty typeC   ; 
    private SimpleIntegerProperty status ;
    private SimpleStringProperty ver_token  ;
    private SimpleStringProperty passchange   ;
    
//constructors
    public User(){

    }
    public User(int id, String email, String password, int type, String roles, String typeC, int status, String ver_token, String passchange) {
        this.id = new SimpleIntegerProperty(id);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.type = new SimpleIntegerProperty(type);
        this.roles = new SimpleStringProperty(roles);
        this.typeC = new SimpleStringProperty(typeC);
        this.status = new SimpleIntegerProperty(status);
        this.ver_token = new SimpleStringProperty(ver_token);
        this.passchange = new SimpleStringProperty(passchange);
    }
        public User(String email, String password, int type, String roles, String typeC, int status, String ver_token, String passchange) {
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.type = new SimpleIntegerProperty(type);
        this.roles = new SimpleStringProperty(roles);
        this.typeC = new SimpleStringProperty(typeC);
        this.status = new SimpleIntegerProperty(status);
        this.ver_token = new SimpleStringProperty(ver_token);
        this.passchange = new SimpleStringProperty(passchange);
    }
        public User(int id )
                {
                            this.id = new SimpleIntegerProperty(id);

                }
    //getters property

    public SimpleIntegerProperty getIdP() {
        return id;
    }

    public SimpleStringProperty getEmailP() {
        return email;
    }

    public SimpleStringProperty getPasswordP() {
        return password;
    }

    public SimpleIntegerProperty getTypeP() {
        return type;
    }

    public SimpleStringProperty getRolesP() {
        return roles;
    }

    public SimpleStringProperty getTypeCP() {
        return typeC;
    }

    public SimpleIntegerProperty getStatusP() {
        return status;
    }

    public SimpleStringProperty getVer_tokenP() {
        return ver_token;
    }

    public SimpleStringProperty getPasschangeP() {
        return passchange;
    }
    
    //getters 

    public int getId() {
        return id.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPassword() {
        return password.get();
    }

    public int getType() {
        return type.get();
    }

    public String getRoles() {
        return roles.get();
    }

    public String getTypeC() {
        return typeC.get();
    }

    public int getStatus() {
        return status.get();
    }

    public String getVer_token() {
        return ver_token.get();
    }

    public String getPasschange() {
        return passchange.get();
    }
    
    //setters 

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }
        public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public void setEmail(SimpleStringProperty email) {
        this.email = email;
    }
        public void setEmail(String email) {
        this.email = new SimpleStringProperty(email);
    }


    public void setPassword(SimpleStringProperty password) {
        this.password = password;
    }
    
    public void setPassword(String password) {
        this.password = new SimpleStringProperty(password);
    }

    public void setType(SimpleIntegerProperty type) {
        this.type = type;
    }
       public void setType(int type) {
        this.type = new SimpleIntegerProperty(type);
    }

    public void setRoles(SimpleStringProperty roles) {
        this.roles = roles;
    }
        public void setRoles(String roles) {
        this.roles = new SimpleStringProperty(roles);
    }


    public void setTypeC(SimpleStringProperty typeC) {
        this.typeC = typeC;
    }
    
    public void setTypeC(String typeC) {
        this.typeC = new SimpleStringProperty(typeC);
    }

    public void setStatus(SimpleIntegerProperty status) {
        this.status = status;
    }
        public void setStatus(int status) {
        this.status = new SimpleIntegerProperty(status);
    }

    public void setVer_token(SimpleStringProperty ver_token) {
        this.ver_token = ver_token;
    }

    public void setVer_token(String ver_token) {
        this.ver_token = new SimpleStringProperty(ver_token);
    }
    public void setPasschange(SimpleStringProperty passchange) {
        this.passchange = passchange;
    }
        public void setPasschange(String passchange) {
        this.passchange = new SimpleStringProperty(passchange);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", password=" + password + ", type=" + type + ", roles=" + roles + ", typeC=" + typeC + ", status=" + status + ", ver_token=" + ver_token + ", passchange=" + passchange + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
        
    
    
    
    

    
    
    
        

    
    
    
}
