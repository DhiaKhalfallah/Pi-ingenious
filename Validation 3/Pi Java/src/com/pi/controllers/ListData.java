/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pi.controllers;
import com.pi.Entities.Candidate;
import com.pi.Entities.Entreprise;
import com.pi.Entities.Reclamation;
import com.pi.Dao.CandidateDao;
import com.pi.Dao.EntrepriseDao;
import com.pi.Dao.ReclamationDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dhia
 */
public class ListData {
    private ObservableList<Candidate> candidate=FXCollections.observableArrayList();
    private ObservableList<Entreprise> entreprise=FXCollections.observableArrayList();
    private ObservableList<Reclamation> claim=FXCollections.observableArrayList();
    
    public ListData() {
        
        CandidateDao pdao=CandidateDao.getInstance();
        candidate= pdao.displayAll();
        EntrepriseDao pdao2=EntrepriseDao.getInstance();
        entreprise= pdao2.displayAll();
        ReclamationDao pdao3=ReclamationDao.getInstance();
        claim= pdao3.displayAll();
    }
     public ObservableList<Candidate>getCandidate(){
        return candidate;
    }
    public ObservableList<Entreprise>getEntreprise(){
        return entreprise;
    }  
    public ObservableList<Reclamation>getReclamation(){
        return claim;
    }  
}
