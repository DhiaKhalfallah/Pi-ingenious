/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.views;

import animatefx.animation.FadeIn;
import animatefx.animation.FlipInX;
import com.pi.Entities.Candidate;
import com.pi.controllers.ListData;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ItemController implements Initializable {

    @FXML
    private Label name;
   
    /**
     * Initializes the controller class.
     */
     ListData listdata = new ListData();
          private ObservableList<Candidate> candidate2=FXCollections.observableArrayList();
              private ObservableList<Candidate> candidateup=FXCollections.observableArrayList();

                  private ObservableList<Candidate> candidatedown=FXCollections.observableArrayList();

                  String Candidate[];
    @FXML
    private Pane flip;
    @FXML
    private Pane face;
    @FXML
    private ImageView image;
    @FXML
    private Label location;
    @FXML
    private Label adresse;
    @FXML
    private Label birthday;
    @FXML
    private Label tel;
    @FXML
    private Label about;
                  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }
    public void initData(Candidate can) throws FileNotFoundException {
        int tel1= can.getTel();
        Integer tell = new Integer(tel1);
        String mobile = tell.toString();
    name.setText(can.getNom()+" "+can.getPrenom());
    InputStream stream = new FileInputStream("C:\\Users\\Dhia\\Desktop\\Pi Java\\src\\com\\pi\\images\\5Head-Emote.png");
    Image image1 = new Image(stream);
    image.setImage(image1);
    location.setText(can.getPays());
    adresse.setText(can.getAdresse());
    birthday.setText(can.getBirthday());
    tel.setText(mobile);
    about.setText(can.getAbout_you());
    


  }
    
    
    
    

    @FXML
    private void flipback(MouseEvent event) {
                new FlipInX(face).play();
                face.toFront();

    }

    @FXML
    private void flip(MouseEvent event) {
        new FlipInX(flip).play();
         flip.toFront();

    }
    
}
