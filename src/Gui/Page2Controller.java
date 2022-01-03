/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Entite.Feature;
import Entite.Person;
import Entite.Product_Backlog;
import Entite.Theme;
import Entite.User_Story;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import Service.FeatureCRUD;
import Service.Product_BacklogCRUD;
import Service.ThemeCRUD;
import Service.User_StoryCRUD;
import Utils.DataBase;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class Page2Controller implements Initializable {

    
  
    
    @FXML
    private TableView<Product_Backlog> tableview;
    @FXML
    private TableColumn<Product_Backlog, String> firstName;
    @FXML
    private TableColumn<Product_Backlog,String> lastName;
    @FXML
    private AnchorPane content;
    @FXML
    private TextField pbacklognom;
    @FXML
    private TableView<Theme> tableviewtheme;
    @FXML
    private TableColumn<Theme, String> numtheme;
    @FXML
    private TableColumn<Theme, String> nomtheme;
    @FXML
    private TableColumn<Theme, String> JoursTotal;
    @FXML
    private Button btn5;
    @FXML
    private TableView<Feature> tableviewfeature;
    @FXML
    private TableColumn<Feature, String> numf;
    @FXML
    private TableColumn<Feature, String> nomf;
    @FXML
    private TableColumn<Feature, String> user;
    @FXML
    private TableColumn<Feature, String> totaljours;
    @FXML
    private TableColumn<Feature, String> statue;
    @FXML
    private Button btn8;
    @FXML
    private TableView<User_Story> tableviewUstory;
    @FXML
    private TableColumn<User_Story, String> numu;
    @FXML
    private TableColumn<User_Story, String> desc;
    @FXML
    private TableColumn<User_Story, String> doing;
    @FXML
    private TableColumn<User_Story, String> totaljours1;
    @FXML
    private TableColumn<User_Story, String> priority;
    

   

    /**
     * Initializes the controller class.
     */
    
       Connection cn2=DataBase.getInstance().getConnection();
    
    Statement st;
    
   // public ClaimCRUD() {
    @FXML
    private PieChart pieChart;
    @FXML
    private TextField nomThemea;
    @FXML
    private TextField featureName;
    @FXML
    private TextField descriptionn;
    @FXML
    private TextField priorityy;
    @FXML
    private TextField EstimationUS;
    @FXML
    private TextField upDoing;

         
  public int setPB_selected()  {
      
 Product_Backlog p = tableview.getSelectionModel().getSelectedItem();
   return p.getId_backlog();
  }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }  
    
    
    
      public void afficheTheme(int idd){
      ThemeCRUD tt = new ThemeCRUD();
        
        
         List <Theme> lus = tt.ReadAllThemes(idd);
         
          numtheme.setCellValueFactory(new PropertyValueFactory<Theme,String>("id_theme"));  
           nomtheme.setCellValueFactory(new PropertyValueFactory<Theme,String>("nom_theme"));
           JoursTotal.setCellValueFactory(new PropertyValueFactory<Theme,String>("total_estimation_theme_jours"));
        
            ObservableList<Theme> aff ;
           aff = FXCollections.observableArrayList();
         
           aff.addAll(lus);
            tableviewtheme.setItems(aff);
        
        System.out.print(idd);
    
    
    
    }
      
     
    @FXML
      private void DisplayTheme(ActionEvent event ) 
    
    {try{
         Product_Backlog p = tableview.getSelectionModel().getSelectedItem();
            //System.out.println(p.getId_backlog());
    int oo=p.getId_backlog();
        
        afficheTheme(oo);}catch (Exception e){AlertMSg(); }
        //System.out.println(s);
    }
    
    
    
    public void affiche(){
    
     Product_BacklogCRUD uu= new Product_BacklogCRUD();
       
         int idf =3;
        List <Product_Backlog> lus = uu.ReadAllProductBacklog();
        
       // System.out.println(lus);
        
        
        
        
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
        
        
           firstName.setCellValueFactory(new PropertyValueFactory<Product_Backlog,String>("id_backlog"));  
           lastName.setCellValueFactory(new PropertyValueFactory<Product_Backlog,String>("projet_nom"));
         
           ObservableList<Product_Backlog> aff ;
           aff = FXCollections.observableArrayList();
         
           aff.addAll(lus);
            tableview.setItems(aff);
           
            
          
            
            
            
            
       //     Product_Backlog dm = (Product_Backlog)tableview.getSelectionModel().getSelectedItem();
            
     //   aff =tableview.getSelectionModel().getSelectedItems();
        
        
            
            
            
           // tableview.setOnMouseClicked((MouseEvent event)->{ onEdit();});
            
            
      /*      TableView.setOnMouseClicked((MouseEvent event) -> {
    if (event.getClickCount() > 1) {
        onEdit();
    }
});*/
            
      //  firstName.setUserData(Person.class.);
       // lastName.setText("michele");
    
    
    }
    
    
  
