package ui;

import control.*;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;

public class NotUsingPointFrame extends javax.swing.JFrame {

    private Customer cust;
    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    private MaintainOrdersControl maintainOrdersControl = new MaintainOrdersControl();
    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private Payment payment = null;
    double totalAmount2 = 0;
    String paymentMethod = "";
    private final double DISCOUNT = 0.1;
    private final double GST = 0.06;

    public NotUsingPointFrame(String transactionID, Customer customer, Staff staff, double totalAmount, double temp, String orderID,
            int seatNumber,ArrayList<Food> foodRecord) {
        initComponents();
        totalAmount2 = temp;
        cust = customer;
        jbtGenerateReceipt.setEnabled(false);
        jtfInitialPointBalance.setEditable(false);
        jtfInitialPointBalance.setText(String.valueOf(cust.getLoyaltyPointBalance()));
        jtfLoyaltyPointUsed.setEditable(false);
        jtfLoyaltyPointUsed.setText("0");
        jtfLoyaltyPointAmount.setEditable(false);
        jtfLoyaltyPointAmount.setText("0");
        jtfGrandTotal.setEditable(false);
        jtfGrandTotal.setText(String.format("RM %.2f", totalAmount2));
        jtfLoyaltyPointEarned.setEditable(false);
        double loyaltyPointEarned = totalAmount2 / 0.1;
        jtfLoyaltyPointEarned.setText(String.valueOf((int) loyaltyPointEarned));
        jtfNewLoyaltyPointBalance.setEditable(false);
        int newLoyaltyPointBalance = cust.getLoyaltyPointBalance() + (int) loyaltyPointEarned;
        jtfNewLoyaltyPointBalance.setText(String.valueOf(newLoyaltyPointBalance));

        ButtonGroup bgPaymentMethod = new ButtonGroup();
        bgPaymentMethod.add(jrbCash);
        bgPaymentMethod.add(jrbCreditCard);

        jrbCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentMethod = "Cash";
                jbtGenerateReceipt.setEnabled(true);
            }
        });

        jrbCreditCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentMethod = "CreditCard";
                jbtGenerateReceipt.setEnabled(true);
            }
        });

        jbtGenerateReceipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String pointUsed = jtfLoyaltyPointUsed.getText();
                int initialLoyaltyPointBalance = cust.getLoyaltyPointBalance();
                int loyaltyPointUsed = Integer.parseInt(pointUsed);
                double loyaltyPointAmount = Double.parseDouble(jtfLoyaltyPointAmount.getText());

                int option = JOptionPane.showConfirmDialog(null, "Confirm to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    Orders orders = maintainOrdersControl.retrieveOrdersRecordControl(orderID);
                    payment = new Payment(transactionID, customer, staff, orders, paymentMethod, DISCOUNT, totalAmount, GST, totalAmount2,
                            totalAmount2, loyaltyPointUsed, loyaltyPointAmount, (int) loyaltyPointEarned);
                    maintainTransactionControl.createTransactionRecordControl(payment);
                    maintainCustomerControl.updateCustomerRecordControl(customer.getCustomerID(),newLoyaltyPointBalance);
                    maintainSeatControl.updateSeatAvailabilityControl(seatNumber);
                    dispose();
                    if(paymentMethod.equals("Cash")){
                        new CashFrame(totalAmount2,foodRecord,transactionID);
                    }
                    else{
                        new CreditCardFrame(totalAmount2,foodRecord,transactionID);
                    }
                }

            }
        });

        setTitle("Not Using Point");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbLoyaltyPointUsed = new javax.swing.JLabel();
        jlbGrandTotal = new javax.swing.JLabel();
        jtfLoyaltyPointUsed = new javax.swing.JTextField();
        jbtGenerateReceipt = new javax.swing.JButton();
        jlbLoyaltyPointEarned = new javax.swing.JLabel();
        jtfGrandTotal = new javax.swing.JTextField();
        jlbSeatAvailability = new javax.swing.JLabel();
        jtfLoyaltyPointEarned = new javax.swing.JTextField();
        jtfLoyaltyPointAmount = new javax.swing.JTextField();
        jlbLoyaltyPointEarned1 = new javax.swing.JLabel();
        jrbCash = new javax.swing.JRadioButton();
        jrbCreditCard = new javax.swing.JRadioButton();
        jlbInitialPointBalance = new javax.swing.JLabel();
        jtfInitialPointBalance = new javax.swing.JTextField();
        jlbInitialPointBalance1 = new javax.swing.JLabel();
        jtfNewLoyaltyPointBalance = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Not Using Point", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbLoyaltyPointUsed.setText("Loyalty Point To Be Used");

        jlbGrandTotal.setText("Grand Total To Be Paid");

        jbtGenerateReceipt.setText("Generate Receipt");

        jlbLoyaltyPointEarned.setText("Loyalty Point Earned");

        jlbSeatAvailability.setText("Loyalty Point Amount");

        jlbLoyaltyPointEarned1.setText("Payment Method");

        jrbCash.setText("Cash");

        jrbCreditCard.setText("Credit Card");

        jlbInitialPointBalance.setText("Current Loyalty Point Balance");

        jlbInitialPointBalance1.setText("New Loyalty Point Balance");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlbLoyaltyPointEarned1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbSeatAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbLoyaltyPointUsed, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(jlbGrandTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbLoyaltyPointEarned, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbInitialPointBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfLoyaltyPointEarned, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jtfLoyaltyPointAmount, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfLoyaltyPointUsed, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfGrandTotal)
                            .addComponent(jtfInitialPointBalance, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNewLoyaltyPointBalance))
                        .addGap(123, 123, 123))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtGenerateReceipt)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbCash)
                                .addGap(26, 26, 26)
                                .addComponent(jrbCreditCard)))
                        .addGap(110, 110, 110))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jlbInitialPointBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbInitialPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfInitialPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLoyaltyPointUsed, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLoyaltyPointUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSeatAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLoyaltyPointAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLoyaltyPointEarned, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLoyaltyPointEarned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbInitialPointBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNewLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLoyaltyPointEarned1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jrbCash)
                    .addComponent(jrbCreditCard))
                .addGap(18, 18, 18)
                .addComponent(jbtGenerateReceipt)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(NotUsingPointFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotUsingPointFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotUsingPointFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotUsingPointFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtGenerateReceipt;
    private javax.swing.JLabel jlbGrandTotal;
    private javax.swing.JLabel jlbInitialPointBalance;
    private javax.swing.JLabel jlbInitialPointBalance1;
    private javax.swing.JLabel jlbLoyaltyPointEarned;
    private javax.swing.JLabel jlbLoyaltyPointEarned1;
    private javax.swing.JLabel jlbLoyaltyPointUsed;
    private javax.swing.JLabel jlbSeatAvailability;
    private javax.swing.JRadioButton jrbCash;
    private javax.swing.JRadioButton jrbCreditCard;
    private javax.swing.JTextField jtfGrandTotal;
    private javax.swing.JTextField jtfInitialPointBalance;
    private javax.swing.JTextField jtfLoyaltyPointAmount;
    private javax.swing.JTextField jtfLoyaltyPointEarned;
    private javax.swing.JTextField jtfLoyaltyPointUsed;
    private javax.swing.JTextField jtfNewLoyaltyPointBalance;
    // End of variables declaration//GEN-END:variables
}
