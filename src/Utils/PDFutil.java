/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import Entite.Room;

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
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author AMINE
 */
public class PDFutil {
    
    Connection cn2;
    Statement ste;

    public PDFutil() {
        cn2 = DataBase.getInstance().getConnection();
    }
    
    
    
    Document doc = new Document();
        
    public void listActivite() throws SQLException,FileNotFoundException,DocumentException,IOException 
    {  
        ste=cn2.createStatement();
        ResultSet rs=ste.executeQuery("SELECT * from room");
        PdfWriter.getInstance(doc, new FileOutputStream("./Room.pdf"));
        
        doc.open();
        doc.add(new Paragraph("   "));
        doc.add(new Paragraph("  Liste Room:  "));
        doc.add(new Paragraph("   "));
        
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        PdfPCell cell;
        
        cell = new PdfPCell(new Phrase("idR",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.RED);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase("roomName",FontFactory.getFont("Comic Sans MS",12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setBackgroundColor(Color.RED);
        table.addCell(cell);
        
       
        
        while (rs.next()) {                
            
                Room a = new Room();
                a.setIdR(rs.getInt(1));
                a.setRoomName(rs.getString(2));
                
               
               /*DateFormat df = new SimpleDateFormat("hh:mm:ss");
               String rec = df.format(a.getId());
                String rank = Integer.toString(a.getId());*/
         
               
               
               
               
               cell = new PdfPCell(new Phrase(String.valueOf(a.getIdR()),FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(Color.cyan);
               table.addCell(cell);
               
               cell = new PdfPCell(new Phrase(a.getRoomName(),FontFactory.getFont("Comic Sans MS",12)));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setBackgroundColor(Color.orange);
               table.addCell(cell);
               
               
        
              
        }
        
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File ("./Room.pdf"));
            }
}
