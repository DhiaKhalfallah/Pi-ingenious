/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.services;

import entities.Offre;
import Tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import art_comm.Controllers.BackOffre;

/**
 *
 * @author RE flex
 */
public class OffreCrud {
      
Connection c;

    public OffreCrud() {
    MyConnection db=new MyConnection();
        c = db.getCnx();
    }

    public void addOffre( Offre cl) {
        try {
String requete = "INSERT INTO offre (id,idcategorie_id,nom , email , logo , title , description )"
                    + "VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(requete);
            pst.setInt(1, cl.getId());
            pst.setInt(2, cl.getCategorie());
            pst.setString(3, cl.getEmail());
            pst.setString(4, cl.getlogo());
            pst.setString(5, cl.getTitle());
            pst.setString(6, cl.getDescription());
            pst.setString(7, cl.getNom());
            pst.executeUpdate();
            System.out.println("Offre added !!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Offre> ListEntite() {
        List<Offre> Mylist = new ArrayList<>();
        try {
            String requete = "select * from Offre ";
            PreparedStatement pst = c.prepareStatement(requete);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Offre p = new Offre();
                p.setId(rs.getInt("Id"));
                p.setCategorie(rs.getInt("idcategorie_id"));
                p.setNom(rs.getString("Nom"));
                p.setEmail(rs.getString("Email"));
                p.setLogo(rs.getString("Logo"));
                p.setTitle(rs.getString("Title"));
                p.setDescription(rs.getString("Description"));
                
                Mylist.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Mylist;
    }
 public ObservableList<Offre> GetOffre() {
      ObservableList<Offre> 
       Mylist=FXCollections.observableArrayList();
        try {
            String requete = "select * from Offre ";
            PreparedStatement pst = c.prepareStatement(requete);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Offre p = new Offre();
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("Nom"));
                p.setLogo(rs.getString("Email"));
                p.setLogo(rs.getString("Logo"));
                p.setTitle(rs.getString("Title"));
                p.setDescription(rs.getString("Description"));
                p.setCategorie(rs.getInt("idcategorie_id"));
                Mylist.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Mylist;
    }
  public int OffreSize() {
      ObservableList<Offre> 
       Mylist=FXCollections.observableArrayList();
        try {
            String requete = "select * from Offre ";
            PreparedStatement pst = c.prepareStatement(requete);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Offre p = new Offre();
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("Nom"));
                p.setLogo(rs.getString("Email"));
                p.setLogo(rs.getString("Logo"));
                p.setTitle(rs.getString("Title"));
                p.setDescription(rs.getString("Description"));
                p.setCategorie(rs.getInt("idcategorie_id"));
                Mylist.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Mylist.size();
    }

    public void UpdateOffre(Offre cl) {
        try {
String requete = "UPDATE Offre SET nom=? , email=? , logo=? ,title=?,`description=? , idcategorie_id=? WHERE id=?";        
PreparedStatement pst = c.prepareStatement(requete);
            pst.setInt(1,cl.getId()); 
            pst.setString(2, cl.getNom());
            pst.setString(3, cl.getEmail());
            pst.setString(4, cl.getlogo());
            pst.setString(5, cl.getTitle());
            pst.setString(6, cl.getDescription());
            pst.setInt(7, cl.getCategorie());
            pst.executeUpdate();
            System.out.println("Offre Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void DeleteOffre(int a) {
        try {
            String requete = "DELETE FROM Offre WHERE id=?";
            PreparedStatement pst = c.prepareStatement(requete);
            pst.setInt(1, a);
            pst.executeUpdate();
            System.out.println("Offre Deleted !!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }


   

    
    }
    
    
    
