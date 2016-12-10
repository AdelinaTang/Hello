package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;

public class FoodClick extends javax.swing.JFrame {

    private MaintainMenusControl maintainMenusControl = new MaintainMenusControl();
    private ArrayList<Menus> readMenu = maintainMenusControl.retrieveMenusRecordControl();
    

    public FoodClick() {
    }
    
    public FoodClick(Menus menu){
        initComponents();
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        jtfFoodID.setText(menu.getFoodID());
        jtfFoodName.setText(menu.getFoodName());
        jtfCategory.setText(menu.getCategory());
        jtaDescription.setText(menu.getDescription());
        jtfPrice.setText(String.format("RM %.2f",menu.getPricePerUnit()));
        jtfStatus.setText(menu.getStatus());
        jtfFoodID.setEditable(false);
        jtfFoodName.setEditable(false);
        jtfCategory.setEditable(false);
        jtaDescription.setEditable(false);
        jtfPrice.setEditable(false);
        jtfStatus.setEditable(false);
        
        
        jbtOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
    }
    
    public FoodClick(int i) {
        initComponents();
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        jtfFoodID.setText(readMenu.get(i).getFoodID());
        jtfFoodName.setText(readMenu.get(i).getFoodName());
        jtfCategory.setText(readMenu.get(i).getCategory());
        jtaDescription.setText(readMenu.get(i).getDescription());
        jtfPrice.setText(String.format("RM %.2f",readMenu.get(i).getPricePerUnit()));
        jtfStatus.setText(readMenu.get(i).getStatus());
        jtfFoodID.setEditable(false);
        jtfFoodName.setEditable(false);
        jtfCategory.setEditable(false);
        jtaDescription.setEditable(false);
        jtfPrice.setEditable(false);
        jtfStatus.setEditable(false);
        
        
        jbtOk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });
    
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbFoodID = new javax.swing.JLabel();
        jlbFoodName = new javax.swing.JLabel();
        jlbCategory = new javax.swing.JLabel();
        jlbDescription = new javax.swing.JLabel();
        jlbPrice = new javax.swing.JLabel();
        jtfFoodID = new javax.swing.JTextField();
        jtfFoodName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescription = new javax.swing.JTextArea();
        jbtOk = new javax.swing.JButton();
        jtfPrice = new javax.swing.JTextField();
        jtfCategory = new javax.swing.JTextField();
        jlbStatus = new javax.swing.JLabel();
        jtfStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbFoodID.setText("Food ID");

        jlbFoodName.setText("Food Name");

        jlbCategory.setText("Category");

        jlbDescription.setText("Description");

        jlbPrice.setText("Price");

        jtaDescription.setColumns(20);
        jtaDescription.setLineWrap(true);
        jtaDescription.setRows(5);
        jtaDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtaDescription);

        jbtOk.setText("Ok");

        jlbStatus.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfFoodID)
                    .addComponent(jtfFoodName)
                    .addComponent(jtfPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jtfCategory)
                    .addComponent(jtfStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtOk)
                .addGap(166, 166, 166))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtOk)
                .addGap(70, 70, 70))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(FoodClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FoodClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FoodClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FoodClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FoodClick().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtOk;
    private javax.swing.JLabel jlbCategory;
    private javax.swing.JLabel jlbDescription;
    private javax.swing.JLabel jlbFoodID;
    private javax.swing.JLabel jlbFoodName;
    private javax.swing.JLabel jlbPrice;
    private javax.swing.JLabel jlbStatus;
    private javax.swing.JTextArea jtaDescription;
    private javax.swing.JTextField jtfCategory;
    private javax.swing.JTextField jtfFoodID;
    private javax.swing.JTextField jtfFoodName;
    private javax.swing.JTextField jtfPrice;
    private javax.swing.JTextField jtfStatus;
    // End of variables declaration//GEN-END:variables
}
