/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Dao;

import art_comm.Entities.Commentaire;
import art_comm.Utils.ConnexionSingleton;
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
 * @author LEGION
 */
public class CommentaireDao implements Idao<Commentaire> {
 private static CommentaireDao instance;
    private Statement st;
    private ResultSet rs;

    public CommentaireDao() {
         ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static CommentaireDao getInstance(){
        if(instance==null) 
            instance=new CommentaireDao();
        return instance;
    }
    
    @Override
    public void insert(Commentaire o) {
        
          String req="insert into commentaire (user,nom,mail,subject,mobile,commentaire,date,blog_id,rate) values ('"+o.getUser()+"','"+o.getNom()+"','"+o.getMail()+"','"+o.getSubject()+"','"+o.getMobile()+"','"+o.getCommentaire()+"','"+o.getDate()+"','"+o.getBlog_id()+"','"+o.getRate()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Commentaire o) {
         String req="delete from commentaire where id="+o.getId();
        Commentaire p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
        
    }

    @Override
    public ObservableList<Commentaire> displayAll() {
String req="select * from commentaire";
        ObservableList<Commentaire> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Commentaire p=new Commentaire();
                p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setNom(rs.getString(3));
                p.setMail(rs.getString(4));
                p.setSubject(rs.getString(5));
                p.setMobile(rs.getInt(6));
                p.setCommentaire(rs.getString(7));
                p.setDate(rs.getString(8));
                p.setBlog_id(rs.getInt(9));
                p.setRate(rs.getInt(10));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public List<Commentaire> displayAllList() {
        String req="select * from commentaire";
        List<Commentaire> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Commentaire p=new Commentaire();
             p.setId(rs.getInt(1));
                              p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setNom(rs.getString(3));
                p.setMail(rs.getString(4));
                p.setMobile(rs.getInt(5));
                p.setCommentaire(rs.getString(6));
                p.setDate(rs.getString(7));
                p.setBlog_id(rs.getInt(8));
                p.setRate(rs.getInt(9));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Commentaire displayById(int id) {
String req="select * from commentaire where id ="+id;
           Commentaire p=new Commentaire();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
       p.setId(rs.getInt(1));
             p.setId(rs.getInt(1));
                              p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setNom(rs.getString(3));
                p.setMail(rs.getString(4));
                p.setMobile(rs.getInt(5));
                p.setCommentaire(rs.getString(6));
                p.setDate(rs.getString(7));
                p.setBlog_id(rs.getInt(8));
                p.setRate(rs.getInt(9));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;    }

    @Override
    public boolean update(Commentaire os) {
      String qry = "UPDATE commentaire SET user = '"+os.getUser()+"', nom = '"+os.getNom()+"', mail = '"+os.getMail()+"', subject = '"+os.getSubject()+"', mobile = '"+os.getMobile()+"', commentaire = '"+os.getCommentaire()+"', date = '"+os.getDate()+"', blog_id = '"+os.getBlog_id()+"', rate = '"+os.getRate()+"',id = '"+os.getId()+"' WHERE id = "+os.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        public List<Commentaire> displayAllup() {
String req="select * from commentaire order by date asc";
        ObservableList<Commentaire> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Commentaire p=new Commentaire();
                p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setNom(rs.getString(3));
                p.setMail(rs.getString(4));
                p.setSubject(rs.getString(5));
                p.setMobile(rs.getInt(6));
                p.setCommentaire(rs.getString(7));
                p.setDate(rs.getString(8));
                p.setBlog_id(rs.getInt(9));
                p.setRate(rs.getInt(10));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
            public List<Commentaire> displayAllDown() {
String req="select * from commentaire order by date desc";
        ObservableList<Commentaire> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Commentaire p=new Commentaire();
                p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setNom(rs.getString(3));
                p.setMail(rs.getString(4));
                p.setSubject(rs.getString(5));
                p.setMobile(rs.getInt(6));
                p.setCommentaire(rs.getString(7));
                p.setDate(rs.getString(8));
                p.setBlog_id(rs.getInt(9));
                p.setRate(rs.getInt(10));
                
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    
    }
    
    

