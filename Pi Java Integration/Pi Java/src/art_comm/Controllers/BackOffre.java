/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.Offre;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import art_comm.services.OffreCrud;


/**
 * FXML Controller class
 *
 * @author RE flex
 */
public class BackOffre implements Initializable {

    @FXML
    private TableColumn<Offre,Integer> id;
    @FXML
    private TableColumn<Offre, String> nom;
    @FXML
    private TableColumn<Offre, String> email;
    @FXML
    private TableColumn<Offre, String> logo;
    @FXML
    private TableColumn<Offre, String> title;
    @FXML
    private TableColumn<Offre, String> description;
     @FXML
    private TableView<Offre> table;

   

    @FXML
    private BorderPane root;
    @FXML
    private FontAwesomeIcon back2;
    @FXML
    private Text back;
    @FXML
    private Button full;
    @FXML
    private HBox dashboard;
    @FXML
    private HBox reviews;
    @FXML
    private HBox blogd;
    @FXML
    private HBox sms;
    @FXML
    private VBox rootpB;
    @FXML
    private Pane status;
    @FXML
    private Button back3;
    @FXML
    private TextField search;
    @FXML
    private HBox btncategorie;
    @FXML
    private HBox btnoffre;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfLogo;
    @FXML
    private TextField tfCategorie;
    @FXML
    private Button btnAdd;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNom1;
    private TextField tfEmail1;
    private TextField tfLogo1;
    @FXML
    private TextField tfTitle1;
    @FXML
    private TextField tfCategorie1;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnEdit;
    @FXML
    private TextField tfDescription1;
    @FXML
    private TableColumn<Offre, Integer> acategorie;
    @FXML
    private TextField tfEmail11;
    @FXML
    private TextField tfLogo11;
    @FXML
    private HBox userb;
    @FXML
    private HBox events;
    @FXML
    private HBox parti;
    @FXML
    private HBox reclamab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         OffreCrud cs = new OffreCrud();

         List<Offre> lc = cs.ListEntite();
        
          ObservableList<Offre> data =
                  
        FXCollections.observableArrayList(lc );
          
        id.setCellValueFactory(
                new PropertyValueFactory<>("id"));
          
        nom.setCellValueFactory(
                new PropertyValueFactory<>("nom"));
 
       email.setCellValueFactory(
                new PropertyValueFactory<>("email"));
        
        logo.setCellValueFactory(
                new PropertyValueFactory<>("logo"));
 
        title.setCellValueFactory(
                new PropertyValueFactory<>("title"));
        
        description.setCellValueFactory(
                new PropertyValueFactory<>("description"));
        
        acategorie.setCellValueFactory(
                new PropertyValueFactory<>("Categorie"));
        
 
        table.setItems(data);
        
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
    private void fullb(MouseEvent event) {
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
    private void reviewsbt(MouseEvent event) {
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

    @FXML
    private void back3bt(MouseEvent event) {
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
    private void btncat(MouseEvent event) throws IOException {
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
    private void btnoffre(MouseEvent event) throws IOException {
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

    @FXML
    private void addOffre(ActionEvent event) {
        OffreCrud tt=new OffreCrud();

    
        if ((tfID.getText().isEmpty())||(tfCategorie.getText().isEmpty())||(tfNom.getText().isEmpty())||(tfEmail.getText().isEmpty())||(tfLogo.getText().isEmpty())||(tfTitle.getText().isEmpty())||(tfDescription.getText().isEmpty()))
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


     Offre e=new Offre(a,b,tfNom.getText(),tfEmail.getText(),tfLogo.getText(),tfTitle.getText(),tfDescription.getText());
OffreCrud s=new OffreCrud();
s.addOffre(e);
OffreCrud cs = new OffreCrud();

         List<Offre> lc = cs.ListEntite();
        
          ObservableList<Offre> data =
                  
        FXCollections.observableArrayList(lc );
          
      
 
 
 
        table.setItems(data);
        
        }
        
    }

    @FXML
    private void Supprimer(ActionEvent event) {
         Offre t = table.getSelectionModel().getSelectedItem();   
         
          if ((tfID.getText().isEmpty())||(tfNom.getText().isEmpty())||(tfEmail.getText().isEmpty())||(tfLogo.getText().isEmpty())||(tfTitle.getText().isEmpty())||(tfDescription.getText().isEmpty())||(tfCategorie.getText().isEmpty()))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid data");
            alert.setHeaderText("You want to delete Offre ");

            alert.showAndWait();
        }

OffreCrud s=new OffreCrud();
s.DeleteOffre(t.getId());
OffreCrud cs = new OffreCrud();

         List<Offre> lc = cs.ListEntite();
        
          ObservableList<Offre> data =
                  
        FXCollections.observableArrayList(lc );
          
      
 
 
 
        table.setItems(data);
        
        
    }

    @FXML
    private void Modifier(ActionEvent event) {
         OffreCrud tt=new OffreCrud();

    
        if ((tfId.getText().isEmpty())||(tfNom1.getText().isEmpty())||(tfEmail11.getText().isEmpty())||(tfLogo11.getText().isEmpty())||(tfTitle1.getText().isEmpty())||(tfDescription1.getText().isEmpty())||(tfCategorie1.getText().isEmpty()))
{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid data");
            alert.setHeaderText("Cannot modifier a entry");
            alert.setContentText("un des champs est vide ");

            alert.showAndWait();
        } 

        
       else{    
       
         int a= Integer.parseInt(tfId.getText());
                  int b= Integer.parseInt(tfCategorie1.getText());

     Offre e=new Offre(a,tfNom1.getText(),tfEmail11.getText(),tfLogo11.getText(),tfTitle1.getText(),tfDescription1.getText(),b);
OffreCrud s=new OffreCrud();
s.UpdateOffre(e);
OffreCrud cs = new OffreCrud();

         List<Offre> lc = cs.ListEntite();
        
          ObservableList<Offre> data =
                  
        FXCollections.observableArrayList(lc );
          
      
 
 
 
        table.setItems(data);
        
    }
    }

    @FXML
    private void afficherform(MouseEvent event) {
         Offre t = table.getSelectionModel().getSelectedItem();         

        tfId.setText(String.valueOf(t.getId()));
        tfNom1.setText(String.valueOf(t.getNom()));
        tfEmail11.setText(String.valueOf(t.getEmail()));
        tfLogo11.setText(String.valueOf(t.getlogo()));
        tfTitle1.setText(String.valueOf(t.getTitle()));
        tfDescription1.setText(String.valueOf(t.getDescription()));
        tfCategorie1.setText(String.valueOf(t.getCategorie()));
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
    
}
