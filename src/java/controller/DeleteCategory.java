/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 *
 * @author NCC
 */
@WebServlet(name = "DeleteCategory", urlPatterns = {"/DeleteCategory"})
public class DeleteCategory extends HttpServlet {
Logger logger = Logger.getLogger(getClass().getName());
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("acc") != null) {
             String cId = request.getParameter("cId");
            CategoryDBContext categoryDBContext = new CategoryDBContext();
            try {
                categoryDBContext.deleteCategory(Integer.parseInt(cId));
            } catch (Exception e) {
                logger.info("ID incorrect format");
            }
            response.sendRedirect("managerCategory");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
