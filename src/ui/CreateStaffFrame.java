//Author: Chow Hui Pin

package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import control.*;
import domain.*;

public class CreateStaffFrame extends javax.swing.JFrame {

    private MaintainStaffControl maintainStaffControl = new MaintainStaffControl();
    String staffID = "";

    public CreateStaffFrame() {

        initComponents();
        setTitle("Create Staff");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        staffID = generateStaffID();

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = jtfFirstName.getText();
                String lastName = jtfLastName.getText();
                String contactNo = jtfContactNo.getText();
                String email = jtfEmail.getText();
                String address = jtaAddress.getText();
                String password = jtfPassword.getText();
                boolean validate = validateInput(firstName, lastName, contactNo, email, address,password);
                if (validate) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm to create?", "Create Staff", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        String staffPassword = jtfPassword.getText();
                        Staff staff = new Staff(staffID, firstName, lastName, contactNo, email, address,
                                "Active", staffPassword);
                        maintainStaffControl.createStaffRecordControl(staff);
                        JOptionPane.showMessageDialog(null, "Record successfully created");
                        Reset();
                        staffID = generateStaffID();

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

    public boolean validateInput(String firstName, String lastName, String contactNo, String email, String address,String password) {
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
        if(password.length() > 20){
            JOptionPane.showMessageDialog(null,"The length of the password cannot exceed 20 characters or digits long");
            jtfPassword.setText("");
            jtfPassword.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public void Reset() {
        jtfFirstName.setText("");
        jtfLastName.setText("");
        jtfContactNo.setText("");
        jtfEmail.setText("");
        jtaAddress.setText("");
        jtfPassword.setText("");
    }

    public String generateStaffID() {
        String staffID = maintainStaffControl.getLatestIDControl();
        int lastThreeDigit = Integer.parseInt(staffID.substring(1, 4));
        String incrementedStaffID = String.format("S%03d", (lastThreeDigit + 1));
        jtfStaffID.setEditable(false);
        jtfStaffID.setText(incrementedStaffID);
        return incrementedStaffID;
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
        jtfStaffID = new javax.swing.JTextField();
        jtfFirstName = new javax.swing.JTextField();
        jtfLastName = new javax.swing.JTextField();
        jtfContactNo = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaAddress = new javax.swing.JTextArea();
        jbtOk = new javax.swing.JButton();
        jbtReset = new javax.swing.JButton();
        jlbPassword = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create Staff", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlbStaffID.setText("Staff ID");

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

        jbtReset.setText("Reset");

        jlbPassword.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtOk)
                        .addGap(29, 29, 29)
                        .addComponent(jbtReset))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtfStaffID)
                        .addComponent(jtfFirstName)
                        .addComponent(jtfLastName)
                        .addComponent(jtfContactNo)
                        .addComponent(jtfEmail)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                        .addComponent(jtfPassword)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtOk)
                    .addComponent(jbtReset))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
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
            java.util.logging.Logger.getLogger(CreateStaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateStaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateStaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateStaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateStaffFrame().setVisible(true);
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
    private javax.swing.JLabel jlbEmail;
    private javax.swing.JLabel jlbFirstName;
    private javax.swing.JLabel jlbLastName;
    private javax.swing.JLabel jlbPassword;
    private javax.swing.JLabel jlbStaffID;
    private javax.swing.JTextArea jtaAddress;
    private javax.swing.JTextField jtfContactNo;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfStaffID;
    // End of variables declaration//GEN-END:variables
}
