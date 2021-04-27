/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import animatefx.animation.BounceIn;
import art_comm.Dao.EventDao;
import art_comm.Entities.Event;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class AddEventBController implements Initializable {

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
    private Button backfont;
    @FXML
    private TextField search;
    @FXML
    private Button View;
    @FXML
    private JFXButton attach;
    @FXML
    private JFXButton add;
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
    private HBox parti;
    @FXML
    private HBox userb;
    @FXML
    private HBox events;
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
            new BounceIn(status).play();               LocalDate localDate = LocalDate.now();
    datel.setValue(localDate);

    datefinl.setValue(localDate);
         add.setOnAction(event -> {
              
Event p1 = new Event(Integer.parseInt(lieul.getText()),Integer.parseInt(entreprise_idl.getText()),Integer.parseInt(nbrl.getText()),Integer.parseInt(par_idl.getText()),Integer.parseInt(ent_idl.getText()),String.valueOf(datel.getValue()),descriptionl.getText(),noml.getText(),imagel.getText(),categoriel.getText(),String.valueOf(datefinl.getValue()),null,null,null);
                     EventDao pdao = EventDao.getInstance();
                  
                     pdao.insert(p1);
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText(null);
                        alert.setContentText("Event insérée avec succés!");
                        alert.show();
                        
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

    private void reviews(MouseEvent event) {
                      try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/CommentaireFront.fxml"));
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
                Logger.getLogger(AddEventBController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void backfontaw(MouseEvent event) {
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
    private void view(MouseEvent event) {
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

    @FXML
    private void add(MouseEvent event) {
         if(lieul.getText().length()==0)
        {
            lieul.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(lieul).play();
        }
        else
            lieul.setStyle(null);
         if(entreprise_idl.getText().length()==0)
        {
            entreprise_idl.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(entreprise_idl).play();
        }
        else
            entreprise_idl.setStyle(null);
          if(nbrl.getText().length()==0)
        {
            nbrl.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(nbrl).play();
        }
        else
            nbrl.setStyle(null);
           if(par_idl.getText().length()==0)
        {
            par_idl.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(par_idl).play();
        }
        else
            par_idl.setStyle(null);
            if(ent_idl.getText().length()==0)
        {
            ent_idl.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(ent_idl).play();
        }
        else
            descriptionl.setStyle(null);
                        if(descriptionl.getText().length()==0)
        {
            descriptionl.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(descriptionl).play();
        }
        else
            descriptionl.setStyle(null);
                                    if(noml.getText().length()==0)
        {
            noml.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(noml).play();
        }
        else
            noml.setStyle(null);
                                                if(categoriel.getText().length()==0)
        {
            categoriel.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(categoriel).play();
        }
        else
            categoriel.setStyle(null);
                                                            if(imagel.getText().length()==0)
        {
            imagel.setStyle("-fx-border-color:red;-fx-border-width:2px ;");
            
           new animatefx.animation.Shake(imagel).play();
        }
        else
            imagel.setStyle(null);
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
    private void reviewsbt(MouseEvent event) {
                        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/CommentaireFront.fxml"));
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
