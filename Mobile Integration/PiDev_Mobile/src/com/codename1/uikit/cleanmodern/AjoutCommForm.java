/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.jobby.entities.Blog;
import com.jobby.entities.Commentaire;
import com.jobby.services.serviceBlog;
import com.codename1.components.ToastBar;
import com.codename1.components.ToastBar.Status;
import static com.codename1.ui.layouts.mig.LinkHandler.HEIGHT;
/**
 *
 * @author LEGION
 */
public class AjoutCommForm extends BaseForm {
    Form current;
    public AjoutCommForm(Resources res)
    {
        super ("Newsfeed",BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Commentaire");
        getContentPane().setScrollVisible(false);
                        super.addSideMenu(res);

        tb.addSearchCommand(e -> {
            
        });
        Tabs swipe = new Tabs();
        Label s1 = new Label();
        Label s2= new Label();
        addTab(swipe,s1, res.getImage("back-logo.jpeg"),"","",res);
        
        
        
          swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Blogs", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("Autres", barGroup);
        liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("Stats", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
        //  ListReclamationForm a = new ListReclamationForm(res);
          //  a.show();
            refreshTheme();
            
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes, liste, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

     TextField nom = new TextField ("","Enter A nom !!");
        nom.setUIID("textFieldBlack");
        addStringValue("nom",nom);
              TextField subject = new TextField ("","Enter A subject !!");
        subject.setUIID("textFieldBlack");
        addStringValue("subject",subject);
              TextField commentaire = new TextField ("","Enter A commentaire !!");
        commentaire.setUIID("textFieldBlack");
        addStringValue("commentaire",commentaire);
              TextField rate = new TextField ("","Enter A rate !!");
        rate.setUIID("textFieldBlack");
        
        addStringValue("rate",rate);
        TextField blogi = new TextField ("","Enter A Blog_Id !!");
        blogi.setUIID("textFieldBlack");
      
        addStringValue("blogi",blogi);
        Button btnAjouter = new Button("Ajouter");
        addStringValue("",btnAjouter);
       
        btnAjouter.addActionListener((e) ->
        {
            try {
                if (rate.getText().equals("")|| nom.getText().equals("")|| subject.getText().equals(" ")||commentaire.getText().equals(" "))
                {
                    Dialog.show("Veuillze verifier les donnees","","Annuler","OK");
                }
                else
                {
                                          ToastBar.Status status2 = ToastBar.getInstance().createStatus();
   
             
                ToastBar.getInstance().setPosition(HEIGHT);
                      ToastBar.Status status = ToastBar.getInstance().createStatus();
 status.setShowProgressIndicator(true);
   status.setIcon(res.getImage("back-logo.jpeg").scaledSmallerRatio(Display.getInstance().getDisplayWidth()/10, Display.getInstance().getDisplayWidth()/15));
                            status.setMessage("Comment has been added");
                                                  status.setExpires(10000);  // only show the status for 3 seconds, then have it automatically clear
status.setShowProgressIndicator(false);
                      status.show();

               //  iDialog.dispose(); //NAHIW LOADING BAED AJOUT
                                   new AjoutCommForm(res).show();

                 refreshTheme();
                    InfiniteProgress ip = new InfiniteProgress();
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Commentaire r = new Commentaire(String.valueOf(nom.getText()).toString(),
                            String.valueOf(subject.getText()).toString(),
                            String.valueOf(commentaire.getText()).toString(),
                                 Integer.parseInt(rate.getText()),
                            Integer.parseInt(blogi.getText()),
                          SessionManager.getId()

                            
                           );
                    System.out.println("data =="+r);
                    serviceBlog.getInstance().ajoutComm(r);
                 
                    iDialog.dispose();
                    new ListBlogForm(res).show();
                    refreshTheme();
                    
                }
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
        });
                
        
    }

    private void addStringValue(String s,  Component v) {
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
                .add(BorderLayout.CENTER,v));
        add(createLineSeparator(0xeeeeee));
        
    }

    private void addTab(Tabs swipe, Label spacer , Image image, String string,String text, Resources res) {
        int size =Math.min(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight());
        if (image.getHeight()<size)
        { 
            image= image.scaledHeight(size);
        }
            if(image.getHeight()>Display.getInstance().getDisplayHeight()/2)
            {
                image=image.scaledHeight(Display.getInstance().getDisplayHeight()/2);
            }
            ScaleImageLabel imageScale = new ScaleImageLabel(image);
            imageScale.setUIID("Container");
            imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
            Label overLay = new Label("","ImageOverlay");
            Container page1=
                    LayeredLayout.encloseIn(
                    imageScale,
                            overLay,
                            BorderLayout.south(
                                    BoxLayout.encloseY(
new SpanLabel(text,"LargeWhiteText"),  
                                            spacer
                                            
                                    )
                    )
            
                    ) ;  
            swipe.addTab("",res.getImage("back-logo.jpeg"), page1);
        
    }
    public void bindButtonSelection(Button btn,Label l)
    {
        btn.addActionListener(e-> {
            if (btn.isSelected())
            {
                updateArrowPosition(btn,l);
            }
            
        });
    }

    private void updateArrowPosition(Button btn, Label l) {
        l.getUnselectedStyle().setMargin(LEFT,btn.getX()+ btn.getWidth() /2- l.getWidth() /2);
      l.getParent().repaint();  
    }
    
}
