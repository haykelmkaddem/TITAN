/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class RetrospectiveController implements Initializable {

    @FXML
    private TableView<?> tableview1;
    @FXML
    private TableColumn<?, ?> name;
    @FXML
    private TableColumn<?, ?> dcreation;
    @FXML
    private TableColumn<?, ?> tcreation;
    @FXML
    private TableColumn<?, ?> dmodify;
    @FXML
    private TableColumn<?, ?> tmodify;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void FiltredDisplay(ActionEvent event) {
    }

    @FXML
    private void openRetro(ActionEvent event) {
    }

    @FXML
    private void deleteAllRetro(ActionEvent event) {
    }

    @FXML
    private void modifyRetro(ActionEvent event) {
    }

    @FXML
    private void deleteRetro(ActionEvent event) {
    }

    @FXML
    private void pdfRetro(ActionEvent event) {
    }

    @FXML
    private void statRetro(ActionEvent event) {
    }

    @FXML
    private void cleanTable(ActionEvent event) {
    }
    
}
