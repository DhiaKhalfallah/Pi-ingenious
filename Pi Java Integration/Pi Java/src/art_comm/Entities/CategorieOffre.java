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
public class CategorieOffre {
    private int id;
    private String nom;
    private String logo;
    private String color;

    public CategorieOffre() {
    }

    @Override
    public String toString() {
        return "CategorieOffre{" + "nom=" + nom + ", logo=" + logo + ", color=" + color + '}';
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getLogo() {
        return logo;
    }

    public String getColor() {
        return color;
    }

    public CategorieOffre(int id, String nom, String logo, String color) {
        this.id = id;
        this.nom = nom;
        this.logo = logo;
        this.color = color;
    }

    public String getlogo() {
     return logo ;
    }


}