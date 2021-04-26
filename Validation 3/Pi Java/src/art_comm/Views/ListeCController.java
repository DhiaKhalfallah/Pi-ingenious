/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Views;

import com.jfoenix.controls.JFXButton;
import com.pi.Dao.CandidateDao;
import com.pi.Entities.Candidate;
import com.pi.controllers.Excel;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import com.pi.controllers.ListData;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import jxl.write.WriteException;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ListeCController implements Initializable {
     ListData listdata = new ListData();
          private ObservableList<Candidate> candidate2=FXCollections.observableArrayList();
              private ObservableList<Candidate> candidateup=FXCollections.observableArrayList();

                  private ObservableList<Candidate> candidatedown=FXCollections.observableArrayList();

                  String Candidate[];

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
    private JFXButton update;
    @FXML
    private JFXButton delete;
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
    private DatePicker tfBday;
    @FXML
    private TextField tfPic;
    @FXML
    private TextField tfCV;
    @FXML
    private TextArea tfAboutyou;
    @FXML
    private TextField id;
    @FXML
    private Button excel;
    @FXML
    private Button Stats;

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
                          if (id.getText() == null || id.getText().trim().isEmpty())
        {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("You need to choose a user to edit");
                a.show();
        //

        }
                          else {

              Candidate c1 = new Candidate(tfNom.getText(),tfPrenom.getText(),TfPays.getText(),tfGouvernorat.getText(),tfAdresse.getText(),String.valueOf(tfBday.getValue()),tfPic.getText(),tfCV.getText(),tfAboutyou.getText(),Integer.parseInt(tfTel.getText()),Integer.parseInt(tfCodePostal.getText()),Integer.parseInt(id.getText())
);

                     CandidateDao pdao = CandidateDao.getInstance();
                     pdao.update(c1);
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
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (cdE.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true;
				} else if (cdE.getPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; }
                                 else if (cdE.getPays().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;  
				}
                                  else if (String.valueOf(cdE.getCode_postal()).indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
                                   else if (cdE.getGouvernorat().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
                                 else if (String.valueOf(cdE.getId()).indexOf(lowerCaseFilter)!=-1){
					return true; 
				}
				else if (String.valueOf(cdE.getTel()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false;
			});
		});
		SortedList<Candidate> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(CanTable.comparatorProperty());
			CanTable.setItems(sortedData);
        
        //endsearch
        //delete 
         
       
        delete.setOnAction(event -> {
                          if (id.getText() == null || id.getText().trim().isEmpty())
        {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setContentText("You need to choose a user to delete");
                a.show();
        //

        }
                          else {
                              Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Are you sure you want to delete?");
                if (a.showAndWait().get() == ButtonType.OK)
                {
             int x=    Integer.parseInt(id.getText());
                CandidateDao cdao = CandidateDao.getInstance();
                  Candidate c =          cdao.displayById(x);
                  cdao.delete(c);
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

    private void refresh(MouseEvent event) {
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


    @FXML
    private void updateCan(MouseEvent event) {
    }

    @FXML
    private void DeleteCan(MouseEvent event) {
    }

    @FXML
    private void attachPic(MouseEvent event) {
    }

    @FXML
    private void attachCv(MouseEvent event) {
    }

    @FXML
    private void excel(MouseEvent event) throws SQLException, WriteException, IOException {
        Excel excel = new Excel();
        excel.Excel();
    }

    @FXML
    private void userrec(MouseEvent event) {
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
    private void OpenStat(MouseEvent event) {
          try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/com/pi/views/Stat.fxml"));
                 Stage stage = new Stage();
            stage.setTitle("Stats");
            stage.setScene(new Scene(page1, 1600, 900));
            stage.show();
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListeRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
}
