/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.controllers;

import com.pi.Entities.Candidate;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Dhia
 */
public class ItemController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
     ListData listdata = new ListData();
          private ObservableList<Candidate> candidate2=FXCollections.observableArrayList();
              private ObservableList<Candidate> candidateup=FXCollections.observableArrayList();

                  private ObservableList<Candidate> candidatedown=FXCollections.observableArrayList();

                  String Candidate[];
                  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Candidate> List=listdata.getCandidate();
        {
        for(Candidate can:List)
        {
            
        }
        }
    }    
    
}
