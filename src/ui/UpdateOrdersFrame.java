package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import domain.*;
import control.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class UpdateOrdersFrame extends JFrame {

    private MaintainOrdersControl maintainOrdersControl = new MaintainOrdersControl();
    private MaintainFoodControl maintainFoodControl = new MaintainFoodControl();
    private MaintainMenusControl maintainMenusControl = new MaintainMenusControl();
    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private MaintainTransactionControl maintainTransactionControl = new MaintainTransactionControl();
    private ArrayList<Menus> readMenu = maintainMenusControl.retrieveMenusRecordControl();
    private ArrayList<String> readOrderID = maintainTransactionControl.retrieveTransactionOrderID();
    private ArrayList<String> readOrderNo = maintainOrdersControl.retrieveOrderNo();
    private ArrayList<Seat> readSeat;
    private ArrayList<Orders> orders = null;
    private ArrayList<Orders> orders2 = null;
    private ArrayList<Food> food = null;
    private ArrayList<Food> temp3 = new ArrayList<Food>();
    private ArrayList<Menus> menus = null;
    private ArrayList<Orders> quantity = null;
    private Menus temp = null;
    private Orders temp2 = null;
    private Food foodRecord = null;
    private JLabel jlbOrderID = new JLabel("Order ID");
    private JLabel jlbSeatNo = new JLabel("Seat No");
    private JLabel jlbDate = new JLabel("Date");
    private JTextField jtfDate = new JTextField();
    private JTextField jtfSeatNo = new JTextField();
    private ArrayList<Food> test = new ArrayList<Food>();
    private Menus menu = null;
    private ArrayList<String> comboBox = new ArrayList<String>();
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
     private JComboBox jcbOrderID = new JComboBox(model);
    int count = 0;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateObj = new Date();
    String dateOrder = dateFormat.format(dateObj);

    public UpdateOrdersFrame() {

        orders = maintainOrdersControl.retrieveOrdersRecordControl();
        
        for(int k = 0 ; k < readOrderNo.size() ; k++){
            count = 0;
            for(int j = 0 ; j < readOrderID.size() ; j++){
                if(!(readOrderNo.get(k).equals(readOrderID.get(j)))){
                    count++;
                }
                
            }
            if(count == readOrderID.size()){
                comboBox.add(readOrderNo.get(k));
            }
        }
        
        for (int i = 0; i < comboBox.size(); i++) {
            //jcbOrderID.addItem(orders.get(i).getOrderID());
             model.addElement(comboBox.get(i));
        }

        JPanel p1 = new JPanel(new GridLayout(3, 2));
        p1.add(new JLabel("Order ID"));
        p1.add(jcbOrderID);
        p1.add(new JLabel("Seat No"));
        p1.add(jtfSeatNo);
        p1.add(new JLabel("Date"));
        p1.add(jtfDate);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 10));

        JTable jtbMenu = new JTable();
        String[] columnNames = {"FoodID", "FoodName", "Category", "Description", "PricePerUnit", "Quantity"};
        Object[][] data = {};

        DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        jtbMenu.setModel(detailsTableModel);
        jtbMenu.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbMenu.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(jtbMenu);
        p2.add(jsp);

        JPanel p2BigPanel = new JPanel(new BorderLayout());
        p2BigPanel.add(new JLabel("Current Order List : "));
        p2BigPanel.add(p2, BorderLayout.SOUTH);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 15));

        //a list of food
        JTable jtbMenu2 = new JTable();
        String[] columnNames2 = {"FoodID", "FoodName", "Category", "Description", "PricePerUnit", "Status"};
        Object[][] data2 = {};

        DefaultTableModel detailsTableModel2 = new DefaultTableModel(data2, columnNames2) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (int i = 0; i < readMenu.size(); i++) {
            if (readMenu.get(i).getStatus().equals("Active")) {
                detailsTableModel2.addRow(new Object[]{readMenu.get(i).getFoodID(), readMenu.get(i).getFoodName(),
                    readMenu.get(i).getCategory(), readMenu.get(i).getDescription(), readMenu.get(i).getPricePerUnit(),
                    readMenu.get(i).getStatus()}
                );
            }

        }

        TableRowSorter<TableModel> sorter
                = new TableRowSorter<TableModel>(detailsTableModel);

        jtbMenu.setRowSorter(sorter);

        TableRowSorter<TableModel> sorter2
                = new TableRowSorter<TableModel>(detailsTableModel2);

        jtbMenu2.setRowSorter(sorter2);

        jtbMenu2.setModel(detailsTableModel2);
        jtbMenu2.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbMenu2.setFillsViewportHeight(true);
        JScrollPane jsp2 = new JScrollPane(jtbMenu2);
        p3.add(jsp2);
        //
        JPanel p3BigPanel = new JPanel(new BorderLayout());
        p3BigPanel.add(new JLabel("To add more food, please select the food below :"));
        p3BigPanel.add(p3, BorderLayout.SOUTH);

        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.add(p1, BorderLayout.NORTH);
        outerPanel.add(p2BigPanel, BorderLayout.CENTER);
        outerPanel.add(p3BigPanel, BorderLayout.SOUTH);

        JPanel bigPanel = new JPanel();

        bigPanel.setBorder(new TitledBorder("Update Orders"));
        bigPanel.add(outerPanel);
        add(bigPanel);

        jcbOrderID.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                detailsTableModel.setRowCount(0);
                String orderID = (String) jcbOrderID.getSelectedItem();
                Orders orders = maintainOrdersControl.retrieveOrdersRecordControl(orderID);
                jtfDate.setText(orders.getDateOrder());
                jtfDate.setEditable(false);
                jtfSeatNo.setText(String.valueOf(orders.getSeat().getSeatNo()));
                jtfSeatNo.setEditable(false);
                orders2 = maintainOrdersControl.retrieveOrdersRecordControl();
                food = maintainFoodControl.retrieveFoodRecordControl(orderID);
                temp3.clear();
                for (int j = 0; j < food.size(); j++) {

                    detailsTableModel.addRow(new Object[]{food.get(j).getMenu().getFoodID(), food.get(j).getMenu().getFoodName(),
                        food.get(j).getMenu().getCategory(), food.get(j).getMenu().getDescription(), food.get(j).getMenu().getPricePerUnit(),
                        food.get(j).getQuantity()});
                    temp3.add(new Food(food.get(j).getFoodOrderID(), food.get(j).getMenu(), food.get(j).getOrders(), food.get(j).getQuantity()));
                    //System.out.println(j);
                }

                food.clear();

            }

        });

        jtbMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (food != null) {
                    String orderID = (String) jcbOrderID.getSelectedItem();
                    food.clear();
                    food = maintainFoodControl.retrieveFoodRecordControl(orderID);
                    orders2 = maintainOrdersControl.retrieveOrdersRecordControl();
                    temp3.clear();

                    for (int j = 0; j < food.size(); j++) {
                        temp3.add(new Food(food.get(j).getFoodOrderID(), food.get(j).getMenu(), food.get(j).getOrders(), food.get(j).getQuantity()));
                    }
                    int row = jtbMenu.rowAtPoint(evt.getPoint());

                    for (int i = 0; i < detailsTableModel.getRowCount(); i++) {

                        if (row == i) {

                            temp = new Menus(temp3.get(i).getMenu().getFoodID(),
                                    temp3.get(i).getMenu().getFoodName(), temp3.get(i).getMenu().getCategory(),
                                    temp3.get(i).getMenu().getDescription(), temp3.get(i).getMenu().getPricePerUnit(),
                                    temp3.get(i).getMenu().getStatus());

                            temp2 = new Orders(orders2.get(i).getOrderID(), orders2.get(i).getSeat(), orders2.get(i).getDateOrder());

                            foodRecord = new Food(temp3.get(i).getFoodOrderID(),
                                    temp, temp2, temp3.get(i).getQuantity());
                            new OrderFrame(foodRecord, detailsTableModel, temp3, jcbOrderID);

                        }
                    }
                }
            }
        });

        jtbMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    int row2 = jtbMenu2.rowAtPoint(evt.getPoint());

                    for (int j = 0; j < detailsTableModel2.getRowCount(); j++) {

                        if (row2 == j) {
                            menu = new Menus(detailsTableModel2.getValueAt(j, 0).toString(),
                                    detailsTableModel2.getValueAt(j, 1).toString(), detailsTableModel2.getValueAt(j, 2).toString(),
                                    detailsTableModel2.getValueAt(j, 3).toString(), Double.parseDouble(detailsTableModel2.getValueAt(j, 4).toString()),
                                    detailsTableModel2.getValueAt(j, 5).toString());
                            Seat seat = maintainSeatControl.retrieveSeatRecordControl(Integer.parseInt(jtfSeatNo.getText()));

                            Orders ord = new Orders(jcbOrderID.getSelectedItem().toString(), seat, jtfDate.getText());
                            new OrderFrame(menu, ord, detailsTableModel, temp3, jtbMenu);
                        }

                    }
                } catch (NumberFormatException ex) {

                }
            }
        });

        setTitle("Update Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 450);

    }

    public static void main(String[] args) {
        new UpdateOrdersFrame();
    }

}
