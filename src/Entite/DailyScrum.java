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
public class DailyScrum extends Document {

    private int id_daily;

    private String title;
    private String yesterdaywork;
    private String todayplan;
    private String blockers;

    private int hrsbrunt;
    private int hrscompleted;

    private Date date_creation;
    private Time time_creation;
    private Date date_modification;
    private Time time_modification;

    public DailyScrum(int id_daily, String title, String yesterdaywork, String todayplan, String blockers, int hrsbrunt, int hrscompleted, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.id_daily = id_daily;
        this.title = title;
        this.yesterdaywork = yesterdaywork;
        this.todayplan = todayplan;
        this.blockers = blockers;
        this.hrsbrunt = hrsbrunt;
        this.hrscompleted = hrscompleted;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public DailyScrum(String title, String yesterdaywork, String todayplan, String blockers, int hrsbrunt, int hrscompleted, Date date_creation, Time time_creation, Date date_modification, Time time_modification, int id_type) {
        super(id_type);
        this.title = title;
        this.yesterdaywork = yesterdaywork;
        this.todayplan = todayplan;
        this.blockers = blockers;
        this.hrsbrunt = hrsbrunt;
        this.hrscompleted = hrscompleted;
        this.date_creation = date_creation;
        this.time_creation = time_creation;
        this.date_modification = date_modification;
        this.time_modification = time_modification;
    }

    public DailyScrum(int id_daily, String title, String yesterdaywork, String todayplan, String blockers, int hrsbrunt, int hrscompleted, int id_type) {
        super(id_type);
        this.id_daily = id_daily;
        this.title = title;
        this.yesterdaywork = yesterdaywork;
        this.todayplan = todayplan;
        this.blockers = blockers;
        this.hrsbrunt = hrsbrunt;
        this.hrscompleted = hrscompleted;
    }

    public DailyScrum(String title, String yesterdaywork, String todayplan, String blockers, int hrsbrunt, int hrscompleted) {
        this.title = title;
        this.yesterdaywork = yesterdaywork;
        this.todayplan = todayplan;
        this.blockers = blockers;
        this.hrsbrunt = hrsbrunt;
        this.hrscompleted = hrscompleted;
    }
    
    

    public int getId_daily() {
        return id_daily;
    }

    public void setId_daily(int id_daily) {
        this.id_daily = id_daily;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYesterdaywork() {
        return yesterdaywork;
    }

    public void setYesterdaywork(String yesterdaywork) {
        this.yesterdaywork = yesterdaywork;
    }

    public String getTodayplan() {
        return todayplan;
    }

    public void setTodayplan(String todayplan) {
        this.todayplan = todayplan;
    }

    public String getBlockers() {
        return blockers;
    }

    public void setBlockers(String blockers) {
        this.blockers = blockers;
    }

    public int getHrsbrunt() {
        return hrsbrunt;
    }

    public void setHrsbrunt(int hrsbrunt) {
        this.hrsbrunt = hrsbrunt;
    }

    public int getHrscompleted() {
        return hrscompleted;
    }

    public void setHrscompleted(int hrscompleted) {
        this.hrscompleted = hrscompleted;
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
        int hash = 3;
        hash = 73 * hash + this.id_daily;
        hash = 73 * hash + Objects.hashCode(this.title);
        hash = 73 * hash + Objects.hashCode(this.yesterdaywork);
        hash = 73 * hash + Objects.hashCode(this.todayplan);
        hash = 73 * hash + Objects.hashCode(this.blockers);
        hash = 73 * hash + this.hrsbrunt;
        hash = 73 * hash + this.hrscompleted;
        hash = 73 * hash + Objects.hashCode(this.date_creation);
        hash = 73 * hash + Objects.hashCode(this.time_creation);
        hash = 73 * hash + Objects.hashCode(this.date_modification);
        hash = 73 * hash + Objects.hashCode(this.time_modification);
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
        final DailyScrum other = (DailyScrum) obj;
        if (this.id_daily != other.id_daily) {
            return false;
        }
        if (this.hrsbrunt != other.hrsbrunt) {
            return false;
        }
        if (this.hrscompleted != other.hrscompleted) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.yesterdaywork, other.yesterdaywork)) {
            return false;
        }
        if (!Objects.equals(this.todayplan, other.todayplan)) {
            return false;
        }
        if (!Objects.equals(this.blockers, other.blockers)) {
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
        return "DailyScrum{" + "id_daily=" + id_daily + ", title=" + title + ", yesterdaywork=" + yesterdaywork + ", todayplan=" + todayplan + ", blockers=" + blockers + ", hrsbrunt=" + hrsbrunt + ", hrscompleted=" + hrscompleted + ", date_creation=" + date_creation + ", time_creation=" + time_creation + ", date_modification=" + date_modification + ", time_modification=" + time_modification + '}';
    }

}
