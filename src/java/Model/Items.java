/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author windy
 */
public class Items {
    Products product;
    String quantity, price;

    public Items() {
    }

    public Items(Products product, String quantity, String price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Items{" + "product=" + product + ", quantity=" + quantity + ", price=" + price + '}';
    }
    
    
}
