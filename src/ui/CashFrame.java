package ui;

import control.*;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Math.ceil;
import javax.swing.border.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CashFrame extends javax.swing.JFrame {

    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private MaintainFoodControl maintainFoodControl = new MaintainFoodControl();
    private Payment py = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date dateObj = new Date();
    String date = dateFormat.format(dateObj);
    String s = "";
    String status = "";
    double money = 0.00;
    double change = 0.00;

    public CashFrame(double grandTotal, ArrayList<Food> foodRecord, String transactionID) {
        initComponents();

        py = maintainTransactionControl.retrieveTransactionRecordControl(transactionID);
        if (!(py.getCustomer().getCustomerID() == null)) {
            status = "member";
        } else {
            status = "nonmember";
        }

        jtfGrandTotal.setEditable(false);
        jtfGrandTotal.setText(String.format("RM %.2f", grandTotal));
        jtfChange.setEditable(false);
        jbtOk.setEnabled(false);

        jtfCashAmount.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cash = jtfCashAmount.getText();
                money = Double.parseDouble(cash);
                boolean valid = validateInput(cash, grandTotal);

                if (valid) {
                    change = Double.parseDouble(cash) - grandTotal;
                    System.out.println(change);
                    jtfChange.setText(String.format("RM %.2f", change));
                    jbtOk.setEnabled(true);
                }

            }
        });

        jbtGenerateChange.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cash = jtfCashAmount.getText();
                money = Double.parseDouble(cash);
                boolean valid = validateInput(cash, grandTotal);
                if (valid) {
                    change = Double.parseDouble(cash) - grandTotal;
                    jtfChange.setText(String.format("RM %.2f", change));
                    jbtOk.setEnabled(true);
                }
            }
        });

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Receipt successfully generated");
                dispose();
                Payment payment = maintainTransactionControl.retrieveTransactionRecordControl(transactionID);
                ArrayList<Food> food = maintainFoodControl.retrieveFoodRecordControl(payment.getOrders().getOrderID());

                if (status.equals("member")) {
                    try {
                        fileForMember(payment, food, money, change);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    try {
                        fileForNonMember(payment, food, money, change);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }

        });

        setTitle("Paid By Cash");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    public void fileForMember(Payment payment, ArrayList<Food> food, double money, double change) throws IOException {
        String a = "";
        File file = new File("cash.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("\t\t\t\tWilson's Cafe");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t    WILSON'S CAFE (SETAPAK)");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t       SDN.BHD (1018028.W)");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t      JALAN GENTING KELANG");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t   53300 SETAPAK KL, MALAYSIA");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t\tTEL : 011-1421-7017");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t   GST REG NO : 001940439040");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        String header = "";
        if (payment.getStaff().getFirstName().equals("Manager")) {
            header = "User : ";
        } else {
            header = "Staff Name : ";
        }
        bufferedWriter.write("\t" + header);
        bufferedWriter.write(payment.getStaff().getFirstName());
        bufferedWriter.newLine();
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.write("\t" + date);
        bufferedWriter.write("\t\t\t       Trans ID : ");
        bufferedWriter.write(payment.getTransactionID());
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        String help = String.format("\t%-25s%-10s%-17s%8s", "Food", "Quantity", "Price per Unit", "Amount(RM)");
        bufferedWriter.write(help);
        bufferedWriter.newLine();
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        for (int i = 0; i < food.size(); i++) {
            String pricePerUnit = String.format("%.2f", food.get(i).getMenu().getPricePerUnit());
            String amount = String.format("%.2f", food.get(i).getQuantity() * food.get(i).getMenu().getPricePerUnit());
            a = String.format("\t%-24s%5s%20s%12s", food.get(i).getMenu().getFoodName(), food.get(i).getQuantity(),
                    pricePerUnit, amount);
            bufferedWriter.write(a);
            bufferedWriter.newLine();
        }
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.write("\tTotal price\t\t\t\t\t     ");
        String totalPriceBD = String.format("%.2f", payment.getTotalPriceBD());
        String totalPriceBDAlign = String.format("%8s", totalPriceBD);
        bufferedWriter.write(totalPriceBDAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tDiscount\t\t\t\t\t     ");
        String discount = String.format("%.2f", payment.getDiscount());
        String discountAlign = String.format("%8s", discount);
        bufferedWriter.write(discountAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tGST\t\t\t\t\t\t     ");
        String gst = String.format("%.2f", payment.getTax());
        String gstAlign = String.format("%8s", gst);
        bufferedWriter.write(gstAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tTotal\t\t\t\t\t\t     ");
        String totalPriceAD = String.format("%.2f", payment.getTotalPriceAD());
        String totalPriceADAlign = String.format("%8s", totalPriceAD);
        bufferedWriter.write(totalPriceADAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tLoyalty point used\t\t\t\t     ");
        String loyaltyPointUsed = String.format("%d", payment.getLoyaltyPointUsed());
        String loyaltyPointUsedAlign = String.format("%8s", loyaltyPointUsed);
        bufferedWriter.write(loyaltyPointUsedAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tLoyalty point amount\t\t\t\t     ");
        String loyaltyPointAmount = String.format("%.2f", payment.getLoyaltyPointAmount());
        String loyaltyPointAmountAlign = String.format("%8s", loyaltyPointAmount);
        bufferedWriter.write(loyaltyPointAmountAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tLoyalty point balance\t\t\t\t     ");
        String loyaltyPointBalance = String.format("%d", payment.getCustomer().getLoyaltyPointBalance());
        String loyaltyPointBalanceAlign = String.format("%8s", loyaltyPointBalance);
        bufferedWriter.write(loyaltyPointBalanceAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tLoyalty point earned\t\t\t\t     ");
        String loyaltyPointEarned = String.format("%d", payment.getLoyaltyPointEarned());
        String loyaltyPointEarnedAlign = String.format("%8s", loyaltyPointEarned);
        bufferedWriter.write(loyaltyPointEarnedAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tGRAND TOTAL to be paid\t\t\t\t     ");
        String grandTotal = String.format("%.2f", payment.getGrandTotal());
        String grandTotalAlign = String.format("%8s", grandTotal);
        bufferedWriter.write(grandTotalAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tCASH\t\t\t\t\t\t     ");
        String cash = String.format("%.2f", money);
        String cashAlign = String.format("%8s", cash);
        bufferedWriter.write(cashAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tCHANGE\t\t\t\t\t\t     ");
        String chg = String.format("%.2f", change);
        String chgAlign = String.format("%8s", chg);
        bufferedWriter.write(chgAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t\t  THANK YOU");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t       Please come again");
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public void fileForNonMember(Payment payment, ArrayList<Food> food, double money, double change) throws IOException {
        String a = "";
        File file = new File("cash.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        bufferedWriter.write("\t\t\t\tWilson's Cafe");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t    WILSON'S CAFE (SETAPAK)");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t       SDN.BHD (1018028.W)");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t      JALAN GENTING KELANG");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t   53300 SETAPAK KL, MALAYSIA");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t\tTEL : 011-1421-7017");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t   GST REG NO : 001940439040");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        String header = "";
        if (payment.getStaff().getFirstName().equals("Manager")) {
            header = "User : ";
        } else {
            header = "Staff Name : ";
        }
        bufferedWriter.write("\t" + header);
        bufferedWriter.write(payment.getStaff().getFirstName());
        bufferedWriter.newLine();
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.write("\t" + date);
        bufferedWriter.write("\t\t\t       Trans ID : ");
        bufferedWriter.write(payment.getTransactionID());
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        String help = String.format("\t%-25s%-10s%-17s%8s", "Food", "Quantity", "Price per Unit", "Amount(RM)");
        bufferedWriter.write(help);
        bufferedWriter.newLine();
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        for (int i = 0; i < food.size(); i++) {
            String pricePerUnit = String.format("%.2f", food.get(i).getMenu().getPricePerUnit());
            String amount = String.format("%.2f", food.get(i).getQuantity() * food.get(i).getMenu().getPricePerUnit());
            a = String.format("\t%-24s%5s%20s%12s", food.get(i).getMenu().getFoodName(), food.get(i).getQuantity(),
                    pricePerUnit, amount);
            bufferedWriter.write(a);
            bufferedWriter.newLine();
        }
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.write("\tTotal price\t\t\t\t\t    ");
        String totalPriceBD = String.format("%.2f", payment.getTotalPriceBD());
        String totalPriceBDAlign = String.format("%9s", totalPriceBD);
        bufferedWriter.write(totalPriceBDAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tGST\t\t\t\t\t\t    ");
        String gst = String.format("%.2f", payment.getTax());
        String gstAlign = String.format("%9s", gst);
        bufferedWriter.write(gstAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tTotal\t\t\t\t\t\t    ");
        String totalPriceAD = String.format("%.2f", payment.getTotalPriceAD());
        String totalPriceADAlign = String.format("%9s", totalPriceAD);
        bufferedWriter.write(totalPriceADAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tGRAND TOTAL to be paid\t\t\t\t    ");
        String grandTotal = String.format("%.2f", payment.getGrandTotal());
        String grandTotalAlign = String.format("%9s", grandTotal);
        bufferedWriter.write(grandTotalAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tCASH\t\t\t\t\t\t    ");
        String cash = String.format("%.2f", money);
        String cashAlign = String.format("%9s", cash);
        bufferedWriter.write(cashAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\tCHANGE\t\t\t\t\t\t    ");
        String chg = String.format("%.2f", change);
        String chgAlign = String.format("%9s", chg);
        bufferedWriter.write(chgAlign);
        bufferedWriter.newLine();
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t\t  THANK YOU");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t       Please come again");
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public boolean validateInput(String cash, double grandTotal) {
        if (cash.equals("")) {
            JOptionPane.showMessageDialog(null, "Field should not be left empty");
            jtfCashAmount.requestFocusInWindow();
            return false;

        }

        if (!cash.matches("\\d+([.,]\\d{1,2})?")) {
            JOptionPane.showMessageDialog(null, "Invalid cash amount");
            jtfCashAmount.setText("");
            jtfCashAmount.requestFocusInWindow();
            return false;
        }

        if (Double.parseDouble(cash) < grandTotal) {
            JOptionPane.showMessageDialog(null, "Not enough cash!");
            jtfCashAmount.setText("");
            jtfCashAmount.requestFocusInWindow();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbCashAmount = new javax.swing.JLabel();
        jtfCashAmount = new javax.swing.JTextField();
        jbtOk = new javax.swing.JButton();
        jtfChange = new javax.swing.JTextField();
        jlbChange = new javax.swing.JLabel();
        jbtGenerateChange = new javax.swing.JButton();
        jlbGrandTotal = new javax.swing.JLabel();
        jtfGrandTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paid By Cash", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbCashAmount.setText("Cash Amount");

        jbtOk.setText("Ok");

        jlbChange.setText("Change");

        jbtGenerateChange.setText("Generate Change");

        jlbGrandTotal.setText("Grand Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbCashAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfCashAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbChange, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jbtOk, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 48, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jtfChange)))))
                .addGap(18, 18, 18)
                .addComponent(jbtGenerateChange)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCashAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCashAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtGenerateChange))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbChange, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtOk)
                .addContainerGap(25, Short.MAX_VALUE))
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
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtGenerateChange;
    private javax.swing.JButton jbtOk;
    private javax.swing.JLabel jlbCashAmount;
    private javax.swing.JLabel jlbChange;
    private javax.swing.JLabel jlbGrandTotal;
    private javax.swing.JTextField jtfCashAmount;
    private javax.swing.JTextField jtfChange;
    private javax.swing.JTextField jtfGrandTotal;
    // End of variables declaration//GEN-END:variables
}
