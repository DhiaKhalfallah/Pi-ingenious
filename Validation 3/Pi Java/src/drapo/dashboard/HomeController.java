/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import art_comm.Controllers.ListBlogController;
import art_comm.Controllers.SplashScreenController;
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
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jxl.write.WriteException;
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
                  
          ListData listdata1 = new ListData();
          private ObservableList<Reclamation> claim2=FXCollections.observableArrayList();
              private ObservableList<Reclamation> claimup=FXCollections.observableArrayList();

                  private ObservableList<Reclamation> claimdown=FXCollections.observableArrayList();

                  String Reclamation[];
  
    @FXML
    private Pane pn_checkApp;
    @FXML
    private Pane pn_BrowseComp;
    @FXML
    private Pane pn_MyProfile;
    @FXML
    private Pane pn_BrowseCan;
    @FXML
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
    private Pane pn_Blog;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         

                    
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
      
          ObservableList<Reclamation> List1=listdata1.getReclamation();
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
            pn_MyProfile.toFront();
    }

    @FXML
    private void BrowseCan(MouseEvent event) {
        pn_BrowseCan.toFront();
    }

    @FXML
    private void BrowseEvent(MouseEvent event) {
      pn_BrowseEvent.toFront();
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
    private void blog(MouseEvent event) {
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
        
        int user_id=53 ;
        int status=1;
        String user_email="dhia@gmail.com";
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
    }

    @FXML
    private void attachCv(MouseEvent event) {
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
         Candidate c1 = new Candidate(tfNom.getText(),tfPrenom.getText(),TfPays.getText(),tfGouvernorat.getText(),tfAdresse.getText(),String.valueOf(tfBday.getValue()),tfPic.getText(),tfCV.getText(),tfAboutyou.getText(),Integer.parseInt(tfTel.getText()),Integer.parseInt(tfCodePostal.getText()),Integer.parseInt(tfid.getText())
);

                     CandidateDao pdao = CandidateDao.getInstance();
                     pdao.update(c1);
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
                 tfNom.setText(currentUser.getNom());
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
    
    
}
