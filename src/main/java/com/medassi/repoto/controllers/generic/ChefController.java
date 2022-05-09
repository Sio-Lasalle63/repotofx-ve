/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medassi.repoto.controllers.generic;

import com.medassi.repoto.App;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author AMedassi
 */
public class ChefController implements Retournable{
    @FXML
    public void cliqueRetour(ActionEvent event) {
         try {
             App.setRoot("accueil_chef");
         } catch (IOException ex) {
             Logger.getLogger(ChefController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
