/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import entities.CategorieOffre;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import services.CategorieCrud;

/**
 * FXML Controller class
 *
 * @author RE flex
 */
public class BackCat implements Initializable {

    @FXML
    private BorderPane root;
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
    private FontAwesomeIcon back2;
    @FXML
    private HBox btncategorie;
    @FXML
    private HBox btnoffre;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfLogo;
    @FXML
    private TextField tfColor;
    @FXML
    private Button btnAjouter;
    @FXML
    private TextField tfId1;
    @FXML
    private TextField tfNom1;
    @FXML
    private TextField tfLogo1;
    @FXML
    private TextField tfColor1;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnSup;
    @FXML
    private TableColumn<CategorieOffre,Integer> id;
    @FXML
    private TableColumn<CategorieOffre, String> nom;
    @FXML
    private TableColumn<CategorieOffre ,String> logo;
    @FXML
    private TableColumn<CategorieOffre, String> color;
    @FXML
    private TableView<CategorieOffre> table;
    @FXML
    private Button btnPDF;
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
        
        CategorieCrud cs = new CategorieCrud();

         List<CategorieOffre> lc = cs.ListEntite();
        
          ObservableList<CategorieOffre> data =
                  
        FXCollections.observableArrayList(lc );
          
        id.setCellValueFactory(
                new PropertyValueFactory<>("id"));
          
        nom.setCellValueFactory(
                new PropertyValueFactory<>("nom"));
 
       
        logo.setCellValueFactory(
                new PropertyValueFactory<>("logo"));
 
        
        color.setCellValueFactory(
                new PropertyValueFactory<>("color"));
        
        
        
 
 
        table.setItems(data);
        
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
    private void Ajouter(ActionEvent event) {
        CategorieCrud tt=new CategorieCrud();

    
        if ((tfId.getText().isEmpty())||(tfNom.getText().isEmpty())||(tfLogo.getText().isEmpty())||(tfColor.getText().isEmpty())
){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid data");
            alert.setHeaderText("Cannot add a new entry");
            alert.setContentText("un des champs est vide ");

            alert.showAndWait();
        } 

        
    
         
        
        
       else{    
       
         int a= Integer.parseInt(tfId.getText());

     CategorieOffre e=new CategorieOffre(a,tfNom.getText(),tfLogo.getText(),tfColor.getText());
CategorieCrud s=new CategorieCrud();
s.addCategorieOffre(e);
CategorieCrud cs = new CategorieCrud();

         List<CategorieOffre> lc = cs.ListEntite();
        
          ObservableList<CategorieOffre> data =
                  
        FXCollections.observableArrayList(lc );
          
      
 
 
 
        table.setItems(data);
        
    }}

    @FXML
    private void Modifier(ActionEvent event) {
           CategorieCrud tt=new CategorieCrud();

    
        if ((tfId1.getText().isEmpty())||(tfNom1.getText().isEmpty())||(tfLogo1.getText().isEmpty())||(tfColor1.getText().isEmpty())
){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid data");
            alert.setHeaderText("Cannot modifier a entry");
            alert.setContentText("un des champs est vide ");

            alert.showAndWait();
        } 
        
       else{    
       
         int a= Integer.parseInt(tfId1.getText());

     CategorieOffre e=new CategorieOffre(a,tfNom1.getText(),tfLogo1.getText(),tfColor1.getText());
CategorieCrud s=new CategorieCrud();
s.UpdateCategorieOffre(e);
CategorieCrud cs = new CategorieCrud();

         List<CategorieOffre> lc = cs.ListEntite();
        
          ObservableList<CategorieOffre> data =
                  
        FXCollections.observableArrayList(lc );
          
      
 
 
 
        table.setItems(data);
        
    }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
         CategorieOffre t = table.getSelectionModel().getSelectedItem();         
 
         if ((tfId.getText().isEmpty())||(tfNom.getText().isEmpty())||(tfLogo.getText().isEmpty())||(tfColor.getText().isEmpty())
){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Are You sure you want To Delete this Categorie");
            alert.showAndWait();
        } 
         
CategorieCrud s=new CategorieCrud();
s.DeleteCategorieOffre(t.getId());
CategorieCrud cs = new CategorieCrud();

         List<CategorieOffre> lc = cs.ListEntite();
        
          ObservableList<CategorieOffre> data =
                  
        FXCollections.observableArrayList(lc );
          
 
        table.setItems(data);
        
        
    }

    @FXML
    private void afficherform(MouseEvent event) {
         CategorieOffre t = table.getSelectionModel().getSelectedItem();         

       
        tfNom1.setText(String.valueOf(t.getNom()));
        tfLogo1.setText(String.valueOf(t.getLogo()));
        tfColor1.setText(String.valueOf(t.getColor()));
        
    }

    @FXML
    private void PDF(ActionEvent event) throws DocumentException {
    
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        final File selectedDirectory = directoryChooser.showDialog(null);
        if (selectedDirectory != null) {
            
            String dest = selectedDirectory.getAbsolutePath()+"\\Table des categories.pdf";
            
            
            try {
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream(dest));
                
                doc.open();
                
                
                //Test PDF
                PdfPTable table = new PdfPTable(3);

                table.setWidthPercentage(100);
                table.setSpacingBefore(0f);
                table.setSpacingAfter(0f);

                // first row
                
               PdfPCell cell = new PdfPCell(new Phrase("Tableau des Categorie"));
                cell.setColspan(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(3.0f);
                cell.setBackgroundColor(new BaseColor(140, 221, 8));
                table.addCell(cell);

                
                table.addCell("Nom ");
                table.addCell("Logo");
                table.addCell("Color");
                         

                
                

               
                
                CategorieCrud prodc = new CategorieCrud();
                List<CategorieOffre> liste_client = prodc.ListEntite();
                for (int i = 0; i < liste_client.size(); i++){
                    
                   
                    table.addCell(String.valueOf(liste_client.get(i).getNom()));
                    table.addCell(String.valueOf(liste_client.get(i).getLogo()));
                    table.addCell(String.valueOf(liste_client.get(i).getColor()));
                                

                    
                }
                doc.add(table); 
                
               
                doc.close();
                System.out.println("done");
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } 
        }
    }

    @FXML
    private void userbt(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/ListeC.fxml"));
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
