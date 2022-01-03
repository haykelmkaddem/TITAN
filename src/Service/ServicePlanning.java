/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entite.Document;
import Entite.Planning;
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
public class ServicePlanning  {
    
    private final Connection con;
    private Statement ste;
    PreparedStatement pre;

    public ServicePlanning() {
        con = DataBase.getInstance().getConnection();

    }


    public void ajouterDoc(Planning d) throws SQLException {
                String req = "insert into planning(id_plan,title"
                + ",analyse,evaluate,product,sprintgoal,tasks"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(NULL,?"
                + ",?,?,?,?,?"
                + ",?,?,?,?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre1.setString(1, d.getTitle());
        
        pre1.setString(2, d.getAnalyse());
        pre1.setString(3, d.getEvaluate());
        pre1.setString(4, d.getProduct());
        pre1.setString(5, d.getSprintgoal());
        pre1.setString(6, d.getTasks());
        
        pre1.setDate(7, Date.valueOf(d.getDate_creation()));
        pre1.setTime(8, Time.valueOf(d.getTime_creation()));
        pre1.setDate(9, Date.valueOf(d.getDate_modification()));
        pre1.setTime(10, Time.valueOf(d.getTime_modification()));
        
        pre1.execute();
    }

    public void ajouterById(Planning d, int id_doc) throws SQLException {
                String req = "insert into planning(id_plan,title,"
                + "analyse,evaluate,product,sprintgoal,tasks"
                + ",date_creation,time_creation, date_modification,time_modification,id_type) "
                + "values(NULL,?"
                + ",?,?,?,?,?"
                + ",?,?,?,?"
                + ",?)";
        
        PreparedStatement pree = con.prepareStatement(req);
        pree.setString(1, d.getTitle());
        
        pree.setString(2, d.getAnalyse());
        pree.setString(3, d.getEvaluate());
        pree.setString(4, d.getProduct());
        pree.setString(5, d.getSprintgoal());
        pree.setString(6, d.getTasks());
        
        pree.setDate(7, Date.valueOf(d.getDate_creation()));
        pree.setTime(8, Time.valueOf(d.getTime_creation()));
        pree.setDate(9, Date.valueOf(d.getDate_modification()));
        pree.setTime(10,Time.valueOf(d.getTime_modification()));
        pree.setInt(11, id_doc);
        
        pree.execute();
    }
    
        public void ajouterByDocument(Planning d, Document t) throws SQLException {
                String req = "insert into planning(id_plan,title,"
                + "analyse,evaluate,product,sprintgoal,tasks"
                + ",date_creation,time_creation, date_modification,time_modification) "
                + "values(NULL,?"
                + ",?,?,?,?,?"
                + ",?,?,?,?"
                + ",?)";
        
        PreparedStatement pre1 = con.prepareStatement(req);
        pre.setString(1, d.getTitle());
        
        pre1.setString(2, d.getAnalyse());
        pre1.setString(3, d.getEvaluate());
        pre1.setString(4, d.getProduct());
        pre1.setString(5, d.getSprintgoal());
        pre1.setString(6, d.getTasks());
        
        pre1.setDate(7, Date.valueOf(d.getDate_creation()));
        pre1.setTime(8, Time.valueOf(d.getTime_creation()));
        pre1.setDate(9, Date.valueOf(d.getDate_modification()));
        pre1.setTime(10, Time.valueOf(d.getTime_modification()));
        
        pre1.setInt(11, t.getId_type());
        
        pre1.execute();
    }

   
    public void deleteDaily(Planning t) throws SQLException {

        String cmd = ("DELETE FROM planning WHERE id_plan = ?");
        try {
            pre = con.prepareStatement(cmd);
            pre.setInt(1, t.getId_plan());
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    public void deleteAllDaily() throws SQLException {

        String cmd = ("delete from planning");
        try {
            pre = con.prepareStatement(cmd);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    
    public void updatePlan(Planning t,int id) throws SQLException {

        String upd = "UPDATE planning SET title = ?, analyse = ?, evaluate = ?,  product = ? , sprintgoal = ? , tasks = ? , date_modification = ?, time_modification = ? WHERE id_plan = ?";
        try {
            pre = con.prepareStatement(upd);
            pre.setString(1, t.getTitle());
            
            pre.setString(2, t.getAnalyse());
            pre.setString(3, t.getEvaluate());
            pre.setString(4, t.getProduct());
            pre.setString(5, t.getSprintgoal());
            pre.setString(6, t.getTasks());
            
            pre.setDate(7, Date.valueOf(t.getDate_modification()));
            pre.setTime(8, Time.valueOf(t.getTime_modification()));

            pre.setInt(9, id);
            pre.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Planning> readAllPlan() throws SQLException {
        List<Planning> arr = new ArrayList<>();
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from planning");
        while (rs.next()) {
            
            int id_plan = rs.getInt(1);
            String title = rs.getString("title");
            String analyse = rs.getString("analyse");
            String evaluate = rs.getString("evaluate");
            String product = rs.getString("product");  
            String sprintgoal = rs.getString("sprintgoal");
            String tasks = rs.getString("tasks");
                
            Date date_creation = rs.getDate("date_creation");
            Time time_creation = rs.getTime("time_creation");
            Date date_modification = rs.getDate("date_modification");
            Time time_modification = rs.getTime("time_modification");
            
            int id_type = rs.getInt("id_type");
            

            Planning d = new Planning(id_plan, title, analyse, evaluate, product, sprintgoal, tasks, date_creation, time_creation, date_modification, time_modification, id_type);

            arr.add(d);
        }
        return arr;
    }
    
    public String listActivite(){
        String mail="";
        try {
            String requete2 = "SELECT * FROM planning";
            PreparedStatement pst = con.prepareStatement(requete2);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                mail +="\n\n";
                Planning a = new Planning();
                a.setId_plan(rs.getInt(1));
                a.setTitle(rs.getString(2));
                a.setAnalyse(rs.getString(3));

                mail +="L'activite numero " + a.getId_plan();
                mail +="\n  Libelle = " + a.getAnalyse();
                mail +="\n  Description = " + a.getTitle();

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mail;
    }
}
