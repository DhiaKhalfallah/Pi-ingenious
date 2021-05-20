/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.uikit.cleanmodern;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.jobby.services.OffreCrud;

/**
 *
 * @author RE flex
 */
public class ListOffreForm extends Form {
     public ListOffreForm(Form previous) {
        setTitle("List Offres");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(OffreCrud.getInstance().getall().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }

}
