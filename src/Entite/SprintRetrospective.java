/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Deku
 */
public class SprintRetrospective extends Document{
    
    private int id_retro;
    private String title;

    
    private String startdoing;
    private String stopdoing;
    private String continuedoing;
    
    private Date date_creation;
    private Time time_creation;
    private Date date_modification;
    private Time time_modification;

    public SprintRetrospective(int id_retro, String title, String startdoing, String stopdoing, String continuedoing, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type, String nom_type) {
        super(id_type, nom_type);
        this.id_retro = id_retro;
        this.title = title;
        this.startdoing = startdoing;
        this.stopdoing = stopdoing;
        this.continuedoing = continuedoing;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintRetrospective(int id_retro, String title, String startdoing, String stopdoing, String continuedoing, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String nom_type) {
        super(nom_type);
        this.id_retro = id_retro;
        this.title = title;
        this.startdoing = startdoing;
        this.stopdoing = stopdoing;
        this.continuedoing = continuedoing;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintRetrospective(int id_retro, String title, String startdoing, String stopdoing, String continuedoing, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.id_retro = id_retro;
        this.title = title;
        this.startdoing = startdoing;
        this.stopdoing = stopdoing;
        this.continuedoing = continuedoing;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintRetrospective(String title, String startdoing, String stopdoing, String continuedoing, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String nom_type) {
        super(nom_type);
        this.title = title;
        this.startdoing = startdoing;
        this.stopdoing = stopdoing;
        this.continuedoing = continuedoing;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintRetrospective(String title, String startdoing, String stopdoing, String continuedoing, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.title = title;
        this.startdoing = startdoing;
        this.stopdoing = stopdoing;
        this.continuedoing = continuedoing;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public int getId_retro() {
        return id_retro;
    }

    public void setId_retro(int id_retro) {
        this.id_retro = id_retro;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStartdoing() {
        return startdoing;
    }

    public void setStartdoing(String startdoing) {
        this.startdoing = startdoing;
    }

    public String getStopdoing() {
        return stopdoing;
    }

    public void setStopdoing(String stopdoing) {
        this.stopdoing = stopdoing;
    }

    public String getContinuedoing() {
        return continuedoing;
    }

    public void setContinuedoing(String continuedoing) {
        this.continuedoing = continuedoing;
    }

    public LocalDate getDate_creation() {
        LocalDate date_creat = LocalDate.now();
        return date_creat;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }
    
    public LocalTime getTime_creation() {
        LocalTime time_creat = LocalTime.now();
        return time_creat;
    }

    public void setTime_creation(Time time_creation) {
        this.time_creation = time_creation;
    }


    public LocalDate getDate_modification() {
        LocalDate date_modifi = LocalDate.now();
        return date_modifi;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

   public LocalTime getTime_modification() {
        LocalTime time_modifi = LocalTime.now();
        return time_modifi;
    }

    public void setTime_modification(Time time_modification) {
        this.time_modification = time_modification;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id_retro;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.startdoing);
        hash = 29 * hash + Objects.hashCode(this.stopdoing);
        hash = 29 * hash + Objects.hashCode(this.continuedoing);
        hash = 29 * hash + Objects.hashCode(this.date_creation);
        hash = 29 * hash + Objects.hashCode(this.time_creation);
        hash = 29 * hash + Objects.hashCode(this.date_modification);
        hash = 29 * hash + Objects.hashCode(this.time_modification);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SprintRetrospective other = (SprintRetrospective) obj;
        if (this.id_retro != other.id_retro) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.startdoing, other.startdoing)) {
            return false;
        }
        if (!Objects.equals(this.stopdoing, other.stopdoing)) {
            return false;
        }
        if (!Objects.equals(this.continuedoing, other.continuedoing)) {
            return false;
        }
        if (!Objects.equals(this.date_creation, other.date_creation)) {
            return false;
        }
        if (!Objects.equals(this.time_creation, other.time_creation)) {
            return false;
        }
        if (!Objects.equals(this.date_modification, other.date_modification)) {
            return false;
        }
        if (!Objects.equals(this.time_modification, other.time_modification)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SprintRetrospective{" + "id_retro=" + id_retro + ", title=" + title + ", startdoing=" + startdoing + ", stopdoing=" + stopdoing + ", continuedoing=" + continuedoing + ", date_creation=" + date_creation + ", time_creation=" + time_creation + ", date_modification=" + date_modification + ", time_modification=" + time_modification + '}';
    }
    
    
}
