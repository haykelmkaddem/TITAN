/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Theme;
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
public class ThemeCRUD {
    
    
     Connection cn2;
    Statement st;
    
    public ThemeCRUD()
    {
    cn2 = DataBase.getInstance().getConnection();
    }
    
     public void ajouterTheme (Theme t)  {
    
    try {
            String requete2 = "INSERT INTO theme (nom_theme,total_estimation_theme_jours,id_backlog)VALUES (?,?,?)";
            PreparedStatement pst = cn2.prepareStatement(requete2);
            pst.setString(1, t.getNom_theme());
            pst.setInt(2, t.getTotal_estimation_theme_jours());
            pst.setInt(3, t.getId_backlog());
            
         
            pst.executeUpdate();
           
            System.out.println("theme  ajoutee succes ");

            st = cn2.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }

    
}


public List<Theme> ReadAllThemes(int idp) {

        List<Theme> Allthemes = new ArrayList<>();
        try {
            String requete3 = "SELECT * FROM theme t , product_backlog p WHERE t.id_backlog = p.id_backlog and t.id_backlog=?";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            pst2.setInt(1,idp);
            
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                /* Personne p = new Personne();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                per.add(p);
                 */
                int id_theme = rs.getInt(1);
                String nom_theme = rs.getString(2);
                int total_estimation_theme_jours = rs.getInt(3);
                int id_backlog = rs.getInt(4);
             
                Theme t = new Theme(id_theme, nom_theme,total_estimation_theme_jours,id_backlog);
                Allthemes.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Allthemes;
    }






}