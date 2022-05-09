/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medassi.repoto.controllers.generic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author AMedassi
 */
public interface Retournable {
    @FXML
    public abstract void cliqueRetour(ActionEvent event) ;
}
