package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import domain.*;

public class StaffFrame extends JFrame {

    Staff stf = null;

    public StaffFrame(Staff staff) {
        stf = staff;
        initComponents();
        setTitle("Staff Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

        jbtLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int logOut = JOptionPane.showConfirmDialog(null, "Confirm to log out?", "Log out", JOptionPane.YES_NO_OPTION);
                if (logOut == JOptionPane.YES_OPTION) {
                    dispose();
                    new Login();
                }
            }
        });

        /**
         * ***********************FOOD*****************************
         */
        jbtReadFood.addActionListener(new StaffFrame.ReadFoodListener());
        jbtSearchFood.addActionListener(new StaffFrame.SearchFoodListener());

        /**
         * ***********************ORDERS*****************************
         */
        jbtCreateOrders.addActionListener(new StaffFrame.CreateOrdersListener());
        jbtReadOrders.addActionListener(new StaffFrame.ReadOrdersListener());
        jbtUpdateOrders.addActionListener(new StaffFrame.UpdateOrdersListener());
        jbtSearchOrder.addActionListener(new StaffFrame.SearchOrderListener());

        /**
         * ***********************PAYMENTS*****************************
         */
        jbtCheckOut.addActionListener(new StaffFrame.CheckOutListener());
        jbtSearchPayment.addActionListener(new StaffFrame.SearchPaymentListener());
        jbtReadPayment.addActionListener(new StaffFrame.ReadPaymentListener());

        /**
         * ***********************CUSTOMER*****************************
         */
        jbtCreateCustomer.addActionListener(new StaffFrame.CreateCustomerListener());
        jbtReadCustomer.addActionListener(new StaffFrame.ReadCustomerListener());
        jbtUpdateCustomer.addActionListener(new StaffFrame.UpdateCustomerListener());
        jbtDeleteCustomer.addActionListener(new StaffFrame.DeleteCustomerListener());
        jbtSearchCustomer.addActionListener(new StaffFrame.SearchCustomerListener());
        jbtRenew.addActionListener(new StaffFrame.RenewListener());

        /**
         * ***********************SEAT*****************************
         */
        jbtReadSeat.addActionListener(new StaffFrame.ReadSeatListener());
        jbtSearchSeat.addActionListener(new StaffFrame.SearchSeatListener());

    }

    /**
     * ***********************FOOD*****************************
     */
    private class ReadFoodListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new ReadMenusFrame();
        }
    }

    private class SearchFoodListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new SearchFoodFrame();
        }
    }

    /**
     * ***********************ORDERS*****************************
     */
    private class CreateOrdersListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new CreateOrdersFrame();
        }
    }

    private class ReadOrdersListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new ReadOrdersFrame();
        }
    }

    private class UpdateOrdersListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new UpdateOrdersFrame();
        }
    }

    private class SearchOrderListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new SearchOrderFrame();
        }
    }

    /**
     * ***********************PAYMENTS*****************************
     */
    private class CheckOutListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new CheckOutFrame(stf);
        }
    }

    private class SearchPaymentListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new SearchPaymentFrame();
        }
    }

    private class ReadPaymentListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new ReadPaymentFrame();
        }
    }

    /**
     * ***********************CUSTOMER*****************************
     */
    private class CreateCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new CreateCustomerFrame();
        }
    }

    private class ReadCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new ReadCustomerFrame();
        }
    }

    private class UpdateCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new UpdateCustomerFrame();
        }
    }

    private class DeleteCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new DeleteCustomerFrame();
        }
    }

    private class SearchCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new SearchCustomerFrame();
        }
    }

    private class RenewListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           // new RenewCustomerFrame();
        }
    }

    /**
     * ***********************SEAT*****************************
     */
    private class ReadSeatListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new ReadSeatFrame();
        }
    }

    private class SearchSeatListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new SearchSeatFrame();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        foodPanel = new javax.swing.JPanel();
        food = new javax.swing.JLabel();
        jbtReadFood = new javax.swing.JButton();
        jbtSearchFood = new javax.swing.JButton();
        ordersPanel = new javax.swing.JPanel();
        orders = new javax.swing.JLabel();
        jbtCreateOrders = new javax.swing.JButton();
        jbtReadOrders = new javax.swing.JButton();
        jbtUpdateOrders = new javax.swing.JButton();
        jbtSearchOrder = new javax.swing.JButton();
        paymentsPanel = new javax.swing.JPanel();
        payments = new javax.swing.JLabel();
        jbtCheckOut = new javax.swing.JButton();
        jbtSearchPayment = new javax.swing.JButton();
        jbtReadPayment = new javax.swing.JButton();
        customerPanel = new javax.swing.JPanel();
        customer = new javax.swing.JLabel();
        jbtCreateCustomer = new javax.swing.JButton();
        jbtReadCustomer = new javax.swing.JButton();
        jbtUpdateCustomer = new javax.swing.JButton();
        jbtDeleteCustomer = new javax.swing.JButton();
        jbtSearchCustomer = new javax.swing.JButton();
        jbtRenew = new javax.swing.JButton();
        seatPanel = new javax.swing.JPanel();
        seats = new javax.swing.JLabel();
        jbtReadSeat = new javax.swing.JButton();
        jbtSearchSeat = new javax.swing.JButton();
        jbtLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        foodPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Food", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        food.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pusheen-food.jpg"))); // NOI18N

        jbtReadFood.setText("Read");
        jbtReadFood.setActionCommand("jbtReadFood");

        jbtSearchFood.setText("Search");
        jbtSearchFood.setActionCommand("jbtSearchFood");

        javax.swing.GroupLayout foodPanelLayout = new javax.swing.GroupLayout(foodPanel);
        foodPanel.setLayout(foodPanelLayout);
        foodPanelLayout.setHorizontalGroup(
            foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodPanelLayout.createSequentialGroup()
                .addGroup(foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(foodPanelLayout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(jbtReadFood, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtSearchFood, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(foodPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(food, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        foodPanelLayout.setVerticalGroup(
            foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodPanelLayout.createSequentialGroup()
                .addComponent(food)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtReadFood)
                    .addComponent(jbtSearchFood))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ordersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orders", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        orders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/order-pusheen.jpg"))); // NOI18N

        jbtCreateOrders.setText("Create");
        jbtCreateOrders.setActionCommand("jbtCreateOrders");

        jbtReadOrders.setText("Read");
        jbtReadOrders.setActionCommand("jbtReadOrders");

        jbtUpdateOrders.setText("Update");
        jbtUpdateOrders.setActionCommand("jbtUpdateOrders");

        jbtSearchOrder.setText("Search");
        jbtSearchOrder.setActionCommand("jbtSearchFood");

        javax.swing.GroupLayout ordersPanelLayout = new javax.swing.GroupLayout(ordersPanel);
        ordersPanel.setLayout(ordersPanelLayout);
        ordersPanelLayout.setHorizontalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(orders)
                    .addGroup(ordersPanelLayout.createSequentialGroup()
                        .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtCreateOrders)
                            .addComponent(jbtUpdateOrders))
                        .addGap(27, 27, 27)
                        .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtSearchOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtReadOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 22, Short.MAX_VALUE))
        );
        ordersPanelLayout.setVerticalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addComponent(orders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCreateOrders)
                    .addComponent(jbtReadOrders))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtUpdateOrders)
                    .addComponent(jbtSearchOrder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        paymentsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Payment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        payments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pusheen-payment.jpg"))); // NOI18N
        payments.setText("jLabel3");

        jbtCheckOut.setText("CheckOut");
        jbtCheckOut.setActionCommand("jbtCheckOut");

        jbtSearchPayment.setText("Search");
        jbtSearchPayment.setActionCommand("jbtSearchPayment");

        jbtReadPayment.setText("Read");
        jbtReadPayment.setActionCommand("jbtReadOrders");

        javax.swing.GroupLayout paymentsPanelLayout = new javax.swing.GroupLayout(paymentsPanel);
        paymentsPanel.setLayout(paymentsPanelLayout);
        paymentsPanelLayout.setHorizontalGroup(
            paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsPanelLayout.createSequentialGroup()
                .addGroup(paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paymentsPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtCheckOut)
                        .addGap(18, 18, 18)
                        .addComponent(jbtSearchPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                    .addGroup(paymentsPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(payments, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(paymentsPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jbtReadPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paymentsPanelLayout.setVerticalGroup(
            paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsPanelLayout.createSequentialGroup()
                .addComponent(payments, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtSearchPayment)
                    .addComponent(jbtCheckOut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtReadPayment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        customerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Customer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        customer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/customer-pusheen.jpg"))); // NOI18N

        jbtCreateCustomer.setText("Create");
        jbtCreateCustomer.setActionCommand("jbtCreateCustomer");

        jbtReadCustomer.setText("Read");
        jbtReadCustomer.setActionCommand("jbtReadCustomer");

        jbtUpdateCustomer.setText("Update");
        jbtUpdateCustomer.setActionCommand("jbtUpdateCustomer");

        jbtDeleteCustomer.setText("Delete");
        jbtDeleteCustomer.setActionCommand("jbtDeleteCustomer");

        jbtSearchCustomer.setText("Search");
        jbtSearchCustomer.setActionCommand("jbtSearchCustomer");

        jbtRenew.setText("Renew");
        jbtRenew.setActionCommand("jbtRenew");

        javax.swing.GroupLayout customerPanelLayout = new javax.swing.GroupLayout(customerPanel);
        customerPanel.setLayout(customerPanelLayout);
        customerPanelLayout.setHorizontalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(customerPanelLayout.createSequentialGroup()
                        .addComponent(jbtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtRenew, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customerPanelLayout.createSequentialGroup()
                        .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtUpdateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                            .addComponent(jbtCreateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtReadCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtDeleteCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, customerPanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(customer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCreateCustomer)
                    .addComponent(jbtReadCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtUpdateCustomer)
                    .addComponent(jbtDeleteCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSearchCustomer)
                    .addComponent(jbtRenew))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        seatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        seats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seat-pusheen.jpg"))); // NOI18N

        jbtReadSeat.setText("Read");
        jbtReadSeat.setActionCommand("jbtReadSeat");

        jbtSearchSeat.setText("Search");
        jbtSearchSeat.setActionCommand("jbtSearchSeat");

        javax.swing.GroupLayout seatPanelLayout = new javax.swing.GroupLayout(seatPanel);
        seatPanel.setLayout(seatPanelLayout);
        seatPanelLayout.setHorizontalGroup(
            seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seats)
                    .addGroup(seatPanelLayout.createSequentialGroup()
                        .addComponent(jbtReadSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtSearchSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        seatPanelLayout.setVerticalGroup(
            seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seatPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(seats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtReadSeat)
                    .addComponent(jbtSearchSeat))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jbtLogOut.setText("Log Out");
        jbtLogOut.setActionCommand("jbtLogOut");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(foodPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ordersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paymentsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtLogOut)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(customerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(seatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jbtLogOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foodPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ordersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paymentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(seatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            java.util.logging.Logger.getLogger(StaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new StaffFrame().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customer;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JLabel food;
    private javax.swing.JPanel foodPanel;
    private javax.swing.JButton jbtCheckOut;
    private javax.swing.JButton jbtCreateCustomer;
    private javax.swing.JButton jbtCreateOrders;
    private javax.swing.JButton jbtDeleteCustomer;
    private javax.swing.JButton jbtLogOut;
    private javax.swing.JButton jbtReadCustomer;
    private javax.swing.JButton jbtReadFood;
    private javax.swing.JButton jbtReadOrders;
    private javax.swing.JButton jbtReadPayment;
    private javax.swing.JButton jbtReadSeat;
    private javax.swing.JButton jbtRenew;
    private javax.swing.JButton jbtSearchCustomer;
    private javax.swing.JButton jbtSearchFood;
    private javax.swing.JButton jbtSearchOrder;
    private javax.swing.JButton jbtSearchPayment;
    private javax.swing.JButton jbtSearchSeat;
    private javax.swing.JButton jbtUpdateCustomer;
    private javax.swing.JButton jbtUpdateOrders;
    private javax.swing.JLabel orders;
    private javax.swing.JPanel ordersPanel;
    private javax.swing.JLabel payments;
    private javax.swing.JPanel paymentsPanel;
    private javax.swing.JPanel seatPanel;
    private javax.swing.JLabel seats;
    // End of variables declaration//GEN-END:variables
}
