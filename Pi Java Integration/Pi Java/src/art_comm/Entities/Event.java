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
public class Event {
    private SimpleIntegerProperty id;
    private SimpleIntegerProperty lieu;
    private SimpleIntegerProperty entreprise_id;
        private SimpleIntegerProperty nbr;
      private SimpleIntegerProperty par_id;
         private SimpleIntegerProperty ent_id;
        private SimpleStringProperty date;
      private SimpleStringProperty description;
     private SimpleStringProperty nom;
     private SimpleStringProperty image;
     private SimpleStringProperty categorie;
     private SimpleStringProperty datef;
     private SimpleStringProperty backcolor;
     private SimpleStringProperty bordercolor;
     private SimpleStringProperty textcolor;  
     
      public Event(int id, int lieu, int entreprise_id,int nbr,int par_id,int ent_id,String date,String description,String nom,String image,String categorie,String datef,String backcolor,String bordercolor,String textcolor  ) 
      {
             this.id =new SimpleIntegerProperty(id);
                this.lieu =new SimpleIntegerProperty(lieu);
                   this.entreprise_id =new SimpleIntegerProperty(entreprise_id);
                                this.nbr =new SimpleIntegerProperty(nbr);
                              this.par_id =new SimpleIntegerProperty(par_id);
                                           this.ent_id =new SimpleIntegerProperty(ent_id);
                            this.date =new SimpleStringProperty(date);
               this.description =new SimpleStringProperty(description);
                                           this.nom =new SimpleStringProperty(nom);
                     this.image =new SimpleStringProperty(image);
    this.categorie =new SimpleStringProperty(categorie);
       this.datef =new SimpleStringProperty(datef);
                  this.backcolor =new SimpleStringProperty(backcolor);
                  this.bordercolor =new SimpleStringProperty(bordercolor);
                  this.textcolor =new SimpleStringProperty(textcolor);
      }
         public Event(int id, int lieu, int entreprise_id,int nbr,int par_id,int ent_id,String date,String description,String nom,String image,String categorie,String datef ) 
      {
             this.id =new SimpleIntegerProperty(id);
                this.lieu =new SimpleIntegerProperty(lieu);
                   this.entreprise_id =new SimpleIntegerProperty(entreprise_id);
                                this.nbr =new SimpleIntegerProperty(nbr);
                              this.par_id =new SimpleIntegerProperty(par_id);
                                           this.ent_id =new SimpleIntegerProperty(ent_id);
                            this.date =new SimpleStringProperty(date);
               this.description =new SimpleStringProperty(description);
                                           this.nom =new SimpleStringProperty(nom);
                     this.image =new SimpleStringProperty(image);
    this.categorie =new SimpleStringProperty(categorie);
       this.datef =new SimpleStringProperty(datef);
      
      } 
      
