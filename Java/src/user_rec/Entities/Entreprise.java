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
public class Entreprise extends User {
    private SimpleStringProperty nom ;
    private SimpleStringProperty about ;
    private SimpleStringProperty adresse ;
    private SimpleStringProperty siteweb ;
    private SimpleStringProperty twitter ;
    private SimpleStringProperty linkdin ;
    private SimpleStringProperty facebook ;
    private SimpleStringProperty profile_pic ;
    private SimpleIntegerProperty tel ;

    public Entreprise(String nom, String about, String adresse, String siteweb, String twitter, String linkdin, String facebook, String profile_pic, int tel, int id, String email, String password, int type, String roles, String typeC, int status, String ver_token, String passchange) {
        super(id, email, password, type, roles, typeC, status, ver_token, passchange);
        this.nom = new SimpleStringProperty(nom);
        this.about = new SimpleStringProperty(about);
        this.adresse = new SimpleStringProperty(adresse);
        this.siteweb = new SimpleStringProperty(siteweb);
        this.twitter = new SimpleStringProperty(twitter);
        this.linkdin = new SimpleStringProperty(linkdin);
        this.facebook = new SimpleStringProperty(facebook);
        this.profile_pic = new SimpleStringProperty(profile_pic);
        this.tel = new SimpleIntegerProperty(tel);
    }
        public Entreprise(String nom, String about, String adresse, String siteweb, String twitter, String linkdin, String facebook, String profile_pic, int tel, String email, String password, int type, String roles, String typeC, int status, String ver_token, String passchange) {
        super(email, password, type, roles, typeC, status, ver_token, passchange);
        this.nom = new SimpleStringProperty(nom);
        this.about = new SimpleStringProperty(about);
        this.adresse = new SimpleStringProperty(adresse);
        this.siteweb = new SimpleStringProperty(siteweb);
        this.twitter = new SimpleStringProperty(twitter);
        this.linkdin = new SimpleStringProperty(linkdin);
        this.facebook = new SimpleStringProperty(facebook);
        this.profile_pic = new SimpleStringProperty(profile_pic);
        this.tel = new SimpleIntegerProperty(tel);
    }
       public Entreprise(String nom, String about, String adresse, String siteweb, String twitter, String linkdin, String facebook, String profile_pic, int tel, int id) {
        super(id);
        this.nom = new SimpleStringProperty(nom);
        this.about = new SimpleStringProperty(about);
        this.adresse = new SimpleStringProperty(adresse);
        this.siteweb = new SimpleStringProperty(siteweb);
        this.twitter = new SimpleStringProperty(twitter);
        this.linkdin = new SimpleStringProperty(linkdin);
        this.facebook = new SimpleStringProperty(facebook);
        this.profile_pic = new SimpleStringProperty(profile_pic);
        this.tel = new SimpleIntegerProperty(tel);
    }
   public Entreprise()
   {
   }
   
   //getters prorp

    public SimpleStringProperty getNomP() {
        return nom;
    }

    public SimpleStringProperty getAboutP() {
        return about;
    }

    public SimpleStringProperty getAdresseP() {
        return adresse;
    }

    public SimpleStringProperty getSitewebP() {
        return siteweb;
    }

    public SimpleStringProperty getTwitterP() {
        return twitter;
    }

    public SimpleStringProperty getLinkdinP() {
        return linkdin;
    }

    public SimpleStringProperty getFacebookP() {
        return facebook;
    }

    public SimpleStringProperty getProfile_picP() {
        return profile_pic;
    }

    public SimpleIntegerProperty getTelP() {
        return tel;
    }
   
   
   //getters
    
    
    public String getNom() {
        return nom.get();
    }

    public String getAbout() {
        return about.get();
    }

    public String getAdresse() {
        return adresse.get();
    }

    public String getSiteweb() {
        return siteweb.get();
    }

    public String getTwitter() {
        return twitter.get();
    }

    public String getLinkdin() {
        return linkdin.get();
    }

    public String getFacebook() {
        return facebook.get();
    }

    public String getProfile_pic() {
        return profile_pic.get();
    }

    public int getTel() {
        return tel.get();
    }
   
   // setters 

    public void setNom(SimpleStringProperty nom) {
        this.nom = nom;
    }

    public void setAbout(SimpleStringProperty about) {
        this.about = about;
    }

    public void setAdresse(SimpleStringProperty adresse) {
        this.adresse = adresse;
    }

    public void setSiteweb(SimpleStringProperty siteweb) {
        this.siteweb = siteweb;
    }

    public void setTwitter(SimpleStringProperty twitter) {
        this.twitter = twitter;
    }

    public void setLinkdin(SimpleStringProperty linkdin) {
        this.linkdin = linkdin;
    }

    public void setFacebook(SimpleStringProperty facebook) {
        this.facebook = facebook;
    }

    public void setProfile_pic(SimpleStringProperty profile_pic) {
        this.profile_pic = profile_pic;
    }

    public void setTel(SimpleIntegerProperty tel) {
        this.tel = tel;
    }
    
    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public void setAbout(String about) {
        this.about =  new SimpleStringProperty(about);
    }

    public void setAdresse(String adresse) {
        this.adresse =  new SimpleStringProperty(adresse);
    }

    public void setSiteweb(String siteweb) {
        this.siteweb =  new SimpleStringProperty(siteweb);
    }

    public void setTwitter(String twitter) {
        this.twitter =  new SimpleStringProperty(twitter);
    }

    public void setLinkdin(String linkdin) {
        this.linkdin =  new SimpleStringProperty(linkdin);
    }

    public void setFacebook(String facebook) {
        this.facebook =  new SimpleStringProperty(facebook);
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic =  new SimpleStringProperty(profile_pic);
    }

    public void setTel(int tel) {
        this.tel =  new SimpleIntegerProperty(tel);
    }
    
    
}

