/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.DailyScrum;
import Service.ServiceDailyScrum;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import static javafx.scene.input.KeyCode.S;
import javafx.scene.layout.BorderPane;
import trash.HomeController;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class DocumentController implements Initializable {

    private final ObservableList<DailyScrum> aff = FXCollections.observableArrayList();
    @FXML
    private BorderPane borderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void loadUI(String ui) {
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderpane.setCenter(root);

    }

    @FXML
    private void DailyScrumDisplay(ActionEvent event) throws SQLException {

        loadUI("DailyScrum");
    }

    @FXML
    private void PlanningDisplay(ActionEvent event) {
        loadUI("Planning");
    }

    @FXML
    private void RetrospectiveDisplay(ActionEvent event) {
        loadUI("Retrospective");
    }

    @FXML
    private void ReviewDisplay(ActionEvent event) {
        loadUI("Review");
    }

    @FXML
    private void createNewFile(ActionEvent event) {
        loadUI("NewFile");
    }
}
