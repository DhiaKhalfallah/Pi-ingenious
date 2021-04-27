/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import animatefx.animation.FlipInX;
import animatefx.animation.Pulse;
import art_comm.Dao.EventDao;
import art_comm.Dao.ParticipantDao;
import art_comm.Entities.Event;
import art_comm.Entities.Participant;
import com.jfoenix.controls.JFXButton;
import com.pi.Entities.Candidate;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class ItemeventController implements Initializable {

    private Text blogtitre;
private Event event;
    private Text cat;
    @FXML
    private Label date;
    private boolean tt;
    @FXML
    private Pane flip;
    @FXML
    private ImageView image;
    @FXML
    private Pane face;
    @FXML
    private Label datef;
    @FXML
    private Label categroie;
    @FXML
    private Label nom;
    @FXML
    private Label nbr;
    @FXML
    private Label desc;
        private Candidate user;
    @FXML
    private Button button;
    @FXML
    private Label ide;
public void setData(Event e,Candidate c) throws FileNotFoundException
{int x;
event=e;
     date.setText(event.getDate());
     datef.setText(event.getDatef());
     categroie.setText(event.getCategorie());
     nom.setText(event.getNom2());
    desc.setText(event.getdescription());
        nbr.setText(String.valueOf(event.getNbr()));
          user=c;
           
     int tel1= event.getId();
        Integer tell = new Integer(tel1);
        String id = tell.toString();
   x=c.getId();
   ide.setText(id);
   System.out.println(x);
    
    String image_name=event.getdescription();
       InputStream stream = new FileInputStream("C:\\Users\\Dhia\\Desktop\\Pi Java Integration\\Pi Java\\src\\com\\QRCODE"+image_name+".png");
    Image image1 = new Image(stream);
    image.setImage(image1);
        if(event.getPar_id()==x)
        {
            button.setText("Unsubscribe");
        }
    else
        {
            button.setText("Subscribe");
        }
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
    }    

    private void viewbt(MouseEvent event) {
            tt=!tt;
        if(tt)
        {
          //  view.setText("Subscribe");
        }
        else
        {
                     //   view.setText("Unsubscribe");

        }
        
        
    }

    @FXML
    private void flipback(MouseEvent event) {
           new Pulse(face).play();
                face.toFront();

    }

    @FXML
    private void flip(MouseEvent event) {
        new Pulse(flip).play();
         flip.toFront();
    }

    @FXML
    private void buttonpress(MouseEvent event1) { 
        int x =user.getId();
        System.out.println(x); 
                   System.out.println(event.getPar_id());
     int y=0;
     int p= event.getNbr();
        if(event.getPar_id()==x)
    {
      
                         EventDao pdao2 = EventDao.getInstance();
    pdao2.updatepar(event.getId(),y);
              p=p+1;
             pdao2.updatplacesub(event.getId(), p);
                 button.setText("Subscribe"); 
                 
              String title = "Unsubscribe";
        String message = "You Have Unscribeded";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));
    }
    else if (event.getPar_id()!=x)
    {
                 ParticipantDao pdao = ParticipantDao.getInstance();
         LocalDate localDate = LocalDate.now();
                
   Participant vbn = new Participant(user.getId(),event.getId(),localDate.toString(),user.getNom(),user.getEmail(),user.getTel());
            pdao.insert(vbn);
         pdao.insert(vbn);

         EventDao pdao2 = EventDao.getInstance();
         pdao2.updatepar(event.getId(),x);
                button.setText("UnSubscribe");
             p=p-1;  
             pdao2.updatplacesub(event.getId(), p);
                 
   String title = "subscribe";
        String message = "You Have scribeded";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));
    }
    }
    
}
