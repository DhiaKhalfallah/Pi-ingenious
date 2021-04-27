/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import animatefx.animation.BounceIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.pdfjet.A4;
import com.pdfjet.Cell;
import com.pdfjet.CoreFont;
import com.pdfjet.Font;
import com.pdfjet.PDF;
import com.pdfjet.Page;
import com.pdfjet.Table;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import art_comm.Dao.EventDao;
import art_comm.Entities.Event;
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
import javax.swing.JFileChooser;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class EventBackendController implements Initializable {
ListData listdata= new ListData();
  private ObservableList<Event> event2=FXCollections.observableArrayList();
              private ObservableList<Event> eventtup=FXCollections.observableArrayList();

                  private ObservableList<Event> eventdown=FXCollections.observableArrayList();
                  Event event;
                  Event eventE;
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
    private Button pdf;
    @FXML
    private TextField search;
    @FXML
    private Button create;
    @FXML
    private Button refresh1;
    @FXML
    private JFXButton attach;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;
    @FXML
    private HBox parti;
    @FXML
    private TableView<Event> eventTab;
    @FXML
    private TableColumn<Event, Integer> idc;
    @FXML
    private TableColumn<Event, Integer> lieuc;
    @FXML
    private TableColumn<Event, Integer> entreprise_idc;
    @FXML
    private TableColumn<Event, Integer> par_idc;
    @FXML
    private TableColumn<Event, Integer> ent_idc;
    @FXML
    private TableColumn<Event, String> datec;
    @FXML
    private TableColumn<Event, String> descriptionc;
    @FXML
    private TableColumn<Event, String> nomc;
    @FXML
    private TableColumn<Event, String> imagec;
    @FXML
    private TableColumn<Event, String> categoriec;
    @FXML
    private TableColumn<Event, String> datefinc;
    @FXML
    private JFXTextField idl;
    @FXML
    private JFXTextField lieul;
    @FXML
    private JFXTextField entreprise_idl;
    @FXML
    private JFXDatePicker datel;
    @FXML
    private JFXDatePicker datefinl;
    @FXML
    private JFXTextField nbrl;
    @FXML
    private JFXTextField par_idl;
    @FXML
    private JFXTextField ent_idl;
    @FXML
    private JFXTextField descriptionl;
    @FXML
    private JFXTextField noml;
    @FXML
    private JFXTextField categoriel;
    @FXML
    private JFXTextField imagel;
    @FXML
    private HBox events;
    @FXML
    private TableColumn<Event, Integer> nbrc;
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
     
    datefinl.setValue(localDate);
          eventTab.setItems(listdata.getEvent());
                   nomc.setCellValueFactory(cell -> cell.
                getValue().getNomProperty2());
        categoriec.setCellValueFactory(cell -> cell.
                getValue().getCategorieProperty()); 
            datefinc.setCellValueFactory(cell -> cell.
                getValue().getDatefProperty());      
         idc.setCellValueFactory(cell -> cell.
                getValue().getIdProperty().asObject()); 
        lieuc.setCellValueFactory(cell -> cell.
                getValue().getLieuProperty().asObject());
                entreprise_idc.setCellValueFactory(cell -> cell.
                getValue().getentreprise_idProperty().asObject());
                nbrc.setCellValueFactory(cell -> cell.
                getValue().getnbrProperty().asObject()); 
            par_idc.setCellValueFactory(cell -> cell.
                getValue().getent_idProperty().asObject()); 
                 ent_idc.setCellValueFactory(cell -> cell.
                getValue().getPar_idProperty().asObject());
                   ent_idc.setCellValueFactory(cell -> cell.
                getValue().getent_idProperty().asObject());
                   datec.setCellValueFactory(cell -> cell.
                getValue().getDatPropertye());
   descriptionc.setCellValueFactory(cell -> cell.
                getValue().getDescriptionProperty());

imagec.setCellValueFactory(cell -> cell.
                getValue().getImageProperty());
        
        
        
       
        
         eventTab.setOnMouseClicked(event->{
          descriptionl.setText(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getdescription());
             noml.setText(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getNom2());
                categoriel.setText(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getCategorie());
                   imagel.setText(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getImage());
           
                         datefinl.setValue (LocalDate.parse(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getDate()));
                           datel.setValue (LocalDate.parse(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getDate()));
      
                                    idl.setText(String.valueOf(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getId()));                              
         
                                    nbrl.setText(String.valueOf(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getNbr()));  
                                                           lieul.setText(String.valueOf(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getLieu()));
                                                                                  entreprise_idl.setText(String.valueOf(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getEntreprise_id()));
                   ent_idl.setText(String.valueOf(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getent_id()));
                    par_idl.setText(String.valueOf(listdata.getEvent()
                .get(eventTab.getSelectionModel().getSelectedIndex())
                .getPar_id())); 
                 })  ;
     

        EventDao pda=EventDao.getInstance();

        
        event2= (ObservableList<Event>) pda.displayAll();
      
        FilteredList<Event> filteredData = new FilteredList<>(event2, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(eventE -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (eventE.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (eventE.getDatef().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                               
                                else if (eventE.getdescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                else if (eventE.getNom2().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                    else if (eventE.getImage().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                        else if (eventE.getCategorie().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (String.valueOf(eventE.getEntreprise_id()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                     else if (String.valueOf(eventE.getLieu()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                         else if (String.valueOf(eventE.getId()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                                   else if (String.valueOf(eventE.getent_id()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}  
                                 else if (String.valueOf(eventE.getPar_id()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}  
				else if (String.valueOf(eventE.getNbr()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
        
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Event> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(eventTab.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		eventTab.setItems(sortedData);
        
                delete.setOnAction(event -> {
                    
             int x=    Integer.parseInt(idl.getText());
                EventDao pdao = EventDao.getInstance();
                 Event p =          pdao.displayById(x);
                  pdao.delete(p);
          
                });
                       update.setOnAction(event->{
                      int  x=    Integer.parseInt(idl.getText());
                        Event p1 = new Event(Integer.parseInt(idl.getText()),Integer.parseInt(lieul.getText()),Integer.parseInt(entreprise_idl.getText()), Integer.parseInt(nbrl.getText()),Integer.parseInt(par_idl.getText()),Integer.parseInt(ent_idl.getText()),String.valueOf(datel.getValue()),descriptionl.getText(), noml.getText(),imagel.getText(),categoriel.getText(),String.valueOf(datefinl.getValue()));

                     EventDao pdao = EventDao.getInstance();
                     pdao.update(p1);
                       });
        // TODO
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void pdf(MouseEvent event) throws FileNotFoundException, Exception {
         File out = new File("Event.pdf");
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
          cell  = new Cell(f1,lieuc.getText());
        tableRow.add(cell);
          cell  = new Cell(f1,ent_idc.getText());
        tableRow.add(cell);
           cell = new Cell(f1,nbrc.getText());
        tableRow.add(cell);
  
           cell = new Cell(f1,par_idc.getText());
        tableRow.add(cell);
           cell = new Cell(f1,ent_idc.getText());
        tableRow.add(cell);
          cell = new Cell(f1,datec.getText());
        tableRow.add(cell);
          cell = new Cell(f1,descriptionc.getText());
        tableRow.add(cell);
          cell = new Cell(f1,nomc.getText());
        tableRow.add(cell);
          cell = new Cell(f1,imagec.getText());
        tableRow.add(cell);
          cell = new Cell(f1,categoriec.getText());
        tableRow.add(cell);
          cell = new Cell(f1,datefinc.getText());
        tableRow.add(cell);
         
        tableData.add(tableRow);
        List<Event>items = eventTab.getItems();
        for(Event bl:items)
        {
            Cell id = new Cell(f2,String.valueOf(bl.getId()));
            Cell lieu =new Cell(f2,String.valueOf(bl.getLieu()));
            Cell Entreprise_id = new Cell(f2,String.valueOf(bl.getEntreprise_id()));
            Cell nbr = new Cell(f2,String.valueOf(bl.getNbr()));
            Cell par_id = new Cell(f2,String.valueOf(bl.getPar_id()));
               Cell ent_id = new Cell(f2,String.valueOf(bl.getent_id()));
            Cell description = new Cell(f2,bl.getdescription());
                Cell nom = new Cell(f2,bl.getNom2());
              Cell image  = new Cell(f2,bl.getImage());
            Cell categorie = new Cell (f2,(bl.getCategorie()));
                        Cell datef = new Cell(f2,String.valueOf(bl.getDatef()));
                        Cell date = new Cell(f2,String.valueOf(bl.getDate()));

            tableRow = new ArrayList<Cell>();
            tableRow.add(id);
                 tableRow.add(lieu);
                      tableRow.add(Entreprise_id);
                           tableRow.add(nbr);
                                tableRow.add(par_id);
 tableRow.add(ent_id);
 tableRow.add(nom);
  tableRow.add(image);
   tableRow.add(categorie);
    tableRow.add(datef);
     tableRow.add(date);
         tableData.add(tableRow);

        } 
        table.setData(tableData);

 table.setPosition(10f,90f );
 table.setColumnWidth(0, 50f);
 table.setColumnWidth(1, 50f);
  table.setColumnWidth(2, 50f);
   table.setColumnWidth(3, 50f);
    table.setColumnWidth(4, 50f);
     table.setColumnWidth(5, 50f);
     table.setColumnWidth(6, 50f);
          table.setColumnWidth(7, 50f);
               table.setColumnWidth(8, 50f);
                    table.setColumnWidth(9, 50f);
                         table.setColumnWidth(10, 50f);
                              table.setColumnWidth(11, 50f);
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
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AddEventB.fxml"));
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
    private void refresh(MouseEvent event) {
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
    private void attach(MouseEvent event) {
              JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                imagel.setText(imagepath);
      
			}
    }

    private void eventbt(MouseEvent event) {
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
    private void partibt(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/partiB.fxml"));
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
