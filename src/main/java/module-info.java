module br.coldy {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.coldy.controller to javafx.fxml;

    exports br.coldy.application;
    exports br.coldy.controller;
}