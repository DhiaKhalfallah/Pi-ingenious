/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;


import com.codename1.ext.filechooser.FileChooser;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.List;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.jobby.entities.CategorieOffre;
import com.jobby.entities.Offre;
import com.jobby.services.CategorieCrud;
import com.jobby.services.OffreCrud;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;



/**
 *
 * @author RE flex
 */
public class AddOffreForm extends Form{
     protected String saveFileToDevice(String hi, String ext) throws IOException {
        URI uri;
        try {
            uri = new URI(hi);
            String path = uri.getPath();
            int index = hi.lastIndexOf("/");
            hi = hi.substring(index + 1);
            return hi;
        } catch (URISyntaxException ex) {
        }
        return "hh";
    }
      
     
    public AddOffreForm(Resources res) {
        
        /*
        Le paramètre previous définit l'interface(Form) précédente.
        Quelque soit l'interface faisant appel à AddTask, on peut y revenir
        en utilisant le bouton back
        */
        setTitle("Add a new offre");
        setLayout(BoxLayout.y());
        
        TextField tfNom = new TextField("","offreNom");
        TextField tfEmail = new TextField("","OffreEmail");
        TextField tfTitle = new TextField("","OffreTitle");
        TextField tfDescription = new TextField("","OffreDescripton");
                TextField log = new TextField("","logo");

        Button btnValider = new Button("Add Offre");
         ArrayList<CategorieOffre> liste = CategorieCrud.getInstance().getAllCats();
        ComboBox getCategoryComboBox = new ComboBox();
        ComboBox getCatInt = new ComboBox();
        getCategoryComboBox.setUIID("TextField");
        getCategoryComboBox.addItem("Choose Category");
        getCatInt.setUIID("TextField");
        setLayout(BoxLayout.y());
        for (CategorieOffre c : liste) {
            getCategoryComboBox.addItem(c.getNom());

        }
        getCategoryComboBox.addActionListener(e1 -> {
            System.out.println(getCategoryComboBox.getSelectedItem().toString());
        });
      
        
           CheckBox multiSelect = new CheckBox ("Multi-select");
    Button img1 = new Button ("choissir une image ");
    img1.addActionListener((ActionEvent e) -> {
            if (FileChooser.isAvailable()) {
               //FileChooser.SetOpenFilesInPlace(true);
                FileChooser.showOpenDialog(multiSelect.isSelected(), ".jpg, .jpeg, .png/plain", (ActionEvent e2) -> {
                    if (e2 == null || e2.getSource() == null) {
                        add("No file was selected");
                        revalidate();
                        return;
                    }
                    if (multiSelect.isSelected()) {
                        String[] paths = (String[]) e2.getSource();
                        for (String path : paths) {
                            System.out.println(path);
                            CN.execute(path);
                        }
                        return;
                    }

                    String file = (String) e2.getSource();
                    if (file == null) {
                        add("No file was selected");
                        revalidate();
                    } else {
                        Image logo;

                        try {
                            logo = Image.createImage(file).scaledHeight(500);;
                            add(logo);
                            String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "photo.png";

                            try (OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
                                System.out.println(imageFile);
                                ImageIO.getImageIO().save(logo, os, ImageIO.FORMAT_PNG, 1);
                            } catch (IOException err) {
                            }
                        } catch (IOException ex) {
                        }

                        String extension = null;
                        if (file.lastIndexOf(".") > 0) {
                            extension = file.substring(file.lastIndexOf(".") + 1);
                            StringBuilder hi = new StringBuilder(file);
                            if (file.startsWith("file://")) {
                                hi.delete(0, 7);
                            }
                            int lastIndexPeriod = hi.toString().lastIndexOf(".");
                            String ext = hi.toString().substring(lastIndexPeriod);
                            String hmore = hi.toString().substring(0, lastIndexPeriod - 1);
                            try {
                                
                                String namePic = saveFileToDevice(file, ext);
                                System.out.println(namePic);
                                 btnValider.addActionListener(new ActionListener() {

                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        if ((tfNom.getText().length() == 0) || (tfTitle.getText().length() == 0) || (tfEmail.getText().length() == 0) || (tfDescription.getText().length() == 0) || (getCategoryComboBox.getSelectedItem().toString().length() == 0)) {
                                        
                                        try {
                                                String test = getCategoryComboBox.getSelectedItem().toString();
                                                ArrayList<CategorieOffre> Exemple = CategorieCrud.getInstance().getCat(test);
                                                for (CategorieOffre cc : Exemple) {
                                                    Offre o = new Offre(cc.getId(),tfNom.getText(), tfEmail.getText(), namePic, tfTitle.getText(), tfDescription.getText());
                                                      if (OffreCrud.getInstance().addOffre(o)) {
                                                        System.out.println("hhw");
                                                      }
                                                      else
                                                          System.out.println("erreur");
                                                } 
                                        }catch (NumberFormatException e) {
                                                Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                                            }

                                        }

                                    }

                                    //new ListOffres(res).show();
                                });
                            } catch (IOException ex) {
                            }

                            revalidate();
                            
                            
                        }
                    }
                });
            } else {
            }
            });
    addAll(getCategoryComboBox,tfNom,tfEmail,tfTitle,tfDescription,img1,btnValider);
  
    
        
    }

  
}
