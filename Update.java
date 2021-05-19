/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilkproje;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Halil bey
 */
public class Update extends DbHelper{
    
    String TableName;
    List<String> FieldName;
    List<Object> Value;
   List<String> WhereFieldName;
   List<Object> WhereValue;
   
    public Update(String tableName) {
        this.TableName = tableName;
        FieldName = new ArrayList<>();
        Value = new ArrayList<>();
        WhereValue = new ArrayList<>();
        WhereFieldName = new ArrayList<>();
    }

    public void SetValue(String FiedlName, String value) {
        this.FieldName.add(FiedlName);
        this.Value.add("'" + value + "'");
    }

    public void SetValue(String FiedlName, Object value) {
        this.FieldName.add(FiedlName);
        this.Value.add(value);
    }

    public void AddWhere(String WhereFiedlName, Object WhereValue) {
        
        if(WhereFiedlName.isEmpty())
            WhereFiedlName = "1";
        
        if(WhereValue.equals(null))
           WhereValue = "1";
        
        this.WhereFieldName.add(WhereFiedlName);
        this.WhereValue.add(WhereValue);
    }
    
    public boolean Execute() {
        try {

            String sql = " UPDATE " + this.TableName + " SET ";

            for (int i = 0; i < this.FieldName.size(); i++) {

                if (i == 0) 
                    sql += this.FieldName.get(i) +" = "+this.Value.get(i) +",";
                else if(i == this.FieldName.size()-1)
                    sql += this.FieldName.get(i) +" = "+this.Value.get(i);
                
            }

            if(this.WhereValue.size() <= 0)
            {
                JOptionPane.showMessageDialog(null, "AddWhere Koşulu Ekleyiniz !!!");
                return false;
            }
            
            sql += " WHERE ";
            for (int i = 0; i < this.WhereValue.size(); i++) {

                if (i == 0) 
                    sql += " "+this.WhereFieldName.get(i) +" = " +this.WhereValue.get(i);
                else
                    sql += " AND "+this.WhereFieldName.get(i) +" = " +this.WhereValue.get(i);
                
            }

            JOptionPane.showMessageDialog(null,sql);
            st.execute(sql);

            return true;
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
}
