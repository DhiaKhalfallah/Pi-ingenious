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
public class ModifierBlogForm extends BaseForm {
        Form current;

    public ModifierBlogForm (Resources res , Blog bl) throws IOException
    {
         super ("Newsfeed",BoxLayout.y());
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Liste Des Blog");
        getContentPane().setScrollVisible(false);
        
                        super.addSideMenu(res);

        super.addSideMenu(res);
        TextField user = new TextField( String.valueOf(bl.getUser()) ,"user",20,TextField.ANY);
        TextField cat = new TextField (bl.getCat() ,"cat",20,TextField.ANY);
        TextField contenu = new TextField (bl.getContenu(),"contenu",20,TextField.ANY);
        TextField titre = new TextField (bl.getTitre(),"titre",20,TextField.ANY);
        
user.setUIID("NewsTopLine");
cat.setUIID("NewsTopLine");
contenu.setUIID("NewsTopLine");
titre.setUIID("NewsTopLine");
Button btnModifier = new Button("Modifier");
btnModifier.setUIID("Button");
btnModifier.addPointerPressedListener(l ->{
    bl.setUser(Integer.parseInt(user.getText()));
    bl.setCat(cat.getText());
    bl.setContenu(contenu.getText());
    bl.setTitre(titre.getText());
    

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
        new FloatingHint(user),
        createLineSeparator(),
        new FloatingHint(cat),
        createLineSeparator(),
        new FloatingHint(contenu),
        createLineSeparator(),
        new FloatingHint(titre),
        createLineSeparator(),
        l4,l5,
        btnModifier,
        btnAnnuler
        
);
add(content);
show();
        
    }
          
}
