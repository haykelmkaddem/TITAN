
package Entite;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;


public class Message {
    
    private int idM;
    private String msg;
    private Date date;
    private int idU;
    private int idR;

    public Message(int idM, String msg, Date date, int idU, int idR) {
        this.idM = idM;
        this.msg = msg;
        this.date = date;
        this.idU = idU;
        this.idR = idR;
    }

    public Message(String msg, Date date) {
        this.msg = msg;
        this.date = date;
    }

    public Message(String msg) {
        this.msg = msg;
    }

    
    
    public Message() {
    }

    public int getIdM() {
        return idM;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDate() {
        return date;
    }

    public int getIdU() {
        return idU;
    }

    public int getIdR() {
        return idR;
    }

    public void setIdM(int idM) {
        this.idM = idM;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idM;
        hash = 47 * hash + Objects.hashCode(this.msg);
        hash = 47 * hash + Objects.hashCode(this.date);
        hash = 47 * hash + this.idU;
        hash = 47 * hash + this.idR;
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
        final Message other = (Message) obj;
        if (this.idM != other.idM) {
            return false;
        }
        if (this.idU != other.idU) {
            return false;
        }
        if (this.idR != other.idR) {
            return false;
        }
        if (!Objects.equals(this.msg, other.msg)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Message{" + "idM=" + idM + ", msg=" + msg + ", date=" + date + ", idU=" + idU + ", idR=" + idR + '}';
    }
    
  
    
    
    
    
    
    
    
}
