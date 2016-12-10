//Author : Chin Wei Song

package control;

import da.*;
import domain.*;
import java.util.ArrayList;

public class MaintainFoodControl {

    private FoodDA foodDA;

    public MaintainFoodControl() {
        foodDA = new FoodDA();
    }

    public int getLatestIDControl() {
        return foodDA.getLatestIDDA();
    }

    public void createFoodRecordControl(Food food) {
        foodDA.createFoodRecordDA(food);
    }

    public ArrayList<Food> retrieveFoodRecordControl(String orderID) {
        return foodDA.retrieveFoodRecordDA(orderID);
    }

    public ArrayList<Food> retrieveFoodRecordControl() {
        return foodDA.retrieveFoodRecordDA();
    }

    public void updateFoodRecordControl(Food foodupdate) {
        foodDA.updateFoodRecordDA(foodupdate);
    }

    public Food retrieveFoodRecordControl(int foodorderid) {
        return foodDA.retrieveFoodRecordDA(foodorderid);
    }

    public void deleteFoodRecordControl(int foodorderid) {
        foodDA.deleteFoodRecordDA(foodorderid);
    }

    public void checkFoodRecordControl(int foodorderid) {
        foodDA.checkFoodRecordDA(foodorderid);
    }
    
    public Food retrieveFoodRecordControl2(String foodid,String orderID){
        return foodDA.retrieveFoodRecordDA2(foodid,orderID);
    }

}
