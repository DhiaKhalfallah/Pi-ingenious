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
public class Commentaire {
    
  int id ;
int user;
String nom ;
String mail;
String subject;
int Mobile;
String Commentaire;
String date;
int blog_id;
int rate ;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMobile() {
        return Mobile;
    }

    public void setMobile(int Mobile) {
        this.Mobile = Mobile;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", user=" + user + ", nom=" + nom + ", mail=" + mail + ", subject=" + subject + ", Mobile=" + Mobile + ", Commentaire=" + Commentaire + ", date=" + date + ", blog_id=" + blog_id + ", rate=" + rate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
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
        final Commentaire other = (Commentaire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public Commentaire() {
    }

    public Commentaire(int id, int user, String nom, String mail, String subject, int Mobile, String Commentaire, String date, int blog_id, int rate) {
        this.id = id;
        this.user = user;
        this.nom = nom;
        this.mail = mail;
        this.subject = subject;
        this.Mobile = Mobile;
        this.Commentaire = Commentaire;
        this.date = date;
        this.blog_id = blog_id;
        this.rate = rate;
    }

    public Commentaire(String nom, String subject, String Commentaire, int rate) {
        this.nom = nom;
        this.subject = subject;
        this.Commentaire = Commentaire;
        this.rate = rate;
    }
  public Commentaire(int id,String nom, String subject, String Commentaire, int rate) {
      this.id=id;
        this.nom = nom;
        this.subject = subject;
        this.Commentaire = Commentaire;
        this.rate = rate;
    }
    public Commentaire(String nom, String subject, String Commentaire, int rate,int blog_id) {
      this.id=id;
        this.nom = nom;
        this.subject = subject;
        this.Commentaire = Commentaire;
        this.rate = rate;
        this.blog_id=blog_id;
    }
        public Commentaire(String nom, String subject, String Commentaire, int rate,int blog_id,int user) {
      this.id=id;
        this.nom = nom;
        this.subject = subject;
        this.Commentaire = Commentaire;
        this.rate = rate;
        this.blog_id=blog_id;
        this.user=user;
    }

}
