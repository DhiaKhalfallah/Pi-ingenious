/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.Dao;
import user_rec.Entities.Entreprise;
import user_rec.Utils.ConnexionSingleton;
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
public class EntrepriseDao implements Idao<Entreprise> {
    
        private static EntrepriseDao instance;
    private Statement st;
    private ResultSet rs;
    
        
    public EntrepriseDao() {
            ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
         public static EntrepriseDao getInstance(){
        if(instance==null) 
        instance=new EntrepriseDao();
        return instance;
    }

    @Override
    public void insert(Entreprise o) {
        int idvalue=0; 
     String req="insert into user (email,password,type,roles,typeC,status,ver_token,passchange) values ('"+o.getEmail()+"','"+o.getPassword()+"','"+o.getType()+"','"+o.getRoles()+"','"+o.getTypeC()+"','"+o.getStatus()+"','"+o.getVer_token()+"','"+o.getPasschange()+"')";
        try {
            st.executeUpdate(req);

        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        //next
        String req1="SELECT * FROM user ORDER BY ID DESC LIMIT 1";
        try {
            rs=st.executeQuery(req1);
             while (rs.next()) {
             idvalue=rs.getInt(1);
             System.out.println(idvalue);
             }
        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //entre
             String req2="insert into entreprise (id,nom,about,adresse,tel,siteweb,twitter,linkdin,facebook,profil_pic) values ('"+idvalue+"','"+o.getNom()+"','"+o.getAbout()+"','"+o.getAdresse()+"','"+o.getTel()+"','"+o.getSiteweb()+"','"+o.getTwitter()+"','"+o.getLinkdin()+"','"+o.getFacebook()+"','"+o.getProfile_pic()+"')";

         try {
            st.executeUpdate(req2);

        } catch (SQLException ex) {
            Logger.getLogger(CandidateDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    }

    @Override
    public void delete(Entreprise o) {
     String req1="delete from user where id="+o.getId();
        String req="delete from entreprise where id="+o.getId();

        Entreprise p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
            st.executeUpdate(req1);
             
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("l'utilisateur n'existe pas");    }

    @Override
    public ObservableList<Entreprise> displayAll() {
 String req="select * from entreprise";
        ObservableList<Entreprise> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Entreprise p=new Entreprise();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setAbout(rs.getString(3));
                p.setAdresse(rs.getString(4));
                p.setTel(rs.getInt(5));
                p.setSiteweb(rs.getString(6));
                p.setTwitter(rs.getString(7));
                p.setLinkdin(rs.getString(8));
                p.setFacebook(rs.getString(9));
                p.setProfile_pic(rs.getString(10));
                

      
                
               
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Entreprise displayById(int id) {
String req="select * from entreprise where id ="+id;
           Entreprise p=new Entreprise();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                               p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setAbout(rs.getString(3));
                p.setAdresse(rs.getString(4));
                p.setTel(rs.getInt(5));
                p.setSiteweb(rs.getString(6));
                p.setTwitter(rs.getString(7));
                p.setLinkdin(rs.getString(8));
                p.setFacebook(rs.getString(9));
                p.setProfile_pic(rs.getString(10));
               
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;         }

    @Override
    public boolean update(Entreprise os) {
    String qry = "UPDATE entreprise SET nom='"+os.getNom()+"',  about='"+os.getAbout()+"', adresse='"+os.getAdresse()+"', tel='"+os.getTel()+"', siteweb='"+os.getSiteweb()+"', twitter='"+os.getTwitter()+"', linkdin='"+os.getLinkdin()+"', facebook='"+os.getFacebook()+"', profil_pic='"+os.getProfile_pic()+"' WHERE id = "+os.getId();
        
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
