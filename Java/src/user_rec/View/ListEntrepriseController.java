/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.View;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import user_rec.Controllers.ListData;
import user_rec.Dao.CandidateDao;
import user_rec.Dao.EntrepriseDao;
import user_rec.Entities.Candidate;
import user_rec.Entities.Entreprise;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ListEntrepriseController implements Initializable {
    ListData listdata = new ListData();
          private ObservableList<Entreprise> entreprise2=FXCollections.observableArrayList();
              private ObservableList<Entreprise> entrepriseup=FXCollections.observableArrayList();

                  private ObservableList<Entreprise> entreprisedown=FXCollections.observableArrayList();

                  String Entreprise[];
    @FXML
    private TableColumn<Entreprise, Integer> idC;
    @FXML
    private TableColumn<Entreprise, String> nomC;
    @FXML
    private TableColumn<Entreprise, Integer> telC;
    @FXML
    private TableColumn<Entreprise, String> adresseC;
    @FXML
    private TableColumn<Entreprise, String> ppC;
    @FXML
    private TableColumn<Entreprise, String> webC;
    @FXML
    private TableColumn<Entreprise, String> twC;
    @FXML
    private TableColumn<Entreprise, String> LinkC;
    @FXML
    private TableColumn<Entreprise, String> FbC;
    @FXML
    private TableColumn<Entreprise, String> AboutC;
    @FXML
    private Button refresh;
    @FXML
    private Button update;
    @FXML   
    private Button delete;
    @FXML
    private TextField search;
    @FXML
    private TableView<Entreprise> EntTable;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfSiteweb;
    @FXML
    private TextField tfTwitter;
    @FXML
    private TextField tfLinkedin;
    @FXML
    private TextField tfFacebook;
    @FXML
    private TextField tfPic;
    @FXML
    private TextArea tfAbout;
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         EntTable.setItems(listdata.getEntreprise());
        idC.setCellValueFactory(cell -> cell.
                getValue().getIdP().asObject());
        nomC.setCellValueFactory(cell -> cell.
                getValue().getNomP());

        telC.setCellValueFactory(cell -> cell.
                getValue().getTelP().asObject());
       
        adresseC.setCellValueFactory(cell -> cell.
                getValue().getAdresseP());
     
        ppC.setCellValueFactory(cell -> cell.
                getValue().getProfile_picP());
        webC.setCellValueFactory(cell -> cell.
                getValue().getSitewebP());
        twC.setCellValueFactory(cell -> cell.
                getValue().getTwitterP());
        FbC.setCellValueFactory(cell -> cell.
                getValue().getFacebookP());
        LinkC.setCellValueFactory(cell -> cell.
                getValue().getLinkdinP());
        AboutC.setCellValueFactory(cell -> cell.
                getValue().getAboutP());
        
        //updating
        
            EntTable.setOnMouseClicked(event->{
        tfNom.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getNom()));
        id.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getId()));
       
         tfTel.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getTel()));
                    
       tfAbout.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getAbout()));
       tfSiteweb.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getSiteweb()));
       
      tfTwitter.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getTwitter()));
      tfLinkedin.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getLinkdin()));
      tfFacebook.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getFacebook()));
       
     
        tfAdresse.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getAdresse()));

       tfPic.setText(String.valueOf(listdata.getEntreprise()
                .get(EntTable.getSelectionModel().getSelectedIndex())
              .getProfile_pic()));
   
                    });

             
           update.setOnAction(event->{

              Entreprise e1 = new Entreprise(       tfNom.getText(), tfAbout.getText(),tfAdresse.getText(),tfSiteweb.getText(),tfTwitter.getText(),tfLinkedin.getText(),tfFacebook.getText(),tfPic.getText(),Integer.parseInt(tfTel.getText()),Integer.parseInt(id.getText()));

                     EntrepriseDao pdao = EntrepriseDao.getInstance();
                     pdao.update(e1);
                       });
           
        
        
        //Search 
        
                 EntrepriseDao eda=EntrepriseDao.getInstance();

        
        entreprise2= (ObservableList<Entreprise>) eda.displayAll();
      
        FilteredList<Entreprise> filteredData = new FilteredList<>(entreprise2, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(cdE -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (cdE.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (cdE.getSiteweb().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (cdE.getTwitter().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}

                                   else if (cdE.getFacebook().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                    else if (cdE.getLinkdin().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (String.valueOf(cdE.getId()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
				else if (String.valueOf(cdE.getTel()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
        	// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Entreprise> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(EntTable.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		EntTable.setItems(sortedData);
        
        //endsearch
        //delete 
        delete.setOnAction(event -> {
                    
             int x=    Integer.parseInt(id.getText());
                EntrepriseDao edao = EntrepriseDao.getInstance();
                  Entreprise e =          edao.displayById(x);
                  edao.delete(e);
          
                });
        
        
        
        
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
                Logger.getLogger(ListEntrepriseController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void refresh(MouseEvent event) {
                   try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/user_rec/View/listEntreprise.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
