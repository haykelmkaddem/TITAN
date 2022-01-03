/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.ListeRecl;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Utils.DataBase;

/**
 * FXML Controller class
 *
 * @author JOZEF
 */
public class FXMLListeReclController implements Initializable {

    @FXML
    private TableView<ListeRecl> table;
    @FXML
    private TableColumn<ListeRecl, Integer> idM;
    @FXML
    private TableColumn<ListeRecl, String> msg;
    @FXML
    private TableColumn<ListeRecl, Date> date;
    @FXML
    private TableColumn<ListeRecl, String> idU;
    @FXML
    private TableColumn<ListeRecl, String> idR;

     
    private ObservableList<ListeRecl> observablelist;
    
    
    
      public  Connection con;
    public Statement ste;
    public PreparedStatement pre;
    public PreparedStatement pret;
    public ResultSet rs;
    
    public FXMLListeReclController(){
        con=DataBase.getInstance().getConnection();
                }
    
    
    //ListeRecl contient table msg ==> idM ,msg,date,idU,idR
    //utliser pour afficher tableau
    
    List<ListeRecl> ListR = new ArrayList<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       String res = "SELECT message.idM,message.msg,message.date, room.roomName , user.userName FROM message,room,user WHERE message.idR = room.idR and message.id=user.id ";
        try {
            ste = con.createStatement();
            rs = ste.executeQuery(res);

            while (rs.next()) {

                ListeRecl ls = new ListeRecl(rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5));
                ListR.add(ls);
            }

            idM.setCellValueFactory(new PropertyValueFactory<>("id"));
            msg.setCellValueFactory(new PropertyValueFactory<>("message"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            idU.setCellValueFactory(new PropertyValueFactory<>("user"));
            idR.setCellValueFactory(new PropertyValueFactory<>("room"));
           

            ObservableList<ListeRecl> obl = FXCollections.observableArrayList(ListR);
            table.setItems(obl);
            table.setEditable(true);

        } catch (SQLException ex) {
            Logger.getLogger(FXMLListeReclController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
        // TODO
    
    }    

    
}
