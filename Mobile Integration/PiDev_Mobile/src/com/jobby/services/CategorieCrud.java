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
import com.codename1.ui.events.ActionListener;
import com.jobby.entities.CategorieOffre;
import com.jobby.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RE flex
 */
public class CategorieCrud {
      public ArrayList<CategorieOffre> cats;
    
    public static CategorieCrud instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private CategorieCrud() {
         req = new ConnectionRequest();
    }
public static CategorieCrud getInstance() {
        if (instance == null) {
            instance = new CategorieCrud();
        }
        return instance;
    }
    public boolean addCategorieOffre(CategorieOffre t) {
        String url = Statics.BASE_URL + "/CategorieOffres/" + t.getLogo() + "/" + t.getNom()+ "/" + t.getColor(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); 
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<CategorieOffre> parseCategorieOffres(String jsonText){
        try {
            cats=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

          
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                CategorieOffre t = new CategorieOffre();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                //t.setStatus(((int)Float.parseFloat(obj.get("status").toString())));
                t.setNom(obj.get("nom").toString());
                //Ajouter la tâche extraite de la réponse Json à la liste
                //t.setType(obj.get("type").toString());
                cats.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        
        return cats;
    }
      public ArrayList<CategorieOffre> getCat(String name){
        String url = Statics.BASE_URL+"/categorieoffre/json_getcat/"+name;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cats = parseCategories2(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cats;
    }
       public ArrayList<CategorieOffre> parseCategories2(String jsonText){
        try {
            cats=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

          
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                CategorieOffre t = new CategorieOffre();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                cats.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        
        return cats;
    }
    public ArrayList<CategorieOffre> getAllCats(){
        String url = Statics.BASE_URL+"/categorieoffre/categoriesAll";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cats = parseCategorieOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cats;
    }
    
    public boolean addcat(CategorieOffre c) {
         String url = Statics.BASE_URL + "/addcat?nom=" + c.getNom()+ "&type=" + c.getLogo()+ "&color=" + c.getColor(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; 
                req.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
}
