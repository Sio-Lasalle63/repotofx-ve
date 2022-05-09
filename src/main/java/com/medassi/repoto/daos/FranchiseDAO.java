/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medassi.repoto.daos;

import com.medassi.repoto.MariaDB;
import com.medassi.repoto.models.Franchise;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author amedassi
 */
public class FranchiseDAO {

    public static Franchise getFranchiseById(int id) throws SQLException {
        String sql = "Select * "
                + "from Franchise  "
                + "where idFranchise = ? ;";

        PreparedStatement ps = MariaDB.getINSTANCE().getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Franchise(rs.getInt("idFranchise"), rs.getString("nom"), rs.getString("adrComplete"), rs.getString("telephone"));
        } else {
            return null;
        }
    }

   
}
