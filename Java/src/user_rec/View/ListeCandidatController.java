/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.View;

import java.io.File;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import user_rec.Controllers.ListData;
import user_rec.Dao.CandidateDao;
import user_rec.Entities.Candidate;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ListeCandidatController implements Initializable {
    ListData listdata = new ListData();
          private ObservableList<Candidate> candidate2=FXCollections.observableArrayList();
              private ObservableList<Candidate> candidateup=FXCollections.observableArrayList();

                  private ObservableList<Candidate> candidatedown=FXCollections.observableArrayList();

                  String Candidate[];
    @FXML
    private TableView<Candidate> CanTable;
    @FXML
    private TableColumn<Candidate, Integer> idC;
    @FXML
    private TableColumn<Candidate, String> nomC;
    @FXML
    private TableColumn<Candidate, String> prenomC;
    @FXML
    private TableColumn<Candidate, Integer> telC;
    @FXML
    private TableColumn<Candidate, String> paysC;
    @FXML
    private TableColumn<Candidate, String> govC;
    @FXML
    private TableColumn<Candidate, String> adresseC;
    @FXML
    private TableColumn<Candidate, Integer> cpC;
    @FXML
    private TableColumn<Candidate, String> bdC;
    @FXML
    private TableColumn<Candidate, String> ppC;
    @FXML
    private TableColumn<Candidate, String> cvC;
    @FXML
    private TableColumn<Candidate, String> AboutC;
    @FXML
    private Button refresh;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TextField search;
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
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CanTable.setItems(listdata.getCandidate());
        idC.setCellValueFactory(cell -> cell.
                getValue().getIdP().asObject());
        nomC.setCellValueFactory(cell -> cell.
                getValue().getNomP());
        prenomC.setCellValueFactory(cell -> cell.
                getValue().getPrenomP());
        telC.setCellValueFactory(cell -> cell.
                getValue().getTelP().asObject());
        paysC.setCellValueFactory(cell -> cell.
                getValue().getPaysP());
        govC.setCellValueFactory(cell -> cell.
                getValue().getGouvernoratP());
        adresseC.setCellValueFactory(cell -> cell.
                getValue().getAdresseP());
        cpC.setCellValueFactory(cell -> cell.
                getValue().getCode_postalP().asObject());
        bdC.setCellValueFactory(cell -> cell.
                getValue().getBirthdayP());
        ppC.setCellValueFactory(cell -> cell.
                getValue().getProfile_picP());
        cvC.setCellValueFactory(cell -> cell.
                getValue().getCvP());
        AboutC.setCellValueFactory(cell -> cell.
                getValue().getAbout_youP());
        
        //updating
        
            CanTable.setOnMouseClicked(event->{
        tfNom.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getNom()));
        id.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getId()));
         tfPrenom.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getPrenom()));
         tfTel.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getTel()));
                    
        TfPays.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getPays()));
        tfGouvernorat.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getGouvernorat()));
        tfAdresse.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getAdresse()));
        tfCodePostal.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getCode_postal()));
       tfAboutyou.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getAbout_you()));
       tfPic.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getProfile_pic()));
       tfCV.setText(String.valueOf(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
              .getCv()));
      tfBday.setValue (LocalDate.parse(listdata.getCandidate()
                .get(CanTable.getSelectionModel().getSelectedIndex())
                .getBirthday()));
                    });

             
           update.setOnAction(event->{

              Candidate c1 = new Candidate(tfNom.getText(),tfPrenom.getText(),TfPays.getText(),tfGouvernorat.getText(),tfAdresse.getText(),String.valueOf(tfBday.getValue()),tfPic.getText(),tfCV.getText(),tfAboutyou.getText(),Integer.parseInt(tfTel.getText()),Integer.parseInt(tfCodePostal.getText()),Integer.parseInt(id.getText())
);

                     CandidateDao pdao = CandidateDao.getInstance();
                     pdao.update(c1);
                       });
           
        
        
        //Search 
        
                 CandidateDao cda=CandidateDao.getInstance();

        
        candidate2= (ObservableList<Candidate>) cda.displayAll();
      
        FilteredList<Candidate> filteredData = new FilteredList<>(candidate2, b -> true);
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
				} else if (cdE.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (cdE.getPays().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                  else if (String.valueOf(cdE.getCode_postal()).indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                   else if (cdE.getGouvernorat().toLowerCase().indexOf(lowerCaseFilter) != -1) {
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
		SortedList<Candidate> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(CanTable.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		CanTable.setItems(sortedData);
        
        //endsearch
        //delete 
        delete.setOnAction(event -> {
                    
             int x=    Integer.parseInt(id.getText());
                CandidateDao cdao = CandidateDao.getInstance();
                  Candidate c =          cdao.displayById(x);
                  cdao.delete(c);
          
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
                Logger.getLogger(ListeCandidatController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void refresh(MouseEvent event) {
                     try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/user_rec/View/listeCandidat.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void attachPic(MouseEvent event) {
         JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                tfPic.setText(imagepath);
                        }
        
    }

    @FXML
    private void attachCv(MouseEvent event) {
         JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                tfCV.setText(imagepath);}
    
    }
    
}
