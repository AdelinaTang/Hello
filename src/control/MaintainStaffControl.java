//Author : Chow Hui Pin

package control;
import da.*;
import domain.*;
import java.util.ArrayList;

public class MaintainStaffControl {
    
    private StaffDA staffDA;
    
    public MaintainStaffControl(){
        staffDA = new StaffDA();
    }
    
    public Staff retrieveStaffRecordControl(String userName, String password){
        return staffDA.retrieveStaffRecordDA(userName,password);
    }
    
    public String getLatestIDControl(){
        return staffDA.getLatestIDDA();
    }
    
    public void createStaffRecordControl(Staff staff){
        staffDA.createStaffRecordDA(staff);
    }
    
    public ArrayList<Staff> retrieveStaffRecordControl(){
        return staffDA.retrieveStaffRecordDA();
    }
    
    public Staff retrieveStaffRecordControl(String staffID){
        return staffDA.retrieveStaffRecordDA(staffID);
    }
    
    public void updateStaffRecordControl(Staff staff){
        staffDA.updateStaffRecordDA(staff);
    }
    
    public void deleteStaffRecordControl(String staffID){
        staffDA.deleteStaffRecordDA(staffID);
    }

    
    
}
