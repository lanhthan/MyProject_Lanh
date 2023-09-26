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
@WebServlet(name="AddToCartController", urlPatterns={"/addtocart"})
public class AddToCartController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddToCartController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        DAO d = new DAO();
        Cookie[] listCookie = request.getCookies();
        HttpSession session = request.getSession();
        ArrayList<Items> listItem = new ArrayList<>();
        ArrayList<Products> listProduct = d.getListProduct();
        
        String txt = "";
        Users u = (Users)session.getAttribute("account");
        
        System.out.println("dang nhap hay chua: " + u);
        if(u==null){
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        
        //check 
        if(listCookie != null){
            for (Cookie c : listCookie) {
                if(c.getName().equals("cart" + u.getAccount())){
                    txt+=c.getValue();
                    System.out.println("txt: " + txt);
                    //cho nay can xu ly
                    c.setMaxAge(0);
                    //response.addCookie(c);
                }
            }
        }
        
        //String quantity = request.getParameter("quantity");
        String pid = request.getParameter("pid");
        //System.out.println("Pid ne: " + pid);
        
        if(txt.isEmpty()){
            txt = pid + ":" + 1;
        } else {
            txt+= "/" + pid + ":" + 1;
        }
        
        Cookie c = new Cookie("cart" + u.getAccount(), txt);
        c.setMaxAge(60*60*24*30);
        response.addCookie(c);
        //doGet(request, response);
//        response.sendRedirect("shopcart");
        response.sendRedirect("product?pid=" + pid);
        //request.getRequestDispatcher("shopcart").forward(request, response);
//        listItem = d.getListItem(txt, listProduct);
//        int sizeCart = listItem.size();
//        request.setAttribute("", c);
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
