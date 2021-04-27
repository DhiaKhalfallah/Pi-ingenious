/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.CategorieOffre;
import Tools.MyConnection;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author RE flex
 */
public class CategorieCrud {
       
Connection c;

    public CategorieCrud() {
    MyConnection db=new MyConnection();
        c = db.getCnx();
    }

    public void addCategorieOffre(CategorieOffre cl) {
        try {
String requete = "INSERT INTO categorie_offre (id,nom,logo,color)"
                    + "VALUES (?,?,?,?)";
            PreparedStatement pst = c.prepareStatement(requete);
                        pst.setInt(1, cl.getId());

            pst.setString(3, cl.getNom());
            pst.setString(2, cl.getLogo());
            pst.setString(4, cl.getColor());
            pst.executeUpdate();
            System.out.println("CategorieOffre added !!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<CategorieOffre> ListEntite() {
        List<CategorieOffre> Mylist = new ArrayList<>();
        try {
            String requete = "select * from categorie_offre ";
            PreparedStatement pst = c.prepareStatement(requete);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CategorieOffre p = new CategorieOffre();
                p.setId(rs.getInt("Id"));
                p.setNom(rs.getString("Nom"));
                p.setLogo(rs.getString("Logo"));
                p.setColor(rs.getString("Color"));

                Mylist.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Mylist;
    }

    public void UpdateCategorieOffre(CategorieOffre cl) {
        try {
String requete = "UPDATE categorie_offre SET nom=? ,logo=?,color=? WHERE id=?";        
PreparedStatement pst = c.prepareStatement(requete);
             pst.setString(1,cl.getNom());
             pst.setString(2,cl.getLogo());
             pst.setString(3,cl.getColor()); 
             pst.setInt(4,cl.getId()); 
            pst.executeUpdate();
            System.out.println("CategorieOffre Updated !!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void DeleteCategorieOffre(int a) {
        try {
            String requete = "DELETE FROM categorie_offre WHERE id=?";
            PreparedStatement pst = c.prepareStatement(requete);
            pst.setInt(1, a);
            pst.executeUpdate();
            System.out.println("CategorieOffre Deleted !!!!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

   
    
    }
    
    
    
