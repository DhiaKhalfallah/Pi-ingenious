/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import art_comm.Dao.BlogDao;
import art_comm.Entities.Blog;
import java.io.File;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
import javax.swing.JFileChooser;
import org.controlsfx.control.Notifications;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class AddBlogController implements Initializable {

    @FXML
    private Label userl;
    @FXML
    private Label catl;
    @FXML
    private Label datel;
    @FXML
    private Label imagel;
    @FXML
    private Label contenul;
    @FXML
    private Label titrel;
    @FXML
    private TextField user;
    @FXML
    private TextField cat;
    @FXML
    private DatePicker date;
    @FXML
    private TextField contenu;
    @FXML
    private TextField titre;
    @FXML
    private Button add;
    @FXML
    private Button attach;
    @FXML
    private TextField imapa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         add.setOnAction(event -> {
                if ((user.getText()!=null)&&( date.getValue()!=null)&&(cat.getText()!=null)&&(contenu.getText()!=null)&&(titre.getText()!=null)&&(imapa.getText()!=null))
                    {
               Blog p = new Blog(Integer.parseInt(user.getText()), cat.getText(),String.valueOf(date.getValue()) ,contenu.getText(), titre.getText(),imapa.getText());
        BlogDao pdao = BlogDao.getInstance();
            pdao.insert(p);
            
          String title = "Commentaire Added";
        String message2 = "Your Comment has been added";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message2);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (2200));
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
             

                    }   
         });
         
    }    

    @FXML
    private void add(KeyEvent event) {
    }

    @FXML
    private void attach(MouseEvent event) {
          JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                imapa.setText(imagepath);
    }
    
}
}
