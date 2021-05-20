/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.jobby.services.*;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.jobby.entities.Event;
import com.jobby.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LEGION
 */
public class serviceEvent {
     public static serviceEvent instance =null;
      private ConnectionRequest req;
          public static serviceEvent getInstance()
    {
       if (instance == null )
           instance = new serviceEvent();
       return instance;
       
       
    }
              private static boolean resultOK=true;

               public serviceEvent()
    {
        req=new ConnectionRequest();
    }
                public void ajoutReclamation(Event event )
    {
        req = new ConnectionRequest();
        
    }
                     public void ajoutEvent(Event e)
     {
         String url=Statics.BASE_URL+"/event/addevent?nbr="+e.getNbr()+"&par_id="+e.getPar_id()+"&ent_id="+e.getEnt_id()+"&description="+e.getDescription()+"&nom="+e.getNom()+"&image="+e.getImage()+"&categorie="+e.getCategorie()+"&backcolor="+e.getBackcolor()+"&bordercolor="+e.getBordercolor()+"&textcolor="+e.getTextcolor();
         req.setUrl(url);
         req.addResponseListener((el) ->
         {
             String str = new String(req.getResponseData());
             System.out.println("data=="+str);
             
         });
         NetworkManager.getInstance().addToQueueAndWait(req);
         
     }    
                     
                     
public ArrayList<Event>affichageblog()
{
ArrayList<Event>result = new ArrayList<>();
String url =Statics.BASE_URL+"/event/displayevent";
req.setUrl(url);
req.addResponseListener(new ActionListener<NetworkEvent>()
{
 @Override
 public void actionPerformed(NetworkEvent evt)
 {
    JSONParser jsonp;
    jsonp= new JSONParser();
    try{
        Map<String,Object>mapReclamations =jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
        List<Map<String,Object>> listOfMaps =(List<Map<String,Object>>) mapReclamations.get("root");
       for(Map<String,Object> obj:listOfMaps)
       {
           Event bl  = new Event();
           float id =Float.parseFloat(obj.get("id").toString());
             float nbr =Float.parseFloat(obj.get("nbr").toString());
          String nom =obj.get("nom").toString();
             String description =obj.get("description").toString();
                String image =obj.get("image").toString();
                String categorie= obj.get("categorie").toString();
                bl.setNbr((int)nbr);
                bl.setId((int)id);
                bl.setNom(nom);
                bl.setDescription(description);
                bl.setImage(image);
                bl.setCategorie(categorie);
result.add(bl);
          
       }
    }catch(Exception ex)
    {
        ex.printStackTrace();
    }
 }

        
});
NetworkManager.getInstance().addToQueueAndWait(req);
return result;
}
/**
public Blog detailBlog(int id,Blog blog)
{
    String url =Statics.BASE_URL+"/detailBlog?"+id;
    req.setUrl(url);
    String str = new String (req.getResponseData());
    req.addResponseListener(((evt) -> {
        JSONParser jsonp = new JSONParser();
        try{
            Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
            blog.setCat(obj.get("cat").toString());
                        blog.setContenu(obj.get("contenu").toString());
            blog.setTitre(obj.get("titre").toString());

        }catch(IOException ex)
        {
            System.out.println("error related to sql :("+ex.getMessage());
        }
        System.out.println("data == "+str);
    }
    ));
    NetworkManager.getInstance().addToQueueAndWait(req);
return blog;
}
   **/ 
public boolean deleteEvent(int id)
{
    String url =Statics.BASE_URL+"/event/deleteEvent?id="+id;
    req.setUrl(url);
    req.addResponseListener(new ActionListener<NetworkEvent>(){
      

        @Override
        public void actionPerformed(NetworkEvent evt) {     
            req.removeResponseCodeListener(this);

        }
    
});
    NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOK;
}
  public boolean modifierEvent(Event event)
{
    String url = Statics.BASE_URL+"/event/updateevent?id="+event.getId()+"&nbr=5"+event.getNbr()+"&description="+event.getDescription()+"&nom="+event.getNom()+"&image="+event.getImage()+"&categorie="+event.getCategorie();
    req.setUrl(url);
    req.addResponseListener(new ActionListener<NetworkEvent>(){
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
