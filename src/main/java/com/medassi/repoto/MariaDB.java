package com.medassi.repoto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MariaDB {

    private static MariaDB INSTANCE = null;
    private Connection connection;

    private MariaDB() {
        try {
            String chaineConnexion = "jdbc:mariadb://" + Config.DB_HOST + "/" + Config.DB_NAME;
            connection = DriverManager.getConnection(chaineConnexion, Config.DB_LOGIN, Config.DB_MDP);
        } catch (SQLException ex) {
            Logger.getLogger(MariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static MariaDB getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new MariaDB();
        }
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

}
