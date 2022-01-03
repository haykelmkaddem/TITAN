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
public class SprintReview extends Document{
    
    private int id_review;
    private String title;

    private String projectname;
    private String thingstodemo;
    private String quickupdates;
    private String whatisnext;
    
    private Date date_creation;
    private Time time_creation;
    private Date date_modification;
    private Time time_modification;

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type, String nom_type) {
        super(id_type, nom_type);
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String nom_type) {
        super(nom_type);
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String nom_type) {
        super(nom_type);
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(String title, int id_type) {
        super(id_type);
        this.title = title;
    }

    public SprintReview(String title) {
        this.title = title;
    }

    public SprintReview(String title, String projectname, String thingstodemo, String quickupdates, String whatisnext) {
    
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
    }

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext, Date date_creation, Time time_creation, Date date_modification, Time time_modification) {
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public SprintReview(int id_review, String title, String projectname, String thingstodemo, String quickupdates, String whatisnext) {
        this.id_review = id_review;
        this.title = title;
        this.projectname = projectname;
        this.thingstodemo = thingstodemo;
        this.quickupdates = quickupdates;
        this.whatisnext = whatisnext;
    }
    
    

    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getThingstodemo() {
        return thingstodemo;
    }

    public void setThingstodemo(String thingstodemo) {
        this.thingstodemo = thingstodemo;
    }

    public String getQuickupdates() {
        return quickupdates;
    }

    public void setQuickupdates(String quickupdates) {
        this.quickupdates = quickupdates;
    }

    public String getWhatisnext() {
        return whatisnext;
    }

    public void setWhatisnext(String whatisnext) {
        this.whatisnext = whatisnext;
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
        int hash = 5;
        hash = 41 * hash + this.id_review;
        hash = 41 * hash + Objects.hashCode(this.title);
        hash = 41 * hash + Objects.hashCode(this.projectname);
        hash = 41 * hash + Objects.hashCode(this.thingstodemo);
        hash = 41 * hash + Objects.hashCode(this.quickupdates);
        hash = 41 * hash + Objects.hashCode(this.whatisnext);
        hash = 41 * hash + Objects.hashCode(this.date_creation);
        hash = 41 * hash + Objects.hashCode(this.time_creation);
        hash = 41 * hash + Objects.hashCode(this.date_modification);
        hash = 41 * hash + Objects.hashCode(this.time_modification);
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
        final SprintReview other = (SprintReview) obj;
        if (this.id_review != other.id_review) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.projectname, other.projectname)) {
            return false;
        }
        if (!Objects.equals(this.thingstodemo, other.thingstodemo)) {
            return false;
        }
        if (!Objects.equals(this.quickupdates, other.quickupdates)) {
            return false;
        }
        if (!Objects.equals(this.whatisnext, other.whatisnext)) {
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
        return "SprintReview{" + "id_review=" + id_review + ", title=" + title + ", projectname=" + projectname + ", thingstodemo=" + thingstodemo + ", quickupdates=" + quickupdates + ", whatisnext=" + whatisnext + ", date_creation=" + date_creation + ", time_creation=" + time_creation + ", date_modification=" + date_modification + ", time_modification=" + time_modification + '}';
    }
    
    
    
}
