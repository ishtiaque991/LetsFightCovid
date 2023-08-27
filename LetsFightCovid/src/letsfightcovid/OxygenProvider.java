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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class OxygenProvider extends javax.swing.JFrame {

    /**
     * Creates new form OxygenProvider
     */
    public OxygenProvider() {
        initComponents();
        show_user();
    }

     public ArrayList<UserOxygen> userList() {
        ArrayList<UserOxygen> userList = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";

            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT  * FROM OxygenProvider";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            UserOxygen user;
            while (rs.next()) {
                user = new UserOxygen(rs.getInt("provider_ID"), rs.getString("provider_address"), rs.getString("provider_contact"), rs.getInt("available_stock"), rs.getString("price_per_cylinder"));
                userList.add(user);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return userList;
    }
     
     
     public void show_user() {
        ArrayList<UserOxygen> list = userList();
       DefaultTableModel model = (DefaultTableModel)jTable1Oxygen.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getProvider_ID();
            row[1] = list.get(i).getProvider_address();
            row[2] = list.get(i).getProvider_contact();
            row[3] = list.get(i).getAvailable_stock();
            row[4] = list.get(i).getPrice_per_cylinder();
           
            model.addRow(row);

        }

    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelHeading = new javax.swing.JLabel();
        OxygenTable = new javax.swing.JScrollPane();
        jTable1Oxygen = new javax.swing.JTable();
        SearchArea = new javax.swing.JLabel();
        jTextSearchArea = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabelHeading.setFont(new java.awt.Font("Yu Gothic", 1, 36)); // NOI18N
        jLabelHeading.setForeground(new java.awt.Color(204, 0, 51));
        jLabelHeading.setText("Oxygen Provider");
        jLabelHeading.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        jPanel1.add(jLabelHeading);
        jLabelHeading.setBounds(430, 10, 440, 100);

        jTable1Oxygen.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1Oxygen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "provider_ID", "provider_address", "provider_contact", "available_stock", "price_per_cylinder"
            }
        ));
        OxygenTable.setViewportView(jTable1Oxygen);

        jPanel1.add(OxygenTable);
        OxygenTable.setBounds(320, 100, 790, 402);

        SearchArea.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        SearchArea.setForeground(new java.awt.Color(255, 255, 255));
        SearchArea.setText("Search By Area");
        jPanel1.add(SearchArea);
        SearchArea.setBounds(60, 170, 230, 100);

        jTextSearchArea.setFont(new java.awt.Font("Yu Gothic Medium", 0, 20)); // NOI18N
        jTextSearchArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchAreaActionPerformed(evt);
            }
        });
        jTextSearchArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextSearchAreaKeyReleased(evt);
            }
        });
        jPanel1.add(jTextSearchArea);
        jTextSearchArea.setBounds(60, 270, 150, 70);

        btnBack.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(153, 0, 0));
        btnBack.setText("Back To Menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(470, 520, 320, 60);

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(910, 520, 150, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon4-removebg-preview (2).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 10, 70, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BgPic.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1160, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextSearchAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSearchAreaActionPerformed

    private void jTextSearchAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSearchAreaKeyReleased
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1Oxygen.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";

            Connection con = DriverManager.getConnection(url);

            String query = "select * from OxygenProvider where provider_address LIKE '%" + jTextSearchArea.getText() + "%'";

            System.out.println(query);
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String s[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                model.addRow(s);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        
    }//GEN-LAST:event_jTextSearchAreaKeyReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
         Menu2 m = new Menu2();
        m.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        loginpage1 obj = new loginpage1();
       obj.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Profile1 p = new Profile1();
        p.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OxygenProvider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OxygenProvider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OxygenProvider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OxygenProvider.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OxygenProvider().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane OxygenTable;
    private javax.swing.JLabel SearchArea;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHeading;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1Oxygen;
    private javax.swing.JTextField jTextSearchArea;
    // End of variables declaration//GEN-END:variables
}
