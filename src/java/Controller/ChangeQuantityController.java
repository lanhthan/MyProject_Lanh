/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
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
import java.util.ArrayList;

/**
 *
 * @author windy
 */
@WebServlet(name = "ChangeQuantityController", urlPatterns = {"/changeQuantity"})
public class ChangeQuantityController extends HttpServlet {

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
            out.println("<title>Servlet ChangeQuantityController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChangeQuantityController at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        ArrayList<Items> listItem = new ArrayList<>();
        ArrayList<Products> listProduct = d.getListProduct();

        String txt = "";

        Users u = (Users)session.getAttribute("account");
        System.out.println("lanh ngooo" + u.toString());
        
        if (listCookie != null) {
            for (Cookie c : listCookie) {
                if (c.getName().equals("cart" + u.getAccount())) {
                    txt += c.getValue();
                    System.out.println("txt: " + txt);
                    //cho nay can xu ly
                    c.setMaxAge(0);
                    //response.addCookie(c);
                }
            }
        }

        String iid = request.getParameter("iid");
        String quantity_raw = request.getParameter("quantity");
        String action = request.getParameter("action");

        Products p = d.getProductByID(iid);
        String stock_raw = p.getStock();
        String newTxt = "";

        try {
            int quantity = Integer.parseInt(quantity_raw);
            int stock = Integer.parseInt(stock_raw);

            if (action.equals("-")) {
                if (quantity > 1) {
                    newTxt = d.changeQuantity(txt, iid, -1);
                } else {
                    newTxt = txt;
                }
            }
            if (action.equals("+")) {
                if (quantity < stock) {
                    newTxt = d.changeQuantity(txt, iid, 1);
                } else {
                    newTxt = txt;
                }
            }
            Cookie c = new Cookie("cart" + u.getAccount(), newTxt);
            c.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(c);
            response.sendRedirect("shopcart");
        } catch (Exception e) {
        }

//        System.out.println("iid: " + iid);
//        listItem = d.getListItem(txt, listProduct, listItem);
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
