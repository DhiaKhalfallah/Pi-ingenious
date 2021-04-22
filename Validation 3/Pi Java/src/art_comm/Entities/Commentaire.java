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
public class Commentaire {
    
        private SimpleIntegerProperty id;
                private SimpleIntegerProperty user;
    private SimpleStringProperty nom;
    private SimpleStringProperty mail;
   private SimpleStringProperty subject;
     private SimpleIntegerProperty mobile;
 private SimpleStringProperty commentaire;
   private SimpleStringProperty date;
    private SimpleIntegerProperty blog_id;
private SimpleIntegerProperty rate;

    public Commentaire(int id, int user, String nom, String mail, String subject, int mobile, String commentaire, String date, int blog_id, int rate) {
        this.id = new  SimpleIntegerProperty(id);
        this.user =new SimpleIntegerProperty  (user);
        this.nom = new SimpleStringProperty (nom);
        this.mail = new SimpleStringProperty(mail);
        this.subject = new SimpleStringProperty(subject);
        this.mobile = new SimpleIntegerProperty(mobile);
        this.commentaire =new SimpleStringProperty (commentaire);
        this.date = new SimpleStringProperty(date);
        this.blog_id = new SimpleIntegerProperty(blog_id);
        this.rate = new SimpleIntegerProperty(rate);
    }

    public Commentaire( int user, String nom, String mail, String subject, int mobile, String commentaire, String date, int blog_id, int rate) {
        this.user =new SimpleIntegerProperty  (user);
        this.nom = new SimpleStringProperty (nom);
        this.mail = new SimpleStringProperty(mail);
        this.subject = new SimpleStringProperty(subject);
        this.mobile = new SimpleIntegerProperty(mobile);
        this.commentaire =new SimpleStringProperty (commentaire);
        this.date = new SimpleStringProperty(date);
        this.blog_id = new SimpleIntegerProperty(blog_id);
        this.rate = new SimpleIntegerProperty(rate);
    }
        public Commentaire( int user, String nom, String mail, String subject, int mobile, String commentaire, String date, int blog_id, int rate,int id) {
                       this.id = new  SimpleIntegerProperty(id);
        this.id = new  SimpleIntegerProperty(id);

            this.user =new SimpleIntegerProperty  (user);
this.nom = new SimpleStringProperty (nom);
        this.mail = new SimpleStringProperty(mail);
        this.subject = new SimpleStringProperty(subject);
        this.mobile = new SimpleIntegerProperty(mobile);
        this.commentaire =new SimpleStringProperty (commentaire);
        this.date = new SimpleStringProperty(date);
        this.blog_id = new SimpleIntegerProperty(blog_id);
        this.rate = new SimpleIntegerProperty(rate);    

    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", user=" + user + ", nom=" + nom + ", mail=" + mail + ", subject=" + subject + ", mobile=" + mobile + ", commentaire=" + commentaire + ", date=" + date + ", blog_id=" + blog_id + ", rate=" + rate + '}';
    }

    public Commentaire() {
    
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
public int getUser() {
        return user.get();
    }

    public void setUser(SimpleIntegerProperty user) {
        this.user = user;
    }

    public void setUser(int user) {
        this.user = new SimpleIntegerProperty(user);
    }
 public SimpleIntegerProperty getUserProperty(){
        return user;
    }
 public String getNom() {
        return nom.get();
    }

    public void setNom(SimpleStringProperty nom) {
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom= new SimpleStringProperty(nom);
    }
 public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public String getMail() {
        return mail.get();
    }

    public void setMail(SimpleStringProperty mail) {
        this.mail = mail;
    }

    public void setMail(String mail) {
        this.mail= new SimpleStringProperty(mail);
    }
 public SimpleStringProperty getMailProperty(){
        return mail;
    } 
     public String getSubject() {
        return subject.get();
    }

    public void setSubject(SimpleStringProperty subject) {
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject= new SimpleStringProperty(subject);
    }
 public SimpleStringProperty getSubjectProperty(){
        return subject;
    }
    public int getMobile() {
        return mobile.get();
    }

    public void setMobile(SimpleIntegerProperty mobile) {
        this.mobile = mobile;
    }

    public void setMobile(int mobile) {
        this.mobile= new SimpleIntegerProperty(mobile);
    }
 public SimpleIntegerProperty getMobileProperty(){
        return mobile;
    }
    public String getCommentaire() {
        return commentaire.get();
    }

    public void setCommentaire(SimpleStringProperty commentaire) {
        this.commentaire = commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire= new SimpleStringProperty(commentaire);
    }
 public SimpleStringProperty getCommentaireProperty(){
        return commentaire;
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
 public SimpleStringProperty getDateProperty(){
        return date;
    }
     public int getBlog_id() {
        return blog_id.get();
    }

    public void setBlog_id(SimpleIntegerProperty blog_id) {
        this.blog_id = blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id= new SimpleIntegerProperty(blog_id);
    }
 public SimpleIntegerProperty getblog_idProperty(){
        return blog_id;
    }
     public int getRate() {
        return rate.get();
    }

    public void setRate(SimpleIntegerProperty rate) {
        this.rate = rate;
    }

    public void setRate(int rate) {
        this.rate= new SimpleIntegerProperty(rate);
    }
 public SimpleIntegerProperty getRateProperty(){
        return rate;
    }
}
