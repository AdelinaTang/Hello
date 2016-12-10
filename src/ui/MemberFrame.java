package ui;

import control.*;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class MemberFrame extends javax.swing.JFrame {

    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    private ArrayList<Customer> customerRecord = null;
    private Customer customer = null;
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private final double DISCOUNT = 0.1;
    private final double GST = 0.06;
    double total = 0;
    double temp = 0;
    String transactionID = "";

    public MemberFrame(double totalAmount, String orderID, Staff staff, int seatNumber, ArrayList<Food> foodRecord) {
        initComponents();
        jbtYes.setEnabled(false);
        jbtNo.setEnabled(false);
        transactionID = generateTransactionID();
        jtfTransactionID.setText(transactionID);
        customerRecord = maintainCustomerControl.retrieveCustomerRecordControl();
        for (int i = 0; i < customerRecord.size(); i++) {
            if (customerRecord.get(i).getStatus().equals("Active")) {
                model.addElement(customerRecord.get(i).getCustomerID());
            }
        }

        jtfTotalPrice.setText(String.format("RM %.2f", totalAmount));
        jtfDiscount.setText(String.valueOf(DISCOUNT));
        jtfGST.setText(String.valueOf(GST));
        total = (totalAmount * (1 - DISCOUNT)) * (1 + GST);
        temp = total;
        jtfTotal.setText(String.format("RM %.2f", total));
        jtfTotalPrice.setEditable(false);
        jtfDiscount.setEditable(false);
        jtfGST.setEditable(false);
        jtfTotal.setEditable(false);
        jtfLoyaltyPointBalance.setEditable(false);

        jcbCustomerID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerID = (String) jcbCustomerID.getSelectedItem();
                customer = maintainCustomerControl.retrieveCustomerRecordControl(customerID);
                jtfLoyaltyPointBalance.setText(String.valueOf(customer.getLoyaltyPointBalance()));
                jtfLoyaltyPointBalance.setEditable(false);
                jbtYes.setEnabled(true);
                jbtNo.setEnabled(true);
            }

        });

        jbtYes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int option = JOptionPane.showConfirmDialog(null, "Confirm to use point?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    dispose();
                    //new UsePointFrame(transactionID, customer, staff, totalAmount, temp, orderID, seatNumber, foodRecord);
                }

            }
        });

        jbtNo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int option = JOptionPane.showConfirmDialog(null, "Confirm to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    dispose();
                    new NotUsingPointFrame(transactionID, customer, staff, totalAmount, temp, orderID, seatNumber, foodRecord);
                }

            }
        });

        setTitle("Member");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String generateTransactionID() {

        String transactionID = maintainTransactionControl.getLatestIDControl();
        if (transactionID.equals("")) {
            transactionID = "O000";
        }
        int lastThreeDigit = Integer.parseInt(transactionID.substring(1, 4));
        String incrementedTransactionID = String.format("T%03d", (lastThreeDigit + 1));
        jtfTransactionID.setEditable(false);
        jtfTransactionID.setText(incrementedTransactionID);
        return incrementedTransactionID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbCustomerID = new javax.swing.JLabel();
        jlbDiscount = new javax.swing.JLabel();
        jlbGST = new javax.swing.JLabel();
        jlbTotal = new javax.swing.JLabel();
        jtfDiscount = new javax.swing.JTextField();
        jtfGST = new javax.swing.JTextField();
        jtfTotal = new javax.swing.JTextField();
        jtfLoyaltyPointBalance = new javax.swing.JTextField();
        jlbLoyaltyPointBalance = new javax.swing.JLabel();
        jtfTotalPrice = new javax.swing.JTextField();
        jlbTotalPrice = new javax.swing.JLabel();
        jcbCustomerID = new javax.swing.JComboBox(model);
        jlbTransactionID = new javax.swing.JLabel();
        jtfTransactionID = new javax.swing.JTextField();
        jlbUsePoint = new javax.swing.JLabel();
        jbtYes = new javax.swing.JButton();
        jbtNo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbCustomerID.setText("Customer ID");

        jlbDiscount.setText("Discount");

        jlbGST.setText("GST");

        jlbTotal.setText("Total");

        jlbLoyaltyPointBalance.setText("Loyalty Point Balance");

        jlbTotalPrice.setText("Total price");

        jlbTransactionID.setText("Transaction ID");

        jlbUsePoint.setText("Use Point?");

        jbtYes.setText("Yes");

        jbtNo.setText("No");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbGST, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(92, 92, 92))
                        .addComponent(jlbTotalPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbUsePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfTransactionID)
                    .addComponent(jtfDiscount)
                    .addComponent(jtfGST)
                    .addComponent(jtfTotal)
                    .addComponent(jtfLoyaltyPointBalance)
                    .addComponent(jtfTotalPrice)
                    .addComponent(jcbCustomerID, javax.swing.GroupLayout.Alignment.TRAILING, 0, 243, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtYes)
                        .addGap(37, 37, 37)
                        .addComponent(jbtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbGST, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGST, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbUsePoint, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtYes)
                    .addComponent(jbtNo))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtNo;
    private javax.swing.JButton jbtYes;
    private javax.swing.JComboBox jcbCustomerID;
    private javax.swing.JLabel jlbCustomerID;
    private javax.swing.JLabel jlbDiscount;
    private javax.swing.JLabel jlbGST;
    private javax.swing.JLabel jlbLoyaltyPointBalance;
    private javax.swing.JLabel jlbTotal;
    private javax.swing.JLabel jlbTotalPrice;
    private javax.swing.JLabel jlbTransactionID;
    private javax.swing.JLabel jlbUsePoint;
    private javax.swing.JTextField jtfDiscount;
    private javax.swing.JTextField jtfGST;
    private javax.swing.JTextField jtfLoyaltyPointBalance;
    private javax.swing.JTextField jtfTotal;
    private javax.swing.JTextField jtfTotalPrice;
    private javax.swing.JTextField jtfTransactionID;
    // End of variables declaration//GEN-END:variables
}
