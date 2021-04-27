/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import art_comm.Entities.Event;
import eventcrud.Entities.Formation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class ItemFromController implements Initializable {

    private Text blogtitre;
    @FXML
    private ImageView img;
private Event event;
    private Text cat;
    @FXML
    private Text date;
    @FXML
    private JFXButton view;
     @FXML
    private Text nom;
      @FXML
    private Text datefin;
    private boolean tt;
public void setData(Formation f)
{
     date.setText(String.valueOf(f.getDateDebut()));;
     datefin.setText(String.valueOf(f.getDateFin()));
     nom.setText(f.getNom());
     int yas=250;
    
    
    
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void viewbt(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/pi/views/payement.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
            new FadeIn(root).play();
        } catch (IOException ex) {
            Logger.getLogger(ItemFromController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
}
}
