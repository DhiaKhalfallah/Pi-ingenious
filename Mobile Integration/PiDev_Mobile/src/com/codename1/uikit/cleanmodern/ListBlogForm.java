/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.facebook.ui.LikeButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.messaging.Message;
import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import static com.codename1.ui.layouts.BoxLayout.encloseY;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.jobby.entities.Blog;
import com.jobby.entities.Commentaire;
import com.jobby.services.serviceBlog;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;



/**
 *
 * @author LEGION
 */
public class ListBlogForm extends BaseForm implements LocalNotificationCallback  {
    Form current;
    public ListBlogForm(Resources res) throws IOException
    {
          super ("Newsfeed",BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Liste Des Blog");
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
     
   
         ArrayList<Blog>list = serviceBlog.getInstance().affichageblog();
        for(Blog bl : list )
     
        {   
  
            String urlImage="back-logo.jpeg";
        Image placeHolder = Image.createImage(120,90);
        EncodedImage enc = EncodedImage.createFromImage(placeHolder,false);
        URLImage urlim = URLImage.createToStorage(enc,urlImage,urlImage,URLImage.RESIZE_SCALE);
            addButton(urlim,bl ,res); 
        ScaleImageLabel image= new ScaleImageLabel(urlim);
       
   
        
        
        }
          Button btnAjouter = new Button("Ajouter");
        addStringValue("",btnAjouter);
        btnAjouter.addActionListener((e) ->
        {
         
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
private void addshare()
{
    Form hi = new Form("ShareButton");
ShareButton sb = new ShareButton();
sb.setText("Share Screenshot");
hi.add(sb);

Image screenshot = Image.createImage(hi.getWidth(), hi.getHeight());
hi.revalidate();
hi.setVisible(true);
hi.paintComponent(screenshot.getGraphics(), true);

String imageFile = FileSystemStorage.getInstance().getAppHomePath() + "screenshot.png";
try(OutputStream os = FileSystemStorage.getInstance().openOutputStream(imageFile)) {
    ImageIO.getImageIO().save(screenshot, os, ImageIO.FORMAT_PNG, 1);
} catch(IOException err) {
    Log.e(err);
}

sb.setImageToShare(imageFile, "image/png");
}

    private void addButton(Image img,Blog bl, Resources res) {
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt= BorderLayout.west(image);


        Label userTxt= new Label("user : "+bl.getUser(),"NewsTopLine2");
        Label catTxt= new Label("category : "+bl.getCat(),"NewsTopLine2");
        Label contenuTxt= new Label("contenu :"+bl.getContenu(),"NewsTopLine2");
        createLineSeparator();
        Label titreTxt= new Label("titre :"+bl.getTitre(),"NewsTopLine2");
    
        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprimerStyle = new Style(lSupprimer.getUnselectedStyle());
        supprimerStyle.setFgColor(0xf21f1f);
        FontImage supprimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE,supprimerStyle);
      lSupprimer.setIcon(supprimerImage);
      lSupprimer.setTextPosition(RIGHT);
      
      
      lSupprimer.addPointerPressedListener(l -> {
          Dialog dig = new Dialog("suppression");
          if (dig.show("Suppression","Vous Voulez supprimer ce blog ?","Annuler","oui"))
              {
              dig.dispose();
              }
          else
              {
                  dig.dispose();
              
          if (serviceBlog.getInstance().deleteBlog(bl.getId()))
              {
                      try {
                          new ListBlogForm(res).show();
                      } catch (IOException ex) {
                          
                      }
              }
              }
      
      });
      Label lModifier= new Label(" ");
      lModifier.setUIID("NewsTopLine");
      Style modifierStyle = new Style(lModifier.getUnselectedStyle());
      modifierStyle.setFgColor(0xf7ad02);
      FontImage mFontImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
      lModifier.setIcon(mFontImage);
      lModifier.setTextPosition(LEFT);
      lModifier.addPointerPressedListener(l -> {
            try {
                //System.out.println("hello update");
                new   ModifierBlogForm(res,bl).show();
            } catch (IOException ex) {
            }
  
              });
           Label lshow= new Label(" ");
      lshow.setUIID("NewsTopLine");
      Style showStyle = new Style(lModifier.getUnselectedStyle());
      showStyle.setFgColor(0xf7ad02);
      FontImage m2FontImage = FontImage.createMaterial(FontImage.MATERIAL_COMMENT, showStyle);
      lshow.setIcon(m2FontImage);
      lshow.setTextPosition(LEFT);
      lshow.addPointerPressedListener(l -> {
            try {
                //System.out.println("hello update");
                            
                   ArrayList<Commentaire>listC = serviceBlog.getInstance().affichagecomm(bl.getId());
                   System.out.println(listC);
                new   blogdetailform(res,bl,listC).show();
            } catch (IOException ex) {
            }
  
              });
      
      
      
      cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
              BoxLayout.encloseX(userTxt),
              BoxLayout.encloseX(catTxt),
              BoxLayout.encloseX(contenuTxt),
              BoxLayout.encloseX(titreTxt,lModifier,lSupprimer,lshow)));
      
        add(cnt);
        
        
  
        
    }

    @Override
    public void localNotificationReceived(String notificationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
