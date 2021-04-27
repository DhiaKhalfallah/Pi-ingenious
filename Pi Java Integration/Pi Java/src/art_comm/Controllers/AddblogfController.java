/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import animatefx.animation.BounceIn;
import art_comm.Dao.BlogDao;
import art_comm.Entities.Blog;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class AddblogfController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private HBox reviews;
    @FXML
    private VBox rootpB;
    @FXML
    private Pane status;
    @FXML
    private Text back;
    @FXML
    private JFXTextField user;
    @FXML
    private JFXTextField cat;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField contenu;
    @FXML
    private JFXTextField titre;
    @FXML
    private JFXTextField imapa;
    @FXML
    private JFXButton add;
    @FXML
    private FontAwesomeIcon back2;
    @FXML
    private HBox dashboard;
    @FXML
    private TextField search;
    @FXML
    private JFXTextField id1;
    @FXML
    private Button View;
    @FXML
    private JFXButton attach;
    @FXML
    private Button backfont;
    @FXML
    private HBox blogd;
    @FXML
    private HBox sms;
    private Button full;
    @FXML
    private HBox events;
    @FXML
    private HBox userb;
    @FXML
    private HBox parti;
    @FXML
    private HBox btncategorie;
    @FXML
    private HBox btnoffre;
    @FXML
    private HBox reclamab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {add.setOnAction(event -> {
              String image=imapa.getText();
             image=image.replace("\\","\\\\");
               Blog p = new Blog(Integer.parseInt(user.getText()), cat.getText(),String.valueOf(date.getValue()) ,contenu.getText(), titre.getText(),image);
        BlogDao pdao = BlogDao.getInstance();
            pdao.insert(p);
          Image img = new Image("/art_comm/Views/img/443-4439064_blue-check-mark-icon-png-check-mark-circle-removebg-preview.png");
        Notifications notificatoinBuilder = Notifications.create()
                .title(" ADD SUCCESSFUL")
                .text("Blog Added ")
                //.graphic(new ImageView (img))
                .graphic (new ImageView(img))
                .hideAfter(Duration.seconds(5))
                        .position(Pos.BOTTOM_RIGHT);
                        notificatoinBuilder.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Blog insérée avec succés!");
        alert.show();
        
      // mailing 
        Properties prop = System.getProperties();
        prop.put("mail.smtp.port", "587");
         prop.put("mail.smtp.auth", true);
         prop.put("mail.smtp.starttls.enable", "true");
        Session newSession = Session.getDefaultInstance(prop, null);

        String emailsubject="Jobby Blog Added";
        String emailbody="Hello User with the ID: "+user.getText()+
                ", A blog has been added in Jobby with a title  "+titre.getText()+
               "At  "+String.valueOf(date.getValue())+" ";
        Message message = new MimeMessage(newSession);
        try {
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("hazemdawahi@gmail.com")); //Logger.getLogger(InscriptionEController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
        }
      try {
          message.setSubject(emailsubject);
      } catch (MessagingException ex) {
          Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
      }

         MimeBodyPart mimeBodyPart = new MimeBodyPart();
      try {
          mimeBodyPart.setContent(emailbody, "text/html");
      } catch (MessagingException ex) {
          Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
      }

          Multipart multipart = new MimeMultipart();
      try {
          multipart.addBodyPart(mimeBodyPart);
      } catch (MessagingException ex) {
          Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
      }


      try {
          message.setContent(multipart);
      } catch (MessagingException ex) {
          Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
      }

           String fromuser ="jobby.contact@gmail.com";
           String pass ="azerty147852369";
           String emailhost="smtp.gmail.com";
           Transport transport = null;
      try {
          transport = (Transport) newSession.getTransport("smtp");
      } catch (NoSuchProviderException ex) {
          Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          transport.connect(emailhost,fromuser,pass);
      } catch (MessagingException ex) {
          Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          transport.sendMessage( message, message.getAllRecipients());
      } catch (MessagingException ex) {
          Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          transport.close();
          
          //ajout d'une inscri
      } catch (MessagingException ex) {
          Logger.getLogger(AddBlogController.class.getName()).log(Level.SEVERE, null, ex);
      }
   
       
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Blog Added check your Mail");
        alert.show();
             

                    
         });
        new BounceIn(status).play();               LocalDate localDate = LocalDate.now();
    date.setValue(localDate);
    
    
               final Tooltip tooltip2= new Tooltip();
        tooltip2.setText("Ajout Dans la base de donnees ");
        add.setTooltip(tooltip2);
        tooltip2.setStyle("-fx-background-color: #0fbcf9");
              final Tooltip tooltip3= new Tooltip();
        tooltip3.setText("Attacher une image");
        attach.setTooltip(tooltip3);
        tooltip3.setStyle("-fx-background-color: #0fbcf9");
                 final Tooltip tooltip4= new Tooltip();
        tooltip4.setText("Afficher les blogs");
        attach.setTooltip(tooltip4);
        tooltip4.setStyle("-fx-background-color: #0fbcf9");
        
        // TODO
    }    


    private void reviews(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/CommentaireFront.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }



    @FXML
    private void add(MouseEvent event) {
        if(user.getText().length()==0)
        {
            user.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(user).play();
        }
        else
            user.setStyle(null);
         if(cat.getText().length()==0)
        {
            cat.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(cat).play();
        }
        else
            cat.setStyle(null);
          if(contenu.getText().length()==0)
        {
            contenu.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(contenu).play();
        }
        else
            contenu.setStyle(null);
           if(titre.getText().length()==0)
        {
            titre.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(titre).play();
        }
        else
            titre.setStyle(null);
            if(imapa.getText().length()==0)
        {
            imapa.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(imapa).play();
        }
        else
            imapa.setStyle(null);
    }

    @FXML
    private void back2bt(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AcceuillB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void backbt(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AcceuillB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void dashboardbt(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AcceuillB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }




    @FXML
    private void view(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/BlogFront.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void attach(MouseEvent event) {
                            JFileChooser chooser = new JFileChooser();
         chooser.showOpenDialog(null);
         File f = chooser.getSelectedFile();
         String filename =f.getAbsolutePath();
         imapa.setText(filename);
         Image getAbsolutePath = null;
         ImageIcon icon = new ImageIcon(filename);
    }

    @FXML
    private void blogbt(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/BlogFront.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void backfontaw(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/BlogFront.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void smsbt(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/smsb.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void fullb(MouseEvent event) {
            Stage stage = (Stage) full.getScene().getWindow();
       stage.setFullScreen(true);
    }

    @FXML
    private void userbt(MouseEvent event) {
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/listeC.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void eventbt(MouseEvent event) {
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/EventBackend.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void partibt(MouseEvent event) {
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/partiB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void reclabt(MouseEvent event) {
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/ListeRec.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void reviewsbt(MouseEvent event) {
                        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/CommentaireFront.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void eventsbt(MouseEvent event) {
                                try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/EventBackend.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btncat(MouseEvent event) {
                                try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AcceuillC.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnoffre(MouseEvent event) {
                                try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AcceuillO.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}
