//Author : Choo Yee Ling

package domain;

public class Seat {

    private int seatNo;
    private String seatAvailability;
    private String seatSize;
    private int numberOfChairs;

    public Seat(int seatNo) {
        this.seatNo = seatNo;
    }

    public Seat(int seatNo, String seatAvailability, String seatSize, int numberOfChairs) {
        this.seatNo = seatNo;
        this.seatAvailability = seatAvailability;
        this.seatSize = seatSize;
        this.numberOfChairs = numberOfChairs;
    }

    public Seat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatAvailability() {
        return seatAvailability;
    }

    public void setSeatAvailability(String seatAvailability) {
        this.seatAvailability = seatAvailability;
    }

    public String getSeatSize() {
        return seatSize;
    }

    public void setSeatSize(String seatSize) {
        this.seatSize = seatSize;
    }

    public int getNumberOfChairs() {
        return numberOfChairs;
    }

    public void setNumberOfChairs(int numberOfChairs) {
        this.numberOfChairs = numberOfChairs;
    }

    @Override
    public String toString() {
        return seatNo + " " + seatAvailability + " " + seatSize + " " + numberOfChairs;
    }

}
