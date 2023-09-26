/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Items;
import Model.Products;
import Model.ShopCart;
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
@WebServlet(name = "DeleteProductController", urlPatterns = {"/delete"})
public class DeleteProductController extends HttpServlet {

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
            out.println("<title>Servlet DeleteProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteProductController at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        System.out.println("id can xoa: " + id);

        //get list cookie
        Cookie[] listCookie = request.getCookies();
        ArrayList<Items> listItem = new ArrayList<>();
        DAO d = new DAO();
        ArrayList<Products> listProduct = d.getListProduct();
        HttpSession session = request.getSession();
        Users u = (Users)session.getAttribute("account");
        ShopCart shopcart;
        String txt = "";
        String str = "";
        String quantity = "";

        //check list cookie null or not
        if (listCookie != null) {
            System.out.println("shopcart: listCookie !=null");
            for (Cookie c : listCookie) {
                if (c.getName().equals("cart" + u.getAccount())) {
                    System.out.println("shopcart: kiem duoc cookie cart");
                    txt += c.getValue();
                }
            }
        }
        listItem = d.getListItem(txt, listProduct, listItem);
        int numProduct = listItem.size();
//        for (Items items : listItem) {
//            if (items.getProduct().getId().equals(id)) {
//                quantity = items.getQuantity();
//            }
//        }
        String idFirst = listItem.get(0).getProduct().getId();
        
        if (numProduct == 1) {
            str = id + ":1";
        } else if(idFirst.equals(id)){
            str = id + ":1/";
        }
        else {
            str = "/" + id + ":1";
        }
        String newTxt = txt.replace(str, "");
        Cookie c = new Cookie("cart" + u.getAccount(), newTxt);
        c.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(c);
        response.sendRedirect("shopcart");
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
        processRequest(request, response);
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
