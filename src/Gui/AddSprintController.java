package Gui;

import Entite.Sprint;
import Service.SprintCrud;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddSprintController {


    @FXML
    private Button btnSave;

    @FXML
    private TextField fieldNomSprint;

    @FXML
    private TextField FieldDelai;

    @FXML
    private TextField fieldCreatedOn;

    @FXML
    private TextField fieldCreatedBy;
    @FXML
    private Button jjjj;

    @FXML
    void addSprint(ActionEvent event) {
        Sprint s = new Sprint(fieldNomSprint.getText(),Integer.parseInt( FieldDelai.getText()), fieldCreatedOn.getText(), fieldCreatedBy.getText());
        SprintCrud sprintCrud = new SprintCrud();
        sprintCrud.ajouterSprint(s);
    }

//    @FXML
//    void exit(ActionEvent event) {
//        
//                Stage stage = (Stage) btnExit.getScene().getWindow();
//                stage.close();
//
//    }

    @FXML
    private void jarebbb(ActionEvent event) {
    }

}
