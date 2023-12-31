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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author windy
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");

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
         //Lay du lieu
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Users u = new Users(account, password);
        HttpSession session = request.getSession();
        DAO d = new DAO();

        //Xu li du lieu
        //check null
        if (request.getParameter("account") == null || request.getParameter("account").isEmpty()
                || request.getParameter("password") == null || request.getParameter("password").isEmpty()) {
            String messError = "Bạn chưa nhập đủ thông tin!";
            request.setAttribute("error", messError);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {

            //check login exits or not
            Users check = d.checkLogin(account, password);
//            System.out.println("users trong logincontroller: " + check);

            if (check != null) {
                session.setAttribute("account", check);
                System.out.println("TIme cua session; " + session.getMaxInactiveInterval());
                request.getRequestDispatcher("home").forward(request, response);
            } else {
                String messError = "Tên đăng nhập hoặc mật khẩu không đúng!";
                request.setAttribute("error", messError);
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
          //Lay du lieu
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Users u = new Users(account, password);
        HttpSession session = request.getSession();
        DAO d = new DAO();

        //Xu li du lieu
        //check null
        if (request.getParameter("account") == null || request.getParameter("account").isEmpty()
                || request.getParameter("password") == null || request.getParameter("password").isEmpty()) {
            String messError = "Bạn chưa nhập đủ thông tin!";
            request.setAttribute("error", messError);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {

            //check login exits or not
            Users check = d.checkLogin(account, password);
//            System.out.println("users trong logincontroller: " + check);

            if (check != null) {
                session.setAttribute("account", check);
                response.sendRedirect("home");
                System.out.println("TIme cua session; " + session.getMaxInactiveInterval());
                //request.getRequestDispatcher("home").forward(request, response);
            } else {
                String messError = "Tên đăng nhập hoặc mật khẩu không đúng!";
                request.setAttribute("error", messError);
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
