
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer.login;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author tejas
 */
public class sports extends javax.swing.JFrame {
     Connection con=null;
    ResultSet rs=null;
    PreparedStatement pst=null;

    /**
     * Creates new form sports
     * @throws java.sql.SQLException
     */
    public sports() throws SQLException {
          initComponents();
        con = DriverManager.getConnection("jdbc:postgresql://localhost/tejas316","postgres","3098");
        fetch();
      
    }

    
      public final void fetch(){
   try{
   String q="select * from products where cat_id=3";
   pst=con.prepareStatement(q);
   rs=pst.executeQuery();
   
   jTable1.setModel(DbUtils.resultSetToTableModel(rs));
   }    catch (SQLException ex) {
            Logger.getLogger(grocery.class.getName()).log(Level.SEVERE, null, ex);
        }} 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 700));
        getContentPane().setLayout(null);

        jButton7.setText("back");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(680, 470, 55, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 30, 750, 402);

        jButton1.setText("ADD TO CART");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 460, 170, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/login/home_bg.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 524);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
         home_page mf = new home_page();
                mf.setVisible(true);
                mf.pack();
                mf.setLocationRelativeTo(null);
                this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     TableModel model1 =jTable1.getModel();
        int indexs[]=jTable1.getSelectedRows();
        Object [] row=new Object[7];
        orders or=new orders();
        DefaultTableModel model2=(DefaultTableModel) or.jTable2.getModel();
        for(int i=0;i<indexs.length;i++)
        {
            row[0]= model1.getValueAt(indexs[i],0);
            row[1]= model1.getValueAt(indexs[i],1);
            row[2]= model1.getValueAt(indexs[i],2);
            row[3]= model1.getValueAt(indexs[i],3);
            row[4]= model1.getValueAt(indexs[i],4);
            row[5]= model1.getValueAt(indexs[i],5);
            row[6]= model1.getValueAt(indexs[i],6);
            model2.addRow(row);
        }
    or.setVisible(true);
         int len=or.jTable2.getRowCount();
         
         for(int i = 0; i<len; i++)
  {   
      
    
            try {
                BigDecimal prod_id = (BigDecimal) or.jTable2.getValueAt(i, 0);
                String pname = (String) or.jTable2.getValueAt(i, 2);
                BigDecimal price = (BigDecimal) or.jTable2.getValueAt(i, 4);
                Integer gst = (Integer) or.jTable2.getValueAt(i, 5);
                Integer vat = (Integer) or.jTable2.getValueAt(i, 6);        
                String queryco = "Insert into orders(prod_id,pname,price,gst,vat) values ('"+prod_id+"','"+pname+"','"+price+"','"+gst+"','"+vat+"')";
                //j++;
                pst = con.prepareStatement(queryco);  
                
                pst.execute();
            } catch (SQLException ex) {
                Logger.getLogger(grocery.class.getName()).log(Level.SEVERE, null, ex);
            }
  }
  JOptionPane.showMessageDialog(null, "Successfully Save");
    // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(sports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new sports().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(sports.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
