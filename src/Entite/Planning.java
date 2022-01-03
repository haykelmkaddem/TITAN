/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;



/**
 *
 * @author Deku
 */
public class Planning extends Document {
    private int id_plan;
    private String title;
    
    private String analyse;
    private String evaluate;
    private String product;
    private String sprintgoal;
    private String tasks;
    
    private Date date_creation;
    private Time time_creation;
    private Date date_modification;
    private Time time_modification;

    public Planning(int id_plan, String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type, String nom_type) {
        super(id_type, nom_type);
        this.id_plan = id_plan;
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }
public Planning( ) {

    }
    public Planning(int id_plan, String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String nom_type) {
        super(nom_type);
        this.id_plan = id_plan;
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public Planning(int id_plan, String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.id_plan = id_plan;
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public Planning(String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type, String nom_type) {
        super(id_type, nom_type);
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public Planning(String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, Date date_creation, Time time_creation, Date date_modification, Time time_modification, String nom_type) {
        super(nom_type);
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public Planning(String title, int id_type) {
        super(id_type);
        this.title = title;
    }

    public Planning(String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, int id_type) {
        super(id_type);
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
    }

    public Planning(String title, String analyse, String evaluate, String product, String sprintgoal, String tasks, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.title = title;
        this.analyse = analyse;
        this.evaluate = evaluate;
        this.product = product;
        this.sprintgoal = sprintgoal;
        this.tasks = tasks;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }
    
    

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSprintgoal() {
        return sprintgoal;
    }

    public void setSprintgoal(String sprintgoal) {
        this.sprintgoal = sprintgoal;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
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
        hash = 59 * hash + this.id_plan;
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + Objects.hashCode(this.analyse);
        hash = 59 * hash + Objects.hashCode(this.evaluate);
        hash = 59 * hash + Objects.hashCode(this.product);
        hash = 59 * hash + Objects.hashCode(this.sprintgoal);
        hash = 59 * hash + Objects.hashCode(this.tasks);
        hash = 59 * hash + Objects.hashCode(this.date_creation);
        hash = 59 * hash + Objects.hashCode(this.time_creation);
        hash = 59 * hash + Objects.hashCode(this.date_modification);
        hash = 59 * hash + Objects.hashCode(this.time_modification);
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
        final Planning other = (Planning) obj;
        if (this.id_plan != other.id_plan) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.analyse, other.analyse)) {
            return false;
        }
        if (!Objects.equals(this.evaluate, other.evaluate)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.sprintgoal, other.sprintgoal)) {
            return false;
        }
        if (!Objects.equals(this.tasks, other.tasks)) {
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
        return "Planning{" + "id_plan=" + id_plan + ", title=" + title + ", analyse=" + analyse + ", evaluate=" + evaluate + ", product=" + product + ", sprintgoal=" + sprintgoal + ", tasks=" + tasks + ", date_creation=" + date_creation + ", time_creation=" + time_creation + ", date_modification=" + date_modification + ", time_modification=" + time_modification + '}';
    }
    
    
}
