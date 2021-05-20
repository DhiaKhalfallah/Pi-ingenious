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
public class Participant {
    int id;
    int user;
    int eventid;
    String date;
    String nom;
    String mail;
    int mobile;

    public Participant(int id, int user, int eventid, String date, String nom, String mail, int mobile) {
        this.id = id;
        this.user = user;
        this.eventid = eventid;
        this.date = date;
        this.nom = nom;
        this.mail = mail;
        this.mobile = mobile;
    }

    public Participant(int user, int eventid, String date, String nom, String mail, int mobile) {
        this.user = user;
        this.eventid = eventid;
        this.date = date;
        this.nom = nom;
        this.mail = mail;
        this.mobile = mobile;
    }

    public Participant(int id, int user, int eventid, String nom, String mail, int mobile) {
        this.id = id;
        this.user = user;
        this.eventid = eventid;
        this.nom = nom;
        this.mail = mail;
        this.mobile = mobile;
    }

    public Participant(int user, String nom, String mail, int mobile) {
        this.user = user;
        this.nom = nom;
        this.mail = mail;
        this.mobile = mobile;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Participant{" + "id=" + id + ", user=" + user + ", eventid=" + eventid + ", date=" + date + ", nom=" + nom + ", mail=" + mail + ", mobile=" + mobile + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
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
        final Participant other = (Participant) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Participant(int user, int eventid, String nom, String mail, int mobile) {
        this.user = user;
        this.eventid = eventid;
        this.nom = nom;
        this.mail = mail;
        this.mobile = mobile;
    }
    
    
}
