//Author : Chow Hui Pin

package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import control.*;
import domain.*;
import java.util.ArrayList;

public class UpdateCustomerFrame extends javax.swing.JFrame {

    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private ArrayList<Customer> customer = null;

    public UpdateCustomerFrame() {
        initComponents();
        setTitle("Update Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        customer = maintainCustomerControl.retrieveCustomerRecordControl();
        for (int i = 0; i < customer.size(); i++) {
            if (customer.get(i).getStatus().equals("Active")) {
                model.addElement(customer.get(i).getCustomerID());

            }

        }

        jcbCustomerID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String customerID = (String) jcbCustomerID.getSelectedItem();
                Customer customer = maintainCustomerControl.retrieveCustomerRecordControl(customerID);
                jtfDateJoined.setEditable(false);
                jtfExpiryDate.setEditable(false);
                jtfOldID.setEditable(false);
                jtfLoyaltyPointBalance.setEditable(false);
                jtfICNo.setEditable(false);
                jtfFirstName.setText(customer.getFirstName());
                jtfLastName.setText(customer.getLastName());
                jtfContactNo.setText(customer.getContactNo());
                jtfEmail.setText(customer.getEmail());
                jtaAddress.setText(customer.getAddress());
                jtfDateJoined.setText(customer.getDateJoined());
                jtfExpiryDate.setText(customer.getExpiryDate());
                jtfLoyaltyPointBalance.setText(String.valueOf(customer.getLoyaltyPointBalance()));
                jtfOldID.setText(customer.getOldID());
                jtfICNo.setText(customer.getICNo());

            }
        });

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String firstName = jtfFirstName.getText();
                String lastName = jtfLastName.getText();
                String contactNo = jtfContactNo.getText();
                String email = jtfEmail.getText();
                String address = jtaAddress.getText();
                String customerID = (String) jcbCustomerID.getSelectedItem();
                Customer cust = maintainCustomerControl.retrieveCustomerRecordControl(customerID);
                String status = cust.getStatus();
                boolean validate = validateInput(firstName, lastName, contactNo, email, address);
                if (validate) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm to update?", "Update Customer", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        Customer customer = new Customer(customerID, jtfICNo.getText(), firstName, lastName, contactNo,
                                email, address, jtfDateJoined.getText(), jtfExpiryDate.getText(),
                                Integer.parseInt(jtfLoyaltyPointBalance.getText()), status, jtfOldID.getText());
                        maintainCustomerControl.updateCustomerRecordControl(customer);
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

    public boolean validateInput(String firstName, String lastName, String contactNo, String email, String address) {
        if (firstName.equals("") || lastName.equals("") || contactNo.equals("") || email.equals("") || address.equals("")) {
            JOptionPane.showMessageDialog(null, "Fields cannot be left blank.");
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

    public void Reset() {

        jtfEmail.setText("");
        jtaAddress.setText("");
        jtfContactNo.setText("");
        jtfFirstName.setText("");
        jtfLastName.setText("");
        jtfDateJoined.setText("");
        jtfExpiryDate.setText("");
        jtfLoyaltyPointBalance.setText("");
        jtfOldID.setText("");
        jtfICNo.setText("");
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
        jtfFirstName = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jtfContactNo = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAddress = new javax.swing.JTextArea();
        jbtOk = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jlbDateJoined = new javax.swing.JLabel();
        jtfDateJoined = new javax.swing.JTextField();
        jlbExpiryDate = new javax.swing.JLabel();
        jtfExpiryDate = new javax.swing.JTextField();
        jlbLoyaltyPointBalance = new javax.swing.JLabel();
        jtfLoyaltyPointBalance = new javax.swing.JTextField();
        jcbCustomerID = new javax.swing.JComboBox(model);
        jlbDateJoined1 = new javax.swing.JLabel();
        jtfOldID = new javax.swing.JTextField();
        jtfICNo = new javax.swing.JTextField();
        jlbICNo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Update Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

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

        jbtCancel.setText("Cancel");

        jlbDateJoined.setText("Date Joined");

        jlbExpiryDate.setText("Expiry Date");

        jlbLoyaltyPointBalance.setText("Loyalty Point Balance");

        jlbDateJoined1.setText("Old Customer ID");

        jlbICNo.setText("IC No");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbICNo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfFirstName)
                            .addComponent(jtfLastName)
                            .addComponent(jtfContactNo)
                            .addComponent(jtfEmail)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                            .addComponent(jcbCustomerID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfICNo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfDateJoined, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfExpiryDate)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbDateJoined1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addComponent(jlbLoyaltyPointBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfLoyaltyPointBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfOldID, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbtOk)
                                .addGap(26, 26, 26)
                                .addComponent(jbtCancel)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfICNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbICNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
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
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfOldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbDateJoined1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtOk)
                    .addComponent(jbtCancel))
                .addGap(59, 59, 59))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(UpdateCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtOk;
    private javax.swing.JComboBox jcbCustomerID;
    private javax.swing.JLabel jlbAddress;
    private javax.swing.JLabel jlbContactNo;
    private javax.swing.JLabel jlbDateJoined;
    private javax.swing.JLabel jlbDateJoined1;
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbExpiryDate;
    private javax.swing.JLabel jlbFirstName;
    private javax.swing.JLabel jlbICNo;
    private javax.swing.JLabel jlbLastName;
    private javax.swing.JLabel jlbLoyaltyPointBalance;
    private javax.swing.JLabel jlbStaffID;
    private javax.swing.JTextArea jtaAddress;
    private javax.swing.JTextField jtfContactNo;
    private javax.swing.JTextField jtfDateJoined;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfExpiryDate;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfICNo;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfLoyaltyPointBalance;
    private javax.swing.JTextField jtfOldID;
    // End of variables declaration//GEN-END:variables
}
