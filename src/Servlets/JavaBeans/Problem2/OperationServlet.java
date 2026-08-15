package Servlets.JavaBeans.Problem2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OperationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");

        int value = Integer.parseInt(operation);

        if (value < 10) {
            response.sendRedirect("page1.jsp");
        } 
        else if (value >= 10 && value <= 99) {
            response.sendRedirect("page2.jsp");
        } 
        else {
            response.sendRedirect("error.jsp");
        }
    }
}