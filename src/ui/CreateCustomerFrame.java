//Author : Chow Hui Pin
package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import control.*;
import domain.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CreateCustomerFrame extends javax.swing.JFrame {

    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateObj = new Date();
    String customerID = "";

    public CreateCustomerFrame() {
        initComponents();
        setTitle("Create Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        customerID = generateCustomerID();
        String dateJoined = dateFormat.format(dateObj);
        String firstFourDigit = dateJoined.substring(0, 4);
        int year = Integer.parseInt(firstFourDigit) + 2;
        String yearString = String.valueOf(year);
        String monthString = dateJoined.substring(5, 7);
        String dayString = dateJoined.substring(8);
        String expiryDate = yearString + "-" + monthString + "-" + dayString;
        jtfDateJoined.setEditable(false);
        jtfDateJoined.setText(dateJoined);
        jtfExpiryDate.setEditable(false);
        jtfExpiryDate.setText(expiryDate);
        jtfLoyaltyPointBalance.setEditable(false);
        int loyaltyPointBalance = 0;
        jtfLoyaltyPointBalance.setText(String.valueOf(loyaltyPointBalance));

        jbtOk.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String firstName = jtfFirstName.getText();
                String lastName = jtfLastName.getText();
                String contactNo = jtfContactNo.getText();
                String email = jtfEmail.getText();
                String address = jtaAddress.getText();
                String icNo = jtfICNo.getText();
                boolean valid = validateInput(icNo, firstName, lastName, contactNo, email, address);
                if (valid) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm to create?", "Create Customer", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        Customer customer = new Customer(customerID, icNo, firstName, lastName, contactNo,
                                email, address, dateJoined, expiryDate, loyaltyPointBalance, "Active", null);
                        maintainCustomerControl.createCustomerRecordControl(customer);
                        JOptionPane.showMessageDialog(null, "Record successfully created");
                        customerID = generateCustomerID();
                        setDefaultInput();
                        Reset();
                    }

                }

            }
        });

        jbtReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reset();
            }
        });
    }

    public String generateCustomerID() {

        String customerID = maintainCustomerControl.getLatestIDControl();
        int lastThreeDigit = Integer.parseInt(customerID.substring(1, 4));
        String incrementedCustomerID = String.format("C%03d", (lastThreeDigit + 1));
        jtfCustomerID.setEditable(false);
        jtfCustomerID.setText(incrementedCustomerID);
        return incrementedCustomerID;
    }

    public void Reset() {
        jtfFirstName.setText("");
        jtfLastName.setText("");
        jtfContactNo.setText("");
        jtfEmail.setText("");
        jtaAddress.setText("");
        jtfICNo.setText("");

    }

    public void setDefaultInput() {

        String dateJoined = dateFormat.format(dateObj);
        String firstFourDigit = dateJoined.substring(0, 4);
        int year = Integer.parseInt(firstFourDigit) + 2;
        String yearString = String.valueOf(year);
        String monthString = dateJoined.substring(5, 7);
        String dayString = dateJoined.substring(8);
        String expiryDate = yearString + "-" + monthString + "-" + dayString;
        jtfDateJoined.setEditable(false);
        jtfDateJoined.setText(dateJoined);
        jtfExpiryDate.setEditable(false);
        jtfExpiryDate.setText(expiryDate);
        jtfLoyaltyPointBalance.setEditable(false);
        int loyaltyPointBalance = 0;
        jtfLoyaltyPointBalance.setText(String.valueOf(loyaltyPointBalance));

    }

    public boolean validateInput(String icNo, String firstName, String lastName, String contactNo, String email, String address) {
        if (icNo.equals("") || firstName.equals("") || lastName.equals("") || contactNo.equals("") || email.equals("") || address.equals("")) {
            JOptionPane.showMessageDialog(null, "Fields cannot be left blank.");
            return false;

        }
        Customer cust = maintainCustomerControl.retrieveCustomerRecordICControl(icNo);
        try {
            if (cust.getICNo() != null) {
                JOptionPane.showMessageDialog(null, "The IC No exists already");
                jtfICNo.setText("");
                jtfICNo.requestFocusInWindow();
                return false;
            }
        } catch (NullPointerException ex) {

        }

        if (!icNo.matches("^\\d{6}\\-\\d{2}\\-\\d{4}$")) {
            JOptionPane.showMessageDialog(null, "Invalid IC No");
            jtfICNo.setText("");
            jtfICNo.requestFocusInWindow();
            return false;
        }
        for (int i = 0; i < firstName.length(); i++) {
            if (!Character.isLetter(firstName.charAt(i))) {
                JOptionPane.showMessageDialog(null, "First name must consist of letters only");
                jtfFirstName.setText("");
                jtfFirstName.requestFocusInWindow();
                return false;

            }
        }
        for (int i = 0; i < lastName.length(); i++) {
            if (!Character.isLetter(lastName.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Last name must consist of letters only");
                jtfLastName.setText("");
                jtfLastName.requestFocusInWindow();
                return false;

            }
        }

        if (contactNo.length() < 11 || contactNo.length() > 12 || !contactNo.matches("[0][1][\\d]-[\\d]{7,}")) {
            JOptionPane.showMessageDialog(null, "Invalid contact no");
            jtfContactNo.setText("");
            jtfContactNo.requestFocusInWindow();
            return false;

        }
        if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            JOptionPane.showMessageDialog(null, "Invalid email address");
            jtfEmail.setText("");
            jtfEmail.requestFocusInWindow();
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbStaffID = new javax.swing.JLabel();
        jlbFirstName = new javax.swing.JLabel();
        jlbLastName = new javax.swing.JLabel();
        jlbContactNo = new javax.swing.JLabel();
        jlbEmail = new javax.swing.JLabel();
        jlbAddress = new javax.swing.JLabel();
        jtfCustomerID = new javax.swing.JTextField();
        jtfFirstName = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jtfContactNo = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAddress = new javax.swing.JTextArea();
        jbtOk = new javax.swing.JButton();
        jlbDateJoined = new javax.swing.JLabel();
        jtfDateJoined = new javax.swing.JTextField();
        jlbExpiryDate = new javax.swing.JLabel();
        jtfExpiryDate = new javax.swing.JTextField();
        jlbLoyaltyPointBalance = new javax.swing.JLabel();
        jtfLoyaltyPointBalance = new javax.swing.JTextField();
        jtfICNo = new javax.swing.JTextField();
        jlbStaffID1 = new javax.swing.JLabel();
        jbtReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbStaffID.setText("Customer ID");

        jlbFirstName.setText("First Name");

        jlbLastName.setText("Last Name");

        jlbContactNo.setText("Contact No");

        jlbEmail.setText("Email");

        jlbAddress.setText("Address");

        jtaAddress.setColumns(20);
        jtaAddress.setLineWrap(true);
        jtaAddress.setRows(5);
        jtaAddress.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jtaAddress);

        jbtOk.setText("Ok");

        jlbDateJoined.setText("Date Joined");

        jlbExpiryDate.setText("Expiry Date");

        jlbLoyaltyPointBalance.setText("Loyalty Point Balance");

        jlbStaffID1.setText("IC No");

        jbtReset.setText("Reset");
        jbtReset.setToolTipText("");

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
                                .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlbExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(45, 45, 45))
                        .addComponent(jlbStaffID1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlbLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfCustomerID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfFirstName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfContactNo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(jtfDateJoined, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfExpiryDate, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtOk)
                        .addGap(35, 35, 35)
                        .addComponent(jbtReset))
                    .addComponent(jtfICNo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfLoyaltyPointBalance))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfICNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbStaffID1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDateJoined, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtOk)
                    .addComponent(jbtReset))
                .addGap(108, 108, 108))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(CreateCustomerFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateCustomerFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateCustomerFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateCustomerFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateCustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtOk;
    private javax.swing.JButton jbtReset;
    private javax.swing.JLabel jlbAddress;
    private javax.swing.JLabel jlbContactNo;
    private javax.swing.JLabel jlbDateJoined;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbExpiryDate;
    private javax.swing.JLabel jlbFirstName;
    private javax.swing.JLabel jlbLastName;
    private javax.swing.JLabel jlbLoyaltyPointBalance;
    private javax.swing.JLabel jlbStaffID;
    private javax.swing.JLabel jlbStaffID1;
    private javax.swing.JTextArea jtaAddress;
    private javax.swing.JTextField jtfContactNo;
    private javax.swing.JTextField jtfCustomerID;
    private javax.swing.JTextField jtfDateJoined;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfExpiryDate;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfICNo;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfLoyaltyPointBalance;
    // End of variables declaration//GEN-END:variables
}
