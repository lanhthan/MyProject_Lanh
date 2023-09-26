/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.DAO;
import java.util.ArrayList;

/**
 *
 * @author windy
 */
public class ShopCart {

    ArrayList<Items> listItem;

    public ShopCart() {
        listItem = new ArrayList<>();
    }

    public ShopCart(ArrayList<Items> listItem) {
        this.listItem = listItem;
    }

    

    public ArrayList<Items> getListItem() {
        return listItem;
    }

    public void setListItem(ArrayList<Items> listItem) {
        this.listItem = listItem;
    }

    @Override
    public String toString() {
        return "ShopCart{" + "listItem=" + listItem + '}';
    }

}
