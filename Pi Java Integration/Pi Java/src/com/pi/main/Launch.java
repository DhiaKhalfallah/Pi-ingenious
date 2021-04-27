package com.pi.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author PC
 */
public class Launch extends Application {
    double x,y =0 ;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/pi/views/Start.fxml"));   

        Scene scene = new Scene(root,1280,720);
        stage.initStyle(StageStyle.UNDECORATED);
       
       
        stage.setScene(scene);
        stage.setTitle("Jooby");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
