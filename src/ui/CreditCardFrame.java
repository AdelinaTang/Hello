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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.border.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class CreditCardFrame extends javax.swing.JFrame {

    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private MaintainFoodControl maintainFoodControl = new MaintainFoodControl();
    private Payment py = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date dateObj = new Date();
    String date = dateFormat.format(dateObj);
    String status = "";

    public CreditCardFrame(double grandTotal, ArrayList<Food> foodRecord, String transactionID) {
        initComponents();

        jtfCN1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean valid = validateInput1(jtfCN1.getText());
                if (valid) {
                    JOptionPane.showMessageDialog(null, "The rest of the field should not be left empty");
                    jtfCN2.requestFocusInWindow();
                }
            }
        });

        jtfCN2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean valid = validateInput2(jtfCN2.getText());
                if (valid) {
                    JOptionPane.showMessageDialog(null, "The rest of the field should not be left empty");
                    jtfCN3.requestFocusInWindow();
                }
            }
        });

        jtfCN3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean valid = validateInput2(jtfCN3.getText());
                if (valid) {
                    JOptionPane.showMessageDialog(null, "The rest of the field should not be left empty");
                    jtfCN4.requestFocusInWindow();
                }
            }
        });

        jtfCN4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean valid = validateInput2(jtfCN4.getText());
                if (valid) {
                    Payment payment = maintainTransactionControl.retrieveTransactionRecordControl(transactionID);
                    ArrayList<Food> food = maintainFoodControl.retrieveFoodRecordControl(payment.getOrders().getOrderID());
                    JOptionPane.showMessageDialog(null, "Receipt is successfully generated");
                    dispose();
                    py = maintainTransactionControl.retrieveTransactionRecordControl(transactionID);
                    if (!(py.getCustomer().getCustomerID() == null)) {
                        status = "member";
                    } else {
                        status = "nonmember";
                    }

                    if (status.equals("member")) {
                        try {
                            fileForMember(payment, food);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    } else {
                        try {
                            fileForNonMember(payment, food);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    try {
                        fileCredit(jtfCN4.getText(), payment);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean valid = validateInput(jtfCN1.getText(), jtfCN2.getText(), jtfCN3.getText(), jtfCN4.getText());
                if (valid) {
                    Payment payment = maintainTransactionControl.retrieveTransactionRecordControl(transactionID);
                    ArrayList<Food> food = maintainFoodControl.retrieveFoodRecordControl(payment.getOrders().getOrderID());
                    JOptionPane.showMessageDialog(null, "Receipt is successfully generated");
                    dispose();
                    py = maintainTransactionControl.retrieveTransactionRecordControl(transactionID);
                    if (!(py.getCustomer().getCustomerID() == null)) {
                        status = "member";
                    } else {
                        status = "nonmember";
                    }

                    if (status.equals("member")) {
                        try {
                            fileForMember(payment, food);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                    } else {
                        try {
                            fileForNonMember(payment, food);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }

                    try {
                        fileCredit(jtfCN4.getText(), payment);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }

                }

            }

        });

        setTitle("Paid By Credit Card");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
    }

    public void fileCredit(String lastFourDigit, Payment payment) throws IOException {
        File file2 = new File("credit.txt");
        file2.createNewFile();
        FileWriter writer2 = new FileWriter(file2);
        BufferedWriter bufferedWriter2 = new BufferedWriter(writer2);

        bufferedWriter2.write("\t\t\t\tGlobal Payment");
        bufferedWriter2.newLine();
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t\tWilson's Cafe");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t    WILSON'S CAFE (SETAPAK)");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t       SDN.BHD (1018028.W)");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t      JALAN GENTING KELANG");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t   53300 SETAPAK KL, MALAYSIA");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t\tTEL : 011-1421-7017");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t   GST REG NO : 001940439040");
        bufferedWriter2.newLine();
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t       ************************************************");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\tTrans ID : ");
        bufferedWriter2.write(payment.getTransactionID());
        bufferedWriter2.write("\t\tMID : 321098625367218");
        bufferedWriter2.newLine();
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t" + date);
        bufferedWriter2.write("\t\tCard : Visa");
        bufferedWriter2.newLine();
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t\t    SALE");
        bufferedWriter2.newLine();
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t****\t****\t****\t");
        bufferedWriter2.write(lastFourDigit);
        bufferedWriter2.newLine();
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\tTotal : MYR");
        String grandTotal = String.format("%.2f", payment.getGrandTotal());
        bufferedWriter2.write("\t\t\t" + grandTotal);
        bufferedWriter2.newLine();
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\tNO SIGNATURE REQUIRED");
        bufferedWriter2.newLine();
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\tI agree to pay above total amount");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\taccording to card issuer agreement");
        bufferedWriter2.newLine();
        bufferedWriter2.write("\t\t\t\t-- CUSTOMER COPY --");
        bufferedWriter2.flush();
        bufferedWriter2.close();

    }

    public void fileForMember(Payment payment, ArrayList<Food> food) throws IOException {
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
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t\t  THANK YOU");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t       Please come again");
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public void fileForNonMember(Payment payment, ArrayList<Food> food) throws IOException {
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
        bufferedWriter.write("\t----------------------------------------------------------------");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t\t  THANK YOU");
        bufferedWriter.newLine();
        bufferedWriter.write("\t\t\t       Please come again");
        bufferedWriter.flush();
        bufferedWriter.close();

    }

    public boolean validateInput(String cardNumber1, String cardNumber2, String cardNumber3, String cardNumber4) {
        if (cardNumber1.equals("") || cardNumber2.equals("") || cardNumber3.equals("") || cardNumber4.equals("")) {
            JOptionPane.showMessageDialog(null, "Field should not be left empty");
            jtfCN1.requestFocusInWindow();
            return false;
        }

        for (int i = 0; i < cardNumber1.length(); i++) {
            if (!Character.isDigit(cardNumber1.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfCN1.setText("");
                jtfCN1.requestFocusInWindow();
                return false;
            }
        }

        if (cardNumber1.length() != 4) {
            JOptionPane.showMessageDialog(null, "Each field should consists of 4 digits");
            jtfCN1.setText("");
            jtfCN1.requestFocusInWindow();
            return false;
        }

        for (int i = 0; i < cardNumber2.length(); i++) {
            if (!Character.isDigit(cardNumber2.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfCN2.setText("");
                jtfCN2.requestFocusInWindow();
                return false;
            }
        }

        if (cardNumber2.length() != 4) {
            JOptionPane.showMessageDialog(null, "Each field should consists of 4 digits");
            jtfCN2.setText("");
            jtfCN2.requestFocusInWindow();
            return false;
        }

        for (int i = 0; i < cardNumber3.length(); i++) {
            if (!Character.isDigit(cardNumber3.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfCN3.setText("");
                jtfCN3.requestFocusInWindow();
                return false;
            }
        }

        if (cardNumber3.length() != 4) {
            JOptionPane.showMessageDialog(null, "Each field should consists of 4 digits");
            jtfCN3.setText("");
            jtfCN3.requestFocusInWindow();
            return false;
        }

        for (int i = 0; i < cardNumber4.length(); i++) {
            if (!Character.isDigit(cardNumber4.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfCN4.setText("");
                jtfCN4.requestFocusInWindow();
                return false;
            }
        }

        if (cardNumber4.length() != 4) {
            JOptionPane.showMessageDialog(null, "Each field should consists of 4 digits");
            jtfCN4.setText("");
            jtfCN4.requestFocusInWindow();
            return false;
        }

        return true;
    }

    public boolean validateInput1(String cardNumber) {
        if (cardNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Field should not be left empty");
            jtfCN1.requestFocusInWindow();
            return false;
        }

        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfCN1.setText("");
                jtfCN1.requestFocusInWindow();
                return false;
            }
        }

        if (cardNumber.length() != 4) {
            JOptionPane.showMessageDialog(null, "Each field should consists of 4 digits");
            jtfCN1.setText("");
            jtfCN1.requestFocusInWindow();
            return false;
        }

        return true;
    }

    public boolean validateInput2(String cardNumber) {
        if (cardNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Field should not be left empty");
            jtfCN2.requestFocusInWindow();
            return false;
        }

        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfCN2.setText("");
                jtfCN2.requestFocusInWindow();
                return false;
            }
        }

        if (cardNumber.length() != 4) {
            JOptionPane.showMessageDialog(null, "Each field should consists of 4 digits");
            jtfCN2.setText("");
            jtfCN2.requestFocusInWindow();
            return false;
        }

        return true;
    }

    public boolean validateInput3(String cardNumber) {
        if (cardNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Field should not be left empty");
            jtfCN3.requestFocusInWindow();
            return false;
        }

        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfCN3.setText("");
                jtfCN3.requestFocusInWindow();
                return false;
            }
        }

        if (cardNumber.length() != 4) {
            JOptionPane.showMessageDialog(null, "Each field should consists of 4 digits");
            jtfCN3.setText("");
            jtfCN3.requestFocusInWindow();
            return false;
        }

        return true;
    }

    public boolean validateInput4(String cardNumber) {
        if (cardNumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Field should not be left empty");
            jtfCN4.requestFocusInWindow();
            return false;
        }

        for (int i = 0; i < cardNumber.length(); i++) {
            if (!Character.isDigit(cardNumber.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                jtfCN4.setText("");
                jtfCN4.requestFocusInWindow();
                return false;
            }
        }

        if (cardNumber.length() != 4) {
            JOptionPane.showMessageDialog(null, "Each field should consists of 4 digits");
            jtfCN4.setText("");
            jtfCN4.requestFocusInWindow();
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbCardNo = new javax.swing.JLabel();
        jbtOk = new javax.swing.JButton();
        jtfCN1 = new javax.swing.JTextField();
        jtfCN2 = new javax.swing.JTextField();
        jtfCN3 = new javax.swing.JTextField();
        jtfCN4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paid By Credit Card", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbCardNo.setText("Card Number");

        jbtOk.setText("Ok");

        jLabel1.setText("--");

        jLabel2.setText("--");

        jLabel3.setText("--");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jtfCN1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtOk, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCN2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCN3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCN4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCardNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jtfCN2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCN3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jtfCN4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtOk)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtOk;
    private javax.swing.JLabel jlbCardNo;
    private javax.swing.JTextField jtfCN1;
    private javax.swing.JTextField jtfCN2;
    private javax.swing.JTextField jtfCN3;
    private javax.swing.JTextField jtfCN4;
    // End of variables declaration//GEN-END:variables
}
