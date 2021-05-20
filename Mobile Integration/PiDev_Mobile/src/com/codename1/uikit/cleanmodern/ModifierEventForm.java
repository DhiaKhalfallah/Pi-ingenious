/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.jobby.entities.Event;
import com.jobby.services.serviceEvent;
import java.io.IOException;

/**
 *
 * @author LEGION
 */
public class ModifierEventForm extends BaseForm {
           Form current;
           public ModifierEventForm(Resources res, Event bl)throws IOException
           {
                super ("Newsfeed",BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Liste Des Blog");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        TextField nbr = new TextField( String.valueOf(bl.getNbr()) ,"nbr",20,TextField.ANY);
        TextField nom = new TextField (bl.getNom() ,"nom",20,TextField.ANY);
        TextField description = new TextField (bl.getDescription(),"description",20,TextField.ANY);
        TextField image = new TextField (bl.getImage(),"image",20,TextField.ANY);
             TextField categorie = new TextField (bl.getCategorie(),"image",20,TextField.ANY);
        
nbr.setUIID("NewsTopLine");
nom.setUIID("NewsTopLine");
description.setUIID("NewsTopLine");
image.setUIID("NewsTopLine");
categorie.setUIID("NewsTopLine");
Button btnModifier = new Button("Modifier");
btnModifier.setUIID("Button");
btnModifier.addPointerPressedListener(l ->{
    bl.setNbr(Integer.parseInt(nbr.getText()));
    bl.setNom(nom.getText());
    bl.setDescription(description.getText());
    bl.setImage(image.getText());
     bl.setCategorie(categorie.getText());
    

if (serviceEvent.getInstance().modifierEvent(bl))
{
        try {
            new listeventform(res).show();
        } catch (IOException ex) {
        }
}
    });
Button btnAnnuler = new Button("Annuler");
btnAnnuler.addActionListener(e-> {
             try {
                 new listeventform(res).show();
             } catch (IOException ex) {
             }
});


Label l2 = new Label("");

Label l3 = new Label("");


Label l4 = new Label("");

Label l5 = new Label("");


Label l1 = new Label();

Container content = BoxLayout.encloseY(
l1,l2,
        new FloatingHint(nbr),
        createLineSeparator(),
        new FloatingHint(nom),
        createLineSeparator(),
        new FloatingHint(description),
        createLineSeparator(),
        new FloatingHint(image),
         new FloatingHint(categorie),
        createLineSeparator(),
        l4,l5,
        btnModifier,
        btnAnnuler
        
);
add(content);
show();
        
    }
       
           }

