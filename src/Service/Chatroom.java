package Service;

import Entite.Message;
import Entite.Room;
import Entite.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataBase;

public class Chatroom {

    public final Connection con;
    public Statement ste;
    public PreparedStatement pre;
    public PreparedStatement pret;
    public ResultSet rs;

    public Chatroom() {
        con = DataBase.getInstance().getConnection();
    }

    private String name;

   
    
    public static java.sql.Date getDateOnCour() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

   
    public void addRoom(Room r1) throws SQLException {
        String req = " insert into room( roomName) values('" + r1.getRoomName() + "')";
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Chatroom.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ste.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Chatroom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        String req = "delete from room where idR =?";
        try {
            pre = con.prepareStatement(req);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //delete room avec USERNAME
    public void deleteRoom1(Room r2) {
        String cmd2 = ("DELETE FROM room WHERE roomName=?");
        try {
            pre = con.prepareStatement(cmd2);
            // set the corresponding param
            pre.setString(1, r2.getRoomName());
            pre.execute();
            // execute the delete statement
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//update nom room from idR
    public void update(int idR) throws SQLException {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Ecrire votre nouvelle roomName  ! ");
        String strr = sc1.nextLine();

        String upd = "UPDATE  room SET roomName ='" + strr + "' where idR=?";

        try {
            pre = con.prepareStatement(upd);
            pre.setInt(1, idR);

            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Room> affichAll() throws SQLException {
        List<Room> list = new ArrayList<>();
        String aff = "SELECT * FROM room";

        ste = con.createStatement();
        rs = ste.executeQuery(aff);
        while (rs.next()) {
            list.add(new Room(rs.getInt(1), rs.getString(2)));
        }

        return list;

    }

    public void ExisteRoom2() {
        Scanner sc7 = new Scanner(System.in);
        System.out.println("Verifier Existance du ID de la room : ");
        int IDr = sc7.nextInt();

        String req1 = ("SELECT * FROM room WHERE idR=?");

        try {
            pre = con.prepareStatement(req1);
            // set the corresponding param
            pre.setInt(1, IDr);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    ///////////////////////////////////////////////////////////////////////
    public void ajoutMsgUser() {
       String roomM="Select roomU from user where username=?";

        Scanner sc1 = new Scanner(System.in);
        System.out.println("Ecrire votre msg  ! ");
        String strr = sc1.nextLine();

        String req = "insert into `message` (msg , date  ) values (?,?)";

        try {

           
            pre = con.prepareStatement(req);
            pre.setString(1, strr);
            pre.setDate(2, getDateOnCour());

            pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Chatroom.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public List<Room> rechUserParNom() {
        List<Room> list = new ArrayList<>();
        String req = "select username from  room where roomName=? ";
        try {
            ste = con.createStatement();
            rs = ste.executeQuery(req);
            while (rs.next()) {
                list.add(new Room(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Chatroom.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void modifiernameroom(Room r, String colName) {
        
        try {
            String req = "Update room set roomName=?  where idR=?";
            pre = con.prepareStatement(req);
            
            pre.setString(1, r.getRoomName());
            System.out.println("ok nom modifier");
            
            pre.setInt(2, r.getIdR());
            
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Chatroom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

}
