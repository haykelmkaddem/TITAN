/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Utils.DataBase;
import Entite.Sprint;
//import edu.scrum.utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class SprintCrud {
     Connection cn2;
    Statement st;
    Sprint s =new Sprint() ;

    public SprintCrud() {
        cn2 = DataBase.getInstance().getConnection();

    }
    
    public void ajouterSprint(Sprint s){
         try {
            String requete = "INSERT INTO SPRINT(nomSprint,delai,createdOn,createdBy) VALUES (?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete);
            pst.setString(1, s.getNomSprint());
            pst.setInt(2, s.getDelai());
            pst.setString(3, s.getCreatedOn());
            pst.setString(4, s.getCreatedBy());

            pst.executeUpdate();
            System.out.println("sprint added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

}
     public void modificationSprint(Sprint s1,Integer id){
         this.getSprintById(s.getId());
         
         try {
            String requete = "UPDATE sprint SET nomSprint = ? ,delai=?,createdOn=?,createdBy=? WHERE id=?";
            PreparedStatement pst = cn2.prepareStatement(requete);
            

            pst.setString(1, s1.getNomSprint());
            pst.setInt(2, s1.getDelai());
            pst.setString(3, s1.getCreatedOn());
            pst.setString(4, s1.getCreatedBy());
            pst.setInt(5,id);

            pst.executeUpdate();
            System.out.println("sprint updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     }
     public void supprimeSprint(Integer id){
         
          try {
            String requete = " DELETE FROM SPRINT WHERE id=?";
            PreparedStatement pst = cn2.prepareStatement(requete);      
            pst.setInt(1,id);

            pst.executeUpdate();
            System.out.println("sprint deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
     }
      public List<Sprint> getSprint() {
          List sprints = new ArrayList();
        try {
            String requet3 = "SELECT * FROM Sprint";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();
            
            while (rs.next()) {
            Sprint s = new Sprint() ; 
                s.setId(rs.getInt("id"));
                s.setNomSprint(rs.getString("nomSprint"));
                s.setDelai(rs.getInt("delai"));
                s.setCreatedOn(rs.getString("createdOn"));
                s.setCreatedBy(rs.getString("createdBy"));
                sprints.add(s);
               
            } System.out.println(sprints);
            

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
          
        return sprints;
    }
       public List<Sprint> getSprintById(Integer id) {
           ArrayList<Sprint> sprints = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM Sprint where id=?";
                        

            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            pst2.setInt(1,id);
            ResultSet rs = pst2.executeQuery();
            
            while (rs.next()) {
            Sprint s = new Sprint() ; 
                s.setId(rs.getInt("id"));
                s.setNomSprint(rs.getString("nomSprint"));
                s.setDelai(rs.getInt("delai"));
                s.setCreatedOn(rs.getString("createdOn"));
                s.setCreatedBy(rs.getString("createdBy"));
                sprints.add(s);
               
            } System.out.println(sprints);
            

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
          
        return sprints;
       }
        
        public List<Sprint> getSprintByNomSprint(String nomSprint) {
           ArrayList<Sprint> sprints = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM Sprint where nomSprint LIKE ?";
                        

            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            pst2.setString(1,nomSprint);
            ResultSet rs = pst2.executeQuery();
            
            while (rs.next()) {
            Sprint s = new Sprint() ; 
                s.setId(rs.getInt("id"));
                s.setNomSprint(rs.getString("nomSprint"));
                s.setDelai(rs.getInt("delai"));
                s.setCreatedOn(rs.getString("createdOn"));
                s.setCreatedBy(rs.getString("createdBy"));
                sprints.add(s);
               
            } System.out.println(sprints);
            

        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
          
        return sprints;
    }
     
     
     
     
     
     
     
     }
    
