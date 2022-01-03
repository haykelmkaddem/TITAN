/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Lenovo
 */
public class Product_Backlog {
    public int id_backlog;
    public String projet_nom;
   // public int id_theme;

    public Product_Backlog(int id_backlog, String projet_nom) {
        this.id_backlog = id_backlog;
        this.projet_nom = projet_nom;
    }

    public int getId_backlog() {
        return id_backlog;
    }

    public String getProjet_nom() {
        return projet_nom;
    }

    public void setId_backlog(int id_backlog) {
        this.id_backlog = id_backlog;
    }

    public void setProjet_nom(String projet_nom) {
        this.projet_nom = projet_nom;
    }

    @Override
    public String toString() {
        return "Product_Backlog{" + "id_backlog=" + id_backlog + ", projet_nom=" + projet_nom + '}';
    }
    
    
    
}
