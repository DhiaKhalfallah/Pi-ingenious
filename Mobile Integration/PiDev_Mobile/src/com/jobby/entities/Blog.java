/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobby.entities;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author LEGION
 */
public class Blog {
      private int id;
    private int  user;
    private int  eventid;
        private String cat;
            private String date;
               private String  contenu;
                            private String  titre;
 private String image;
                                               private int nbr;
    public Blog(int user, String cat, String date, String contenu, String titre) {
        this.user = user;
        this.cat = cat;
        this.date = date;
        this.contenu = contenu;
        this.titre = titre;
    }

    public Blog(int user, String cat, String contenu, String titre, String image, int nbr) {
        this.user = user;
        this.cat = cat;
        this.contenu = contenu;
        this.titre = titre;
        this.image = image;
        this.nbr = nbr;
    }

    public Blog(int user, String cat, String contenu, String titre) {
        this.user = user;
        this.cat = cat;
        this.contenu = contenu;
        this.titre = titre;
    }

    public Blog(int id, int user, int eventid, String cat, String date, String contenu, String titre, String image, int nbr) {
        this.id = id;
        this.user = user;
        this.eventid = eventid;
        this.cat = cat;
        this.date = date;
        this.contenu = contenu;
        this.titre = titre;
        this.image = image;
        this.nbr = nbr;
    }

    public Blog(int user, String cat, String date, String contenu, String titre, String image, int nbr) {
        this.user = user;
        this.cat = cat;
        this.date = date;
        this.contenu = contenu;
        this.titre = titre;
        this.image = image;
        this.nbr = nbr;
    }

    public Blog(String cat, String date, String contenu, String titre, String image, int nbr) {
        this.cat = cat;
        this.date = date;
        this.contenu = contenu;
        this.titre = titre;
        this.image = image;
        this.nbr = nbr;
    }

    public Blog(String date, String contenu, String titre) {
        this.date = date;
        this.contenu = contenu;
        this.titre = titre;
    }

    public Blog() {
    }
                                          

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getNbr() {
        return nbr;
    }

    public void setNbr(int nbr) {
        this.nbr = nbr;
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
