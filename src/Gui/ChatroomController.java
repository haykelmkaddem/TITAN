/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.lowagie.text.DocumentException;
import Entite.Room;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import Service.Chatroom;
import Utils.DataBase;
import Utils.PDFutil;

/**
 * FXML Controller class
 *
 * @author JOZEF
 */
public class ChatroomController implements Initializable {

    @FXML
    private TableView<Room> table;
    @FXML
    private TableColumn<Room, Integer> id;
    @FXML
    private TableColumn<Room, String> nom;
    @FXML
    private TextField tfNom;
    private List<Room> ListRoom;
    private ObservableList<Room> observablelist;
    @FXML
    private Button listmsg;
    @FXML
    private ComboBox<String> comboBox;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            Chatroom ch = new Chatroom();
            id.setCellValueFactory(new PropertyValueFactory<>("idR"));
            nom.setCellValueFactory(new PropertyValueFactory<>("roomName"));
            ListRoom = ch.affichAll();
            observablelist = FXCollections.observableArrayList(ListRoom);
            table.setItems(observablelist);
            
            table.setEditable(true);
            
            nom.setCellFactory(TextFieldTableCell.forTableColumn());
           
            fillcombonme();
              
            } catch (SQLException ex) {
                Logger.getLogger(ChatroomController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

    @FXML
    private void Ajout(ActionEvent event) throws SQLException {
        Chatroom ch = new Chatroom();
        if ((tfNom.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!!!");
            alert.setHeaderText("Champs manquants!!");
            alert.setContentText("Veuillez remplir tous les champs!");

            alert.showAndWait();
        } else {
            ch.addRoom(new Room(tfNom.getText()));
            JOptionPane.showMessageDialog(null, "Room ajouté");
            tfNom.clear();

            //aff temp reel
    
            id.setCellValueFactory(new PropertyValueFactory<>("idR"));
            nom.setCellValueFactory(new PropertyValueFactory<>("roomName"));
            ListRoom = ch.affichAll();
            observablelist = FXCollections.observableArrayList(ListRoom);
            table.setItems(observablelist);
        }

    }

    @FXML
    private void supprimer(ActionEvent event) {
        Chatroom ch = new Chatroom();
        ch.delete(id.getCellData(table.getSelectionModel().getSelectedIndex()));

        Room selectedItem = table.getSelectionModel().getSelectedItem();
        table.refresh();
        table.getItems().removeAll(selectedItem);
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    public void GenerateRoomPdf() throws SQLException, IOException, FileNotFoundException {
        PDFutil pdf = new PDFutil();

        try {
            pdf.listActivite();
        } catch (DocumentException ex) {
            Logger.getLogger(ChatroomController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void listmsg(ActionEvent event) throws IOException {

        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("FXMLListeRecl.fxml"));
        Parent root1 = (Parent) fxmlloader.load();

        Stage stage = new Stage();
        stage.setTitle("Liste des message ");
        stage.setScene(new Scene(root1));
        stage.show();

    }

    ObservableList aa = FXCollections.observableArrayList();
    Connection con = DataBase.getInstance().getConnection();

    
    
    


        
       
    
    // fill in combo box with names from List(observable list) from database
    //joint deux table pour afficher
    
    private void fillcombonme() throws SQLException {
        PreparedStatement stm;
        String sql = " Select roomName from room ";
        stm = con.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();

        while (rs.next()) {
            aa.add(rs.getString("roomName"));
            comboBox.setItems(aa);
        }
    }

    private void refresh(MouseEvent event) throws SQLException {
        Chatroom ch = new Chatroom();
        id.setCellValueFactory(new PropertyValueFactory<>("idR"));
        nom.setCellValueFactory(new PropertyValueFactory<>("roomName"));
        ListRoom = ch.affichAll();
        observablelist = FXCollections.observableArrayList(ListRoom);
        table.setItems(observablelist);

    }

//    private void lancerchattttt(ActionEvent event) throws IOException {
//        
//        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/vues/server.fxml"));
//        Parent root1 = (Parent) fxmlloader.load();
//
//        Stage stage = new Stage();
//        stage.setTitle("SERVER");
//        stage.setScene(new Scene(root1));
//        stage.show();
//    }
//    
//    
//
//////    @FXML
////    private void lancerclientttt(ActionEvent event) throws IOException {
////     FXMLLoader fxmlloader1 = new FXMLLoader(getClass().getResource("/vues/client.fxml"));
////        Parent root2 = (Parent) fxmlloader1.load();
////
////        Stage stage1 = new Stage();
////        stage1.setTitle("INTERFACE CLIENT1");
////        stage1.setScene(new Scene(root2));
////        stage1.show();
////        
////        
////       
////    }
//
//    @FXML
//    private void lancerchat(ActionEvent event) {
//    }

    @FXML
    private void LANCER(ActionEvent event) throws IOException {
    
    FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("server.fxml"));
        Parent root1 = (Parent) fxmlloader.load();

        Stage stage = new Stage();
        stage.setTitle("SERVER");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    @FXML
    private void lancerclient(ActionEvent event) throws IOException {
        
        
       FXMLLoader fxmlloader1 = new FXMLLoader(getClass().getResource("client.fxml"));
        Parent root2 = (Parent) fxmlloader1.load();

        Stage stage1 = new Stage();
        stage1.setTitle("INTERFACE CLIENT1");
        stage1.setScene(new Scene(root2));
        stage1.show(); 
        
        
        
        
    }

  


}
