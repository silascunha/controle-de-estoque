package br.coldy.controller;

import br.coldy.application.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    @FXML
    private Button btPrincipal;
    @FXML
    private Button btSecond;

    //variavel auxiliar para o clique do mouse no botão que diminui o menu dos botões principais
    private boolean isMenuButtonsResumed;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onBtPrincipalAction() {
        App.setScreen("WelcomeView");
    }

    @FXML
    public void onBtSecondAction() throws IOException {
        App.setScreen("OtherView");
    }

    @FXML
    public void menuResumeClicked() {
        Scene mainScene = App.getMainScene();
        BorderPane mainBorderPane = (BorderPane) mainScene.getRoot();

        if (isMenuButtonsResumed) {
            ((AnchorPane) mainBorderPane.getLeft()).setPrefWidth(160.0);
            isMenuButtonsResumed = false;
        }
        else {
            ((AnchorPane) mainBorderPane.getLeft()).setPrefWidth(50.0);
            isMenuButtonsResumed = true;
        }
    }

}
