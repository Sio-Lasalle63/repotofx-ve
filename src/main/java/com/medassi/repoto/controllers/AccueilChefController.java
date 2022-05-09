package com.medassi.repoto.controllers;

import com.medassi.repoto.App;
import com.medassi.repoto.daos.FranchiseDAO;
import com.medassi.repoto.models.UtilisateurChefDAtelier;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class AccueilChefController implements Initializable {

    @FXML
    private Label zone_accueil;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String msg = "Bonjour " + App.utilisateurConnecte.getPrenom() + " " + App.utilisateurConnecte.getNom() + ",";
        msg += "\nVous êtes authentifié en tant que chef d'atelier";

        try {
            msg += " affecté à " + FranchiseDAO.getFranchiseById(((UtilisateurChefDAtelier)App.utilisateurConnecte).getIdFranchise());
        } catch (SQLException ex) {
            Logger.getLogger(AccueilChefController.class.getName()).log(Level.SEVERE, null, ex);
        }

        msg += ". Vous pouvez:\n\tAjouter un client\n\tAjouter un véhicule\n\tCréer une maintenance\n\nBonne journée.";
        zone_accueil.setText(msg);
        zone_accueil.setWrapText(true);
    }

    @FXML
    private void cliqueAddClient(ActionEvent event) {
        try {
            App.setRoot("add_client");
        } catch (IOException ex) {
            Logger.getLogger(AccueilChefController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cliqueAddVehicule(ActionEvent event) {
        try {
            App.setRoot("add_vehicule");
        } catch (IOException ex) {
            Logger.getLogger(AccueilChefController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cliqueAddMaintenance(ActionEvent event) {
        try {
            App.setRoot("add_maintenance");
        } catch (IOException ex) {
            Logger.getLogger(AccueilChefController.class.getName()).log(Level.SEVERE, null, ex);
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
