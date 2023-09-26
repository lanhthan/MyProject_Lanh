/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
import Model.Category;
import Model.Products;
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
@WebServlet(name = "ManagerProductController", urlPatterns = {"/managerProduct"})
public class ManagerProductController extends HttpServlet {

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
            out.println("<title>Servlet ManagerProductController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerProductController at " + request.getContextPath() + "</h1>");
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
        DAO d = new DAO();
        ArrayList<Category> listCategory = d.getListCategory();

        String action = request.getParameter("action");

        if (action.equals("add")) {
//            String name = request.getParameter("name");
//            System.out.println("name name name: " + name);
//            String category = request.getParameter("category");
//            String price = request.getParameter("price");
//            String stock = request.getParameter("stock");
//            String gender = request.getParameter("gender");
//            String description = request.getParameter("description");
//            String image = request.getParameter("image");
//            String discount = request.getParameter("discount");
//
//            if (name == null || category == null || price == null
//                    || stock == null || gender == null || description == null
//                    || image == null || discount == null || name.isEmpty()
//                    || category.isEmpty() || price.isEmpty()
//                    || stock.isEmpty() || gender.isEmpty() || description.isEmpty()
//                    || image.isEmpty() || discount.isEmpty()) {
//                String messError = "Bạn chưa nhập đủ thông tin!";
//                request.setAttribute("error", messError);
            request.setAttribute("listCategory", listCategory);
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
//            } else {
//                boolean check = d.addProduct(name, category, price, stock, gender, description, image, discount);
//                if (check) {
//                    response.sendRedirect("manager?type=product");
//                }
//            }

        } else if (action.equals("update")) {
            String pid = request.getParameter("pid");
            Products p = d.getProductByID(pid);
            request.setAttribute("product", p);
            request.setAttribute("listCategory", listCategory);
            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
        } else  if(action.equals("delete")){
            String pid = request.getParameter("pid");
            request.setAttribute("pid", pid);
            boolean check = d.deleteProduct(pid);
            if(check){
                request.getRequestDispatcher("manager?type=product").forward(request, response);
            }
            
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
