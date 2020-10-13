package br.coldy.controller;

import br.coldy.application.App;
import br.coldy.model.entities.Category;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoriesController implements Initializable {

    @FXML
    private TableView<Category> tableViewCategories;
    @FXML
    private TableColumn<Category, Integer> tableColumnId;
    @FXML
    private TableColumn<Category, String> tableColumnName;

    @Override
    public void initialize(URL uri, ResourceBundle rb) {
        initializeNodes();
    }

    private void initializeNodes() {
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        Stage stage = (Stage) App.getMainScene().getWindow();
        tableViewCategories.prefHeightProperty().bind(stage.heightProperty());
    }
}
