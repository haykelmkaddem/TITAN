/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Theme;
import Entite.User_Story;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Utils.DataBase;

/**
 *
 * @author Lenovo
 */
public class User_StoryCRUD {
    
     
     Connection cn2;
      Statement st;
    
      
      
      
       public User_StoryCRUD()
    {
    cn2 = DataBase.getInstance().getConnection();
    }
    
    
    
    
     public void ajouterUser_Story(User_Story u)  {
    
    try {
            String requete2 = "INSERT INTO user_story (user_story_description,doing,total_estimation_userStory_jours,priority,id_feature,id_PB)VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete2);
           // pst.setInt(1, u.getId_user_story());
            pst.setString(1, u.getUser_story_description());
            pst.setInt(2, u.getDoing());
            pst.setInt(3, u.getTotal_estimation_userStory_jours());
            pst.setInt(4, u.getPriority());
            pst.setInt(5, u.getId_feature());
            pst.setInt(6, u.getId_PB());
            
         
            pst.executeUpdate();
           
            System.out.println("user story  ajoutee succes ");

            st = cn2.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }

    
}
    
    
    
     public List<User_Story> ReadAlluserStory(int idf) {

        List<User_Story> AlluserStory = new ArrayList<>();
        try {
            String requete3 = "SELECT id_user_story , user_story_description ,doing ,total_estimation_userStory_jours ,priority ,id_PB  FROM product_backlog p , theme t , feature f , user_story u  WHERE (p.id_backlog=t.id_backlog) and( t.id_theme=f.id_theme ) and (f.id_feature= u.id_feature) and (u.id_feature=?)";
           
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            
            pst2.setInt(1,idf);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
               
                int id_user_story = rs.getInt(1);
                String user_story_description = rs.getString(2);
                int doing = rs.getInt(3);
                int total_estimation_userStory_jours = rs.getInt(4);
                int priority = rs.getInt(5);
                int id_PB=rs.getInt(6);
                int id_feature = idf;
                
             
                User_Story u = new User_Story(id_user_story, user_story_description,doing,total_estimation_userStory_jours,priority,id_feature,id_PB);
                AlluserStory.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return AlluserStory;
    }
     
     
     
     
}
