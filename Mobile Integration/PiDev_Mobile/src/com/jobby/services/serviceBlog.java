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
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.jobby.entities.Blog;
import com.jobby.entities.Commentaire;
import com.jobby.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 *
 * @author LEGION
 */
public class serviceBlog {
    public static serviceBlog instance =null;
    
    private ConnectionRequest req;
    public static serviceBlog getInstance()
    {
       if (instance == null )
           instance = new serviceBlog();
       return instance;
       
       
    }
    private static boolean resultOK=true;
  
    public serviceBlog()
    {
        req=new ConnectionRequest();
    }
    public void ajoutReclamation(Blog blog )
    {
        req = new ConnectionRequest();
        
    }
     public void ajoutBlog(Blog blog)
     {
         
         String url=Statics.BASE_URL+"/blog/addblog?&user="+blog.getUser()+"&cat="+blog.getCat()+"&contenu="+blog.getContenu()+"&titre="+blog.getTitre();
         req.setUrl(url);
         req.addResponseListener((e) ->
         {
             String str = new String(req.getResponseData());
             
         });
         NetworkManager.getInstance().addToQueueAndWait(req);
         
     }    
      public void ajoutComm(Commentaire comm)
     {
         System.out.println(comm.getBlog_id());
         String url=Statics.BASE_URL+"/commentaire/addcomm?user="+comm.getUser()+"&nom="+comm.getNom()+"&mail="+comm.getMail()+"&subject="+comm.getSubject()+"&mobile="+comm.getMobile()+"&commentaire="+comm.getCommentaire()+"&subject="+comm.getSubject()+"&blog_id="+comm.getBlog_id()+"&rate="+comm.getRate();
         req.setUrl(url);
         req.addResponseListener((e) ->
         {
             String str = new String(req.getResponseData());
             
         });
         NetworkManager.getInstance().addToQueueAndWait(req);
         
     }    
public ArrayList<Commentaire>affichagecomm(int bbid)
{
ArrayList<Commentaire>result = new ArrayList<>();
String url =Statics.BASE_URL+"/commentaire/displayComm";
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
           Commentaire bl  = new Commentaire();
           float id =Float.parseFloat(obj.get("id").toString());
          float rate =Float.parseFloat(obj.get("rate").toString()); 
          float blogt =Float.parseFloat(obj.get("blogId").toString());
                    float user =Float.parseFloat(obj.get("user").toString());

          String nom =obj.get("nom").toString();
             String subject =obj.get("subject").toString();
                String commentaire =obj.get("commentaire").toString();
                
            
                
                bl.setRate((int)rate);
                
                              bl.setId((int)id);
                               bl.setUser((int)user);

                bl.setNom(nom);
                bl.setSubject(subject);
                 bl.setCommentaire(commentaire);
                 if(bbid==(int)blogt)
                     
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
public ArrayList<Blog>affichageblog()
{
ArrayList<Blog>result = new ArrayList<>();
String url =Statics.BASE_URL+"/blog/displayblog";
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
           Blog bl  = new Blog();
           float id =Float.parseFloat(obj.get("id").toString());
          float user =Float.parseFloat(obj.get("user").toString());  
          String cat =obj.get("cat").toString();
             String contenu =obj.get("contenu").toString();
                String titre =obj.get("titre").toString();
                bl.setUser((int)user);
                              bl.setId((int)id);

                bl.setCat(cat);
                bl.setContenu(contenu);
                 bl.setTitre(titre);
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
public Blog detailBlog(int id,Blog blog)
{
    String url =Statics.BASE_URL+"/blog/detailBlog?id="+id;
    req.setUrl(url);
    String str = new String (req.getResponseData());
    req.addResponseListener(((evt) -> {
        JSONParser jsonp = new JSONParser();
        try{
            Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
            
        

        }catch(IOException ex)
        {
            System.out.println("error related to sql :("+ex.getMessage());
        }
        System.out.println("data detail == "+str);
    }
    ));
    NetworkManager.getInstance().addToQueueAndWait(req);
return blog;
}
public boolean deleteBlog(int id)
{
    String url =Statics.BASE_URL+"/blog/deleteBlog?id="+id;
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
public boolean modifierBlog(Blog blog)
{
    String url = Statics.BASE_URL+"/blog/updateBlog?id="+blog.getId()+"&user="+blog.getUser()+"&cat="+blog.getCat()+"&contenu="+blog.getContenu()+"&titre="+blog.getTitre();
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
public boolean deleteComm(int id)
{
    String url =Statics.BASE_URL+"/commentaire/deleteComm?id="+id;
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
public boolean modifierComm(Commentaire comm)
{
    String url = Statics.BASE_URL+"/commentaire/updateComm?id="+comm.getId()+"&user="+comm.getUser()+"&nom="+comm.getMail()+"&mail="+comm.getMail()+"&subject="+comm.getSubject()+"&mobile="+comm.getMobile()+"&commentaire="+comm.getCommentaire()+"&subject="+comm.getSubject()+"&blog_id="+comm.getBlog_id()+"&rate="+comm.getRate();
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