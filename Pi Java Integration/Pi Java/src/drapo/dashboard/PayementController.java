/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import art_comm.Dao.Formation_Services;
import com.jfoenix.controls.JFXButton;
import eventcrud.Entities.Formation;
import art_comm.Utils.MyConnection;
import javafx.scene.image.Image;

import eventcrud.Entities.Payment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


/**
 * FXML Controller class
 *
 * @author MSF_Nabeul
 */
public class PayementController implements Initializable {
    Stage dialogStage = new Stage();
    Scene scene;
    @FXML
    private TextField usermail;
    @FXML
    private TextField montant;
    @FXML
    private TextField First;
    @FXML
    private TextField Last;
    @FXML
    private TextField Number;
    @FXML
    private TextField Card;
    @FXML
    private TextField CVC;
    @FXML
    private JFXButton dashboard;
    @FXML
    private Pane pn_checkApp;
    @FXML
    private Pane pn_BrowseComp;
    @FXML
    private Pane pn_MyProfile;
    @FXML
    private Pane pn_BrowseCan;
    @FXML
    private Pane pn_BrowseWorkShops;
    @FXML
    private Pane pn_SendClaim;
    @FXML
    private Pane pn_BrowseClaims;
    @FXML
    private Pane pn_browsejobs;
    @FXML
    private Pane pn_Home;
    @FXML
    private Pane pn_Blog;
    @FXML
    private Pane pn_EnProfile;
    @FXML
    private Pane pn_AddJob;
    @FXML
    private Pane pn_BorwseInt;
    @FXML
    private JFXButton Pay;
    @FXML
    private VBox vbox_2;
    @FXML
    private VBox vbox_1;



    /**
     * Initializes the controller class.
     */
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MyConnection myConnection = MyConnection.getInstance ();
        Formation_Services cartServices =new Formation_Services ();
        List<Formation> LastOrder= new ArrayList();
        try {
            LastOrder = cartServices.read();
        } catch (SQLException ex) {
            Logger.getLogger(PayementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        usermail.setText ("joejoe@gmail.com");
        montant.setText (String.valueOf (((int) LastOrder.get (0).getPrix())));
        First.setText ("user01");
        Last.setText ("user02");
        Number.setText (String.valueOf (25963741));
        Card.setText ("**** **** **** 5556");
        CVC.setText ("101");


    }

    public void payerService(ActionEvent event) throws IOException {


        ExecutorService emailExecutor = Executors.newSingleThreadExecutor();
        emailExecutor.execute(new Runnable() {
            @Override
            public void run() {
                Payment P=new Payment();

                P.RetrieveCustomer ();
                Integer Dueamount = Integer.parseInt(montant.getText());
                P.payement (Dueamount);

                try {
                    Desktop.getDesktop().browse(new URL("https://dashboard.stripe.com/test/customers/cus_JDqwZqbdKtrxes?fbclid=IwAR0Qq32Mve6E-ETXw1HRGN8U35vckgJQz4-Sq11Ht5Xw2-Egv-ebZwNLq6Y").toURI());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
        emailExecutor.shutdown();
        Node source = (Node) event.getSource();
        dialogStage = (Stage) source.getScene().getWindow();
        dialogStage.close();
        scene = new Scene (FXMLLoader.load(getClass().getResource("/com/pi/views/Home.fxml")));
        
        dialogStage.setScene(scene);

        String title = "Payement succesful";
        String message = "You payment  has been Approved";

        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.setNotificationType(NotificationType.SUCCESS);
        tray.showAndDismiss (Duration.millis (3200));

        dialogStage.show();
               
    }

    @FXML
    private void logout(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void dashboardbt(MouseEvent event) {
    }

  

    @FXML
    private void blog(MouseEvent event) {
    }

    @FXML
    private void ProfileEn(MouseEvent event) {
    }

    @FXML
    private void AddJob(MouseEvent event) {
    }

    @FXML
    private void BrowseIn(MouseEvent event) {
    }

    @FXML
    private void BrowseOff(MouseEvent event) {
    }

    @FXML
    private void previouspage(MouseEvent event) {
    }

    @FXML
    private void browsejobs(MouseEvent event) {
    }

    @FXML
    private void CheckApp(MouseEvent event) {
    }

    @FXML
    private void BrowseComp(MouseEvent event) {
    }

    @FXML
    private void Profile(MouseEvent event) {
    }

    @FXML
    private void BrowseCan(MouseEvent event) {
    }

    @FXML
    private void BrowseEvent(MouseEvent event) {
    }

    @FXML
    private void BrowseWorkShop(MouseEvent event) {
    }

    @FXML
    private void SendClaim(MouseEvent event) {
    }

    @FXML
    private void CheckCLaim(MouseEvent event) {
    }

    @FXML
    private void nextpage(MouseEvent event) {
    }

}


