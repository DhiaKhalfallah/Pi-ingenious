/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.views;


import com.jfoenix.controls.JFXButton;
import entities.Offre;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Tools.JavaMailUtil;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import art_comm.services.OffreCrud;


/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class ItemOffreController implements Initializable {

    private Text blogtitre;
    @FXML
    private ImageView img;

    private Text cat;
    MouseEvent event;
    @FXML
    private Label idblog;
    private Label nbr;
    @FXML
    private Text blognom;
    @FXML
    private Text blogCategorie;
    @FXML
    private Text blogemail;
    @FXML
    private Text blogtitle;
    @FXML
    private Text blogdescription;
    @FXML
    private JFXButton btnsup;
    @FXML
    private Label idoffre;
public void setData(Offre blog) throws IOException
{
    
     int tel1= blog.getId();
        Integer tell = new Integer(tel1);
        String id = tell.toString();
        int tel11= blog.getCategorie();
        Integer tell1 = new Integer(tel11);
        String Categorie = tell.toString();
     
 idblog.setText(id);
 blognom.setText(blog.getNom());
 blogCategorie.setText(Categorie);
 blogemail.setText(blog.getEmail());
 blogtitle.setText(blog.getTitle());
    blogdescription.setText(blog.getDescription());
  
    btnsup.setOnAction(event -> {
        OffreCrud s=new OffreCrud();
s.DeleteOffre(tell);
 JavaMailUtil.sendMail("dhiaeddine.khalfallah@esprit.tn","L'offre est supprimer ");
     });
   
}
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }
    @FXML
    private void viewbt(MouseEvent event) throws IOException {   
  
    }


    @FXML
    private void Supprimer(ActionEvent event) {
        JavaMailUtil.sendMail("abderrahmen.driss@esprit.tn","L'offre est supprimer ");
        
    }

     
}
