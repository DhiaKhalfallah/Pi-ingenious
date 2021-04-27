/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventcrud.Entities;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Formation {
      private int id;
      private int idcategorie_id;
      private  final  int  status=0;
      private String nom ,secteur , image,description, categorie ;
      private Date DateDebut , DateFin ;
      private  int prix;
      private final String backcolor="#cc66ff";
      private final String bordercolor="#cc66ff";
      private final String textcolor="#ffffff";
      private final Date updated_at=null;
      private final int id_user=1;
    
    public Formation() {
    }

   

 

    public Formation(int id, String nom, String secteur, String description, String categorie, Date DateDebut, Date DateFin , int status) {
        this.id = id;
        this.nom = nom;
        this.secteur = secteur;
        this.description = description;
        this.categorie = categorie;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
        
    }

    public Formation(int id, String nom, String secteur, String description, Date DateDebut, Date DateFin) {
        this.id = id;
        this.nom = nom;
        this.secteur = secteur;
        this.description = description;
        this.DateDebut = DateDebut;
        this.DateFin = DateFin;
    }

    public Formation(int id, String nom, String secteur, Date DateDebut) {
        this.id = id;
        this.nom = nom;
        this.secteur = secteur;
        this.DateDebut = DateDebut;
    }


  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date DateDebut) {
        this.DateDebut = DateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date DateFin) {
        this.DateFin = DateFin;
    }

    public int getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Formation{" + "id=" + id + ", status=" + status + ", nom=" + nom + ", secteur=" + secteur + ", description=" + description + ", DateDebut=" + DateDebut + ", DateFin=" + DateFin + '}';
    }

    public Formation(int id, String nom, String secteur, String description, Date DateDebut) {
        this.id = id;
        this.nom = nom;
        this.secteur = secteur;
        this.description = description;
        this.DateDebut = DateDebut;
    }

    public int getIdcategorie_id() {
        return idcategorie_id;
    }

    public void setIdcategorie_id(int idcategorie_id) {
        this.idcategorie_id = idcategorie_id;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

   

  
      
      
      
      
    
}
