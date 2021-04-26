package com.pi.controllers;

import animatefx.animation.FadeIn;
import art_comm.Controllers.ListBlogController;
import art_comm.Controllers.SplashScreenController;
import com.jfoenix.controls.JFXButton;
import com.pi.Dao.CandidateDao;
import com.pi.Entities.Candidate;
import drapo.dashboard.HomeController;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.mindrot.jbcrypt.BCrypt;
import static tray.animations.AnimationType.FADE;
import static tray.notification.NotificationType.SUCCESS;
import tray.notification.TrayNotification;

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
    private TextField Email;
    @FXML
    private PasswordField Password;
    @FXML
    private Label error;
    @FXML
    private Label reset;

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
//start
    @FXML
    private void Loging(MouseEvent event) throws IOException {
           
            CandidateDao c= new CandidateDao();
            Candidate ca = new Candidate();
            Candidate can = new Candidate();
            ca=c.authenticateUser(Email.getText(), Password.getText());
            FXMLLoader loader;
                     if (Email.getText().equals("admin") && Password.getText().equals("admin")  )
                       {
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
                     
          else  if (ca.equals(can))
            {
                              error.setText("Please Check Your Email!");

            }
            else
            {
                   String pwd=ca.getPassword();
                   String Hashed = "$2a" + pwd.substring(3);
                boolean test=BCrypt.checkpw(Password.getText(), Hashed);
           
                if (test)
            { System.out.println(test);
             String test1 = ca.getVer_token() ;
             
             if (test1.equals("Active"))
             {
            loader = new FXMLLoader( getClass().getResource( "/com/pi/views/Home.fxml" ));
              Scene scene = new Scene(loader.load());
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();   
              stage.setScene(scene);

  HomeController controller = loader.getController();
  controller.setSession(ca);

  stage.show();
             }
             else
             {
                                error.setText("Your Account is not verified!");
 
             }
            }
            
            else
            {
                error.setText("Please Check Your Password!");
            }

            }
          //  Parent root = FXMLLoader.load(getClass().getResource("/com/pi/views/Home.fxml"));
         
            //    Scene scene = new Scene(root);
                //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              //  stage.setScene(scene);
                //stage.show();
                //new FadeIn(root).play();
         
              


    }
    //end

    @FXML
    private void opendash(MouseEvent event) {
    }

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
    

    @FXML
    private void resetP(MouseEvent event) throws Exception {
        
        
                if (Email.getText() == null || Email.getText().trim().isEmpty())
        {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("Please enter an email to send the reset link to!");
                a.show();
        //

        }
          else
                {
                    
        String email = Email.getText();
        String Token = cToken(email);
        CandidateDao c= new CandidateDao();
        c.ResetPass(email, Token);
        String body = "Follow the link  http://127.0.0.1:8000/passchange , Your password change token is "+Token;
        sendMail(email,body);
        TrayNotification tray = new TrayNotification("Password Reset", "A link has been sent to your Email",SUCCESS);
        tray.setAnimationType(FADE);
        tray.showAndWait();
                }
        
        
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
    
    


