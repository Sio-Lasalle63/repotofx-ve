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
public class UtilisateurClient extends Utilisateur{
    private String adr ;
    private String tel ;
    private String loginCreateur ;

    public UtilisateurClient(String adr, String tel, String loginCreateur, String login, String mdp , String nom, String prenom,boolean actif) {
        super(login, nom, prenom, "Client",actif);
        this.adr = adr;
        this.tel = tel;
        super.setMdp(mdp);
        this.loginCreateur = loginCreateur;
    }

    public String getAdr() {
        return adr;
    }

    public String getTel() {
        return tel;
    }
    
    
    
}
