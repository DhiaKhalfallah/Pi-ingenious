/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Dao;

import art_comm.Entities.Participant;
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
 * @author LEGION
 */
public class ParticipantDao implements Idao<Participant> {
        
    private static ParticipantDao instance;
    private Statement st;
    private ResultSet rs;

    public ParticipantDao() {
         ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static ParticipantDao getInstance(){
        if(instance==null) 
            instance=new ParticipantDao();
        return instance;
    }

    @Override
    public void insert(Participant o) {
         String req="insert into participant (user,eventid,date,nom,mail,mobile) values ('"+o.getUser()+"','"+o.getEventid()+"','"+o.getDate()+"','"+o.getNom()+"','"+o.getMail()+"','"+o.getMobile()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Participant o) {
        String req="delete from participant where id="+o.getId();
        Participant p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }

    @Override
    public ObservableList<Participant> displayAll() {
         String req="select * from participant";
        ObservableList<Participant> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Participant p=new Participant();
                p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setEventid(rs.getInt(3));
                p.setDate(rs.getString(4));
                p.setNom(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setMobile(rs.getInt(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
 public List<Participant> displayAllList() {
        String req="select * from participant";
        List<Participant> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Participant p=new Participant();
                 p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setEventid(rs.getInt(3));
                p.setDate(rs.getString(4));
                p.setNom(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setMobile(rs.getInt(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Participant displayById(int id) {
         String req="select * from participant where id ="+id;
           Participant p=new Participant();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
            p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setEventid(rs.getInt(3));
                p.setDate(rs.getString(4));
                p.setNom(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setMobile(rs.getInt(7));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }
    @Override
    public boolean update(Participant p) {
             String qry = "UPDATE participant SET id = '"+p.getId()+"', user = '"+p.getUser()+"', eventid = '"+p.getEventid()+"', date = '"+p.getDate()+"', nom = '"+p.getNom()+"', mail = '"+p.getMail()+"', mobile = '"+p.getMobile()+"' WHERE id = "+p.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
    }
    
     public ObservableList<Participant> displayAllup() {
         String req="select * from participant order by date asc";
        ObservableList<Participant> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Participant p=new Participant();
                p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setEventid(rs.getInt(3));
                p.setDate(rs.getString(4));
                p.setNom(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setMobile(rs.getInt(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      public ObservableList<Participant> displayAlldown() {
         String req="select * from participant order by date desc";
        ObservableList<Participant> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Participant p=new Participant();
                p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                p.setEventid(rs.getInt(3));
                p.setDate(rs.getString(4));
                p.setNom(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setMobile(rs.getInt(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ParticipantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
