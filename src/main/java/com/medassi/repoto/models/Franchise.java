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
public class Franchise {
    private int id ;
    private String nom ;
    private String adrComplete ;
    private String telephone ;

    public Franchise(int id, String nom, String adrComplete, String telephone) {
        this.id = id;
        this.nom = nom;
        this.adrComplete = adrComplete;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdrComplete() {
        return adrComplete;
    }

    public String getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return nom ;
    }
    
    
    
}
