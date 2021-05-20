/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobby.entities;

/**
 *
 * @author RE flex
 */
public class Offre {
    private int id;
    private int idcategorie_id;
    private String nom ;
    private String email ;
    private String logo ; 
   private String title ; 
   private String description ; 

    public Offre() {
    }

    public Offre(int idcategorie_id, String nom, String email, String logo, String title, String description) {
        this.idcategorie_id = idcategorie_id;
        this.nom = nom;
        this.email = email;
        this.logo = logo;
        this.title = title;
        this.description = description;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIdcategorie_id() {
        return idcategorie_id;
    }

    public void setIdcategorie_id(int idcategorie_id) {
        this.idcategorie_id = idcategorie_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" + "id=" + id + ", idcategorie_id=" + idcategorie_id + ", nom=" + nom + ", email=" + email + ", logo=" + logo + ", title=" + title + ", description=" + description + '}';
    }
   
}
