package com.medassi.repoto.controllers;

import com.medassi.repoto.App;
import com.medassi.repoto.daos.UtilisateurDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ConnexionController {

    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField pf;

    @FXML
    private void clickConnexion(ActionEvent event) {
        App.utilisateurConnecte = UtilisateurDAO.getUtilisateurIdentifie(tfLogin.getText(), pf.getText());
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Connexion à la base");
        if (App.utilisateurConnecte != null) {
            a.setContentText("Identification réussie en tant que " + App.utilisateurConnecte.getType());
            try {
                switch (App.utilisateurConnecte.getType()) {
                    case "Chef":
                        App.setRoot("accueil_chef");
                        break;
                    case "Mecanicien":
                        App.setRoot("accueil_mecanicien");
                        break;
                    case "Admin":
                        App.setRoot("accueil_admin");
                        break;
                    default:
                        App.setRoot("accueil_error");
                        break;
                }

            } catch (IOException ex) {
                Logger.getLogger(ConnexionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Identification échouée");
            a.showAndWait();
        }

    }
}
