/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.Dao;

import com.pi.Entities.Candidate;
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
public class CandidateDao implements Idao<Candidate> {
    private static CandidateDao instance;
    private Statement st;
    private ResultSet rs;
    
    
    public CandidateDao() {
            ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static CandidateDao getInstance(){
        if(instance==null) 
            instance=new CandidateDao();
        return instance;
    }

    @Override
    public void insert(Candidate o) {
        int idvalue=0;  
        String req="insert into user (email,password,type,roles,typeC,status,ver_token,passchange) values ('"+o.getEmail()+"','"+o.getPassword()+"','"+o.getType()+"','"+o.getRoles()+"','"+o.getTypeC()+"','"+o.getStatus()+"','"+o.getVer_token()+"','"+o.getPasschange()+"')";
        try {
            st.executeUpdate(req);

        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //next
        String req1="SELECT * FROM user ORDER BY ID DESC LIMIT 1";
        try {
            rs=st.executeQuery(req1);
             while (rs.next()) {
             idvalue=rs.getInt(1);
             }
        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //candidate 
       String req3="insert into candidate (id,nom,prenom,pays,gouvernorat,adresse,birthday,profile_pic,cv,about_you,tel,code_postal) values ('"+idvalue+"','"+o.getNom()+"','"+o.getPrenom()+"','"+o.getPays()+"','"+o.getGouvernorat()+"','"+o.getAdresse()+"','"+o.getBirthday()+"','"+o.getProfile_pic()+"','"+o.getCv()+"','"+o.getAbout_you()+"','"+o.getTel()+"','"+o.getCode_postal()+"')";
 try {
            st.executeUpdate(req3);

        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Candidate o) {
     String req="delete from Candidate where id="+o.getId();
     String req1="delete from User where id="+o.getId();

        Candidate p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
            st.executeUpdate(req1);
             
        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("l'utilisateur n'existe pas");
            }
    

    @Override
    public ObservableList<Candidate> displayAll() {
       String req="select * from Candidate";
        ObservableList<Candidate> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Candidate p=new Candidate();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setTel(rs.getInt(4));
                p.setPays(rs.getString(5));
                p.setGouvernorat(rs.getString(6));
                p.setAdresse(rs.getString(7));
                p.setCode_postal(rs.getInt(8));
                p.setBirthday(rs.getString(9));
                p.setProfile_pic(rs.getString(10));
                p.setCv(rs.getString(11));
                p.setAbout_you(rs.getString(12));
      
                
               
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Candidate displayById(int id) {
String req="select * from Candidate where id ="+id;
           Candidate p=new Candidate();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setTel(rs.getInt(4));
                p.setPays(rs.getString(5));
                p.setGouvernorat(rs.getString(6));
                p.setAdresse(rs.getString(7));
                p.setCode_postal(rs.getInt(8));
                p.setBirthday(rs.getString(9));
                p.setProfile_pic(rs.getString(10));
                p.setCv(rs.getString(11));
                p.setAbout_you(rs.getString(12));
               
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;      }

    @Override
    public boolean update(Candidate os) {
             String qry = "UPDATE Candidate SET nom='"+os.getNom()+"', prenom='"+os.getPrenom()+"', tel='"+os.getTel()+"', pays='"+os.getPays()+"', gouvernorat='"+os.getGouvernorat()+"', adresse='"+os.getAdresse()+"', code_postal='"+os.getCode_postal()+"', profile_pic='"+os.getProfile_pic()+"', cv='"+os.getCv()+"', about_you='"+os.getAbout_you()+"' WHERE id = "+os.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   
    }
    
        public Candidate authenticateUser(String Email,String Password) {
          String req="select id,password,email,ver_token from user where email ='"+Email+"' ";
           int id=0 ; 
          Candidate p=new Candidate();

        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                id=rs.getInt(1);
                p.setPassword(rs.getString(2));
                p.setEmail(rs.getString(3));
                p.setVer_token(rs.getString(4));

            //}  
        } catch (SQLException ex) {
            System.out.println("No user found");
        }
        //Candidate 
        String req1="select * from Candidate where id ="+id;

         try {
             
            rs=st.executeQuery(req1);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrenom(rs.getString(3));
                p.setTel(rs.getInt(4));
                p.setPays(rs.getString(5));
                p.setGouvernorat(rs.getString(6));
                p.setAdresse(rs.getString(7));
                p.setCode_postal(rs.getInt(8));
                p.setBirthday(rs.getString(9));
                p.setProfile_pic(rs.getString(10));
                p.setCv(rs.getString(11));
                p.setAbout_you(rs.getString(12));
               
            //}  
        } catch (SQLException ex) {
 System.out.println("No user found");
        }
        
    return p;     
        
        }
        
    public boolean ResetPass(String Email,String Token) {
      String qry = "UPDATE user SET  passchange='"+Token+"' WHERE email='"+Email+"' " ;
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;   

    }
    
}
