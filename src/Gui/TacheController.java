package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class TacheController {

    @FXML
    private TableView<?> rowTaches;

    @FXML
    private TableColumn<?, ?> colIdTache;

    @FXML
    private TableColumn<?, ?> colpriorite;

    @FXML
    private TableColumn<?, ?> colnom_tache;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colestimation;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRecherche;

    @FXML
    private TextField fieldRechId;

    @FXML
    private TextField fieldRechNom;

    @FXML
    private Button btnAdd;

    @FXML
    void addTache(ActionEvent event) {

    }

    @FXML
    void deleteTache(ActionEvent event) {

    }

    @FXML
    void loadSprints(ActionEvent event) {

    }

    @FXML
    void loadTaches(ActionEvent event) {

    }

    @FXML
    void serchTache(ActionEvent event) {

    }

    @FXML
    void updateTache(ActionEvent event) {

    }

}
