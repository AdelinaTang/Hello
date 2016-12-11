//Author : Chow Hui Pin
package ui;

import java.awt.event.MouseAdapter;
import control.MaintainCustomerControl;
import control.MaintainMenusControl;
import domain.Customer;
import domain.Menus;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class SearchCustomerFrame extends javax.swing.JFrame {

    private MaintainCustomerControl maintainCustomerControl = new MaintainCustomerControl();
    private ArrayList<Customer> customer = null;
    private String[] columnNames = {"CustomerID", "FirstName", "LastName", "ContactNo", "Email", "Address", "DateJoined", "ExpiryDate", "LoyaltyPoints", "Status", "OldID"};
    private Object[][] data = {};
    DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public SearchCustomerFrame() {
        initComponents();

        jTextField1.addActionListener((ActionEvent e) -> {
            action();
        });

        jButton1.addActionListener((ActionEvent e) -> {
            action();
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void action() {
        detailsTableModel.setRowCount(0);

        customer = maintainCustomerControl.retrieveCustomerRecordControl();
        if (!jTextField1.getText().equals("")) {
            for (int i = 0; i < customer.size(); i++) {
                if (customer.get(i).toString().toLowerCase().contains(jTextField1.getText().toLowerCase())) {
                    System.out.println(customer.get(i));
                    detailsTableModel.addRow(new Object[]{customer.get(i).getCustomerID(), customer.get(i).getFirstName(),
                        customer.get(i).getLastName(), customer.get(i).getContactNo(), customer.get(i).getEmail(),
                        customer.get(i).getAddress(), customer.get(i).getDateJoined(), customer.get(i).getExpiryDate(), customer.get(i).getLoyaltyPointBalance(), customer.get(i).getStatus(), customer.get(i).getOldID()}
                    );
                }
            }
        } else;
        new DisplaySearch();
        customer.clear();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search");

        jLabel1.setText("Search");

        jButton1.setText("Find");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(96, 96, 96)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(152, 152, 152)
                                        .addComponent(jButton1))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(159, 159, 159)
                                        .addComponent(jLabel1)))
                        .addContainerGap(99, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap(43, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchCustomerFrame().setVisible(true);
            }
        });
    }

    class DisplaySearch extends JFrame {

        public DisplaySearch() {
            JTable jtbMenu = new JTable();

            jtbMenu.setModel(detailsTableModel);
            jtbMenu.setPreferredScrollableViewportSize(new Dimension(450, 63));
            jtbMenu.setFillsViewportHeight(true);
            JScrollPane jsp = new JScrollPane(jtbMenu);
            add(jsp);

            TableRowSorter<TableModel> sorter
                    = new TableRowSorter<TableModel>(detailsTableModel);

            jtbMenu.setRowSorter(sorter);

            jtbMenu.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    Customer customer = null;
                    int row = jtbMenu.rowAtPoint(evt.getPoint());
                    String oldID = "";
                    int rowCount = detailsTableModel.getRowCount();
                    for (int i = 0; i < rowCount; i++) {

                        if (row == i) {
                            if (!(detailsTableModel.getValueAt(i, 10) == null)) {
                                oldID = detailsTableModel.getValueAt(i, 10).toString();
                            }
                            customer = new Customer(detailsTableModel.getValueAt(i, 0).toString(), detailsTableModel.getValueAt(i, 1).toString(),
                                    detailsTableModel.getValueAt(i, 2).toString(), detailsTableModel.getValueAt(i, 3).toString(), detailsTableModel.getValueAt(i, 4).toString(),
                                    detailsTableModel.getValueAt(i, 4).toString(), detailsTableModel.getValueAt(i, 5).toString(), detailsTableModel.getValueAt(i, 6).toString(), detailsTableModel.getValueAt(i, 7).toString(), Integer.parseInt(detailsTableModel.getValueAt(i, 8).toString()), detailsTableModel.getValueAt(i, 9).toString(),
                                    oldID);
                            new CustomerClick(customer);
                        }

                    }
                }

            });

            setTitle("Search Customer");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);
            setSize(600, 300);

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
