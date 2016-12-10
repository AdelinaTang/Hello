package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import control.*;
import domain.*;

public class OrderFrame extends JFrame {

    private MaintainMenusControl maintainMenusControl = new MaintainMenusControl();
    private MaintainFoodControl maintainFoodControl = new MaintainFoodControl();
    private ArrayList<Menus> readMenu = maintainMenusControl.retrieveMenusRecordControl();
    private MaintainOrdersControl maintainOrdersControl = new MaintainOrdersControl();
    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private Food food = null;
    private JTextField jtfFoodID = new JTextField();
    private JTextField jtfFoodName = new JTextField();
    private JTextField jtfCategory = new JTextField();
    private JTextField jtfPrice = new JTextField();
    private JTextField jtfQuantity = new JTextField();
    private JButton jbtOk = new JButton("Ok");
    private JButton jbtCancel = new JButton("Cancel");
    private JButton jbtDelete = new JButton("Delete");
    private Food foodupdate = null;
    private ArrayList<Food> arrList = null;
    int foodOrderID = 0;

    public OrderFrame() {
    }

    public OrderFrame(Food foodRecord, DefaultTableModel detailsTableModel, ArrayList<Food> temp3, JComboBox jcbOrderID) {

        foodOrderID = generateFoodOrderID();
        setLayout(new GridLayout(6, 2, 3, 9));
        setTitle("Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(400, 270);

        jtfFoodID.setText(foodRecord.getMenu().getFoodID());
        jtfFoodName.setText(foodRecord.getMenu().getFoodName());
        jtfCategory.setText(foodRecord.getMenu().getCategory());
        jtfPrice.setText(String.format("RM %.2f", foodRecord.getMenu().getPricePerUnit()));
        jtfQuantity.setText(String.valueOf(foodRecord.getQuantity()));
        jtfFoodID.setEditable(false);
        jtfFoodName.setEditable(false);
        jtfCategory.setEditable(false);
        jtfPrice.setEditable(false);

        add(new JLabel("Food ID"));
        add(jtfFoodID);
        add(new JLabel("Food Name"));
        add(jtfFoodName);
        add(new JLabel("Category"));
        add(jtfCategory);
        add(new JLabel("Price"));
        add(jtfPrice);
        add(new JLabel("Quantity"));
        add(jtfQuantity);
        add(jbtOk);
        add(jbtDelete);

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean valid = validateInput(jtfQuantity.getText());
                if (valid) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm to update?", "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        foodupdate = new Food(foodRecord.getFoodOrderID(), foodRecord.getMenu(), foodRecord.getOrders(), Integer.parseInt(jtfQuantity.getText()));
                        maintainFoodControl.updateFoodRecordControl(foodupdate);
                        JOptionPane.showMessageDialog(null, "Order is successfully updated");
                        dispose();

                        for(int i = 0; i < temp3.size(); i++) {                          
                            if (foodRecord.getFoodOrderID() == temp3.get(i).getFoodOrderID()) {
                                detailsTableModel.setValueAt(foodupdate.getQuantity(), i, 5);
                            }
                        }

                    }
                }

            }
        });
        
        jbtCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        jbtDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Confirm to delete?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {

                    maintainFoodControl.deleteFoodRecordControl(foodRecord.getFoodOrderID());
                    JOptionPane.showMessageDialog(null, "Record is successfully deleted");
                    dispose();
                    for (int i = 0; i < temp3.size(); i++) {
                        if (foodRecord.getFoodOrderID() == temp3.get(i).getFoodOrderID()) {
                            detailsTableModel.removeRow(i);
                            temp3.remove(i);

                        }

                    }
                }
            }
        });

    }

    public OrderFrame(Menus menu, Orders orders, DefaultTableModel detailsTableModel, ArrayList<Food> temp3,JTable jtbMenu) {

        foodOrderID = generateFoodOrderID();
        setLayout(new GridLayout(6, 2, 3, 9));
        setTitle("Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(400, 270);

        jtfFoodID.setText(menu.getFoodID());
        jtfFoodName.setText(menu.getFoodName());
        jtfCategory.setText(menu.getCategory());
        jtfPrice.setText(String.format("RM %.2f", menu.getPricePerUnit()));
        jtfFoodID.setEditable(false);
        jtfFoodName.setEditable(false);
        jtfCategory.setEditable(false);
        jtfPrice.setEditable(false);
        add(new JLabel("Food ID"));
        add(jtfFoodID);
        add(new JLabel("Food Name"));
        add(jtfFoodName);
        add(new JLabel("Category"));
        add(jtfCategory);
        add(new JLabel("Price"));
        add(jtfPrice);
        add(new JLabel("Quantity"));
        add(jtfQuantity);
        add(jbtOk);
        add(jbtCancel);

        foodOrderID = generateFoodOrderID();

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean valid = validateInput(jtfQuantity.getText());
                if (valid) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm to add?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        Food ft = maintainFoodControl.retrieveFoodRecordControl2(menu.getFoodID(),orders.getOrderID());
                        if (ft != null) {
                            Food f = new Food(ft.getFoodOrderID(), ft.getMenu(), ft.getOrders(), Integer.parseInt(jtfQuantity.getText()) + ft.getQuantity());

                            maintainFoodControl.updateFoodRecordControl(f);
                        } else {
                            food = new Food(foodOrderID, menu, orders, Integer.parseInt(jtfQuantity.getText()));
                            maintainFoodControl.createFoodRecordControl(food);
                        }

                        JOptionPane.showMessageDialog(null, "Order is successfully added");
                        dispose();
                        //temp3.clear();
                        detailsTableModel.setRowCount(0);
                        arrList = maintainFoodControl.retrieveFoodRecordControl(orders.getOrderID());
                        for (int k = 0; k < arrList.size(); k++) {

                            detailsTableModel.addRow(new Object[]{arrList.get(k).getMenu().getFoodID(), arrList.get(k).getMenu().getFoodName(),
                                arrList.get(k).getMenu().getCategory(), arrList.get(k).getMenu().getDescription(), arrList.get(k).getMenu().getPricePerUnit(),
                                arrList.get(k).getQuantity()});
                            //temp3.add(new Food(arrList.get(k).getFoodOrderID(), arrList.get(k).getMenu(), arrList.get(k).getOrders(), arrList.get(k).getQuantity()));
                            
                        }
                        jtbMenu.setModel(detailsTableModel);
                    }
                }

            }

        });
        
        jbtCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public OrderFrame(Menus menu, Orders orders) {

        foodOrderID = generateFoodOrderID();
        setLayout(new GridLayout(6, 2, 3, 9));
        setTitle("Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(400, 270);

        jtfFoodID.setText(menu.getFoodID());
        jtfFoodName.setText(menu.getFoodName());
        jtfCategory.setText(menu.getCategory());
        jtfPrice.setText(String.format("RM %.2f", menu.getPricePerUnit()));
        jtfFoodID.setEditable(false);
        jtfFoodName.setEditable(false);
        jtfCategory.setEditable(false);
        jtfPrice.setEditable(false);
        add(new JLabel("Food ID"));
        add(jtfFoodID);
        add(new JLabel("Food Name"));
        add(jtfFoodName);
        add(new JLabel("Category"));
        add(jtfCategory);
        add(new JLabel("Price"));
        add(jtfPrice);
        add(new JLabel("Quantity"));
        add(jtfQuantity);
        add(jbtOk);
        add(jbtCancel);

                        System.out.println(orders.getSeat().getSeatNo());
        foodOrderID = generateFoodOrderID();

        jbtOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean valid = validateInput(jtfQuantity.getText());
                if (valid) {
                    int option = JOptionPane.showConfirmDialog(null, "Confirm to add?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        food = new Food(foodOrderID, menu, orders, Integer.parseInt(jtfQuantity.getText()));
                        maintainFoodControl.createFoodRecordControl(food);

                        JOptionPane.showMessageDialog(null, "Order is successfully added");
                        maintainSeatControl.updateSeatAvailabilityControl2(orders.getSeat().getSeatNo());
                        dispose();

                    }
                }

            }

        });

        jbtCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

    }

    public boolean validateInput(String quantity) {
        if (quantity.equals("")) {
            JOptionPane.showMessageDialog(null, "Field cannot be left empty");
            jtfQuantity.requestFocusInWindow();
            return false;

        }
        for (int i = 0; i < quantity.length(); i++) {
            if (!Character.isDigit(quantity.charAt(i))) {
                JOptionPane.showMessageDialog(null, "Invalid quantity");
                jtfQuantity.setText("");
                jtfQuantity.requestFocusInWindow();
                return false;

            }
        }
        return true;
    }

    public int generateFoodOrderID() {

        int foodOrderID = maintainFoodControl.getLatestIDControl();
        int incrementedFoodOrderID = foodOrderID + 1;
        return incrementedFoodOrderID;
    }
}
