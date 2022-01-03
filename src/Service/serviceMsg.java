/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Message;
import Entite.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.DataBase;

/**
 *
 * @author JOZEF
 */
public class serviceMsg {

    public final Connection con;
    public Statement ste;
    public PreparedStatement pre;
    public PreparedStatement pret;
    public ResultSet rs;

    public serviceMsg() {
        con = DataBase.getInstance().getConnection();
    }

    //ajout msg table user
    public void ajoutMsgUser(Message m1) {

        String req = "insert into `message` (msg, date ) values (?,?)";

        try {

            pre = con.prepareStatement(req);
            pre.setString(1, m1.getMsg());
            pre.setDate(2, getDateOnCour());

            pre.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Chatroom.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static java.sql.Date getDateOnCour() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());

    }
     public List<Message> affichAll() throws SQLException {
        List<Message> list = new ArrayList<>();
        String req = "SELECT * FROM message";

        ste = con.createStatement();
        rs = ste.executeQuery(req);
        while (rs.next()) {
            list.add(new Message(rs.getString(2)));
        }

        return list;

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
}
