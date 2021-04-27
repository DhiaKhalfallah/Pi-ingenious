/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import animatefx.animation.BounceIn;
import animatefx.animation.Shake;
import art_comm.Controllers.ListBlogController;
import art_comm.Controllers.SplashScreenController;
import art_comm.Dao.BlogDao;
import art_comm.Dao.EventDao;
import art_comm.Dao.Formation_Services;
import art_comm.Entities.Blog;
import art_comm.Entities.Event;
import art_comm.services.OffreCrud;
import com.jfoenix.controls.JFXButton;
import com.pi.Entities.Candidate;
import com.pi.controllers.ListData;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import com.pi.Dao.CandidateDao;
import com.pi.Dao.ReclamationDao;
import com.pi.Entities.Reclamation;
import com.pi.views.ItemController;
import java.io.FileNotFoundException;
import com.pi.controllers.Excel;
import com.pi.views.ClaimController;
import com.pi.views.ItemOffreController;
import entities.Offre;
import eventcrud.Entities.Formation;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javax.swing.JFileChooser;
import jxl.write.WriteException;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class HomeController implements Initializable {
       ListData listdata = new ListData();
          private ObservableList<Candidate> candidate2=FXCollections.observableArrayList();
              private ObservableList<Candidate> candidateup=FXCollections.observableArrayList();

                  private ObservableList<Candidate> candidatedown=FXCollections.observableArrayList();

                  String Candidate[];
                  
        private ObservableList<Reclamation> reclam=FXCollections.observableArrayList();
              private ObservableList<Reclamation> claimup=FXCollections.observableArrayList();

                  private ObservableList<Reclamation> claimdown=FXCollections.observableArrayList();
art_comm.Controllers.ListData listdata3=new art_comm.Controllers.ListData();
                  String Reclamation[];
                  private List<Event>Events = new ArrayList<>();
  private List<Formation>Formationli = new ArrayList<>();
    @FXML
    private Pane pn_checkApp;
    @FXML
    private Pane pn_BrowseComp;
    @FXML
    private Pane pn_MyProfile;
    @FXML
    private Pane pn_BrowseCan;
    private Pane pn_BrowseEvent;
    @FXML
    private Pane pn_BrowseWorkShops;
    @FXML
    private Pane pn_SendClaim;
    @FXML
    private Pane pn_BrowseClaims;
    @FXML
    private Pane pn_browsejobs;
    @FXML
    private Pane pn_Home;
    @FXML
    private VBox vbox_2;
    @FXML
    private VBox vbox_1;
    @FXML
    private ScrollPane pn_Blog;
    @FXML
    private Pane pn_EnProfile;
    @FXML
    private Pane pn_AddJob;
    @FXML
    private Pane pn_BorwseInt;
    @FXML
    private Pane pn_BrowseOffers;
    @FXML
    private FlowPane pn_scroll;
    private TableView<Reclamation> RecTable;
    private TableColumn<Reclamation, Integer> idC;
    private TableColumn<Reclamation, Integer> userC;
    private TableColumn<Reclamation, String> emailC;
    private TableColumn<Reclamation, String> subjectC;
    private TableColumn<Reclamation, String> claimC;
    private TableColumn<Reclamation, String> DateC;
    private TextField search;
    private TableColumn<Reclamation, Integer> status;
    @FXML
    private JFXButton excel1;
    @FXML
    private TextField tfuser;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfSubject;
    @FXML
    private TextArea tfclaim;
    @FXML
    private Button update;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField TfPays;
    @FXML
    private TextField tfGouvernorat;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfCodePostal;
    @FXML
    private TextField tfPic;
    @FXML
    private TextField tfCV;
    @FXML
    private TextArea tfAboutyou;
    @FXML
    private DatePicker tfBday;
    @FXML
    private TextField tfid;
    @FXML
    private Pane pn_EditP;
    @FXML
    private FlowPane pn_recScroll;
    private Candidate currentUser ; 
    private ObservableList<Reclamation> List1;
    private Label name;
    @FXML
    private Label bday;
    @FXML
    private Label adress;
    @FXML
    private Label city;
    @FXML
    private Label pays;
    @FXML
    private Label tel;
    @FXML
    private Label mail;
    @FXML
    private Label prenom;
    @FXML
    private Label nom;
    @FXML
    private Label about;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfCategorie;
    @FXML
    private TextField tfLogo;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfID;
    @FXML
    private ScrollPane scroll2;
    @FXML
    private GridPane Grid2;
    /**
     * Initializes the controller class.
     */
private List<Blog>Blogs = new ArrayList<>();  
private List<Offre>offers = new ArrayList<>();  

@FXML
    private JFXButton listoffre;
    @FXML
    private ScrollPane pn_Browseform;
    @FXML
    private GridPane gridF;
    @FXML
    private JFXButton broweform;
    @FXML
    private GridPane grid;
    @FXML
    private MenuItem popular;
    @FXML
    private MenuItem newer;
    @FXML
    private MenuItem older;
    @FXML
    private ScrollPane pn_BrowseEvents;
    @FXML
    private GridPane grid1;
    @FXML
    private SplitMenuButton menu;
    @FXML
    private MenuItem today;
    @FXML
    private MenuItem month;
    @FXML
    private MenuItem upcoming;
    @FXML
    private TextField tfNom1;
    /**
     * Initializes the controller class.
     */
    
     private List<Offre>offres()
{
       
   
    List<Offre>blogs = new ArrayList();
    Offre blog;
      OffreCrud cs = new OffreCrud();
                  int  p = cs.OffreSize();
                 
                         ObservableList<Offre> blog2=FXCollections.observableArrayList();
                         blog2= cs.GetOffre();

    for (int i=0;i<p;i++)
    {
        blog = new Offre();
             

        blog.setId(blog2.get(i).getId());
        blog.setCategorie(blog2.get(i).getCategorie());
        blog.setNom(blog2.get(i).getNom());
        blog.setEmail(blog2.get(i).getEmail());
        blog.setTitle(blog2.get(i).getTitle());
        blog.setLogo(blog2.get(i).getlogo());
        blog.setDescription(blog2.get(i).getDescription());
        blogs.add(blog);
    }
   
    return blogs;
   
}
      private List<Formation>Formations()
{
        
    
    List<Formation>events = new ArrayList();
    Formation f;
      Formation_Services pdao = Formation_Services.getInstance();
                  int  p =        pdao.size();
                  
                         ObservableList<Formation> blog2=FXCollections.observableArrayList();
                         blog2=pdao.display();

    for (int i=0;i<p;i++)
    {
        f = new Formation();
        f.setDateDebut(blog2.get(i).getDateDebut());
        f.setDateFin(blog2.get(i).getDateFin());
        f.setNom(blog2.get(i).getNom());
        
        events.add(f);
    }
    
    return events
            ;
    
        
    }    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                Formationli=new ArrayList<>(Formations());
              int column=0;
              int row =1;

              try {
                  System.out.println(Formationli.size());
                  
              for(int i =0;i<Formationli.size();i++)
              {          
                  FXMLLoader fxmloader = new FXMLLoader();

                  fxmloader.setLocation(getClass().getResource("/com/pi/views/itemForm.fxml"));
      VBox      box=fxmloader.load();        
      ItemFromController itemformController = fxmloader.getController();
      itemformController.setData(Formationli.get(i));

              if(column ==3)
                  {
                      column =0;
                      ++row;
                  }
                  gridF.add(box, column++, row);
                  GridPane.setMargin(box, new Insets(10));
              }
              } catch (IOException ex) {
                      Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                  }
          offers=new ArrayList<>(offres());
        int column5=0;
        int row5 =1;
       
        try {
        for(int i =0;i<offers.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
           
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemOffre.fxml"));
VBox      box=fxmloader.load();        
ItemOffreController itemoffreController = fxmloader.getController();
     itemoffreController.setData(offers.get(i));
        if(column5 ==2)
            {
                column5 =0;
                ++row5;
            }
            Grid2.add(box, column5++, row5);
            GridPane.setMargin(box, new Insets(48));
        }
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        pn_BrowseCan.toFront();

               // Candidate list
        
        ObservableList<Candidate> List=listdata.getCandidate();
         Node n = null  ;
         FXMLLoader  loader;
        for(Candidate can:List)
        {
            
            
               loader = new FXMLLoader(getClass().getResource("/com/pi/views/Item.fxml"));
            try {
                 n=(Node) loader.load() ;
                   
                 
                 
             } catch (IOException ex) {
                 Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
             }
            ItemController controller = loader.<ItemController>getController();
             try {
                 controller.initData(can);
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
            pn_scroll.getChildren().add(n);

            
        }

      // end list
      
      //list Rec
      
  
        
    } 
     private    List<Event>upcomingevent() {   

        
    List<Event>events = new ArrayList();
    Event event2;
      EventDao pdao = EventDao.getInstance();
                  int  p =          pdao.sizeEventU();
                  System.out.println(p);
                  
                         ObservableList<Event> blog2=FXCollections.observableArrayList();
                         blog2=listdata3.getupcoming();

    for (int i=0;i<p;i++)
    {
        event2 = new Event();
        event2.setLieu(blog2.get(i).getLieu());
        event2.setent_id(blog2.get(i).getent_id());
        event2.setNbr(blog2.get(i).getNbr());
        
        event2.setId(blog2.get(i).getId());
    event2.setentreprise_id(blog2.get(i).getEntreprise_id());
        event2.seImage(blog2.get(i).getImage());
        event2.setPar_id(blog2.get(i).getPar_id());
        event2.setDescription(blog2.get(i).getdescription());
event2.setNom2(blog2.get(i).getNom2());
event2.setCategorie(blog2.get(i).getCategorie());
event2.setDatef(blog2.get(i).getDatef());
event2.setNbr(blog2.get(i).getNbr());
        event2.setDate(blog2.get(i).getDate());
        events.add(event2);
    }
    
    return events
            
            ;
    
    
        
    }    
    
   private List<Event>events()
{
        
    art_comm.Controllers.ListData listdata4=new art_comm.Controllers.ListData();

    List<Event>events = new ArrayList();
    Event event2;
      EventDao pdao = EventDao.getInstance();
                  int  p =          pdao.sizeEvent();
                  pdao.qrcode();
                         ObservableList<Event> blog2=FXCollections.observableArrayList();
                         blog2=listdata4.getEvent();

    for (int i=0;i<p;i++)
    {
        event2 = new Event();
          event2 = new Event();
        event2.setLieu(blog2.get(i).getLieu());
        event2.setent_id(blog2.get(i).getent_id());
        event2.setNbr(blog2.get(i).getNbr());
        
        event2.setId(blog2.get(i).getId());
    event2.setentreprise_id(blog2.get(i).getEntreprise_id());
        event2.seImage(blog2.get(i).getImage());
        event2.setPar_id(blog2.get(i).getPar_id());
        event2.setDescription(blog2.get(i).getdescription());
event2.setNom2(blog2.get(i).getNom2());
event2.setCategorie(blog2.get(i).getCategorie());
event2.setDatef(blog2.get(i).getDatef());
event2.setNbr(blog2.get(i).getNbr());
        event2.setDate(blog2.get(i).getDate());
        events.add(event2);
    }
    
    return events
            ;
    
        
    }    
  private List<Event>today()
{
        
    
    List<Event>events = new ArrayList();
    Event event2;
      EventDao pdao = EventDao.getInstance();
                  int  p =          pdao.sizeEventT();
                  System.out.println(p);
                  
                         ObservableList<Event> blog2=FXCollections.observableArrayList();
                         blog2=listdata3.gettoday();

    for (int i=0;i<p;i++)
    {      
                event2 = new Event();
           event2 = new Event();
        event2.setLieu(blog2.get(i).getLieu());
        event2.setent_id(blog2.get(i).getent_id());
        event2.setNbr(blog2.get(i).getNbr());
        
        event2.setId(blog2.get(i).getId());
    event2.setentreprise_id(blog2.get(i).getEntreprise_id());
        event2.seImage(blog2.get(i).getImage());
        event2.setPar_id(blog2.get(i).getPar_id());
        event2.setDescription(blog2.get(i).getdescription());
event2.setNom2(blog2.get(i).getNom2());
event2.setCategorie(blog2.get(i).getCategorie());
event2.setDatef(blog2.get(i).getDatef());
event2.setNbr(blog2.get(i).getNbr());
        event2.setDate(blog2.get(i).getDate());
      
 
        events.add(event2);
    }
    
    return events
            
            ;
    
    
        
    }    
  private List<Event>month()
{
        
    
    List<Event>events = new ArrayList();
    Event event2 ;
      EventDao pdao = EventDao.getInstance();
                  int  p =          pdao.sizeEventM();
                  System.out.println(p);
                  
                         ObservableList<Event> blog2=FXCollections.observableArrayList();
                         blog2=listdata3.getmonth();

    for (int i=0;i<p;i++)
    {
                event2 = new Event();
          event2 = new Event();
        event2.setLieu(blog2.get(i).getLieu());
        event2.setent_id(blog2.get(i).getent_id());
        event2.setNbr(blog2.get(i).getNbr());
        
        event2.setId(blog2.get(i).getId());
    event2.setentreprise_id(blog2.get(i).getEntreprise_id());
        event2.seImage(blog2.get(i).getImage());
        event2.setPar_id(blog2.get(i).getPar_id());
        event2.setDescription(blog2.get(i).getdescription());
event2.setNom2(blog2.get(i).getNom2());
event2.setCategorie(blog2.get(i).getCategorie());
event2.setDatef(blog2.get(i).getDatef());
event2.setNbr(blog2.get(i).getNbr());
        event2.setDate(blog2.get(i).getDate());
        events.add(event2);
    }
    
    return events
            
            ;
    
    
        
    }
 private    List<Blog>popular() {   
        
    List<Blog>blogs = new ArrayList(); 
        List<Offre>offres = new ArrayList(); 
    Blog blog;

      BlogDao pdao = BlogDao.getInstance();
                  int  p =          pdao.PopularSize();
                  System.out.println(p);
                  
                         ObservableList<Blog> blog2=FXCollections.observableArrayList();
                         blog2=listdata3.getblogp();

    for (int i=0;i<p;i++)
    {
      blog = new Blog();

        blog.setId(blog2.get(i).getId());
          blog.setCat(blog2.get(i).getCat());
        blog.setTitre(blog2.get(i).getTitre());
        blog.setImage(blog2.get(i).getImage());
        blog.setDate(blog2.get(i).getDate());
        blog.setNbr(blog2.get(i).getNbr());
        blogs.add(blog);
    }
          
    return blogs;   
          }    
                    private    List<Blog>newest() {   
        
    List<Blog>blogs = new ArrayList(); 
    Blog blog;

      BlogDao pdao = BlogDao.getInstance();
                  int  p =          pdao.NewestSize();
                  System.out.println(p);
                  
                         ObservableList<Blog> blog2=FXCollections.observableArrayList();
                         blog2=listdata3.getblogn();

    for (int i=0;i<p;i++)
    {
      blog = new Blog();

        blog.setId(blog2.get(i).getId());
          blog.setCat(blog2.get(i).getCat());
        blog.setTitre(blog2.get(i).getTitre());
        blog.setImage(blog2.get(i).getImage());
        blog.setDate(blog2.get(i).getDate());
        blog.setNbr(blog2.get(i).getNbr());
        blogs.add(blog);
    }
          
    return blogs;   
          }
                              private    List<Blog>oldest() {   
        
    List<Blog>blogs = new ArrayList(); 
    Blog blog;

      BlogDao pdao = BlogDao.getInstance();
                  int  p =          pdao.OldestSize();
                  System.out.println(p);
                  
                         ObservableList<Blog> blog2=FXCollections.observableArrayList();
                         blog2=listdata3.getBlogO();

    for (int i=0;i<p;i++)
    {
      blog = new Blog();

        blog.setId(blog2.get(i).getId());
          blog.setCat(blog2.get(i).getCat());
        blog.setTitre(blog2.get(i).getTitre());
        blog.setImage(blog2.get(i).getImage());
        blog.setDate(blog2.get(i).getDate());
        blog.setNbr(blog2.get(i).getNbr());
        blogs.add(blog);
    }
          
    return blogs;   
          }
   private List<Blog>blogs()
{
        
    
    List<Blog>blogs = new ArrayList();
    Blog blog;
      BlogDao pdao = BlogDao.getInstance();
                  int  p =          pdao.sizeblog();
                  
                         ObservableList<Blog> blog2=FXCollections.observableArrayList();
                         blog2=listdata3.getBlog();

    for (int i=0;i<p;i++)
    {
        blog = new Blog();
             

        blog.setId(blog2.get(i).getId());
          blog.setCat(blog2.get(i).getCat());
        blog.setTitre(blog2.get(i).getTitre());
        blog.setImage(blog2.get(i).getImage());
        blog.setDate(blog2.get(i).getDate());
        blog.setNbr(blog2.get(i).getNbr());
        blogs.add(blog);
    }
    
    return blogs;
    
}

    @FXML
    private void browsejobs(MouseEvent event) {
        pn_browsejobs.toFront();
    }

    @FXML
    private void CheckApp(MouseEvent event) {
           pn_checkApp.toFront();
    }

    @FXML
    private void BrowseComp(MouseEvent event) {
       pn_BrowseComp.toFront();
    }

    @FXML
    private void Profile(MouseEvent event) {
        int tel1= currentUser.getTel() ; 
         Integer tell = new Integer(tel1);
        String mobile = tell.toString();
      nom.setText(currentUser.getNom());
     bday.setText(currentUser.getBirthday());
     adress.setText(currentUser.getAdresse());
     city.setText(currentUser.getGouvernorat());
    pays.setText(currentUser.getPays());
     tel.setText(mobile);
     mail.setText(currentUser.getEmail());
     prenom.setText(currentUser.getPrenom());
     nom.setText(currentUser.getNom());
     about.setText(currentUser.getAbout_you());
        
            
            pn_MyProfile.toFront();
    }

    @FXML
    private void BrowseCan(MouseEvent event) {
        pn_BrowseCan.toFront();
    }

    @FXML
    private void BrowseEvent(MouseEvent event5) {
                  Events=new ArrayList<>(events());

          today.setOnAction(event -> {
                     Events=new ArrayList<>(today());
        int column=0;
        int row =1;
        
        try {
            System.out.println(Events.size());
        for(int i =0;i<Events.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemEvent.fxml"));
VBox      box=fxmloader.load();  
        new BounceIn(box).play();

ItemeventController itemeventController = fxmloader.getController();
itemeventController.setData(Events.get(i),currentUser);

        if(column ==2)
            {
                column =0;
                ++row;
            }
            grid1.add(box, column++, row);
            GridPane.setMargin(box, new Insets(26));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
          month.setOnAction(event -> {
                     Events=new ArrayList<>(month());
        int column=0;
        int row =1;
        
        try {
            System.out.println(Events.size());
        for(int i =0;i<Events.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemEvent.fxml"));
VBox      box=fxmloader.load();        
        new BounceIn(box).play();

ItemeventController itemeventController = fxmloader.getController();
itemeventController.setData(Events.get(i),currentUser);

        if(column ==2)
            {
                column =0;
                ++row;
            }
            grid1.add(box, column++, row);
            GridPane.setMargin(box, new Insets(26));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
          upcoming.setOnAction(event -> {
                     Events=new ArrayList<>(upcomingevent());
        int column=0;
        int row =1;
        
        try {
            System.out.println(Events.size());
        for(int i =0;i<Events.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemEvent.fxml"));
VBox      box=fxmloader.load();  
        new BounceIn(box).play();

ItemeventController itemeventController = fxmloader.getController();
itemeventController.setData(Events.get(i),currentUser);

        if(column ==2)
            {
                column =0;
                ++row;
            }
            grid1.add(box, column++, row);
            GridPane.setMargin(box, new Insets(26));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
        int column=0;
        int row =1;
        
        try {
            System.out.println(Events.size());
        for(int i =0;i<Events.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemEvent.fxml"));
VBox      box=fxmloader.load();        
ItemeventController itemeventController = fxmloader.getController();
itemeventController.setData(Events.get(i),currentUser);

        if(column ==2)
            {
                column =0;
                ++row;
            }
            grid1.add(box, column++, row);
            GridPane.setMargin(box, new Insets(26));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
      pn_BrowseEvents.toFront();
    }
    

    @FXML
    private void BrowseWorkShop(MouseEvent event) {
          pn_BrowseWorkShops.toFront();
    }

    @FXML
    private void SendClaim(MouseEvent event) {
           pn_SendClaim.toFront();
    }

    @FXML
    private void CheckCLaim(MouseEvent event) {
            pn_recScroll.getChildren().clear();
         ReclamationDao pdao4=ReclamationDao.getInstance();
        reclam= pdao4.displayBySession(currentUser.getId());  
         List1=reclam;
                  
         Node n1 = null  ;
         FXMLLoader  loadern;
        for(Reclamation rec:List1)
        {
            
            
               loadern = new FXMLLoader(getClass().getResource("/com/pi/views/claim.fxml"));
            try {
                 n1=(Node) loadern.load() ;
               
                 
             } catch (IOException ex) {
                 Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
             }
            ClaimController controller = loadern.<ClaimController>getController();
             try {
                 controller.initData(rec);
             } catch (FileNotFoundException ex) {
                 Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
             }
             
            pn_recScroll.getChildren().add(n1);

            
        }

     pn_BrowseClaims.toFront();
    }

    @FXML
    private void previouspage(MouseEvent event) {
        vbox_1.toFront();
    }

    @FXML
    private void nextpage(MouseEvent event) {
                vbox_2.toFront();

    }

    @FXML
    private void logout(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void blog(MouseEvent event5) {
        popular.setOnAction(event -> {
              
                   Blogs=new ArrayList<>(popular());
        int column2=0;
        int row2 =1;
        
        try {
        for(int i =0;i<Blogs.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemblog.fxml"));
VBox      box=fxmloader.load();      
        new Shake(box).play();

ItemblogController itemController = fxmloader.getController();
     itemController.setData(Blogs.get(i),currentUser);

        if(column2 ==2)
            {
                column2 =0;
                ++row2;
            }
            grid.add(box, column2++, row2);
            GridPane.setMargin(box, new Insets(48));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
          });
              newer.setOnAction(event -> {
                       Blogs=new ArrayList<>(newest());
        int column3=0;
        int row3 =1;
        
        try {
        for(int i =0;i<Blogs.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemblog.fxml"));
VBox      box=fxmloader.load();    
        new Shake(box).play();

ItemblogController itemController = fxmloader.getController();
     itemController.setData(Blogs.get(i),currentUser);
     
        if(column3 ==2)
            {
                column3 =0;
                ++row3;
            }
            grid.add(box, column3++, row3);
            GridPane.setMargin(box, new Insets(48));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
              
          });
                  older.setOnAction(event -> {
                           Blogs=new ArrayList<>(oldest());
        int column4=0;
        int row4 =1;
        
        try {
        for(int i =0;i<Blogs.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemblog.fxml"));
VBox      box=fxmloader.load();        
        new Shake(box).play();

ItemblogController itemController = fxmloader.getController();
     itemController.setData(Blogs.get(i),currentUser);
        if(column4 ==2)
            {
                column4 =0;
                ++row4;
            }
            grid.add(box, column4++, row4);
            GridPane.setMargin(box, new Insets(48));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
              
          });
                  
        Blogs=new ArrayList<>(blogs());
        int column5=0;
        int row5 =1;
        
        try {
        for(int i =0;i<Blogs.size();i++)
        {          
            FXMLLoader fxmloader = new FXMLLoader();
            
            fxmloader.setLocation(getClass().getResource("/com/pi/views/itemblog.fxml"));
VBox      box=fxmloader.load();        
ItemblogController itemController = fxmloader.getController();
     itemController.setData(Blogs.get(i),currentUser);
     System.out.println(currentUser.getId());
        if(column5 ==2)
            {
                column5 =0;
                ++row5;
            }
            grid.add(box, column5++, row5);
            GridPane.setMargin(box, new Insets(48));
        }
        } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        pn_Blog.toFront();
    }

    @FXML
    private void ProfileEn(MouseEvent event) {
        pn_EnProfile.toFront();
    }

    @FXML
    private void AddJob(MouseEvent event) {
        pn_AddJob.toFront();
    }

    @FXML
    private void BrowseIn(MouseEvent event) {
        pn_BorwseInt.toFront();
    }

    @FXML
    private void BrowseOff(MouseEvent event) {
        pn_BrowseOffers.toFront();
    }

    private void excel(MouseEvent event) throws SQLException, WriteException, IOException {
        Excel excel = new Excel();
        excel.Excel();
    }

    private void refresh(MouseEvent event) {
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/pi/views/Home.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
     pn_BrowseClaims.toFront();

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void addClaim(MouseEvent event) {
        
        int user_id=currentUser.getId() ;
        int status=1;
        String user_email=currentUser.getEmail();
        String subject=tfSubject.getText();
        String claim=tfclaim.getText();
        Date date = new Date();  
        SimpleDateFormat  formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");  
        String Submit = formatter.format(date);  
        
        Reclamation r = new Reclamation(user_id,status,user_email,subject,claim,Submit);
        ReclamationDao rec= new ReclamationDao();
        rec.insert(r);
    }

    @FXML
    private void attachPic(MouseEvent event) {
         JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath().replace("\\","\\\\");
                                tfPic.setText(imagepath);}
    }

    @FXML
    private void attachCv(MouseEvent event) {
         JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath().replace("\\","\\\\");
                                tfCV.setText(imagepath);}
    }

    @FXML
    private void updatecan(MouseEvent event) {
        
        if (tfid.getText() == null || tfid.getText().trim().isEmpty())
        {
                Alert a = new Alert(AlertType.WARNING);
                a.setContentText("You are trying to edit an invalid user!");
                a.show();
        //if (dlg.showAndWait().get() != ButtonType.OK)

        }
        else
        {
         Candidate c1 = new Candidate(tfNom1.getText(),tfPrenom.getText(),TfPays.getText(),tfGouvernorat.getText(),tfAdresse.getText(),String.valueOf(tfBday.getValue()),tfPic.getText(),tfCV.getText(),tfAboutyou.getText(),Integer.parseInt(tfTel.getText()),Integer.parseInt(tfCodePostal.getText()),Integer.parseInt(tfid.getText())
);

                     CandidateDao pdao = CandidateDao.getInstance();
                     pdao.update(c1);
                     Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Changes can be witnessed in your next session!");
                a.show();
        }
    }
        

    @FXML
    private void editredirect(MouseEvent event) {
            int idt= currentUser.getId();
                         Integer id1 = new Integer(idt);
                         String id = id1.toString();
                               int tel1= currentUser.getTel();
                         Integer tell = new Integer(tel1);
                         String mobile = tell.toString();
                         int postal= currentUser.getCode_postal();
                         Integer postal1 = new Integer(postal);
                         String code = postal1.toString();
                        
                         LocalDate date = LocalDate.parse(currentUser.getBirthday());
                 tfNom1.setText(currentUser.getNom());
                 tfPrenom.setText(currentUser.getPrenom());
                 tfTel.setText(mobile);
                 tfCodePostal.setText(code);
                 TfPays.setText(currentUser.getPays());
                 tfGouvernorat.setText(currentUser.getGouvernorat());
                 tfAdresse.setText(currentUser.getAdresse());
                 tfBday.setValue(date);
                 tfPic.setText(currentUser.getProfile_pic());
                 tfCV.setText(currentUser.getCv());
                 tfAboutyou.setText(currentUser.getAbout_you());
        tfid.setText(id);
        pn_EditP.toFront();
    }

    private void dash(MouseEvent event) {
        
        
    }
    
    public void setSession(Candidate c)
    {
     currentUser = c ; 
    }

    @FXML
    private void addOffre(MouseEvent event) {
         OffreCrud tt=new OffreCrud();

    
        if ((tfID.getText().isEmpty())||(tfNom.getText().isEmpty())||(tfEmail.getText().isEmpty())||(tfLogo.getText().isEmpty())||(tfTitle.getText().isEmpty())||(tfDescription.getText().isEmpty())||(tfCategorie.getText().isEmpty()))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid data");
            alert.setHeaderText("Cannot add a new entry");
            alert.setContentText("un des champs est vide ");

            alert.showAndWait();
        }     
        
       else{    
       
         int a= Integer.parseInt(tfID.getText());
                  int b= Integer.parseInt(tfCategorie.getText());


     Offre e=new Offre(a,tfNom.getText(),tfEmail.getText(),tfLogo.getText(),tfTitle.getText(),tfDescription.getText(),b);
OffreCrud s=new OffreCrud();
s.addOffre(e);
scroll2.toFront();
OffreCrud cs = new OffreCrud();

         List<Offre> lc = cs.ListEntite();
        
          ObservableList<Offre> data =
                  
        FXCollections.observableArrayList(lc );
          
          //Notification
          
   Notifications  notif= Notifications.create();
                
                 notif.title("Un noveau offre a été ajouté");
notif.text("Un noveau offre a été ajouté");
notif.graphic(null);
notif.hideAfter(Duration.seconds(30));
notif.position(Pos.TOP_RIGHT);
notif.showConfirm();
        
        }
    }



    @FXML
    private void listoffre(MouseEvent event) {
        scroll2.toFront();
    }

    @FXML
    private void browsefrombt(MouseEvent event) {
        pn_Browseform.toFront();
    }

    @FXML
    private void BrowseEventbt(MouseEvent event) {
    }

    
    
}
