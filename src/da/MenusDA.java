//Author : Choo Yee Ling

package da;

import javax.swing.*;
import java.sql.*;
import domain.*;
import java.util.ArrayList;

public class MenusDA {

    private String host = "jdbc:derby://localhost:1527/guiassignment";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Menus";
    private Connection conn;
    private PreparedStatement stmt;
    private ArrayList<Menus> menusRecord = new ArrayList<Menus>();
    private ArrayList<Menus> menus = new ArrayList<Menus>();

    public MenusDA() {
        createConnection();
    }

    public void createMenusRecordDA(Menus menus) {
        String sqlQuery = "Insert into " + tableName + " values(?,?,?,?,?,?)";
        String pricePerUnit = String.valueOf(menus.getPricePerUnit());
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, menus.getFoodID());
            stmt.setString(2, menus.getFoodName());
            stmt.setString(3, menus.getCategory());
            stmt.setString(4, menus.getDescription());
            stmt.setString(5, pricePerUnit);
            stmt.setString(6, menus.getStatus());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getLatestIDDA() {
        String sqlQuery = "Select * from " + tableName + " order by foodid";
        ResultSet rs = null;
        String foodID = "";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                foodID = rs.getString("foodid");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return foodID;

    }

    public ArrayList<Menus> retrieveMenusRecordDA() {
        String sqlQuery = "Select * from " + tableName;
        ResultSet rs = null;
        double pricePerUnit = 0.0;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                pricePerUnit = Double.parseDouble(rs.getString("priceperunit"));
                menusRecord.add(new Menus(rs.getString("foodid"), rs.getString("foodname"), rs.getString("category"),
                        rs.getString("description"), pricePerUnit, rs.getString("status")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return menusRecord;

    }

    public Menus retrieveMenusRecordDA(String menuID) {
        String sqlQuery = "Select * from " + tableName + " where foodid = ?";
        ResultSet rs = null;
        Menus menu = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, menuID);
            rs = stmt.executeQuery();
            if (rs.next()) {
                menu = new Menus(rs.getString("foodid"), rs.getString("foodname"), rs.getString("category"), rs.getString("description"),
                        Double.parseDouble(rs.getString("priceperunit")), rs.getString("status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return menu;

    }

    public void updateMenusRecordDA(Menus menus) {
        String sqlQuery = "Update " + tableName + " set foodname = ?, category = ?, description = ?, priceperunit = ?, status = ? where"
                + " foodid = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, menus.getFoodName());
            stmt.setString(2, menus.getCategory());
            stmt.setString(3, menus.getDescription());
            stmt.setString(4, String.valueOf(menus.getPricePerUnit()));
            stmt.setString(5, menus.getStatus());
            stmt.setString(6, menus.getFoodID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ArrayList<Menus> retrieveMenusRecordDA2(String foodID) {
        String sqlQuery = "Select * from " + tableName + " where foodid = ?";
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, foodID);
            rs = stmt.executeQuery();
            while(rs.next()){
                menus.add(new Menus(rs.getString("foodid"),rs.getString("foodname"),rs.getString("category"),
                        rs.getString("description"),Double.parseDouble(rs.getString("priceperunit")),rs.getString("status")));
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return menus;

    }

    public void deleteMenusRecordDA(String menuID) {
        String sqlQuery = "Delete from " + tableName + " where foodid = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, menuID);
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
