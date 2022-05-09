package com.medassi.repoto;

import com.medassi.repoto.models.Utilisateur;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static Utilisateur utilisateurConnecte = null;

    @Override
    public void start(Stage stage) throws IOException {
        loadProperties();
        scene = new Scene(loadFXML("connexion"));
        stage.setScene(scene);
        stage.setTitle("Repoto");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("images/station_fixe.png")));
        stage.show();

    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        scene.getWindow().sizeToScene();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("fxml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        InputStream is = App.class.getResourceAsStream("conf/properties.conf");
        try {
            properties.load(is);
            Config.DB_LOGIN = properties.getProperty("DB_LOGIN");
            Config.DB_MDP = properties.getProperty("DB_MDP");
            Config.DB_HOST = properties.getProperty("DB_HOST");
            Config.DB_NAME = properties.getProperty("DB_NAME");
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
