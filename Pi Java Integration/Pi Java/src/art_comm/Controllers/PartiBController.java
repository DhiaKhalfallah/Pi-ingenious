/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;
import animatefx.animation.BounceIn;
import art_comm.Dao.ParticipantDao;
import art_comm.Entities.Participant;
import com.pdfjet.A4;
import com.pdfjet.Cell;
import com.pdfjet.CoreFont;
import com.pdfjet.Font;
import com.pdfjet.PDF;
import com.pdfjet.Page;
import com.pdfjet.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileOutputStream;
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
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class PartiBController implements Initializable {
    ListData listdata= new ListData();
   private ObservableList<Participant> par2=FXCollections.observableArrayList();
              private ObservableList<Participant> parup=FXCollections.observableArrayList();

                  private ObservableList<Participant> pardown=FXCollections.observableArrayList();
                  Participant participant;

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
    private HBox events;
    @FXML
    private HBox parti;
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
    private Button pdf;
    @FXML
    private TextField search;
    @FXML
    private Button create;
    @FXML
    private Button refresh1;

    @FXML
    private JFXTextField idl;
    @FXML
    private JFXDatePicker datel;
    @FXML
    private JFXTextField noml;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;
    @FXML
    private TableView<Participant> parTable;
    @FXML
    private TableColumn<Participant, Integer> userc;
    @FXML
    private TableColumn<Participant, Integer> eventidc;
    @FXML
    private TableColumn<Participant, String> mailc;
    @FXML
    private TableColumn<Participant, Integer> mobilec;
    @FXML
    private JFXTextField userl;
    @FXML
    private JFXTextField maill;
    @FXML
    private JFXTextField mobilel;
    @FXML
    private TableColumn<Participant, Integer> idc;
    @FXML
    private TableColumn<Participant, String> datec;
    @FXML
    private TableColumn<Participant, String> nomc;
    @FXML
    private JFXTextField eventidl;
    @FXML
    private HBox userb;
    @FXML
    private HBox btncategorie;
    @FXML
    private HBox btnoffre;
    @FXML
    private HBox reclamab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            new BounceIn(status).play();               LocalDate localDate = LocalDate.now();
    datel.setValue(localDate);
        // TODO
        parTable.setItems(listdata.getParticipaant());
        
         idc.setCellValueFactory(cell -> cell.
                getValue().getIdProperty().asObject()); 
          userc.setCellValueFactory(cell -> cell.
                getValue().getUserProperty().asObject()); 
        eventidc.setCellValueFactory(cell -> cell.
                getValue().getEventidProperty().asObject());
        datec.setCellValueFactory(cell -> cell.
                getValue().getDateProperty());
        nomc.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        mailc.setCellValueFactory(cell -> cell.
                getValue().getMailProperty());
        mobilec.setCellValueFactory(cell -> cell.
                getValue().getMobileProperty().asObject());
        
        
        
        
            parTable.setOnMouseClicked(event->{
        idl.setText(String.valueOf(listdata.getParticipaant()
                .get(parTable.getSelectionModel().getSelectedIndex())
              .getId()));
          userl.setText(String.valueOf(listdata.getParticipaant()
                .get(parTable.getSelectionModel().getSelectedIndex())
              .getUser()));
       eventidl.setText(String.valueOf(listdata.getParticipaant()
                .get(parTable.getSelectionModel().getSelectedIndex())
                .getEventid()));
              datel.setValue (LocalDate.parse(listdata.getParticipaant()
                .get(parTable.getSelectionModel().getSelectedIndex())
                .getDate()));
          
              noml.setText(listdata.getParticipaant()
                .get(parTable.getSelectionModel().getSelectedIndex())
                .getNom());
                 maill.setText(listdata.getParticipaant()
                .get(parTable.getSelectionModel().getSelectedIndex())
                .getMail());
          mobilel.setText(String.valueOf(listdata.getParticipaant()
                .get(parTable.getSelectionModel().getSelectedIndex())
                .getMobile()));
    });
        
        
        

         ParticipantDao pda=ParticipantDao.getInstance();

        
        par2= (ObservableList<Participant>) pda.displayAll();
      
        FilteredList<Participant> filteredData = new FilteredList<>(par2, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(participant -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (participant.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (participant.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (participant.getMail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                             
                                 else if (String.valueOf(participant.getId()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                     else if (String.valueOf(participant.getId()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                         else if (String.valueOf(participant.getMobile()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
				else if (String.valueOf(participant.getEventid()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
        
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Participant> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(parTable.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		parTable.setItems(sortedData);
        
                delete.setOnAction(event -> {
                    
             int x=    Integer.parseInt(idl.getText());
                ParticipantDao pdao = ParticipantDao.getInstance();
                  Participant p =          pdao.displayById(x);
                  pdao.delete(p);
          
                });
                       update.setOnAction(event->{
                      int  x=    Integer.parseInt(idl.getText());

                        Participant p1 = new Participant(Integer.parseInt(idl.getText()),Integer.parseInt(userl.getText()), Integer.parseInt(eventidl.getText()),String.valueOf(datel.getValue()),noml.getText(), maill.getText(),Integer.parseInt(mobilel.getText()));

                     ParticipantDao pdao = ParticipantDao.getInstance();
                     pdao.update(p1);
                       });
    
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void dashboarbt(MouseEvent event) {
              try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AcceuillB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void reviewsbt(MouseEvent event) {
                      try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/CommentaireFront.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    private void eventbt(MouseEvent event) {
              try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/Event_Backend.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void partibt(MouseEvent event) {
              try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/PartiB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void backfontaw(MouseEvent event) {
              try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AcceuillB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void pdf(MouseEvent event)throws FileNotFoundException, Exception {
         File out = new File("Participant.pdf");
        FileOutputStream fos = new FileOutputStream(out);
        PDF pdf = new PDF(fos);
        Page page = new Page(pdf,A4.PORTRAIT);
        Font f1 = new Font(pdf,CoreFont.HELVETICA_BOLD);
        Font f2= new Font(pdf,CoreFont.HELVETICA);
        Table table = new Table();
        List<List<Cell>> tableData = new ArrayList<>();
        List<Cell> tableRow = new ArrayList<>();
        
        Cell cell = new Cell(f1,idc.getText());
        tableRow.add(cell);
          cell  = new Cell(f1,userc.getText());
        tableRow.add(cell);
          cell  = new Cell(f1,eventidc.getText());
        tableRow.add(cell);
           cell = new Cell(f1,datec.getText());
        tableRow.add(cell);
           cell = new Cell(f1,nomc.getText());
        tableRow.add(cell);
           cell = new Cell(f1,mailc.getText());
        tableRow.add(cell);
           cell = new Cell(f1,mobilec.getText());
        tableRow.add(cell);
        tableData.add(tableRow);
        List<Participant>items = parTable.getItems();
        for(Participant bl:items)
        {
            Cell id = new Cell(f2,String.valueOf(bl.getId()));
            Cell user =new Cell(f2,String.valueOf(bl.getUser()));
            Cell eventid = new Cell(f2,String.valueOf(bl.getEventid()));
            Cell date = new Cell(f2,bl.getDate());
            Cell nom = new Cell(f2,bl.getNom());
            Cell mail = new Cell(f2,bl.getMail());
            Cell mobile = new Cell (f2,String.valueOf(bl.getMobile()));
            tableRow = new ArrayList<Cell>();
            tableRow.add(id);
                 tableRow.add(user);
                      tableRow.add(eventid);
                           tableRow.add(date);
                                tableRow.add(nom);
 tableRow.add(mail);
 tableRow.add(mobile);
         tableData.add(tableRow);

        } 
        table.setData(tableData);

 table.setPosition(10f,90f );
 table.setColumnWidth(0, 50f);
 table.setColumnWidth(1, 60f);
  table.setColumnWidth(2, 50f);
   table.setColumnWidth(3, 100f);
    table.setColumnWidth(4, 50f);
     table.setColumnWidth(5, 150f);
     table.setColumnWidth(6, 70f);
                    while (true){
                        table.drawOn(page);
                        if(!table.hasMoreData())
                        {
                            table.resetRenderedPagesCount();
                            break;
                        }
                        page= new Page(pdf,A4.PORTRAIT);
                        
        }
                    pdf.flush();
                    fos.close();
                    System.out.println("saved to "+out.getAbsolutePath());
        
    }


    @FXML
    private void create(MouseEvent event) {
              try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AddppartiB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void refresh(MouseEvent event) {
              try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/partiB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(SmsbController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btncat(MouseEvent event) {
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
    private void btnoffre(MouseEvent event) {
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

    
}
