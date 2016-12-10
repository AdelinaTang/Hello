//Author : Choo Yee Ling

package da;

import javax.swing.*;
import java.sql.*;
import domain.*;
import java.util.ArrayList;

public class SeatDA {

    private String host = "jdbc:derby://localhost:1527/guiassignment";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "Seat";
    private Connection conn;
    private PreparedStatement stmt;
    private ArrayList<Seat> seatRecord = new ArrayList<Seat>();

    public SeatDA() {
        createConnection();
    }

    public int getLatestIDDA() {
        String sqlQuery = "Select * from " + tableName + " order by seatno";
        ResultSet rs = null;
        int seatNo = 0;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                seatNo = Integer.parseInt(rs.getString("seatno"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return seatNo;

    }

    public void createSeatRecordDA(Seat seat) {
        String sqlQuery = "Insert into " + tableName + " values(?,?,?,?)";
        String seatNo = String.valueOf(seat.getSeatNo());
        String numberOfChairs = String.valueOf(seat.getNumberOfChairs());
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, seatNo);
            stmt.setString(2, seat.getSeatAvailability());
            stmt.setString(3, seat.getSeatSize());
            stmt.setString(4, numberOfChairs);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public ArrayList<Seat> retrieveSeatRecordDA() {
        String sqlQuery = "Select * from " + tableName;
        ResultSet rs = null;
        Seat seat = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            rs = stmt.executeQuery();
            while (rs.next()) {
                seatRecord.add(new Seat(Integer.parseInt(rs.getString("seatno")), rs.getString("seatavailability"), rs.getString("seatsize"),
                        Integer.parseInt(rs.getString("numberofchairs"))));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return seatRecord;

    }

    public Seat retrieveSeatRecordDA(int seatNo) {
        String sqlQuery = "Select * from " + tableName + " where seatNo = ?";
        ResultSet rs = null;
        Seat seat = null;
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(seatNo));
            rs = stmt.executeQuery();
            if (rs.next()) {
                seat = new Seat(Integer.parseInt(rs.getString("seatno")), rs.getString("seatavailability"), rs.getString("seatsize"),
                        Integer.parseInt(rs.getString("numberofchairs")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return seat;

    }

    public void updateSeatRecordDA(Seat seat) {
        String sqlQuery = "Update " + tableName + " set seatsize = ?, numberofchairs = ? where seatno = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, seat.getSeatSize());
            stmt.setString(2, String.valueOf(seat.getNumberOfChairs()));
            stmt.setString(3, String.valueOf(seat.getSeatNo()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void changeSeatAvailabilityDA(Seat seat) {
        String sqlQuery = "Update " + tableName + " set seatavailability = ? where seatno = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, seat.getSeatAvailability());
            stmt.setString(2, String.valueOf(seat.getSeatNo()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteSeatRecordDA(int seatNo) {
        try {
            String sqlQuery = "Delete from " + tableName + " where seatNo = ?";
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, String.valueOf(seatNo));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void updateSeatAvailabilityDA(int seatNumber) {
        String sqlQuery = "Update " + tableName + " set seatavailability = ? where seatno = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, "Available");
            stmt.setString(2, String.valueOf(seatNumber));
            stmt.executeUpdate();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void updateSeatAvailabilityDA2(int seatNumber) {
        String sqlQuery = "Update " + tableName + " set seatavailability = ? where seatno = ?";
        try {
            stmt = conn.prepareStatement(sqlQuery);
            stmt.setString(1, "Unavailable");
            stmt.setString(2, String.valueOf(seatNumber));
            stmt.executeUpdate();
        }catch (SQLException ex) {
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
