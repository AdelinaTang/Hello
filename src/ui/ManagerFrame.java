package ui;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import domain.*;

public class ManagerFrame extends javax.swing.JFrame {

    Staff stf = null;
    public ManagerFrame(Staff staff) {
        
        stf = staff;
        initComponents();
        setTitle("Manager Frame");
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
         * ***********************STAFF*****************************
         */
        jbtCreateStaff.addActionListener(new CreateStaffListener());
        jbtReadStaff.addActionListener(new ReadStaffListener());
        jbtUpdateStaff.addActionListener(new UpdateStaffListener());
        jbtDeleteStaff.addActionListener(new DeleteStaffListener());
        jbtSearchStaff.addActionListener(new SearchStaffListener());

        /**
         * ***********************FOOD*****************************
         */
        jbtCreateFood.addActionListener(new CreateFoodListener());
        jbtReadFood.addActionListener(new ReadFoodListener());
        jbtUpdateFood.addActionListener(new UpdateFoodListener());
        jbtDeleteFood.addActionListener(new DeleteFoodListener());
        jbtSearchFood.addActionListener(new SearchFoodListener());

        /**
         * ***********************CUSTOMER*****************************
         */
        jbtCreateCustomer.addActionListener(new CreateCustomerListener());
        jbtReadCustomer.addActionListener(new ReadCustomerListener());
        jbtUpdateCustomer.addActionListener(new UpdateCustomerListener());
        jbtDeleteCustomer.addActionListener(new DeleteCustomerListener());
        jbtSearchCustomer.addActionListener(new SearchCustomerListener());
        jbtRenew.addActionListener(new RenewListener());

        /**
         * ***********************SEAT*****************************
         */
        jbtCreateSeat.addActionListener(new CreateSeatListener());
        jbtReadSeat.addActionListener(new ReadSeatListener());
        jbtUpdateSeat.addActionListener(new UpdateSeatListener());
        jbtDeleteSeat.addActionListener(new DeleteSeatListener());
        jbtSearchSeat.addActionListener(new SearchSeatListener());
        
        /**
         * ***********************ORDERS*****************************
         */
        jbtCreateOrders.addActionListener(new CreateOrdersListener());
        jbtReadOrders.addActionListener(new ReadOrdersListener());
        jbtUpdateOrders.addActionListener(new UpdateOrdersListener());
        jbtSearchOrders.addActionListener(new SearchOrdersListener());
        
        /**
         * ***********************PAYMENTS*****************************
         */
        jbtCheckOut.addActionListener(new CheckOutListener());
        jbtReadPayment.addActionListener(new ReadPaymentListener());
        jbtSearchPayment.addActionListener(new SearchPaymentListener());

    }

