//Author : Chow Hui Pin

package domain;

public class Customer {

    private String customerID;
    private String icNo;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;
    private String address;
    private String dateJoined;
    private String expiryDate;
    private int loyaltyPointBalance;
    private String status;
    private String oldID;

    public Customer(String customerID, String icNo, String firstName, String lastName, String contactNo, String email, String address, String dateJoined, String expiryDate, int loyaltyPointBalance, String status, String oldID) {
        this.customerID = customerID;
        this.icNo = icNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
        this.dateJoined = dateJoined;
        this.expiryDate = expiryDate;
        this.loyaltyPointBalance = loyaltyPointBalance;
        this.status = status;
        this.oldID = oldID;
    }

    public Customer(String toString) {

    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getICNo() {
        return icNo;
    }

    public void setICNo(String icNo) {
        this.icNo = icNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getLoyaltyPointBalance() {
        return loyaltyPointBalance;
    }

    public void setLoyaltyPointBalance(int loyaltyPointBalance) {
        this.loyaltyPointBalance = loyaltyPointBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOldID() {
        return oldID;
    }

    public void setOldID(String oldID) {
        this.oldID = oldID;
    }

    @Override
    public String toString() {
        return customerID + " " + firstName + " " + lastName + " " + contactNo + " " + email + " " + address + " " + dateJoined + " " + expiryDate + " " + loyaltyPointBalance + " " + status + " " + oldID;
    }

}
