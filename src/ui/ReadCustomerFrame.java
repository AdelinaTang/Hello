package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadCustomerFrame extends JFrame {

    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    private ArrayList<Customer> readCustomer = maintainCustomerControl.retrieveCustomerRecordControl();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateObj = new Date();

    public ReadCustomerFrame() {

        String dateJoined = dateFormat.format(dateObj);
        for (int i = 0; i < readCustomer.size(); i++) {
            String expiredDate = readCustomer.get(i).getExpiryDate();
            if ((dateJoined.compareTo(expiredDate) > 0)) {
                Customer customer = new Customer(readCustomer.get(i).getCustomerID(),readCustomer.get(i).getICNo(), readCustomer.get(i).getFirstName(),
                        readCustomer.get(i).getLastName(), readCustomer.get(i).getContactNo(), readCustomer.get(i).getEmail(),
                        readCustomer.get(i).getAddress(), readCustomer.get(i).getDateJoined(), readCustomer.get(i).getExpiryDate(),
                        readCustomer.get(i).getLoyaltyPointBalance(),
                        "Terminated", readCustomer.get(i).getOldID());
                maintainCustomerControl.updateCustomerRecordControl(customer);

            }
        }

        JTable jtbCustomer = new JTable();
        String[] columnNames = {"CustomerID","IC No", "FirstName", "LastName", "ContactNo", "Email", "Address",
            "DateJoined", "ExpiryDate", "LoyaltyPointBalance", "Status", "OldID"};
        Object[][] data = {};

        DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(detailsTableModel);
        
        jtbCustomer.setRowSorter(sorter);

        for (int i = 0; i < readCustomer.size(); i++) {
            detailsTableModel.addRow(new Object[]{readCustomer.get(i).getCustomerID(),readCustomer.get(i).getICNo(), readCustomer.get(i).getFirstName(),
                readCustomer.get(i).getLastName(), readCustomer.get(i).getContactNo(), readCustomer.get(i).getEmail(),
                readCustomer.get(i).getAddress(), readCustomer.get(i).getDateJoined(), readCustomer.get(i).getExpiryDate(),
                readCustomer.get(i).getLoyaltyPointBalance(), readCustomer.get(i).getStatus(), readCustomer.get(i).getOldID()});

        }

        jtbCustomer.setModel(detailsTableModel);
        jtbCustomer.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbCustomer.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(jtbCustomer);
        add(jsp);

        jtbCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jtbCustomer.rowAtPoint(evt.getPoint());
                for (int i = 0; i < readCustomer.size(); i++) {
                    if (row == i) {
                        new CustomerClick(i);
                    }
                }
            }
        });

        setTitle("Read Customer");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 300);

    }

    public static void main(String[] args) {
        new ReadCustomerFrame();
    }

}
