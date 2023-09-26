/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAO;
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
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {

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
            out.println("<title>Servlet RegisterController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterController at " + request.getContextPath() + "</h1>");
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
        //get data
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        DAO d = new DAO();
        String messError = "";

        //check null
        if (request.getParameter("account") == null || request.getParameter("account").isEmpty()
                || request.getParameter("password") == null || request.getParameter("password").isEmpty()
                || request.getParameter("repassword") == null || request.getParameter("repassword").isEmpty()) {
            messError = "Bạn chưa nhập đủ thông tin!";
            request.setAttribute("error", messError);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            //check trung account
            ArrayList<Users> listUser = new ArrayList<>();
            listUser = d.getListUser();
            for (Users u : listUser) {
                if (account.equals(u.getAccount())) {
                    messError = "Tên đăng nhập đã có người sử dụng! Chọn cái khác đi!";
                    request.setAttribute("error", messError);
                    request.setAttribute("account", account);
                    request.setAttribute("password", password);
                    request.setAttribute("repassword", repassword);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } 
            }

            //check password and repassword
            if (!repassword.equals(password)) {
                messError = "Nhập lại mật khẩu không đúng!";
                request.setAttribute("error", messError);
                request.setAttribute("account", account);
                request.setAttribute("password", password);
                request.setAttribute("repassword", repassword);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else if(messError.equals("")){
                boolean beRegistered = d.addUser(account, password);
                if (beRegistered) {
                    response.sendRedirect("login.jsp");
                }

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
