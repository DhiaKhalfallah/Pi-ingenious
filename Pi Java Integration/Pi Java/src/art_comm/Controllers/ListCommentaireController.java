/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import art_comm.Dao.BlogDao;
import art_comm.Dao.CommentaireDao;
import art_comm.Entities.Blog;
import art_comm.Entities.Commentaire;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class ListCommentaireController implements Initializable {
       private ListData listdata = new ListData();

          private ObservableList<Commentaire> commentaire2=FXCollections.observableArrayList();
          Commentaire Commentaire;
              private ObservableList<Commentaire> commentaireup=FXCollections.observableArrayList();

                  private ObservableList<Commentaire> commentairedown=FXCollections.observableArrayList();
@FXML
    private TableColumn<Commentaire, Integer> id;
    @FXML
    private TableColumn<Commentaire, Integer> user;
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
    private TableColumn<Commentaire,Integer> rate;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private Button add;
    @FXML
    private Button refresh;
    @FXML
    private Button pdf;
    @FXML
    private TextField search;
    @FXML
    private Button sms;
    @FXML
    private TableView<Commentaire> commTable;
    @FXML
    private TextField idl;
    @FXML
    private TextField userl;
    @FXML
    private TextField noml;
    @FXML
    private TextField maill;
    @FXML
    private TextField subjectl;
    @FXML
    private TextField mobilel;
    @FXML
    private TextField ratel;
    @FXML
    private DatePicker datel;
    @FXML
    private TextArea commentairel;
    @FXML
    private TextField blog_idl;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
            commTable.setOnMouseClicked(event->{
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
              ratel.setText(String.valueOf((listdata.getComm()
                .get(commTable.getSelectionModel().getSelectedIndex())
                .getRate())));
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
        
                delete.setOnAction(event -> {
                    
             int x=    Integer.parseInt(idl.getText());
                CommentaireDao pdao = CommentaireDao.getInstance();
                  Commentaire p =          pdao.displayById(x);
                  pdao.delete(p);
          
                });
                     update.setOnAction(event->{
                      int  x=    Integer.parseInt(idl.getText());

                        Commentaire p1 = new Commentaire(Integer.parseInt(userl.getText()), noml.getText(),maill.getText(),subjectl.getText(),Integer.parseInt(mobilel.getText()),commentaire.getText(),String.valueOf(datel.getValue()),Integer.parseInt(blog_idl.getText()),Integer.parseInt(ratel.getText()),Integer.parseInt(idl.getText()));

                     CommentaireDao pdao = CommentaireDao.getInstance();
                     pdao.update(p1);
                       });
    
         // TODO
    }    

    @FXML
    private void update(MouseEvent event) {
    }

    @FXML
    private void delete(MouseEvent event) {
        
    }

    @FXML
    private void add(MouseEvent event) {
              try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/AddCommentaire.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void refresh(MouseEvent event) {
             try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/ListCommentaire.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        
    }


    @FXML
    private void sms(MouseEvent event) {
          try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/sendsms.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    @FXML
    private void triUp(ActionEvent event) {
                 CommentaireDao pdao=CommentaireDao.getInstance();
        commentaireup= (ObservableList<Commentaire>) pdao.displayAllup();
        		commTable.setItems(commentaireup);
    }

    @FXML
    private void triDown(ActionEvent event) {
                        CommentaireDao pdao=CommentaireDao.getInstance();
        commentairedown= (ObservableList<Commentaire>) pdao.displayAllDown();
        		commTable.setItems(commentairedown);
    }
    
}
