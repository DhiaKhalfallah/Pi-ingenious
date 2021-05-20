/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobby.entities;

/**
 *
 * @author LEGION
 */
public class Event {
    private int id;
    private int lieu;
    private int entreprise_id;
        private int nbr;
      private int par_id;
         private int ent_id;
        private String date;
      private String description;
     private String nom;
     private String image;
     private String categorie;
     private String datef;
     private String backcolor;
     private String bordercolor;
     private String textcolor;  

    public Event() {
    }

    public Event(int nbr, int par_id, String description, String image, String categorie) {
        this.nbr = nbr;
        this.par_id = par_id;
        this.description = description;
        this.image = image;
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", lieu=" + lieu + ", entreprise_id=" + entreprise_id + ", nbr=" + nbr + ", par_id=" + par_id + ", ent_id=" + ent_id + ", date=" + date + ", description=" + description + ", nom=" + nom + ", image=" + image + ", categorie=" + categorie + ", datef=" + datef + ", backcolor=" + backcolor + ", bordercolor=" + bordercolor + ", textcolor=" + textcolor + '}';
    }

    public int getId() {
        return id;
    }

    public int getLieu() {
        return lieu;
    }

    public int getEntreprise_id() {
        return entreprise_id;
    }

    public int getNbr() {
        return nbr;
    }

    public int getPar_id() {
        return par_id;
    }

    public int getEnt_id() {
        return ent_id;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getNom() {
        return nom;
    }

    public String getImage() {
        return image;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDatef() {
        return datef;
    }

    public String getBackcolor() {
        return backcolor;
    }

    public String getBordercolor() {
        return bordercolor;
    }

    public String getTextcolor() {
        return textcolor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLieu(int lieu) {
        this.lieu = lieu;
    }

    public void setEntreprise_id(int entreprise_id) {
        this.entreprise_id = entreprise_id;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    public void setPar_id(int par_id) {
        this.par_id = par_id;
    }

    public void setEnt_id(int ent_id) {
        this.ent_id = ent_id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setDatef(String datef) {
        this.datef = datef;
    }

    public void setBackcolor(String backcolor) {
        this.backcolor = backcolor;
    }

    public void setBordercolor(String bordercolor) {
        this.bordercolor = bordercolor;
    }

    public void setTextcolor(String textcolor) {
        this.textcolor = textcolor;
    }
    
}
