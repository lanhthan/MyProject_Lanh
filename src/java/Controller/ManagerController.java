/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller;

import DAO.DAO;
import Model.Category;
import Model.Customers;
import Model.Products;
import Model.Users;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author windy
 */
@WebServlet(name="ManagerController", urlPatterns={"/manager"})
public class ManagerController extends HttpServlet {
   
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
            out.println("<title>Servlet ManagerController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerController at " + request.getContextPath () + "</h1>");
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
        ArrayList<Products> listProduct =  d.getListProduct();
        ArrayList<Category> listCategory = d.getListCategory();
        ArrayList<Users> listUser = d.getListUser();
        ArrayList<Customers> listCustomer = d.getListCustomer();
        
        
        String type = request.getParameter("type");
        System.out.println("type ne: " + type);
        
        if(type.equals("product")){
            System.out.println("no la product");
            request.setAttribute("listProduct", listProduct);
            request.setAttribute("listCategory", listCategory);
            request.getRequestDispatcher("managerProduct.jsp").forward(request, response);
        } else if(type.equals("customer")){
            request.setAttribute("listUser", listUser);
            request.setAttribute("listCustomer", listCustomer);
            request.getRequestDispatcher("managerCustomer.jsp").forward(request, response);
            System.out.println("no da vao day");
        }
        
//        if(type.equals("order")){
//            
//        }
                     
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
