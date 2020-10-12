package br.coldy.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainView"));
        stage.setScene(scene);
        setScreen("WelcomeView");
        stage.show();
    }

    public synchronized static void setScreen(String fxml) {
        try {
            VBox newVbox = (VBox) loadFXML(fxml);
            VBox mainVbox = (VBox) ((BorderPane) scene.getRoot()).getCenter();

            mainVbox.getChildren().clear();
            mainVbox.getChildren().addAll(newVbox.getChildren());
        } catch (IOException e) {
            //TODO Class Alerts
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/br/coldy/view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}