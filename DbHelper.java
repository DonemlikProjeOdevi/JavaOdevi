/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilkproje;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Halil bey
 */
public class DbHelper {
    
    static Statement st;
    public DbHelper()
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:1433;databaseName=EMLAK;user=BILSAMUSER;password=Bismillah+qwz0";
        Connection con = DriverManager.getConnection(url);    
        st = con.createStatement();
        }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
            
    public  static ResultSet Select(String Sql)
    {
      try{
            return st.executeQuery(Sql);
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
