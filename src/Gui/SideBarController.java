/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import trash.HomeController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Deku
 */
public class SideBarController implements Initializable {

    @FXML
    private BorderPane borderpane;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashboard(MouseEvent event) {
        loadUI("Dashboard");
    }

    @FXML
    private void project(MouseEvent event) {
    }

    @FXML
    private void task(MouseEvent event) {
        
       loadUI("Chatroom");
        
        
    }

    @FXML
    private void prodbacklog(MouseEvent event) {
        
        
        loadUI("page2");
        
        
    }

    @FXML
    private void sprints(MouseEvent event) {
        
         loadUI("Sprint");
    }

    @FXML
    private void document(MouseEvent event) {
        loadUI("Document");
    }

    @FXML
    private void team(MouseEvent event) {
    }

    @FXML
    private void exit(MouseEvent event) {
         Stage stage = (Stage) borderpane.getScene().getWindow();
         stage.close();
    }
    
    private void loadUI(String ui){
        Parent root = null ;
         
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderpane.setCenter(root);
      
     }
}
