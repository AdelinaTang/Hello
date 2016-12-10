//Author : Chin Wei Song

package control;

import da.*;
import domain.*;
import java.util.ArrayList;

public class MaintainOrdersControl {
    
    private OrdersDA ordersDA;
    
    public MaintainOrdersControl(){
         ordersDA = new OrdersDA();
    }
    
    public String getLatestIDControl(){
        return ordersDA.getLatestIDDA();
    }
    
    public String checkOrdersRecordControl(String orderID){
        return ordersDA.checkOrdersRecordDA(orderID);
    }
    
    public void createOrdersRecordControl(Orders orders){
        ordersDA.createOrdersRecordDA(orders);
    }
    
    public ArrayList<Orders> retrieveOrdersRecordControl(){
        return ordersDA.retrieveOrdersRecordDA();
    }
    public Orders retrieveOrdersRecordControl(String orderID){
        return ordersDA.retrieveOrdersRecordDA(orderID);
    }
    public String checkOrdersRecordControl(){
        return ordersDA.checkOrdersRecordDA();
    }
    
    public ArrayList<Orders> retrieveOrdersRecordControl(int seatNo){
        return ordersDA.retrieveOrdersRecordDA(seatNo);
    }
    
    public ArrayList<String> retrieveOrderNo(){
        return ordersDA.retrieveOrderNo();
    }
}
