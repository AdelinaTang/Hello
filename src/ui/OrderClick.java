package ui;

import control.MaintainFoodControl;
import domain.Food;
import domain.Orders;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

public class OrderClick extends javax.swing.JFrame {

    private MaintainFoodControl maintainFoodControl = new MaintainFoodControl();
    private ArrayList<Food> readFood = maintainFoodControl.retrieveFoodRecordControl();

    public OrderClick() {
        initComponents();
    }

    public OrderClick(Food food) {
        initComponents();
        setTitle("Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        jtfDateOrder.setText(food.getOrders().getDateOrder());
        jtfOrderID.setText(food.getOrders().getOrderID());
        jtfSeatNumber.setText(String.valueOf(food.getOrders().getSeat().getSeatNo()));
        jtfFoodID.setText(food.getMenu().getFoodID());
        jtfQuantity.setText(String.valueOf(food.getQuantity()));

        jtfDateOrder.setEditable(false);
        jtfOrderID.setEditable(false);
        jtfSeatNumber.setEditable(false);
        jtfFoodID.setEditable(false);
        jtfQuantity.setEditable(false);

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public OrderClick(int i) {
        initComponents();
        setTitle("Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        jtfDateOrder.setText(readFood.get(i).getOrders().getDateOrder());
        jtfOrderID.setText(readFood.get(i).getOrders().getOrderID());
        jtfSeatNumber.setText(String.valueOf(readFood.get(i).getOrders().getSeat().getSeatNo()));
        jtfFoodID.setText(readFood.get(i).getMenu().getFoodID());
        jtfQuantity.setText(String.valueOf(readFood.get(i).getQuantity()));

        jtfDateOrder.setEditable(false);
        jtfOrderID.setEditable(false);
        jtfSeatNumber.setEditable(false);
        jtfFoodID.setEditable(false);
        jtfQuantity.setEditable(false);

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlblOrderID = new javax.swing.JLabel();
        jlbFoodID = new javax.swing.JLabel();
        jtfOrderID = new javax.swing.JTextField();
        jbtOk = new javax.swing.JButton();
        jlblQuantity = new javax.swing.JLabel();
        jtfFoodID = new javax.swing.JTextField();
        jtfSeatNumber = new javax.swing.JTextField();
        jlblSeatNumber = new javax.swing.JLabel();
        jtfQuantity = new javax.swing.JTextField();
        jlblDateOrder = new javax.swing.JLabel();
        jtfDateOrder = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Order", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        jlblOrderID.setText("Order ID");

        jlbFoodID.setText("Food ID");

        jbtOk.setText("Ok");
        jbtOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOkActionPerformed(evt);
            }
        });

        jlblQuantity.setText("Quantity");

        jlblSeatNumber.setText("Seat Number");

        jlblDateOrder.setText("Date Order");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jlbFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                        .addComponent(jtfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jlblSeatNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jlblQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                                .addComponent(jlblDateOrder, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtfSeatNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtfFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jtfDateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(28, 28, 28))
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jbtOk)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfSeatNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jlblSeatNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlbFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfFoodID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlblQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlblDateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfDateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jbtOk)
                        .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Order");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOkActionPerformed
        dispose();
    }

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
            java.util.logging.Logger.getLogger(OrderClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderClick.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderClick().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtOk;
    private javax.swing.JLabel jlbFoodID;
    private javax.swing.JLabel jlblDateOrder;
    private javax.swing.JLabel jlblOrderID;
    private javax.swing.JLabel jlblQuantity;
    private javax.swing.JLabel jlblSeatNumber;
    private javax.swing.JTextField jtfDateOrder;
    private javax.swing.JTextField jtfFoodID;
    private javax.swing.JTextField jtfOrderID;
    private javax.swing.JTextField jtfQuantity;
    private javax.swing.JTextField jtfSeatNumber;
    // End of variables declaration//GEN-END:variables
}
