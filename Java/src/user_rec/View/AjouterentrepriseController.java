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
import user_rec.Dao.EntrepriseDao;
import user_rec.Entities.Entreprise;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class AjouterentrepriseController implements Initializable {

    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPassword;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfTel;
    @FXML
    private TextField tfSiteweb;
    @FXML
    private TextField tfTwitter;
    @FXML
    private TextField tfLinkedin;
    @FXML
    private TextField tfFacebook;
    @FXML
    private TextField tfPic;
    @FXML
    private TextArea tfAbout;

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
                Logger.getLogger(AjouterentrepriseController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void addEntreprise(MouseEvent event) {
        
        String email= tfEmail.getText() ; 
        String password= tfPassword.getText() ; 
        String nom= tfNom.getText() ; 
        String adresse= tfAdresse.getText() ; 
        String pic= tfPic.getText() ; 
        String about= tfAbout.getText() ; 
        String siteweb= tfSiteweb.getText() ;
        String twitter= tfTwitter.getText() ;
        String facebook= tfFacebook.getText() ;
        String linkedin= tfLinkedin.getText() ;
        String role="[\"ROLE_ENTREPRISE\"]" ; 
        String typeC="entreprise" ; 
        String vertoken="Active" ; 
        String passchange="none" ; 
        int tel= Integer.parseInt(tfTel.getText()) ; 
        int type=1 ; 
        int status=0 ;
  
        Entreprise e = new Entreprise(nom,about,adresse,siteweb,twitter,linkedin,facebook,pic,tel,email,password,type,role,typeC,status,vertoken,passchange);
        EntrepriseDao entr = new EntrepriseDao();
        entr.insert(e);
    }
    
}
