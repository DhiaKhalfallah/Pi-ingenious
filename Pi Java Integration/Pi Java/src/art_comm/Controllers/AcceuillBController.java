/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package art_comm.Controllers;

import animatefx.animation.BounceIn;
import art_comm.Dao.BlogDao;
import art_comm.Dao.EventDao;
import art_comm.Views.ListeCandidatController;
import art_comm.Views.ListeRecController;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class AcceuillBController implements Initializable {
    private ObservableList<PieChart.Data> pcData;
    private ObservableList<PieChart.Data> pcData1;

    @FXML
    private BorderPane root;
    @FXML
    private Text back;
    @FXML
    private HBox dashboard;
    @FXML
    private HBox reviews;
    @FXML
    private VBox rootpB;
    @FXML
    private Pane status;
    @FXML
    private Button back3;
    @FXML
    private TextField search;
    @FXML
    private PieChart chart;
    @FXML
    private Label caption;
    @FXML
    private HBox blogd;
    @FXML
    private HBox sms;
    @FXML
    private Button full;
    @FXML
    private FontAwesomeIcon back2;
    @FXML
    private HBox events;
    @FXML
    private HBox userb;
    @FXML
    private HBox btncategorie;
    @FXML
    private HBox btnoffre;
    @FXML
    private HBox reclamab;
    @FXML
    private HBox parti;
    @FXML
    private PieChart chart1;
    @FXML
    private Label caption1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            new BounceIn(status).play();
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
        // TODO
          EventDao pdao1 = EventDao.getInstance();
        ObservableList<PieChart.Data> pieChartData1
                = /* FXCollections.observableArrayList(
            new PieChart.Data("fff", 60),
            new PieChart.Data("Ense", 25),
            new PieChart.Data("Fails", 15));
 Chart.setData(pieChartData);*/ pcData1 = FXCollections.observableArrayList();
     int nbrjanvier1=pdao1.displayjanvier();
      int nbrfevrier1=pdao1.displayfevrier();
       int nbrmars1=pdao1.displaymars();
        int nbravril1=pdao1.displayavril();
         int nbrmai1=pdao1.displaymai();
          int nbrjuin1=pdao1.displayjuin();
           int nbrjuillet1=pdao1.displayjuillet();
            int nbraout1=pdao1.displayaout();
             int nbrseptembre1=pdao1.displayseptember();
              int nbroctober1=pdao1.displayoctobre();
               int nbrnovembre1=pdao1.displaynovembre();
                int nbrdecember1=pdao1.displaydecembre();
       
        pcData1.add(new PieChart.Data("janvier", nbrjanvier1));
        pcData1.add(new PieChart.Data("fevrier", nbrfevrier1));
                pcData1.add(new PieChart.Data("mars", nbrmars1));
                pcData1.add(new PieChart.Data("avril", nbravril1));
                pcData1.add(new PieChart.Data("mail", nbrmai1));
                                pcData1.add(new PieChart.Data("juin", nbrjuin1));
                                                pcData1.add(new PieChart.Data("juillet", nbrjuillet1));
                                                          pcData1.add(new PieChart.Data("aout", nbraout1));
                pcData1.add(new PieChart.Data("september", nbrseptembre1));

                                pcData1.add(new PieChart.Data("october", nbroctober1));

                                                pcData1.add(new PieChart.Data("november", nbrnovembre1));

                                                                pcData1.add(new PieChart.Data("december", nbrdecember1));



                
                


        chart1.setData(pcData1);
        chart1.setTitle("Categorie des Participant / Date");
        pcData1.stream().forEach(pieData -> {
            System.out.println(pieData.getName() + ": "
                    + pieData.getPieValue());
        });

        for (final PieChart.Data data1 : chart1.getData()) {
            data1.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    caption1.setTranslateX(e.getSceneX());
                    caption1.setTranslateY(e.getSceneY());
                    caption1.setText(String.valueOf(data1.getPieValue()) );
                }
            });
        }

        pcData1.stream().forEach(pieData1 -> {
            pieData1.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                Bounds b1 = pieData1.getNode().getBoundsInLocal();
                double newX = (b1.getWidth()) / 2 + b1.getMinX();
                double newY = (b1.getHeight()) / 2 + b1.getMinY();
                // Make sure pie wedge location is reset
                pieData1.getNode().setTranslateX(0);
                pieData1.getNode().setTranslateY(0);
                TranslateTransition tt = new TranslateTransition(
                        Duration.millis(1500), pieData1.getNode());
                tt.setByX(newX);
                tt.setByY(newY);
                tt.setAutoReverse(true);
                tt.setCycleCount(2);
                tt.play();
            });
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
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
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

    @FXML
    private void fullb(MouseEvent event) {
            Stage stage = (Stage) full.getScene().getWindow();
       stage.setFullScreen(true);
    }

    private void userscene(MouseEvent event) {
            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/listeC.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListeCandidatController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void openrec(MouseEvent event) {
        try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/ListeRec.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListeRecController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void eventsbt(MouseEvent event) {
         try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/EventBackend.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListeRecController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

 

    private void partibt2(MouseEvent event) {
                      try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/partiB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void partibt3(MouseEvent event) {
                      try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/partiB.fxml"));
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
    private void partibt(MouseEvent event) {
                  try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/art_comm/Views/partiB.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        

        stage.setMaximized(true);
                stage.setScene(scene);
      
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(ListBlogController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    }
    

