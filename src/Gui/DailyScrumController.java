/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.DailyScrum;
import Service.ServiceDailyScrum;
import com.lowagie.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import utils.PDFutilDaily;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class DailyScrumController implements Initializable {

    @FXML
    private TableView<DailyScrum> tableview1;
    @FXML
    private TableColumn<DailyScrum, String> name;
    @FXML
    private TableColumn<DailyScrum, String> dcreation;
    @FXML
    private TableColumn<DailyScrum, String> tcreation;
    @FXML
    private TableColumn<DailyScrum, String> dmodify;
    @FXML
    private TableColumn<DailyScrum, String> tmodify;

    @FXML
    private TextField filterField;

    private final ObservableList<DailyScrum> aff = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            ServiceDailyScrum ser = new ServiceDailyScrum();

            List<DailyScrum> lus = ser.readAllDaily();

//
            aff.addAll(lus);
            tableview1.getItems().clear();
            tableview1.setItems(aff);

            name.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("title"));
            dcreation.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("date_creation"));
            tcreation.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("time_creation"));
            dmodify.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("date_modification"));
            tmodify.setCellValueFactory(new PropertyValueFactory<DailyScrum, String>("time_modification"));
        } catch (SQLException ex) {
            Logger.getLogger(DailyScrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void filter(ObservableList<DailyScrum> list) {

        FilteredList<DailyScrum> filteredData = new FilteredList<>(list, b -> true);

// 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(DailyScrum -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (DailyScrum.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } /*else if (DailyScrum.getDate_creation().indexOf(lowerCaseFilter) != -1) {
        return true; // Filter matches last name.
        } else if (String.valueOf(DailyScrum.getSalary()).indexOf(lowerCaseFilter) != -1) {
        return true;
        } */ else {
                    return false; // Does not match.
                }
            });
        });

        SortedList<DailyScrum> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableview1.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableview1.setItems(sortedData);
    }

    @FXML
    private void FiltredDisplay(ActionEvent event) {
        filter(aff);
    }


    @FXML
    private void deleteAllDaily(ActionEvent event) throws SQLException {
        ServiceDailyScrum sd = new ServiceDailyScrum();
        sd.deleteAllDaily();
        tableview1.refresh();

    }


    @FXML
    private void deleteDailyS(ActionEvent event) throws SQLException {
        ServiceDailyScrum sd = new ServiceDailyScrum();
        sd.deleteDaily((DailyScrum) tableview1.getSelectionModel().getSelectedItem());
        tableview1.getItems().remove(tableview1.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void pdfDaily(ActionEvent event) throws SQLException, IOException, FileNotFoundException  {
        PDFutilDaily pdf = new PDFutilDaily();

        
            try {
                pdf.listActivite();
            } catch (DocumentException ex) {
                Logger.getLogger(DailyScrumController.class.getName()).log(Level.SEVERE, null, ex);
            }
   

    }


    @FXML
    private void cleanTable(ActionEvent event) {
        tableview1.getItems().clear();
    }

    @FXML
    private void openDailyS(ActionEvent event) {
    }

    @FXML
    private void modifyDailyS(ActionEvent event) {
    }

    @FXML
    private void statDaily(ActionEvent event) {
    }


}