       public Event( int lieu, int entreprise_id,int nbr,int par_id,int ent_id,String date,String description,String nom,String image,String categorie,String datef,String backcolor,String bordercolor,String textcolor  ) 
      {
    
                this.lieu =new SimpleIntegerProperty(lieu);
                   this.entreprise_id =new SimpleIntegerProperty(entreprise_id);
                                this.nbr =new SimpleIntegerProperty(nbr);
                              this.par_id =new SimpleIntegerProperty(par_id);
                                           this.ent_id =new SimpleIntegerProperty(ent_id);
                            this.date =new SimpleStringProperty(date);
               this.description =new SimpleStringProperty(description);
                                           this.nom =new SimpleStringProperty(nom);
                     this.image =new SimpleStringProperty(image);
    this.categorie =new SimpleStringProperty(categorie);
       this.datef =new SimpleStringProperty(datef);
                  this.backcolor =new SimpleStringProperty(backcolor);
                  this.bordercolor =new SimpleStringProperty(bordercolor);
                  this.textcolor =new SimpleStringProperty(textcolor);
      }
        public Event( ) 
      {
          
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
   public int getLieu() {
        return lieu.get();
    }

    public void setLieu(SimpleIntegerProperty lieu) {
        this.lieu = lieu;
    }

    public void setLieu(int lieu) {
        this.lieu = new SimpleIntegerProperty(lieu);
    }
 public SimpleIntegerProperty getLieuProperty(){
        return lieu;
    }

  public int getEntreprise_id() {
        return entreprise_id.get();
    }

    public void setentreprise_id(SimpleIntegerProperty entreprise_id) {
        this.id = id;
    }

    public void setentreprise_id(int entreprise_id) {
        this.entreprise_id = new SimpleIntegerProperty(entreprise_id);
    }
 public SimpleIntegerProperty getentreprise_idProperty(){
        return entreprise_id;
    }
   public int getNbr() {
        return nbr.get();
    }

    public void setnbr(SimpleIntegerProperty nbr) {
        this.nbr = nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = new SimpleIntegerProperty(nbr);
    }
 public SimpleIntegerProperty getnbrProperty(){
        return nbr;
    }
    public int getPar_id() {
        return par_id.get();
    }

    public void setPar_id(SimpleIntegerProperty par_id) {
        this.par_id = par_id;
    }

    public void setPar_id(int par_id) {
        this.par_id = new SimpleIntegerProperty(par_id);
    }
 public SimpleIntegerProperty getPar_idProperty(){
        return par_id;
    }
    public int getent_id() {
        return ent_id.get();
    }

    public void setent_id(SimpleIntegerProperty ent_id) {
        this.ent_id = ent_id;
    }

    public void setent_id(int ent_id) {
        this.ent_id = new SimpleIntegerProperty(ent_id);
    }
 public SimpleIntegerProperty getent_idProperty(){
        return ent_id;
    }
    public String getDate() {
        return date.get();
    }

    public void setDate(SimpleStringProperty date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date= new SimpleStringProperty(date);
    }
 public SimpleStringProperty getDatPropertye(){
        return date;
    }
     public String getdescription() {
        return description.get();
    }

    public void setDescription(SimpleStringProperty descrciption) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = new SimpleStringProperty(description);
    }
 public SimpleStringProperty getDescriptionProperty(){
        return description;
    }
 
   public String getImage() {
        return image.get();
    }

    public void setImage(SimpleStringProperty image) {
        this.image = image;
    }

    public void seImage(String image) {
        this.image= new SimpleStringProperty(image);
    }
 public SimpleStringProperty getImageProperty(){
        return image;
    }
   public String getCategorie() {
        return categorie.get();
    }

    public void setCategorie(SimpleStringProperty categorie) {
        this.categorie = categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie= new SimpleStringProperty(categorie);
    }
 public SimpleStringProperty getCategorieProperty(){
        return categorie;
    }
    public String getDatef() {
        return datef.get();
    }

    public void setDatef(SimpleStringProperty datef) {
        this.datef = datef;
    }

    public void setDatef(String datef) {
        this.datef= new SimpleStringProperty(datef);
    }
 public SimpleStringProperty getDatefProperty(){
        return datef;
    }
    public String getBackcolor() {
        return backcolor.get();
    }

    public void setBackcolor(SimpleStringProperty backcolor) {
        this.backcolor = backcolor;
    }

    public void setBackcolor(String backcolor) {
        this.backcolor= new SimpleStringProperty(backcolor);
    }
 public SimpleStringProperty getBackcolorProperty(){
        return backcolor;
    }
            public String getBordercolor() {
        return bordercolor.get();
    }

    public void setBordercolor(SimpleStringProperty Bordercolor) {
        this.bordercolor = bordercolor;
    }

    public void setBorderColor(String bordercolor) {
        this.backcolor= new SimpleStringProperty(bordercolor);
    }
 public SimpleStringProperty getBordercolorProperty(){
        return bordercolor;
    }     
    public String getTextcolor() {
        return textcolor.get();
    }

    public void setTextcolor(SimpleStringProperty textcolor) {
        this.textcolor = textcolor;
    }

    public void setTextcolor(String textcolor) {
        this.textcolor= new SimpleStringProperty(textcolor);
    }
 public SimpleStringProperty getTextcolorProperty(){
        return textcolor;
    }
 
   public String getNom2() {
        return nom.get();
    }

    public void setNom2(SimpleStringProperty Nom) {
        this.nom = nom;
    }

    public void setNom2(String nom) {
        this.nom= new SimpleStringProperty(nom);
    }
 public SimpleStringProperty getNomProperty2(){
        return nom;
 }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Event other = (Event) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


      }
    
    