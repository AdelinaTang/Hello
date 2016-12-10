package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import control.*;
import domain.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends JFrame {

    private JTextField jtfUsername = new JTextField();
    private JPasswordField jpfPassword = new JPasswordField();
    private JButton jbtLogin = new JButton("Login");
    private JLabel jlbWilsonCafe = new JLabel("Wilson's Cafe");
    private ImageIcon sushi = new ImageIcon(getClass().getResource("/Images/pusheen.gif"));
    private JLabel frame = new JLabel(sushi);
    private MaintainStaffControl maintainStaffControl = new MaintainStaffControl();
    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    private ArrayList<Customer> customerRecord = null;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateObj = new Date();

    public Login() {

        add(frame, BorderLayout.NORTH);
        jlbWilsonCafe.setFont(new Font("CASTELLAR", Font.PLAIN, 20));
        jlbWilsonCafe.setHorizontalAlignment(SwingConstants.CENTER);
        add(jlbWilsonCafe, BorderLayout.CENTER);

        JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 4));
        p2.add(new JLabel("Username"));
        p2.add(jtfUsername);
        p2.add(new JLabel("Password"));
        p2.add(jpfPassword);
        p2.add(new JLabel());
        p2.add(jbtLogin);
        add(p2, BorderLayout.SOUTH);

        jbtLogin.addActionListener(new loginListener());
        jtfUsername.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                jpfPassword.requestFocusInWindow();
            }
        });
        
        jpfPassword.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 String userName = jtfUsername.getText(), password = jpfPassword.getText();
        Staff staff = maintainStaffControl.retrieveStaffRecordControl(userName, password);
        if (staff == null) {
            JOptionPane.showMessageDialog(null, "No such record exists. Try again", "Error", JOptionPane.ERROR_MESSAGE);
            jtfUsername.setText("");
            jpfPassword.setText("");
            jtfUsername.requestFocusInWindow();
        } else {
            JOptionPane.showMessageDialog(null, "Successfully login");
            dispose();
            if (staff.getFirstName().equals("Manager")) {
                new ManagerFrame(staff);
            } else {
                new StaffFrame(staff);
            }

        }
            }
            
        });

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(350, 450);

        
    
}

private class loginListener implements ActionListener {

    public void actionPerformed(ActionEvent e) {

        String userName = jtfUsername.getText(), password = jpfPassword.getText();
        Staff staff = maintainStaffControl.retrieveStaffRecordControl(userName, password);
        if (staff == null) {
            JOptionPane.showMessageDialog(null, "No such record exists. Try again", "Error", JOptionPane.ERROR_MESSAGE);
            jtfUsername.setText("");
            jpfPassword.setText("");
            jtfUsername.requestFocusInWindow();
        } else {
            JOptionPane.showMessageDialog(null, "Successfully login");
            dispose();
            if (staff.getFirstName().equals("Manager")) {
                new ManagerFrame(staff);
            } else {
                new StaffFrame(staff);
            }

        }
    }

}

public static void main(String[] args) {
        new Login();
    }
}
