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
public class CategorieOffre {
       private int id;
       private String logo ;
       private String nom ;
       private String color ;

    public CategorieOffre(int id, String logo, String nom, String color) {
        this.id = id;
        this.logo = logo;
        this.nom = nom;
        this.color = color;
    }

    public CategorieOffre(String logo, String nom, String color) {
        this.logo = logo;
        this.nom = nom;
        this.color = color;
    }

    public CategorieOffre() {
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CategorieOffre{" + "id=" + id + ", logo=" + logo + ", nom=" + nom + ", color=" + color + '}';
    }
    
}
