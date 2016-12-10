//Author : Adelina Tang Chooi Li
package da;

import javax.swing.*;
import java.sql.*;
import domain.*;
import java.util.ArrayList;

public class TransactionDA {

    private String host = "jdbc:derby://localhost:1527/guiassignment";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Payment";
    private Connection conn;
    private PreparedStatement stmt;
    private Customer customer = null;
    private CustomerDA customerDA = new CustomerDA();
    private Staff staff = null;
    private StaffDA staffDA = new StaffDA();
    private Orders orders = null;
    private OrdersDA ordersDA = new OrdersDA();

    public TransactionDA() {
        createConnection();
    }

    public String getLatestIDDA() {
        String sqlQuery = "Select * from " + tableName + " order by transactionid";
        ResultSet rs = null;
        String transactionID = "";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                transactionID = rs.getString("transactionid");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return transactionID;

    }

    public void createTransactionRecordDA(Payment payment) {
        String sqlQuery = "Insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, payment.getTransactionID());
            stmt.setString(2, payment.getCustomer().getCustomerID());
            stmt.setString(3, payment.getStaff().getStaffID());
            stmt.setString(4, payment.getOrders().getOrderID());
            stmt.setString(5, payment.getPaymentMethod());
            stmt.setString(6, String.valueOf(payment.getDiscount()));
            stmt.setString(7, String.valueOf(payment.getTotalPriceBD()));
            stmt.setString(8, String.valueOf(payment.getTax()));
            stmt.setString(9, String.valueOf(payment.getTotalPriceAD()));
            stmt.setString(10, String.valueOf(payment.getGrandTotal()));
            stmt.setString(11, String.valueOf(payment.getLoyaltyPointUsed()));
            stmt.setString(12, String.valueOf(payment.getLoyaltyPointAmount()));
            stmt.setString(13, String.valueOf(payment.getLoyaltyPointEarned()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Payment retrieveTransactionRecordDA(String transactionID) {
        String sqlQuery = "Select * from " + tableName + " where transactionid = ?";
        ResultSet rs = null;
        Payment payment = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, transactionID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("customerid") == null) {
                    Customer customer = new Customer(null, "", "", "", "", "", "", "", "", 0, "", "");
                    staff = staffDA.retrieveStaffRecordDA(rs.getString("staffid"));
                    orders = ordersDA.retrieveOrdersRecordDA(rs.getString("orderid"));
                    payment = new Payment(rs.getString("transactionid"), customer, staff, orders, rs.getString("paymentmethod"),
                            Double.parseDouble(rs.getString("discount")), Double.parseDouble(rs.getString("totalpricebd")),
                            Double.parseDouble(rs.getString("tax")), Double.parseDouble(rs.getString("totalpricead")),
                            Double.parseDouble(rs.getString("grandtotal")), Integer.parseInt(rs.getString("loyaltypointused")), Double.parseDouble(rs.getString("loyaltypointamount")),
                            Integer.parseInt(rs.getString("loyaltypointearned")));
                } else {
                    customer = customerDA.retrieveCustomerRecordDA(rs.getString("customerid"));
                    staff = staffDA.retrieveStaffRecordDA(rs.getString("staffid"));
                    orders = ordersDA.retrieveOrdersRecordDA(rs.getString("orderid"));
                    payment = new Payment(rs.getString("transactionid"), customer, staff, orders, rs.getString("paymentmethod"),
                            Double.parseDouble(rs.getString("discount")), Double.parseDouble(rs.getString("totalpricebd")),
                            Double.parseDouble(rs.getString("tax")), Double.parseDouble(rs.getString("totalpricead")),
                            Double.parseDouble(rs.getString("grandtotal")), Integer.parseInt(rs.getString("loyaltypointused")), Double.parseDouble(rs.getString("loyaltypointamount")),
                            Integer.parseInt(rs.getString("loyaltypointearned")));
                }

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return payment;

    }

    public ArrayList<Payment> retrieveTransactionRecordDA() {
        String sqlQuery = "Select * from " + tableName;
        ResultSet rs = null;
        ArrayList<Payment> payments = new ArrayList<Payment>();
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customer = customerDA.retrieveCustomerRecordDA(rs.getString("customerid"));
                staff = staffDA.retrieveStaffRecordDA(rs.getString("staffid"));
                orders = ordersDA.retrieveOrdersRecordDA(rs.getString("orderid"));
                payments.add(new Payment(rs.getString("transactionid"), customer, staff, orders, rs.getString("paymentmethod"),
                        Double.parseDouble(rs.getString("discount")), Double.parseDouble(rs.getString("totalpricebd")),
                        Double.parseDouble(rs.getString("tax")), Double.parseDouble(rs.getString("totalpricead")),
                        Double.parseDouble(rs.getString("grandtotal")), Integer.parseInt(rs.getString("loyaltypointused")), Double.parseDouble(rs.getString("loyaltypointamount")),
                        Integer.parseInt(rs.getString("loyaltypointearned"))));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return payments;

    }

    public ArrayList<String> retrieveTransactionOrderID() {
        String sqlQuery = "Select orderid from " + tableName;
        ResultSet rs = null;
        ArrayList<String> orderID = new ArrayList<String>();
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while(rs.next()){
                orderID.add(rs.getString("orderid"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderID;

    }

    public void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("TRACE : Connection established");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

}
