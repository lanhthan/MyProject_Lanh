/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author windy
 */
public class Products {
    String id, name, cateid, price, stock, gender, description, image, discount;

    public Products() {
    }

    public Products(String id, String name, String cateid, String price, String stock, String gender, String description, String image, String discount) {
        this.id = id;
        this.name = name;
        this.cateid = cateid;
        this.price = price;
        this.stock = stock;
        this.gender = gender;
        this.description = description;
        this.image = image;
        this.discount = discount;
    }
    public Products(String id, String name, String cateid, int price, String stock, String gender, String description, String image, String discount) {
        this.id = id;
        this.name = name;
        this.cateid = cateid;
        this.price = String.valueOf(price);
        this.stock = stock;
        this.gender = gender;
        this.description = description;
        this.image = image;
        this.discount = discount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    public String getPrice() {
        return price;
    }
    public int getPriceInt() {
        return Integer.parseInt(price);
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", name=" + name + ", cateid=" + cateid + ", price=" + price + ", stock=" + stock + ",   discount=" + discount + '}';
    }

    
    
}
