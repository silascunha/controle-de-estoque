package br.coldy.controller.util;

import javafx.scene.control.Alert;

public class Alerts {

    private static Alert alert;

    public static void showAlert(String title, String header, String content, Alert.AlertType type) {
        alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

}
