/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Message;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import Service.Chatroom;
import Service.serviceMsg;

/**
 * FXML Controller class
 *
 * @author JOZEF
 */
public class MessageController implements Initializable {

    private TextArea textArea;
    @FXML
    private TableView<Message> table;
    @FXML
    private TableColumn<Message, Integer> idM;
    @FXML
    private TableColumn<Message, String> msg;
    @FXML
    private TableColumn<Message, Date> date;
    @FXML
    private TableColumn<Message, Integer> idU;
    @FXML
    private TableColumn<Message, Integer> idR;

    
    private List<Message> ListMsg;
    private ObservableList<Message> observablelist;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
public static java.sql.Date getDateOnCour() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());

    }
    private void AjoutMsg(ActionEvent event) throws SQLException {
    
         serviceMsg ch = new serviceMsg();
       if ((textArea.getText().equals("")) ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!!!");
            alert.setHeaderText("Champs manquants!!");
            alert.setContentText("Veuillez remplir tous les champs!");

            alert.showAndWait();
        } else {
            ch.ajoutMsgUser(new Message(textArea.getText(),getDateOnCour()));
        JOptionPane.showMessageDialog(null, "Message ajouté");
            textArea.clear();
             
        //aff temp reel
        idM.setCellValueFactory(new PropertyValueFactory<>("idM"));
        msg.setCellValueFactory(new PropertyValueFactory<>("msg"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

       ListMsg = ch.affichAll();
       observablelist = FXCollections.observableArrayList(ListMsg);
       table.setItems(observablelist);
       }
    
    }

    @FXML
    private void ModifierMsg(ActionEvent event) {
    }

    @FXML
    private void AfficherMsg(ActionEvent event) {
    }

    @FXML
    private void SupprimerMsg(ActionEvent event) {
    
    
    
    
    /* serviceMsg ch = new serviceMsg();
       if ((textArea.getText().equals("")) ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!!!");
            alert.setHeaderText("Champs manquants!!");
            alert.setContentText("Veuillez remplir tous les champs!");

            alert.showAndWait();
        } else {
            ch.ajoutMsgUser(new Message(textArea.getText(),getDateOnCour()));
        JOptionPane.showMessageDialog(null, "Message ajouté");
            textArea.clear();
             
        //aff temp reel
        idM.setCellValueFactory(new PropertyValueFactory<>("idM"));
        msg.setCellValueFactory(new PropertyValueFactory<>("msg"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

       ListMsg = ch.affichAll();
       observablelist = FXCollections.observableArrayList(ListMsg);
       table.setItems(observablelist);
     
*/
    }
    
    }
    

