package ui;

import domain.*;
import control.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import java.awt.Dimension;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class CreateOrdersFrame extends JFrame {

    private MaintainOrdersControl maintainOrdersControl = new MaintainOrdersControl();
    private MaintainSeatControl maintainSeatControl = new MaintainSeatControl();
    private MaintainMenusControl maintainMenusControl = new MaintainMenusControl();
    private ArrayList<Menus> readMenu = maintainMenusControl.retrieveMenusRecordControl();
    private Menus menu = null;
    private Orders orders = null;
    private ArrayList<Seat> seat = null;
    private JTextField jtfOrderID = new JTextField();
    private DefaultComboBoxModel model = new DefaultComboBoxModel();
    private JComboBox jcbSeatNo = new JComboBox(model);
    private JTextField jtfDate = new JTextField();

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date dateObj = new Date();
    String orderID = "";

    public CreateOrdersFrame() {

        JPanel p1 = new JPanel(new GridLayout(3, 2, 3, 8));
        p1.add(new JLabel("Order ID"));
        p1.add(jtfOrderID);
        p1.add(new JLabel("Seat No"));
        p1.add(jcbSeatNo);
        p1.add(new JLabel("Date"));
        p1.add(jtfDate);

        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 3, 29));

        JTable jtbMenu = new JTable();
        String[] columnNames = {"FoodID", "FoodName", "Category", "Description", "PricePerUnit", "Status"};
        Object[][] data = {};

        DefaultTableModel detailsTableModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (int i = 0; i < readMenu.size(); i++) {
            if (readMenu.get(i).getStatus().equals("Active")) {
                detailsTableModel.addRow(new Object[]{readMenu.get(i).getFoodID(), readMenu.get(i).getFoodName(),
                    readMenu.get(i).getCategory(), readMenu.get(i).getDescription(), readMenu.get(i).getPricePerUnit(),
                    readMenu.get(i).getStatus()}
                );
            }

        }

        jtbMenu.setModel(detailsTableModel);
        jtbMenu.setPreferredScrollableViewportSize(new Dimension(450, 63));
        jtbMenu.setFillsViewportHeight(true);
        JScrollPane jsp = new JScrollPane(jtbMenu);
        p2.add(jsp);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel outerPanel = new JPanel(new BorderLayout());
        outerPanel.add(p1, BorderLayout.NORTH);
        outerPanel.add(p2, BorderLayout.CENTER);
        outerPanel.add(p3, BorderLayout.SOUTH);

        JPanel bigPanel = new JPanel();

        bigPanel.setBorder(new TitledBorder("Create Orders"));
        bigPanel.add(outerPanel);
        add(bigPanel);

        setTitle("Create Order");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600, 400);

        orderID = generateOrderID();
        String date = dateFormat.format(dateObj);
        jtfDate.setEditable(false);
        jtfDate.setText(date);

        seat = maintainSeatControl.retrieveSeatRecordControl();
        for (int i = 0; i < seat.size(); i++) {
            if (seat.get(i).getSeatAvailability().equals("Available")) {
                model.addElement(seat.get(i).getSeatNo());
            }
        }

        jtbMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    int seatNo = (int) jcbSeatNo.getSelectedItem();

                    Seat seat = maintainSeatControl.retrieveSeatRecordControl(seatNo);

                    orders = new Orders(jtfOrderID.getText(), seat, date);

                    jcbSeatNo.setEnabled(false);
                    String id = maintainOrdersControl.checkOrdersRecordControl(jtfOrderID.getText());
                    if (id == "") {
                        maintainOrdersControl.createOrdersRecordControl(orders);
                    }
                    int row = jtbMenu.rowAtPoint(evt.getPoint());
                    for (int i = 0; i < detailsTableModel.getRowCount(); i++) {
                        if (row == i) {
                            menu = new Menus(detailsTableModel.getValueAt(i, 0).toString(),
                                    detailsTableModel.getValueAt(i, 1).toString(), detailsTableModel.getValueAt(i, 2).toString(),
                                    detailsTableModel.getValueAt(i, 3).toString(), Double.parseDouble(detailsTableModel.getValueAt(i, 4).toString()),
                                    detailsTableModel.getValueAt(i, 5).toString());
                            new OrderFrame(menu, orders);
                        }
                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "All seats are currently being occupied");
                }
            }
        });

    }

    public String generateOrderID() {
        String orderID = maintainOrdersControl.getLatestIDControl();
        if (orderID.equals("")) {
            orderID = "O000";
        }
        int lastThreeDigit = Integer.parseInt(orderID.substring(1, 4));
        String incrementedOrderID = String.format("O%03d", (lastThreeDigit + 1));
        jtfOrderID.setEditable(false);
        jtfOrderID.setText(incrementedOrderID);
        return incrementedOrderID;
    }

    public static void main(String[] args) {
        new CreateOrdersFrame();
    }

}
