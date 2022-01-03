/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Utils.DataBase;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import Entite.Planning;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author AMINE
 */
public class PDFutilDaily {
    
    Connection cn2;
    Statement ste;

    public PDFutilDaily() {
        cn2 = DataBase.getInstance().getConnection();
    }
    
    
    
    Document doc = new Document();
        
    public void listActivite() throws SQLException,FileNotFoundException,DocumentException,IOException 
    {  
        ste=cn2.createStatement();
        ResultSet rs=ste.executeQuery("SELECT * from planning");
        PdfWriter.getInstance(doc, new FileOutputStream("./planning.pdf"));
        
        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste planning:  "));
        doc.add(new Paragraph("   "));
        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        PdfPCell cell;
        
        cell = new PdfPCell(new Phrase("id_plan",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("title",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.gray);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("analyse",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.GRAY);
        table.addCell(cell);
        
        

        
        while (rs.next()) {                
            
                Planning a = new Planning();
                a.setId_plan(rs.getInt(1));
                a.setTitle(rs.getString(2));
                a.setAnalyse(rs.getString(3));
                
               
               /*DateFormat df = new SimpleDateFormat("hh:mm:ss");
               String rec = df.format(a.getId());
                String rank = Integer.toString(a.getId());*/
         
               
               
               
               
               cell = new PdfPCell(new Phrase(String.valueOf(a.getId_plan()),FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(Color.cyan);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(a.getTitle(),FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(Color.orange);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(a.getAnalyse(),FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(Color.orange);
               table.addCell(cell);
        
        

        }
        
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File ("./planning.pdf"));
            }
}
