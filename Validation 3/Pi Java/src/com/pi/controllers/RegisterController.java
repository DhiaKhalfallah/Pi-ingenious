package com.pi.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.pi.Dao.CandidateDao;
import com.pi.Entities.Candidate;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import org.mindrot.jbcrypt.BCrypt;
import com.pi.controllers.DataValidation;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import java.util.Locale;


public class RegisterController implements Initializable {

    @FXML
    private AnchorPane container;
    @FXML
    private JFXButton createAccountButton;
    @FXML
    private ImageView exit;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfEmail;
    @FXML
    private DatePicker tfBday;
    @FXML
    private PasswordField tfPassword;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfGouvernorat;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfCodePostal;
    @FXML
    private TextField tfCV;
    @FXML
    private TextField tfPic;
    @FXML
    private TextArea tfAboutyou;
    @FXML
    private Label lb_email;
    @FXML
    private JFXComboBox<String> Tfpays;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> country = FXCollections.observableArrayList();
            String[] locales = Locale.getISOCountries();
            ArrayList<String> Pays = new ArrayList<String>()  ;
             for (String countryCode : locales) {

        Locale obj = new Locale("", countryCode);
               String n = obj.getDisplayCountry() ; 
               Pays.add(n);

    }

            country.addAll(Pays);          
             Tfpays.setItems(country);
    }

    @FXML
    private void open_login_form(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/pi/views/Login.fxml"));

        Scene scene = createAccountButton.getScene();

        root.translateYProperty().set(scene.getHeight());

        StackPane parentContainer = (StackPane) scene.getRoot();
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

    @FXML
    private void addCan(MouseEvent event) throws IOException {
         String email= tfEmail.getText() ; 
        String passwordToHash= tfPassword.getText() ; 
        String nom= tfNom.getText() ; 
        String prenom= tfPrenom.getText() ; 
        String pays= Tfpays.getValue(); ; 
        String gouvernorat= tfGouvernorat.getText(); 
        String adresse= tfAdresse.getText() ; 
        String birthday= String.valueOf(tfBday.getValue()) ; 
        String pic= tfPic.getText() ; 
        String cv= tfCV.getText() ; 
        String about= tfAboutyou.getText() ; 
        String role="[\"ROLE_CANDIDATE\"]" ; 
        String typeC="candidate" ; 
        String vertoken="Active" ; 
        String passchange="none" ; 
        int tel= Integer.parseInt(tfTel.getText()) ; 
        int codep= Integer.parseInt(tfCodePostal.getText()) ; 
        int type=0 ; 
        int status=0 ;
        String password="";
         
        password= BCrypt.hashpw(passwordToHash, BCrypt.gensalt());

       
        Candidate c= new  Candidate(nom,prenom,pays,gouvernorat,adresse,birthday,pic,cv,about,tel,codep,email,password,type,role,typeC,status,vertoken,passchange);
        
        CandidateDao can= new CandidateDao() ;
        can.insert(c);
        
        Parent root = FXMLLoader.load(getClass().getResource("/com/pi/views/Login.fxml"));

        Scene scene = createAccountButton.getScene();

        root.translateYProperty().set(scene.getHeight());

        StackPane parentContainer = (StackPane) scene.getRoot();
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
    private void uploadCV(MouseEvent event) {
                JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                tfCV.setText(imagepath);}
    }

    @FXML
    private void uploadPic(MouseEvent event) {
          JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                tfPic.setText(imagepath);
                        }
    }
    
  
}

    
