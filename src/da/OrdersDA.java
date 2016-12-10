//Author : Chin Wei Song
package da;

import javax.swing.*;
import java.sql.*;
import domain.*;
import control.*;
import java.util.ArrayList;

public class OrdersDA {

    private String host = "jdbc:derby://localhost:1527/guiassignment";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Orders";
    private Connection conn;
    private PreparedStatement stmt;
    private ArrayList<Orders> orders = new ArrayList<Orders>();
    private Seat seat = null;
    private SeatDA seatDA = new SeatDA();

    public OrdersDA() {
        createConnection();

    }

    public ArrayList<Orders> retrieveOrdersRecordDA() {
        String sqlQuery = "Select * from " + tableName;

        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                seat = seatDA.retrieveSeatRecordDA(Integer.parseInt(rs.getString("seatno")));
                orders.add(new Orders(rs.getString("orderid"), seat, rs.getString("dateorder")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return orders;

    }

    public Orders retrieveOrdersRecordDA(String orderID) {
        String sqlQuery = "Select * from " + tableName + " where orderid = ?";
        ResultSet rs = null;
        Orders orders = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, orderID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                seat = seatDA.retrieveSeatRecordDA(Integer.parseInt(rs.getString("seatno")));
                orders = new Orders(rs.getString("orderid"), seat, rs.getString("dateorder"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return orders;

    }

    public String checkOrdersRecordDA(String orderID) {
        String sqlQuery = "Select * from " + tableName + " where orderID = ?";
        String id = "";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, orderID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getString("orderid");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return id;
    }

    public void createOrdersRecordDA(Orders orders) {
        String sqlQuery = "Insert into " + tableName + " values(?,?,?)";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, orders.getOrderID());
            stmt.setString(2, String.valueOf(orders.getSeat().getSeatNo()));
            stmt.setString(3, orders.getDateOrder());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public String getLatestIDDA() {
        String sqlQuery = "Select * from " + tableName + " order by orderid";
        ResultSet rs = null;
        String orderID = "";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                orderID = rs.getString("orderid");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return orderID;

    }

    public String checkOrdersRecordDA() {
        String sqlQuery = "Select * from " + tableName;
        String id = "";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getString("orderid");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public ArrayList<Orders> retrieveOrdersRecordDA(int seatNo) {
        String sqlQuery = "Select * from " + tableName + " where seatNo = ?";
        ResultSet rs = null;
        ArrayList<Orders> orders = new ArrayList<Orders>();
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(seatNo));
            rs = stmt.executeQuery();
            while (rs.next()) {
                seat = seatDA.retrieveSeatRecordDA(Integer.parseInt(rs.getString("seatno")));
                orders.add(new Orders(rs.getString("orderid"), seat, rs.getString("dateorder")));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return orders;

    }

    public ArrayList<String> retrieveOrderNo() {
        ResultSet rs = null;
        ArrayList<String> orderid = new ArrayList<String>();
        try {
            String sqlQuery = "Select orderid from " + tableName;
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while(rs.next()){
                orderid.add(rs.getString("orderid"));
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return orderid;

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
