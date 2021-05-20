/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
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
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
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
public class blogdetailform extends BaseForm {
        Form current;

    public blogdetailform (Resources res ,  Blog bl, ArrayList<Commentaire>listC ) throws IOException
    {
    
    
    
    
    
    
    
    
          super ("Newsfeed",BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Liste Des Commentaires");
                super.addSideMenu(res);

        getContentPane().setScrollVisible(false);
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
        RadioButton mesListes = RadioButton.createToggle("Welcome", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("To", barGroup);
        liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("Blogs", barGroup);
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

        partage.setSelected(false);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(false);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
       
  
     Blog bll;
   
           

     bll= serviceBlog.getInstance().detailBlog(bl.getId(), bl);
  for(Commentaire c1 : listC )
     
        {  
            String urlImage="back-logo.jpeg";
        Image placeHolder = Image.createImage(120,90);
        EncodedImage enc = EncodedImage.createFromImage(placeHolder,false);
        URLImage urlim = URLImage.createToStorage(enc,urlImage,urlImage,URLImage.RESIZE_SCALE);
            addButton(urlim,bll,c1 ,res); 
        ScaleImageLabel image= new ScaleImageLabel(urlim);
       
   
        
        
        }
        
        
        
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

    private void addButton(Image img,Blog bl, Commentaire c,Resources res) {
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
        Button image = new Button(img.fill(width, height));
        image.setUIID("Label");
        Container cnt= BorderLayout.west(image);


int x=c.getUser();
             System.out.println("x"+x);
       Label nom= new Label("nom : "+c.getNom(),"NewsTopLine2");
        Label comm= new Label("commentaire : "+c.getCommentaire(),"NewsTopLine2");
        Label subject= new Label("subjecct :"+c.getSubject(),"NewsTopLine2");
        createLineSeparator();
        Label rate= new Label("rate :"+c.getRate(),"NewsTopLine2");
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
              
          if (serviceBlog.getInstance().deleteComm(c.getId()))
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
                new   ModifierCommForm(res,bl).show();
            } catch (IOException ex) {
            }
  
              });
           Label lshow= new Label(" ");
      lshow.setUIID("NewsTopLine");
      Style showStyle = new Style(lModifier.getUnselectedStyle());
      showStyle.setFgColor(0xf7ad02);
      FontImage m2FontImage = FontImage.createMaterial(FontImage.MATERIAL_CHECK, showStyle);
      lshow.setIcon(m2FontImage);
      lshow.setTextPosition(LEFT);
      lshow.addPointerPressedListener(l -> {
         //   try {
                //System.out.println("hello update");
            //    new   blogdetailform(res,bl,c).show();
           // } catch (IOException ex) {
            //}
  
              });
                    if (SessionManager.getId()!=x)
                    {
      
      cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
           
              
              BoxLayout.encloseX(nom),
              BoxLayout.encloseX(rate),
              BoxLayout.encloseX(subject),   

                    BoxLayout.encloseX(comm)));   


                    }
                    else
                    {
                          cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
           
              
              BoxLayout.encloseX(nom),
              BoxLayout.encloseX(rate),
              BoxLayout.encloseX(subject),   

                  BoxLayout.encloseX(comm,lModifier,lSupprimer)));
                    }
   
        
        add(cnt);

  
        
    }

    public void localNotificationReceived(String notificationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
