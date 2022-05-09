/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medassi.repoto.controllers;

import com.medassi.repoto.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author AMedassi
 */
public class AccueilAdminController implements Initializable {

    @FXML
    private Label zone_accueil;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          String msg = "Bonjour "+App.utilisateurConnecte.getPrenom()+" "+App.utilisateurConnecte.getNom()+"," ;
        msg+="\nVous êtes authentifié en tant qu' administrateur RH" ;
        msg+=". Vous pouvez:\n\tActiver un utilisateur\n\tDésactiver un utilisateur\n\tCréer un utilisateur\n\nBonne journée." ;
        zone_accueil.setText(msg);
        zone_accueil.setWrapText(true);
    }    

    @FXML
    private void cliqueActiverDesactiverUtilisateur(ActionEvent event) {
        try {
            App.setRoot("activer_desactiver");
        } catch (IOException ex) {
            Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cliqueAddUtilisateur(ActionEvent event) {
         try {
            App.setRoot("add_utilisateur");
        } catch (IOException ex) {
            Logger.getLogger(AccueilAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cliqueDeconnexion(ActionEvent event) {
        try {
            App.utilisateurConnecte = null;
            App.setRoot("connexion");

        } catch (IOException ex) {
            Logger.getLogger(AccueilMecanicienController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
