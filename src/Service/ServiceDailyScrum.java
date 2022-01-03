/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.DailyScrum;
import Entite.Document;
import IService.InterService;
import Utils.DataBase;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Deku
 */
public class ServiceDailyScrum{

    private final Connection con;
    private Statement ste;
    PreparedStatement pre;

    public ServiceDailyScrum() {
        con = DataBase.getInstance().getConnection();

    }


    public void ajouterDoc(DailyScrum d) throws SQLException {
        String req = "insert into dailyscrum(id_daily,title,"
                + "yesterdaywork,todayplan,blockers,hrsbrunt,hrscompleted"
                + ",date_creation,time_creation, date_modification,time_modification,id_type) "
                + "values(NULL,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre1.setString(1, d.getTitle());
        
        pre1.setString(2, d.getYesterdaywork());
        pre1.setString(3, d.getTodayplan());
        pre1.setString(4, d.getBlockers());
        pre1.setInt(5, d.getHrsbrunt());
        pre1.setInt(6, d.getHrscompleted());
        
        pre1.setDate(7, Date.valueOf(d.getDate_creation()));
        pre1.setTime(8, Time.valueOf(d.getTime_creation()));
        pre1.setDate(9, Date.valueOf(d.getDate_modification()));
        pre1.setTime(10, Time.valueOf(d.getTime_modification()));
        pre1.setInt(11, d.getId_type());
        
        pre1.execute();
    }

    public void ajouterById(DailyScrum t, int id_doc) throws SQLException {
      String req = "insert into dailyscrum(id_daily,title,"
                + "yesterdaywork,todayplan,blockers,hrsbrunt,hrscompleted"
                + ",date_creation,time_creation, date_modification,time_modification,id_type) "
                + "values(NULL,?,"
                + "?,?,?,?,?,"
                + "?,?,?,?,?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre1.setString(1, t.getTitle());
        
        pre1.setString(2, t.getYesterdaywork());
        pre1.setString(3, t.getTodayplan());
        pre1.setString(4, t.getBlockers());
        pre1.setInt(5, t.getHrsbrunt());
        pre1.setInt(6, t.getHrscompleted());
        
        pre1.setDate(7, Date.valueOf(t.getDate_creation()));
        pre1.setTime(8, Time.valueOf(t.getTime_creation()));
        pre1.setDate(9, Date.valueOf(t.getDate_modification()));
        pre1.setTime(10, Time.valueOf(t.getTime_modification()));
        pre1.setInt(11, id_doc);
        
        pre1.execute();
    }
    
        public void ajouterByDocument(DailyScrum t, Document d) throws SQLException {
        String req = "insert into dailyscrum(id_daily,title,"
                + "yesterdaywork,todayplan,blockers"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(NULL,?,"
                + "?,?,?,"
                + "?,?,?,?,?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre1.setString(1, t.getTitle());
        
        pre1.setString(2, t.getYesterdaywork());
        pre1.setString(3, t.getTodayplan());
        pre1.setString(4, t.getBlockers());
        
        pre1.setDate(5, Date.valueOf(t.getDate_creation()));
        pre1.setTime(6, Time.valueOf(t.getTime_creation()));
        pre1.setDate(7, Date.valueOf(t.getDate_modification()));
        pre1.setTime(8, Time.valueOf(t.getTime_modification()));
        
        pre1.setInt(9, d.getId_type());
        
        pre1.execute();
    }

   
    public void deleteDaily(DailyScrum t) throws SQLException {

        String cmd = ("DELETE FROM dailyscrum WHERE id_daily = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, t.getId_daily());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void deleteAllDaily() throws SQLException {

        String cmd = ("delete from dailyscrum");
        try {
            pre = con.prepareStatement(cmd);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    
    public void updateDaily(DailyScrum t, int id_daily) throws SQLException {

        String upd = "UPDATE dailyscrum SET title = ?, yesterdaywork = ?, todayplan = ?, blockers = ? , hrsbrunt = ? , hrscompleted = ? , date_modification = ?, time_modification = ? WHERE id_daily = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getTitle());
            
            pre.setString(2, t.getYesterdaywork());
            pre.setString(3, t.getTodayplan());
            pre.setString(4, t.getBlockers());
            
            pre.setInt(5, t.getHrsbrunt());
            pre.setInt(6, t.getHrscompleted());
            
            pre.setDate(7, Date.valueOf(t.getDate_modification()));
            pre.setTime(8, Time.valueOf(t.getTime_modification()));

            pre.setInt(9, id_daily);
           // pre.setInt(10, id_type);
            
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<DailyScrum> readAllDaily() throws SQLException {
        List<DailyScrum> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from dailyscrum");
        while (rs.next()) {
            
            int id_daily = rs.getInt(1);
            String title = rs.getString("title");
            String yesterdaywork = rs.getString("yesterdaywork");
            String todayplan = rs.getString("todayplan");
            String blockers = rs.getString("blockers");
            
            int hrsbrunt = rs.getInt("hrsbrunt");
            int hrscompleted = rs.getInt("hrscompleted");
                
            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");
            
            int id_type = rs.getInt("id_type");
            

            DailyScrum d = new DailyScrum(id_daily, title, yesterdaywork, todayplan, blockers, hrsbrunt, hrscompleted, date_creation, time_creation, date_modification, time_modification, id_type);

            arr.add(d);
        }
        return arr;
    }


}
