
package ui;

import control.MaintainFoodControl;
import control.MaintainMenusControl;
import control.MaintainOrdersControl;
import control.MaintainSeatControl;
import domain.Food;
import domain.Menus;
import domain.Orders;
import domain.Seat;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Wilson
 */
public class SearchOrderFrame extends javax.swing.JFrame {

    private MaintainFoodControl maintainFoodControl = new MaintainFoodControl();
    private String[] columnNames = {"OrderID", "SeatNo", "FoodID", "Quantity", "DateOrder"};
    private Object[][] data = {};
    DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public SearchOrderFrame() {
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

        ArrayList<Food> food = maintainFoodControl.retrieveFoodRecordControl();
        if (!jTextField1.getText().equals("")) {
            for (int i = 0; i < food.size(); i++) {
                if (food.get(i).toString().toLowerCase().contains(jTextField1.getText().toLowerCase())) {
                    System.out.println(food.get(i));
                    detailsTableModel.addRow(new Object[]{food.get(i).getOrders().getOrderID(), food.get(i).getOrders().getSeat().getSeatNo(), food.get(i).getMenu().getFoodID(), food.get(i).getQuantity(), food.get(i).getOrders().getDateOrder()
                    });
                }
            }
        } else;
        new DisplaySearch();
        food.clear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
            java.util.logging.Logger.getLogger(SearchFoodFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFoodFrame.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchOrderFrame().setVisible(true);
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
                    Food food = null;
                    int row = jtbMenu.rowAtPoint(evt.getPoint());

                    int rowCount = detailsTableModel.getRowCount();
                    for (int i = 0; i < rowCount; i++) {

                        if (row == i) {
                            food = new Food(new Orders(detailsTableModel.getValueAt(i, 0).toString()), new Seat(Integer.parseInt(detailsTableModel.getValueAt(i, 1).toString())),
                                    new Menus(detailsTableModel.getValueAt(i, 2).toString()), Integer.parseInt(detailsTableModel.getValueAt(i, 3).toString()), new Orders(detailsTableModel.getValueAt(i, 4).toString()));
                            new OrderClick(food);
                        }

                    }

                }
            });

            setTitle("Search Order");
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
