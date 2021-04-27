/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.views;

import animatefx.animation.FlipInX;
import animatefx.animation.Tada;
import com.pi.Entities.Candidate;
import com.pi.Entities.Reclamation;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;


/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ClaimController implements Initializable {

    @FXML
    private Label details;
    @FXML
    private Label id;
    @FXML
    private Label status;
    @FXML
    private Label Submit;
    @FXML
    private Label email;
    @FXML
    private Label Subject;
    @FXML
    private Pane face;
    @FXML
    private Pane flip;
    @FXML
    private Label status1;
    @FXML
    private Label id1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void initData(Reclamation rec) throws FileNotFoundException {
        int tel1= rec.getId();
        Integer tell = new Integer(tel1);
        String idt = tell.toString();
    id.setText(idt);
    id1.setText(idt);
    if (rec.getCstatus()==1)
    {status.setText("In progress");
      status.setStyle("-fx-text-fill: red;");
      status1.setText("In progress");
      status1.setStyle("-fx-text-fill: red;");
    }
    else
    {
        status.setText("Closed");
      status.setStyle("-fx-text-fill: green;");
        status1.setText("Closed");
      status1.setStyle("-fx-text-fill: green;");
    }
    email.setText(rec.getUser_email());
    Subject.setText(rec.getSubject());
    Submit.setText(rec.getSubmit_date());
    details.setText(rec.getClaim());
    


  }

    @FXML
    private void switchback(MouseEvent event) {
           new Tada(face).play();
                face.toFront();

    }

    @FXML
    private void siwtch(MouseEvent event) {
            new Tada(flip).play();
         flip.toFront();
    }
    
}
