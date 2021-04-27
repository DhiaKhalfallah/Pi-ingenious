/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;
import javafx.collections.transformation.FilteredList;
import animatefx.animation.BounceIn;
import art_comm.Dao.CommentaireDao;
import art_comm.Entities.Commentaire;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.pdfjet.A4;
import com.pdfjet.Cell;
import com.pdfjet.CoreFont;
import com.pdfjet.Font;
import com.pdfjet.PDF;
import com.pdfjet.Page;
import com.pdfjet.Table;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class CommentaireFrontController implements Initializable {
art_comm.Controllers.ListData  listdata = new art_comm.Controllers.ListData();
 private ObservableList<Commentaire> commentaire2=FXCollections.observableArrayList();
          Commentaire Commentaire;
              private ObservableList<Commentaire> commentaireup=FXCollections.observableArrayList();

                  private ObservableList<Commentaire> commentairedown=FXCollections.observableArrayList();
    @FXML
    private BorderPane root;
    @FXML
    private VBox rootpB;
    @FXML
    private Pane status;
    @FXML
    private Text back;
    @FXML
    private TableColumn<Commentaire, Integer> user;
    private Button full;
    @FXML
    private FontAwesomeIcon back2;
    @FXML
    private HBox dashboard;
    @FXML
    private HBox reviews;
    @FXML
    private HBox blogd;
    @FXML
    private HBox sms;
    @FXML
    private Button back3;
    @FXML
    private FontAwesomeIcon backfont;
    @FXML
    private Button pdf;
    @FXML
    private TextField search;
    @FXML
    private HBox events;
    @FXML
    private HBox parti;
    @FXML
    private Button capture;
    @FXML
    private Button create;
    @FXML
    private TableView<Commentaire> commTable;
    @FXML
    private TableColumn<Commentaire, Integer> id;
    @FXML
    private TableColumn<Commentaire, String> nom;
    @FXML
    private TableColumn<Commentaire, String> mail;
    @FXML
    private TableColumn<Commentaire, String> subject;
    @FXML
    private TableColumn<Commentaire, Integer> mobile;
    @FXML
    private TableColumn<Commentaire, String> commentaire;
    @FXML
    private TableColumn<Commentaire, String> date;
    @FXML
    private TableColumn<Commentaire, Integer> blog_id;
    @FXML
    private TableColumn<Commentaire, Integer> rate;
    @FXML
    private JFXTextField idl;
    @FXML
    private JFXTextField userl;
    @FXML
    private JFXTextField noml;
    @FXML
    private JFXTextField maill;
    @FXML
    private JFXTextField subjectl;
    @FXML
    private JFXTextField mobilel;
    @FXML
    private JFXTextArea commentairel;
    @FXML
    private JFXDatePicker datel;
    @FXML
    private Rating ratel;
    @FXML
    private JFXTextField blog_idl;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;
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
        // TODO
  
                new BounceIn(status).play();
                LocalDate localDate = LocalDate.now();
    datel.setValue(localDate);
                new BounceIn(status).play();
                commTable.setItems(listdata.getComm());
        
         id.setCellValueFactory(cell -> cell.
                getValue().getIdProperty().asObject()); 
          user.setCellValueFactory(cell -> cell.
                getValue().getUserProperty().asObject()); 
        nom.setCellValueFactory(cell -> cell.
                getValue().getNomProperty());
        mail.setCellValueFactory(cell -> cell.
                getValue().getMailProperty());
        subject.setCellValueFactory(cell -> cell.
                getValue().getSubjectProperty());
        mobile.setCellValueFactory(cell -> cell.
                getValue().getMobileProperty().asObject());
        commentaire.setCellValueFactory(cell -> cell.
                getValue().getCommentaireProperty());
        
              date.setCellValueFactory(cell -> cell.
                getValue().getDateProperty());
                    blog_id.setCellValueFactory(cell -> cell.
                getValue().getblog_idProperty().asObject());
              rate.setCellValueFactory(cell -> cell.
                getValue().getRateProperty().asObject());
        
            commTable.setOnMouseClicked((MouseEvent event)->{
        idl.setText(String.valueOf(listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
              .getId()));
          userl.setText(String.valueOf(listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
              .getUser()));
       noml.setText(listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getNom());
              datel.setValue(LocalDate.parse(listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getDate()));
          
              maill.setText(listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getMail());
                 subjectl.setText(listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getSubject());
          mobilel.setText(String.valueOf(listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getMobile()));
            commentairel.setText((listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getCommentaire()));
              ratel.setRating((listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getRate()));
                blog_idl.setText(String.valueOf((listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getBlog_id())));
          
    });
        
        
        

        CommentaireDao pda=CommentaireDao.getInstance();

        
        commentaire2= (ObservableList<Commentaire>) pda.displayAll();
      
        FilteredList<Commentaire> filteredData = new FilteredList<>(commentaire2, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Commentaire -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Commentaire.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (Commentaire.getMail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (Commentaire.getSubject().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                  else if (Commentaire.getCommentaire().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                   else if (Commentaire.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (String.valueOf(Commentaire.getId()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                   else if (String.valueOf(Commentaire.getRate()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                     else if (String.valueOf(Commentaire.getBlog_id()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                       else if (String.valueOf(Commentaire.getUser()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
                                         else if (String.valueOf(Commentaire.getMobile()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
				else if (String.valueOf(Commentaire.getUser()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
        
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Commentaire> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(commTable.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		commTable.setItems(sortedData);
        
            
         // TODO
    }    

    private void refresh(MouseEvent event) {
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

    private void fullb(MouseEvent event) {
            Stage stage = (Stage) full.getScene().getWindow();
       stage.setFullScreen(true);
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

    private void dashboarbt(MouseEvent event) {
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
    private void backfontaw(MouseEvent event) {
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
    private void pdf(MouseEvent event) throws FileNotFoundException, Exception {
        File out = new File("Commentaire.pdf");
        FileOutputStream fos = new FileOutputStream(out);
        PDF pdf = new PDF(fos);
        Page page = new Page(pdf,A4.PORTRAIT);
        Font f1 = new Font(pdf,CoreFont.HELVETICA_BOLD);
        Font f2= new Font(pdf,CoreFont.HELVETICA);
        Table table = new Table();
        List<List<Cell>> tableData = new ArrayList<>();
        List<Cell> tableRow = new ArrayList<>();
        
    
        Cell  cell  = new Cell(f1,nom.getText());
        tableRow.add(cell);
           cell = new Cell(f1,date.getText());
        tableRow.add(cell);
           cell = new Cell(f1,mail.getText());
        tableRow.add(cell);
           cell = new Cell(f1,subject.getText());
        tableRow.add(cell);
           cell = new Cell(f1,mobile.getText());
        tableRow.add(cell);
          cell = new Cell(f1,commentaire.getText());
        tableRow.add(cell);
      

         
        tableData.add(tableRow);
        List<Commentaire>items = commTable.getItems();
        for(Commentaire bl:items)
        {
            Cell nom = new Cell(f2,bl.getNom());    
            Cell date = new Cell (f2,bl.getDate());
            Cell mail = new Cell(f2,bl.getMail());
            Cell subject = new Cell(f2,bl.getSubject());
            Cell mobile = new Cell(f2,String.valueOf(bl.getMobile()));
            Cell commentaire = new Cell (f2,bl.getCommentaire());
       
            tableRow = new ArrayList<Cell>();
                      tableRow.add(nom);
                           tableRow.add(date);
                                tableRow.add(mail);
 tableRow.add(subject);
 tableRow.add(mobile);
  tableRow.add(commentaire);
  
         tableData.add(tableRow);

        } 
        table.setData(tableData);

table.setPosition(30f,90f );
 table.setColumnWidth(0, 70f);
 table.setColumnWidth(1, 70f);
  table.setColumnWidth(2, 150f);
   table.setColumnWidth(3, 70f);
    table.setColumnWidth(4, 70f);
     table.setColumnWidth(5, 100f);

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
                                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("PDF succees!");
        alert.show();
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

    private void eventbt(MouseEvent event) {
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

    @FXML
    private void capturebt(MouseEvent event) {
         try {
        Robot robot = new Robot();
        java.awt.Rectangle rectangle = new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage image = robot.createScreenCapture(rectangle);
        Image myImage=SwingFXUtils.toFXImage(image,null);
        ImageIO.write(image, "jpg", new File ("out.jpg"));
                                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Shot Taken!");
        alert.show();
     
    } catch (AWTException ex) {
        Logger.getLogger(BlogFrontController.class.getName()).log(Level.SEVERE, null, ex);
    }   catch (IOException ex) {
            Logger.getLogger(CommentaireFrontController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @FXML
    private void create(MouseEvent event) {
    }

    @FXML
    private void updatebt(MouseEvent event) {
        if (( commTable.getSelectionModel().selectedItemProperty().get())==null)
                        {
                                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Click On Something!");
        alert.show();
                        }
                    else
                        {
                      int  x=    Integer.parseInt(idl.getText());

                        Commentaire p1 = new Commentaire(Integer.parseInt(userl.getText()), noml.getText(),maill.getText(),subjectl.getText(),Integer.parseInt(mobilel.getText()),commentaire.getText(),String.valueOf(datel.getValue()),Integer.parseInt(blog_idl.getText()), (int) ratel.getRating(),Integer.parseInt(idl.getText()));

                     CommentaireDao pdao = CommentaireDao.getInstance();
                     pdao.update(p1);
                                     Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information Dialog");
        alert2.setHeaderText(null);
        alert2.setContentText("Update  avec succés!");
        alert2.show();
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
    }

    @FXML
    private void deletebt(MouseEvent event) {
        if (( commTable.getSelectionModel().selectedItemProperty().get())==null)
                        {
                                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Click On Something!");
        alert.show();
                        }
                    else
                        {
                                       Alert alert =new Alert(Alert.AlertType.WARNING);
                            alert.setContentText("his is the content of the  warning");
                            alert.setTitle("Clear all fields");
                            alert.setHeaderText("Are you sure you want to delete this item");
                            ButtonType cancelButtonType = new ButtonType("cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
          alert.getDialogPane().getButtonTypes().add(cancelButtonType);
          Optional<ButtonType> result=alert.showAndWait();
          if (result.isPresent() && result.get()==ButtonType.OK)
                               {
             int x=    Integer.parseInt(idl.getText());
                CommentaireDao pdao = CommentaireDao.getInstance();
                  Commentaire p =          pdao.displayById(x);
                  pdao.delete(p);
                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information Dialog");
        alert2.setHeaderText(null);
        alert2.setContentText("Delete  avec succés!");
        alert2.show();
                 try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/CommentaireFront.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
                        }
          
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
