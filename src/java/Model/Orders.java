/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author windy
 */
public class Orders {
    String oid, cid, orderDate, totalPrice;

    public Orders() {
    }

    public Orders(String oid, String cid, String orderDate, String totalPrice) {
        this.oid = oid;
        this.cid = cid;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Orders{" + "oid=" + oid + ", cid=" + cid + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + '}';
    }
    
    
}
