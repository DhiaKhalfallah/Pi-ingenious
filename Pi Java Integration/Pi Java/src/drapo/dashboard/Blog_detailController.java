/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import art_comm.Controllers.ListBlogController;
import art_comm.Controllers.ListData;
import art_comm.Dao.BlogDao;
import art_comm.Dao.CommentaireDao;
import art_comm.Dao.ParticipantDao;
import art_comm.Entities.Blog;
import art_comm.Entities.Commentaire;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.pi.Entities.Candidate;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class Blog_detailController implements Initializable {
       private ListData listdata = new ListData();
private List<Commentaire>Comm = new ArrayList<>();

    @FXML
    private ScrollPane blog_detail;
    @FXML
    private Text title;
    @FXML
    private ImageView image;
    @FXML
    private Label categorie;
    @FXML
    private Label contenu;
    @FXML
    private HBox date;
    @FXML
    private Button back;
Blog blog1;
    @FXML
    private JFXTextField subjectl;
    @FXML
    private JFXTextArea commentairel;
    @FXML
    private Rating ratel;
    @FXML
    private JFXButton add;
    Commentaire comm2;
    int y;
    @FXML
    private GridPane grid;
    @FXML
    private Label idblog;
    int t;
           private Candidate user;     
    @FXML
    private ImageView backto;

public void initData(int x,Candidate c)
{
    
    
    
      BlogDao pdao = BlogDao.getInstance();
                  Blog blog =          pdao.displayById(x);
                     int tel1= blog.getId();
        Integer tell = new Integer(tel1);
        String id = tell.toString();
        user=c;
idblog.setText(id);
    title.setText(blog.getTitre());
    contenu.setText(blog.getContenu());
categorie.setText(blog.getCat());

    t= Integer.parseInt(idblog.getText());
   Comm=new ArrayList<>(Commp(t));
        int column=1;
        int row =0;
        
        try {
            System.out.println(Comm.size());
        for(int i =0;i<Comm.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemblog2.fxml"));
VBox      box=fxmloader.load();        
Itemblog2Controller itemController2 = fxmloader.getController();
     itemController2.setData(Comm.get(i),c);

        if(column ==1)
            {
                column =0;
                ++row;
            }
            grid.add(box, column++, row);
            GridPane.setMargin(box, new Insets(10));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        add.setOnAction(event -> {
         LocalDate localDate = LocalDate.now();
           Commentaire c1=new Commentaire (c.getId(),c.getNom(),c.getEmail(),subjectl.getText(),c.getTel(),commentairel.getText(),localDate.toString(),t, (int) ratel.getRating()); 
        CommentaireDao pdao2 = CommentaireDao.getInstance();
            pdao2.insert(c1);    
      String title = "Commentaire Added";
        String message = "Your Comment has been added";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));
        });
        
    
}
    /**
     * Initializes the controller class.
     */
       List<Commentaire>Commp(int x)
       {
 
    List<Commentaire>comm = new ArrayList();
    Commentaire commentaire;
      CommentaireDao pdao = CommentaireDao.getInstance();
                  int  p =          pdao.Commsize(x);
                  
                         ObservableList<Commentaire> Comm2=FXCollections.observableArrayList();
                         Comm2=pdao.byblogid(x);

    for (int i=0;i<p;i++)
    {
        commentaire = new Commentaire();
        
        commentaire.setId(Comm2.get(i).getId());

        commentaire.setUser(Comm2.get(i).getUser());
        commentaire.setCommentaire(Comm2.get(i).getCommentaire());
        commentaire.setDate(Comm2.get(i).getDate());
        commentaire.setRate(Comm2.get(i).getRate());
        Comm.add(commentaire);
    }
    
    return Comm;
    
}
  
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
 
                      }


    @FXML
    private void logout(MouseEvent event) {
    }

    private void dashboardbt(MouseEvent event) {
                        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/SplashScreen.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      stage.setX(830);
stage.setY(350);
stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

   

    

    @FXML
    private void blog_detailbt(MouseEvent event) {
              
    }

    @FXML
    private void backbt(MouseEvent event) {
         FXMLLoader fxmloader = new FXMLLoader();
            
     try {
  FXMLLoader loader= new FXMLLoader( getClass().getResource( "/com/pi/views/Home.fxml" ));
              Scene scene = new Scene(loader.load());
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();   
              stage.setScene(scene);

  HomeController controller = loader.getController();
  controller.setSession(user);

  stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        
    }


    @FXML
    private void addbt(MouseEvent event) {
        
    }

    @FXML
    private void backtobt(MouseEvent event) {
               FXMLLoader fxmloader = new FXMLLoader();
            
     try {
  FXMLLoader loader= new FXMLLoader( getClass().getResource( "/com/pi/views/Home.fxml" ));
              Scene scene = new Scene(loader.load());
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();   
              stage.setScene(scene);

  HomeController controller = loader.getController();
  controller.setSession(user);

  stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
     
    

 
    
}
