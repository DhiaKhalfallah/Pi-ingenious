/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_rec.Controllers;
import user_rec.Entities.Candidate;
import user_rec.Entities.Entreprise;
import user_rec.Entities.Reclamation;
import user_rec.Dao.CandidateDao;
import user_rec.Dao.EntrepriseDao;
import user_rec.Dao.ReclamationDao;
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
