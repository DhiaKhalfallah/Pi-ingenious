/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Views;

import com.jfoenix.controls.JFXButton;
import com.pi.Dao.ReclamationDao;
import com.pi.Entities.Reclamation;
import com.pi.controllers.ListData;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ListeRecController implements Initializable {
     ListData listdata1 = new ListData();
          private ObservableList<Reclamation> claim2=FXCollections.observableArrayList();
              private ObservableList<Reclamation> claimup=FXCollections.observableArrayList();

                  private ObservableList<Reclamation> claimdown=FXCollections.observableArrayList();

                  String Reclamation[];

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
    private FontAwesomeIcon backfont;
    @FXML
    private TextField search;
    @FXML
    private Button refresh1;
    @FXML
    private JFXButton delete;
    @FXML
    private TextField id;
    @FXML
    private TableView<Reclamation> RecTable;
     @FXML
    private TableColumn<Reclamation, Integer> idC;
    @FXML
    private TableColumn<Reclamation, Integer> userC;
    @FXML
    private TableColumn<Reclamation, String> emailC;
    @FXML
    private TableColumn<Reclamation, String> subjectC;
    @FXML
    private TableColumn<Reclamation, String> claimC;
    @FXML
    private TableColumn<Reclamation, String> DateC;
    @FXML
    private TableColumn<Reclamation, Integer> status1;
    @FXML
    private TextField search1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                   
                 
        RecTable.setItems(listdata1.getReclamation());
        idC.setCellValueFactory(cell -> cell.
                getValue().getIdP().asObject());
        userC.setCellValueFactory(cell -> cell.
                getValue().getUser_idP().asObject());
        emailC.setCellValueFactory(cell -> cell.
                getValue().getUser_emailP());
         claimC.setCellValueFactory(cell -> cell.
                getValue().getClaimP());
         subjectC.setCellValueFactory(cell -> cell.
                getValue().getSubjectP());
         DateC.setCellValueFactory(cell -> cell.
                getValue().getSubmit_dateP());
         status1.setCellValueFactory(cell -> cell.
                getValue().getCstatusP().asObject());
         
          RecTable.setOnMouseClicked(event->{
                     id.setText(String.valueOf(listdata1.getReclamation()
                .get(RecTable.getSelectionModel().getSelectedIndex())
              .getId()));
         });
         
         delete.setOnAction(event -> {
                   if (id.getText() == null || id.getText().trim().isEmpty())
        {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("You need to choose a user to delete");
                a.show();
        //

        }
                   else 
                 {
                         Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Are you sure you want to delete?");
                if (a.showAndWait().get() == ButtonType.OK)
                {  
             int x=    Integer.parseInt(id.getText());
                ReclamationDao rdao = ReclamationDao.getInstance();
                  Reclamation r =          rdao.displayById(x);
                  rdao.delete(r);
                 }
                 }
          
                });
    
             ReclamationDao rda=ReclamationDao.getInstance();

       
        claim2= (ObservableList<Reclamation>) rda.displayAll();
      
        FilteredList<Reclamation> filteredData = new FilteredList<>(claim2, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(cdE -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (cdE.getUser_email().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} 
                                else if (cdE.getSubject().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}                               
                                 else if (String.valueOf(cdE.getId()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
				else if (String.valueOf(cdE.getUser_id()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
        	// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(RecTable.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		RecTable.setItems(sortedData);
                
               //SearchAutoComplete 
                  ArrayList<String> valeurs= new ArrayList<String>();
        
          ObservableList<Reclamation> ls = listdata1.getReclamation(); //Logger.getLogger(FormatWindowController.class.getName()).log(Level.SEVERE, null, ex);
          for(Reclamation c:ls)
          {
              valeurs.add(c.getUser_email());
          }
         
         TextFields.bindAutoCompletion(search1, valeurs);
         
         //Try 
         
         RecTable.setRowFactory(row -> {
    return new TableRow<Reclamation>() {
        public void updateItem(Reclamation item, boolean empty) {
            super.updateItem(item, empty); //This is mandatory

            if (item == null || empty) { //If the cell is empty
                setStyle("");
            } else { //If the cell is not empty


                if (item.getCstatus()==1) {
                    setStyle("-fx-background-color: red");
}
                else {
                    //Here I see if the row of this cell is selected or not
                    setStyle("-fx-background-color: green"); //The background of the cell in yellow
                     
                    
                }
            }
        }
    };
});
    }    

    @FXML
    private void back2bt(MouseEvent event) {
    }

    @FXML
    private void backbt(MouseEvent event) {
    }

    @FXML
    private void dashboarbt(MouseEvent event) {
    }

    @FXML
    private void reviewsbt(MouseEvent event) {
    }

    @FXML
    private void blogbt(MouseEvent event) {
    }

    @FXML
    private void smsbt(MouseEvent event) {
    }

    @FXML
    private void backfontaw(MouseEvent event) {
    }

    @FXML
    private void back3bt(MouseEvent event) {
    }

    @FXML
    private void refresh(MouseEvent event) {
          try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/ListeRec.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListeRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void DeleteCan(MouseEvent event) {
    }

    @FXML
    private void userinter(MouseEvent event) {
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/listeC.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListeCandidatController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
