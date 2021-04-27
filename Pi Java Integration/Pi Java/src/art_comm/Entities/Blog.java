 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Entities;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author LEGION
 */
public class Blog {
       private SimpleIntegerProperty id;
    private SimpleIntegerProperty user;
    private SimpleIntegerProperty eventid;
        private SimpleStringProperty cat;
            private SimpleStringProperty date;
               private SimpleStringProperty contenu;
                            private SimpleStringProperty titre;
                                           private SimpleStringProperty image;
                                               private SimpleIntegerProperty nbr;
      public Blog(int id, int user, int eventid, String cat, String date, String contenu, String titre, String image,int nbr) {
        this.id = new SimpleIntegerProperty (id);
        this.user = new SimpleIntegerProperty (user);
        this.eventid = new SimpleIntegerProperty(eventid);
        this.cat =  new SimpleStringProperty(cat);
        this.date =  new SimpleStringProperty (date);
        this.contenu =  new SimpleStringProperty (contenu);
        this.titre =  new SimpleStringProperty (titre);
        this.image = new SimpleStringProperty (image) ;
 this.nbr = new SimpleIntegerProperty (nbr);
    }

    public Blog(int id, int user, int eventid, String cat, String date, String contenu, String titre, String image) {
        this.id = new SimpleIntegerProperty (id);
        this.user = new SimpleIntegerProperty (user);
        this.eventid = new SimpleIntegerProperty(eventid);
        this.cat =  new SimpleStringProperty(cat);
        this.date =  new SimpleStringProperty (date);
        this.contenu =  new SimpleStringProperty (contenu);
        this.titre =  new SimpleStringProperty (titre);
        this.image = new SimpleStringProperty (image) ;
    }
     public Blog( int user, String cat, String date, String contenu, String titre, String image) {
        this.user = new SimpleIntegerProperty (user);
        this.cat =  new SimpleStringProperty(cat);
        this.date =  new SimpleStringProperty (date);
        this.contenu =  new SimpleStringProperty (contenu);
        this.titre =  new SimpleStringProperty (titre);
        this.image = new SimpleStringProperty (image) ;
    }
        public Blog(int user, int eventid, String cat, String date, String contenu, String titre, String image,int id) {
      
        this.user = new SimpleIntegerProperty (user);
        this.eventid = new SimpleIntegerProperty(eventid);
        this.cat =  new SimpleStringProperty(cat);
        this.date =  new SimpleStringProperty (date);
        this.contenu =  new SimpleStringProperty (contenu);
        this.titre =  new SimpleStringProperty (titre);
        this.image = new SimpleStringProperty (image) ;  
        this.id = new SimpleIntegerProperty (id);
    }
    public Blog(int user, int eventid, String cat, String date, String contenu, String titre, String image) {

        this.user = new SimpleIntegerProperty (user);
        this.eventid = new SimpleIntegerProperty(eventid);
        this.cat =  new SimpleStringProperty(cat);
        this.date =  new SimpleStringProperty (date);
        this.contenu =  new SimpleStringProperty (contenu);
        this.titre =  new SimpleStringProperty (titre);
        this.image = new SimpleStringProperty (image) ;
    }
 public Blog(int user,  String cat,  String date,  String contenu,  String titre,  String image,int id) {
    
        this.user = new SimpleIntegerProperty(user) ;
        this.cat = new  SimpleStringProperty (cat);
        this.date =  new SimpleStringProperty (date);
        this.contenu = new SimpleStringProperty (contenu);
        this.titre =new SimpleStringProperty (titre);
        this.image = new SimpleStringProperty (image);  
        this.id = new SimpleIntegerProperty(id);
    }
        public Blog() {
   
    }

        public int getId() {
        return id.get();
    }

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }
 public SimpleIntegerProperty getIdProperty(){
        return id;
    }
  public int getUser() {
        return user.get();
    }

    public void setUser(SimpleIntegerProperty user) {
        this.user = user;
    }

    public void setUser(int user) {
        this.user = new SimpleIntegerProperty(user);
    }
 public SimpleIntegerProperty getUserProperty(){
        return user;
    } 
   public int getNbr() {
        return nbr.get();
    }

    public void setNbr(SimpleIntegerProperty nbr) {
        this.nbr = nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = new SimpleIntegerProperty(nbr);
    }
 public SimpleIntegerProperty getNbrProperty(){
        return nbr;
    } 
       
     public int getEventid() {
        return eventid.get();
    }

    public void setEventid(SimpleIntegerProperty eventid) {
        this.eventid = eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = new SimpleIntegerProperty(eventid);
    }
 public SimpleIntegerProperty getEventidProperty(){
        return eventid;
    }     
   public String getCat() {
        return cat.get();
    }

    public void setCat(SimpleStringProperty cat) {
        this.cat = cat;
    }

    public void setCat(String cat) {
        this.cat = new SimpleStringProperty(cat);
    }
 public SimpleStringProperty getCatProperty(){
        return cat;
    } 
  public String getDate() {
        return date.get();
    }

    public void setDate(SimpleStringProperty date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = new SimpleStringProperty(date);
    }
 public SimpleStringProperty getDateProperty(){
        return date;
    } 
  public String getContenu() {
        return contenu.get();
    }

    public void setContenu(SimpleStringProperty contenu) {
        this.contenu = contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = new SimpleStringProperty(contenu);
    }
 public SimpleStringProperty getContenuProperty(){
        return contenu;
    } 
  public String getTitre() {
        return titre.get();
    }

    public void setTitre(SimpleStringProperty titre) {
        this.titre = titre;
    }

    public void setTitre(String titre) {
        this.titre = new SimpleStringProperty(titre);
    }
 public SimpleStringProperty getTitreProperty(){
        return titre;
    } 
  public String getImage() {
        return image.get();
    }

    public void setImage(SimpleStringProperty image) {
        this.image = image;
    }

    public void setImage(String image) {
        this.image = new SimpleStringProperty(image);
    }
 public SimpleStringProperty getImageProperty(){
        return image;
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Blog other = (Blog) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Blog{" + "id=" + id + ", user=" + user + ", eventid=" + eventid + ", cat=" + cat + ", date=" + date + ", contenu=" + contenu + ", titre=" + titre + ", image=" + image + ", nbr=" + nbr + '}';
    }

   

   
    
    
}
