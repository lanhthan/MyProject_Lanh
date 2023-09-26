/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Category;
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
@WebServlet(name = "AddProductController", urlPatterns = {"/addProduct"})
public class AddProductController extends HttpServlet {

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
            out.println("<title>Servlet AddProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductController at " + request.getContextPath() + "</h1>");
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
        ArrayList<Category> listCategory = d.getListCategory();

        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String gender = request.getParameter("gender");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        String discount = request.getParameter("discount");
        System.out.println(name);
        System.out.println(category);
        System.out.println(price);
        System.out.println(stock);
        System.out.println(gender);
        System.out.println(description);
        System.out.println(image);
        System.out.println(discount);

        if (name == null || category == null || price == null
                || stock == null || gender == null || description == null
                || image == null || discount == null || name.isEmpty()
                || category.isEmpty() || price.isEmpty()
                || stock.isEmpty() || gender.isEmpty() || description.isEmpty()
                || image.isEmpty() || discount.isEmpty()) {
            String messError = "Bạn chưa nhập đủ thông tin!";
            request.setAttribute("error", messError);
            request.setAttribute("listCategory", listCategory);
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
        } else{
            boolean check = d.addProduct(name, category, price, stock, gender, description, image, discount);
            System.out.println("check ne: " + check);
            if(check){
                response.sendRedirect("manager?type=product");
//                request.getRequestDispatcher("manager").forward(request, response);
            }
        }
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
