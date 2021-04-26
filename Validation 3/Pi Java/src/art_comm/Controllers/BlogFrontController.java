/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;
import art_comm.Dao.BlogDao;
import art_comm.Entities.Blog;
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
import javafx.animation.FadeTransition;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JFileChooser;

import animatefx.animation.BounceIn;
import animatefx.animation.FadeIn;
import animatefx.animation.Pulse;
import art_comm.Entities.Blog;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class BlogFrontController implements Initializable {
ListData listdata = new ListData();
          private ObservableList<Blog> blog2=FXCollections.observableArrayList();
              private ObservableList<Blog> blogup=FXCollections.observableArrayList();

                  private ObservableList<Blog> blogdown=FXCollections.observableArrayList();

String Blog[];
    @FXML
    private BorderPane root;
    private Button review;
    @FXML
    private VBox rootpB;
    @FXML
    private HBox reviews;
    @FXML
    private Pane status;
    @FXML
    private Text back;
    private JFXDatePicker datel;
    @FXML
    private TextField search;
    @FXML
    private FontAwesomeIcon back2;
    @FXML
    private HBox dashboard;
    @FXML
    private Button back3;
    @FXML
    private Button pdf;
    @FXML
    private Button refresh1;
    @FXML
    private FontAwesomeIcon backfont;
    @FXML
    private HBox blogd;
    @FXML
    private HBox sms;
    private Button full;
    @FXML
    private Button create;
    @FXML
    private TableView<Blog> blog;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<Blog, Integer> user;
    @FXML
    private TableColumn<Blog, String> cat;
    @FXML
    private TableColumn<Blog, String> date;
    @FXML
    private TableColumn<Blog, String> contenu;
    @FXML
    private TableColumn<Blog, String> titre;
    @FXML
    private TableColumn<Blog, String> image;
    @FXML
    private JFXTextField id1;
    @FXML
    private JFXTextField user1;
    @FXML
    private JFXTextField cat1;
    @FXML
    private JFXDatePicker date1;
    @FXML
    private JFXTextField contenu1;
    @FXML
    private JFXTextField titre1;
    @FXML
    private JFXTextField imapa1;
    @FXML
    private JFXButton attach;
    @FXML
    private JFXButton update;
    @FXML
    private JFXButton delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
 
                         final Tooltip tooltip4= new Tooltip();
        tooltip4.setText("Attacher une image ");
        attach.setTooltip(tooltip4);
        tooltip4.setStyle("-fx-background-color: #0fbcf9");
                       final Tooltip tooltip5= new Tooltip();
        tooltip5.setText("Mettre A Jour Le Tableau ");
        refresh1.setTooltip(tooltip5);
        tooltip5.setStyle("-fx-background-color: #0fbcf9");
                       final Tooltip tooltip6= new Tooltip();
        tooltip6.setText("Creer un blog ");
        create.setTooltip(tooltip6);
        tooltip6.setStyle("-fx-background-color: #0fbcf9");
                       final Tooltip tooltip7= new Tooltip();
        tooltip7.setText("Imprimer PDF ");
        pdf.setTooltip(tooltip7);
        tooltip7.setStyle("-fx-background-color: #0fbcf9");
        
        new BounceIn(status).play();
    
        LocalDate localDate = LocalDate.now();
        
    date1.setValue(localDate);
      blog.setItems(listdata.getBlog());
        
          user.setCellValueFactory(cell -> cell.
                getValue().getUserProperty().asObject()); 
        cat.setCellValueFactory(cell -> cell.
                getValue().getCatProperty());
        date.setCellValueFactory(cell -> cell.
                getValue().getDateProperty());
        contenu.setCellValueFactory(cell -> cell.
                getValue().getContenuProperty());
        titre.setCellValueFactory(cell -> cell.
                getValue().getTitreProperty());
        image.setCellValueFactory(cell -> cell.
                getValue().getImageProperty());
        
        
        
        
            blog.setOnMouseClicked(event->{
        id1.setText(String.valueOf(listdata.getBlog()
                .get(blog.getSelectionModel().getSelectedIndex())
              .getId()));
          user1.setText(String.valueOf(listdata.getBlog()
                .get(blog.getSelectionModel().getSelectedIndex())
              .getUser()));
       cat1.setText(listdata.getBlog()
                .get(blog.getSelectionModel().getSelectedIndex())
                .getCat());
              date1.setValue (LocalDate.parse(listdata.getBlog()
                .get(blog.getSelectionModel().getSelectedIndex())
                .getDate()));
          
              contenu1.setText(listdata.getBlog()
                .get(blog.getSelectionModel().getSelectedIndex())
                .getContenu());
                titre1.setText(listdata.getBlog()
                .get(blog.getSelectionModel().getSelectedIndex())
                .getTitre());
                  imapa1.setText(listdata.getBlog()
                .get(blog.getSelectionModel().getSelectedIndex())
                .getImage());
             
       
    });
  

         BlogDao pda=BlogDao.getInstance();

        
        blog2= (ObservableList<Blog>) pda.displayAll();
      
        FilteredList<Blog> filteredData = new FilteredList<>(blog2, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(blogE -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (blogE.getCat().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (blogE.getDate().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (blogE.getContenu().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                  else if (blogE.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                   else if (blogE.getImage().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
                                 else if (String.valueOf(blogE.getId()).indexOf(lowerCaseFilter)!=-1){
					return true; // Filter matches last name.
				}
				else if (String.valueOf(blogE.getUser()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
        
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Blog> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(blog.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		blog.setItems(sortedData);
        
                delete.setOnAction(event -> {
                    
             int x=    Integer.parseInt(id1.getText());
                BlogDao pdao = BlogDao.getInstance();
                  Blog p =          pdao.displayById(x);
                  pdao.delete(p);
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Delete  avec succés!");
        alert.show();
        
                });
                       update.setOnAction(event->{
                      int  x=    Integer.parseInt(id1.getText());

                        Blog p1 = new Blog(Integer.parseInt(user1.getText()), cat1.getText(),String.valueOf(date1.getValue()),contenu1.getText(), titre1.getText(),imapa1.getText(),Integer.parseInt(id1.getText()));

                     BlogDao pdao = BlogDao.getInstance();
                     pdao.update(p1);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Delete  avec succés!");
        alert.show();
        
                       });
    }    


    @FXML
    private void refresh(MouseEvent event) {
                try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/BlogFront.fxml"));
                Scene scene = new Scene(page1);
                
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();    

    stage.setFullScreen(true);
                stage.setScene(scene);

                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

 


    @FXML
    private void create(MouseEvent event) {
                 try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/Addblogf.fxml"));
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

    stage.setFullScreen(true);
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


    private void pdf(MouseEvent event) throws FileNotFoundException, Exception {
        File out = new File("Blog.pdf");
        FileOutputStream fos = new FileOutputStream(out);
        PDF pdf = new PDF(fos);
        Page page = new Page(pdf,A4.PORTRAIT);
        Font f1 = new Font(pdf,CoreFont.HELVETICA_BOLD);
        Font f2= new Font(pdf,CoreFont.HELVETICA);
        Table table = new Table();
        List<List<Cell>> tableData = new ArrayList<>();
        List<Cell> tableRow = new ArrayList<>();
        
        Cell cell = new Cell(f1,id.getText());
        tableRow.add(cell);
          cell  = new Cell(f1,user.getText());
        tableRow.add(cell);
          cell  = new Cell(f1,cat.getText());
        tableRow.add(cell);
           cell = new Cell(f1,date.getText());
        tableRow.add(cell);
           cell = new Cell(f1,contenu.getText());
        tableRow.add(cell);
           cell = new Cell(f1,titre.getText());
        tableRow.add(cell);
           cell = new Cell(f1,image.getText());
        tableRow.add(cell);
        tableData.add(tableRow);
        List<Blog>items = blog.getItems();
        for(Blog bl:items)
        {
            Cell id = new Cell(f2,String.valueOf(bl.getId()));
            Cell user =new Cell(f2,String.valueOf(bl.getUser()));
            Cell cat = new Cell(f2,bl.getCat());
            Cell date = new Cell(f2,bl.getDate());
            Cell contenu = new Cell(f2,bl.getContenu());
            Cell titre = new Cell(f2,bl.getTitre());
            Cell image = new Cell (f2,bl.getImage());
            tableRow = new ArrayList<Cell>();
            tableRow.add(id);
                 tableRow.add(user);
                      tableRow.add(cat);
                           tableRow.add(date);
                                tableRow.add(contenu);
 tableRow.add(titre);
 tableRow.add(image);
         tableData.add(tableRow);

        } 
        table.setData(tableData);

 table.setPosition(30f,90f );
 table.setColumnWidth(0, 70f);
 table.setColumnWidth(1, 70f);
  table.setColumnWidth(2, 100f);
   table.setColumnWidth(3, 70f);
    table.setColumnWidth(4, 70f);
     table.setColumnWidth(5, 70f);
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
    private void attach(MouseEvent event) {
               JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                imapa1.setText(imagepath);
      
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

    private void fullb(MouseEvent event) {
            Stage stage = (Stage) full.getScene().getWindow();
       stage.setFullScreen(true);
    }




    
}
