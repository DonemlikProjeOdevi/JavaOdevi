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
public class Insert extends DbHelper{

    String TableName;
    List<String> FieldName;
    List<Object> Value;

    public Insert(String tableName) {
        this.TableName = tableName;
        FieldName = new ArrayList<>();
        Value = new ArrayList<>();
    }

    public void SetValue(String FiedlName, String value) {
        this.FieldName.add(FiedlName);
        this.Value.add("'" + value + "'");
    }

    public void SetValue(String FiedlName, Object value) {
        this.FieldName.add(FiedlName);
        this.Value.add(value);
    }

    public boolean Execute() {
        try {
            
            String sql = "INSERT INTO " + this.TableName + "  (";

            for (int i = 0; i < this.FieldName.size(); i++) {

                if (i == 0) {
                    sql += this.FieldName.get(i);
                } else if (i == this.FieldName.size() - 1) {
                    sql += "," + this.FieldName.get(i) + ")";
                } else {
                    sql += "," + this.FieldName.get(i);
                }
            }

            sql += " VALUES ( ";
            for (int i = 0; i < this.Value.size(); i++) {

                if (i == 0) {
                    sql += this.Value.get(i).toString();
                } else if (i == this.Value.size() - 1) {
                    sql += "," + this.Value.get(i) + ")";
                } else {
                    sql += "," + this.Value.get(i);
                }
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
