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
public class Participant {
  private SimpleIntegerProperty id;
    private SimpleIntegerProperty user;
    private SimpleIntegerProperty eventid;
        private SimpleStringProperty date;
            private SimpleStringProperty nom;
               private SimpleStringProperty mail;
             private  SimpleIntegerProperty mobile;

    public Participant(int id, int user, int eventid, String date, String nom, String mail, int mobile) {
        this.id = new SimpleIntegerProperty(id);
        this.user = new SimpleIntegerProperty(user);
        this.eventid = new SimpleIntegerProperty (eventid);
        this.date = new  SimpleStringProperty (date);
        this.nom = new  SimpleStringProperty  (nom);
        this.mail = new  SimpleStringProperty  (mail);
        this.mobile =new  SimpleIntegerProperty (mobile);
    }
     public Participant( int user, int eventid, String date, String nom, String mail, int mobile) {
        this.user = new SimpleIntegerProperty(user);
        this.eventid = new SimpleIntegerProperty (eventid);
        this.date = new  SimpleStringProperty (date);
        this.nom = new  SimpleStringProperty  (nom);
        this.mail = new  SimpleStringProperty  (mail);
        this.mobile =new  SimpleIntegerProperty (mobile);
    }
          public Participant() {
   
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
  public int getEventid() {
        return eventid.get();
    }

    public void setEventid(SimpleIntegerProperty eventid) {
        this.eventid = eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = new SimpleIntegerProperty(eventid);
    }
 public SimpleIntegerProperty getEventidProperty(){
        return eventid;
    }
  public String getDate() {
        return date.get();
    }

    public void setDate(SimpleStringProperty date) {
        this.date = date;
    }

    public void setDate(String date) {
        this.date = new SimpleStringProperty(date);
    }
 public SimpleStringProperty getDateProperty(){
        return date;
    }
 public String getNom() {
        return nom.get();
    }

    public void setNom(SimpleStringProperty nom) {
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
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
        this.mail = new SimpleStringProperty(mail);
    }
 public SimpleStringProperty getMailProperty(){
        return mail;
    }
   public int getMobile() {
        return mobile.get();
    }

    public void setMobile(SimpleIntegerProperty mobile) {
        this.mobile = mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = new SimpleIntegerProperty(mobile);
    }
 public SimpleIntegerProperty getMobileProperty(){
        return mobile;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
  
}
