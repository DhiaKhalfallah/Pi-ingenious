/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.Dao;
import com.pi.Entities.Reclamation;
import com.pi.Utils.ConnexionSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dhia
 */
public class ReclamationDao implements Idao<Reclamation>{

 private static ReclamationDao instance;
    private Statement st;
    private ResultSet rs;
    
        
    public ReclamationDao() {
            ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
         public static ReclamationDao getInstance(){
        if(instance==null) 
        instance=new ReclamationDao();
        return instance;
    }

    @Override
    public void insert(Reclamation o) {
 String req="insert into reclamation (user_id,user_email,subject,claim,submit_date,cstatus) values ('"+o.getUser_id()+"','"+o.getUser_email()+"','"+o.getSubject()+"','"+o.getClaim()+"','"+o.getSubmit_date()+"','"+o.getCstatus()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

    @Override
    public void delete(Reclamation o) {
String req="delete from reclamation where id="+o.getId();

        Reclamation p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("la reclamation n'existe pas");    }

    @Override
    public ObservableList<Reclamation> displayAll() {
String req="select * from reclamation";
        ObservableList<Reclamation> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Reclamation p=new Reclamation();
                p.setId(rs.getInt(1));
                p.setUser_id(rs.getInt(2));
                p.setUser_email(rs.getString(3));
                p.setSubject(rs.getString(4));
                p.setClaim(rs.getString(5));
                p.setSubmit_date(rs.getString(6));
                p.setCstatus(rs.getInt(7));
 
               
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;    }

    @Override
    public Reclamation displayById(int id) {
        
        String req="select * from reclamation where id ="+id;
           Reclamation p=new Reclamation();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt(1));
                p.setUser_id(rs.getInt(2));
                p.setUser_email(rs.getString(3));
                p.setSubject(rs.getString(4));
                p.setClaim(rs.getString(5));
                p.setSubmit_date(rs.getString(6));
                p.setCstatus(rs.getInt(7));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;     
    }

    @Override
    public boolean update(Reclamation os) {
        throw new UnsupportedOperationException("No option to update Claims."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     public ObservableList<Reclamation> displayBySession(int id) {
        
        String req="select * from reclamation where user_id ="+id;
          
                   ObservableList<Reclamation> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
           
             Reclamation p=new Reclamation();
                p.setId(rs.getInt(1));
                p.setUser_id(rs.getInt(2));
                p.setUser_email(rs.getString(3));
                p.setSubject(rs.getString(4));
                p.setClaim(rs.getString(5));
                p.setSubmit_date(rs.getString(6));
                p.setCstatus(rs.getInt(7));
                                list.add(p);

            }  
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;     
    }
         



    
    
}
