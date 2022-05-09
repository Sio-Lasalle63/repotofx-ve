/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medassi.repoto.daos;

import com.medassi.repoto.App;
import com.medassi.repoto.MariaDB;
import com.medassi.repoto.models.Utilisateur;
import com.medassi.repoto.models.UtilisateurAdmin;
import com.medassi.repoto.models.UtilisateurChefDAtelier;
import com.medassi.repoto.models.UtilisateurClient;
import com.medassi.repoto.models.UtilisateurMecanicien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author amedassi
 */
public class UtilisateurDAO {

    public static Utilisateur getUtilisateurIdentifie(String login, String mdp) {
        Utilisateur u = null;
        try {
            String sql = "Select nom,prenom,typeUtilisateur,idFranchise "
                    + "from Utilisateur "
                    + "where login = ? and sha1Password=sha1(?) and actif ";
            PreparedStatement ps = MariaDB.getINSTANCE().getConnection().prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, mdp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String typeU = rs.getString("typeUtilisateur");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                switch (typeU) {
                    case "Admin":
                        u = new UtilisateurAdmin(login, nom, prenom, true);
                        break;
                    case "Chef":
                        int idFranchiseC = rs.getInt("idFranchise");
                        u = new UtilisateurChefDAtelier(idFranchiseC, login, null, nom, prenom, true);
                        break;
                    case "Mecanicien":
                        int idFranchiseM = rs.getInt("idFranchise");
                        u = new UtilisateurMecanicien(idFranchiseM, login, null, nom, prenom, true);
                        break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public static int addUtilisateurClient(UtilisateurClient u) {
        int res = 0;
        try {
            String sql = "INSERT INTO Utilisateur(login,nom,prenom,sha1Password,adrComplete,telephone,typeUtilisateur,login_chef) "
                    + "VALUES ( ?,?,?,sha1(?),?,?,?,? )";
            PreparedStatement ps = MariaDB.getINSTANCE().getConnection().prepareStatement(sql);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getNom());
            ps.setString(3, u.getPrenom());
            ps.setString(4, u.getMdp());
            ps.setString(5, u.getAdr());
            ps.setString(6, u.getTel());
            ps.setString(7, "Client");
            ps.setString(8, App.utilisateurConnecte.getLogin());
            res = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public static int addUtilisateurChef(UtilisateurChefDAtelier u) {
        int res = 0;
        String sql = "INSERT INTO Utilisateur(login,nom,prenom,sha1Password,typeUtilisateur,idFranchise) "
                + "VALUES ( ?,?,?,sha1(?),'Chef',?)";
        try {
            PreparedStatement ps = MariaDB.getINSTANCE().getConnection().prepareStatement(sql);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getNom());
            ps.setString(3, u.getPrenom());
            ps.setString(4, u.getMdp());
            ps.setInt(5, u.getIdFranchise());
            res = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public static int addUtilisateurMeca(UtilisateurMecanicien u) {
        int res = 0;
        String sql = "INSERT INTO Utilisateur(login,nom,prenom,sha1Password,typeUtilisateur,idFranchise) "
                + "VALUES ( ?,?,?,sha1(?),'Mecanicien',?)";
        try {
            PreparedStatement ps = MariaDB.getINSTANCE().getConnection().prepareStatement(sql);
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getNom());
            ps.setString(3, u.getPrenom());
            ps.setString(4, u.getMdp());
            ps.setInt(5, u.getIdFranchise());
            res = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return res;
    }

    public static ObservableList<UtilisateurClient> getClients() {
        ObservableList<UtilisateurClient> ucs = FXCollections.observableArrayList();
        try {
            String sql = "Select login,nom,prenom,adrComplete,telephone,login_chef "
                    + "from Utilisateur "
                    + "where typeUtilisateur='Client' and actif ";
            PreparedStatement ps = MariaDB.getINSTANCE().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String login = rs.getString("login");
                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adr = rs.getString("adrComplete");
                String tel = rs.getString("telephone");
                String loginCreateur = rs.getString("login_chef");
                UtilisateurClient uc = new UtilisateurClient(adr, tel, loginCreateur, login, null, nom, prenom, true);
                ucs.add(uc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ucs;
    }

    public static ObservableList<Utilisateur> getUtilisateurs() {
        ObservableList<Utilisateur> us = FXCollections.observableArrayList();
        try {
            String sql = "Select login,nom,prenom,typeUtilisateur,actif "
                    + "from Utilisateur ";
            PreparedStatement ps = MariaDB.getINSTANCE().getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                us.add(new Utilisateur(rs.getString("login"), rs.getString("nom"), rs.getString("prenom"),
                        rs.getString("typeUtilisateur"), rs.getBoolean("actif")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return us;
    }

    public static int activation(Utilisateur u, boolean b) {
        int res = 0;
        try {
            String sql = "update Utilisateur set actif=? where login=?";
            PreparedStatement ps = MariaDB.getINSTANCE().getConnection().prepareStatement(sql);
            ps.setBoolean(1, b);
            ps.setString(2, u.getLogin());
            res = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

}
