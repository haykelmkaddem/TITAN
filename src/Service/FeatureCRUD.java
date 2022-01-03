/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Feature;
import Entite.User_Story;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import Utils.DataBase;

/**
 *
 * @author Lenovo
 */
public class FeatureCRUD {
    
    
    
      Connection cn2;
    Statement st;
    
    public FeatureCRUD()
    {
    cn2 = DataBase.getInstance().getConnection();
    }
    
    
    
    
    public void ajouterTheme (Feature f)  {
    
    try {
            String requete2 = "INSERT INTO feature (nom_feature,id_user_respensability,total_estimation_feature_jours,statue,id_theme)VALUES (?,?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete2);
            pst.setString(1, f.getNom_feature());
            pst.setInt(2, f.getId_user_respensability());
            pst.setInt(3, f.getTotal_estimation_feature_jours());
            pst.setInt(4, f.getStatue());
            pst.setInt(5, f.getId_theme());
         
            pst.executeUpdate();
           
            System.out.println("Fonctionalite  ajoutee avec succes ");

            st = cn2.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }

    
}
    
    public List<Feature> ReadAllFeature(int idt) {

        List<Feature> Allfeature = new ArrayList<>();
        try {
            String requete3 = "SELECT id_feature , nom_feature ,id_user_respensability ,total_estimation_feature_jours ,statue   FROM product_backlog p , theme t , feature f WHERE (p.id_backlog=t.id_backlog) and( t.id_theme=f.id_theme ) and (f.id_theme=? )";
           
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            
            pst2.setInt(1,idt);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
               
                int id_feature = rs.getInt(1);
                String nom_feature = rs.getString(2);
                int id_user_respensability = rs.getInt(3);
                int total_estimation_feature_jours = rs.getInt(4);
                int statue = rs.getInt(5);
                int id_theme = idt;
             
                Feature f = new Feature(id_feature, nom_feature,id_user_respensability,total_estimation_feature_jours,statue,id_theme);
                Allfeature.add(f);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Allfeature;
    }
    
    public void updateDaysFeatures(int idf){
    int somme=0;
                ;
        User_StoryCRUD us =new User_StoryCRUD();
       
       List <User_Story> listStory = us.ReadAlluserStory(idf);
         
         
          ListIterator<User_Story> litr = null;
            
            
            litr=listStory.listIterator();
            
            
            
            
            while(litr.hasNext()){
                
             somme =  litr.next().getTotal_estimation_userStory_jours() + somme;
               // System.out.println(somme);
         
            } System.out.println(somme);
         
         
    
    
    }
    
    
}
