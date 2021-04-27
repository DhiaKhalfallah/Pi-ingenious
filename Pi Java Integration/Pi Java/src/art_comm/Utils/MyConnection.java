/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author USER
 */
public class MyConnection {
    
       private static String HOST = "127.0.0.1";
        private static int PORT = 3306;
        private static String DB_NAME = "pidev";
        private static String USERNAME = "root";
        private static String PASSWORD = "";
        private static Connection connection ;
        private static MyConnection instance;
        private String url="jdbc:mysql://127.0.0.1:3306/pidev";
        private Connection cnx;
        public static Connection getConnection (){
        try {
            connection = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            return  connection;
        }
        
           public static MyConnection getInstance(){
       
       if(instance==null)
           instance=new MyConnection();
       return instance;
   }
             public Connection getCnx() {
        return cnx;
    }
  private MyConnection() {
        try {
            cnx=DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
