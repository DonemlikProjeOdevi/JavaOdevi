/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilkproje;

import javax.swing.JOptionPane;

/**
 *
 * @author Halil bey
 */
public class UserManager {

    public static String UserName;

    public static boolean IsUser(String UserName, String Sifre) {
        try {
            String Sql = "SELECT * FROM KULLANICI WHERE ADI = '" + UserName + "' AND SIFRE = '" + Sifre + "'";
            if (DbHelper.Select(Sql).next()) {
                UserManager.UserName = UserName;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }

    }
}
