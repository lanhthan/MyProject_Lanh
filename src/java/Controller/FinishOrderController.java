/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Customers;
import Model.Items;
import Model.Products;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author windy
 */
@WebServlet(name = "FinishOrderController", urlPatterns = {"/finish"})
public class FinishOrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FinishOrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FinishOrderController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String cid = request.getParameter("cid");
//        System.out.println("da den day nhe");
//        System.out.println("CustyomerID ne: " + cid);
//        System.out.println("den day khong");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO d = new DAO();
        Cookie[] listCookie = request.getCookies();
        ArrayList<Products> listProduct = d.getListProduct();
        String txt = "";
        HttpSession session = request.getSession();
        Users u = (Users) session.getAttribute("account");
        String cid = request.getParameter("cid");

        String customer = request.getParameter("customer");
        System.out.println("customer cua Lanh ne: " + customer);

        //Khach hang moi
        if (cid == null || cid.isEmpty()) {
            System.out.println("vao duoc thanh dia danh cho khach hang moi");
            String name = request.getParameter("name");
            System.out.println("name: " + name);
            String address = request.getParameter("address");
            System.out.println("address: " + address);
            String phone = request.getParameter("phone");
            System.out.println("phone: " + phone);
            String totalPrice = request.getParameter("totalPrice");
            System.out.println("totalPrice: " + totalPrice);
            String userId = request.getParameter("uid");

            request.setAttribute("name", name);
            request.setAttribute("address", address);
            request.setAttribute("phone", phone);
            request.setAttribute("totalPrice", totalPrice);
            request.setAttribute("userId", userId);

            d.createCustomer(userId, name, address, phone);
            System.out.println("userID uy tin: " + userId);
            Customers cus = d.getCustomerByUId(userId);
            cid = cus.getCid();
            System.out.println("cid cook: " + cid);

            //request.getRequestDispatcher("customer").forward(request, response);
//            request.getRequestDispatcher("index.html").forward(request, response);

        }

        //check list cookie null or not
        if (listCookie != null) {
            System.out.println("shopcart: listCookie !=null");
            for (Cookie c : listCookie) {
                if (c.getName().equals("cart" + u.getAccount())) {
                    //System.out.println("shopcart: kiem duoc cookie cart");
                    txt += c.getValue();
                }
            }
        }
        ArrayList<Items> listItem = new ArrayList<>();
        listItem = d.getListItem(txt, listProduct, listItem);
        int size = listItem.size();

        //Order
        //String cid = request.getParameter("cid");
        //System.out.println("CustyomerID ne: " + cid);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateOrder = format.format(date);
        System.out.println("Current date: " + format.format(date));
        String totalPrice = request.getParameter("totalPrice");
        System.out.println("totalPrice ne " + totalPrice);
        String priceMoi = totalPrice.substring(0, totalPrice.length() - 2);
        System.out.println("priceMoi " + priceMoi);
        try {
            int realTotalPrice = Integer.parseInt(priceMoi);
            boolean check = d.createOrder(cid, dateOrder, realTotalPrice);
            if (check) {
                String oid = d.getOrderId(cid, dateOrder);
                System.out.println("oid ne cau oi: " + oid);

                for (Items items : listItem) {
                    String pid = items.getProduct().getId();
                    String price = items.getProduct().getPrice();
                    String quantity = items.getQuantity();
                    d.createOrderDetail(oid, pid, price, quantity);

                }
                request.setAttribute("oid", oid);
                for (Cookie c : listCookie) {
                    if (c.getName().equals("cart" + u.getAccount())) {
                        System.out.println("finishorder: kiem duoc cookie cart de xoa");
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
                request.getRequestDispatcher("finish.jsp").forward(request, response);

            }
        } catch (Exception e) {
            System.out.println("parse: " + e.getMessage());
        }

        //OrderDetail
//        if (listCookie != null) {
//            System.out.println("shopcart: listCookie !=null");
//            for (Cookie c : listCookie) {
//                if (c.getName().equals("cart" + u.getAccount())) {
//                    System.out.println("shopcart: kiem duoc cookie cart");
//                    txt += c.getValue();
//                }
//            }
//        }
//
//        listItem = d.getListItem(txt, listProduct, listItem);
//        for (Items items : listItem) {
//            String pid = items.getProduct().getId();
//            String price = items.getProduct().getPrice();
//            String quantity = items.getQuantity();
//            System.out.println("pid " + pid);
//            System.out.println("price " + price);
//            System.out.println("quantity " + quantity);
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
