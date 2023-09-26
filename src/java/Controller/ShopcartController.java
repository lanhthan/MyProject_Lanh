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
@WebServlet(name = "ShopcartController", urlPatterns = {"/shopcart"})
public class ShopcartController extends HttpServlet {

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
            out.println("<title>Servlet ShopcartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ShopcartController at " + request.getContextPath() + "</h1>");
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

        //get list cookie
        Cookie[] listCookie = request.getCookies();
        ArrayList<Items> listItem = new ArrayList<>();
        HttpSession session = request.getSession();
        Users u = (Users)session.getAttribute("account");
        DAO d = new DAO();
        ArrayList<Products> listProduct = d.getListProduct();
        ShopCart shopcart;
        String txt = "";
        
        if(u==null){
            response.sendRedirect("login.jsp");
        }

        //check list cookie null or not
        if (listCookie != null) {
            //System.out.println("shopcart: listCookie !=null");
            for (Cookie c : listCookie) {
                
                if (c.getName().equals("cart" + u.getAccount())) {
                    //System.out.println("shopcart: kiem duoc cookie cart");
                    txt += c.getValue();
                }
            }
        }

        if (txt.equals("")) {
            listItem = null;
            response.sendRedirect("shopcart.jsp");
        } else {
            //System.out.println("shopcart txt: " + txt);
            listItem = d.getListItem(txt, listProduct, listItem);
            for (Items items : listItem) {
                System.out.println(items.toString());
            }
            request.setAttribute("listItem", listItem);
            request.getRequestDispatcher("shopcart.jsp").forward(request, response);
        }

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
