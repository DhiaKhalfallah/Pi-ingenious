package com.pi.controllers;

import animatefx.animation.FadeIn;
import art_comm.Controllers.ListBlogController;
import art_comm.Controllers.SplashScreenController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane container;
    @FXML
    private JFXButton loginButton;
    @FXML
    private ImageView exit;
    @FXML
    private JFXButton loginButton1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void open_registration_form(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/pi/views/Register.fxml"));

        Scene scene = loginButton.getScene();

        root.translateXProperty().set(scene.getWidth());

        StackPane parentContainer = (StackPane) scene.getRoot();
        parentContainer.getChildren().add(root);

        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(0.5), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished(event1 -> {
            parentContainer.getChildren().remove(container);
        });
        timeline.play();

    }

    @FXML
    private void exit(MouseEvent event) {
     System.exit(0);
    }

    @FXML
    private void Loging(MouseEvent event) throws IOException {
           
  
            Parent root = FXMLLoader.load(getClass().getResource("/com/pi/views/Home.fxml"));
         
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                new FadeIn(root).play();
         

    }

    @FXML
    private void opendash(MouseEvent event) {
    }

    @FXML
    private void LogAdmin(MouseEvent event) throws IOException {
                try {
            Thread.sleep(500);
                     Platform.runLater(new Runnable(){
                @Override
                public void run() {    
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/art_comm/Views/AcceuillB.fxml"));  
                    } catch (IOException ex) {
                        Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                    }
     Scene scene = new Scene(root);
        Stage stage =new Stage();
                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent t) {
            KeyCode key = t.getCode();
            if (key == KeyCode.ESCAPE){
                stage.close();
            }
        }
                });

        stage.setMaximized(true);

        stage.setScene(scene);
        
        stage.show();
                  
                    

         
                }
                         
                     });
     
        } catch (InterruptedException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

           
            

  
      
    }
    
    