    /**
     * ***********************STAFF*****************************
     */
    private class CreateStaffListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new CreateStaffFrame();

        }
    }

    private class ReadStaffListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new ReadStaffFrame();
        }
    }

    private class UpdateStaffListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new UpdateStaffFrame();
        }
    }

    private class DeleteStaffListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new DeleteStaffFrame();
        }
    }

    private class SearchStaffListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new SearchStaffFrame();
        }
    }

    /**
     * ***********************FOOD*****************************
     */
    private class CreateFoodListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new CreateMenusFrame();
        }
    }

    private class ReadFoodListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new ReadMenusFrame();
        }
    }

    private class UpdateFoodListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new UpdateMenusFrame();
        }
    }

    private class DeleteFoodListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new DeleteMenusFrame();
        }
    }

    private class SearchFoodListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new SearchFoodFrame();
        }
    }

    /**
     * ***********************CUSTOMER*****************************
     */
    private class CreateCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new CreateCustomerFrame();
        }
    }

    private class ReadCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new ReadCustomerFrame();
        }
    }

    private class UpdateCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new UpdateCustomerFrame();
        }
    }

    private class DeleteCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            new DeleteCustomerFrame();
        }
    }

    private class SearchCustomerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           new SearchCustomerFrame();
        }
    }

    private class RenewListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new RenewCustomerFrame();
        }
    }

    /**
     * ***********************SEAT*****************************
     */
    private class CreateSeatListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new CreateSeatFrame();
        }
    }

    private class ReadSeatListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new ReadSeatFrame();
        }
    }

    private class UpdateSeatListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new UpdateSeatFrame();
        }
    }

    private class DeleteSeatListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new DeleteSeatFrame();
        }
    }

    private class SearchSeatListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //new SearchSeatFrame();
        }
    }
    
     /**
     * ***********************ORDERS*****************************
     */
    
    private class CreateOrdersListener implements ActionListener{
        
         public void actionPerformed(ActionEvent e) {
            new CreateOrdersFrame();
        }
    }
    
    private class ReadOrdersListener implements ActionListener{
        
         public void actionPerformed(ActionEvent e) {
            new ReadOrdersFrame();
        }
    }
    
    private class UpdateOrdersListener implements ActionListener{
        
         public void actionPerformed(ActionEvent e) {
            new UpdateOrdersFrame();
        }
    }
    
     private class SearchOrdersListener implements ActionListener{
        
         public void actionPerformed(ActionEvent e) {
            new SearchOrderFrame();
        }
    }
     
     /**
     * ***********************PAYMENTS*****************************
     */
     private class CheckOutListener implements ActionListener{
        
         public void actionPerformed(ActionEvent e) {
            new CheckOutFrame(stf);
        }
    }
     
     private class ReadPaymentListener implements ActionListener{
        
         public void actionPerformed(ActionEvent e) {
            //new ReadPaymentFrame();
        }
    }
     private class SearchPaymentListener implements ActionListener{
        
         public void actionPerformed(ActionEvent e) {
            //new SearchPaymentFrame();
        }
    }
    
   
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jToggleButton1 = new javax.swing.JToggleButton();
        button1 = new java.awt.Button();
        foodPanel = new javax.swing.JPanel();
        food = new javax.swing.JLabel();
        jbtCreateFood = new javax.swing.JButton();
        jbtReadFood = new javax.swing.JButton();
        jbtUpdateFood = new javax.swing.JButton();
        jbtSearchFood = new javax.swing.JButton();
        jbtDeleteFood = new javax.swing.JButton();
        ordersPanel = new javax.swing.JPanel();
        orders = new javax.swing.JLabel();
        jbtCreateOrders = new javax.swing.JButton();
        jbtReadOrders = new javax.swing.JButton();
        jbtUpdateOrders = new javax.swing.JButton();
        jbtSearchOrders = new javax.swing.JButton();
        staffPanel = new javax.swing.JPanel();
        staff = new javax.swing.JLabel();
        jbtCreateStaff = new javax.swing.JButton();
        jbtReadStaff = new javax.swing.JButton();
        jbtUpdateStaff = new javax.swing.JButton();
        jbtDeleteStaff = new javax.swing.JButton();
        jbtSearchStaff = new javax.swing.JButton();
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
        jbtLogOut = new javax.swing.JButton();
        seatPanel = new javax.swing.JPanel();
        seats = new javax.swing.JLabel();
        jbtCreateSeat = new javax.swing.JButton();
        jbtReadSeat = new javax.swing.JButton();
        jbtUpdateSeat = new javax.swing.JButton();
        jbtDeleteSeat = new javax.swing.JButton();
        jbtSearchSeat = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTextPane1);

        jToggleButton1.setText("jToggleButton1");

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        foodPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Food", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        food.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/pusheen-food.jpg"))); // NOI18N

        jbtCreateFood.setText("Create");
        jbtCreateFood.setActionCommand("jbtCreateFood");

        jbtReadFood.setText("Read");
        jbtReadFood.setActionCommand("jbtReadFood");

        jbtUpdateFood.setText("Update");
        jbtUpdateFood.setActionCommand("jbtUpdateFood");

        jbtSearchFood.setText("Search");
        jbtSearchFood.setActionCommand("jbtSearchFood");

        jbtDeleteFood.setText("Delete");
        jbtDeleteFood.setActionCommand("jbtDeleteFood");

        javax.swing.GroupLayout foodPanelLayout = new javax.swing.GroupLayout(foodPanel);
        foodPanel.setLayout(foodPanelLayout);
        foodPanelLayout.setHorizontalGroup(
            foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodPanelLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodPanelLayout.createSequentialGroup()
                        .addGroup(foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(foodPanelLayout.createSequentialGroup()
                                .addComponent(jbtDeleteFood, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtSearchFood, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(foodPanelLayout.createSequentialGroup()
                                .addComponent(jbtCreateFood, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtReadFood, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodPanelLayout.createSequentialGroup()
                        .addComponent(food)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, foodPanelLayout.createSequentialGroup()
                        .addComponent(jbtUpdateFood, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        foodPanelLayout.setVerticalGroup(
            foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodPanelLayout.createSequentialGroup()
                .addComponent(food)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCreateFood)
                    .addComponent(jbtReadFood))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtUpdateFood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtDeleteFood)
                    .addComponent(jbtSearchFood))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jbtCreateFood.getAccessibleContext().setAccessibleName("jbtCreateFood");
        jbtReadFood.getAccessibleContext().setAccessibleName("jbtReadFood");
        jbtUpdateFood.getAccessibleContext().setAccessibleName("jbtUpdateFood");
        jbtSearchFood.getAccessibleContext().setAccessibleName("jbtSearchFood");
        jbtDeleteFood.getAccessibleContext().setAccessibleName("jbtDeleteFood");

        ordersPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orders", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        orders.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/order-pusheen.jpg"))); // NOI18N

        jbtCreateOrders.setText("Create");
        jbtCreateOrders.setActionCommand("jbtCreateOrders");

        jbtReadOrders.setText("Read");
        jbtReadOrders.setActionCommand("jbtReadOrders");

        jbtUpdateOrders.setText("Update");
        jbtUpdateOrders.setActionCommand("jbtUpdateOrders");

        jbtSearchOrders.setText("Search");
        jbtSearchOrders.setActionCommand("jbtSearchStaff");

        javax.swing.GroupLayout ordersPanelLayout = new javax.swing.GroupLayout(ordersPanel);
        ordersPanel.setLayout(ordersPanelLayout);
        ordersPanelLayout.setHorizontalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersPanelLayout.createSequentialGroup()
                        .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtCreateOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtReadOrders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtSearchOrders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtUpdateOrders, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ordersPanelLayout.createSequentialGroup()
                        .addComponent(orders)
                        .addGap(13, 13, 13))))
        );
        ordersPanelLayout.setVerticalGroup(
            ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ordersPanelLayout.createSequentialGroup()
                .addComponent(orders)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCreateOrders)
                    .addComponent(jbtUpdateOrders))
                .addGap(18, 18, 18)
                .addGroup(ordersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtReadOrders)
                    .addComponent(jbtSearchOrders))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jbtCreateOrders.getAccessibleContext().setAccessibleName("jbtCreateOrders");
        jbtReadOrders.getAccessibleContext().setAccessibleName("jbtReadOrders");
        jbtUpdateOrders.getAccessibleContext().setAccessibleName("jbtUpdateOrders");

        staffPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Staff", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        staff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cook-pusheen.jpg"))); // NOI18N

        jbtCreateStaff.setText("Create");
        jbtCreateStaff.setActionCommand("jbtCreateStaff");

        jbtReadStaff.setText("Read");
        jbtReadStaff.setActionCommand("jbtReadStaff");

        jbtUpdateStaff.setText("Update");
        jbtUpdateStaff.setActionCommand("jbtUpdateStaff");

        jbtDeleteStaff.setText("Delete");
        jbtDeleteStaff.setActionCommand("jbtDeleteStaff");

        jbtSearchStaff.setText("Search");
        jbtSearchStaff.setActionCommand("jbtSearchStaff");

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtReadStaff, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                        .addComponent(jbtDeleteStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtSearchStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staff)
                            .addComponent(jbtCreateStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtUpdateStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addComponent(staff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCreateStaff)
                    .addComponent(jbtReadStaff))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtUpdateStaff)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtDeleteStaff)
                    .addComponent(jbtSearchStaff))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jbtCreateStaff.getAccessibleContext().setAccessibleName("jbtCreateStaff");
        jbtReadStaff.getAccessibleContext().setAccessibleName("jbtReadStaff");
        jbtUpdateStaff.getAccessibleContext().setAccessibleName("jbtUpdateStaff");
        jbtDeleteStaff.getAccessibleContext().setAccessibleName("jbtDeleteStaff");
        jbtSearchStaff.getAccessibleContext().setAccessibleName("jbtSearchStaff");

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
                        .addGap(18, 18, 18)
                        .addComponent(jbtCheckOut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtSearchPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paymentsPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(payments, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paymentsPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtReadPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        paymentsPanelLayout.setVerticalGroup(
            paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paymentsPanelLayout.createSequentialGroup()
                .addComponent(payments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paymentsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCheckOut)
                    .addComponent(jbtSearchPayment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtReadPayment)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jbtCheckOut.getAccessibleContext().setAccessibleName("jbtCheckOut");
        jbtSearchPayment.getAccessibleContext().setAccessibleName("jbtSearchPayment");

        customerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Member", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

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
            .addGroup(customerPanelLayout.createSequentialGroup()
                .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(customerPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(customer, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(customerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jbtCreateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtUpdateCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                            .addComponent(jbtSearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtRenew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtDeleteCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbtReadCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        customerPanelLayout.setVerticalGroup(
            customerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerPanelLayout.createSequentialGroup()
                .addComponent(customer)
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jbtCreateCustomer.getAccessibleContext().setAccessibleName("jbtCreateCustomer");
        jbtReadCustomer.getAccessibleContext().setAccessibleName("jbtReadCustomer");
        jbtUpdateCustomer.getAccessibleContext().setAccessibleName("jbtUpdateCustomer");
        jbtDeleteCustomer.getAccessibleContext().setAccessibleName("jbtDeleteCustomer");
        jbtSearchCustomer.getAccessibleContext().setAccessibleName("jbtSearchCustomer");
        jbtRenew.getAccessibleContext().setAccessibleName("jbtRenew");

        jbtLogOut.setText("Log Out");
        jbtLogOut.setActionCommand("jbtLogOut");

        seatPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Handwriting", 0, 18))); // NOI18N

        seats.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seat-pusheen.jpg"))); // NOI18N

        jbtCreateSeat.setText("Create");
        jbtCreateSeat.setActionCommand("jbtCreateSeat");

        jbtReadSeat.setText("Read");
        jbtReadSeat.setActionCommand("jbtReadSeat");

        jbtUpdateSeat.setText("Update");
        jbtUpdateSeat.setActionCommand("jbtUpdateSeat");

        jbtDeleteSeat.setText("Delete");
        jbtDeleteSeat.setActionCommand("jbtDeleteSeat");

        jbtSearchSeat.setText("Search");
        jbtSearchSeat.setActionCommand("jbtSearchSeat");

        javax.swing.GroupLayout seatPanelLayout = new javax.swing.GroupLayout(seatPanel);
        seatPanel.setLayout(seatPanelLayout);
        seatPanelLayout.setHorizontalGroup(
            seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, seatPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(seats)
                .addGap(21, 21, 21))
            .addGroup(seatPanelLayout.createSequentialGroup()
                .addGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(seatPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(seatPanelLayout.createSequentialGroup()
                                .addComponent(jbtCreateSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtReadSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(seatPanelLayout.createSequentialGroup()
                                .addComponent(jbtUpdateSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtDeleteSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(seatPanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jbtSearchSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        seatPanelLayout.setVerticalGroup(
            seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seatPanelLayout.createSequentialGroup()
                .addComponent(seats)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCreateSeat)
                    .addComponent(jbtReadSeat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtSearchSeat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtUpdateSeat)
                    .addComponent(jbtDeleteSeat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jbtCreateSeat.getAccessibleContext().setAccessibleName("jbtCreateSeat");
        jbtReadSeat.getAccessibleContext().setAccessibleName("jbtReadSeat");
        jbtUpdateSeat.getAccessibleContext().setAccessibleName("jbtUpdateSeat");
        jbtDeleteSeat.getAccessibleContext().setAccessibleName("jbtDeleteSeat");
        jbtSearchSeat.getAccessibleContext().setAccessibleName("jbtSearchSeat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paymentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(foodPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ordersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staffPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbtLogOut)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtLogOut)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ordersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(foodPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(staffPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(paymentsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(customerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtLogOut.getAccessibleContext().setAccessibleName("jbtLogOut");

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
            java.util.logging.Logger.getLogger(ManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private javax.swing.JLabel customer;
    private javax.swing.JPanel customerPanel;
    private javax.swing.JLabel food;
    private javax.swing.JPanel foodPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton jbtCheckOut;
    private javax.swing.JButton jbtCreateCustomer;
    private javax.swing.JButton jbtCreateFood;
    private javax.swing.JButton jbtCreateOrders;
    private javax.swing.JButton jbtCreateSeat;
    private javax.swing.JButton jbtCreateStaff;
    private javax.swing.JButton jbtDeleteCustomer;
    private javax.swing.JButton jbtDeleteFood;
    private javax.swing.JButton jbtDeleteSeat;
    private javax.swing.JButton jbtDeleteStaff;
    private javax.swing.JButton jbtLogOut;
    private javax.swing.JButton jbtReadCustomer;
    private javax.swing.JButton jbtReadFood;
    private javax.swing.JButton jbtReadOrders;
    private javax.swing.JButton jbtReadPayment;
    private javax.swing.JButton jbtReadSeat;
    private javax.swing.JButton jbtReadStaff;
    private javax.swing.JButton jbtRenew;
    private javax.swing.JButton jbtSearchCustomer;
    private javax.swing.JButton jbtSearchFood;
    private javax.swing.JButton jbtSearchOrders;
    private javax.swing.JButton jbtSearchPayment;
    private javax.swing.JButton jbtSearchSeat;
    private javax.swing.JButton jbtSearchStaff;
    private javax.swing.JButton jbtUpdateCustomer;
    private javax.swing.JButton jbtUpdateFood;
    private javax.swing.JButton jbtUpdateOrders;
    private javax.swing.JButton jbtUpdateSeat;
    private javax.swing.JButton jbtUpdateStaff;
    private javax.swing.JLabel orders;
    private javax.swing.JPanel ordersPanel;
    private javax.swing.JLabel payments;
    private javax.swing.JPanel paymentsPanel;
    private javax.swing.JPanel seatPanel;
    private javax.swing.JLabel seats;
    private javax.swing.JLabel staff;
    private javax.swing.JPanel staffPanel;
    // End of variables declaration//GEN-END:variables
}
