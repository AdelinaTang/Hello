//Author : Chow Hui Pin

package control;

import da.*;
import domain.*;
import java.util.ArrayList;

public class MaintainCustomerControl {
    
    private CustomerDA customerDA;
    
    public MaintainCustomerControl(){
         customerDA = new CustomerDA();
    }
    
    public void createCustomerRecordControl(Customer customer){
        customerDA.createCustomerRecordDA(customer);
    }
    
    public String getLatestIDControl(){
        return customerDA.getLatestIDDA();
    }
    
    public ArrayList<Customer> retrieveCustomerRecordControl(){
        return customerDA.retrieveCustomerRecordDA();
    }
    
    public Customer retrieveCustomerRecordControl(String customerID){
        return customerDA.retrieveCustomerRecordDA(customerID);
    }
    
    public Customer retrieveCustomerRecordICControl(String icNo){
        return customerDA.retrieveCustomerRecordICDA(icNo);
    }
    
    public void updateCustomerRecordControl(Customer customer){
        customerDA.updateCustomerRecordDA(customer);
    }
    
    public void deleteCustomerRecordControl(String customerID){
        customerDA.deleteCustomerRecordDA(customerID);
    }
    
    public void updateRenewCustomerRecordControl(String icNo){
        customerDA.updateRenewCustomerRecordDA(icNo);
    }
    
    public ArrayList<String> retrieveCustomerRecordICControl(){
        return customerDA.retrieveCustomerRecordICDA();
    } 
    
    public void updateCustomerRecordControl(String customerID, int newLoyaltyPointBalance2){
        customerDA.updateCustomerRecordDA(customerID,newLoyaltyPointBalance2);
    }
    
    public void deleteCustomerRecordControl2(String ICNo){
        customerDA.deleteCustomerRecordDA2(ICNo);
    }
}
