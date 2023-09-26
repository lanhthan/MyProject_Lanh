/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Dal.DBContext;
import Model.Category;
import Model.Customers;
import Model.Items;
import Model.Products;
import Model.Users;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Comparator.comparing;
import java.util.Locale;

/**
 *
 * @author windy
 */
public class DAO extends DBContext {

    //Khai bao cac thanh phan xu li database
    Connection cnn; //Ket noi DB
    Statement stm; // Thuc hien cac cau lenh SQL
    ResultSet rs; // Luu tru va xu ly du lieu
    PreparedStatement pstm;//Thuc hien cac cau leng SQL

    private void connect() {
        //connect vs database dau
//        try {
//            cnn = (new DBContext1()).getConnection();
//            System.out.println("Connect successfully!");
//        } catch (Exception e) {
//            System.out.println("Connect fail: " + e.getMessage());
//        }

        //connect vs database hai (sau)
        cnn = super.connection;
        if (cnn != null) {
            System.out.println("Connect successfully");
        } else {
            System.out.println("Connect fail");
        }
    }

    public DAO() {
        connect();
    }

    public ArrayList<Category> getListCategory() {
        ArrayList<Category> listC = new ArrayList<>();
        try {
            String strSQL = "select * from Categories";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                Category c = new Category(id, name, image);
                listC.add(c);
            }
        } catch (Exception e) {
            System.out.println("ListCategory: " + e.getMessage());
        }
        return listC;
    }

    public static void main(String[] args) {
        ArrayList<Category> listC = new ArrayList<>();
        ArrayList<Products> listP = new ArrayList<>();
        ArrayList<Products> listPro = new ArrayList<>();
        DAO d = new DAO();
        listP = d.getListProduct();
        listP = d.getListProductHigh(listP);
        for (Products products : listP) {
            System.out.println(products.toString());
        }
//        listC = d.getListCategory();
//        for (Category c : listC) {
//            System.out.println(c.getName());
//            
//        }

//        System.out.println(d.formatCurrency("1234000")); 
//        System.out.println(d.formatCurrency("234000")); 
//        System.out.println(d.formatCurrency("34000")); 
//        
//        System.out.println(d.calDiscount("35000", "10"));
//        System.out.println(d.calDiscount("120000", "70"));
//        ArrayList<Products> listProduct = d.getListProduct();
//        String txt = "2:1/4:1/4:1/3:1";
//        //ArrayList<Items> listI = d.getListItem(txt, listProduct);
//        ArrayList<Items> listIT = new ArrayList<>();
//        System.out.println("length: " + listIT.size());
//        listIT = d.getListItem(txt, listProduct, listIT);
//
////        Products p = d.getProductByID("4");
////        Items i = new Items(p, "2", "11");
////        d.addItem(i, listIT);
////        System.out.println("before");
//        for (Items items : listIT) {
//            System.out.println("product");
//            System.out.println(items.toString());
//        }
////        d.addItem(i, listIT);
////        for (Items items : listIT) {
////            System.out.println("product");
////            System.out.println(items.toString());
////        }
//        String  result = d.calPrice("30000", "3");
//        System.out.println(d.formatCurrency(result));
//        String txt = "2:1/3:1";
//        String hehe = d.changeQuantity(txt, "3", -1);
//        String haha = d.changeQuantity(txt, "23", 1);
//        System.out.println("Txt new: " + hehe);
//        System.out.println("Txt new: " + haha);
    }

    public Users checkLogin(String account, String password) {
        try {
            String strSQL = "select * from Users where account=? and password=?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
//                System.out.println("rs.getString(4):"  + rs.getString(4));
                Users u = new Users(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return u;
            }
        } catch (Exception e) {
            System.out.println("checkLogin: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Users> getListUser() {
        ArrayList<Users> listUser = new ArrayList<>();
        try {
            String strSQL = "select * from Users";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String role = rs.getString(4);
                Users c = new Users(id, account, password, role);
                listUser.add(c);
            }

        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return listUser;
    }

    public boolean addUser(String account, String password) {
        try {
            String strSQL = "insert into Users(account, password, role) values (?,?,0)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, account);
            pstm.setString(2, password);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addUser: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Products> getListProduct() {
        ArrayList<Products> listP = new ArrayList<>();
        DAO d = new DAO();
        try {
            String strSQL = "select * from Products";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cateid = rs.getString(3);
//                int price_raw = rs.getInt(4);
//                Locale locale = new Locale("vi", "VN");
//                NumberFormat format = NumberFormat.getCurrencyInstance(locale);
//                String price = format.format(price_raw);

//                String price_raw = rs.getString(4);
//                String price = d.formatCurrency(price_raw);
                String price = rs.getString(4);

                String stock = rs.getString(5);
                String gender = rs.getString(6);
                String description = rs.getString(7);
                String image = rs.getString(8);

//                String discount_raw = rs.getString(9);
//                String discount = d.formatCurrency(d.calDiscount(price_raw, discount_raw));
                String discount = rs.getString(9);

                Products p = new Products(id, name, cateid, price, stock, gender, description, image, discount);

                listP.add(p);
            }
        } catch (Exception e) {
            System.out.println("ListProduct: " + e.getMessage());
        }
        return listP;
    }

    public ArrayList<Products> getListProductByGender(String genderParameter) {
        ArrayList<Products> listP = new ArrayList<>();
        DAO d = new DAO();
        try {
            String strSQL = "select * from Products where gender=? or gender=?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, genderParameter);
            pstm.setString(2, "Other");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cateid = rs.getString(3);
//                String price_raw = rs.getString(4);
//                String price = d.formatCurrency(price_raw);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String gender = rs.getString(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
//                String discount_raw = rs.getString(9);
//                String discount = d.formatCurrency(d.calDiscount(price_raw, discount_raw));
                String discount = rs.getString(9);
                Products p = new Products(id, name, cateid, price, stock, gender, description, image, discount);

                listP.add(p);
            }
        } catch (Exception e) {
            System.out.println("ListProductByGender: " + e.getMessage());
        }
        return listP;
    }

    public ArrayList<Products> getListProductById(String idParameter) {
        ArrayList<Products> listP = new ArrayList<>();
        DAO d = new DAO();
        try {
            String strSQL = "select * from Products p, Categories c where c.CategoryID=? and c.CategoryID= p.CategoryID";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, idParameter);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cateid = rs.getString(3);
//                String price_raw = rs.getString(4);
//                String price = d.formatCurrency(price_raw);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String gender = rs.getString(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
//                String discount_raw = rs.getString(9);
//                String discount = d.formatCurrency(d.calDiscount(price_raw, discount_raw));
                String discount = rs.getString(9);
                Products p = new Products(id, name, cateid, price, stock, gender, description, image, discount);

                listP.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListProductById: " + e.getMessage());
        }
        return listP;
    }

    public ArrayList<Products> getListProductSale() {
        ArrayList<Products> listP = new ArrayList<>();
        DAO d = new DAO();
        try {
            String strSQL = "select * from Products where  Discount>0";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cateid = rs.getString(3);
//                String price_raw = rs.getString(4);
//                String price = d.formatCurrency(price_raw);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String gender = rs.getString(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
//                String discount_raw = rs.getString(9);
//                String discount = d.formatCurrency(d.calDiscount(price_raw, discount_raw));
                String discount = rs.getString(9);
                Products p = new Products(id, name, cateid, price, stock, gender, description, image, discount);

                listP.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListProductSale: " + e.getMessage());
        }
        return listP;
    }

    public String formatCurrency(String input) {
        String result = "";
        char ch;
        int length = input.length();
        //System.out.println("mode"+length%3);
        for (int i = 0; i < (length % 3); i++) {
            result = result + input.charAt(i);
        }
        for (int i = length % 3; i < length; i++) {
            if (i % 3 == length % 3 && i != length - 1) {

                result = result + "." + input.charAt(i);
            } else {
                result = result + input.charAt(i);

            }
        }
        if (length % 3 == 0) {
            return result.substring(1);
        }
        return result;
    }

    public String calDiscount(String price_raw, String discount_raw) {
        String result = "";
        try {
            int price = Integer.parseInt(price_raw);
            int discount = Integer.parseInt(discount_raw);
            int result_raw = price * (100 - discount) / 100;
            result = String.valueOf(result_raw);
        } catch (Exception e) {
            System.out.println("calDiscount: " + e.getMessage());
        }
        return result;
    }

    public Products getProductByID(String pid) {
        Products p = new Products();
        DAO d = new DAO();
        try {
            String strSQL = "  select * from Products p, Categories c where p.CategoryID = c.CategoryID and p.ProductID = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, pid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cateid = rs.getString(11);
//                String price_raw = rs.getString(4);
//                String price = d.formatCurrency(price_raw);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String gender = rs.getString(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
//                String discount_raw = rs.getString(9);
//                String discount = d.formatCurrency(d.calDiscount(price_raw, discount_raw));
                String discount = rs.getString(9);
                p = new Products(id, name, cateid, price, stock, gender, description, image, discount);

            }
        } catch (Exception e) {
            System.out.println("getProductByID: " + e.getMessage());
        }
        return p;
    }

    public ArrayList<Items> getListItem(String txt, ArrayList<Products> listProduct, ArrayList<Items> listI) {

        //if (txt != null && txt.length() != 0) {
        String[] listP = txt.split("/");

        for (String p : listP) {
            //System.out.println("Quay lai mot vong");
            String[] product = p.split(":");

            String pid = product[0];
            String quantity = product[1];
            Products pro = getProductByID(pid);

            Items i = new Items(pro, quantity, pro.getPrice());
            addItem(i, listI);
        }
        //}
        return listI;
    }

    private void addItem(Items i, ArrayList<Items> listI) {
        boolean isDuplicate = false;
        if (listI.isEmpty()) {
//            String price = calPrice(i.getPrice(), "1");
//            i.setPrice(price);
            listI.add(i);
            //System.out.println("rong va add moi");
        } else {
            //System.out.println("day la else");
            for (int j = 0; j < listI.size(); j++) {
                //System.out.println("listI" + listI.get(j).getProduct().getId());
                //System.out.println("i them vao" + i.getProduct().getId());
                if (listI.get(j).getProduct().getId().equals(i.getProduct().getId())) {
                    //System.out.println("co trung");
                    isDuplicate = true;
                    int quantity = Integer.parseInt(listI.get(j).getQuantity()) + 1;
                    listI.get(j).setQuantity(String.valueOf(quantity));
//                    String unitPrice_raw = i.getProduct().getPrice();
//                    String unitPrice ="";
//                    for (int k=0; k<unitPrice_raw.length(); k++) {
//                        if(unitPrice_raw.charAt(k)!='.'){
//                            unitPrice+=unitPrice_raw.charAt(k);
//                        }
//                    }
//                    System.out.println("unitPrice moi : " + unitPrice);
//                    String price = formatCurrency(calPrice(unitPrice, listI.get(j).getQuantity()));
//                    //String price = calPrice("30000", "3");
//                    System.out.println("price ne: " + price);
//                    //System.out.println("unitprice: "+ Integer.parseInt(i.getProduct().getPrice()));
//                    System.out.println("quantity: " + i.getQuantity());
//                    i.setPrice(formatCurrency(price));

                }
//                else{
//                    System.out.println("ko trung");
//                    listI.add(i);
//                    System.out.println("add: " + i.toString());
//                    return;
//                }

            }
            if (isDuplicate == false) {
//                String price = calPrice(i.getPrice(), "1");
//                i.setPrice(price);
                listI.add(i);
                //System.out.println("add: " + i.toString());
            }
//            for (Items item : listI) {
//                System.out.println("vao duoc khong");
//                if (item.getProduct().getId().equals(i.getProduct().getId())) {
//                    System.out.println("tang 1");
//                    int quantity = Integer.parseInt(item.getQuantity()) + 1;
//                    item.setQuantity(String.valueOf(quantity));
//                } else {
//                    
//                    for (Items items : listI) {
//                        System.out.println(items.toString());
//                    }
//                    System.out.println("add moi");
//                    listI.add(i);
//                    System.out.println("add duoc");
//                    
//                }
//            }
        }

    }

    public String calPrice(String unitPrice, String quantity_raw) {
        String result = "";
        try {
            int price = Integer.parseInt(unitPrice);
            int quantity = Integer.parseInt(quantity_raw);
            int result_raw = price * quantity;
            result = String.valueOf(result_raw);
        } catch (Exception e) {
            System.out.println("calPrice: " + e.getMessage());
        }
        return result;
    }

    public void removeItem(String txt, String iid) {
        String[] listP = txt.split("/");

        for (String p : listP) {
            //System.out.println("Quay lai mot vong");
            String[] product = p.split(":");

            String pid = product[0];

        }
    }

    public String changeQuantity(String txt, String iid, int i) {
        String result = "";
        String str = "/" + iid + ":1";
        String[] listP = txt.split("/");

        if (i == -1) {
            result = txt.replaceFirst(str, "");
        }
        if (i == 1) {
            result = txt + "/" + iid + ":1";
        }
        return result;
    }

    public ArrayList<Products> searchProduct(String search) {
        ArrayList<Products> listP = new ArrayList<>();
        DAO d = new DAO();
        try {
            String strSQL = "select * from Products where ProductName like N'%" + search + "%'";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cateid = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String gender = rs.getString(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
                String discount = rs.getString(9);
                Products p = new Products(id, name, cateid, price, stock, gender, description, image, discount);

                listP.add(p);
            }
        } catch (Exception e) {
            System.out.println("searchProduct: " + e.getMessage());
        }
        return listP;
    }

    public Customers getCustomerByUId(String idParameter) {
        Customers p = new Customers();
        DAO d = new DAO();
        try {
            String strSQL = "select * from Customers c, Users u where c.UserID= u.UserID and u.UserID = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, idParameter);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String cid = rs.getString(1);
                String uid = rs.getString(2);
                String name = rs.getString(3);
                String gender = rs.getString(4);
                String dob = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);

                p = new Customers(cid, uid, name, gender, dob, address, phone);

            }
        } catch (Exception e) {
            System.out.println("getCustomerByUId: " + e.getMessage());
        }
        return p;
    }

    public boolean createOrder(String cid, String dateOrder, int totalPrice) {
        try {
            String strSQL = "insert into Orders(CustomerID, OrderDate, TotalPrice) values(?,?,?)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, cid);
            pstm.setString(2, dateOrder);
            pstm.setInt(3, totalPrice);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("createOrder: " + e.getMessage());
        }
        return false;
    }

    public String getOrderId(String cid, String dateOrder) {
        String result = "";
        try {
            String strSQL = "select OrderID from Orders where CustomerID=? and OrderDate = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, cid);
            pstm.setString(2, dateOrder);
            rs = pstm.executeQuery();
            while (rs.next()) {
                result = rs.getString(1);
            }
            return result;
        } catch (Exception e) {
            System.out.println("getOrderId: " + e.getMessage());
        }
        return null;
    }

    public boolean createOrderDetail(String oid, ArrayList<Items> listItem) {
        boolean check = false;
        for (Items items : listItem) {
            try {
                String strSQL = "insert into OrderDetails(OrderID, ProductID, Price, Quantity) values(?,?,?,?)";
                pstm = cnn.prepareStatement(strSQL);
                pstm.setString(1, oid);
                pstm.setString(2, items.getProduct().getId());
                pstm.setString(3, items.getProduct().getPrice());
                pstm.setString(4, items.getQuantity());

                pstm.execute();

            } catch (Exception e) {
                System.out.println("createOrderDetail: " + e.getMessage());
            }
        }
        check = true;

        return check;
    }

    public void createOrderDetail(String oid, String pid, String price, String quantity) {
        try {
            String strSQL = "insert into OrderDetails(OrderID, ProductID, Price, Quantity) values(?,?,?,?)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, oid);
            pstm.setString(2, pid);
            pstm.setString(3, price);
            pstm.setString(4, quantity);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("createOrderDetail: " + e.getMessage());
        }
    }

    public void createCustomer(String userId, String name, String address, String phone) {
        try {
            String strSQL = "insert into Customers(UserID, FullName, Gender, Birthdate, Address, Phone) values (?, ?, 0, '', ?, ?)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, userId);
            pstm.setString(2, name);
            pstm.setString(3, address);
            pstm.setString(4, phone);

            pstm.execute();

        } catch (Exception e) {
            System.out.println("createCustomer: " + e.getMessage());
        }
    }

    public boolean addProduct(String name, String category, String price, String stock, String gender, String description, String image, String discount) {
        try {
            String strSQL = "insert into Products(ProductName, CategoryID, Price, Stock, Gender, Description, Image, Discount) values (?,?,?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, name);
            pstm.setString(2, category);
            pstm.setString(3, price);
            pstm.setString(4, stock);
            pstm.setString(5, gender);
            pstm.setString(6, description);
            pstm.setString(7, image);
            pstm.setString(8, discount);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addProduct: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteProduct(String pid) {
        try {
            String strSQL = "delete from Products where ProductID=?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, pid);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteProduct: " + e.getMessage());
        }
        return false;
    }

    public boolean updateProduct(String pid, String name, String category, String price, String stock, String gender, String description, String image, String discount) {
        try {
            String strSQL = "update Products set ProductName=?, CategoryID=?, Price=?, Stock=?, Gender=?, Description=?, Image=?, Discount=? where ProductID=?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, name);
            pstm.setString(2, category);
            pstm.setString(3, price);
            pstm.setString(4, stock);
            pstm.setString(5, gender);
            pstm.setString(6, description);
            pstm.setString(7, image);
            pstm.setString(8, discount);
            pstm.setString(9, pid);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateProduct: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Customers> getListCustomer() {
        ArrayList<Customers> listCustomer = new ArrayList<>();
        try {
            String strSQL = "select * from Customers";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String cid = rs.getString(1);
                String uid = rs.getString(2);
                String fname = rs.getString(3);
                String gender = rs.getString(4);
                String dob = rs.getString(5);
                String address = rs.getString(6);
                String phone = rs.getString(7);
                Customers c = new Customers(cid, uid, fname, gender, dob, address, phone);
                listCustomer.add(c);
            }

        } catch (Exception e) {
            System.out.println("getListCustomer: " + e.getMessage());
        }
        return listCustomer;
    }

    public ArrayList<Items> getListItemByOID(String oid) {
        ArrayList<Items> listI = new ArrayList<>();
        DAO d = new DAO();
        try {
            String strSQL = " select ProductName, o.Price, o.Quantity, p.Discount from OrderDetails o, Products p where OrderID=? and p.ProductID=o.ProductID";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, oid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String pname = rs.getString(1);
                String price = rs.getString(2);
                String quantity = rs.getString(3);
                String discount = rs.getString(4);
                Products p = new Products("", pname, "", price, "", "", "", "", discount);
                Items i = new Items(p, quantity, price);

                listI.add(i);
            }
        } catch (Exception e) {
            System.out.println("getListItemByOID: " + e.getMessage());
        }
        return listI;
    }

    public Users getUserById(String uid) {
        Users u = new Users();
        try {
            String strSQL = " select * from Users where UserID = ?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, uid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String account = rs.getString(2);
                String password = rs.getString(3);
                String role = rs.getString(4);
                u = new Users(id, account, password, role);
                return u;
            }
        } catch (Exception e) {
            System.out.println("getUserById: " + e.getMessage());
        }
        return null;
    }

    public boolean updatePassword(String uid, String newPass) {
        try {
            String strSQL = "update Users set Password=? where UserID=?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, newPass);
            pstm.setString(2, uid);

            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updatePassword: " + e.getMessage());
        }
        return false;
    }

    public boolean updateCustomer(String cid, String name, String gender, String dob, String address, String phone) {
        try {
            String strSQL = "update Customers set FullName=?, Gender=?, Address=?, Phone=? where CustomerID=?";
            pstm = cnn.prepareStatement(strSQL);
            pstm.setString(1, name);
            pstm.setString(2, gender);
            pstm.setString(3, address);
            pstm.setString(4, phone);
            pstm.setString(5, cid);

            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateCustomer: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<Products> getListProductHigh() {
        ArrayList<Products> listP = new ArrayList<>();
        DAO d = new DAO();
        try {
            String strSQL = "  select *,\n"
                    + "   case\n"
                    + "    when Discount !=0 then (Price*100 - Price*Discount)/100 \n"
                    + "	when Discount =0 then Price\n"
                    + "  end as Discounted from Products\n"
                    + "  order by Discounted desc";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cateid = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String gender = rs.getString(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
                String discount = rs.getString(9);
                Products p = new Products(id, name, cateid, price, stock, gender, description, image, discount);

                listP.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListProductHigh: " + e.getMessage());
        }
        return listP;
    }

    public ArrayList<Products> getListProductLow() {
        ArrayList<Products> listP = new ArrayList<>();
        DAO d = new DAO();
        try {
            String strSQL = "  select *,\n"
                    + "   case\n"
                    + "    when Discount !=0 then (Price*100 - Price*Discount)/100 \n"
                    + "	when Discount =0 then Price\n"
                    + "  end as Discounted from Products\n"
                    + "  order by Discounted";
            pstm = cnn.prepareStatement(strSQL);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String cateid = rs.getString(3);
                String price = rs.getString(4);
                String stock = rs.getString(5);
                String gender = rs.getString(6);
                String description = rs.getString(7);
                String image = rs.getString(8);
                String discount = rs.getString(9);
                Products p = new Products(id, name, cateid, price, stock, gender, description, image, discount);

                listP.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListProductHigh: " + e.getMessage());
        }
        return listP;
    }

    public ArrayList<Products> getListProductHigh(ArrayList<Products> listProduct) {
        ArrayList<Products> listP = new ArrayList<>();
        ArrayList<Products> listPro = new ArrayList<>();
        Products temp = new Products();

        for (Products p : listProduct) {
            int price = Integer.parseInt(p.getPrice());
            int discount = Integer.parseInt(p.getDiscount());
            int newPrice = price * (100 - discount) / 100;
            temp = new Products(p.getId(), p.getName(), p.getCateid(), newPrice, p.getStock(), p.getGender(), p.getDescription(), p.getImage(), p.getDiscount());
//            p.setPrice(String.valueOf(newPrice));
            listP.add(temp);
        }
        for (Products products : listP) {
            System.out.println("listP " + products.toString());
        }
        listP.sort(comparing(Products::getPriceInt).reversed());
        
        for (Products products : listP) {
            temp = getProductByID(products.getId());
            listPro.add(temp);
        }
        return listPro;
    }

    public ArrayList<Products> getListProductLow(ArrayList<Products> listProduct) {
         ArrayList<Products> listP = new ArrayList<>();
        ArrayList<Products> listPro = new ArrayList<>();
        Products temp = new Products();

        for (Products p : listProduct) {
            int price = Integer.parseInt(p.getPrice());
            int discount = Integer.parseInt(p.getDiscount());
            int newPrice = price * (100 - discount) / 100;
            temp = new Products(p.getId(), p.getName(), p.getCateid(), newPrice, p.getStock(), p.getGender(), p.getDescription(), p.getImage(), p.getDiscount());
//            p.setPrice(String.valueOf(newPrice));
            listP.add(temp);
        }
        for (Products products : listP) {
            System.out.println("listP " + products.toString());
        }
        listP.sort(comparing(Products::getPriceInt));
        
        for (Products products : listP) {
            temp = getProductByID(products.getId());
            listPro.add(temp);
        }
        return listPro;
    }

}
