/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfightcovid;

import javax.swing.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
 *
 * @author Asus
 */
public class PlasmaInformation extends javax.swing.JFrame {

    /**
     * Creates new form PlasmaInformation
     */
    public PlasmaInformation() {
        initComponents();
        show_user();
    }

    public ArrayList<UserPlasma> userList() {
        ArrayList<UserPlasma> userList = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";

            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT  * FROM Plasma";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            UserPlasma user;
            while (rs.next()) {
                user = new UserPlasma(rs.getInt("plasma_ID"), rs.getString("donor_name"), rs.getString("donor_address"), rs.getString("blood_group"), rs.getString("donor_contact"), rs.getInt("plasma_availability"));
                userList.add(user);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return userList;
    }

    public void show_user() {
        ArrayList<UserPlasma> list = userList();
        DefaultTableModel model = (DefaultTableModel) jTable1Plasma.getModel();
        Object[] row = new Object[6];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getPlasma_ID();
            row[1] = list.get(i).getDonor_name();
            row[2] = list.get(i).getDonor_address();
            row[3] = list.get(i).getBlood_group();
            row[4] = list.get(i).getDonor_contact();
            row[5] = list.get(i).getPlasma_availability();
            model.addRow(row);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelHeading = new javax.swing.JLabel();
        PlasmaTable = new javax.swing.JScrollPane();
        jTable1Plasma = new javax.swing.JTable();
        searchBg = new javax.swing.JLabel();
        jTextSearchbg = new javax.swing.JTextField();
        searchAdd = new javax.swing.JLabel();
        jTextSearchAdd = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1155, 599));
        jPanel1.setLayout(null);

        jLabelHeading.setBackground(new java.awt.Color(255, 255, 255));
        jLabelHeading.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabelHeading.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHeading.setText("Plasma Information");
        jLabelHeading.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelHeading);
        jLabelHeading.setBounds(400, 30, 430, 60);

        jTable1Plasma.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTable1Plasma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "plasma_ID", "donor_name", "donor_address", "blood_group", "donor_contact", "plasma_availability"
            }
        ));
        PlasmaTable.setViewportView(jTable1Plasma);

        jPanel1.add(PlasmaTable);
        PlasmaTable.setBounds(290, 100, 800, 402);

        searchBg.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        searchBg.setForeground(new java.awt.Color(255, 255, 255));
        searchBg.setText("Search By Blood Group");
        jPanel1.add(searchBg);
        searchBg.setBounds(30, 140, 240, 40);

        jTextSearchbg.setFont(new java.awt.Font("Yu Gothic Medium", 0, 20)); // NOI18N
        jTextSearchbg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchbgActionPerformed(evt);
            }
        });
        jTextSearchbg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextSearchbgKeyReleased(evt);
            }
        });
        jPanel1.add(jTextSearchbg);
        jTextSearchbg.setBounds(30, 200, 210, 50);

        searchAdd.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        searchAdd.setForeground(new java.awt.Color(255, 255, 255));
        searchAdd.setText("Search By Address");
        jPanel1.add(searchAdd);
        searchAdd.setBounds(30, 310, 210, 40);

        jTextSearchAdd.setFont(new java.awt.Font("Yu Gothic Medium", 0, 20)); // NOI18N
        jTextSearchAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSearchAddActionPerformed(evt);
            }
        });
        jTextSearchAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextSearchAddKeyReleased(evt);
            }
        });
        jPanel1.add(jTextSearchAdd);
        jTextSearchAdd.setBounds(30, 380, 210, 60);

        btnBack.setFont(new java.awt.Font("Yu Gothic Medium", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(153, 0, 0));
        btnBack.setText("Back To Menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(560, 530, 270, 40);

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(910, 530, 160, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icon4-removebg-preview (2).png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(40, 30, 70, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BgPic.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1155, 599);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextSearchbgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchbgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSearchbgActionPerformed

    private void jTextSearchAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSearchAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSearchAddActionPerformed

    private void jTextSearchbgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSearchbgKeyReleased
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) jTable1Plasma.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";

            Connection con = DriverManager.getConnection(url);

            String query = "select * from Plasma where blood_group LIKE '" + jTextSearchbg.getText() + "%'";

            System.out.println(query);
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String s[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                model.addRow(s);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jTextSearchbgKeyReleased

    private void jTextSearchAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSearchAddKeyReleased
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) jTable1Plasma.getModel();
        model.setRowCount(0);
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";

            Connection con = DriverManager.getConnection(url);

            String query = "select * from Plasma where donor_address LIKE '%" + jTextSearchAdd.getText() + "%'";

            System.out.println(query);
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String s[] = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
                model.addRow(s);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTextSearchAddKeyReleased

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
            java.util.logging.Logger.getLogger(PlasmaInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlasmaInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlasmaInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlasmaInformation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlasmaInformation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PlasmaTable;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelHeading;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable jTable1Plasma;
    private javax.swing.JTextField jTextSearchAdd;
    private javax.swing.JTextField jTextSearchbg;
    private javax.swing.JLabel searchAdd;
    private javax.swing.JLabel searchBg;
    // End of variables declaration//GEN-END:variables
}
