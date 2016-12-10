//Author : Chin Wei Song

package domain;

public class Food {

    private int foodOrderID;
    private Menus menus = new Menus();
    private Orders orders = new Orders();
    private int quantity;

    public Food(int foodOrderID, Menus menus, Orders orders, int quantity) {
        this.foodOrderID = foodOrderID;
        this.menus = menus;
        this.orders = orders;
        this.quantity = quantity;
    }

    public Food(Orders order1, Seat seat, Menus menu, int quantity, Orders order3) {
        orders.setOrderID(order1.getOrderID());
        orders.setSeat(seat);
        menus.setFoodID(menu.getFoodID());
        this.quantity = quantity;
        orders.setDateOrder(order3.getOrderID());
    }

    public Food() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getFoodOrderID() {
        return foodOrderID;
    }

    public void setFoodOrderID(int foodOrderID) {
        this.foodOrderID = foodOrderID;
    }

    public Menus getMenu() {
        return menus;
    }

    public void setMenu(Menus menus) {
        this.menus = menus;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return foodOrderID + " " + menus + " " + orders + " " + quantity;
    }

}
