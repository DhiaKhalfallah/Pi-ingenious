/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import java.io.IOException;
import java.net.URL;
import javafx.stage.Stage;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class SplashScreenController implements Initializable {

    @FXML
    private StackPane rootps;
    @FXML
    private Pane rootpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       new SplashScreen().start(); 
        // TODO
    }    
      
class SplashScreen extends Thread{
    @Override
    public void run()  {
        try {
            Thread.sleep(5000);
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
                stage.initStyle(StageStyle.UNDECORATED);
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
        rootps.getScene().getWindow().hide();
                  
                    

         
                }
                         
                     });
     
        } catch (InterruptedException ex) {
            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
            }
}
      
}