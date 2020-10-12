package br.coldy.controller;

import br.coldy.application.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btPrincipal;

    @FXML
    private Button btSecond;

    @FXML
    public void onBtPrincipalAction() {
        App.setScreen("WelcomeView");
    }

    @FXML
    public void onBtSecondAction() throws IOException {
        App.setScreen("OtherView");
    }



}
