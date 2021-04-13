/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.Entities;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Dhia
 */
public class Reclamation {
    private SimpleIntegerProperty id ;
    private SimpleIntegerProperty user_id ;
    private SimpleIntegerProperty cstatus ;
    private SimpleStringProperty user_email ;
    private SimpleStringProperty subject ;
    private SimpleStringProperty claim ;
    private SimpleStringProperty submit_date ;

    public Reclamation(int id, int user_id, int cstatus, String user_email, String subject, String claim, String submit_date) {
        this.id = new SimpleIntegerProperty(id);
        this.user_id = new SimpleIntegerProperty(user_id);
        this.cstatus = new SimpleIntegerProperty(cstatus);
        this.user_email = new SimpleStringProperty(user_email);
        this.subject = new SimpleStringProperty(subject);
        this.claim = new SimpleStringProperty(claim);
        this.submit_date = new SimpleStringProperty(submit_date);
    }
        public Reclamation( int user_id, int cstatus, String user_email, String subject, String claim, String submit_date) {
        this.user_id = new SimpleIntegerProperty(user_id);
        this.cstatus = new SimpleIntegerProperty(cstatus);
        this.user_email = new SimpleStringProperty(user_email);
        this.subject = new SimpleStringProperty(subject);
        this.claim = new SimpleStringProperty(claim);
        this.submit_date = new SimpleStringProperty(submit_date);
    }
 public Reclamation(){}
 
 //getters prop 

    public SimpleIntegerProperty getIdP() {
        return id;
    }

    public SimpleIntegerProperty getUser_idP() {
        return user_id;
    }

    public SimpleIntegerProperty getCstatusP() {
        return cstatus;
    }

    public SimpleStringProperty getUser_emailP() {
        return user_email;
    }

    public SimpleStringProperty getSubjectP() {
        return subject;
    }

    public SimpleStringProperty getClaimP() {
        return claim;
    }

    public SimpleStringProperty getSubmit_dateP() {
        return submit_date;
    }
 
 // getters

    public int getId() {
        return id.get();
    }

    public int getUser_id() {
        return user_id.get();
    }

    public int getCstatus() {
        return cstatus.get();
    }

    public String getUser_email() {
        return user_email.get();
    }

    public String getSubject() {
        return subject.get();
    }

    public String getClaim() {
        return claim.get();
    }

    public String getSubmit_date() {
        return submit_date.get();
    }
 
 // setters 

    public void setId(SimpleIntegerProperty id) {
        this.id = id;
    }

    public void setUser_id(SimpleIntegerProperty user_id) {
        this.user_id = user_id;
    }

    public void setCstatus(SimpleIntegerProperty cstatus) {
        this.cstatus = cstatus;
    }

    public void setUser_email(SimpleStringProperty user_email) {
        this.user_email = user_email;
    }

    public void setSubject(SimpleStringProperty subject) {
        this.subject = subject;
    }

    public void setClaim(SimpleStringProperty claim) {
        this.claim = claim;
    }

    public void setSubmit_date(SimpleStringProperty submit_date) {
        this.submit_date = submit_date;
    }
    
    
    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public void setUser_id(int user_id) {
        this.user_id = new SimpleIntegerProperty(user_id);
    }

    public void setCstatus(int cstatus) {
        this.cstatus = new SimpleIntegerProperty(cstatus);
    }

    public void setUser_email(String user_email) {
        this.user_email = new SimpleStringProperty(user_email);
    }

    public void setSubject(String subject) {
        this.subject =  new SimpleStringProperty(subject);
    }

    public void setClaim(String claim) {
        this.claim =  new SimpleStringProperty(claim);
    }

    public void setSubmit_date(String submit_date) {
        this.submit_date =  new SimpleStringProperty(submit_date);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Reclamation other = (Reclamation) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", user_id=" + user_id + ", cstatus=" + cstatus + ", user_email=" + user_email + ", subject=" + subject + ", claim=" + claim + ", submit_date=" + submit_date + '}';
    }
    
    
    
    
    
    
    

    
}
