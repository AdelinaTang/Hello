//Author : Chin Wei Song

package domain;

import java.util.Date;

public class Orders {

    private String orderID;
    private Seat seat;
    private String dateOrder;

    public Orders() {

    }

    public Orders(String orderID, Seat seat, String dateOrder) {
        this.orderID = orderID;
        this.seat = seat;
        this.dateOrder = dateOrder;
    }

    public Orders(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    @Override
    public String toString() {
        return orderID + " " + seat + " " + dateOrder;
    }

}
