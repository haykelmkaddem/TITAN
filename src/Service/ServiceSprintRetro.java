/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Document;
import Entite.SprintRetrospective;
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
public class ServiceSprintRetro {
    
    private final Connection con;
    private Statement ste;
    PreparedStatement pre;

    public ServiceSprintRetro() {
        con = DataBase.getInstance().getConnection();

    }


    public void ajouterRetro(SprintRetrospective d) throws SQLException {
                String req = "insert into retrospective(id_retro,title,"
                + "startdoing,stopdoing,continuedoing"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(NULL,?,"
                + "?,?,?,"
                + "?,?,?,?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre.setString(1, d.getTitle());
        
        pre1.setString(2, d.getStartdoing());
        pre1.setString(3, d.getStopdoing());
        pre1.setString(4, d.getContinuedoing());
        
        pre1.setDate(6, Date.valueOf(d.getDate_creation()));
        pre1.setTime(7, Time.valueOf(d.getTime_creation()));
        pre1.setDate(8, Date.valueOf(d.getDate_modification()));
        pre1.setTime(9, Time.valueOf(d.getTime_modification()));
        
        pre1.execute();
    }

    public void ajouterRetroById(SprintRetrospective d, int id_doc) throws SQLException {
                String req = "insert into retrospective(id_retro,title,"
                + "startdoing,stopdoing,continuedoing"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(NULL,?,"
                + "?,?,?,"
                + "?,?,?,?"
                + ",?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre.setString(1, d.getTitle());
        
        pre1.setString(2, d.getStartdoing());
        pre1.setString(3, d.getStopdoing());
        pre1.setString(4, d.getContinuedoing());
        
        pre1.setDate(6, Date.valueOf(d.getDate_creation()));
        pre1.setTime(7, Time.valueOf(d.getTime_creation()));
        pre1.setDate(8, Date.valueOf(d.getDate_modification()));
        pre1.setTime(9, Time.valueOf(d.getTime_modification()));
        pre1.setInt(10, id_doc);
        
        pre1.execute();
    }
    
        public void ajouterRetroByDoc(SprintRetrospective d, Document t) throws SQLException {
                                String req = "insert into retrospective(id_retro,title,"
                + "startdoing,stopdoing,continuedoing"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(NULL,?,"
                + "?,?,?,"
                + "?,?,?,?"
                + "?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre.setString(1, d.getTitle());
        
        pre1.setString(2, d.getStartdoing());
        pre1.setString(3, d.getStopdoing());
        pre1.setString(4, d.getContinuedoing());
        
        pre1.setDate(6, Date.valueOf(d.getDate_creation()));
        pre1.setTime(7, Time.valueOf(d.getTime_creation()));
        pre1.setDate(8, Date.valueOf(d.getDate_modification()));
        pre1.setTime(9, Time.valueOf(d.getTime_modification()));
        
        pre1.setInt(10, t.getId_type());
        
        pre1.execute();
    }

   
    public void deleteRetro(SprintRetrospective t) throws SQLException {

        String cmd = ("DELETE FROM retrospective WHERE id_retro = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, t.getId_retro());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void deleteAllRetro() throws SQLException {

        String cmd = ("delete from retrospective");
        try {
            pre = con.prepareStatement(cmd);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    
    public void updateRetro(SprintRetrospective t) throws SQLException {

        String upd = "UPDATE retrospective SET title = ?, startdoing = ?, stopdoing = ?,  continuedoing = ? , date_modification = ?, time_modification = ? WHERE id_retro = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getTitle());
            
            pre.setString(2, t.getStartdoing());
            pre.setString(3, t.getStopdoing());
            pre.setString(4, t.getContinuedoing());
            
            pre.setDate(5, Date.valueOf(t.getDate_modification()));
            pre.setTime(6, Time.valueOf(t.getTime_modification()));

            pre.setInt(7, t.getId_retro());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<SprintRetrospective> readAllPlan() throws SQLException {
        List<SprintRetrospective> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from retrospective");
        while (rs.next()) {
            
            int id_plan = rs.getInt(1);
            String title = rs.getString("title");
            
            String startdoing = rs.getString("startdoing");
            String stopdoing = rs.getString("stopdoing");
            String continuedoing = rs.getString("continuedoing");  
                
            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");
            
            int id_type = rs.getInt("id_type");
            

            SprintRetrospective d = new SprintRetrospective(id_plan, title, startdoing, stopdoing, continuedoing, date_creation, time_creation, date_modification, time_modification, id_type);

            arr.add(d);
        }
        return arr;
    }
}
