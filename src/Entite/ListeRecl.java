/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;

/**
 *
 * @author JOZEF
 */
public class ListeRecl {
    private int id;
    private String message;
    private Date date;
    private String user;
    private String room;

    public ListeRecl() {
    }

    public ListeRecl(int id, String message, Date date, String user, String room) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.user = user;
        this.room = room;
    }

    public ListeRecl(String message, Date date, String user, String room) {
        this.message = message;
        this.date = date;
        this.user = user;
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
    
    
}
