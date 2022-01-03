
package Entite;

import java.util.Objects;


public class Room {
   
     private int idR;
     private String roomName;

    public Room(int idR, String roomName) {
        this.idR = idR;
        this.roomName = roomName;
    }

    public Room() {
    }

    public Room(String roomName) {
        this.roomName = roomName;
    }

    

    public int getIdR() {
        return idR;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.idR;
        hash = 29 * hash + Objects.hashCode(this.roomName);
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
        final Room other = (Room) obj;
        if (this.idR != other.idR) {
            return false;
        }
        if (!Objects.equals(this.roomName, other.roomName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Room{" + "idR=" + idR + ", roomName=" + roomName + '}';
    }

    
   
    
    
}
