module br.coldy {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.coldy to javafx.fxml;
    exports br.coldy;
}