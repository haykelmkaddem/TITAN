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
public class SprintBacklog {
    private int id_sp;
    private int id_user;
    private String user_story;
    private int id_tache ;
    private String nom_tache ;
    private int estimation ; 
    private String nom_res;

    public SprintBacklog() {
    }

    public SprintBacklog(int id_user, String user_story, int id_tache, String nom_tache, int estimation, String nom_res) {
        this.id_user = id_user;
        this.user_story = user_story;
        this.id_tache = id_tache;
        this.nom_tache = nom_tache;
        this.estimation = estimation;
        this.nom_res = nom_res;
    }
    

    public SprintBacklog(int id_sp, int id_user, String user_story, int id_tache, String nom_tache, int estimation, String nom_res) {
        this.id_sp = id_sp;
        this.id_user = id_user;
        this.user_story = user_story;
        this.id_tache = id_tache;
        this.nom_tache = nom_tache;
        this.estimation = estimation;
        this.nom_res = nom_res;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_story() {
        return user_story;
    }

    public void setUser_story(String user_story) {
        this.user_story = user_story;
    }

    public int getId_tache() {
        return id_tache;
    }

    public void setId_tache(int id_tache) {
        this.id_tache = id_tache;
    }

    public String getNom_tache() {
        return nom_tache;
    }

    public void setNom_tache(String nom_tache) {
        this.nom_tache = nom_tache;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public String getNom_res() {
        return nom_res;
    }

    public void setNom_res(String nom_res) {
        this.nom_res = nom_res;
    }

    @Override
    public String toString() {
        return "sprintBacklog{" + "id_sp=" + id_sp + ", id_user=" + id_user + ", user_story=" + user_story + ", id_tache=" + id_tache + ", nom_tache=" + nom_tache + ", estimation=" + estimation + ", nom_res=" + nom_res + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id_sp;
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
        final SprintBacklog other = (SprintBacklog) obj;
        if (this.id_sp != other.id_sp) {
            return false;
        }
        return true;
    }


  
    
    
    
}
