/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.Entities;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Dhia
 */
public class Admin extends User {

    public Admin(int id, String email, String password, int type, String roles, String typeC, int status, String ver_token, String passchange) {
        super(id, email, password, type, roles, typeC, status, ver_token, passchange);
    }
    
    
}
