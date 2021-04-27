/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ListeCandidatController implements Initializable {

    @FXML
    private TableView<?> CanTable;
    @FXML
    private TableColumn<?, ?> idC;
    @FXML
    private TableColumn<?, ?> nomC;
    @FXML
    private TableColumn<?, ?> prenomC;
    @FXML
    private TableColumn<?, ?> telC;
    @FXML
    private TableColumn<?, ?> paysC;
    @FXML
    private TableColumn<?, ?> govC;
    @FXML
    private TableColumn<?, ?> adresseC;
    @FXML
    private TableColumn<?, ?> cpC;
    @FXML
    private TableColumn<?, ?> bdC;
    @FXML
    private TableColumn<?, ?> ppC;
    @FXML
    private TableColumn<?, ?> cvC;
    @FXML
    private TableColumn<?, ?> AboutC;
    @FXML
    private Button refresh;
    @FXML
    private Button update;
    @FXML
    private Button delete;
    @FXML
    private TextField search;
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
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void redirectBack(MouseEvent event) {
    }

    @FXML
    private void refresh(MouseEvent event) {
    }

    @FXML
    private void attachPic(MouseEvent event) {
    }

    @FXML
    private void attachCv(MouseEvent event) {
    }
    
}
