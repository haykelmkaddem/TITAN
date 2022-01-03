/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Dell
 */
public class Tache {
    private int id ; 
    private int priorite ;
    private String nom_tache ;
    private String description ;
    private int estimation ;
    private String status;

    public Tache() {
    }

    public Tache(int priorite, String nom_tache, String description, int estimation, String status) {
        this.priorite = priorite;
        this.nom_tache = nom_tache;
        this.description = description;
        this.estimation = estimation;
        this.status = status;
    }
    

    public Tache(int id, int priorite, String nom_tache, String description, int estimation, String status) {
        this.id = id;
        this.priorite = priorite;
        this.nom_tache = nom_tache;
        this.description = description;
        this.estimation = estimation;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    public String getNom_tache() {
        return nom_tache;
    }

    public void setNom_tache(String nom_tache) {
        this.nom_tache = nom_tache;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "tache{" + "id=" + id + ", priorite=" + priorite + ", nom_tache=" + nom_tache + ", description=" + description + ", estimation=" + estimation + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tache other = (Tache) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

    
    
}
