/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;
import animatefx.animation.BounceIn;
import art_comm.Dao.ParticipantDao;
import art_comm.Entities.Participant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class AddppartiBController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private FontAwesomeIcon back2;
    @FXML
    private Text back;
    @FXML
    private HBox dashboard;
    @FXML
    private HBox reviews;
    @FXML
    private HBox parti;
    @FXML
    private HBox blogd;
    @FXML
    private HBox sms;
    @FXML
    private VBox rootpB;
    @FXML
    private Pane status;
    @FXML
    private Button backfont;
    @FXML
    private TextField search;
    @FXML
    private Button View;
    @FXML
    private JFXButton add;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField user;
   
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField nom;
    @FXML
    private JFXTextField mail;
    @FXML
    private JFXTextField mobile;
    @FXML
    private JFXTextField eventid;
    @FXML
    private HBox contact;
    @FXML
    private HBox userb;
    @FXML
    private HBox events;
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
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            new BounceIn(status).play();               LocalDate localDate = LocalDate.now();
    date.setValue(localDate);
                add.setOnAction(event -> {
      String testData[] = {
	    		mail.getText()
	          };
      boolean x=isAddressValid(mail.getText());
      System.out.println(x);
                   
                        if((x)&&(user.getText()!=null)&&(nom.getText()!=null)&&(eventid.getText()!=null)&&(date.getValue()!=null)&&(mobile.getText()!=null))
                        { 
                        Participant p = new Participant(Integer.parseInt(user.getText()), Integer.parseInt(eventid.getText()),String.valueOf(date.getValue()),nom.getText(), mail.getText(),Integer.parseInt(mobile.getText())); //  }             //  }
                        ParticipantDao pdao = ParticipantDao.getInstance();
                        pdao.insert(p);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Participant insérée avec succés!");
                        alert.show();
                        // mailing
                        Properties prop = System.getProperties();
                        prop.put("mail.smtp.port", "587");
                        prop.put("mail.smtp.auth", true);
                        prop.put("mail.smtp.starttls.enable", "true");
                        Session newSession = Session.getDefaultInstance(prop, null);
                        String emailsubject="Jobby participant Added";
                        String emailbody="Hello User with the ID: "+user.getText()+
                                
                                "At  "+String.valueOf(date.getValue())+" ";
                        Message message = new MimeMessage(newSession);
                        try {
                            message.addRecipient(Message.RecipientType.TO, new InternetAddress("eyajdir7@gmail.com")); //Logger.getLogger(InscriptionEController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (MessagingException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            message.setSubject(emailsubject);
                        } catch (MessagingException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        MimeBodyPart mimeBodyPart = new MimeBodyPart();
                        try {
                            mimeBodyPart.setContent(emailbody, "text/html");
                        } catch (MessagingException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Multipart multipart = new MimeMultipart();
                        try {
                            multipart.addBodyPart(mimeBodyPart);
                        } catch (MessagingException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            message.setContent(multipart);
                        } catch (MessagingException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String fromuser ="jobby.contact@gmail.com";
                        String pass ="azerty147852369";
                        String emailhost="smtp.gmail.com";
                        Transport transport = null;
                        try {
                            transport = (Transport) newSession.getTransport("smtp");
                        } catch (NoSuchProviderException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            transport.connect(emailhost,fromuser,pass);
                        } catch (MessagingException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            transport.sendMessage( message, message.getAllRecipients());
                        } catch (MessagingException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            transport.close();
                            
                            //ajout d'une inscri
                        } catch (MessagingException ex) {
                            Logger.getLogger(AddppartiBController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Participant Added check your Mail");
                        alert.show();
                    }
        });
  
    }
        static int hear( BufferedReader in ) throws IOException {
      String line = null;
      int res = 0;
      while ( (line = in.readLine()) != null ) {
          String pfx = line.substring( 0, 3 );
          try {
             res = Integer.parseInt( pfx );
          } 
          catch (Exception ex) {
             res = -1;
          }
          if ( line.charAt( 3 ) != '-' ) break;
      }
      return res;
      }
    private static void say( BufferedWriter wr, String text ) 
       throws IOException {
      wr.write( text + "\r\n" );
      wr.flush();
      return;
      }
    private static ArrayList getMX( String hostName )
          throws NamingException {
      // Perform a DNS lookup for MX records in the domain
      Hashtable env = new Hashtable();
      env.put("java.naming.factory.initial",
              "com.sun.jndi.dns.DnsContextFactory");
      DirContext ictx = new InitialDirContext( env );
      Attributes attrs = ictx.getAttributes
                            ( hostName, new String[] { "MX" });
      Attribute attr = attrs.get( "MX" );
      // if we don't have an MX record, try the machine itself
      if (( attr == null ) || ( attr.size() == 0 )) {
        attrs = ictx.getAttributes( hostName, new String[] { "A" });
        attr = attrs.get( "A" );
        if( attr == null ) 
             throw new NamingException
                      ( "No match for name '" + hostName + "'" );
      }
      // Huzzah! we have machines to try. Return them as an array list
      // NOTE: We SHOULD take the preference into account to be absolutely
      //   correct. This is left as an exercise for anyone who cares.
      ArrayList res = new ArrayList();
      NamingEnumeration en = attr.getAll();
      while ( en.hasMore() ) {
         String x = (String) en.next();
         String f[] = x.split( " " );
         if ( f[1].endsWith( "." ) ) 
             f[1] = f[1].substring( 0, (f[1].length() - 1));
         res.add( f[1] );
      }
      return res;
      }
    public static boolean isAddressValid( String address ) {
      // Find the separator for the domain name
      int pos = address.indexOf( '@' );
      // If the address does not contain an '@', it's not valid
      if ( pos == -1 ) return false;
      // Isolate the domain/machine name and get a list of mail exchangers
      String domain = address.substring( ++pos );
      ArrayList mxList = null;
      try {
         mxList = getMX( domain );
      } 
      catch (NamingException ex) {
         return false;
      }
      // Just because we can send mail to the domain, doesn't mean that the
      // address is valid, but if we can't, it's a sure sign that it isn't
      if ( mxList.size() == 0 ) return false;
      // Now, do the SMTP validation, try each mail exchanger until we get
      // a positive acceptance. It *MAY* be possible for one MX to allow
      // a message [store and forwarder for example] and another [like
      // the actual mail server] to reject it. This is why we REALLY ought
      // to take the preference into account.
      for ( int mx = 0 ; mx < mxList.size() ; mx++ ) {
          boolean valid = false;
          try {
              int res;
              Socket skt = new Socket( (String) mxList.get( mx ), 25 );
              BufferedReader rdr = new BufferedReader
                 ( new InputStreamReader( skt.getInputStream() ) );
              BufferedWriter wtr = new BufferedWriter
                 ( new OutputStreamWriter( skt.getOutputStream() ) );
              res = hear( rdr );
              if ( res != 220 ) throw new Exception( "Invalid header" );
              say( wtr, "EHLO orbaker.com" );
              res = hear( rdr );
              if ( res != 250 ) throw new Exception( "Not ESMTP" );
              // validate the sender address  
              say( wtr, "MAIL FROM: <tim@orbaker.com>" );
              res = hear( rdr );
              if ( res != 250 ) throw new Exception( "Sender rejected" );
              say( wtr, "RCPT TO: <" + address + ">" );
              res = hear( rdr );
              // be polite
              say( wtr, "RSET" ); hear( rdr );
              say( wtr, "QUIT" ); hear( rdr );
              if ( res != 250 ) 
                 throw new Exception( "Address is not valid!" );
              valid = true;
              rdr.close();
              wtr.close();
              skt.close();
          } 
          catch (Exception ex) {
            // Do nothing but try next host
          } 
          finally {
            if ( valid ) return true;
          }
      }
      return false;
      }
    public  String call_this_to_validate( String email ) {
        String testData[] = {email};
        String return_string="";
        for ( int ctr = 0 ; ctr < testData.length ; ctr++ ) {
        	return_string=( testData[ ctr ] + " is valid? " + 
                 isAddressValid( testData[ ctr ] ) );
        }
        return return_string;
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void backfontaw(MouseEvent event) {
               try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/partiB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void view(MouseEvent event) {
               try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/partiB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
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
         if(eventid.getText().length()==0)
        {
            eventid.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(eventid).play();
        }
        else
            eventid.setStyle(null);
          if(nom.getText().length()==0)
        {
            nom.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(nom).play();
        }
        else
            nom.setStyle(null);
           if(mail.getText().length()==0)
        {
            mail.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(mail).play();
        }
        else
            mail.setStyle(null);
            if(mobile.getText().length()==0)
        {
            mobile.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(mobile).play();
        }
        else
            mobile.setStyle(null);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
