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
public class Candidate extends User {
    private SimpleStringProperty nom ;
    private SimpleStringProperty prenom ;
    private SimpleStringProperty pays ;
    private SimpleStringProperty gouvernorat ;
    private SimpleStringProperty adresse ;
    private SimpleStringProperty birthday ;
    private SimpleStringProperty profile_pic ;
    private SimpleStringProperty cv ;
    private SimpleStringProperty about_you ;
    private SimpleIntegerProperty tel ;
    private SimpleIntegerProperty code_postal ;

    public Candidate(String nom, String prenom, String pays, String gouvernorat, String adresse, String birthday, String profile_pic, String cv, String about_you, int tel, int code_postal, int id, String email, String password, int type, String roles, String typeC, int status, String ver_token, String passchange) {
        super(id, email, password, type, roles, typeC, status, ver_token, passchange);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.pays = new SimpleStringProperty(pays);
        this.gouvernorat = new SimpleStringProperty(gouvernorat);
        this.adresse = new SimpleStringProperty(adresse);
        this.birthday = new SimpleStringProperty(birthday);
        this.profile_pic = new SimpleStringProperty(profile_pic);
        this.cv = new SimpleStringProperty(cv);
        this.about_you = new SimpleStringProperty(about_you);
        this.tel = new SimpleIntegerProperty(tel);
        this.code_postal = new SimpleIntegerProperty(code_postal);
    }
    
        public Candidate(String nom, String prenom, String pays, String gouvernorat, String adresse, String birthday, String profile_pic, String cv, String about_you, int tel, int code_postal, String email, String password, int type, String roles, String typeC, int status, String ver_token, String passchange) {
        super(email, password, type, roles, typeC, status, ver_token, passchange);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.pays = new SimpleStringProperty(pays);
        this.gouvernorat = new SimpleStringProperty(gouvernorat);
        this.adresse = new SimpleStringProperty(adresse);
        this.birthday = new SimpleStringProperty(birthday);
        this.profile_pic = new SimpleStringProperty(profile_pic);
        this.cv = new SimpleStringProperty(cv);
        this.about_you = new SimpleStringProperty(about_you);
        this.tel = new SimpleIntegerProperty(tel);
        this.code_postal = new SimpleIntegerProperty(code_postal);
    }
  
       public Candidate(String nom, String prenom, String pays, String gouvernorat, String adresse, String birthday, String profile_pic, String cv, String about_you, int tel, int code_postal,int id) {
        super(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.pays = new SimpleStringProperty(pays);
        this.gouvernorat = new SimpleStringProperty(gouvernorat);
        this.adresse = new SimpleStringProperty(adresse);
        this.birthday = new SimpleStringProperty(birthday);
        this.profile_pic = new SimpleStringProperty(profile_pic);
        this.cv = new SimpleStringProperty(cv);
        this.about_you = new SimpleStringProperty(about_you);
        this.tel = new SimpleIntegerProperty(tel);
        this.code_postal = new SimpleIntegerProperty(code_postal);
    }
  
    public Candidate()
    {
    
    }
    
    //getters propr

    public SimpleStringProperty getNomP() {
        return nom;
    }
    

    public SimpleStringProperty getPrenomP() {
        return prenom;
    }

    public SimpleStringProperty getPaysP() {
        return pays;
    }

    public SimpleStringProperty getGouvernoratP() {
        return gouvernorat;
    }

    public SimpleStringProperty getAdresseP() {
        return adresse;
    }

    public SimpleStringProperty getBirthdayP() {
        return birthday;
    }

    public SimpleStringProperty getProfile_picP() {
        return profile_pic;
    }

    public SimpleStringProperty getCvP() {
        return cv;
    }

    public SimpleStringProperty getAbout_youP() {
        return about_you;
    }

    public SimpleIntegerProperty getTelP() {
        return tel;
    }

    public SimpleIntegerProperty getCode_postalP() {
        return code_postal;
    }
// getters 

    public String getNom() {
        return nom.get();
    }

    public String getPrenom() {
        return prenom.get();
    }

    public String getPays() {
        return pays.get();
    }

    public String getGouvernorat() {
        return gouvernorat.get();
    }

    public String getAdresse() {
        return adresse.get();
    }

    public String getBirthday() {
        return birthday.get();
    }

    public String getProfile_pic() {
        return profile_pic.get();
    }

    public String getCv() {
        return cv.get();
    }

    public String getAbout_you() {
        return about_you.get();
    }

    public int getTel() {
        return tel.get();
    }

    public int getCode_postal() {
        return code_postal.get();
    }

   //setters

    public void setNom(SimpleStringProperty nom) {
        this.nom = nom;
    }
    

    public void setPrenom(SimpleStringProperty prenom) {
        this.prenom = prenom;
    }

    public void setPays(SimpleStringProperty pays) {
        this.pays = pays;
    }

    public void setGouvernorat(SimpleStringProperty gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public void setAdresse(SimpleStringProperty adresse) {
        this.adresse = adresse;
    }

    public void setBirthday(SimpleStringProperty birthday) {
        this.birthday = birthday;
    }

    public void setProfile_pic(SimpleStringProperty profile_pic) {
        this.profile_pic = profile_pic;
    }

    public void setCv(SimpleStringProperty cv) {
        this.cv = cv;
    }

    public void setAbout_you(SimpleStringProperty about_you) {
        this.about_you = about_you;
    }

    public void setTel(SimpleIntegerProperty tel) {
        this.tel = tel;
    }

    public void setCode_postal(SimpleIntegerProperty code_postal) {
        this.code_postal = code_postal;
    }
    
    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }
    

    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom);
    }

    public void setPays(String pays) {
        this.pays = new SimpleStringProperty(pays);
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = new SimpleStringProperty(gouvernorat);
    }

    public void setAdresse(String adresse) {
        this.adresse = new SimpleStringProperty(adresse);
    }

    public void setBirthday(String birthday) {
        this.birthday = new SimpleStringProperty(birthday);
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = new SimpleStringProperty(profile_pic);
    }

    public void setCv(String cv) {
        this.cv = new SimpleStringProperty(cv);
    }

    public void setAbout_you(String about_you) {
        this.about_you = new SimpleStringProperty(about_you);
    }

    public void setTel(int tel) {
        this.tel = new SimpleIntegerProperty(tel);
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = new SimpleIntegerProperty(code_postal);
    }
    
    
    
    
    


    
}
