/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Dao;
import art_comm.Entities.Event;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
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
public class EventDao implements Idao<Event> {
     private static EventDao instance;
    private Statement st;
    private ResultSet rs;

    public EventDao() {
          ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public static EventDao getInstance(){
        if(instance==null) 
            instance=new EventDao();
        return instance;
    }

    @Override
    public void insert(Event o) {
         String req="insert into event (lieu,entreprise_id,nbr,par_id,ent_id,date,description,nom,image,categorie,datefin,backcolor,bordercolor,textcolor) values ('"+o.getLieu()+"','"+o.getEntreprise_id()+"','"+o.getNbr()+"','"+o.getPar_id()+"','"+o.getent_id()+"','"+o.getDate()+"','"+o.getdescription()+"','"+o.getNom2()+"','"+o.getImage()+"','"+o.getCategorie()+"','"+o.getDatef()+"','"+o.getBackcolor()+"','"+o.getBordercolor()+"','"+o.getTextcolor()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Event o) {
         String req="delete from event where id="+o.getId();
        Event p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }
 public void qrcode() {
        String req="select* from event";

        try {
            rs=st.executeQuery(req);
            while(rs.next()){      
                EventDao.generate_qr(rs.getString("description"),rs.getString("nom"));;

              

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public ObservableList<Event> displayAll() {
        String req="select * from event";
        ObservableList<Event> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){      

                Event p=new Event();
                p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));

                list.add(p)
                        ;

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Event> displayAllList() {
        String req="select * from event";
        List<Event> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));

                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    	public static void generate_qr(String image_name,String qrCodeData) {
        try {
            String filePath = "C:\\Users\\Dhia\\Desktop\\Pi Java Integration\\Pi Java\\src\\com\\QRCODE"+image_name+".png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

        public ObservableList<Event> today() {
        String req="SELECT * FROM `event` where date = CURDATE()";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
            public ObservableList<Event> month() {
        String req="SELECT * FROM `event`WHERE MONTH(datefin) = MONTH(CURRENT_DATE())";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
                public ObservableList<Event> upcoming() {
        String req="SELECT * FROM `event` where date > CURDATE()";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public int sizeEvent() {
        String req="select * from event";
        List<Event> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }
     public int sizeEventT() {
        String req="SELECT * FROM `event` where date = CURDATE()";
        List<Event> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }
          public int sizeEventM() {
        String req="SELECT * FROM `event`WHERE MONTH(datefin) = MONTH(CURRENT_DATE())";
        List<Event> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }
               public int sizeEventU() {
        String req="SELECT * FROM `event` where date > CURDATE()";
        List<Event> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
               Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }
    @Override
    public Event displayById(int id) {
          String req="select * from event where id ="+id;
           Event p=new Event();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                    p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }

    @Override
    public boolean update(Event p) {
            String qry = "UPDATE event SET id = '"+p.getId()+"', lieu = '"+p.getLieu()+"', entreprise_id = '"+p.getEntreprise_id()+"', nbr = '"+p.getNbr()+"',par_id = '"+p.getPar_id()+"', ent_id = '"+p.getent_id()+"', date = '"+p.getDate()+"', description = '"+p.getdescription()+"', nom = '"+p.getNom2()+"', image = '"+p.getImage()+"', categorie = '"+p.getCategorie()+"', datefin = '"+p.getDatef()+"' WHERE id = "+p.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public boolean updatepar(int x,int y) {
        
            String qry = "UPDATE event SET par_id ='"+y+"' WHERE id = "+x;
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        public boolean updatplacesub(int x,int y) {
        
            String qry = "UPDATE event SET nbr ='"+y+"' WHERE id = "+x;
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public ObservableList<Event> displayAllup() {
        String req="select * from event order by date asc";
        ObservableList<Event> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p)
                        ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ObservableList<Event> displayAllDown() {
        String req="select * from event order by date desc";
        ObservableList<Event> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p)
                        ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     public int displayjanvier() {
                int x;
         String req="select * from event  WHERE date BETWEEN '2021-01-01' AND '2021-01-31'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                                  p.setId(rs.getInt(1));
               p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                       public int displayfevrier() {
                           int x;
         String req="select * from event  WHERE date BETWEEN '2021-02-01' AND '2021-02-28'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                public int displaymars() {
                    int x;
         String req="select * from event  WHERE date BETWEEN '2021-03-01' AND '2021-03-31'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                     p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                           public int displayavril() {
int x;
         String req="select * from event  WHERE date BETWEEN '2021-04-01' AND '2021-04-30'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                                  p.setId(rs.getInt(1));
                   p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                         x=list.size();

        return x;  
        
    }
                                      public int displaymai() {
                                          int x;
         String req="select * from event  WHERE date BETWEEN '2021-05-01' AND '2021-05-31'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                                  p.setId(rs.getInt(1));
            p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                                 public int displayjuin() {
                                                     int x;
         String req="select * from event  WHERE date BETWEEN '2021-06-01' AND '2021-06-30'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                                  p.setId(rs.getInt(1));
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                                            public int displayjuillet() {
                                                                int x;
         String req="select * from event  WHERE date BETWEEN '2021-07-01' AND '2021-07-31'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                                  p.setId(rs.getInt(1));
                  p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                    public int displayaout() {
                        int x;
         String req="select * from event  WHERE date BETWEEN '2021-08-01' AND '2021-08-31'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                               public int displayseptember() {
                                   int x;
         String req="select * from event  WHERE date BETWEEN '2021-09-01' AND '2021-09-30'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
              p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                          public int displayoctobre() {
                                              int x;
         String req="select * from event  WHERE date BETWEEN '2021-10-01' AND '2021-10-31'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                      p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                                     public int displaynovembre() {
                                                         int x;
         String req="select * from event  WHERE date BETWEEN '2021-11-01' AND '2021-11-30'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                                  p.setId(rs.getInt(1));
                   p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                                                public int displaydecembre() {
                                                                    int x = 0;
         String req="select * from event  WHERE date BETWEEN '2021-12-01' AND '2021-12-31'";
        ObservableList<Event> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                   p.setId(rs.getInt(1));
                p.setLieu(rs.getInt(2));
                p.setentreprise_id(rs.getInt(3));
                p.setNbr(rs.getInt(4));
                p.setPar_id(rs.getInt(5));
                p.setent_id(rs.getInt(6));
                p.setDate(rs.getString(7));
                p.setDescription(rs.getString(8));
                   p.setNom2(rs.getString(9));
                p.seImage(rs.getString(10));
                p.setCategorie(rs.getString(11));
                p.setDatef(rs.getString(12));
                p.setBackcolor(rs.getString(13));
                p.setBorderColor(rs.getString(14));
                p.setBorderColor(rs.getString(15));
                list.add(p);
                x=list.size();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;   
    }
        public ObservableList<Event> Lieu() {
        String req="select * from map";
        ObservableList<Event> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                p.setId(rs.getInt(1));
                System.out.println(p.getId());
                list.add(p)
                        ;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
         public ObservableList<Event> ent() {
        String req="select * from entreprise";
        ObservableList<Event> list=FXCollections.observableArrayList();       

        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Event p=new Event();
                p.setId(rs.getInt(1));
                list.add(p);
                        System.out.println(p.getId());
                        
                        
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }   
                                                                
    }
    

