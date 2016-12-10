//Author : Chin Wei Song
package da;

import javax.swing.*;
import java.sql.*;
import domain.*;
import java.util.ArrayList;

public class FoodDA {

    private String host = "jdbc:derby://localhost:1527/guiassignment";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Food";
    private Connection conn;
    private PreparedStatement stmt;
    private ArrayList<Food> foodRecord = new ArrayList<Food>();
    private Menus menus = null;
    private MenusDA menusDA = new MenusDA();
    private Orders orders = null;
    private OrdersDA ordersDA = new OrdersDA();
    private Food foodList = null;

    public FoodDA() {
        createConnection();
    }

    public int getLatestIDDA() {
        String sqlQuery = "Select * from " + tableName + " order by foodorderid";
        ResultSet rs = null;
        int foodorderid = 0;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                foodorderid = Integer.parseInt(rs.getString("foodorderid"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return foodorderid;

    }

    public void createFoodRecordDA(Food food) {
        String sqlQuery = "Insert into " + tableName + " values(?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(food.getFoodOrderID()));
            stmt.setString(2, food.getOrders().getOrderID());
            stmt.setString(3, food.getMenu().getFoodID());
            stmt.setString(4, String.valueOf(food.getQuantity()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ArrayList<Food> retrieveFoodRecordDA(String orderID) {
        String sqlQuery = "Select * from " + tableName + " where orderid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, orderID);
            rs = stmt.executeQuery();
            while (rs.next()) {
                menus = menusDA.retrieveMenusRecordDA(rs.getString("foodid"));
                orders = ordersDA.retrieveOrdersRecordDA(rs.getString("orderid"));
                foodRecord.add(new Food(Integer.parseInt(rs.getString("foodorderid")), menus, orders,
                        Integer.parseInt(rs.getString("quantity"))));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return foodRecord;

    }

    public ArrayList<Food> retrieveFoodRecordDA() {
        String sqlQuery = "Select * from " + tableName;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                menus = menusDA.retrieveMenusRecordDA(rs.getString("foodid"));
                orders = ordersDA.retrieveOrdersRecordDA(rs.getString("orderid"));
                foodRecord.add(new Food(Integer.parseInt(rs.getString("foodorderid")), menus, orders,
                        Integer.parseInt(rs.getString("quantity"))));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return foodRecord;

    }

    public void updateFoodRecordDA(Food foodupdate) {
        //String sqlQuery = "Update " + tableName + " set quantity = ? where orderid = ? and foodid = ?";
        String sqlQuery = "Update " + tableName + " set quantity = ? where foodorderid = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(foodupdate.getQuantity()));
            stmt.setString(2, String.valueOf(foodupdate.getFoodOrderID()));
//            stmt.setString(1, String.valueOf(foodupdate.getQuantity()));
//            stmt.setString(2, foodupdate.getOrders().getOrderID());
//            stmt.setString(3, foodupdate.getMenu().getFoodID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public Food retrieveFoodRecordDA(int foodorderid) {
        String sqlQuery = "Select * from " + tableName + " where foodorderid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(foodorderid));
            rs = stmt.executeQuery();
            while (rs.next()) {
                menus = menusDA.retrieveMenusRecordDA(rs.getString("foodid"));
                orders = ordersDA.retrieveOrdersRecordDA(rs.getString("orderid"));
                foodList = new Food(Integer.parseInt(rs.getString("foodorderid")), menus, orders,
                        Integer.parseInt(rs.getString("quantity")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return foodList;

    }

    public void deleteFoodRecordDA(int foodorderid) {
        String sqlQuery = "Delete from " + tableName + " where foodorderid = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(foodorderid));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public int checkFoodRecordDA(int foodorderid) {
        String sqlQuery = "Select * from " + tableName + " where foodorderid = ?";
        ResultSet rs = null;
        int id = 0;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(foodorderid));
            rs = stmt.executeQuery();
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("foodorderid"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return id;

    }

    public Food retrieveFoodRecordDA2(String foodid,String orderID) {
        String sqlQuery = "Select * from " + tableName + " where foodid = ? and orderid = ?";
        ResultSet rs = null;
        Food food = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1,foodid);
            stmt.setString(2,orderID);
            rs = stmt.executeQuery();
            if(rs.next()){
                menus = menusDA.retrieveMenusRecordDA(rs.getString("foodid"));
                orders = ordersDA.retrieveOrdersRecordDA(rs.getString("orderid"));
                food = new Food(Integer.parseInt(rs.getString("foodorderid")),menus,orders,Integer.parseInt(rs.getString("quantity")));
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return food;

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
