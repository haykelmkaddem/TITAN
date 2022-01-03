/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Sprint;
import Entite.Tache;
import Utils.DataBase;
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
public class TacheCrud {

    Connection cn2;
    Statement st;
    Tache t = new Tache();

    public TacheCrud() {
        cn2 = DataBase.getInstance().getConnection();

    }

    public void ajouterTache(Tache t) {
        try {
            String requete = "INSERT INTO TACHE(priorite,nom_tache,description,estimation,status) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete);
            pst.setInt(1, t.getPriorite());
            pst.setString(2, t.getNom_tache());
            pst.setString(3, t.getDescription());
            pst.setInt(4, t.getEstimation());
            pst.setString(5, t.getStatus());

            pst.executeUpdate();
            System.out.println("tache added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void modificationTache(Integer id, Tache t1) {
       

        try {
            String requete = "UPDATE TACHE SET priorite=? ,nom_tache=? ,description=?,estimation=?,status=? WHERE id=?";
            PreparedStatement pst = cn2.prepareStatement(requete);
            pst.setInt(1, t1.getPriorite());
            pst.setString(2, t1.getNom_tache());
            pst.setString(3, t1.getDescription());
            pst.setInt(4, t1.getEstimation());
            pst.setString(5, t1.getStatus());
            pst.setInt(6, id);
            pst.executeUpdate();
            System.out.println("tache updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimeTache(Integer id) {

        try {
            String requete = " DELETE FROM Tache WHERE id=?";
            PreparedStatement pst = cn2.prepareStatement(requete);
            pst.setInt(1, id);

            pst.executeUpdate();
            System.out.println("tache deleted");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Tache> getTache() {
        ArrayList<Tache> taches = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM TACHE";
            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Tache s = new Tache();
                s.setId(rs.getInt("id"));
                s.setPriorite(rs.getInt("priorite"));
                s.setNom_tache(rs.getString("nom_tache"));
                s.setDescription(rs.getString("description"));
                s.setEstimation(rs.getInt("estimation"));
                s.setStatus(rs.getString("status"));
                taches.add(s);

            }
            System.out.println(taches);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return taches;
    }

    public List<Tache> getTachesById(Integer id) {
        ArrayList<Tache> taches = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM TACHE where id=?";

            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            pst2.setInt(1, id);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Tache s = new Tache();
                s.setId(rs.getInt("id"));
                s.setPriorite(rs.getInt("priorite"));
                s.setNom_tache(rs.getString("nom_tache"));
                s.setDescription(rs.getString("description"));
                s.setEstimation(rs.getInt("estimation"));
                s.setStatus(rs.getString("status"));
                taches.add(s);

            }
            System.out.println(taches);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return taches;
    }

    public List<Tache> getTacheByNomTaches(String nom_tache) {
        ArrayList<Tache> tache = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM TACHE where nom_tache LIKE ?";

            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            pst2.setString(1, nom_tache);
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Tache s = new Tache();
                s.setId(rs.getInt("id"));
                s.setPriorite(rs.getInt("priorite"));
                s.setNom_tache(rs.getString("nom_tache"));
                s.setDescription(rs.getString("description"));
                s.setEstimation(rs.getInt("estimation"));
                s.setStatus(rs.getString("status"));
                tache.add(s);

            }
            System.out.println(tache);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return tache;
    }
    public List<Tache> getToDoTache() {
        ArrayList<Tache> tache = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM TACHE where status LIKE ?";

            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            pst2.setString(1,"DOING");
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Tache s = new Tache();
                
                s.setId(rs.getInt("id"));
                s.setPriorite(rs.getInt("priorite"));
                s.setNom_tache(rs.getString("nom_tache"));
                s.setDescription(rs.getString("description"));
                s.setEstimation(rs.getInt("estimation"));
                s.setStatus(rs.getString("status"));
                tache.add(s);

            }
            System.out.println(tache);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return tache;
    }
public List<Tache> getDOINGTache() {
        ArrayList<Tache> tache = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM TACHE where status LIKE ?";

            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            pst2.setString(1,"DOING");
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Tache s = new Tache();
                s.setId(rs.getInt("id"));
                s.setPriorite(rs.getInt("priorite"));
                s.setNom_tache(rs.getString("nom_tache"));
                s.setDescription(rs.getString("description"));
                s.setEstimation(rs.getInt("estimation"));
                s.setStatus(rs.getString("status"));
                tache.add(s);

            }
            System.out.println(tache);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return tache;
    }
public List<Tache> getDONETache() {
        ArrayList<Tache> tache = new ArrayList<>();
        try {
            String requet3 = "SELECT * FROM TACHE where status LIKE ?";

            PreparedStatement pst2 = cn2.prepareStatement(requet3);
            pst2.setString(1,"DOING");
            ResultSet rs = pst2.executeQuery();

            while (rs.next()) {
                Tache s = new Tache();
                s.setId(rs.getInt("id"));
                s.setPriorite(rs.getInt("priorite"));
                s.setNom_tache(rs.getString("nom_tache"));
                s.setDescription(rs.getString("description"));
                s.setEstimation(rs.getInt("estimation"));
                s.setStatus(rs.getString("status"));
                tache.add(s);

            }
            System.out.println(tache);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return tache;
    }


}
