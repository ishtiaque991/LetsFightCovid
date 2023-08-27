/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letsfightcovid;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Asus
 */
public class PaymentSlip extends javax.swing.JFrame {

    /**
     * Creates new form PaymentSlip
     */
    public PaymentSlip() {
        initComponents();
        show_user();
    }
    
    
     public ArrayList<UserPayment> userList() {
        ArrayList<UserPayment> userList = new ArrayList<>();

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Covid;user=sa;password=covid12345";

            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT * FROM Payment WHERE ID=(SELECT max(ID) FROM Payment)";
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePay = new javax.swing.JTable();
        btnPDF = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Payment Slip");

        jTablePay.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jTablePay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Subtotal", "Paid", "Exchange"
            }
        ));
        jScrollPane1.setViewportView(jTablePay);

        btnPDF.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnPDF.setText("Generate PDF");
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 81, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        // TODO add your handling code here:
        String path="";
        JFileChooser j=new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x= j.showSaveDialog(this);
        
        if(x==JFileChooser.APPROVE_OPTION){
            path=j.getSelectedFile().getPath();
        
        }
         Document doc = new Document();
         
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path+"PaymentSlip.pdf"));
            
            doc.open();
            
            PdfPTable tbl = new PdfPTable(4);
            
            tbl.addCell("ID");
            tbl.addCell("Subtotal");
            tbl.addCell("Paid");
            tbl.addCell("Exchange");
            
            for(int i=0;i<jTablePay.getRowCount();i++){
                String ID = jTablePay.getValueAt(i, 0).toString();
                String subtotal = jTablePay.getValueAt(i, 1).toString();
                String pay = jTablePay.getValueAt(i, 2).toString();
                String bal = jTablePay.getValueAt(i, 3).toString();
                
                tbl.addCell(ID);
                 tbl.addCell(subtotal);
                  tbl.addCell(pay);
                   tbl.addCell(bal);
            
            }
            doc.add(tbl);
            
            JOptionPane.showMessageDialog(null,"Downloaded PDF File","ALERT MESSAGE",JOptionPane.WARNING_MESSAGE);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PaymentSlip.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(PaymentSlip.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        doc.close();
    }//GEN-LAST:event_btnPDFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Menu2 m = new Menu2();
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
            java.util.logging.Logger.getLogger(PaymentSlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentSlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentSlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentSlip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentSlip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePay;
    // End of variables declaration//GEN-END:variables
}
