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
import static com.pi.controllers.LoginController.sendMail;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static tray.animations.AnimationType.FADE;
import static tray.notification.NotificationType.NOTICE;
import static tray.notification.NotificationType.SUCCESS;
import tray.notification.TrayNotification;


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
    private void addCan(MouseEvent event) throws IOException, Exception {
        int tel=0;
        int codep=0;
        DataValidation validator = new DataValidation();
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
        String vertoken=cToken(email) ; 
        String passchange="none" ; 
        if(validator.textNumeric(tfTel) && validator.textNumeric(tfCodePostal) )
        {
            if(validator.dataLength(tfTel,"8") && validator.dataLength(tfCodePostal,"4"))
            {
        tel= Integer.parseInt(tfTel.getText()) ; 
        codep= Integer.parseInt(tfCodePostal.getText()) ; 
            }
        }
        int type=0 ; 
        int status=0 ;
        String password="";
         
        password= BCrypt.hashpw(passwordToHash, BCrypt.gensalt());

        //Candidate c= new  Candidate(nom,prenom,pays,gouvernorat,adresse,birthday,pic,cv,about,tel,codep,email,password,type,role,typeC,status,vertoken,passchange);
        
        //CandidateDao can= new CandidateDao() ;
        //can.insert(c);
        if(validator.isNotEmpty(tfEmail) && validator.isNotEmpty(tfPassword) && validator.isNotEmpty(tfNom) && validator.isNotEmpty(tfPrenom) && validator.isNotEmpty(tfGouvernorat) && validator.isNotEmpty(tfAdresse) && validator.isNotEmpty(tfAboutyou) && validator.isNotEmpty(tfPic) && validator.isNotEmpty(tfCV) && validator.isNotEmpty(tfTel) && validator.isNotEmpty(tfCodePostal)
){
            if (validator.emailFormat(tfEmail) && validator.textNumeric(tfTel) && validator.textNumeric(tfCodePostal) && validator.dataLength(tfTel,"8") && validator.dataLength(tfCodePostal,"4") && validator.textAlphabet(tfNom) && validator.textAlphabet(tfPrenom) && validator.textAlphabet(tfGouvernorat) )
            {
         Candidate c= new  Candidate(nom,prenom,pays,gouvernorat,adresse,birthday,pic,cv,about,tel,codep,email,password,type,role,typeC,status,vertoken,passchange);
        
        CandidateDao can= new CandidateDao() ;
        can.insert(c);  
        String body = "Follow the link  http://127.0.0.1:8000/verify , Your verification token is "+vertoken;
        sendMail(email,body);
        TrayNotification tray = new TrayNotification("Account verification", "A link has been sent to your Email",NOTICE);
        tray.setAnimationType(FADE);
        tray.showAndWait();       
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
        }
        
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
    
    public String cToken(String passwordToHash )
    {
         
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        
        return generatedPassword ; 
    }
    
         public static void sendMail(String recepient , String body) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String myAccountEmail = "jobby.contact@gmail.com";
        //Your gmail password
        String password = "azerty147852369";

        //Create a session with account credentials
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        //Prepare email message
        Message message = prepareMessage(session, myAccountEmail, recepient , body);

        //Send mail
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient , String body) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Password Change Request");
            message.setText(body);
            return message;
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }  
  
}

    
