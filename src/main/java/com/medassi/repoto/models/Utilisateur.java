/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medassi.repoto.models;

/**
 *
 * @author amedassi
 */
public class Utilisateur {

    private String login;
    private String nom;
    private String prenom;
    private String type;
    private boolean actif ;
    private String mdp ;

    public Utilisateur(String login, String nom, String prenom, String type, boolean actif) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.actif = actif;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return mdp;
    }
    
    

  
   
    public String getLogin() {
        return login;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }

    public boolean isActif() {
        return actif;
    }

}
