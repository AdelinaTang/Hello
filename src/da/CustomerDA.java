//Author : Chow Hui Pin
package da;

import javax.swing.*;
import java.sql.*;
import domain.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomerDA {

    private String host = "jdbc:derby://localhost:1527/guiassignment";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Customer";
    private Connection conn;
    private PreparedStatement stmt;
    private ArrayList<Customer> customerRecord = new ArrayList<Customer>();

    public CustomerDA() {
        createConnection();
    }

    public void createCustomerRecordDA(Customer customer) {
        String sqlQuery = "Insert into " + tableName + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String loyaltyPointBalance = String.valueOf(customer.getLoyaltyPointBalance());

        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, customer.getCustomerID());
            stmt.setString(2, customer.getICNo());
            stmt.setString(3, customer.getFirstName());
            stmt.setString(4, customer.getLastName());
            stmt.setString(5, customer.getContactNo());
            stmt.setString(6, customer.getEmail());
            stmt.setString(7, customer.getAddress());
            stmt.setString(8, customer.getDateJoined());
            stmt.setString(9, customer.getExpiryDate());
            stmt.setString(10, loyaltyPointBalance);
            stmt.setString(11, customer.getStatus());
            stmt.setString(12, customer.getOldID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public String getLatestIDDA() {
        String sqlQuery = "Select * from " + tableName + " order by customerid";
        ResultSet rs = null;
        String customerID = "";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customerID = rs.getString("customerid");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customerID;

    }

    public ArrayList<Customer> retrieveCustomerRecordDA() {
        String sqlQuery = "Select * from " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customerRecord.add(new Customer(rs.getString("customerid"), rs.getString("icno"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("contactno"), rs.getString("email"), rs.getString("address"), rs.getString("datejoined"),
                        rs.getString("expirydate"), Integer.parseInt(rs.getString("loyaltypointbalance")), rs.getString("status"), rs.getString("oldid")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customerRecord;

    }

    public Customer retrieveCustomerRecordDA(String customerID) {
        String sqlQuery = "Select * from " + tableName + " where customerid = ?";
        ResultSet rs = null;
        Customer customer = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, customerID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                customer = new Customer(rs.getString("customerid"), rs.getString("icno"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("contactno"), rs.getString("email"), rs.getString("address"), rs.getString("datejoined"),
                        rs.getString("expirydate"), Integer.parseInt(rs.getString("loyaltypointbalance")), rs.getString("status"), rs.getString("oldid"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customer;

    }

    public Customer retrieveCustomerRecordICDA(String icNo) {
        String sqlQuery = "Select * from " + tableName + " where icNo = ?";
        ResultSet rs = null;
        Customer customer = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, icNo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customer = new Customer(rs.getString("customerid"), rs.getString("icno"), rs.getString("firstname"), rs.getString("lastname"),
                        rs.getString("contactno"), rs.getString("email"), rs.getString("address"), rs.getString("datejoined"),
                        rs.getString("expirydate"), Integer.parseInt(rs.getString("loyaltypointbalance")), rs.getString("status"), rs.getString("oldid"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customer;

    }

    public void updateCustomerRecordDA(Customer customer) {
        String sqlQuery = "Update " + tableName + " set contactno = ?, email = ?, address = ?, status = ? where customerid = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, customer.getContactNo());
            stmt.setString(2, customer.getEmail());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getStatus());
            stmt.setString(5, customer.getCustomerID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteCustomerRecordDA(String customerID) {
        String sqlQuery = "Delete from " + tableName + " where customerid = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, customerID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void deleteCustomerRecordDA2(String customerID) {
        String sqlQuery = "Update " + tableName + " set status = ? where customerid = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, "Terminated");
            stmt.setString(2, customerID);
            stmt.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

    }

    public void updateRenewCustomerRecordDA(String icNo) {
        String sqlQuery = "Update " + tableName + " set status = ? where icno = ? ";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, "Terminated");
            stmt.setString(2, icNo);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ArrayList<String> retrieveCustomerRecordICDA() {
        String sqlQuery = "Select distinct icno from " + tableName;
        ResultSet rs = null;
        ArrayList<String> customerRecord = new ArrayList<String>();
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                customerRecord.add(rs.getString("icno"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return customerRecord;

    }

    public void updateCustomerRecordDA(String customerID, int newLoyaltyPointBalance2) {
        String sqlQuery = "Update " + tableName + " set loyaltypointbalance = ? where customerid = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(newLoyaltyPointBalance2));
            stmt.setString(2, customerID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

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
