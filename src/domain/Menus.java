//Author : Choo Yee Ling

package domain;

public class Menus {

    private String foodID;
    private String foodName;
    private String category;
    private String description;
    private double pricePerUnit;
    private String status;

    public Menus() {
    }

    public Menus(String foodID, String foodName, String category, String description, double pricePerUnit, String status) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.category = category;
        this.description = description;
        this.pricePerUnit = pricePerUnit;
        this.status = status;
    }

    public Menus(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return foodID + " " + foodName + " " + category + " " + description + " " + pricePerUnit
                + " " + status;
    }

}
