/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author RE flex
 */
public class MyConnection {
    
    public String url="jdbc:mysql://localhost:3306/pidev";
    public String user="root";
    public String pwd="";
    public static MyConnection instance;
    
    Connection cnx;
    public MyConnection() {
        
        try {
            cnx = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static MyConnection getInstance() {
        if(instance == null){
            instance = new MyConnection();
        }
        return instance;
    }
    
}