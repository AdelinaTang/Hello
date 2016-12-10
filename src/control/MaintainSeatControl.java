//Author : Choo Yee Ling

package control;

import da.*;
import domain.*;
import java.util.ArrayList;

public class MaintainSeatControl {
    private SeatDA seatDA;
    
    public MaintainSeatControl(){
        seatDA = new SeatDA();
    }
    public int getLatestIDControl(){
        return seatDA.getLatestIDDA();
    }
    
    public void createSeatRecordControl(Seat seat){
        seatDA.createSeatRecordDA(seat);
    }
    
    public ArrayList<Seat> retrieveSeatRecordControl(){
        return seatDA.retrieveSeatRecordDA();
    }
    
    public Seat retrieveSeatRecordControl(int seatNo){
        return seatDA.retrieveSeatRecordDA(seatNo);
    }
    
    public void updateSeatRecordControl(Seat seat){
        seatDA.updateSeatRecordDA(seat);
    }
    
       public void changeSeatAvailability(Seat seat){
        seatDA.changeSeatAvailabilityDA(seat);
    }
       
    public void deleteSeatRecordControl(int seatNo){
        seatDA.deleteSeatRecordDA(seatNo);
    }
    
    public void updateSeatAvailabilityControl(int seatNumber){
        seatDA.updateSeatAvailabilityDA(seatNumber);
        
    }
    
    public void updateSeatAvailabilityControl2(int seatNumber){
        seatDA.updateSeatAvailabilityDA2(seatNumber);
        
    }
}
