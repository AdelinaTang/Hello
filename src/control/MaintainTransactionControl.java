//Author : Adelina Tang Chooi Li

package control;

import da.*;
import domain.*;
import java.util.ArrayList;

public class MaintainTransactionControl {
    
    private TransactionDA transactionDA;
    
    public MaintainTransactionControl(){
        transactionDA = new TransactionDA();
    }
    
    public String getLatestIDControl(){
        return transactionDA.getLatestIDDA();
    }
    
    public void createTransactionRecordControl(Payment payment){
        transactionDA.createTransactionRecordDA(payment);
    }
    
    public Payment retrieveTransactionRecordControl(String transactionID){
        return transactionDA.retrieveTransactionRecordDA(transactionID);
    }
    
    public ArrayList<Payment> retrieveTransactionRecordControl(){
        return transactionDA.retrieveTransactionRecordDA();
    }
    
    public ArrayList<String> retrieveTransactionOrderID(){
        return transactionDA.retrieveTransactionOrderID();
        
    }
    
    
}
