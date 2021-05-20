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
import com.jobby.entities.Offre;
import com.jobby.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author RE flex
 */
public class OffreCrud {
 public ArrayList<Offre> cats;
    
    public static OffreCrud instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private OffreCrud() {
         req = new ConnectionRequest();
    }
public static OffreCrud getInstance() {
        if (instance == null) {
            instance = new OffreCrud();
        }
        return instance;
    }
  

    public ArrayList<Offre> parseOffres(String jsonText){
        try {
            cats=new ArrayList<>();
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

          
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
            //Parcourir la liste des tâches Json
            for(Map<String,Object> obj : list){
                //Création des tâches et récupération de leurs données
                Offre t = new Offre();
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
      public boolean addOffre(Offre o) {                
        String url = Statics.BASE_URL + "/admin/offre/json_addjob/" + o.getNom() + "/" +o.getEmail()+"/"+ o.getTitle()+"/"+o.getDescription()+"/"+o.getLogo()+"/"+o.getIdcategorie_id(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
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
   
    public ArrayList<Offre> getall(){
        String url = Statics.BASE_URL+"/offre/offresAll";
      
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cats = parseOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return cats;
    }

}

    
