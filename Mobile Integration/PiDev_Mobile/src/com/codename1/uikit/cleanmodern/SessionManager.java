/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.io.Preferences;

/**
 *
 * @author Dhia
 */
public class SessionManager {
    
     public static Preferences pref;
       private static int id ; 
       private static int tel ; 
       private static String email ; 
       private static String password ; 
       private static String about ;
       private static String nom ;
       private static String prenom ; 

 public static Preferences getPref() {
        return pref;
    }

    public static void setPref(Preferences pref) {
        SessionManager.pref = pref;
    }
    
     public static int getId() {
        return pref.get("id",id);
     }
    public static void setId(int id) {
        pref.set("id",id);
    }
    public static int getTel() {
        return pref.get("tel",tel);
     }
    public static void setTel(int tel) {
        pref.set("tel",tel);
    }


    public static String getEmail() {
        return pref.get("email",email);
    }

    public static void setEmail(String email) {
         pref.set("email",email);
    }

    public static String getPassword() {
        return pref.get("password",password);
    }

    public static void setPassword(String password) {
         pref.set("password",password);
    }

    public static String getAbout() {
        return pref.get("about",about);
    }

    public static void setAbout(String about) {
         pref.set("about",about);
    }
    
    public static String getPrenom() {
        return pref.get("prenom",prenom);
    }

    public static void setPrenom(String prenom) {
         pref.set("prenom",prenom);
    }
     public static String getNom() {
        return pref.get("nom",nom);
    }

    public static void setNom(String nom) {
         pref.set("nom",nom);
    }

    
}
