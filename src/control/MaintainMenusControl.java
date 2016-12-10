//Author : Choo Yee Ling

package control;

import da.*;
import domain.*;
import java.util.ArrayList;

public class MaintainMenusControl {
    
    private MenusDA menusDA;
    
    public MaintainMenusControl(){
         menusDA = new MenusDA();
    }
    
    public void createMenusRecordControl(Menus menus){
         menusDA.createMenusRecordDA(menus);
    }
    
    public String getLatestIDControl(){
        return menusDA.getLatestIDDA();
    }
    
    public ArrayList<Menus> retrieveMenusRecordControl(){
        return menusDA.retrieveMenusRecordDA();
    }
    
    public ArrayList<Menus> retrieveMenusRecordControl2(String foodID){
        return menusDA.retrieveMenusRecordDA2(foodID);
    }
    
    public void updateMenusRecordControl(Menus menus){
        menusDA.updateMenusRecordDA(menus);
    }
    
    public Menus retrieveMenusRecordControl(String menuID){
        return menusDA.retrieveMenusRecordDA(menuID);
    }
    
    public void deleteMenusRecordControl(String menuID){
        menusDA.deleteMenusRecordDA(menuID);
    }
    
    
    
}
