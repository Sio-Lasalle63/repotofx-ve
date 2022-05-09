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
public class UtilisateurChefDAtelier extends Utilisateur{
    private int idFranchise ;

    public UtilisateurChefDAtelier(int idFranchise, String login, String mdp , String nom, String prenom,boolean actif) {
        super(login, nom, prenom, "Chef",actif);
        super.setMdp(mdp);
        this.idFranchise = idFranchise;
    }

    public int getIdFranchise() {
        return idFranchise;
    }
    
}
