/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medassi.repoto.models;

/**
 *
 * @author AMedassi
 */
public class UtilisateurAdmin extends Utilisateur {
    
    public UtilisateurAdmin(String login, String nom, String prenom,boolean actif) {
        super(login, nom, prenom, "Admin",actif);
    }
    
}
