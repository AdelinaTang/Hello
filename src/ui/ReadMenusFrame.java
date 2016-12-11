//Author : Choo Yee Ling
package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;

public class ReadMenusFrame extends JFrame {

    private MaintainMenusControl maintainMenusControl = new MaintainMenusControl();
    private ArrayList<Menus> readMenu = maintainMenusControl.retrieveMenusRecordControl();

    public ReadMenusFrame() {

        JTable jtbMenu = new JTable();
        String[] columnNames = {"FoodID", "FoodName", "Category", "Description", "PricePerUnit", "Status"};
        Object[][] data = {};

        DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(detailsTableModel);

        jtbMenu.setRowSorter(sorter);

        for (int i = 0; i < readMenu.size(); i++) {
            detailsTableModel.addRow(new Object[]{readMenu.get(i).getFoodID(), readMenu.get(i).getFoodName(),
                readMenu.get(i).getCategory(), readMenu.get(i).getDescription(), readMenu.get(i).getPricePerUnit(),
                readMenu.get(i).getStatus()}
            );
        }

        jtbMenu.setModel(detailsTableModel);
        jtbMenu.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbMenu.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(jtbMenu);
        add(jsp);

        jtbMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jtbMenu.rowAtPoint(evt.getPoint());
                for (int i = 0; i < readMenu.size(); i++) {
                    if (row == i) {
                        new FoodClick(i);
                    }
                }
            }
        });

        setTitle("Read Menu");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 300);
    }

    public static void main(String[] args) {
        new ReadMenusFrame();
    }

}
