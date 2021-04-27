/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;


/**
 *
 * @author RE flex
 */
public class Offre {
    private int id;
    private String nom;
    private String email;
    private String logo;
    private String title;
    private String description;
    private int Categorie;

 
   

    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
     public void setEmail(String email) {
        this.email = email;
    }
    
     public void setLogo(String logo) {
        this.logo = logo;
    }

      public void setTitle(String title) {
        this.title = title;
    }
     
        public void setDescription(String description) {
        this.description = description;
    }
     
       public void setId(int id) {
        this.id = id;
    }

        public int getId() {
          return id;
        }

    public String getNom() {
          return nom;
        }

    public String getEmail() {
      return email ;
    }

    public String getlogo() {
      return logo ;
    }

    public String getTitle() {
     return title ;
    }

    public String getDescription() {
      return description ;
    }
     public int getCategorie() {
    return Categorie ;
    }

    public Offre(int id, String nom, String email , String logo , String title , String description , int categorie) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.logo = logo;
        this.title = title;
        this.description = description;
        this.Categorie = categorie;
    }
    
    public Offre(int id, int categorie, String nom, String email , String logo , String title , String description ) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.logo = logo;
        this.title = title;
        this.description = description;
        this.Categorie = categorie;
    }

    public void setCategorie(int Categorie) {
        this.Categorie = Categorie;
    }

   

    public Offre() {
    }

    
}



