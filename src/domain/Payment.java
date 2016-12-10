//Author : Adelina Tang Chooi Li

package domain;

public class Payment {

    private String transactionID;
    private Customer customer;
    private Staff staff;
    private Orders orders;
    private String paymentMethod;
    private double discount;
    private double totalPriceBD;
    private double tax;
    private double totalPriceAD;
    private double grandTotal;
    private int loyaltyPointUsed;
    private double loyaltyPointAmount;
    private int loyaltyPointEarned;

    public Payment(String transactionID, Customer customer, Staff staff, Orders orders, String paymentMethod, double discount, double totalPriceBD, double tax, double totalPriceAD, double grandTotal, int loyaltyPointUsed, double loyaltyPointAmount, int loyaltyPointEarned) {
        this.transactionID = transactionID;
        this.customer = customer;
        this.staff = staff;
        this.orders = orders;
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.totalPriceBD = totalPriceBD;
        this.tax = tax;
        this.totalPriceAD = totalPriceAD;
        this.grandTotal = grandTotal;
        this.loyaltyPointUsed = loyaltyPointUsed;
        this.loyaltyPointAmount = loyaltyPointAmount;
        this.loyaltyPointEarned = loyaltyPointEarned;
    }

    public Payment(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPriceBD() {
        return totalPriceBD;
    }

    public void setTotalPriceBD(double totalPriceBD) {
        this.totalPriceBD = totalPriceBD;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalPriceAD() {
        return totalPriceAD;
    }

    public void setTotalPriceAD(double totalPriceAD) {
        this.totalPriceAD = totalPriceAD;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public int getLoyaltyPointUsed() {
        return loyaltyPointUsed;
    }

    public void setLoyaltyPointUsed(int loyaltyPointUsed) {
        this.loyaltyPointUsed = loyaltyPointUsed;
    }

    public double getLoyaltyPointAmount() {
        return loyaltyPointAmount;
    }

    public void setLoyaltyPointAmount(int loyaltyPointAmount) {
        this.loyaltyPointAmount = loyaltyPointAmount;
    }

    public int getLoyaltyPointEarned() {
        return loyaltyPointEarned;
    }

    public void setLoyaltyPointEarned(int loyaltyPointEarned) {
        this.loyaltyPointEarned = loyaltyPointEarned;
    }

    @Override
    public String toString() {
        return transactionID + " " + customer + " " + staff + " " + orders + " " + paymentMethod + " " + discount + " " + totalPriceBD + " " + tax + " " + totalPriceAD + " " + grandTotal + " " + loyaltyPointUsed + " " + loyaltyPointAmount + " " + loyaltyPointEarned;
    }

}
