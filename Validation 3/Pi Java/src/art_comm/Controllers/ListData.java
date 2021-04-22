/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import art_comm.Dao.BlogDao;
import art_comm.Dao.CommentaireDao;
import art_comm.Entities.Blog;
import art_comm.Entities.Commentaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author LEGION
 */
public class ListData {
    private ObservableList<Blog> Blog=FXCollections.observableArrayList();
    private ObservableList<Commentaire> comm=FXCollections.observableArrayList();
    
     public ListData() {
        
        BlogDao pdao=BlogDao.getInstance();
        Blog= pdao.displayAll();
         CommentaireDao pdao2=CommentaireDao.getInstance();
        comm= pdao2.displayAll();
    }
    
    public ObservableList<Blog>getBlog(){
        return Blog;
    }
    public ObservableList<Commentaire>getComm(){
        return comm;
    }  
}