//    
//  
//    private void MoveTheme(ActionEvent event) throws IOException {
//        
//         
//         FXMLLoader loader = new FXMLLoader();
//        
//        loader.setLocation(getClass().getResource("page3.fxml"));
//        
//         loader.load();
//        
//         AnchorPane newLoadedPane =FXMLLoader.load(getClass().getResource("page3.fxml"));
//        Page3Controller send = loader.getController();
//       // send.backlog_selected(22);
//        
//         Product_Backlog p = tableview.getSelectionModel().getSelectedItem();
//          int xx=p.getId_backlog();
//        
//        send.affiche(xx);
//        send.disint(55);
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
//      //  AnchorPane newLoadedPane =FXMLLoader.load(getClass().getResource("page3.fxml"));
//    content.getChildren().clear();
//    content.getChildren().add(newLoadedPane);
//        
//    
//        
//        
//    }

    @FXML
    private void addProduct_backlog(ActionEvent event) {
       
        String mpmpb=pbacklognom.getText();
        
        Product_BacklogCRUD BB =new Product_BacklogCRUD();
        Product_Backlog B1 =new Product_Backlog(0,mpmpb);
       BB.ajouterNouveauProductBacklog(B1);
        
          Product_Backlog p = tableview.getSelectionModel().getSelectedItem();
            System.out.println(p.getProjet_nom());
        
    }

    private void afficheSelect(ActionEvent event) {
         Product_Backlog p = tableview.getSelectionModel().getSelectedItem();
            System.out.println(p.getId_backlog());
        
    }

    @FXML
    private void displayBacklog(ActionEvent event) {
        
        
        
        affiche();
    }
    
    
    
    
    
    
     public void afficheFeatures(int hh){
     
         
         int somme=0;
         
        FeatureCRUD ff = new FeatureCRUD();
                
             //   ff.updateDaysFeatures(hh);
                
                ;
        User_StoryCRUD us =new User_StoryCRUD();
         List <User_Story> listStory = us.ReadAlluserStory(hh);
         
         
          ListIterator<User_Story> litr = null;
            
            
            litr=listStory.listIterator();
            
            
            
            
            while(litr.hasNext()){
                
             somme =  litr.next().getTotal_estimation_userStory_jours() + somme;
               // System.out.println(somme);
         
            } System.out.println(somme);
         
         
        
         List <Feature> lus = ff.ReadAllFeature(hh);
         
        // String nom_feature="anisss";
         
          numf.setCellValueFactory(new PropertyValueFactory<Feature,String>("id_feature"));  
           nomf.setCellValueFactory(new PropertyValueFactory<Feature,String>("nom_feature"));
           user.setCellValueFactory(new PropertyValueFactory<Feature,String>("id_user_respensability"));
           
           totaljours.setCellValueFactory(new PropertyValueFactory<Feature,String>("total_estimation_feature_jours"));
           statue.setCellValueFactory(new PropertyValueFactory<Feature,String>("statue"));
           
        
           
           
           
           
           
           
            ObservableList<Feature> aff ;
           aff = FXCollections.observableArrayList();
         
           aff.addAll(lus);
            tableviewfeature.setItems(aff);
        
    
    }


   /* private void DisplayFeatures(ActionEvent event) {
        
              
        Theme p = tableviewtheme.getSelectionModel().getSelectedItem();
            //System.out.println(p.getId_backlog());
    int oo=p.getId_backlog();
        
        afficheFeatures(oo);
        //System.out.println(s);
    }
*/
    @FXML
    private void DisplayFeatures(javafx.scene.input.MouseEvent event) {
         Theme p = tableviewtheme.getSelectionModel().getSelectedItem();
            //System.out.println(p.getId_backlog());
    int oo=p.getId_backlog();
        
        afficheFeatures(oo);
    }

    @FXML
    private void displayedFeatures(ActionEvent event) {
        try{
        Theme p = tableviewtheme.getSelectionModel().getSelectedItem();
            //System.out.println(p.getId_backlog());
    int lh=p.getId_theme();
        
        afficheFeatures(lh);
        }catch (Exception e){AlertMSg(); }
    }
    
    
    public void AlertMSg(){
    
    
     Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Error Message");
alert.setHeaderText("Contenu non selection");
alert.setContentText("SVP ,veuillez selection une ligne de table precedent");

alert.showAndWait();
    
    }

    @FXML
    private void DisplayUserStory(ActionEvent event) {
        
        try{
        Feature p = tableviewfeature.getSelectionModel().getSelectedItem();
        
            //System.out.println(p.getId_backlog());
            int lh=p.getId_feature();
        afficheUsrStory(lh);
        
        }catch  (Exception e) {
           
         AlertMSg();   
      System.out.println("Something wenthhhh wrong.");}
      // if (lh>0) 
    //  System.out.println(p.getId_feature());
       // afficheUsrStory(lh);
   /*    else {Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("Alert");
        a1.setHeaderText("Champ Vide");
        a1.setContentText("message");
        a1.showAndWait();
       }
       */ 
    }
    
    public void afficheUsrStory(int cv){
    
        int qq=setPB_selected();
        
        System.out.println(qq);
        
     User_StoryCRUD uu = new User_StoryCRUD();
        
     
     int somme=0;
     int progress=0;
     // User_StoryCRUD us =new User_StoryCRUD();
         List <User_Story> listStory = uu.ReadAlluserStory(cv);
         
         
          ListIterator<User_Story> litr = null;
            
            
            litr=listStory.listIterator();
            
            
            
            
            while(litr.hasNext()){
                
             somme =  litr.next().getTotal_estimation_userStory_jours() + somme;
            // progress= litr.next().getDoing() +progress;
               // System.out.println(somme);
         
            } //System.out.println(somme);
          //  System.out.println(progress);
            
            
            
            
             List <User_Story> listStoryy = uu.ReadAlluserStory(cv);
         
         
          ListIterator<User_Story> litrr = null;
            
            
            litrr=listStoryy.listIterator();
            
            
            
            
            while(litrr.hasNext()){
                
            // somme =  litr.next().getTotal_estimation_userStory_jours() + somme;
             progress= litrr.next().getDoing() +progress;
               // System.out.println(somme);
         
            } //System.out.println(somme);
            System.out.println(progress);
         
     
     
            
            
            try {
            String requete2 = " UPDATE feature SET  total_estimation_feature_jours=?  WHERE id_feature = ?";
            PreparedStatement pst = cn2.prepareStatement(requete2);
          pst.setInt(1,somme);
            pst.setInt(2,cv );
             //pst.setInt(3, b.getEstimationDate());
              //pst.setString(4, b.getUserStoryPrio());
               //pst.setString(5, b.getMVP());
                //pst.setString(6, b.getRespensabilite());
            pst.executeUpdate();
            // st.executeUpdate(requete);
            System.out.println("estamation days a jour avec succes");

            st = cn2.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }
            
            
            
            
     
     
     
        
         List <User_Story> lus = uu.ReadAlluserStory(cv);
         
          numu.setCellValueFactory(new PropertyValueFactory<User_Story,String>("id_user_story"));  
           desc.setCellValueFactory(new PropertyValueFactory<User_Story,String>("user_story_description"));
           doing.setCellValueFactory(new PropertyValueFactory<User_Story,String>("doing"));
           totaljours1.setCellValueFactory(new PropertyValueFactory<User_Story,String>("total_estimation_userStory_jours"));
           priority.setCellValueFactory(new PropertyValueFactory<User_Story,String>("priority"));
           
        
            ObservableList<User_Story> aff ;
           aff = FXCollections.observableArrayList();
         
           aff.addAll(lus);
            tableviewUstory.setItems(aff);
    
    
    }
    
    public void chart(int cv){
        
         User_StoryCRUD uu = new User_StoryCRUD();
        
     int progress=0;
     int somme=0;
    // int progress=0;
     // User_StoryCRUD us =new User_StoryCRUD();
         List <User_Story> listStory = uu.ReadAlluserStory(cv);
         
         
          ListIterator<User_Story> litr = null;
            
            
            litr=listStory.listIterator();
            
            
            
            
            while(litr.hasNext()){
                
             somme =  litr.next().getTotal_estimation_userStory_jours() + somme;
            // progress= litr.next().getDoing() +progress;
               // System.out.println(somme);
         
            } System.out.println(somme);
            
            
            
            
            
             List <User_Story> listStoryy = uu.ReadAlluserStory(cv);
         
         
          ListIterator<User_Story> litrr = null;
            
            
            litrr=listStoryy.listIterator();
            
            
            
            
            while(litrr.hasNext()){
                
            // somme =  litr.next().getTotal_estimation_userStory_jours() + somme;
             progress= litrr.next().getDoing() +progress;
               // System.out.println(somme);
         
            } //System.out.println(somme);
            System.out.println(progress);
            
            
            
            ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
              //  new PieChart.Data("Grapefruit", 13),
               // new PieChart.Data("Oranges", 25),
                new PieChart.Data("Done", progress),
                new PieChart.Data("ToDO", somme-progress));
        pieChart.setData(pieChartData);
            
            
          
}
            
        
    
    

    @FXML
    private void DisplayChart(ActionEvent event) {
        
         try{
        Feature p = tableviewfeature.getSelectionModel().getSelectedItem();
        
            //System.out.println(p.getId_backlog());
            int lh=p.getId_feature();
       // afficheUsrStory(lh);
        chart(lh);
        }catch  (Exception e) {
           
         AlertMSg();   
      System.out.println("Something wenthhhh wrong.");}
        
        
    }

    

    @FXML
    private void addThemee(ActionEvent event) {
        
        try{
        Product_Backlog p = tableview.getSelectionModel().getSelectedItem();
        
            //System.out.println(p.getId_backlog());
            int lh=p.getId_backlog();
            
            
            String mpmpb=nomThemea.getText();
        
        ThemeCRUD tc =new ThemeCRUD();
       Theme t1 =new Theme(0,mpmpb,0,lh);
       tc.ajouterTheme(t1);
            
            
            
       // afficheUsrStory(lh);
       // chart(lh);
        }catch  (Exception e) {
           
         AlertMSg();   
      //System.out.println("Something wenthhhh wrong.");}
          
        
        
        }
        
    }

    @FXML
    private void addFeature(ActionEvent event) {
        
        
        
          try{
        Theme f = tableviewtheme.getSelectionModel().getSelectedItem();
        
            System.out.println(f.getId_theme());
            int lh=f.getId_theme();
            
            
            String nonfonctionalite=featureName.getText();
           // String pri=priorityy.getText();
        
           // int a=Integer.parseInt(String.valueOf(pri)); 
            
            
            
        FeatureCRUD tc =new FeatureCRUD();
       Feature t1 =new Feature(0,nonfonctionalite ,0,0,0,lh);
      //tc.ajouterUser_Story(t1);
           tc.ajouterTheme(t1);
            
            
       // afficheUsrStory(lh);
       // chart(lh);
        }catch  (Exception e) {
           
         AlertMSg();   
      //System.out.println("Something wenthhhh wrong.");}
          
        
        
        }
        
        
    }

    @FXML
    private void addUserStory(ActionEvent event) {
        
         int id_PB=setPB_selected();
        
         try{
        Feature  f = tableviewfeature.getSelectionModel().getSelectedItem();
        
            System.out.println(f.getId_feature());
            int lh=f.getId_feature();
            
            
            String mpmpb=descriptionn.getText();
            String p =priorityy.getText();
        int i = Integer.parseInt(p);

         String est =EstimationUS.getText();
        int jours = Integer.parseInt(est);

        
        User_StoryCRUD us =new User_StoryCRUD();
       User_Story uus =new User_Story(0,mpmpb,0,jours,i,lh,id_PB);
       us.ajouterUser_Story(uus);
            
            
            
       // afficheUsrStory(lh);
       // chart(lh);
        }catch  (Exception e) {
           
         AlertMSg();   
      //System.out.println("Something wenthhhh wrong.");}
          
        
        
        }
        
        
        
        
        
    }

    @FXML
    private void updateDoing(ActionEvent event) {
        
          try{
        User_Story  s = tableviewUstory.getSelectionModel().getSelectedItem();
        
           // System.out.println(f.getId_feature());
            int rowID=s.getId_user_story();
            
             String p =upDoing.getText();
        int avancement = Integer.parseInt(p);
            
           

        
//        User_StoryCRUD uss =new User_StoryCRUD();
//             uss.;
//            
            
            
       // afficheUsrStory(lh);
       // chart(lh);
        
            String requete2 = "UPDATE user_story SET doing=? WHERE id_user_story=?";
            PreparedStatement pst = cn2.prepareStatement(requete2);
          pst.setInt(1,avancement);
            pst.setInt(2,rowID );
             //pst.setInt(3, b.getEstimationDate());
              //pst.setString(4, b.getUserStoryPrio());
               //pst.setString(5, b.getMVP());
                //pst.setString(6, b.getRespensabilite());
            pst.executeUpdate();
            // st.executeUpdate(requete);
            System.out.println("progression a jour avec succes");

            st = cn2.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    } 
          
          
        
        
    }
    
    
    
    
    
}
