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
public class admPayment extends javax.swing.JFrame {

    /**
     * Creates new form admPayment
     */
    public admPayment() {
        initComponents();
        show_user();
    }

    public ArrayList<UserPayment> userList() {
        ArrayList<UserPayment> userList = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";

            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT * FROM Payment";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            UserPayment user;
            while (rs.next()) {
                user = new UserPayment(rs.getInt("ID"), rs.getInt("subtotal"), rs.getInt("pay"), rs.getInt("bal"));
                userList.add(user);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
        return userList;
    }
     
     
     public void show_user() {
        ArrayList<UserPayment> list = userList();
       DefaultTableModel model = (DefaultTableModel)jTablePay.getModel();
        Object[] row = new Object[5];

        for (int i = 0; i < list.size(); i++) {

            row[0] = list.get(i).getID();
            row[1] = list.get(i). getSubtotal();
            row[2] = list.get(i).getPay();
            row[3] = list.get(i).getBal();
            
           
            model.addRow(row);

        }
        
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblheading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePay = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        lblheading.setFont(new java.awt.Font("Algerian", 0, 38)); // NOI18N
        lblheading.setForeground(new java.awt.Color(255, 255, 255));
        lblheading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblheading.setText("Payment Data");
        jPanel1.add(lblheading);
        lblheading.setBounds(360, 20, 430, 80);

        jTablePay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Subtotal", "Paid", "Exchange"
            }
        ));
        jScrollPane1.setViewportView(jTablePay);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(350, 110, 452, 402);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 0));
        jButton1.setText("Back To Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(80, 515, 160, 50);

        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 153));
        jButton2.setText("Delete Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(840, 520, 160, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BgPic.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1150, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";
            
            Connection con = DriverManager.getConnection(url);
            int row = jTablePay.getSelectedRow();
            String value =(jTablePay.getModel().getValueAt(row, 0).toString());
            String query1 = "DELETE FROM Payment WHERE ID="+value;
            PreparedStatement pst =con.prepareStatement(query1);
            pst.executeUpdate();
            
            DefaultTableModel model=(DefaultTableModel)jTablePay.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
            
         } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         MenuAdm m = new MenuAdm();
        m.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(admPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admPayment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePay;
    private javax.swing.JLabel lblheading;
    // End of variables declaration//GEN-END:variables
}
