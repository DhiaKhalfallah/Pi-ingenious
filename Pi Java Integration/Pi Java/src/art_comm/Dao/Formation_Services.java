/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Dao;



import eventcrud.Entities.Formation;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.imageio.ImageIO;
import art_comm.Utils.MyConnection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Formation_Services {

    public Formation_Services() {
        MyConnection cs = MyConnection.getInstance();
        try {
            st = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Formation_Services getInstance() {
        if (instance == null) {
            instance = new Formation_Services();
        }
        return instance;
    }

    private Connection c = MyConnection.getConnection();
    private static Formation_Services instance;

    private Statement st;
    private ResultSet rs;

    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value 
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

//hedha khalih
    public void Ajouter(Formation t) throws SQLException {

        String query = "INSERT INTO `formation`( `idcategorie_id`, `nom`, `description`, `secteur`, `date`,  `datefin`,`prix`, `image`) VALUES (?,?,?,?,?,?,?,?)";

        PreparedStatement st;

        try {
            st = c.prepareStatement(query);
            st.setString(1, t.getCategorie());
            st.setString(2, t.getNom());

            st.setString(3, t.getDescription());
            st.setString(4, t.getSecteur());
            st.setDate(5, t.getDateDebut());

            st.setDate(6, t.getDateFin());
            st.setInt(7, t.getPrix());
            st.setString(8, t.getImage());

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
   
    public ObservableList<Formation> display() {
        String req="select * from formation";
        ObservableList<Formation> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Formation p=new Formation();
                p.setId(rs.getInt(1));
                p.setIdcategorie_id(rs.getInt(2));
                p.setNom(rs.getString(3));
                p.setSecteur(rs.getString(6));
                p.setDescription(rs.getString(5));
                
                p.setImage(rs.getString(9));
       
                p.setDateDebut(rs.getDate(7));
                p.setDateFin(rs.getDate(11));
                
                list.add(p)
                        ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int size() {
        String req="select * from formation";
        List<Formation> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Formation p=new Formation();
                p.setId(rs.getInt(1));
     
                
                p.setSecteur(rs.getString(6));
                p.setDescription(rs.getString(5));
                p.setNom(rs.getString(3));
                p.setImage(rs.getString(9));
       
                p.setDateDebut(rs.getDate(7));
                p.setDateFin(rs.getDate(11));
                                list.add(p)
                        ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }

    public int displayjanvier() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-01-01' AND '2021-01-31'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displayfevrier() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-02-01' AND '2021-02-28'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displaymars() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-03-01' AND '2021-03-31'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displayavril() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-04-01' AND '2021-04-30'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displaymai() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-05-01' AND '2021-05-31'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displayjuin() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-06-01' AND '2021-06-30'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displayjuillet() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-07-01' AND '2021-07-31'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displayaout() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-08-01' AND '2021-08-31'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displayseptember() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-09-01' AND '2021-09-30'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displayoctobre() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-10-01' AND '2021-10-31'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displaynovembre() {
        int x;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-11-01' AND '2021-11-30'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));

                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public int displaydecembre() {
        int x = 0;
        x = 0;
        String req = "select * from formation  WHERE date BETWEEN '2021-12-01' AND '2021-12-31'";
        ObservableList<Formation> list = FXCollections.observableArrayList();

        try {
            rs = st.executeQuery(req);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDateDebut(rs.getDate(4));
                list.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        x = list.size();

        return x;
    }

    public void update(int i) {
        PreparedStatement st;

        String req = "UPDATE `formation` SET `status`=? WHERE id=?";
        int d = 1;
        try {
            st = c.prepareStatement(req);
            st.setInt(1,d);
            st.setInt(2,i);

            st.executeUpdate();
            System.out.println("Successful");

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public ObservableList<Formation> read() throws SQLException {
        ObservableList<Formation> ls = FXCollections.observableArrayList();
        String req = "SELECT * FROM `formation` ";
       try {
            rs = st.executeQuery(req);
            while (rs.next()) {
               
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setSecteur(rs.getString(3));
                p.setDescription("description");
                p.setDateDebut(rs.getDate("date"));
                p.setDateFin(rs.getDate("datefin"));
                ls.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Formation_Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }
}
