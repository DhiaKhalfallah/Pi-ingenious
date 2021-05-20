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
import com.jobby.entities.Blog;
import com.jobby.services.serviceBlog;
import java.io.IOException;

/**
 *
 * @author LEGION
 */
public class ModifierCommForm  extends BaseForm {
        Form current;

    public ModifierCommForm (Resources res , Blog bl) throws IOException
    {
         super ("Newsfeed",BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Liste Des Blog");
        getContentPane().setScrollVisible(false);
        
        
        super.addSideMenu(res);
        TextField nom = new TextField( String.valueOf(bl.getUser()) ,"nom",20,TextField.ANY);
        TextField subject = new TextField (bl.getCat() ,"subject",20,TextField.ANY);
        TextField comm = new TextField (bl.getContenu(),"commentaire",20,TextField.ANY);
        TextField rate = new TextField (bl.getTitre(),"rate",20,TextField.ANY);
        
nom.setUIID("NewsTopLine");
subject.setUIID("NewsTopLine");
comm.setUIID("NewsTopLine");
rate.setUIID("NewsTopLine");
Button btnModifier = new Button("Modifier");
btnModifier.setUIID("Button");
btnModifier.addPointerPressedListener(l ->{
    bl.setUser(Integer.parseInt(nom.getText()));
    bl.setCat(subject.getText());
    bl.setContenu(comm.getText());
    bl.setTitre(rate.getText());
    

if (serviceBlog.getInstance().modifierBlog(bl))
{
        try {
            new ListBlogForm(res).show();
        } catch (IOException ex) {
        }
}
    });
Button btnAnnuler = new Button("Annuler");
btnAnnuler.addActionListener(e-> {
             try {
                 new ListBlogForm(res).show();
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
        new FloatingHint(nom),
        createLineSeparator(),
        new FloatingHint(subject),
        createLineSeparator(),
        new FloatingHint(comm),
        createLineSeparator(),
        new FloatingHint(rate),
        createLineSeparator(),
        l4,l5,
        btnModifier,
        btnAnnuler
        
);
add(content);
show();
        
    }
    
}
