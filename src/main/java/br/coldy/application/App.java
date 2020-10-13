package br.coldy.application;

import br.coldy.controller.util.Alerts;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static ScrollPane mainScrollPane;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainView"));

        mainScrollPane = (ScrollPane) ((BorderPane) scene.getRoot()).getCenter();
        mainScrollPane.setFitToWidth(true);
        mainScrollPane.setFitToHeight(true);

        scene.getStylesheets().add(getClass().getResource("/br/coldy/css/style.css").toExternalForm());
        stage.setScene(scene);
        setScreen("WelcomeView");
        stage.show();
    }

    public synchronized static void setScreen(String fxml) {
        try {
            VBox newVbox = (VBox) loadFXML(fxml);

            mainScrollPane.setContent(newVbox);
        } catch (IllegalStateException | IOException e) {
            Alerts.showAlert("Erro", "Erro ao carregar a tela.",
                    "Motivo: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/br/coldy/view/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Scene getMainScene() {
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }

}