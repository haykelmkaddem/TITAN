/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

//import Entite.ProductBacklog;
import Entite.Product_Backlog;
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
public class Product_BacklogCRUD {
    
    Connection cn2;
    Statement st;
    
    public Product_BacklogCRUD()
    {
    cn2 = DataBase.getInstance().getConnection();
    }
    public void ajouterNouveauProductBacklog (Product_Backlog b)  {
    
    try {
            String requete2 = "INSERT INTO product_backlog (projet_nom)VALUES (?)";
            PreparedStatement pst = cn2.prepareStatement(requete2);
           // pst.setString(1, b.getFeatures());
            pst.setString(1, b.getProjet_nom());
         
            pst.executeUpdate();
           
            System.out.println("Projet Backlog ajoutee ");

            st = cn2.createStatement();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        
    }

    
    
    
}


    
    public List<Product_Backlog> ReadAllProductBacklog() {

        List<Product_Backlog> allBacklog = new ArrayList<>();
        try {
            String requete3 = "SELECT * FROM Product_Backlog";
            PreparedStatement pst2 = cn2.prepareStatement(requete3);
            ResultSet rs = pst2.executeQuery();
            while (rs.next()) {
                /* Personne p = new Personne();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                per.add(p);
                 */
                int id_backlog = rs.getInt(1);
                //String features = rs.getString("features");
                String projet_nom = rs.getString(2);
             
                Product_Backlog PB = new Product_Backlog(id_backlog, projet_nom);
                allBacklog.add(PB);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return allBacklog;
    }
    
    
    
    

}