package com.pi.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartController implements Initializable {

    @FXML
    private StackPane parentContainer;
    @FXML
    private AnchorPane container;
    @FXML
    private JFXButton getStartedButton;
    @FXML
    private ImageView exit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void open_login(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/pi/views/Login.fxml"));

        Scene scene = getStartedButton.getScene();
       
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
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

}
