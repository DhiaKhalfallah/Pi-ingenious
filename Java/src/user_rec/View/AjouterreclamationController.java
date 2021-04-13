/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.View;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Locale;  
import user_rec.Dao.ReclamationDao;
import user_rec.Entities.Reclamation;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class AjouterreclamationController implements Initializable {

    @FXML
    private TextField tfuser;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfSubject;
    @FXML
    private TextArea tfclaim;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
                Logger.getLogger(AjouterreclamationController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void addClaim(MouseEvent event) {
        
        int user_id=Integer.parseInt(tfuser.getText()) ;
        int status=1;
        String user_email=tfemail.getText();
        String subject=tfSubject.getText();
        String claim=tfclaim.getText();
        Date date = new Date();  
        SimpleDateFormat  formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");  
        String Submit = formatter.format(date);  
        
        Reclamation r = new Reclamation(user_id,status,user_email,subject,claim,Submit);
        ReclamationDao rec= new ReclamationDao();
        rec.insert(r);
        
        
        
        
    }
    
}
