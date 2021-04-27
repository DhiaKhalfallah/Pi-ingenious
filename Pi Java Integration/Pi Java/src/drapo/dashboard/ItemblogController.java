/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drapo.dashboard;

import art_comm.Controllers.ListBlogController;
import art_comm.Dao.BlogDao;
import art_comm.Entities.Blog;
import art_comm.Entities.Commentaire;
import com.jfoenix.controls.JFXButton;
import com.pi.Entities.Candidate;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author LEGION
 */
public class ItemblogController implements Initializable {

    @FXML
    private Text blogtitre;
private Blog blog,blog2;
    private Text cat;
    @FXML
    private Text date;
    MouseEvent event;
    @FXML
    private Label idblog;
    @FXML
    private Label nbr;
    @FXML
    private Rating ratingb;
    private Candidate user;
    @FXML
    private HBox ratingB1;
    @FXML
    private ImageView img;
    @FXML
    private JFXButton view;
    
public void setData(Blog blog,Candidate c) throws IOException
{
    
     int tel1= blog.getId();
        Integer tell = new Integer(tel1);
        String id = tell.toString();
       int tel12= blog.getNbr();
        Integer tell2 = new Integer(tel12);
        String nbr2 = tell2.toString();
     user=c;
 idblog.setText(id);
    blogtitre.setText(blog.getTitre());
     date.setText(blog.getDate());
    nbr.setText(nbr2);
        BlogDao pdao = BlogDao.getInstance();
                  int  p =          pdao.rating(blog.getId());
    ratingb.setRating(p);
}
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }
    @FXML
    private void viewbt(MouseEvent event) throws IOException {   
  
           FXMLLoader fxmloader = new FXMLLoader();
    
         FXMLLoader loader= new FXMLLoader();
         loader.setLocation(getClass().getResource("/com/pi/views/blog_detail.fxml"));
         Parent page1 =loader.load();
                    Scene scene = new Scene(page1,1280,720);

                Blog_detailController blogD =loader.getController();
   
          blogD.initData(Integer.parseInt(idblog.getText()),user);

                BlogDao pdao = BlogDao.getInstance();
                  Blog blog =          pdao.displayById(Integer.parseInt(idblog.getText()));
                  
                  
                 int y= blog.getNbr();
                 blog.setNbr(y+1);
          
 pdao.updateR(blog);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();        
      
        stage.setScene(scene);
        stage.setTitle("Jooby");
        stage.show();
    

    }

     
}
