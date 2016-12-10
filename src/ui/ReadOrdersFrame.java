package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;

public class ReadOrdersFrame extends JFrame {
    
    private MaintainFoodControl maintainFoodControl = new MaintainFoodControl();
    private ArrayList<Food> readFood = maintainFoodControl.retrieveFoodRecordControl();
    
    public ReadOrdersFrame() {
        
        JTable jtbOrder = new JTable();
        String[] columnNames = {"OrderID", "SeatNo", "FoodID", "Quantity", "DateOrder"};
        Object[][] data = {};
        
        DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(detailsTableModel);
        
        jtbOrder.setRowSorter(sorter);
        
        for (int i = 0; i < readFood.size(); i++) {
            detailsTableModel.addRow(new Object[]{readFood.get(i).getOrders().getOrderID(), readFood.get(i).getOrders().getSeat().getSeatNo(), readFood.get(i).getMenu().getFoodID(), readFood.get(i).getQuantity(), readFood.get(i).getOrders().getDateOrder()});
        }
        
        jtbOrder.setModel(detailsTableModel);
        jtbOrder.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbOrder.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(jtbOrder);
        add(jsp);
        
        jtbOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jtbOrder.rowAtPoint(evt.getPoint());
                for (int i = 0; i < readFood.size(); i++) {
                    if (row == i) {
                        new OrderClick(i);
                    }
                }
            }
        });
        
        setTitle("Read Orders");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 300);
    }
    
    public static void main(String[] args) {
        new ReadOrdersFrame();
    }
    
}
