//Author : Chow Hui Pin

package domain;

public class Staff {

    private String staffID;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String email;
    private String address;
    private String status;
    private String password;

    public Staff(String staffID, String firstName, String lastName, String contactNo, String email, String address, String status, String password) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
        this.status = status;
        this.password = password;
    }

    public Staff(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }

    public Staff(String staffID) {
        this.staffID = staffID;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return staffID + " " + firstName + " " + lastName + " " + contactNo + " " + email + " " + address + " " + status + " " + password;
    }

}
