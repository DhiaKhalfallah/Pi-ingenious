/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.View;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import user_rec.Controllers.ListData;
import user_rec.Dao.CandidateDao;
import user_rec.Dao.ReclamationDao;
import user_rec.Entities.Candidate;
import user_rec.Entities.Reclamation;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ListeReclamationController implements Initializable {
    ListData listdata = new ListData();
          private ObservableList<Reclamation> claim2=FXCollections.observableArrayList();
              private ObservableList<Reclamation> claimup=FXCollections.observableArrayList();

                  private ObservableList<Reclamation> claimdown=FXCollections.observableArrayList();

                  String Reclamation[];
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
    private Button refresh;
    @FXML
    private Button delete;
    @FXML
    private TextField search;
    @FXML
    private TextField id;
    @FXML
    private TableView<Reclamation> RecTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        RecTable.setItems(listdata.getReclamation());
        idC.setCellValueFactory(cell -> cell.
                getValue().getIdP().asObject());
        userC.setCellValueFactory(cell -> cell.
                getValue().getUser_idP().asObject());
        emailC.setCellValueFactory(cell -> cell.
                getValue().getUser_emailP());
         claimC.setCellValueFactory(cell -> cell.
                getValue().getClaimP());
         DateC.setCellValueFactory(cell -> cell.
                getValue().getSubmit_dateP());
         
         RecTable.setOnMouseClicked(event->{
                     id.setText(String.valueOf(listdata.getReclamation()
                .get(RecTable.getSelectionModel().getSelectedIndex())
              .getId()));
         });
         
         delete.setOnAction(event -> {
                    
             int x=    Integer.parseInt(id.getText());
                ReclamationDao rdao = ReclamationDao.getInstance();
                  Reclamation r =          rdao.displayById(x);
                  rdao.delete(r);
          
                });
         
         //Search 
        
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
         
    }    

    @FXML
    private void redirectBack(MouseEvent event) {
                       try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/user_rec/View/Acceuil.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListeReclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void refresh(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/user_rec/View/listeReclamation.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
