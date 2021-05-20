/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobby.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.codename1.uikit.cleanmodern.NewsfeedForm;
import com.codename1.uikit.cleanmodern.ProfileForm;
import com.jobby.entities.Candidate;
import com.codename1.uikit.cleanmodern.SessionManager;
import com.jobby.utils.Sms;
import com.jobby.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dhia
 */
public class UserService {
    
      public ArrayList<Candidate> tasks;
    
    public static UserService instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private UserService() {
         req = new ConnectionRequest();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
      public boolean addUser(Candidate t) {
        String url = Statics.BASE_URL + "/signup/new?mail="+t.getEmail()+"&nom="+t.getNom()+"&prenom="+t.getPrenom()+"&tel="+t.getTel()+"&pays="+t.getPays()+"&gouvernorat="+t.getGouvernorat()+"&postal="+t.getCode_postal()+"&about="+t.getAbout_you()+"&adresse="+t.getAdresse()+"&date="+t.getBirthday()+"&pass="+t.getPassword(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion        
        //req.setPost(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
      
      public void signin(TextField username , TextField pass , Resources rs)
      {
          String url = Statics.BASE_URL + "/signin?mail="+username.getText().toString()+"&password="+pass.getText().toString(); //création de l'URL
        req.setUrl(url);
        
        req.addResponseListener((e) ->{
             System.out.println("haaaaaa");
             JSONParser j = new JSONParser();
             String json = new String(req.getResponseData())+ "";
             
             try 
             {
                 if(json.equals("failed"))
                 {
                 Dialog.show("Login failed","Check Credentials","OK",null);
                 }
                 else
                 {
                     System.out.println(" data = " +json);
                    Map<String,Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    
                     //Session  Service
                float id = Float.parseFloat(user.get("username").toString());
                SessionManager.setId((int)id);
                float tel = Float.parseFloat(user.get("tel").toString());
                SessionManager.setTel((int)tel+2);
                SessionManager.setPassword(user.get("password").toString());
                SessionManager.setAbout(user.get("aboutYou").toString());
                SessionManager.setEmail(user.get("email").toString());
                SessionManager.setNom(user.get("nom").toString());
                
                SessionManager.setPrenom(user.get("prenom").toString());
                
                 Sms s = new Sms(); 
                 s.sendsms(SessionManager.getTel());
                    
                    if ( user.size() > 0 )
                    {
                        new NewsfeedForm(rs).show() ;
                    }
                 }
             } catch (Exception ex) {
               ex.printStackTrace();
             }
             
        
        });
                NetworkManager.getInstance().addToQueueAndWait(req);

          
      }
       public boolean addClaim(TextField s , TextArea d) {
           java.util.Date date=new java.util.Date();  
        String url = Statics.BASE_URL + "/contact/new?mail="+SessionManager.getEmail()+"&id="+SessionManager.getId()+"&date="+date+"&status="+0+"&claim="+d.getText()+"&subject="+s.getText(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion        
        //req.setPost(true);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
}
