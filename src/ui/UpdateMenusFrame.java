//Author : Choo Yee Ling

package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import control.*;
import domain.*;
import java.util.ArrayList;

public class UpdateMenusFrame extends javax.swing.JFrame {

    private MaintainMenusControl maintainMenusControl = new MaintainMenusControl();
    private ArrayList<Menus> menus = null;
    private DefaultComboBoxModel model = new DefaultComboBoxModel();

    public UpdateMenusFrame() {

        initComponents();
        setTitle("Update Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        menus = maintainMenusControl.retrieveMenusRecordControl();
        for (int i = 0; i < menus.size(); i++) {
            model.addElement(menus.get(i).getFoodID());
        }

        jcbMenuID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String menuID = (String) jcbMenuID.getSelectedItem();
                Menus menu = maintainMenusControl.retrieveMenusRecordControl(menuID);
                double pricePerUnit = menu.getPricePerUnit();
                jtfFoodName.setText(menu.getFoodName());
                jcbCategory.setSelectedItem(menu.getCategory());
                jtaDescription.setText(menu.getDescription());
                jtfPrice.setText(String.format("%.2f", pricePerUnit));
                jcbStatus.setSelectedItem(menu.getStatus());

            }
        });

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String category = (String) jcbCategory.getSelectedItem();
                String foodID = (String) jcbMenuID.getSelectedItem();
                String status = (String) jcbStatus.getSelectedItem();
                String price = jtfPrice.getText();
                String foodName = jtfFoodName.getText();
                String description = jtaDescription.getText();
                boolean valid = validateInput(foodName, description, price);
                if (valid) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm to update?", "Update Menu", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        double pricePerUnit = Double.parseDouble(price);
                        Menus menu = new Menus(foodID, jtfFoodName.getText(), category, jtaDescription.getText(), pricePerUnit,
                                status);
                        maintainMenusControl.updateMenusRecordControl(menu);
                        JOptionPane.showMessageDialog(null, "Record successfully updated");
                        Reset();
                    }

                }
            }
        });

        jbtCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public boolean validateInput(String foodName, String description, String price) {
        if (foodName.equals("") || description.equals("") || price.equals("")) {
            JOptionPane.showMessageDialog(null, "Fields cannot be left blank.");
            jtfFoodName.requestFocusInWindow();
            return false;
        }
        if (!price.matches("\\d+([.,]\\d{1,2})?")) {
            JOptionPane.showMessageDialog(null, "Invalid price");
            jtfPrice.setText("");
            jtfPrice.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public void Reset() {
        jtfFoodName.setText("");
        jtaDescription.setText("");
        jtfPrice.setText("");
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
        jtfFoodName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaDescription = new javax.swing.JTextArea();
        jbtOk = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jtfPrice = new javax.swing.JTextField();
        jcbMenuID = new javax.swing.JComboBox(model);
        jcbCategory = new javax.swing.JComboBox();
        jlbStatus = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbFoodID.setText("Food ID");

        jlbFoodName.setText("Food Name");

        jlbCategory.setText("Category");

        jlbDescription.setText("Description");

        jlbPrice.setText(" Price (RM)");

        jtaDescription.setColumns(20);
        jtaDescription.setLineWrap(true);
        jtaDescription.setRows(5);
        jtaDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtaDescription);

        jbtOk.setText("Ok");

        jbtCancel.setText("Cancel");

        jcbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sushi", "Dessert", "Drinks" }));

        jlbStatus.setText("Status");

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Active", "Terminated" }));

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
                    .addComponent(jtfFoodName)
                    .addComponent(jtfPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jcbMenuID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtOk)
                        .addGap(18, 18, 18)
                        .addComponent(jbtCancel))
                    .addComponent(jcbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMenuID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCancel)
                    .addComponent(jbtOk))
                .addGap(50, 50, 50))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(UpdateMenusFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateMenusFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateMenusFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateMenusFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateMenusFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtOk;
    private javax.swing.JComboBox jcbCategory;
    private javax.swing.JComboBox jcbMenuID;
    private javax.swing.JComboBox jcbStatus;
    private javax.swing.JLabel jlbCategory;
    private javax.swing.JLabel jlbDescription;
    private javax.swing.JLabel jlbFoodID;
    private javax.swing.JLabel jlbFoodName;
    private javax.swing.JLabel jlbPrice;
    private javax.swing.JLabel jlbStatus;
    private javax.swing.JTextArea jtaDescription;
    private javax.swing.JTextField jtfFoodName;
    private javax.swing.JTextField jtfPrice;
    // End of variables declaration//GEN-END:variables
}
