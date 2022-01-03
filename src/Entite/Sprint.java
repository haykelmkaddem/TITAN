/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Dell
 */
public class Sprint {
  private int id ; 
  private String nomSprint;
  private int delai ;
  
  private String createdOn;
  private String createdBy ;

    public Sprint() {
        
    }
    
    

    public String getCurrentdate(){
        Date cd = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(cd);
        
        
    }

    public Sprint(String nomSprint, int delai, String createdOn, String createdBy) {
        this.nomSprint = nomSprint;
        this.delai = delai;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id).get();
    }

    public String getNomSprint() {
        return nomSprint;
    }

    public void setNomSprint(String nomSprint) {
        this.nomSprint = new SimpleStringProperty(nomSprint).get();
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = new SimpleIntegerProperty(delai).get();
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = new SimpleStringProperty(createdOn).get();
    }

  

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = new SimpleStringProperty(createdBy).get();
    }

    @Override
    public String toString() {
        return "sprint{" + "id=" + id + ", nomSprint=" + nomSprint + ", delai=" + delai + ", createdOn=" + createdOn + ", createdBy=" + createdBy + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.nomSprint);
        hash = 59 * hash + this.delai;
        hash = 59 * hash + Objects.hashCode(this.createdOn);
        hash = 59 * hash + Objects.hashCode(this.createdBy);
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
        final Sprint other = (Sprint) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomSprint, other.nomSprint)) {
            return false;
        }
        if (this.delai != other.delai) {
            return false;
        }
        if (!Objects.equals(this.createdOn, other.createdOn)) {
            return false;
        }
        if (!Objects.equals(this.createdBy, other.createdBy)) {
            return false;
        }
        return true;
    }


            
    
}
