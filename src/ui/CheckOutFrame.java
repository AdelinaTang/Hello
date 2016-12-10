package ui;

import control.*;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CheckOutFrame extends JFrame {

    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private JComboBox jcbSeatNo = new JComboBox(model);
    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private MaintainFoodControl maintainFoodControl = new MaintainFoodControl();
    private MaintainOrdersControl maintainOrdersControl = new MaintainOrdersControl();
    private ArrayList<Seat> seatRecord = null;
    private ArrayList<Orders> ordersRecord = null;
    private ArrayList<Food> foodRecord = null;
    private JButton jbtSearch = new JButton("Search");
    private JTextField jtftotalAmount = new JTextField();
    private JButton jbtYes = new JButton("Yes");
    private JButton jbtNo = new JButton("No");
    double totalAmount = 0;
    String orderID = "";

    public CheckOutFrame(Staff staff) {

        jbtYes.setEnabled(false);
        jbtNo.setEnabled(false);
        JPanel p1 = new JPanel(new GridLayout(1, 3, 5, 9));
        p1.add(new JLabel("Seat No"));
        p1.add(jcbSeatNo);
        p1.add(jbtSearch);

        seatRecord = maintainSeatControl.retrieveSeatRecordControl();
        for (int i = 0; i < seatRecord.size(); i++) {
            if (seatRecord.get(i).getSeatAvailability().equals("Unavailable")) {
                model.addElement(seatRecord.get(i).getSeatNo());
            }
        }
        JPanel p2 = new JPanel();

        JTable jtbMenu = new JTable();
        String[] columnNames = {"FoodID", "OrderID", "FoodName", "Quantity", "PricePerUnit", "TotalPrice"};
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

        JPanel p3 = new JPanel(new GridLayout(1, 2));
        p3.add(new JLabel("Total Amount"));
        p3.add(jtftotalAmount, BorderLayout.EAST);

        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p2, BorderLayout.NORTH);
        p4.add(p3, BorderLayout.CENTER);

        JPanel p5 = new JPanel();
        p5.add(new JLabel("Are you a member?"));
        p5.add(jbtYes);
        p5.add(jbtNo);

        JPanel p6 = new JPanel(new BorderLayout(3, 3));
        p6.setBorder(new TitledBorder("Check Out"));
        p6.add(p1, BorderLayout.NORTH);
        p6.add(p4, BorderLayout.CENTER);
        p6.add(p5, BorderLayout.SOUTH);
        add(p6);

        int seatNumber;
        try {
            seatNumber = (int) jcbSeatNo.getSelectedItem();

            jbtSearch.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    detailsTableModel.setRowCount(0);

                    int seatNo = (int) jcbSeatNo.getSelectedItem();
                    ordersRecord = maintainOrdersControl.retrieveOrdersRecordControl(seatNo);
                    orderID = ordersRecord.get(ordersRecord.size() - 1).getOrderID();
                    foodRecord = maintainFoodControl.retrieveFoodRecordControl(orderID);

                    totalAmount = 0;
                    for (int i = 0; i < foodRecord.size(); i++) {
                        double totalPrice = foodRecord.get(i).getQuantity() * foodRecord.get(i).getMenu().getPricePerUnit();

                        detailsTableModel.addRow(new Object[]{foodRecord.get(i).getMenu().getFoodID(), foodRecord.get(i).getOrders().getOrderID(),
                            foodRecord.get(i).getMenu().getFoodName(), foodRecord.get(i).getQuantity(), foodRecord.get(i).getMenu().getPricePerUnit(),
                            totalPrice});
                        totalAmount += totalPrice;

                    }
                    jtftotalAmount.setEditable(false);
                    jtftotalAmount.setText(String.format("RM %.2f", totalAmount));
                    foodRecord.clear();
                    ordersRecord.clear();
                    jbtYes.setEnabled(true);
                    jbtNo.setEnabled(true);

                }

            });

            jbtYes.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();

                    new MemberFrame(totalAmount, orderID, staff, seatNumber, foodRecord);
                }
            });

            jbtNo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new NonMemberFrame(totalAmount, orderID, staff, seatNumber, foodRecord);
                }
            });
        } catch (NullPointerException ex) {

        }

        setTitle("Check Out");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();

    }

    public static void main(String[] args) {

    }

}
