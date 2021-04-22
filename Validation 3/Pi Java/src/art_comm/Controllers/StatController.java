/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import art_comm.Dao.BlogDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class StatController implements Initializable {
    private ObservableList<PieChart.Data> pcData;

    @FXML
    private PieChart chart;
    @FXML
    private Button back;
    @FXML
    private Label caption;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
             // TODO
                BlogDao pdao = BlogDao.getInstance();
        ObservableList<PieChart.Data> pieChartData
                = /* FXCollections.observableArrayList(
            new PieChart.Data("fff", 60),
            new PieChart.Data("Ense", 25),
            new PieChart.Data("Fails", 15));
 Chart.setData(pieChartData);*/ pcData = FXCollections.observableArrayList();
     int nbrjanvier=pdao.displayjanvier();
      int nbrfevrier=pdao.displayfevrier();
       int nbrmars=pdao.displaymars();
        int nbravril=pdao.displayavril();
         int nbrmai=pdao.displaymai();
          int nbrjuin=pdao.displayjuin();
           int nbrjuillet=pdao.displayjuillet();
            int nbraout=pdao.displayaout();
             int nbrseptembre=pdao.displayseptember();
              int nbroctober=pdao.displayoctobre();
               int nbrnovembre=pdao.displaynovembre();
                int nbrdecember=pdao.displaydecembre();
       
        pcData.add(new PieChart.Data("janvier", nbrjanvier));
        pcData.add(new PieChart.Data("fevrier", nbrfevrier));
                pcData.add(new PieChart.Data("mars", nbrmars));
                pcData.add(new PieChart.Data("avril", nbravril));
                pcData.add(new PieChart.Data("mail", nbrmai));
                                pcData.add(new PieChart.Data("juin", nbrjuin));
                                                pcData.add(new PieChart.Data("juillet", nbrjuillet));
                                                          pcData.add(new PieChart.Data("aout", nbraout));
                pcData.add(new PieChart.Data("september", nbrseptembre));

                                pcData.add(new PieChart.Data("october", nbroctober));

                                                pcData.add(new PieChart.Data("november", nbrnovembre));

                                                                pcData.add(new PieChart.Data("december", nbrdecember));



                
                


        chart.setData(pcData);
        chart.setTitle("Categorie des Date / Blog");
        pcData.stream().forEach(pieData -> {
            System.out.println(pieData.getName() + ": "
                    + pieData.getPieValue());
        });

        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    caption.setTranslateX(e.getSceneX());
                    caption.setTranslateY(e.getSceneY());
                    caption.setText(String.valueOf(data.getPieValue()) );
                }
            });
        }

        pcData.stream().forEach(pieData -> {
            pieData.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                Bounds b1 = pieData.getNode().getBoundsInLocal();
                double newX = (b1.getWidth()) / 2 + b1.getMinX();
                double newY = (b1.getHeight()) / 2 + b1.getMinY();
                // Make sure pie wedge location is reset
                pieData.getNode().setTranslateX(0);
                pieData.getNode().setTranslateY(0);
                TranslateTransition tt = new TranslateTransition(
                        Duration.millis(1500), pieData.getNode());
                tt.setByX(newX);
                tt.setByY(newY);
                tt.setAutoReverse(true);
                tt.setCycleCount(2);
                tt.play();
            });
        });
      


        
        
    }    

    @FXML
    private void back(MouseEvent event) {
           try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/FXMLDocument.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(StatController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
