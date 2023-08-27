/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfightcovid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class LetsFightCovid {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        try {
            // TODO code application logic here

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";
            
            Connection connection = DriverManager.getConnection(url);
            String sql = "Select * from Icu ";
            PreparedStatement pst = connection.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                int id = rs.getInt("icu_ID");
                int avl = rs.getInt("icu_availability");
                String name = rs.getString("cost_per_day");
                int hid = rs.getInt("hospital_ID");
                System.out.println(id+"  "+avl+"  "+name+"  "+hid);
                
                
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LetsFightCovid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
