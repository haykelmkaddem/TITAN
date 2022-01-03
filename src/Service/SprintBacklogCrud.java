/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Sprint;
import Entite.SprintBacklog;
import Utils.DataBase;
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
public class SprintBacklogCrud {

    Connection cn2;
    Statement st;
    Sprint s = new Sprint();

    public SprintBacklogCrud() {
        cn2 = DataBase.getInstance().getConnection();

    }

    public void ajouterSprintBacklog(SprintBacklog sb) {
        try {
            String requete = "INSERT INTO sprintbacklog(id_user, user_story,id_tache,nom_tache,estimation,nom_res) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete);
            
           pst.setInt(1, sb.getId_user());
            pst.setString(2, sb.getUser_story());
            pst.setInt(3, sb.getId_tache());
            pst.setString(4, sb.getNom_tache());
            pst.setInt(5, sb.getEstimation());
            pst.setString(6, sb.getNom_res());
          

            pst.executeUpdate();
            System.out.println("sprintbacklog added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void modificationSprintBacklog(Integer id_sp ,SprintBacklog s1) {
        this.getSprintBacklogById(s.getId());

        try {
            String requete = "UPDATE SprintBacklog SET id_user=?, user_story=?,id_tache=?,nom_tache=?,estimation=?,nom_res=? WHERE id_sp=?";
            PreparedStatement pst = cn2.prepareStatement(requete);

            pst.setInt(1, s1.getId_user());
            pst.setString(2, s1.getUser_story());
            pst.setInt(3, s1.getId_tache());
            pst.setString(4, s1.getNom_tache());
            pst.setInt(5, s1.getEstimation());
            pst.setString(6, s1.getNom_res());
            pst.setInt(7, id_sp);

            pst.executeUpdate();
            System.out.println("sprintBacklog updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimeSprintBacklog(Integer id_sp) {

        try {
            String requete = " DELETE FROM SPRINTBACKLOG WHERE id_sp=?";
            PreparedStatement pst = cn2.prepareStatement(requete);
            pst.setInt(1, id_sp);

            pst.executeUpdate();
            System.out.println("sprintbacklog deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<SprintBacklog> getSprintBacklogs(List sprints) {

        try {
            String requet3 = "SELECT * FROM Sprintbacklog";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                SprintBacklog s = new SprintBacklog();
                s.setId_sp(rs.getInt("id_sp"));
                s.setId_user(rs.getInt("id_user"));
                s.setUser_story(rs.getString("user_story"));
                s.setId_tache(rs.getInt("id_tache"));
                s.setNom_tache(rs.getString("nom_tache"));
                s.setEstimation(rs.getInt("estimation"));
                s.setNom_res(rs.getString("nom_res"));
                sprints.add(s);

            }
            System.out.println(sprints);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return sprints;
    }

    public List<SprintBacklog> getSprintBacklogById(Integer id) {
        ArrayList<SprintBacklog> sprints = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM SprintBacklog where id_sp=?";

            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            pst2.setInt(1, id);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                SprintBacklog s = new SprintBacklog();
                s.setId_sp(rs.getInt("id_sp"));
                s.setId_user(rs.getInt("id_user"));
                s.setUser_story(rs.getString("user_story"));
                s.setId_tache(rs.getInt("id_tache"));
                s.setNom_tache(rs.getString("nom_tache"));
                s.setEstimation(rs.getInt("estimation"));
                s.setNom_res(rs.getString("nom_res"));
                sprints.add(s);

            }
            System.out.println(sprints);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return sprints;
    }

  
}
