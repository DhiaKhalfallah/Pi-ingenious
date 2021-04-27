/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import art_comm.Dao.BlogDao;
import art_comm.Dao.CommentaireDao;
import art_comm.Dao.EventDao;
import art_comm.Dao.ParticipantDao;
import art_comm.Entities.Blog;
import art_comm.Entities.Commentaire;
import art_comm.Entities.Event;
import art_comm.Entities.Participant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LEGION
 */
public class ListData {
   private ObservableList<Blog> Blog=FXCollections.observableArrayList();
    private ObservableList<Commentaire> comm=FXCollections.observableArrayList();
        private ObservableList<Blog> BlogP=FXCollections.observableArrayList();
            private ObservableList<Blog> BlogN=FXCollections.observableArrayList();
                private ObservableList<Blog> BlogO=FXCollections.observableArrayList();
        private ObservableList<Participant> par=FXCollections.observableArrayList();
    private ObservableList<Event> event=FXCollections.observableArrayList();
    
        private ObservableList<Event> week=FXCollections.observableArrayList();

            private ObservableList<Event> today=FXCollections.observableArrayList();

                private ObservableList<Event> month=FXCollections.observableArrayList();

                    private ObservableList<Event> upcoming=FXCollections.observableArrayList();

     ParticipantDao pdao4=ParticipantDao.getInstance();
     public ListData() {
      BlogDao pdao=BlogDao.getInstance();
        Blog= pdao.displayAll();
        BlogP= pdao.Popular();
        BlogN=pdao.Newest();
        BlogO=pdao.Oldest();
         CommentaireDao pdao2=CommentaireDao.getInstance();
        comm= pdao2.displayAll();
            par = pdao4.displayAll();
        System.out.println(par);
         EventDao pdao5=EventDao.getInstance();
        event= pdao5.displayAll();
        System.out.println(event);
          today= pdao5.today();
  month= pdao5.month();
    upcoming= pdao5.upcoming();
        
    }
    

      public ObservableList<Blog>getBlog(){
        return Blog;
    }
     public ObservableList<Blog>getblogp(){
        return BlogP;
    }
      public ObservableList<Blog>getblogn(){
        return BlogN;
    }
       public ObservableList<Blog>getBlogO(){
        return BlogO;
    }
    public ObservableList<Commentaire>getComm(){
        return comm;
    }
        public ObservableList<Participant>getParticipaant(){
        return par;
    }
    public ObservableList<Event>getEvent(){
        return event;
    } 
     public ObservableList<Event>gettoday(){
        return today;
    } 
      public ObservableList<Event>getmonth(){
        return month;
    } 
       public ObservableList<Event>getupcoming(){
        return upcoming;
    } 
     
}
