//Author : Chow Hui Pin

package da;

import javax.swing.*;
import java.sql.*;
import domain.*;
import java.util.ArrayList;

public class StaffDA {

    private String host = "jdbc:derby://localhost:1527/guiassignment";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Staff";
    private Connection conn;
    private PreparedStatement stmt;
    private ArrayList<Staff> staffRecord = new ArrayList<Staff>();
    
    public StaffDA() {
        createConnection();
    }

    public Staff retrieveStaffRecordDA(String userName, String password) {
        String sqlQuery = "Select * from " + tableName + " where firstname = ? and password = ?";
        ResultSet rs = null;
        Staff staff = null;
        try {
 
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if (rs.next()) {
                staff = new Staff(rs.getString("staffid"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("contactno"),
                        rs.getString("email"),rs.getString("address"),rs.getString("status"),rs.getString("password"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return staff;

    }

    public String getLatestIDDA() {
        String sqlQuery = "Select * from " + tableName + " order by staffid";
        ResultSet rs = null;
        String staffID = "";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                staffID = rs.getString("staffid");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return staffID;

    }

    public void createStaffRecordDA(Staff staff) {
        String sqlQuery = "Insert into " + tableName + " values(?,?,?,?,?,?,?,?)";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, staff.getStaffID());
            stmt.setString(2, staff.getFirstName());
            stmt.setString(3, staff.getLastName());
            stmt.setString(4, staff.getContactNo());
            stmt.setString(5, staff.getEmail());
            stmt.setString(6, staff.getAddress());
            stmt.setString(7, staff.getStatus());
            stmt.setString(8, staff.getPassword());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public ArrayList<Staff> retrieveStaffRecordDA(){
        String sqlQuery = "Select * from " + tableName;
        ResultSet rs = null;
        Staff staff = null;
        
        try{
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while(rs.next()){
                staffRecord.add(new Staff(rs.getString("staffid"),rs.getString("firstname"),rs.getString("lastname"),
                        rs.getString("contactno"),rs.getString("email"),rs.getString("address"),rs.getString("status"),
                        rs.getString("password")));
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return staffRecord;
        
        
    }
    
    public Staff retrieveStaffRecordDA(String staffID){
        String sqlQuery = "Select * from " + tableName + " where staffid = ?";
        ResultSet rs = null;
        Staff staff = null;
        try{
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1,staffID);
            rs = stmt.executeQuery();
            if(rs.next()){
                staff = new Staff(rs.getString("staffid"),rs.getString("firstname"),rs.getString("lastname"),
                        rs.getString("contactno"),rs.getString("email"),rs.getString("address"),rs.getString("status"),
                        rs.getString("password"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
        
    }
    
    public void updateStaffRecordDA(Staff staff){
        String sqlQuery = "Update " + tableName + " set contactno = ?, email = ?, address = ?, password = ?, status = ? where staffid = ?";
        try{
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1,staff.getContactNo());
            stmt.setString(2,staff.getEmail());
            stmt.setString(3,staff.getAddress());
            stmt.setString(4,staff.getPassword());
            stmt.setString(5,staff.getStatus());
            stmt.setString(6,staff.getStaffID());
            stmt.executeUpdate();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void deleteStaffRecordDA(String staffID){
        String sqlQuery = "Delete from " + tableName + " where staffid = ?";
        try{
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, staffID);
            stmt.executeUpdate();
        }catch(SQLException ex){
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
