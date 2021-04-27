/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Dao;

import art_comm.Entities.Blog;
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
public class BlogDao implements Idao<Blog> {
    private static BlogDao instance;
    private Statement st;
    private ResultSet rs;

    public BlogDao() {
            ConnexionSingleton cs=ConnexionSingleton.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static BlogDao getInstance(){
        if(instance==null) 
            instance=new BlogDao();
        return instance;
    }
    @Override
    public void insert(Blog o) {
            String req="insert into blog (user,cat,date,contenu,titre,image,nbr) values ('"+o.getUser()+"','"+o.getCat()+"','"+o.getDate()+"','"+o.getContenu()+"','"+o.getTitre()+"','"+o.getImage()+"',0)";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Blog o) {
          String req="delete from Blog where id="+o.getId();
        Blog p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
            }

    @Override
    public ObservableList<Blog> displayAll() {
         String req="select * from blog";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                p.setNbr(rs.getInt(8));
               
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public List<Blog> displayAllList() {
        String req="select * from blog";
        List<Blog> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
             p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                p.setNbr(rs.getInt(8));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public ObservableList<Blog> Popular() {
        String req="SELECT id,user,cat,date,contenu,titre,image, MAX(nbr) FROM blog;";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
             p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                p.setNbr(rs.getInt(8));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public int PopularSize() {
        String req="SELECT id,user,cat,date,contenu,titre,image, MAX(nbr) FROM blog;";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
             p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                p.setNbr(rs.getInt(8));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }
public ObservableList<Blog> Newest() {
        String req="SELECT * FROM `blog` where date > CURDATE();";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
             p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                p.setNbr(rs.getInt(8));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public int NewestSize() {
        String req="SELECT * FROM `blog` where date > CURDATE();";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
             p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                p.setNbr(rs.getInt(8));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }
public ObservableList<Blog> Oldest() {
        String req="SELECT * FROM `blog` where date < CURDATE();";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
             p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                p.setNbr(rs.getInt(8));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
public int OldestSize() {
        String req="SELECT * FROM `blog` where date < CURDATE();";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
             p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                p.setNbr(rs.getInt(8));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list.size();
    }
public int sizeblog() {
        String req="select * from blog";
        List<Blog> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
             p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                               p.setNbr(rs.getInt(8));

                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list.size());
    }

    @Override
    public Blog displayById(int id) {
     String req="select * from blog where id ="+id;
           Blog p=new Blog();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
       p.setId(rs.getInt(1));
               p.setId(rs.getInt(1));
              p.setId(rs.getInt(1));
               p.setUser(rs.getInt(2));
               p.setCat(rs.getString(3));
               p.setDate(rs.getString(4));
               p.setContenu(rs.getString(5));
               p.setTitre(rs.getString(6));
               p.setImage(rs.getString(7));
                               p.setNbr(rs.getInt(8));

            //}  
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;    }

    @Override
    public boolean update(Blog os) {
          String qry = "UPDATE blog SET id = '"+os.getId()+"', user = '"+os.getUser()+"', cat = '"+os.getCat()+"', date = '"+os.getDate()+"', contenu = '"+os.getContenu()+"', titre = '"+os.getTitre()+"', image = '"+os.getImage()+"'  WHERE id = "+os.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        public boolean updateR(Blog os) {
          String qry = "UPDATE blog SET nbr = '"+os.getNbr()+"'  WHERE id = "+os.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      public List<Blog> displayAllup() {
         String req="select * from blog order by date asc";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                                                       p.setNbr(rs.getInt(8));

                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
    }
    public int rating(int x) {
         String req="SELECT AVG(rate) from commentaire where blog_id="+x;
int y = 0;        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
         
                                  y=(rs.getInt(1));
             

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return y;   
             }

        public List<Blog> displayAlldown() {
         String req="select * from blog order by date desc";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                                                       p.setNbr(rs.getInt(8));

                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;   
    }
            public int displayjanvier() {
                int x;
         String req="select * from blog  WHERE date BETWEEN '2021-01-01' AND '2021-01-31'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                       public int displayfevrier() {
                           int x;
         String req="select * from blog  WHERE date BETWEEN '2021-02-01' AND '2021-02-28'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                public int displaymars() {
                    int x;
         String req="select * from blog  WHERE date BETWEEN '2021-03-01' AND '2021-03-31'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                           public int displayavril() {
int x;
         String req="select * from blog  WHERE date BETWEEN '2021-04-01' AND '2021-04-30'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                         x=list.size();

        return x;  
        
    }
                                      public int displaymai() {
                                          int x;
         String req="select * from blog  WHERE date BETWEEN '2021-05-01' AND '2021-05-31'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                                 public int displayjuin() {
                                                     int x;
         String req="select * from blog  WHERE date BETWEEN '2021-06-01' AND '2021-06-30'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                                            public int displayjuillet() {
                                                                int x;
         String req="select * from blog  WHERE date BETWEEN '2021-07-01' AND '2021-07-31'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                    public int displayaout() {
                        int x;
         String req="select * from blog  WHERE date BETWEEN '2021-08-01' AND '2021-08-31'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                               public int displayseptember() {
                                   int x;
         String req="select * from blog  WHERE date BETWEEN '2021-09-01' AND '2021-09-30'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                          public int displayoctobre() {
                                              int x;
         String req="select * from blog  WHERE date BETWEEN '2021-10-01' AND '2021-10-31'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                                     public int displaynovembre() {
                                                         int x;
         String req="select * from blog  WHERE date BETWEEN '2021-11-01' AND '2021-11-30'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
                        x=list.size();

        return x;   
    }
                                                                public int displaydecembre() {
                                                                    int x = 0;
         String req="select * from blog  WHERE date BETWEEN '2021-12-01' AND '2021-12-31'";
        ObservableList<Blog> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Blog p=new Blog();
                                  p.setId(rs.getInt(1));
                p.setUser(rs.getInt(2));
                  p.setCat(rs.getString(3));
                    p.setDate(rs.getString(4));
                      p.setContenu(rs.getString(5));
                                   p.setTitre(rs.getString(6));
                                       p.setImage(rs.getString(7));
                list.add(p);
                x=list.size();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;   
    }
    
    
    
}
