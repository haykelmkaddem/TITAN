package Gui;

import Entite.Sprint;
import Service.SprintCrud;
import java.io.IOException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;



public class SprintController {

    private TableView<Sprint> rowSprints;

    @FXML
    private TableColumn<Sprint, String> colIdSprint;

    @FXML
    private TableColumn<Sprint, String> colNomSprint;

    @FXML
    private TableColumn<Sprint, String> colDelai;

    @FXML
    private TableColumn<Sprint,String> colCreatedOn;

    @FXML
    private TableColumn<Sprint, String> colCreatedBy;

    @FXML
    private TableView<Sprint> tableSprints;

    @FXML
    private AnchorPane content;

    @FXML
    private Button btnRecherche;

    @FXML
    private TextField fieldRechId;

    @FXML
    private TextField fieldRechNom;

    @FXML
    private Button btnAdd;
    @FXML
    private Button bt33;

    @FXML
    void addSprint(ActionEvent event) throws IOException {
        
        
         AnchorPane newLoadedPane =FXMLLoader.load(getClass().getResource("AddSprint.fxml"));
   content.getChildren().clear();
    content.getChildren().add(newLoadedPane);
        
        
        
        

    }

    
   // List<Sprint> sprints;
    

    void deleteSprint(ActionEvent event) {
         SprintCrud sc = new SprintCrud();
         
         
         
         {try{
         Sprint s = tableSprints.getSelectionModel().getSelectedItem();
            //System.out.println(p.getId_backlog());
    int oo=s.getId();
        sc.supprimeSprint(oo);
         }catch (Exception e)
         
         
         {AlertMSg(); }
         
         
         }
        
        
        

    }
    
    
    
    
    public void AlertMSg(){
    
    
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Error Message");
alert.setHeaderText("Contenu non selection");
alert.setContentText("SVP ,veuillez selection une ligne de table precedent");

alert.showAndWait();
    
    }
    

    @FXML
    void serchSprint(ActionEvent event) {
        
        
  
    }

    void updateSprint(ActionEvent event) {
        

    }
     

    @FXML
    public void loadSprints(){
        SprintCrud sc = new SprintCrud();
       // List 
        
       // Product_BacklogCRUD uu= new Product_BacklogCRUD();
       
       //  int idf =3;
        List <Sprint> lus = sc.getSprint();
        
       // System.out.println(lus);
        colIdSprint.setCellValueFactory(new PropertyValueFactory<Sprint,String>("id"));
        colNomSprint.setCellValueFactory(new PropertyValueFactory<Sprint,String>("nomSprint"));
        colDelai.setCellValueFactory(new PropertyValueFactory<Sprint,String>("delai"));
        colCreatedOn.setCellValueFactory(new PropertyValueFactory<Sprint,String>("createdOn"));
        colCreatedBy.setCellValueFactory(new PropertyValueFactory<Sprint,String>("createdBy"));
        
        
        
        ObservableList<Sprint> aff ;
           aff = FXCollections.observableArrayList();
         
           aff.addAll(lus);
            tableSprints.setItems(aff);
        
        
        
     //  ArrayList<Product_Backlog> lus = new ArrayList<>();
        
    /*     ArrayList<Person> personData = new ArrayList<>();
        
         
         
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
        
        */
        
      //  lastName.setCellValueFactory(new PropertyValueFactory<Product_Backlog,String>("lastName"));
        
//        
//           firstName.setCellValueFactory(new PropertyValueFactory<Product_Backlog,String>("id_backlog"));  
//           lastName.setCellValueFactory(new PropertyValueFactory<Product_Backlog,String>("projet_nom"));
//         
//           ObservableList<Product_Backlog> aff ;
//           aff = FXCollections.observableArrayList();
//         
//           aff.addAll(lus);
//            tableview.setItems(aff);
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        SprintCrud sc = new SprintCrud();
//        sprints = sc.getSprint();
//       
//        for(Sprint s:sprints){
//            Sprint sp = new Sprint();
//            sp.setId(s.getId());
//            sp.setNomSprint(s.getNomSprint());
//            sp.setDelai(s.getDelai());
//            sp.setCreatedOn(s.getCreatedOn());
//            sp.setCreatedBy(s.getCreatedBy());
//            obser.add(s);
//        }
//        colIdSprint.setCellValueFactory(new PropertyValueFactory<Sprint,String>("id"));
//        colNomSprint.setCellValueFactory(new PropertyValueFactory<Sprint,String>("nomSprint"));
//        colDelai.setCellValueFactory(new PropertyValueFactory<Sprint,String>("delai"));
//        colCreatedOn.setCellValueFactory(new PropertyValueFactory<Sprint,String>("createdOn"));
//        colCreatedBy.setCellValueFactory(new PropertyValueFactory<Sprint,String>("createdBy"));
//        
//        rowSprints.setItems(obser);
//        
//        rowSprints.setEditable(true);
//        
//        colIdSprint.setCellFactory(TextFieldTableCell.forTableColumn());
//        colNomSprint.setCellFactory(TextFieldTableCell.forTableColumn());
//        colDelai.setCellFactory(TextFieldTableCell.forTableColumn());
//        colCreatedOn.setCellFactory(TextFieldTableCell.forTableColumn());
//        colCreatedBy.setCellFactory(TextFieldTableCell.forTableColumn());
//                System.out.println(obser);
//       
//        colIdSprint.setSortType(TableColumn.SortType.DESCENDING);
//        colNomSprint.setSortType(TableColumn.SortType.DESCENDING);
//        colDelai.setSortType(TableColumn.SortType.DESCENDING);
//        colCreatedOn.setSortType(TableColumn.SortType.DESCENDING);
//        colCreatedBy.setSortType(TableColumn.SortType.DESCENDING);
      
    }

    @FXML
    private void displaySprints(ActionEvent event) {
        
        
        loadSprints();
        
        
    }


   
    




    
        
    }


