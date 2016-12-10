package ui;

import control.*;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class NonMemberFrame extends javax.swing.JFrame {

    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private MaintainOrdersControl maintainOrdersControl = new MaintainOrdersControl();
    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private Payment payment = null;
    private final double GST = 0.06;
    String transactionID = "";
    String paymentMethod = "";

    public NonMemberFrame(double totalAmount,String orderID,Staff staff,int seatNumber,ArrayList<Food> foodRecord) {
        initComponents();
        
        transactionID = generateTransactionID();
        jtfTransactionID.setText(transactionID);
        jtfTotalPrice.setEditable(false);
        jtfTotalPrice.setText(String.format("RM %.2f", totalAmount));
        jtfGST.setText(String.valueOf(GST));
        jtfGST.setEditable(false);
        double grandTotal = totalAmount * (1 + GST);
        jtfGrandTotal.setText(String.format("RM %.2f", grandTotal));
        jtfGrandTotal.setEditable(false);
        jbtGenerateReceipt1.setEnabled(false);

        ButtonGroup bgPaymentMethod = new ButtonGroup();
        bgPaymentMethod.add(jrbCash);
        bgPaymentMethod.add(jrbCreditCard);
        
        jrbCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentMethod = "Cash";
                jbtGenerateReceipt1.setEnabled(true);
            }
        });

        jrbCreditCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentMethod = "CreditCard";
                jbtGenerateReceipt1.setEnabled(true);
            }
        });
        
        jbtGenerateReceipt1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int option = JOptionPane.showConfirmDialog(null, "Confirm to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    
                    Customer customer = new Customer(null,"","","","","","","","",0,"","");
                    Orders orders = maintainOrdersControl.retrieveOrdersRecordControl(orderID);
                    payment = new Payment(transactionID, customer, staff, orders, paymentMethod, 0.00, totalAmount, GST, grandTotal,
                            grandTotal, 0, 0.00,0);
                    maintainTransactionControl.createTransactionRecordControl(payment);
                    maintainSeatControl.updateSeatAvailabilityControl(seatNumber);
                    dispose();
                     if(paymentMethod.equals("Cash")){
                        new CashFrame(grandTotal,foodRecord,transactionID);
                    }
                    else{
                        new CreditCardFrame(grandTotal,foodRecord,transactionID);
                    }
                }

            }
        });

        setTitle("Non Member");
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

        jbtGenerateReceipt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlbGST = new javax.swing.JLabel();
        jlbGrandTotal = new javax.swing.JLabel();
        jtfGST = new javax.swing.JTextField();
        jtfGrandTotal = new javax.swing.JTextField();
        jtfTotalPrice = new javax.swing.JTextField();
        jlbTotalPrice = new javax.swing.JLabel();
        jlbTransactionID = new javax.swing.JLabel();
        jtfTransactionID = new javax.swing.JTextField();
        jlbLoyaltyPointEarned1 = new javax.swing.JLabel();
        jrbCash = new javax.swing.JRadioButton();
        jrbCreditCard = new javax.swing.JRadioButton();
        jbtGenerateReceipt1 = new javax.swing.JButton();

        jbtGenerateReceipt.setText("Generate Receipt");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Non Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbGST.setText("GST");

        jlbGrandTotal.setText("Grand Total To Be Paid");

        jlbTotalPrice.setText("Total price");

        jlbTransactionID.setText("Transaction ID");

        jlbLoyaltyPointEarned1.setText("Payment Method");

        jrbCash.setText("Cash");

        jrbCreditCard.setText("Credit Card");

        jbtGenerateReceipt1.setText("Generate Receipt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlbLoyaltyPointEarned1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbTransactionID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTotalPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbGST, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtGenerateReceipt1)
                    .addComponent(jtfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGST, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jrbCash)
                        .addGap(39, 39, 39)
                        .addComponent(jrbCreditCard)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTransactionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbGST, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jlbGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jrbCash)
                        .addComponent(jrbCreditCard))
                    .addComponent(jlbLoyaltyPointEarned1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtGenerateReceipt1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(NonMemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NonMemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NonMemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NonMemberFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtGenerateReceipt;
    private javax.swing.JButton jbtGenerateReceipt1;
    private javax.swing.JLabel jlbGST;
    private javax.swing.JLabel jlbGrandTotal;
    private javax.swing.JLabel jlbLoyaltyPointEarned1;
    private javax.swing.JLabel jlbTotalPrice;
    private javax.swing.JLabel jlbTransactionID;
    private javax.swing.JRadioButton jrbCash;
    private javax.swing.JRadioButton jrbCreditCard;
    private javax.swing.JTextField jtfGST;
    private javax.swing.JTextField jtfGrandTotal;
    private javax.swing.JTextField jtfTotalPrice;
    private javax.swing.JTextField jtfTransactionID;
    // End of variables declaration//GEN-END:variables
}
