/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author windy
 */
public class OrderDetails {
    String oid, pid, price, quantity;

    public OrderDetails() {
    }

    public OrderDetails(String oid, String pid, String price, String quantity) {
        this.oid = oid;
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" + "oid=" + oid + ", pid=" + pid + ", price=" + price + ", quantity=" + quantity + '}';
    }
    
    
}
