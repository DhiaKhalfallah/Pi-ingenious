/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.View;

import java.io.File;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFileChooser;
import user_rec.Dao.CandidateDao;
import user_rec.Entities.Candidate;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class AjoutercandidatController implements Initializable {

    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfPassword;
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
    private TextField tfPic;
    @FXML
    private TextField tfCV;
    @FXML
    private TextArea tfAboutyou;
    @FXML
    private DatePicker tfBday;

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
                Logger.getLogger(AjoutercandidatController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void addCan(MouseEvent event) {
        
        String email= tfEmail.getText() ; 
        String password= tfPassword.getText() ; 
        String nom= tfNom.getText() ; 
        String prenom= tfPrenom.getText() ; 
        String pays= TfPays.getText() ; 
        String gouvernorat= tfGouvernorat.getText(); 
        String adresse= tfAdresse.getText() ; 
        String birthday= String.valueOf(tfBday.getValue()) ; 
        String pic= tfPic.getText() ; 
        String cv= tfCV.getText() ; 
        String about= tfAboutyou.getText() ; 
        String role="[\"ROLE_CANDIDATE\"]" ; 
        String typeC="candidate" ; 
        String vertoken="Active" ; 
        String passchange="none" ; 
        int tel= Integer.parseInt(tfTel.getText()) ; 
        int codep= Integer.parseInt(tfCodePostal.getText()) ; 
        int type=0 ; 
        int status=0 ;
  
        Candidate c= new  Candidate(nom,prenom,pays,gouvernorat,adresse,birthday,pic,cv,about,tel,codep,email,password,type,role,typeC,status,vertoken,passchange);
        
        CandidateDao can= new CandidateDao() ;
        can.insert(c);
        
    }

    @FXML
    private void attachPic(MouseEvent event) {
        
          JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                tfPic.setText(imagepath);
                        }
        
    }

    @FXML
    private void attachCv(MouseEvent event) {
          JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File(".")); //sets current directory
			
			int response = fileChooser.showOpenDialog(null); //select file to open
			//int response = fileChooser.showSaveDialog(null); //select file to save
			
			if(response == JFileChooser.APPROVE_OPTION) {
				File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                                String imagepath= file.getAbsolutePath();
                                tfCV.setText(imagepath);}
    }
    
}
