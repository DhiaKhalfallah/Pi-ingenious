/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;
import art_comm.Controllers.ListBlogController;
import java.util.Locale;

import art_comm.Dao.BlogDao;
import art_comm.Dao.CommentaireDao;
import art_comm.Entities.Blog;
import art_comm.Entities.Commentaire;

import com.jfoenix.controls.JFXButton;
import com.pi.Entities.Candidate;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class Itemblog2Controller implements Initializable {

    private Text blogtitre;
    private Text date;
    private Label nbr;
    private Label idblog;
    @FXML
    private Label userc;
    @FXML
    private Label datec;
    @FXML
    private Label commentairec;
    @FXML
    private Rating ratec;
    @FXML
    private Label idComm;
    private JFXButton translate;
    @FXML
    private Label idc;
    private JFXButton editC;
    @FXML
    private JFXButton deletec;
               private Candidate user;     

public void setData(Commentaire comm,Candidate c) throws IOException
{
    if (comm.getUser()!=c.getId())
    {
        deletec.setDisable(true);
    }
    else
    {
    user =c;
     int tel1= comm.getId();
        Integer tell = new Integer(tel1);
        String id = tell.toString();
       int tel12= comm.getUser();
        Integer tell2 = new Integer(tel12);
        String nbr2 = tell2.toString();
idc.setText(id);
    commentairec.setText(comm.getCommentaire());
     datec.setText(comm.getDate());
     userc.setText(nbr2);
    ratec.setRating(comm.getRate());
    ratec.setDisable(true);
 
             deletec.setOnAction(event -> {
                     Alert alert =new Alert(Alert.AlertType.WARNING);
                            alert.setContentText("his is the content of the  warning");
                            alert.setTitle("Clear all fields");
                            alert.setHeaderText("Are you sure you want to delete this item");
                            ButtonType cancelButtonType = new ButtonType("cancel",ButtonBar.ButtonData.CANCEL_CLOSE);
          alert.getDialogPane().getButtonTypes().add(cancelButtonType);
          Optional<ButtonType> result=alert.showAndWait();
          if (result.isPresent() && result.get()==ButtonType.OK)
                               {
             int x=    Integer.parseInt(idc.getText());
                CommentaireDao pdao = CommentaireDao.getInstance();
                  Commentaire p =          pdao.displayById(x);
                  pdao.delete(p);
                        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information Dialog");
        alert2.setHeaderText(null);
        alert2.setContentText("Delete  avec succés!");
        alert2.show();
                
                        }
          
                        
          });
    
    }
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
           

    }    


    @FXML
    private void deletecbt(MouseEvent event) {
                  
    }


}